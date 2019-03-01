package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Actividadescalibracionequipo;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface ActividadesCalibracionDAO extends DaoGenerico<Actividadescalibracionequipo> {
	int consultarId();

}
