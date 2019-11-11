package ec.edu.epn.rrhh.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Emp;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboral;

@Remote
public interface HistoriaLaboralDAO extends DaoGenerico<HistoriaLaboral> {
	// HistoriaLaboralDAO
	public List<HistoriaLaboral> findHistoriaByEmp(Emp emp);
	
	public List<HistoriaLaboral> findHistoriasByEmpNoDuplicados(Emp emp);

	public List<HistoriaLaboral> findHistoriasSinContratoByEmp(Emp emp);

	public List<HistoriaLaboral> findHistoriasAnuladasInsub(Emp emp);

	public HistoriaLaboral findCurrentHistoriaLaboralByEmp(Emp emp);

	public HistoriaLaboral findLastHistoriaDesignacionByEmp(Emp emp);

	public HistoriaLaboral findCountOfHistoriaDesignacionByDependenciaDesignacion(String nombreDependencia,
			String nombreDesignacion, int idAccionDePersonal, String tipoDesignacion);

	public List<HistoriaLaboral> findHistoriaYear(Integer year);

	public Integer getMaxID();

	public Integer getMaxNroDocumentoByYear(Integer year);

	public boolean findVacacionActivaByEmpleado(Emp emp, Date fechaActual);

	public boolean findVacacionActivaByEmpleado(Emp emp, Date fechaActual, Date fechaFin);

	public boolean hasNombramientoActivoByEmpleado(Emp emp);
	
	public List<HistoriaLaboral> getLicenciasVencidasPorMes(String nombreDependencia, String mes, String anio);

	public boolean findAnioSabaticoActivoByEmpleado(Emp emp, Date fechaActual);

	public boolean findAnioSabaticoActivoByEmpleado(Emp emp, Date fechaActual, Date fechaFin);

	public boolean findEncargoActivoByEmpleado(Emp emp, Date fechaActual, Date fechaFin);

	public boolean findEncargoActivoByEmpleado(Emp emp, Date fechaActual);

	public boolean findLicenciaActivaByEmpleado(Emp emp, Date fechaRige);

	public boolean findLicenciaActivaByEmpleado(Emp emp, Date fechaRige, Date fechaFin);

	public boolean isEmpleadoOnComisionActiva(Emp emp, Date fechaRige);

	public boolean isEmpleadoOnComisionActiva(Emp emp, Date fechaRige, Date fechaFin);

	public boolean findCambioAdministrativoActivoByEmpleado(Emp emp, Date fechaRige);

	public boolean empleadoHasSubrogacionActivaEnFecha(Emp emp, Date fechaActual);

	public boolean empleadoHasAnyDesignacionActivaOnFecha(Emp emp, Date fechaActual, Date fechaFin);

	public List<HistoriaLaboral> getAllDesignacionesActivas();
	
	public boolean empleadoHasNombramientosSinFinalizar(Emp emp);

	public boolean isEmpleadoOnDesignacionActiva(Emp emp);

	public List<HistoriaLaboral> getDesignacionesEmpleadoOnFecha(Emp emp, Date fechaActual);

	public boolean isEmpleadoConNombramiento(Emp emp);

	public List<HistoriaLaboral> findHistoriaByIdhistoria(Integer historiaid);

	public Boolean isHistoriaElaborado();

	public HistoriaLaboral getMostRecentNombramientoByEmp(Emp emp);

	public HistoriaLaboral getMostRecentNombramientoFinalizadoByEmp(Emp emp);
	
	public HistoriaLaboral getMostRecentNombramientoProvisionalByEmp(Emp emp);

	public boolean empleadoHasNombramientosFinalizar(Emp emp);

	public boolean isEmpleadoOnNombramientoProvisional(Emp emp);

	public boolean isAccionPorFinalizar(String nombreAccion, Emp emp);

	public boolean isAnyAccionPorFinalizar(Emp emp);
	
	public long findCountAccionesNoLicenciaFinalizables(Emp emp);

	public List<HistoriaLaboral> findAccionesNoLicenciaFinalizables(Emp emp);

	public HistoriaLaboral findHistoriaByNroDocumentoEmpYEstado(Emp emp, String nroDocumento, String estado);

	public List<HistoriaLaboral> getDesignacionesActivasByEmpFinalizacion(Emp emp, String nroDocumentoAFinalizar);

	public List<HistoriaLaboral> getAnyDesignacionActivaByEmpFinalizacion(Emp emp, String nroDocumentoAFinalizar);

	public boolean empleadoHasAnyTipoDesginacionActiva(String tipoDesignacion, Emp emp);

	public boolean empleadoHasAnyLicenciaActiva(Emp emp, String tipoDeLicencia);

	public boolean empleadoHasAnyLicenciaActiva(Emp emp);

	public List<HistoriaLaboral> getLicenciasActivasByEmpleado(Emp emp);
	
	public List<HistoriaLaboral> getAllLicenciasVencidas(int firstResult, int maxResult);
	
	public List<HistoriaLaboral> getAllLicenciasVencidasByEmp(String nced, int firstResult, int maxResult);
	
	public Object getAllLicenciasVencidasByEmpApel(boolean isOnlyCount, 
			String apel, int firstResult, int maxResult);
	public long getCountLicenciasVencidas();
	
	public long getCountLicenciasVencidasByEmp (String nced);

	public HistoriaLaboral getAnioPeriodoSabaticoActivoByEmpleado(Emp emp);

	public HistoriaLaboral getComisionEstadiaActivaByEmpleado(Emp emp);

	public HistoriaLaboral getLicenciaPorEstudiosActivaByEmpleado(Emp emp);

	public boolean isAccionInsubsistida(Emp emp, String numeroDocumentoAccion);

	public List<HistoriaLaboral> findHistorias();

	public HistoriaLaboral findHistoriaByIdDesignacion(int idDesignacion);

	public List<HistoriaLaboral> findHistorias(Integer anio);

	public List<HistoriaLaboral> findHistorias(Date inicio, Date ffinal, String nombreDependencia,
			String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado, String nombreDesignacion,
			Emp empleado, boolean isFullReport, int [] filtersAcciones) ;

	public List<HistoriaLaboral> findHistorias(Date inicio, Date ffinal);

	public Object findHistoriasEjecucion(boolean isOnlyCount, String nroDocumento,
			String nombreAccion,  int firstResult, int maxResult);

	public HistoriaLaboral findHistoriaDesignacionByDependenciaYTipo(String dependencia, String facultad,
			String tipoDeDesignacion, String dignidad, String estadoDesignacion);

	public List<HistoriaLaboral> findNombrameintosByEmp(Emp emp);

	public boolean isEmpleadoOnMultipleDesignacion(Emp emp);

	public List<HistoriaLaboral> getDesignacionesMultiplesByEmp(Emp emp);

	public List<HistoriaLaboral> findContByEmp(Emp emp);
	
	public List<HistoriaLaboral> findContratosVencidosByEmp(Emp emp);

	public HistoriaLaboral findHistoriaActualizacionByEmp(Emp emp);

	public HistoriaLaboral getTipoRelacionNombramientoByEmp(Emp emp);

	List<HistoriaLaboral> findHistoriaByNoDoc(String nced);

	public HistoriaLaboral findLastContByEmp(Emp emp);
	/* Funciones para manejo de tabs en MovimientosController */

	// Tab 1: Historias que afecten la asistencia del empleado. (Sin licencias
	// por estudios o periodos
	// y años sabáticos

	public List<HistoriaLaboral> getHistoriasQueAfectanAsistencia(Emp emp);

	public List<HistoriaLaboral> getHistoriasQueAfectanAsistenciaReporte(Date inicio, Date ffinal,
			String nombreDependencia, String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado,
			String nombreDesignacion, Emp empleado, boolean isFullReport);

	/* Tab 2: Historias que afectan el cargo o la RMU */

	public List<HistoriaLaboral> getHistoriasQueAfectanCargoRmu(Emp emp);

	public List<HistoriaLaboral> getHistoriasQueAfectanCargoRmuReporte(Date inicio, Date ffinal,
			String nombreDependencia, String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado,
			String nombreDesignacion, Emp empleado , boolean isFullReport);

	/*
	 * Tab 3: Historias que se refieran a designacion de dignidades
	 * (Designaciones, subrogaciones y encargos
	 */

	public List<HistoriaLaboral> getHistoriasQueAfectanDesignacion(Emp emp);

	public List<HistoriaLaboral> getHistoriasQueAfectanDesignacionReporte(Date inicio, Date ffinal,
			String nombreDependencia, String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado,
			String nombreDesignacion, Emp empleado , boolean isFullReport);

	/*
	 * Tab 4: Historias con licencias o comisiones por estudios, año o periodo
	 * sabático
	 */

	public List<HistoriaLaboral> getHistoriasLicenciasComSabatico(Emp emp);

	public List<HistoriaLaboral> getHistoriasLicenciasComSabaticoReporte(Date inicio, Date ffinal,
			String nombreDependencia, String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado,
			String nombreDesignacion, Emp empleado , boolean isFullReport);

	/* Tab 5: Sanciones */

	public List<HistoriaLaboral> getHistoriasSanciones(Emp emp);

	public List<HistoriaLaboral> getHistoriasSancionesReporte(Date inicio, Date ffinal, String nombreDependencia,
			String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado, String nombreDesignacion,
			Emp empleado , boolean isFullReport);

	/* Tab 6: Contratos* (Ya se encuentra definida la funcion) */

	public List<HistoriaLaboral> getContratosReporte(Date inicio, Date ffinal, String nombreDependencia,
			String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado, String nombreDesignacion,
			Emp empleado , boolean isFullReport);

	/* Tab 7: Finalziaciones y actualziaciones */

	public List<HistoriaLaboral> getActualizacionesFinalizaciones(Emp emp);

	public List<HistoriaLaboral> getActualizacionesFinalizacionesReporte(Date inicio, Date ffinal,
			String nombreDependencia, String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado,
			String nombreDesignacion, Emp empleado , boolean isFullReport);

	/* Tab 8: Historias Migradas */

	public List<HistoriaLaboral> getAccionesMigradas(Emp emp);

	public List<HistoriaLaboral> getAccionesMigradasReporte(Date inicio, Date ffinal, String nombreDependencia,
			String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado, String nombreDesignacion,
			Emp empleado , boolean isFullReport);
	/* Finalizacion métodos para manejo de tabs */

	// Reportes empleados

	public List<HistoriaLaboral> getReportePorEmpleadosGeneral(Date fechaDesde, Date fechaHasta,
			String codEstadoEmpleado, String codTipoRelacionEmpleado, String codClaseEmpleado,
			String nombreDependencia, String nombreDependenciaDesignacion);

	public List<HistoriaLaboral> getReportePorEmpleadosContratos(Date fechaDesde, Date fechaHasta,
			String codEstadoEmpleado, String codTipoRelacionEmpleado, String codClaseEmpleado,
			String nombreDependencia, String nombreDependenciaDesignacion);

	public Integer findHistoriaNumberBySubtipo(String subtipoAccion);

    public long getCountOfHistoriasSinRegistro();
	public HistoriaLaboral findLastContByEmpActivo(Emp emp);

	public HistoriaLaboral findCurrentHistoriaLaboralByEstadoActivoEmp(Emp emp);

	public Integer findHistoriaNumberByTipoAccion(String subtipoAccion);

}
