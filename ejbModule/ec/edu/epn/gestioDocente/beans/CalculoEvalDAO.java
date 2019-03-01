package ec.edu.epn.gestioDocente.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.CalculoEval;


@Local
public interface CalculoEvalDAO extends DaoGenerico<CalculoEval> {

	Long countCalcDocPeriodo(String nced, Integer idPensum) throws Exception;
	

	
	
}
