/**
 * 
 */
package ec.edu.epn.rrhh.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.DTO.ContDTO;
import ec.edu.epn.rrhh.entities.Cont;

/**
 * @author Administrador
 * 
 */
@Stateless
public class ContDAOImplement extends DaoGenericoImplement<Cont> implements ContDAO {

	@Override
	public Cont findbyCedula(String cedula) {
		StringBuilder querys = new StringBuilder(
				"SELECT e FROM Cont e where e.emp.nced = ?1 order by e.nroCont des limit 1");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, cedula);
		return (Cont) query.getSingleResult();
	}

	@Override
	public List<Cont> findbyPeriodo(Integer idperiodo) {
		StringBuilder querys = new StringBuilder("SELECT e FROM Cont e  ");

		if (idperiodo == 10000) {
			querys.append("where e.pensum.idPensum = ?0 ");
		}

		querys.append("order by e.emp.apel");

		Query query = getEntityManager().createQuery(querys.toString());

		if (idperiodo == 10000) {
			query.setParameter(1, idperiodo);
		}

		return query.getResultList();
	}

	@Override
	public Cont findContratobyCedula(String cedula) {
		StringBuilder querys = new StringBuilder("SELECT e FROM Cont e where e.emp.nced = ?1 order by e.nroCont desc ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, cedula);
		query.setMaxResults(1);

		try {
			Cont cont = (Cont) query.getSingleResult();
			return cont;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public List<Cont> findContratosHisotiral2012(String cedula) {
		StringBuilder querys = new StringBuilder(
				"SELECT e FROM Cont e where e.emp.nced = ?1 and extract(year from e.frigeCont)>=?2 order by e.frigeCont DESC ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, cedula);
		query.setParameter(2, 2012);

		return query.getResultList();
	}

	@Override
	public List<Cont> findContratosHisotiral(String cedula) {
		StringBuilder querys = new StringBuilder(
				"SELECT e FROM Cont e where e.emp.nced = ?1 order by e.frigeCont DESC ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, cedula);

		return query.getResultList();
	}

	@Override
	public Cont findContID(String idnom) {

		Query q = getEntityManager().createQuery(" Select nom from Cont  nom where nom.nroCont = ?1 ");
		q.setParameter(1, idnom);

		return (Cont) q.getSingleResult();

	}

	@Override
	public void updatecONTRATO(String idnom, String path) {

		Query q = getEntityManager().createQuery("UPDATE Cont SET path = ?1 where nroCont = ?2 ");
		q.setParameter(2, idnom);
		q.setParameter(1, path);

		q.executeUpdate();

	}

	@Override
	public Long countContPeriodo(String nCont) throws Exception {
		Query q = getEntityManager().createQuery("SELECT count(c) FROM Cont c WHERE c.nroCont = ?1 ");
		q.setParameter(1, nCont);
		return (Long) q.getSingleResult();
	}

	/**
	 * lista las entidades contratos por la cedula y por el id del pensum que se
	 * requiera JDBC
	 * 
	 * @param cedula
	 *            - string del numero de cedula a buscar
	 * @param idPensum
	 *            - integer del id del pensum que se requiere
	 * @return Lista de contratos por los parametros enviados
	 * @throws NoResultException
	 *             - Excepcion lanzada cuando no se encuentra la entidad
	 * @throws Exception
	 *             - Excepcion general
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Cont> listarContratosXcedulaXidPensum(String cedula, Integer idPensum)
			throws NoResultException, Exception {

		List<Cont> retorno = null;
		try {
			StringBuilder stQuery = new StringBuilder();
			stQuery.append(" SELECT cnt FROM Cont cnt where cnt.emp.nced = :cedula ");
			if (!idPensum.equals(Integer.valueOf("-99"))) {
				stQuery.append(" AND cnt.pensum.idPensum = :idPensum ");
			}
			stQuery.append(" order by cnt.nroCont ");
			Query q = getEntityManager().createQuery(stQuery.toString());
			if (!idPensum.equals(Integer.valueOf("-99"))) {
				q.setParameter("idPensum", idPensum);
			}
			q.setParameter("cedula", cedula);
			retorno = q.getResultList();
		} catch (NoResultException e) {
			throw new NoResultException("No se encontró los contratos para el docente y el período buscado");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al buscar los contratos");
		}
		return retorno;

	}

	/**
	 * lista las entidades nombramientos por la cedula y por el id del pensum
	 * que se requiera JDBC
	 * 
	 * @param cedula
	 *            - string del numero de cedula a buscar
	 * @param idPensum
	 *            - integer del id del pensum que se requiere
	 * @return Lista de nombramientos por los parametros enviados
	 * @throws SQLException
	 *             - Excepcion lanzada cuando no se encuentra la entidad
	 * @throws Exception
	 *             - Excepcion general
	 */
	@Override
	public List<ContDTO> listarContratosXcedulaXidPensumJdbc(String cedula, Integer idPensum)
			throws SQLException, Exception {
		List<ContDTO> retorno = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			StringBuilder sbSql = new StringBuilder();
			sbSql.append(" SELECT ");
			sbSql.append(" cont.");
			sbSql.append("nro_cont ");
			sbSql.append(" ,cont.");
			sbSql.append("nced ");
			sbSql.append(" ,cont.");
			sbSql.append("id_pensum ");
			sbSql.append(" ,cont.");
			sbSql.append("path ");
			sbSql.append(" FROM ");
			sbSql.append(" \"Rrhh\".cont ");
			sbSql.append(" cont ");
			sbSql.append(" WHERE ");
			sbSql.append(" cont.");
			sbSql.append("nced ");
			sbSql.append(" = ?");
			if (!idPensum.equals(Integer.valueOf("-99"))) {
				sbSql.append(" AND ");
				sbSql.append(" cont.");
				sbSql.append("id_pensum ");
				sbSql.append(" = ?");
			}

			con = getDataSource().getConnection();
			pstmt = con.prepareStatement(sbSql.toString());
			pstmt.setString(1, cedula);
			if (!idPensum.equals(Integer.valueOf("-99"))) {
				pstmt.setInt(2, idPensum);
			}
			System.out.println(sbSql.toString());
			rs = pstmt.executeQuery();
			retorno = new ArrayList<ContDTO>();
			while (rs.next()) {
				retorno.add(transformarResultSetAdto(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Error al generar la consulta : (SQL) ");
		} catch (Exception e) {
			throw new Exception("Error inesperado, vuelva a intentarlo");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
			}
		}
		return retorno;
	}

	/*
	 * *************************************************************************
	 * ******** * ************************** METODOS DE TRANSFORMACION
	 * **************************** *
	 * *************************************************************************
	 * ********
	 */

	/**
	 * Método privado que sirve para trasformar los datos del resulset a
	 * EntidadDto
	 * 
	 * @param rs
	 *            - rs parámetros de ingreso
	 * @return retorna el DTO seteado con los datos correctos
	 * @throws SQLException
	 *             - SQLException Excepción de error en la consulta sql
	 */

	private ContDTO transformarResultSetAdto(ResultSet rs) throws SQLException {
		ContDTO retorno = new ContDTO();
		retorno.setNroCont(rs.getString("nro_cont"));
		retorno.setNced(rs.getString("nced"));
		retorno.setPensum(rs.getInt("id_pensum"));
		retorno.setPath(rs.getString("path"));
		return retorno;
	}

	@Override
	public ArrayList<ContDTO> consultaContratosPeriodo(Integer idperiodo, String idtipoCon) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = super.getDataSource().getConnection();
			if (con != null) {

				String qry = "  select e.nced, e.apel, e.nom, d.nom_dep, c.nro_cont, to_char(c.frige_cont,'yyyy-MM-dd'),to_char(c.ffin_cont,'yyyy-MM-dd'), t.desc_tcont  "
						+ " from  \"Rrhh\".cont c , \"Rrhh\".emp e, \"Rrhh\".dep d, \"Contratos\".pensum p, \"Rrhh\".tcont t "
						+ " where c.nced = e.nced   and p.id_pensum = c.id_pensum and d.cod_dep = e.cod_dep and trim(t.tcont) = trim(c.tcont) and trim(t.tcont) like ? and trim(e.cod_clase) in ('1','4','5') ";

				if (idperiodo == 10000) {

				}

				else {
					qry = qry + " and p.id_pensum = ? ";

				}

				
				
//				String query = "select * from people where (first_name = :name or last_name = :name) and address = :address");
//						NamedParameterStatement p = new NamedParameterStatement(con, query);
//						p.setString("name", name);
//						p.setString("address", address);
				
				qry = qry + "order by d.nom_dep, e.apel, e.nom  ";
				System.out.println("Consulta" + qry);
				
				ps = con.prepareStatement(qry);

				ps.setString(1, idtipoCon.trim());
				
				if (idperiodo == 10000) {

				}

				else {
					ps.setInt(2, idperiodo);
				}
				
				
				
				

				ResultSet rs = ps.executeQuery();

				ArrayList<ContDTO> listaDocenteCI = new ArrayList<ContDTO>();

				while (rs.next()) {

					ContDTO cont = new ContDTO();
					
					cont.setNced(rs.getString(1));
					cont.setAlala(rs.getString(2));
					cont.setAdvertidoa(rs.getString(3));
					cont.setAlla(rs.getString(4));
					cont.setNroCont(rs.getString(5));
					cont.setFac1(rs.getString(6));
					cont.setFac2(rs.getString(7));
					cont.setBasel(rs.getString(8));
					listaDocenteCI.add(cont);

				}
				

				ps.close();
				con.close();

				return listaDocenteCI;
			}

			else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			super.cerrarConexion(con, ps);
		}
	}

}
