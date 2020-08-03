package ec.edu.epn.acreditacion.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.acreditacion.DTO.CriterioDetalleDTO;
import ec.edu.epn.acreditacion.entities.Criterio;
import ec.edu.epn.acreditacion.entities.CriterioDetalle;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface CriterioDetalleDAO extends DaoGenerico<CriterioDetalle>{

	CriterioDetalleDTO criterioxIdCriterioCarrera(Integer idCriterio, String idCarrera);

	Long countCriterioDetalleXIdCarrera(String idCarrera, Integer idPensum) throws Exception;

	void generaAcreditacionXCarrera(String idCarrera,  Integer idPensum) throws Exception;

	CriterioDetalle criterioDetalleXIdCarreraIdCriterio(Integer idCriterio, String idCarrera) throws Exception;
	
	List<Criterio> listCriteriosbyCarreraPeriodo(String carrera, Integer periodo) throws Exception;
	
	List<CriterioDetalle> listCriteriosbyCrierioCarreraPeriodo(Integer idCriterio, String carrera, Integer periodo) throws Exception;
	List<CriterioDetalle> listCriteriosbyCarrera(String carrera) throws Exception;

}
