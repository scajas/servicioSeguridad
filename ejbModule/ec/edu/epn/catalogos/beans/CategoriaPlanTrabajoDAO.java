package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.catalogos.entities.CategoriaPlantrabajo;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface CategoriaPlanTrabajoDAO extends
		DaoGenerico<CategoriaPlantrabajo> {

	List<CategoriaPlantrabajo> listaCategoriasPlanTrabajoActivas();

}
