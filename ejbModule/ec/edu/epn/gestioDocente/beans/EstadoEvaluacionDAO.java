package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.EstadoEvaluacion;



@Local
public interface EstadoEvaluacionDAO extends DaoGenerico<EstadoEvaluacion> {

	EstadoEvaluacion estadoEvalXNombre(String nombre) throws Exception;

	List<EstadoEvaluacion> listEstaodEval();

	List<EstadoEvaluacion> listEstaodEvalPreplanif();
	

}
