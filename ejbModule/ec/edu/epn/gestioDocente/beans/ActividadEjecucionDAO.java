package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.ActividadEjecucion;


@Local
public interface ActividadEjecucionDAO extends DaoGenerico<ActividadEjecucion>{

	Long actvEvalXNombre(Integer idEvalAcademica, Integer tipoActvEval, String nombre);

	List<ActividadEjecucion> listActvEvalXEvalTipo(Integer idEvalAcademica, Integer tipoActvEval) throws Exception;

	Long actvEvalEjecucion(Integer idEvalAcademica);

	List<ActividadEjecucion> listActvEvalXIdEval(Integer idEvalAcademica) throws Exception;

	Double sumValorActvEjec(Integer idEvalAcademica);

	
	
}
