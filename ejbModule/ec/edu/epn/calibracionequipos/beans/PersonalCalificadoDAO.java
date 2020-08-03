package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Personalcalificado;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface PersonalCalificadoDAO extends DaoGenerico<Personalcalificado> {
	int consultarId();

	List<Personalcalificado> buscarPersonal(String nombres, String cedula);

}
