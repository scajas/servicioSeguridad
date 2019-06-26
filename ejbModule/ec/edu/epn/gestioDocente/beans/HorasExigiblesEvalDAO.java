package ec.edu.epn.gestioDocente.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.HorasExigiblesEval;

@Local
public interface HorasExigiblesEvalDAO extends DaoGenerico<HorasExigiblesEval>{

	HorasExigiblesEval horasExigiblesXPensum(Integer idPensum);

	Double numhorasExigiblesXPensum(Integer idPensum);

	

	
}
