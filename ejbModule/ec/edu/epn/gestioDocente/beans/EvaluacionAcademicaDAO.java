package ec.edu.epn.gestioDocente.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.EvaluacionAcademica;
import ec.edu.epn.rrhh.DTO.DocenteDTO;
import ec.edu.epn.rrhh.DTO.DocentesEvaluacionDTO;
 /**EvaluacionAcademicaDAO**/
@Local
public interface EvaluacionAcademicaDAO extends DaoGenerico<EvaluacionAcademica>{

	void llenarRegistrosAutoEvalaucion() throws Exception;

	EvaluacionAcademica evaluacionXCedulaPeriodo(String nced, Integer idPensum, String estadoo) throws Exception;

	Long countEvalXDocPeriodo(String nced, Integer idPensum, String estado) throws Exception;

	ArrayList<DocenteDTO> docenteConsultaPlanif(Long idUser, String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep, String perfilUsuario, Integer idPensum) throws SQLException;

	ArrayList<DocenteDTO> docenteXEvaluacion(Long idUser, String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep, String perfilUsuario, Integer idPensum) throws SQLException;

	ArrayList<DocentesEvaluacionDTO> calcEvaluacionXCedulaDoc(String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep, String perfilUsuario, Integer idPensum, String codTipoRelacionLab) throws SQLException;

	EvaluacionAcademica evaluacionXCedulaPeriodoEstado(String nced, Integer idPensum, String estado, String estado2)
			throws Exception;

	Long countEvalXDocPeriodoEstado(String nced, Integer idPensum, String estado, String estado2) throws Exception;

	List<EvaluacionAcademica> listEvalXEstadosPlanif(String nced);

	void generarReplicaPlanificacionXPeriodo(String nced, Integer idPensumActual, Integer idPensumRepl,
			EvaluacionAcademica evalAcadActual, Long idUser);

	List<EvaluacionAcademica> evaluacionXPeriodo(Integer idPensum) throws Exception;

	ArrayList<DocentesEvaluacionDTO> reportePlanificacionDoc(String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep, String perfilUsuario, Integer idPensum, String codTipoRelacionLab) throws SQLException;
	
	
	
}
