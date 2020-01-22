package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.ActividadEvaluacion;

@Local
public interface ActividadEvaluacionDAO extends DaoGenerico<ActividadEvaluacion>{

	List<ActividadEvaluacion> listActvEvalXEvalTipo(Integer idEvalAcademica, Integer tipoActvEval) throws Exception;

	Long actvEvalXNombre(Integer idEvalAcademica, Integer tipoActvEval, String nombre);

	Long actvEvalXCatalogo(Integer idEvalAcademica, Integer tipoActvEval, Integer idCatalogoAct);

	ActividadEvaluacion actvEvalXEvalTipo(Integer idEvalAcademica, Integer idCatalogo) throws Exception;

	List<ActividadEvaluacion> listActvEvalXIdEval(Integer idEvalAcademica) throws Exception;

	Long actvEvalNotIdTipoActv(Integer idEvalAcademica, Integer tipoActvEval);

	Double sumValorActEval(Integer idEvalAcademica);

	Long countActvEvalXCat(Integer idEvalAcademica, Integer idCatalogo) throws Exception;

	List<ActividadEvaluacion> listActvEvalXCat(Integer idEvalAcademica, Integer idCatalogo) throws Exception;
	
}
