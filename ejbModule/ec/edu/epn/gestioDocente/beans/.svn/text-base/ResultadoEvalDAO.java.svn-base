package ec.edu.epn.gestioDocente.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.ResultadoEval;


@Local
public interface ResultadoEvalDAO extends DaoGenerico<ResultadoEval> {
	

	ResultadoEval buscarXCedulaResultEval(String nced, Integer idPensum, String tipoEval, String ncedDir);

	Long countPregEvalDocente(String nced, Integer idPensum, String tipoEval, String ncedDir) throws Exception;	
	
}
