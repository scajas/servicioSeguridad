package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.DTO.RecorridoEvaluacionDTO;
import ec.edu.epn.gestionDocente.entities.RecorridoEvaluacion;

@Local
public interface RecorridoEvaluacionDAO extends DaoGenerico<RecorridoEvaluacion>{

	RecorridoEvaluacion recorridoXEstado(Integer idEvaluacion, String estadoAnterior) throws Exception;

	List<RecorridoEvaluacionDTO> listaRecorridoXEval(Integer idEvaluacion);

	
}
