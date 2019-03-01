package ec.edu.epn.acreditacion.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.acreditacion.DTO.IndicadorDetalleDTO;
import ec.edu.epn.acreditacion.entities.Indicador;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface IndicadorDAO extends DaoGenerico<Indicador>{

	List<Indicador> listIndicadoresxIdSubCriterio(Integer idSubCriterio) throws Exception;

	List<IndicadorDetalleDTO> indicadorDTOxIdSubCriAndCriDetalle(Integer idCriterioDetalle, Integer idSubcriterio);

}
