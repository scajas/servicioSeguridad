package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.ActPlan;
import ec.edu.epn.gestionDocente.entities.PlanTrabajo;




@Local
public interface Actividades_PlanDAO extends DaoGenerico<ActPlan> {
	int consultarId();

	List<ActPlan> listaActividadesExistentesEnplanTrabajo(PlanTrabajo idplan,
			Pensum pensum);

}
