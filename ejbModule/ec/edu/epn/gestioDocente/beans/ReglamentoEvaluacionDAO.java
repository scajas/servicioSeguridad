package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.DTO.CatalogoActividadesDTO;
import ec.edu.epn.gestionDocente.entities.ReglamentoEvaluacion;

@Local
public interface ReglamentoEvaluacionDAO extends DaoGenerico<ReglamentoEvaluacion>{

	List<CatalogoActividadesDTO> listReglamentoActvXTipo(Integer tipoActvEval) throws Exception;
	
}
