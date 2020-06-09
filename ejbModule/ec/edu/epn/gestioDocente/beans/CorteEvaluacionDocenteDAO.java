package ec.edu.epn.gestioDocente.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.CorteEvaluacionDocente;

@Local
public interface CorteEvaluacionDocenteDAO extends DaoGenerico<CorteEvaluacionDocente>{

	List<Pensum> listaPensumXCorteEval(String nced, String estado, Date fechaCierre);

	List<Pensum> listaPensumEval(Integer idPensum);

	CorteEvaluacionDocente corteEvaluacionDocenteXPensum(Integer idPensum);

	CorteEvaluacionDocente corteEvalXDepPensum(Integer idPensum, String dep, String estadoEval, String opcion);

	CorteEvaluacionDocente corteEvalXPensumDoc(Integer idPensum, String nced, String estadoEval, String dep);

	
	

}
