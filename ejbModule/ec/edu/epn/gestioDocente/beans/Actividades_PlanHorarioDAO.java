package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.Actividad_PlanHorario;
import ec.edu.epn.gestionDocente.entities.PlanTrabajo;


@Local
public interface Actividades_PlanHorarioDAO extends
		DaoGenerico<Actividad_PlanHorario> {
	int consultarId();

	List<Actividad_PlanHorario> listaActividadesHorarioExistentesEnplanTrabajo(
			PlanTrabajo idplan, Pensum p);
	
	List<Actividad_PlanHorario> listaPlantrabajoPedido(Pedido pedido);

}
