package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.EqPerCalf;
import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.calibracionequipos.entidades.Personalcalificado;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface EquipoPersonalDAO extends DaoGenerico<EqPerCalf> {
	List<Personalcalificado> buscarPersonalxEquipo(Equiposcalibracionequipo equipo);
}
