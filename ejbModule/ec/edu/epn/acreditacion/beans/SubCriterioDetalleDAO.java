package ec.edu.epn.acreditacion.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.acreditacion.DTO.SubCriterioDetalleDTO;
import ec.edu.epn.acreditacion.entities.SubcriterioDetalle;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface SubCriterioDetalleDAO extends DaoGenerico<SubcriterioDetalle>{

	List<SubCriterioDetalleDTO> criterioxIdCriterioCarrera(Integer idCriterioDetalle , Integer idSubCriterioDetalle);

}
