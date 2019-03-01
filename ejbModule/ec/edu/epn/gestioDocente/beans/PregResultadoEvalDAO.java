package ec.edu.epn.gestioDocente.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.DTO.CoEvaluacionResultadoDTO;
import ec.edu.epn.gestionDocente.DTO.PreguntasEvaluacionDTO;
import ec.edu.epn.gestionDocente.entities.PregResultadoEval;


@Local
public interface PregResultadoEvalDAO extends DaoGenerico<PregResultadoEval> {

	Long countPregResultadoEvalDocente(Integer idResultadoEval)
			throws Exception;

	PregResultadoEval valPregResEvalXIdPreg(Integer idResultadoEval,
			Integer idPreguntasEval) throws Exception;

	List<PreguntasEvaluacionDTO> listPregResultadoEvaluacion(String tipo,
			String seleccion, Integer idResultadoEval) throws Exception;

	ArrayList<CoEvaluacionResultadoDTO> coEvalDocentePeriodo(String nced,
			Integer idPensum) throws SQLException;	
	
}
