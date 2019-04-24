package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Detalleorden;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.OrdenTrabajo;
import ec.edu.epn.laboratorioBJ.entities.PersonalLab;

@Local
public interface OrdenTrabajoDAO extends DaoGenerico<OrdenTrabajo> {

	List<Detalleorden> filtrarLista(String fechaInicio, String fechaFin, String tipo, String estado, String laboratorio,String personal);

	List<PersonalLab> listaPersonalAnalista();

	List<LaboratorioLab> listaLaboratorioUnidad(int id);
	
	
}
