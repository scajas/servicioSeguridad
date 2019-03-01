package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.calibracionequipos.entidades.Plan;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface PlanDAO extends DaoGenerico<Plan> {
	int consultarId();

	List<Plan> buscarPlanxEquipo(Equiposcalibracionequipo equipo);

}
