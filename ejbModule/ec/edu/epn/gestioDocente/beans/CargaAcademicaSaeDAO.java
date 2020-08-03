package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.DTO.CargaPlanificacionDTO;
import ec.edu.epn.gestionDocente.entities.CargaAcademicaSae;

@Local
public interface CargaAcademicaSaeDAO extends DaoGenerico<CargaAcademicaSae>{

	Long countCargAcadSaeXDocPeriodo(String nced, Integer idPensum) throws Exception;

	List<CargaAcademicaSae> listCargAcadSaeXDocPeriodo(String nced, Integer idPensum) throws Exception;

	void cargaAcademicaSae(List<CargaPlanificacionDTO> listCarga, Integer idPensum, String nced) throws Exception;

	void actualizarCargaAcademicaSae(List<CargaPlanificacionDTO> listCarga, List<CargaPlanificacionDTO> listCargaAux,  List<CargaAcademicaSae> listCargaAcademica,
			Integer idPensum, String nced) throws Exception;

	void actualizarCargaAcademicaSaeDelete(List<CargaPlanificacionDTO> listCarga,
			List<CargaAcademicaSae> listCargaAux, List<CargaAcademicaSae> listCargaAcademica, Integer idPensum,
			String nced) throws Exception;

	void cargaAcademicaRemedialSae(List<CargaPlanificacionDTO> listCarga, Integer idPensum, String nced)
			throws Exception;
	
	void actualizarNumEstudCargaAcademicaSae(List<CargaPlanificacionDTO> listCarga,
			List<CargaAcademicaSae> listCargaAcademica) throws Exception;

	
	
}
