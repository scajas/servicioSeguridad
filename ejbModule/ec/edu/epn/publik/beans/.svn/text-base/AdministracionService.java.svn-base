package ec.edu.epn.publik.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.ActividadProyecto;
import ec.edu.epn.gestionDocente.entities.AreaConocimiento;
import ec.edu.epn.gestionDocente.entities.Capacitacion;
import ec.edu.epn.gestionDocente.entities.CategoriasD;
import ec.edu.epn.gestionDocente.entities.DocumentoGD;
import ec.edu.epn.gestionDocente.entities.EmpleadoPublica;
import ec.edu.epn.gestionDocente.entities.ExpProfesExt;
import ec.edu.epn.gestionDocente.entities.Infoactividad;
import ec.edu.epn.gestionDocente.entities.Pais;
import ec.edu.epn.gestionDocente.entities.Patente;
import ec.edu.epn.gestionDocente.entities.Publicacione;
import ec.edu.epn.gestionDocente.entities.Recategorizacion;
import ec.edu.epn.gestionDocente.entities.Recodificacion;
import ec.edu.epn.gestionDocente.entities.Tesissaew;
import ec.edu.epn.gestionDocente.entities.TituloFormacionAcademica;
import ec.edu.epn.publik.entities.PerfilUsuario;
import ec.edu.epn.rrhh.entities.Emp;
import ec.edu.epn.rrhh.entities.EmpExt;
import ec.edu.epn.rrhh.entities.Vehiculo;
import ec.edu.epn.seguridad.vo.Perfil;
import ec.edu.epn.seguridad.vo.Usuario;

@Local
public interface AdministracionService extends DaoGenerico<Usuario>{

	List<Usuario> usuarioExiste(String cedula);

	Perfil buscarperfil(Integer idPerfil);

	List<PerfilUsuario> perfilesUsuario(Integer idUsuario, Integer Idperfil);

	int consultarIdUser();

	void actualizarPassword(Integer idusuario, String password);

	String obtenerCArgo(String cedula);

	int consultarIdVehiculo();

	Emp buscaremp(String nced) throws Exception;

	void insertarVehiculo(Vehiculo auto);

	EmpExt buscarempExterno(String nced) throws Exception;

	void modificarEmp(Emp emp) throws Exception;

	void modificarTitulo(TituloFormacionAcademica titu) throws Exception;

	void modificarpub(Publicacione pub) throws Exception;

	List<DocumentoGD> buscarDocumento(String idPublic) throws Exception;

	int maxIdDocumento();

	void insertarDocumento(DocumentoGD doc);

	void modificarDoc(DocumentoGD doc) throws Exception;

	void modificarProy(ActividadProyecto proy) throws Exception;

	void modificarExp(ExpProfesExt exp) throws Exception;

	List<DocumentoGD> buscarDocumentoExiste(String idPublic, Integer idEstado)
			throws Exception;

	void insertarTesisSAEW(Tesissaew tesis);

	List<Tesissaew> buscarTesisSaew(String cedula,String categoria, String proceso) throws Exception;

	List<Tesissaew> buscarTesisSaewExiste(String cedula, String categoria,
			String proceso, Integer tesis) throws Exception;

	List<TituloFormacionAcademica> buscarTutlosRegSDenescyt(String cedula)
			throws Exception;

	List<Infoactividad> consultarinformes(String cedula, String proceso,
			String categoria, Integer idrecatgoriza);

	int maxInfor();

	void insertarInforme(Infoactividad inf);

	void modificarInfor(Infoactividad emp) throws Exception;

	List<CategoriasD> buscarCategorias(Integer serie) throws Exception;

	CategoriasD buscarCategoriaSELECT(int idcategoria) throws Exception;

	List<Recategorizacion> buscarRecExiste(String nced, String categoria,
			String proceso) throws Exception;

	int maxCodRecategorizacion();

	void insertarRecategorizacion(Recategorizacion rec);

	void modificarTesis(Tesissaew te) throws Exception;

	List<TituloFormacionAcademica> buscarTutlosRegSDenescytRevaloriza(
			String cedula) throws Exception;

	List<Publicacione> findPublicacionIndexasa(String nced, String categoria);

	List<Patente> buscarpatentesRel(String nced, String clase) throws Exception;

	List<ActividadProyecto> findActividadProyectoCierre(String nced,
			String marca);

	List<ExpProfesExt> findExperieprofeExt(String cedula);

	void modificarRecategorizacion(Recategorizacion rec) throws Exception;

	List<Patente> buscarpatentesRel1(String nced, String clase)
			throws Exception;

	void modificarPatente(Patente pat) throws Exception;

	List<Capacitacion> buscarCapacitacionesDocente(String cedula,
			String valida) throws Exception;

	void modificarCapacitacion(Capacitacion cap) throws Exception;

	List<ActividadProyecto> findActividadProyectoCierreRec(String nced,
			String marca);

	List<TituloFormacionAcademica> buscarTutlosRegSDenescytRevalorizarec(
			String cedula) throws Exception;

	List<Publicacione> findPublicacionIndexasaRec(String nced, String categoria);

	List<Patente> buscarpatentesRelrec(String nced, String clase)
			throws Exception;

	List<ExpProfesExt> findExperieprofeExtRec(String cedula);

	List<Recategorizacion> buscarRecExisteccOM(String nced, String categoria,
			String proceso) throws Exception;

	List<Recategorizacion> buscarRecExistConsejo(String nced, String categoria,
			String proceso) throws Exception;

	List<Recategorizacion> buscarRecReporte(String nced, String categoria,
			String proceso, String estado) throws Exception;

	List<Emp> buscarEmpRev(String proceso) throws Exception;

	List<AreaConocimiento> finaAllAreas() throws Exception;

	AreaConocimiento buscarAreaByID(String cod) throws Exception;

	void insertarPublicacion(Publicacione pub);

	Publicacione buscarPubByID(String cod) throws Exception;

	void insertarEMpleadoPublica(EmpleadoPublica emp);

	int maxIDEmpleadoPublica();

	List<EmpleadoPublica> finaAutoresporPublicacion(String tipo, Integer Idpub)
			throws Exception;

	List<EmpleadoPublica> finaAutoresporPublicacionExiste(String tipo,
			String nced, Integer idpub) throws Exception;

	List<Pais> findAllPais() throws Exception;

	void borrarEmpP(EmpleadoPublica EmpP) throws Exception;

	int consultarIdRecodifica();

	void insertarRecodificación(Recodificacion emp);

	List<String> finaAutoresporPublicacionReporte(String tipo)
			throws Exception;

	List<ExpProfesExt> listExpProfesionalExtNoDocente(String cedula);

	List<ExpProfesExt> listExpProfExtNoDocenteRecat(String cedula);
	
	
	

}
