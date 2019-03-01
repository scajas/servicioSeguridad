package ec.edu.epn.deportivo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.deportivo.entities.Deporte;
import ec.edu.epn.deportivo.entities.Estudiante;
import ec.edu.epn.deportivo.entities.GrupoEstudiante;
import ec.edu.epn.deportivo.entities.Planificacion;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface GrupoEstudianteDAO extends DaoGenerico<GrupoEstudiante> {
	
	
	List<GrupoEstudiante> findxPlanificacion(Planificacion planif);
	List<GrupoEstudiante> findxDepEstu(Deporte dep, Estudiante est);
	List<GrupoEstudiante> findxEstu(Estudiante est);
	List<GrupoEstudiante> findxParamEstu(String nombres, String cedula);

}
