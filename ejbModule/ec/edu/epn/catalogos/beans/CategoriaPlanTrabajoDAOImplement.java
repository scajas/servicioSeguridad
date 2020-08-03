package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.catalogos.entities.CategoriaPlantrabajo;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class EmpleadosServiceBean
 */
@Stateless
public class CategoriaPlanTrabajoDAOImplement extends
		DaoGenericoImplement<CategoriaPlantrabajo> implements
		CategoriaPlanTrabajoDAO {

	@Override
	public List<CategoriaPlantrabajo> listaCategoriasPlanTrabajoActivas() {
		StringBuilder queryString = new StringBuilder(
				"SELECT cat FROM CategoriaPlantrabajo cat where cat.activoCategoria = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "SI");
		return query.getResultList();
	}

}
