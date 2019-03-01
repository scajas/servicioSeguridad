/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.Alquiler;

/**
 * @author Administrador
 * 
 */
@Stateless
public class AlquilerDAOImplement extends DaoGenericoImplement<Alquiler>
		implements AlquilerDAO {

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(alq.idAlquiler)FROM Alquiler alq");
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
	public List<Alquiler> listarAlquiler() {
		StringBuilder queryString = new StringBuilder(
				"SELECT alq FROM Alquiler alq");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}

	@Override
	public List<Alquiler> buscarAlquiler(int alq) {
		StringBuilder queryString = new StringBuilder(
				"SELECT alq FROM Alquiler alq where alq.idAlquiler=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, alq);

		return query.getResultList();
	}

	@Override
	public List<Alquiler> buscarAlquilerXEvento(String nombreEvento) {
		StringBuilder queryString = new StringBuilder(
				"SELECT alq FROM Alquiler alq where alq.evento.nomEvento=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nombreEvento);

		return query.getResultList();
	}

	@Override
	public List<Alquiler> buscarAlquilerXTipoAlquiler(String nombreTipoAlquiler) {
		StringBuilder queryString = new StringBuilder(
				"SELECT alq FROM Alquiler alq where alq.estadoAlquiler.estadoAlquiler=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nombreTipoAlquiler);

		return query.getResultList();
	}

	@Override
	public List<Alquiler> listaAlquilerSINPago() {
		StringBuilder queryString = new StringBuilder(
				"select alq from Alquiler alq where alq.idAlquiler not IN (select pag.alquiler.idAlquiler from Pago pag)");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}

	@Override
	public boolean buscarEventoAlquilado(int idevento) {
		StringBuilder queryString = new StringBuilder(
				"select alq from Alquiler alq where alq.evento.idEventos = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idevento);
		if (query.getResultList().size() > 0)
			return true;
		else
			return false;

	}

}
