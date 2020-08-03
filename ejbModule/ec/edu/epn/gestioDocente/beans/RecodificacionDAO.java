package ec.edu.epn.gestioDocente.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.Recodificacion;

@Local
public interface RecodificacionDAO extends DaoGenerico<Recodificacion>{

	int consultarIdRecodifica();

}
