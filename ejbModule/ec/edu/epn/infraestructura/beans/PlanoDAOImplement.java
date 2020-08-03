package ec.edu.epn.infraestructura.beans;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.sql.DataSource;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.EdificioInfra;
import ec.edu.epn.infraestructura.entities.PisoInfra;
import ec.edu.epn.infraestructura.entities.Plano;

@Stateless
public class PlanoDAOImplement extends DaoGenericoImplement<Plano> implements
		PlanoDAO {

	@Resource(mappedName = "java:jboss/datasources/SeguridadEPNDS")
	DataSource ds;

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(pln.idPlano) FROM Plano pln");
		Integer idReq = null;
		try {
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		return idReq;

	}

	@Override
	public List<Plano> listarPlanos() {
		StringBuilder queryString = new StringBuilder(
				"SELECT pln FROM Plano pln");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}

	@Override
	public List<Plano> buscarPlanos(int plano) {
		StringBuilder queryString = new StringBuilder(
				"SELECT pln FROM Plano pln where pln.idPlano=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, plano);

		return query.getResultList();
	}

	@Override
	public List<Plano> buscarPlanoXNombre(String nombrePlano) {
		StringBuilder queryString = new StringBuilder(
				"SELECT pln FROM Plano pln where pln.nombrePlano like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + nombrePlano + "%");

		return query.getResultList();
	}

	@Override
	public List<Plano> buscarPlanoXEstado(String estadoPlano) {
		StringBuilder queryString = new StringBuilder(
				"SELECT pln FROM Plano pln where pln.estado like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + estadoPlano + "%");

		return query.getResultList();
	}

	// Aqui se debe tomar el Lugar_Espacio y llegar ahsta el plano por medio de
	// lso id
	@Override
	public List<Plano> buscarPlanoXEdificio(EdificioInfra nombreEdificio) {
		// 19.10.2014 busqueda anterior no trae resultados, se mejora el select.
		StringBuilder queryString = new StringBuilder(
				"SELECT le.plano FROM Piso le where le.edificio.nomEdificio like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + nombreEdificio.getNomEdificio() + "%");

		return (List<Plano>) query.getResultList();
	}

	// Aqui s etoam el piso de donde se encuentra el plano y s elo sustrae
	@Override
	public List<Plano> buscarPlanoXPiso(PisoInfra piso) {
		StringBuilder queryString = new StringBuilder(
				"SELECT p.plano FROM Piso p where p.nomPiso like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + piso.getNomPiso() + "%");

		return (List<Plano>) query.getResultList();
	}

	@Override
	public List<PisoInfra> buscarPlanoXPiso(Plano plano) {
		StringBuilder queryString = new StringBuilder(
				"SELECT le FROM Piso le where le.plano.nombrePlano = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, plano.getNombrePlano());

		return query.getResultList();
	}

	@Override
	public boolean ingresarImagen(String pathImagen, int id_docente) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ds.getConnection();
			if (con != null) {
				File f = new File(pathImagen);
				FileInputStream s = new FileInputStream(f);
				ps = con.prepareStatement("UPDATE \"Infraestructura\".planos set plano=? WHERE id_plano=?");
				ps.setBinaryStream(1, s, (int) f.length());
				ps.setInt(2, id_docente);
				ps.executeUpdate();
				ps.close();
				s.close();
				con.close();
				return true;
			} else {

				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public byte[] obtenerImagen(int id_docente) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		byte[] i = null;
		try {
			con = ds.getConnection();
			if (con != null) {
				ps = con.prepareStatement("select plano from \"Infraestructura\".planos WHERE id_plano=?");
				ps.setInt(1, id_docente);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					i = null;
					i = rs.getBytes("plano");
				}
				rs.close();
				ps.close();

				return i;
			} else {

				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		} finally {
			ps.close();
			con.close();
		}
	}

}
