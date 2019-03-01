/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.TipoEvento;

/**
 * @author Administrador
 * 
 */
@Stateless
public class TipoEventoInfraDAOImplement extends DaoGenericoImplement<TipoEvento>
		implements TipoEventoInfraDAO {

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(tevento.idTevento) FROM TipoEvento tevento");

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
	public List<TipoEvento> listarTipoEventor() {
		StringBuilder queryString = new StringBuilder(
				"SELECT tevento FROM TipoEvento tevento");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}

	@Override
	public List<TipoEvento> buscarTEvento(int tevento) {
		StringBuilder queryString = new StringBuilder(
				"SELECT tevento FROM TipoEvento tevento where tevento.idTevento=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, tevento);

		return query.getResultList();
	}

	@Override
	public List<TipoEvento> buscarTEventoXNombre(String tevento) {
		StringBuilder queryString = new StringBuilder(
				"SELECT tevento FROM TipoEvento tevento where tevento.tipoEvento like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + tevento + "%");

		return query.getResultList();
	}

}
