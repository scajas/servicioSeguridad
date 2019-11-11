package ec.edu.epn.silabo.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.NombTemp;
import ec.edu.epn.silabo.dto.BibliografiaSilaboDTO;
import ec.edu.epn.silabo.entities.Silabo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * Session Bean implementation class SilaboDAOImplement
 */
@Stateless
@LocalBean
public class SilaboDAOImplement extends DaoGenericoImplement<Silabo> implements SilaboDAO {

	@Resource(mappedName = "java:jboss/datasources/SeguridadEPNDS")
	private DataSource dataSource;

	@Override
	public Silabo consultarSilabo(String nced, String codigo, Integer idPensum, String paralelo, String codcarrera) {

		StringBuilder querys = new StringBuilder("SELECT e From Silabo e where e.cedula = ?1 ");

		if (codigo != null) {

			querys.append(" and e.codigo = ?2 ");
		}

		if (idPensum != 0) {

			querys.append(" and e.idPensum = ?3  ");
		}

		if (paralelo != null) {

			querys.append(" and e.paralelo = ?4 ");
		}

		if (codcarrera != null) {

			querys.append(" and e.codcarrera = ?5 ");
		}

		querys.append("  order by e.idSilabo  ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, nced);

		if (codigo != null) {

			query.setParameter(2, codigo);
		}

		if (idPensum != 0) {

			query.setParameter(3, idPensum);
		}

		if (paralelo != null) {

			query.setParameter(4, paralelo);
		}
		if (codcarrera != null) {

			query.setParameter(5, codcarrera);
		}

		query.setMaxResults(1);

		try {
			Silabo sib = (Silabo) query.getSingleResult();
			return sib;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public int maxsilabo() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idSilabo) FROM Silabo p");
		Integer idPagosV = null;

		try {
			idPagosV = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idPagosV = null;
		}
		if (idPagosV == null) {
			idPagosV = 1;
		} else {
			++idPagosV;
		}
		return idPagosV;
	}

	@Override
	public List<Silabo> consultarSilaboMateria(String nced, String codigo) {

		StringBuilder querys = new StringBuilder("SELECT e From Silabo e where e.cedula = ?1 and e.codigo like ?2  ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, nced);
		query.setParameter(2, "%"+codigo+"%");

		return query.getResultList();

	}

	@Override
	public List<Silabo> listConsultarSilabo(String nced, String codigo, Integer idPensum, String paralelo,
			String codcarrera) {

		StringBuilder querys = new StringBuilder("SELECT e From Silabo e where e.cedula = ?1 ");

		if (codigo != null) {
			querys.append(" and e.codigo = ?2 ");
		}

		if (idPensum != 0) {
			querys.append(" and e.idPensum = ?3  ");
		}

		if (paralelo != null) {
			querys.append(" and e.paralelo = ?4 ");
		}

		if (codcarrera != null) {
			querys.append(" and e.codcarrera = ?5 ");
		}

		querys.append("  order by e.idSilabo  ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, nced);

		if (codigo != null) {
			query.setParameter(2, codigo);
		}

		if (idPensum != 0) {
			query.setParameter(3, idPensum);
		}

		if (paralelo != null) {
			query.setParameter(4, paralelo);
		}
		if (codcarrera != null) {
			query.setParameter(5, codcarrera);
		}

		try {
			return query.getResultList();

		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Silabo> listConsultaFacultad() {
		StringBuilder querys = new StringBuilder("SELECT DISTINCT s.facultad From Silabo s ");

		Query query = getEntityManager().createQuery(querys.toString());

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Silabo> listConsultaCarreraXFacultad(String facultad) {
		StringBuilder querys = new StringBuilder("SELECT DISTINCT s.carrera From Silabo s where s.facultad = ?1");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, facultad);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Silabo> listConsultaMateriaXFacultad(String facultad) {
		StringBuilder querys = new StringBuilder(
				"SELECT DISTINCT s.asignatura From Silabo s where s.facultad = ?1 order by s.asignatura");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, facultad);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Silabo> listConsultaMateriaXCarrera(String codcarrera) {
		StringBuilder querys = new StringBuilder(
				"SELECT DISTINCT s.asignatura From Silabo s where s.carrera = ?1 order by s.asignatura");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, codcarrera);

		return query.getResultList();
	}

	@Override
	public ArrayList<BibliografiaSilaboDTO> findBibliog(String facultad, String carrera, int idPensum, String materia)
			throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			if (con != null) {

				String qry3 = null;
				
				
				String qry = "select s.id_silabo, e.nced, CONCAT(COALESCE(apel, ' '), ' ', COALESCE(nom, ' ') )as nombres, p.meses_pensem, facultad, carrera, asignatura, titulo, autor, editorial, ano, edicion, isbn, "
						+ " (case when tipob = '1' then 'Básica' when tipob = '2' then 'Complementaria' else '' end) as tipo, codigo, id_bibliografia "
						+ " from  \"Silabo\".silabo s, \"Rrhh\".emp e, \"Silabo\".bibliografia b, \"Contratos\".pensum p "
						+ " where e.nced = s.cedula " + " and s.id_silabo = b.id_silabo "
						+ " and s.id_pensum = p.id_pensum " + " and facultad like ? "
						+ " and carrera like ? and trim(asignatura) like ?  ";

				if (idPensum != 0) {

					qry = qry + "  and s.id_pensum = ? ";

				}

				qry = qry + "  ORDER BY nombres  ";

				ps = con.prepareStatement(qry);
				ps.setString(1, facultad);
				ps.setString(2, carrera);
				ps.setString(3, materia);

				if (idPensum != 0) {
					ps.setInt(4, idPensum);
				}

				ResultSet rs = ps.executeQuery();
				ArrayList<BibliografiaSilaboDTO> listaReporte = new ArrayList<BibliografiaSilaboDTO>();
				while (rs.next()) {

					BibliografiaSilaboDTO dto = new BibliografiaSilaboDTO();
					dto.setIdSilabo(rs.getInt(1));
					dto.setCedula(rs.getString(2));
					dto.setNombres(rs.getString(3));
					dto.setPensum(rs.getString(4));
					dto.setFacultad(rs.getString(5));
					dto.setCarrera(rs.getString(6));
					dto.setAsignatura(rs.getString(7));
					dto.setTitulo(rs.getString(8));
					dto.setAutor(rs.getString(9));
					dto.setEditorial(rs.getString(10));
					dto.setAno(rs.getString(11));
					dto.setEdicion(rs.getString(12));
					dto.setIsbn(rs.getString(13));
					dto.setTipoB(rs.getString(14));
					dto.setCodmat(rs.getString(15));
					dto.setIdbibliografia(rs.getInt(16));

					listaReporte.add(dto);

				}

				ps.close();
				con.close();

				return listaReporte;
			}

			else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			ps.close();
			con.close();
		}
	}
	
	
	@Override
	public List<Silabo> consultarSilaboPensum(Integer idpensum) {

		StringBuilder querys = new StringBuilder("SELECT e From Silabo e where e.idPensum = ?1 ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idpensum);
		

		return query.getResultList();

	}
	
	@Override
	public List<Silabo> consultarSilaboPensumByEMp(Integer idpensum,String nced) {

		StringBuilder querys = new StringBuilder("SELECT e From Silabo e where e.idPensum = ?1 and e.cedula = ?2 ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idpensum);
		query.setParameter(2, nced);
		

		return query.getResultList();

	}

}
