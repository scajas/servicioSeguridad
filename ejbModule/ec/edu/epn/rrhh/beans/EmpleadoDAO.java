package ec.edu.epn.rrhh.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.persistence.NoResultException;

import ec.edu.epn.acreditacion.reportes.dto.ReporteChartDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReporteDistributivoAcademicoDTO;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.DTO.NombramientoDTO;
import ec.edu.epn.rrhh.DTO.DocenteDTO;
import ec.edu.epn.rrhh.DTO.EmpleadoDTO;
import ec.edu.epn.rrhh.entities.Emp;

@Remote
public interface EmpleadoDAO extends DaoGenerico<Emp> {

	List<Emp> listaEmpleadoXCedula(String cedula) throws Exception;

	List<Emp> findempByParams(String cedula, String apellidos, String nombre);
	
	List<Emp> listaEmpleadoTipoContrato(Long idusuario) throws Exception;

	Emp buscaremp(String nced) throws Exception;

	List<Emp> listaXParametros(String nombre, String Apellido) throws Exception;

	public ArrayList<DocenteDTO> docenteCIPersonal(String auxCIDoc, String auxNomDoc, String auxApelDoc, String auxDep,
			Long idUser, String perfilUsuario) throws Exception;

	public ArrayList<DocenteDTO> conusltaDatosDocentesGeneralPT(String cedula, Long idUsuario, String perfilUsuario)
			throws Exception;

	ArrayList<DocenteDTO> listBusquedaDocentesXDep(String cedula, String nombre, String apellido, String departamento)
			throws Exception;

	ArrayList<DocenteDTO> BusqeudaDocenteRevalorizacion(String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep, List<String> depar) throws Exception;

	ArrayList<NombramientoDTO> nombramientos(String cedula);

	ArrayList<DocenteDTO> BusqeudaDocenteRevalorizacionEnviada(String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep) throws Exception;

	ArrayList<DocenteDTO> BusqeudaDocenteRecategorizacion(String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep, List<String> depar) throws Exception;

	ArrayList<DocenteDTO> BusqeudaDocenteRecateogrizacionEnviada(String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep) throws Exception;

	List<Emp> findEMPBYPARAMS(String nom, String apel, String coddep, String nced);
	
	public ArrayList<DocenteDTO> listDocenteSeleccionado(String cedula, String nombre, String apellido,
			String departamento, String idPeriodo, String perfilSeleccionado) throws Exception;

	public ArrayList<DocenteDTO> listDocenteSeleccionadoEjecucion(String cedula, String nombre, String apellido,
			String departamento, String idPeriodo, String perfilSeleccionado) throws Exception;

	List<EmpleadoDTO> findEmpFacDep(String nombreCedulaEmpelado) throws Exception;

	ArrayList<DocenteDTO> listDocenteDepartamento(Long idUser, String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep, String perfilUsuario) throws SQLException;

	ArrayList<DocenteDTO> calculoEvaluacionXCedulaDoc(String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep, String perfilUsuario, Integer idPensum) throws SQLException;

	ArrayList<DocenteDTO> docenteCIPersonalEvaluacion(String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep, String perfilUsuario, String tipoEval, Integer idPensum) throws SQLException;

	Long countEmpxCed(String nced) throws Exception;

	ArrayList<DocenteDTO> docenteCIPlanifActividades(String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep, Integer idPensum) throws SQLException;

	//List<Emp> listarEmpXidDep(String idDepartamento, String nombre) throws NoResultException, Exception;
	
	/**
	 * Método que devuelve la lista de empleados según el criterio. 
	 * @return Lista<Emp>
	 */
	public List<Emp> obtenerListaEmpleados(String criterio);

	/**
	 * Método que devuelve el empleado según el criterio. 
	 * @return Lista<Emp>
	 */
	public Emp obtenerEmpleado(String criterio);

	List<Emp> listarEmpXlistCedulas(List<String> docentes, String nombre) throws NoResultException, Exception;
	

	List<Emp> listarEmpXidDep(String idDepartamento, String nombre, String codClase, String tipoRelLaboral, String estadoDocente)
			throws NoResultException, Exception;

	List<Emp> findempByParamsDep(String cedula, String apellidos, String nombre, String coddep);

	List<Emp> findempByParamsReporteGI(String cedula, String apellidos, String nombre, String codRelacionLab,
			String coddep, String tipo);

	Emp obtenerEmpleadoAcreditacion(String criterio);

	ArrayList<ReporteChartDTO> totalProyectos(String cedula);

	ArrayList<ReporteChartDTO> totalPublicaciones(String cedula);

	ArrayList<ReporteChartDTO> totalHorasDoc(String cedula);

	ArrayList<ReporteChartDTO> totalHorasInv(String cedula);

	ArrayList<ReporteChartDTO> totalHorasGes(String cedula);

	Emp buscarempJefeDepartamento(String coddep) throws Exception;

	List<Emp> findEmpXCeduNombre(String cedula, String apellidos, String nombre);

	List<Emp> findinvAcreditadosSenescyt();

	Emp buscarempLivianoRG(String nced) throws Exception;

	DocenteDTO cargoDedicacionRelLab(Integer idPensum, Integer idOpcion, String nced) throws Exception;

	DocenteDTO buscarEmpHistoriaLab(String nced, Integer idPensum) throws Exception;

	EmpleadoDTO buscarHistoriaEmpleado(String nced, Integer idPensum) throws Exception;

	List<Emp> listaEmpleadonoContrato(int firstResults, int maxResults);
	
	public long getCountEmpContrato();
	
	List<Emp> findEmpsByCedula(String nced, int firstResult, int maxResults);

/*	List<Emp> buscarempActualizar() throws Exception;

	List<Emp> buscarempActualizarDatos() throws Exception;*/

	


}
