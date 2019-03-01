package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.PlanfActAcademica;


@Local
public interface PlanfActAcademicaDAO extends DaoGenerico<PlanfActAcademica> {

	Long countPlanifActDocente(String nced, Integer idPensum) throws Exception;

	PlanfActAcademica valPlanifCedulaPeriodo(String nced, Integer idPensum)
			throws Exception;

	List<PlanfActAcademica> listPlanifXPeriodo(Integer idPensum) throws Exception;

	
}
