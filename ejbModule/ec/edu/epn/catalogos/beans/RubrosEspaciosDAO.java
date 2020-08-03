package ec.edu.epn.catalogos.beans;

import javax.ejb.Local;

import ec.edu.epn.catalogos.entities.RubrosEspacio;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface RubrosEspaciosDAO extends DaoGenerico<RubrosEspacio> {

	int consultarID();

}
