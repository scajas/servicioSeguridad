package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Bodega;
import ec.edu.epn.laboratorioBJ.entities.Existencia;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.Movimientosinventario;
import ec.edu.epn.laboratorioBJ.entities.ProductoLab;
import ec.edu.epn.laboratorioBJ.entities.SaldoExistencia;

/**
 * Session Bean implementation class ExistenciasDAOImplement
 */
@Stateless
@LocalBean
public class ExistenciasDAOImplement extends DaoGenericoImplement<Existencia> implements ExistenciasDAO {

	/**
	 * Default constructor.
	 */
	public ExistenciasDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SaldoExistencia findSaldoById(String id) {
		StringBuilder querys = new StringBuilder("SELECT s FROM SaldoExistencia s where id_existencia = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, id);
		query.setMaxResults(1);

		try {
			SaldoExistencia metodo = (SaldoExistencia) query.getSingleResult();
			return metodo;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public List<ProductoLab> filtrarLista(String dato) {
		// Busqueda por nombre

		dato = dato.toUpperCase();

		StringBuilder queryString = new StringBuilder(
				"SELECT d FROM ProductoLab d where nombre_pr like '%" + dato + "%'");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<ProductoLab> resultados = query.getResultList();
		return resultados;

	}

	@Override
	public String maxIdServ(int id) {
		StringBuilder queryString = new StringBuilder(
				"SELECT max(e.idExistencia) FROM Existencia e where idUnidad = ?1 ");
		// new StringBuilder("SELECT b FROM Servicio b where id_Unidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		String idExistencia = (String) query.getSingleResult();
		return idExistencia;
	}

	@Override
	public List<Movimientosinventario> listarMovimientoById(String idExistencia) {

		System.out.println("COSAS DE LA VIDA: " + idExistencia);
		StringBuilder queryString = new StringBuilder(
				"SELECT m FROM Movimientosinventario m where m.idExistencia = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idExistencia);

		List<Movimientosinventario> resultados = query.getResultList();
		return resultados;

	}
	
	@Override
	public List<Existencia> listarExistenciaById(int id) {

		System.out.println("idUnidad: " + id);
		StringBuilder queryString = new StringBuilder(
				"SELECT e FROM Existencia e where e.idUnidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<Existencia> resultados = query.getResultList();
		return resultados;

	}

}
