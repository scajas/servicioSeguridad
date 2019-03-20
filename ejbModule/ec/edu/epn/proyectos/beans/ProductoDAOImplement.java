package ec.edu.epn.proyectos.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Publicacione;
import ec.edu.epn.proyectos.entities.Producto;

/**
 * Session Bean implementation class ProductoDAOImplement
 */
@Stateless
@LocalBean
public class ProductoDAOImplement extends DaoGenericoImplement<Producto> implements ProductoDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findPublicacionesProyecto(Integer idproyecto, String nrotesis) {

		StringBuilder queryString = new StringBuilder("SELECT fam FROM Producto fam where  fam.proyecto.idProy = ?0 ");

		if (nrotesis != null) {
			queryString.append(" and fam.codtesis = ?1 ");
		}

		queryString.append("  order by fam.id");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, idproyecto);

		if (nrotesis != null) {
			query.setParameter(1, nrotesis);
		}
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findPublicacionesProyectoReports(Integer idproyecto, Integer idpensum) {

		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Producto fam where  fam.proyecto.idProy = ?0 and fam.idpensum = ?1 ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, idproyecto);

		query.setParameter(1, idpensum);

		return query.getResultList();

	}

}
