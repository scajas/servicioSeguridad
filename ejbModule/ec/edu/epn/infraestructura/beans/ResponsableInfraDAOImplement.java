package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.ResponsableInfra;

@Stateless
public class ResponsableInfraDAOImplement extends DaoGenericoImplement<ResponsableInfra>
		implements ResponsableInfraDAO {

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(res.idResponsable) FROM Responsable res");

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
	public List<ResponsableInfra> listarResponsable() {
		StringBuilder queryString = new StringBuilder(
				"SELECT resp FROM Responsable resp");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}

	@Override
	public List<ResponsableInfra> buscarResponsable(int resp) {
		StringBuilder queryString = new StringBuilder(
				"SELECT resp FROM Responsable resp where resp.idResponsable=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, resp);

		return query.getResultList();
	}

	@Override
	public List<ResponsableInfra> buscarResponsableXNombre(String nombre) {
		StringBuilder queryString = new StringBuilder(
				"SELECT resp FROM Responsable resp where resp.nombreResp like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + nombre + "%");

		return query.getResultList();
	}

	@Override
	public List<ResponsableInfra> buscarResponsableXApellido(String apellido) {
		StringBuilder queryString = new StringBuilder(
				"SELECT resp FROM Responsable resp where resp.apellidoResp like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + apellido + "%");

		return query.getResultList();
	}

	@Override
	public List<ResponsableInfra> buscarResponsableXCedula(String cedula) {
		StringBuilder queryString = new StringBuilder(
				"SELECT resp FROM Responsable resp where resp.cedulaResp like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula);

		return query.getResultList();
	}

}
