package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;

import ec.edu.epn.laboratorioBJ.entities.Detallemetodo;
import ec.edu.epn.laboratorioBJ.entities.Existencia;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.Movimientosinventario;
import ec.edu.epn.laboratorioBJ.entities.Ordeninventario;
import ec.edu.epn.laboratorioBJ.entities.UnidadLabo;

/**
 * Session Bean implementation class OrdenInventarioDAOImplement
 */
@Stateless
@LocalBean
public class OrdenInventarioDAOImplement extends DaoGenericoImplement<Ordeninventario> implements OrdenInventarioDAO {

	/**
	 * Default constructor.
	 */
	public OrdenInventarioDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Detallemetodo> listaDetalleMetodo(String id) {
		StringBuilder queryString = new StringBuilder("SELECT d FROM Detallemetodo d where id_metodo = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<Detallemetodo> resultados = query.getResultList();
		return resultados;
	}

	@Override
	public List<Existencia> listaExistencia(String id) {
		StringBuilder queryString = new StringBuilder("SELECT e FROM Existencia e where id_unidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<Existencia> resultados = query.getResultList();
		return resultados;
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
	public Existencia findExistenciaById(String id) {
		StringBuilder querys = new StringBuilder("SELECT e FROM Existencia e where e.idExistencia = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, id);
		query.setMaxResults(1);

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
	public List<Ordeninventario> getListOI(Integer idUsuario, Integer idUnidad) {

		StringBuilder consulta = new StringBuilder();

		consulta.append("SELECT DISTINCT (o) from Ordeninventario o, Existencia e, BodegaUsuario b"
				+ " where o.unidad.idUnidad = e.unidad.idUnidad and e.bodega.idBodega = b.bodega.idBodega "
				+ " and b.id.idUsuario = ?0 and  o.unidad.idUnidad = ?1 order by o.idOrdeninventario desc  ");

		Query q = super.getEntityManager().createQuery(consulta.toString());
		q.setParameter(0, idUsuario);
		q.setParameter(1, idUnidad);

		return q.getResultList();
	}

	@Override
	public List<Movimientosinventario> listaMovimientoI(String id) {
		StringBuilder queryString = new StringBuilder(
				"SELECT m FROM Movimientosinventario m where m.ordeninventario.idOrdeninventario = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<Movimientosinventario> resultados = query.getResultList();
		return resultados;
		
	}

	@Override
	public List<Ordeninventario> listaOI(int id) {
		StringBuilder queryString = new StringBuilder("SELECT o FROM Ordeninventario o where id_unidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<Ordeninventario> resultados = query.getResultList();
		return resultados;
	}

	@Override
	public List<Ordeninventario> getListOIById(String id) {

		System.out.println("idUnidad: " + id);
		StringBuilder queryString = new StringBuilder(
				"SELECT o FROM Ordeninventario o where o.idOrdeninventario like '%" + id + "%'");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Ordeninventario> resultados = query.getResultList();
		return resultados;
	}
	
	@Override
	public List<Ordeninventario> getListOTById(String id) {

		System.out.println("idUnidad: " + id);
		StringBuilder queryString = new StringBuilder(
				"SELECT o FROM Ordeninventario o where o.detalleorden.ordenTrabajo.idOrden like '%" + id + "%' order by idOrdeninventario");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Ordeninventario> resultados = query.getResultList();
		return resultados;
	}

	@Override
	public String maxIdOrdenI(int id, String fecha) {
		String[] parts = fecha.split("-");

		String anio = parts[0];
		System.out.println("Este es el anio: " + anio);

		StringBuilder queryString = new StringBuilder(
				"SELECT max(o.idOrdeninventario) FROM Ordeninventario o where o.unidad.idUnidad = ?"
						+ "AND o.idOrdeninventario like '%"+anio+"%'");
		// new StringBuilder("SELECT b FROM Servicio b where id_Unidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		try {
			String idOrdeninventario = (String) query.getSingleResult();
			return idOrdeninventario;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}
	}
	
	@Override
	public UnidadLabo obtenerUnidad(int id) {
		StringBuilder querys = new StringBuilder("SELECT u FROM UnidadLabo u where u.idUnidad = '"+id+"'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			UnidadLabo unidadLabo = (UnidadLabo) query.getSingleResult();
			return unidadLabo;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

}
