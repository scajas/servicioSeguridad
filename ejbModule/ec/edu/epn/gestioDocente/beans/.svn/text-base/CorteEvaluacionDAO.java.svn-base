package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.CorteEvaluacion;

@Local
public interface CorteEvaluacionDAO extends DaoGenerico<CorteEvaluacion>{

	List<Pensum> listaPensumXDepCortePlanif(String tipoEvaluacion, String codDep);

	CorteEvaluacion corteEvalXPensumDep(String codDep, Integer idPensum);

	

}
