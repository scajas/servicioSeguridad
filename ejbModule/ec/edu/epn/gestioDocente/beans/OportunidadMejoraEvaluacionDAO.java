package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.OportunidadMejoraEvaluacion;

@Local
public interface OportunidadMejoraEvaluacionDAO extends DaoGenerico<OportunidadMejoraEvaluacion>{

	List<OportunidadMejoraEvaluacion> listOportunidadesXEvaluacion(Integer idEvalaucionAcademica) throws Exception;

	
}
