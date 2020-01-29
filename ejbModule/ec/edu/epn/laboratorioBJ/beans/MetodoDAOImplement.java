package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Compra;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.UnidadLabo;

@Stateless
@LocalBean
public class MetodoDAOImplement extends DaoGenericoImplement<Metodo> implements MetodoDAO {

	public MetodoDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Metodo> getListMetodos(String id) {

		StringBuilder queryString = new StringBuilder(
				"SELECT m FROM Metodo m where m.idMetodo like '%" + id + "%' ORDER BY m.servicio.nombreS ASC");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Metodo> resultados = query.getResultList();
		return resultados;
	}

	@Override
	public String maxIdMetodo(int id) {

		StringBuilder queryString = new StringBuilder(
				"SELECT max(m.idMetodo) FROM Metodo m where m.servicio.laboratorio.unidad.idUnidad= ?");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		try {
			String idMetodo = (String) query.getSingleResult();
			return idMetodo;  
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}
	}

	@Override
	public UnidadLabo obtenerUnidad(int id) {
		StringBuilder querys = new StringBuilder("SELECT u FROM UnidadLabo u where u.idUnidad = '" + id + "'");
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
