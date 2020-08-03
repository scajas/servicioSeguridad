package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.PlanTrabajo;


@Local
public interface PlanTrabajoDAO extends DaoGenerico<PlanTrabajo> {
	int consultarId();

	PlanTrabajo buuscarXNced(String cedula, int idpensum);

	PlanTrabajo buuscarPlanTrabajoEnviado(String cedula, Pensum p);

	List<PlanTrabajo> buscarPlanesXCedulaNombre(String ceula, String nombre,
			String apellido, Pensum pensum);

	List<PlanTrabajo> buscarPlanesAvanzados(PlanTrabajo plan, String horario);

	List<PlanTrabajo> listaCargos();

}
