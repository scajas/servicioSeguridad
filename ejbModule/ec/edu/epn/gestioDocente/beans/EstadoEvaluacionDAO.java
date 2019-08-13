package ec.edu.epn.gestioDocente.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.EstadoEvaluacion;



@Local
public interface EstadoEvaluacionDAO extends DaoGenerico<EstadoEvaluacion> {

	EstadoEvaluacion estadoEvalXNombre(String nombre) throws Exception;
	

}
