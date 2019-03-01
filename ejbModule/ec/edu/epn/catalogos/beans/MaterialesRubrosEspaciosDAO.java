package ec.edu.epn.catalogos.beans;

import javax.ejb.Local;

import ec.edu.epn.catalogos.entities.MaterialesRubrosEspacio;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface MaterialesRubrosEspaciosDAO extends
		DaoGenerico<MaterialesRubrosEspacio> {

	int consultarID();
}
