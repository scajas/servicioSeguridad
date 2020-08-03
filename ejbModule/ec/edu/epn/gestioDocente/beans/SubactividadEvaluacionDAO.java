package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.SubactividadEvaluacion;

@Local
public interface SubactividadEvaluacionDAO extends DaoGenerico<SubactividadEvaluacion>{

	List<SubactividadEvaluacion> listSubActvXIdActv(Integer idActividad) throws Exception;

	
}
