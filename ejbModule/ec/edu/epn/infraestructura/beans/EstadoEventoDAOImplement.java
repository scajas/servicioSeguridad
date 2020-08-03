package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.EstadoEvento;

@Stateless
public class EstadoEventoDAOImplement extends
		DaoGenericoImplement<EstadoEvento> implements EstadoEventoDAO {

	@Override
	public int consultarId() {

		Query q = getEntityManager().createQuery(
				"SELECT MAX(eevento.idEvento) FROM EstadoEvento eevento");

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
	public List<EstadoEvento> listarEEvento() {
		StringBuilder queryString = new StringBuilder(
				"SELECT eevento FROM EstadoEvento eevento");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}

	@Override
	public List<EstadoEvento> buscarEstadoEvento(int eevento) {
		StringBuilder queryString = new StringBuilder(
				"SELECT eevento FROM EstadoEvento eevento where eevento.idEvento=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, eevento);

		return query.getResultList();
	}

	@Override
	public List<EstadoEvento> buscarEstadoEventoXNombre(String eevento) {
		StringBuilder queryString = new StringBuilder(
				"SELECT eevento FROM EstadoEvento eevento where eevento.estadoEvento like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + eevento + "%");

		return query.getResultList();
	}

	@Override
	public List<EstadoEvento> listarEEventoReserva() {
		StringBuilder queryString = new StringBuilder(
				"SELECT eevento FROM EstadoEvento eevento where eevento.idEvento in (3,4)");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}
}
