package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Detallemetodo;
import ec.edu.epn.laboratorioBJ.entities.Existencia;
import ec.edu.epn.laboratorioBJ.entities.Movimientosinventario;
import ec.edu.epn.laboratorioBJ.entities.UnidadLabo;

/**
 * Session Bean implementation class DetalleMetodoDAOImplement
 */
@Stateless
@LocalBean
public class DetalleMetodoDAOImplement extends DaoGenericoImplement<Detallemetodo> implements DetalleMetodoDAO {

	/**
	 * Default constructor.
	 */
	public DetalleMetodoDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Existencia> listaExistencias(int id) {

		StringBuilder queryString = new StringBuilder(
				"SELECT e FROM Existencia e where e.idUnidad = ?1 ORDER BY e.producto.nombrePr ASC ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<Existencia> resultados = query.getResultList();
		return resultados;

	}

	@Override
	public Existencia buscarExistencias(String id) {

		StringBuilder querys = new StringBuilder("SELECT e FROM Existencia e where e.idExistencia = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, id);
		query.setMaxResults(1); // fsaf

		try {
			Existencia existencia = (Existencia) query.getSingleResult();
			return existencia;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public List<Detallemetodo> listaDetallesById(String id) {

		System.out.println("ID que pasa" + id);

		StringBuilder queryString = new StringBuilder("SELECT d FROM Detallemetodo d WHERE d.metodo.idMetodo = ?1  ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<Detallemetodo> resultados = query.getResultList();
		System.out.println("Resultados Obtenidos" + resultados.size());

		return resultados;

	}

}
