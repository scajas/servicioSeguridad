package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Detalleorden;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.Muestra;
import ec.edu.epn.laboratorioBJ.entities.Servicio;

/**
 * Session Bean implementation class DetalleOrdenDAOImplement
 */
@Stateless
@LocalBean
public class DetalleOrdenDAOImplement extends DaoGenericoImplement<Detalleorden> implements DetalleOrdenDAO {

	/**
	 * Default constructor.
	 */
	public DetalleOrdenDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Metodo findMetodoById(String id) {
		StringBuilder querys = new StringBuilder("SELECT e FROM Metodo e where e.idMetodo = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, id);
		query.setMaxResults(1);

		try {
			Metodo metodo = (Metodo) query.getSingleResult();
			return metodo;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Servicio findServicioById(String id) {
		StringBuilder querys = new StringBuilder("SELECT e FROM Servicio e where e.idServicio = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, id);
		query.setMaxResults(1);

		try {
			Servicio servicio = (Servicio) query.getSingleResult();
			return servicio;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public List<Detalleorden> listTAbyId(String id) {

		System.out.println("idUnidad: " + id);
		StringBuilder queryString = new StringBuilder("SELECT d FROM Detalleorden d "
				+ "WHERE d.ordenTrabajo.idOrden like '%" + id + "%' ORDER BY d.ordenTrabajo.idOrden ASC");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Detalleorden> resultados = query.getResultList();
		System.out.println("Resultados Obtenidos" + resultados.size());
		return resultados;
	}

}
