package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.DTO.CatalogoActividadesDTO;
import ec.edu.epn.gestionDocente.DTO.ReglamentoEvalDTO;
import ec.edu.epn.gestionDocente.entities.ReglamentoEvaluacion;

@Local
public interface ReglamentoEvaluacionDAO extends DaoGenerico<ReglamentoEvaluacion>{

	List<ReglamentoEvalDTO> listCoevalReglamento(Integer idPensum, String nced, String apel, String nom, String codDep)
			throws Exception;

	List<CatalogoActividadesDTO> listReglamentoAll() throws Exception;

	ReglamentoEvalDTO reglamentoReporte() throws Exception;

	List<CatalogoActividadesDTO> listReglamentoActvXTipo(Integer tipoActvEval, String estado) throws Exception;

	List<CatalogoActividadesDTO> listReglamentoActvXTipo(Integer tipoActvEval) throws Exception;
	
}
