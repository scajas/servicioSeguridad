package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Detalleplan;
import ec.edu.epn.calibracionequipos.entidades.Plan;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface DetallePlanDAO extends DaoGenerico<Detalleplan> {
	int consultarId();

	List<Detalleplan> detallesxPlan(Plan plan);
}
