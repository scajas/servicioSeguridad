package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Estadoequipo;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface EstadoEquipoDAO extends DaoGenerico<Estadoequipo> {
	int consultarId();

}
