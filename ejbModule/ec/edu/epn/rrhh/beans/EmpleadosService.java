package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.ActividadAdministrativa;
import ec.edu.epn.gestionDocente.entities.ActividadDocencia;
import ec.edu.epn.gestionDocente.entities.ActividadExtension;
import ec.edu.epn.gestionDocente.entities.ActividadProyecto;
import ec.edu.epn.gestionDocente.entities.ActividadTecnica;
import ec.edu.epn.gestionDocente.entities.AreaConocDocente;
import ec.edu.epn.gestionDocente.entities.Capacitacion;
import ec.edu.epn.gestionDocente.entities.ExpProfesExt;
import ec.edu.epn.gestionDocente.entities.IdiomasDocente;
import ec.edu.epn.gestionDocente.entities.Premio;
import ec.edu.epn.gestionDocente.entities.Publicacione;
import ec.edu.epn.gestionDocente.entities.TesisCalificada;
import ec.edu.epn.gestionDocente.entities.TesisDirigida;
import ec.edu.epn.gestionDocente.entities.TipoPublicacion;
import ec.edu.epn.gestionDocente.entities.TituloFormacionAcademica;
import ec.edu.epn.rrhh.DTO.EmpleadoDTO;
import ec.edu.epn.rrhh.entities.Cargosc;
import ec.edu.epn.rrhh.entities.Clasemp;
import ec.edu.epn.rrhh.entities.Cont;
import ec.edu.epn.rrhh.entities.Dep;
import ec.edu.epn.rrhh.entities.Ecivil;
import ec.edu.epn.rrhh.entities.Emp;
import ec.edu.epn.rrhh.entities.Estemp;
import ec.edu.epn.rrhh.entities.Estudio;
import ec.edu.epn.rrhh.entities.Eventocapac;
import ec.edu.epn.rrhh.entities.Familiare;
import ec.edu.epn.rrhh.entities.Genero;
import ec.edu.epn.rrhh.entities.HistoriaEstado;
import ec.edu.epn.rrhh.entities.Nac;
import ec.edu.epn.rrhh.entities.NombTemp;
import ec.edu.epn.rrhh.entities.Partind;
import ec.edu.epn.rrhh.entities.PubliPart;
import ec.edu.epn.rrhh.entities.Tcont;
import ec.edu.epn.rrhh.entities.Tnomb;
import ec.edu.epn.rrhh.entities.Vehiculo;
import ec.edu.epn.seguridad.vo.Usuario;

@Local
public interface EmpleadosService extends DaoGenerico<Emp> {

	List<Emp> findempByParams(String cedula, String apellidos, String nombre);

	List<Emp> findempByParams(String nced, String nombre, String apellido, String codDep, String relacionLaboral);

	List<Familiare> findfamilieares(String cedula);

	List<Estudio> findEstudios(String cedula);

	List<Eventocapac> findCapacitaciones(String cedula);

	List<IdiomasDocente> findIdiomas(String cedula);

	List<ExpProfesExt> findExperieprofeExt(String cedula);

	List<PubliPart> findPublicacionesEMp(String cedula);

	List<TituloFormacionAcademica> findTitulosDocente(String cedula);

	List<Capacitacion> findCapacDocente(String cedula);

	List<Premio> findPremios(String cedula);

	List<AreaConocDocente> findareasDocente(String idusuario);

	List<ActividadDocencia> findactividad(String nced, String nivel);

	List<TesisDirigida> findTesisDir(String nced);

	List<TesisCalificada> findTesisCAlif(String nced);

	List<ActividadProyecto> findActividadProyecto(String nced);

	List<Publicacione> findPublicacion(String nced, String idPublicacion);

	List<ActividadAdministrativa> findActividadAdm(String nced);

	List<ActividadTecnica> findActividadTecnica(String nced);

	List<ActividadExtension> findActividadExtension(String nced);

	List<Capacitacion> findCapcitacionDcita(String nced);

	Usuario finduserLog(Integer idUsuario);

	List<Vehiculo> findVehiculo(String nced,String placa);

	List<Vehiculo> findVehiculo1(String nced);

	List<Vehiculo> findVehiculo2(String nced);

	List<Vehiculo> findVehiculo3(String nced, String placa);

	List<Publicacione> findPublicacionDocente(String nced);

	List<Publicacione> findPublicacionTodas(String nced);

	ActividadProyecto findActividadProyectoDocumento(String idActividad);

	List<Publicacione> findPublicacionIndexasa(String nced, String categoria);

	List<ActividadProyecto> findActividadProyectoCierre(String nced,
			String marca);
	
	List<Emp> listaEmpleadoXCedula(String cedula) throws Exception;

	NombTemp consultarNombramiento(String nced);

	Cont findContratobyCedula(String cedula);

	Partind findbyCodPind(String codpind);

	Dep findDepbyCodigo(String cod_dep);

	Tnomb findTnomByID(String tnom);

	List<Dep> listDepartamentos() throws Exception;

	List<NombTemp> consultarNombramientosHistoria(String nced);

	List<Cont> findContratosHisotiral(String cedula);

	List<Partind> findPartidas();

	List<Tnomb> findTiposNombramiento();

	int consultarIdnombramiento();

	void insertarNombramiento(NombTemp nom);

	List<Tcont> findTipoCOntrato();

	Tcont findTipoCOntratoByCodigo();

	List<Cargosc> findCargosContratoByTipoCOntrato(String tipoCont);

	void insertarContrato(Cont nom);

	List<Ecivil> findestadoCivil();

	List<Clasemp> findClaseEmp();

	List<Genero> findgeneros();

	List<Nac> findNacionalidades();

	void insertarEMP(Emp emp);

	List<Estemp> findestadosEmp();
	
	void updateAccionPersonal(String idaccp, String path);
	
	void updateNombramiento(Integer idnom, String path);

	void updatecONTRATO(String idnom, String path);

	Estemp findEstadoEmp(String codEst);

	Clasemp findClaseEmp(String claseemp);

	List<Publicacione> findPublicacionEmp(String nced,String idtipoPub,String coddep);

	List<String> findCodigosSinRepetir(String idtipoPub, Integer año,String coddep, String autores, String calalog);

	List<Publicacione> findPublicacionesReporte(String codigoPublicacion);

	Emp findEMPbyapelNom(String nom, String apel);

	List<Emp> findEMPBYPARAMS(String nom, String apel, String coddep, String nced);

	List<TipoPublicacion> findAllTipos();

	TipoPublicacion findById(String id);

	int consultarNumeroSerial(int anio, String idtipo, String coddep);

	List<HistoriaEstado> findHistoriaByEmp(String nced);

	int consultarIdhisotrial();

	void insertarHE(HistoriaEstado his);

	NombTemp findNombyID(Integer idnom);

	void modificarNomb(NombTemp nom) throws Exception;

	void borrarNom(NombTemp nom) throws Exception;

	Cont findContID(String idnom);

	void modificarCont(Cont con) throws Exception;

	void borrarCont(Cont con) throws Exception;

	void modificarHist(HistoriaEstado his) throws Exception;

	void borrarhist(HistoriaEstado his) throws Exception;

	List<Publicacione> findPublicacionVIPS(String vips, String idtipoPub);

	List<EmpleadoDTO> findEmpFacDep(String nombreCedulaEmpelado) throws Exception;

	List<Publicacione> findPublicacionVIPSPorAño(String vips, String idtipoPub,
			Integer anio);

	List<ExpProfesExt> listExpProfesionalExterna(String cedula);

	
	
	

}
