package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Estadoejecucion;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface EstadoEjecucionDAO extends DaoGenerico<Estadoejecucion> {
	int consultarId();

}
