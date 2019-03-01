package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;


import ec.edu.epn.catalogos.entities.Departamento;
import ec.edu.epn.catalogos.entities.LineasInvestigacion;

import ec.edu.epn.proyectos.entities.ActividadProyectoP;
import ec.edu.epn.proyectos.entities.Auspiciante;
import ec.edu.epn.proyectos.entities.AuspicianteProyecto;
import ec.edu.epn.proyectos.entities.Convocatoria;
import ec.edu.epn.proyectos.entities.Cronograma;
import ec.edu.epn.proyectos.entities.Entregable;
import ec.edu.epn.proyectos.entities.EstadoProyecto;

import ec.edu.epn.proyectos.entities.HistoriaEstadoP;
import ec.edu.epn.proyectos.entities.ItemP;
import ec.edu.epn.proyectos.entities.Lineasproy;
import ec.edu.epn.proyectos.entities.Miembro;
import ec.edu.epn.proyectos.entities.ObjetivoProyecto;
import ec.edu.epn.proyectos.entities.ObservacionProyecto;
import ec.edu.epn.proyectos.entities.Parametro;
import ec.edu.epn.proyectos.entities.Presupuesto;

import ec.edu.epn.proyectos.entities.ProyectoP;
import ec.edu.epn.proyectos.entities.RecursohPr;

import ec.edu.epn.proyectos.entities.ResultadoP;

import ec.edu.epn.proyectos.entities.RolProyectoP;
import ec.edu.epn.proyectos.entities.SeguimientoPr;
import ec.edu.epn.proyectos.entities.TipoActividad;
import ec.edu.epn.proyectos.entities.TipoObjetivo;

import ec.edu.epn.proyectos.entities.TipoProyectoP;
import ec.edu.epn.rrhh.entities.Dep;
import ec.edu.epn.rrhh.entities.Emp;

@Local
public interface ProyectoService {

	int consultarIdProy();

	List<TipoProyectoP> findTipoProy();

	TipoProyectoP buscarProy(Integer idProy) throws Exception;

	List<Departamento> findDept();

	Departamento dept(Integer iddetp) throws Exception;

	List<LineasInvestigacion> findlinInv(Integer iddept);

	LineasInvestigacion finLininv(Integer idlininv) throws Exception;

	List<Convocatoria> findconv();

	Convocatoria finconv(String idconv) throws Exception;

	Emp empleado(String cedula) throws Exception;

	void insertarProyecto(ProyectoP proyecto) throws Exception;

	List<ProyectoP> findproybyUser(String cedula);

	List<TipoObjetivo> finObjetProys();

	TipoObjetivo fintipoObj(Integer idtipo_obj) throws Exception;

	Integer consultarIdObje_Proy();

	void insertarObjetivoProyecto(ObjetivoProyecto objetivo_proy)
			throws Exception;

	List<ObjetivoProyecto> findObjetivosproyec(Integer idproy);

	List<RecursohPr> findrecProy(Integer idproy);

	List<RolProyectoP> findrolproy();

	RolProyectoP finrolproy(Integer idRol) throws Exception;

	List<Emp> findempByParams(String cedula, String apellidos, String nombre);

	Integer consultarIdRec_Proy();

	void insertarrecursoProyecto(RecursohPr recurso_proy) throws Exception;

	List<AuspicianteProyecto> findAuspProy(Integer idproy);

	Integer consultarIdAus();

	void insertarAuspicienta(AuspicianteProyecto aus) throws Exception;

	EstadoProyecto estod(int idEstado) throws Exception;

	int consultarIdHistoriaEstado();

	void insertarHistoriaestado(HistoriaEstadoP hisEs) throws Exception;

	HistoriaEstadoP histPory(int idProy) throws Exception;

	void updateProy(ProyectoP proy) throws Exception;

	void editarObjetivoProyecto(ObjetivoProyecto objetivo_proy)
			throws Exception;

	void editarAuspicienta(AuspicianteProyecto aus) throws Exception;

	void editarecursoProyecto(RecursohPr recurso_proy) throws Exception;

	void borrarObjetivo(ObjetivoProyecto objetivo_proy);

	void eliminarecursoProyecto(RecursohPr recurso_proy) throws Exception;

	void eliminarAuspicienta(AuspicianteProyecto aus) throws Exception;

	int consultaridObserProy();

	List<ProyectoP> findproybyUserestado(String cedula, String estado);

	List<ObservacionProyecto> findObservaProyNo(int idProyecto);

	ObservacionProyecto finobsProy(int idobs) throws Exception;



	void borrarObservacionNo(ObservacionProyecto obsd);

	List<ObservacionProyecto> findObservaProy(int idProyecto);

	List<ObservacionProyecto> findObservaProySI(int idProyecto);

	List<ActividadProyectoP> findActProy(Integer idproy);

	RecursohPr finrecProy(Integer idrecur);

	

	List<TipoActividad> findtiposASct();

	TipoActividad finTip(Integer idTip);

	int consultarIdActiProy();

	void insertarActproy(ActividadProyectoP actividad) throws Exception;



	List<ActividadProyectoP> findActProyExuste(Integer idproy, String nombreact,
			String partiipacion);

	List<SeguimientoPr> findSegAct(Integer idact);

	int consultarIdSeg();

	int consultarMaxPorcAvance(Integer idact);

	void insertarSegActr(SeguimientoPr seg) throws Exception;

	void updateActproy(ActividadProyectoP actividad) throws Exception;

	List<SeguimientoPr> findSegActExite100(Integer idact);

	Long calcularTotalhoras(int idact);

	Double calcularDineroFavor(int idproy, String estadopresup);

	Integer consultarIdEntrega();

	void ingresarEntregable(Entregable entr) throws Exception;

	List<Entregable> findentragableprpoy(int idProyecto);

	void insertPublicacionDocente(ec.edu.epn.gestionDocente.entities.Publicacione publicaciones);

	Double calcularDineroEsperado(int idproy);

	Double calcularDineroreal(int idproy);

	List<ObjetivoProyecto> findObjetivosproyecExiste(Integer idproy,
			Integer idObj);

	void updateSegActr(SeguimientoPr seg) throws Exception;

	Double calcularTotalExtras(int idact);

	List<Auspiciante> findAuspByParams(String nombre, String cargo,
			String Institucion);

	List<ResultadoP> findResult(Integer idproy);

	Integer consultarIdresult();

	void insertarResultado(ResultadoP res) throws Exception;

	void eliminarresultado(ResultadoP res) throws Exception;

	void editarResultado(ResultadoP res) throws Exception;

	RecursohPr findDirector(int idProyecto);

	List<ProyectoP> findproyestado(String estado);

	ProyectoP buscarProyecto(Integer idProy) throws Exception;

	int consultarNumeroSerial(int anio, int idtipo);

	List<Cronograma> findCornograma(Integer idProyecto, int anio);

	List<Presupuesto> findPresupuesto(Integer idProyecto, int anio);

	List<ItemP> findItems();

	int consultarIdCoronograma();

	void insertarCronograma(Cronograma cr) throws Exception;

	void eliminarCronograma(Cronograma cr) throws Exception;

	ItemP buscarItem(Integer iditem) throws Exception;

	int consultarIdPrepsupuesto();

	void insertarPresupuesto(Presupuesto cr) throws Exception;

	void eliminarPresupuesto(Presupuesto cr) throws Exception;

	List<Presupuesto> findPresupuestoExiste(Integer idProyecto, int anio,
			int iditem);

	List<RecursohPr> findrecProyExiste(Integer idproy, Integer idtipoRec);

	Double calcularTotalPryActr(int idproy, int anio);

	void editarPresupuesto(Presupuesto cr) throws Exception;

	RecursohPr findrecFirma(Integer idproy, int idRec);

	List<ActividadProyectoP> findActProyTotales(Integer idproy, Integer clase);

	ActividadProyectoP findTotalesAct(Integer idproy, Integer clase,
			Integer serial);

	int consultarIdActiProySerial(Integer idproy);

	List<SeguimientoPr> findSegActExiteMes(Integer idact, Integer mes);

	Double calcularTotalAvanceAcumulado(int idproyecto);

	Double calcularTotalAvanceMes(int idproyecto, Integer mes);

	void eliminarSeguimiento(SeguimientoPr seg) throws Exception;

	void updateCrono(Cronograma actividad) throws Exception;

	Double calcularTotalfinPory(int idproy, int anio);

	void eliminarMiembro(Miembro cr) throws Exception;

	List<Parametro> getParametros(Integer serial);

	void insertParamentro(Parametro aus);

	void eliminarParamentro(Parametro aus) throws Exception;

	void insertarLin(Lineasproy lin) throws Exception;

	

	void eliminarLin(Lineasproy lin) throws Exception;

	int consultarIdLin();

	List<Lineasproy> findLineasProy(Integer idProyect);

	List<ProyectoP> findproybyDepat(String cedula, String estado);

	Dep departamento(String codddep) throws Exception;

	List<ProyectoP> findproyectos(String coddep, String nombre, String cedula);

	List<HistoriaEstadoP> findhistorias(Integer idProyecto);

	void eliminarEstado(HistoriaEstadoP hist) throws Exception;

	void eliminarProyecto(ProyectoP pr) throws Exception;

	List<RecursohPr> findrecProyExisteRG(Integer idproy, String nced,
			String codTesis);

	List<String> findRecDirectorCedula();

	List<LineasInvestigacion> findAllLineas();

	List<RecursohPr> findRecDirector(String cedula);

	List<ProyectoP> findproyectosReporte(Integer idtipo, String area,
			String codigo, Integer idlinea, String coddep, String cedula,
			String estado, Integer anio);

	ProyectoP buscarProyectoPornombre(String nombre) throws Exception;

	List<RecursohPr> buscarRecursoExisteCedula(String nced, Integer idproy) throws Exception;

	List<LineasInvestigacion> findlinInvAntiguas(Integer iddept);

	List<ProyectoP> buscarProyectoExiste(String codigo) throws Exception;

	List<String> findRecCedulas();

	List<String> findRecDsitinct();

	RecursohPr findDirectorVinculado(int idProyecto);

	

	

}
