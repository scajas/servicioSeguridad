package ec.edu.epn.proyectos.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.sql.DataSource;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;

import ec.edu.epn.proyectos.entities.Objetivoavance;

/**
 * Session Bean implementation class ObjetivoAvanceDAOImplement
 */
@Stateless
@LocalBean
public class ObjetivoAvanceDAOImplement extends DaoGenericoImplement<Objetivoavance> implements ObjetivoAvanceDAO {

	@Override
	public List<Objetivoavance> findAvanceByObjetivo(Integer idobjetivo, String tipo) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From Objetivoavance e where e.objetivo.idObjproy = ?1 and e.tipo = ?2 order by e.id");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idobjetivo);
		query.setParameter(2, tipo);

		return query.getResultList();

	}

	@Override
	public List<Objetivoavance> findAvanceByObjetivoExiste(Integer idobjetivo, Integer idpensum, String tipo) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From Objetivoavance e where e.objetivo.idObjproy = ?1   and e.idpensum = ?2 and e.tipo = ?3   order by e.id");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idobjetivo);
		query.setParameter(2, idpensum);
		query.setParameter(3, tipo);

		return query.getResultList();

	}

	@Override
	public List<Objetivoavance> findAvanceByObjetivoProyecto(Integer idobjetivo, String tipo, Integer idpensum) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From Objetivoavance e where e.objetivo.proyecto.idProy = ?1 and e.tipo = ?2  and e.idpensum  = ?3 order by e.id");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idobjetivo);
		query.setParameter(2, tipo);
		query.setParameter(3, idpensum);

		return query.getResultList();

	}

	@Override
	public Double consultarMaximoReportado(Integer idproyecto, String tipo) {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(pen.avance) FROM Objetivoavance pen where pen.objetivo.idObjproy = ?1 and pen.tipo = ?2 ");

		q.setParameter(1, idproyecto);
		q.setParameter(2, tipo);
		Double idReq = null;
		try {
			idReq = (Double) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 0.00;

		}
		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public Objetivoavance findAvanceByObjetivoProyectoAnterior(Integer idobjetivo, String tipo, Integer idpensum) {

		try {

			StringBuilder querys = new StringBuilder(
					"SELECT e From Objetivoavance e where e.objetivo.idObjproy = ?1 and e.tipo = ?2  and e.idpensum  = ?3 order by e.id");

			Query query = getEntityManager().createQuery(querys.toString());
			query.setParameter(1, idobjetivo);
			query.setParameter(2, tipo);
			query.setParameter(3, idpensum);

			return (Objetivoavance) query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@Resource(mappedName = "java:jboss/datasources/SeguridadEPNDS")
	private DataSource dataSource;

	@Override
	public boolean deleteObjJDBC(Objetivoavance tfa) {
		System.out.println("***********TFA DELETE************");
		Connection con = null;
		PreparedStatement ps = null;

		System.out.println("Id a eliminar" + tfa.getId());

		try {
			con = dataSource.getConnection();

			if (con != null) {

				ps = con.prepareStatement("DELETE FROM \"Proyectos\".objetivoavance  " + "where id=?");
				ps.setInt(1, tfa.getId());

				ps.executeUpdate();
				return true;

			} else {

				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();

			return false;

		} finally {
			super.cerrarConexion(con, ps);
		}
	}
	
	
	@Override
	public Long countObjtvAvanceXidObjProy(Integer idObjetivoProyecto) {
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(oa) FROM  Objetivoavance oa WHERE oa.objetivo.idObjproy= ? ");
			
		q.setParameter(1, idObjetivoProyecto);		
		return (Long) q.getSingleResult();
	}

}
