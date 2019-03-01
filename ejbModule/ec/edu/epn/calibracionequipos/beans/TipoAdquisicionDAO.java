package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Tipoadquisicion;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface TipoAdquisicionDAO extends DaoGenerico<Tipoadquisicion> {
	int consultarId();

}
