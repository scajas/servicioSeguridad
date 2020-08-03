package ec.edu.epn.catalogos.beans;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.DTO.PlanifDocenteDTO;
import ec.edu.epn.gestionDocente.entities.PlanifDocente;
import ec.edu.epn.proyectos.DTO.ProyectoDTO;

@Local
public interface PlanifDocenteDAO extends DaoGenerico<PlanifDocente> {
	int consultarId();
	
	public List<ProyectoDTO> listProyectoDTO (String cedula) throws Exception;
	public List<PlanifDocenteDTO>  listPlanificacionDocenteDTO (String cedula, String tipoActividad, String idPeriodo) throws Exception;
	public String estadoPlanificacion(String cedula, String idPeriodo)throws Exception;
	public List<PlanifDocenteDTO>  listPlanificacionDocenteEjecucionDTO (String cedula, String tipoActividad, String idPeriodo) throws Exception;

	List<PlanifDocente> verificarPlanifEjecucion(String cedula, String periodo) throws Exception;
	List<PlanifDocente> verificarPlanifEjecucionXcedula(String cedula) throws Exception;

	public void actualizarPlanificacion(PlanifDocenteDTO planifDocenteDTO) throws Exception;
	
	List<PlanifDocente> verificarEvaluacionRegistrada(String cedula,
			String periodo);

	List<PlanifDocente> verificarEvaluacionRegistradaXcedula(String cedula);

	public List<ProyectoDTO> listProyectoXNcedDocenteDTO(String cedula) throws SQLException;
}
