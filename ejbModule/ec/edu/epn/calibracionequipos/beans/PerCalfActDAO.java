package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.PerCalAct;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface PerCalfActDAO extends DaoGenerico<PerCalAct> {

	PerCalAct buscarVinculacion(PerCalAct viculacion);
	
	
}
