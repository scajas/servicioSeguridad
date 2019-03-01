package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.EstadoAlquiler;

@Stateless
public class EstadoAlquilerDAOImplement extends
		DaoGenericoImplement<EstadoAlquiler> implements EstadoAlquilerDAO {

	@Override
	public int consultarId() {
		Query q = getEntityManager()
				.createQuery(
						"SELECT MAX(ealquiler.idEalquiler) FROM EstadoAlquiler ealquiler");

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
	public List<EstadoAlquiler> listarEAlquiler() {
		StringBuilder queryString = new StringBuilder(
				"SELECT ealq FROM EstadoAlquiler ealq");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}

	@Override
	public List<EstadoAlquiler> buscarEAlquiler(int ealquiler) {
		StringBuilder queryString = new StringBuilder(
				"SELECT ealq FROM EstadoAlquiler ealq where ealq.idEalquiler=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, ealquiler);

		return query.getResultList();
	}

	@Override
	public List<EstadoAlquiler> buscarEAlquilerXNombre(String ealquiler) {
		// 26/10/2014 lower minusculas//
		StringBuilder queryString = new StringBuilder(
				"SELECT ealq FROM EstadoAlquiler ealq where lower(ealq.estadoAlquiler) like?1 or ealq.estadoAlquiler like?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + ealquiler + "%");

		return query.getResultList();
	}

}
