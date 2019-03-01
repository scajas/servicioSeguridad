package ec.edu.epn.infraestructura.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.Sesione;

@Local
public interface SesionesDAO extends DaoGenerico<Sesione> {

	int consultarId();

}
