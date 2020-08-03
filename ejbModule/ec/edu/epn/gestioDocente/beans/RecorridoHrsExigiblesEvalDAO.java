package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.DTO.HorasPeriodoAcademicoDTO;
import ec.edu.epn.gestionDocente.entities.RecorridoHrsExigiblesEval;

@Local
public interface RecorridoHrsExigiblesEvalDAO extends DaoGenerico<RecorridoHrsExigiblesEval>{

	int countRecorridoExigPorPensum(Integer idEvaluacion);

	RecorridoHrsExigiblesEval maxRecHrsExigiblesEval(Integer idEvaluacion);

	List<RecorridoHrsExigiblesEval> listRecHrsExigiblesEval(Integer idEvaluacion);

	HorasPeriodoAcademicoDTO llenarHorasPeriodoXEval(RecorridoHrsExigiblesEval recorrido);

	

	
	
}
