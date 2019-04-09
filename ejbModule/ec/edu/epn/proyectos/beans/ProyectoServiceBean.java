package ec.edu.epn.proyectos.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.epn.gestioDocente.beans.*;
import ec.edu.epn.gestionDocente.entities.Publicacione;
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
import ec.edu.epn.rrhh.entities.HistoriaEstado;

/**
 * Session Bean implementation class ProyectoPServiceBean
 */
@Stateless
public class ProyectoServiceBean   implements ProyectoService {

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	// ////////////////////////////////////////////////////////////////
	@Override
	public List<TipoProyectoP> findTipoProy() {
		StringBuilder queryString = new StringBuilder(
				"select tp from TipoProyectoP tp order by tp.orden");
		Query query = getEntityManager().createQuery(queryString.toString());
		System.out.println("Consultado TiposProy");
		return query.getResultList();
	}

	@Override
	public List<ProyectoP> findproybyUser(String cedula) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select pr from ProyectoP pr where pr.nced = ?1 order by pr.codigoPr ");
		qUsuario.setParameter(1, cedula);
		return qUsuario.getResultList();

	}

	@Override
	public List<ProyectoP> findproyectos(String coddep, String nombre,
			String cedula) {

		StringBuilder queryString = new StringBuilder(
				"select pr from ProyectoP pr ");

		if (cedula != null) {
			queryString.append(" ,RecursohPr rp   ");
		}

		queryString.append(" where pr.estado like ?0 ");

		if (cedula != null) {
			queryString.append(" and rp.proyecto.idProy = pr.idProy   ");
		}

		if (coddep != null) {
			queryString.append(" and pr.codigoPr  = ?1 ");
		}

		if (nombre != null) {
			queryString.append(" and pr.nombrePr  like ?2 ");
		}

		if (cedula != null) {
			queryString.append(" and rp.nced = ?3   ");
		}

		queryString.append(" order by pr.codigoPr ");

		Query qUsuario = getEntityManager().createQuery(queryString.toString());

		qUsuario.setParameter(0, "%");

		if (coddep != null) {
			qUsuario.setParameter(1, coddep);
		}

		if (nombre != null) {
			qUsuario.setParameter(2, "%" + nombre + "%");
		}

		if (cedula != null) {
			qUsuario.setParameter(3, cedula);
		}

		return qUsuario.getResultList();

	}

	@Override
	public List<ProyectoP> findproybyDepat(String codDept, String estado) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select pr from ProyectoP pr where pr.coddep = ?1 and pr.estado like ?2 order by pr.codigoPr  ");
		qUsuario.setParameter(1, codDept);
		qUsuario.setParameter(2, "%" + estado + "%");
		return qUsuario.getResultList();

	}

	@Override
	public List<ProyectoP> findproybyUserestado(String cedula, String estado) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select pr from ProyectoP pr where pr.nced = ?1  and pr.estado = ?2  order by pr.codigoPr ");
		qUsuario.setParameter(1, cedula);
		qUsuario.setParameter(2, estado.trim());

		return qUsuario.getResultList();

	}

	@Override
	public List<ProyectoP> findproyestado(String estado) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select pr from ProyectoP pr where pr.estado = ?2  order by pr.codigoPr ");

		qUsuario.setParameter(2, estado.trim());

		return qUsuario.getResultList();

	}

	@Override
	public List<ObservacionProyecto> findObservaProyNo(int idProyectoP) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select obs from ObservacionProyectoP obs where obs.investigadorObservacione.proyecto.idProy = ?1  and obs.estado like ?2 ");
		qUsuario.setParameter(1, idProyectoP);
		qUsuario.setParameter(2, "%NO%");
		return qUsuario.getResultList();

	}

	@Override
	public List<ObservacionProyecto> findObservaProySI(int idProyectoP) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select obs from ObservacionProyectoP obs where obs.investigadorObservacione.proyecto.idProy = ?1  and obs.estado like ?2 ");
		qUsuario.setParameter(1, idProyectoP);
		qUsuario.setParameter(2, "%SI%");
		return qUsuario.getResultList();

	}

	@Override
	public List<ObservacionProyecto> findObservaProy(int idProyectoP) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select obs from ObservacionProyectoP obs where obs.investigadorObservacione.proyecto.idProy = ?1   ");
		qUsuario.setParameter(1, idProyectoP);

		return qUsuario.getResultList();

	}

	@Override
	public RecursohPr findDirector(int idProyectoP) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select reh from RecursohPr reh where reh.proyecto.idProy = ?1  and reh.rolProyecto.idRolProy = ?2 ");
		qUsuario.setParameter(1, idProyectoP);
		qUsuario.setParameter(2, 1);

		try {
			RecursohPr r = (RecursohPr) qUsuario.getSingleResult();

			return r;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public List<Entregable> findentragableprpoy(int idProyectoP) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select ent from Entregable ent where ent.proyecto.idProy = ?1   ");
		qUsuario.setParameter(1, idProyectoP);

		return qUsuario.getResultList();

	}

	@Override
	public List<Departamento> findDept() {
		StringBuilder queryString = new StringBuilder(
				"select dep from DepartamentoCatalogo dep order by dep.nomDepart");
		Query query = getEntityManager().createQuery(queryString.toString());
		System.out.println("Consultado departamentos");
		return query.getResultList();
	}

	@Override
	public List<Convocatoria> findconv() {
		StringBuilder queryString = new StringBuilder(
				"select conv from Convocatoria conv");
		Query query = getEntityManager().createQuery(queryString.toString());
		System.out.println("Consultado convocatorias");
		return query.getResultList();
	}

	@Override
	public List<TipoObjetivo> finObjetProys() {
		StringBuilder queryString = new StringBuilder(
				"select objtp from TipoObjetivo objtp");
		Query query = getEntityManager().createQuery(queryString.toString());
		System.out.println("Consultado Objetivos");
		return query.getResultList();
	}

	@Override
	public void insertPublicacionDocente(Publicacione publicaciones) {

		getEntityManager().persist(publicaciones);

	}

	// @Override
	// public List<RolProyectoP> findrolproy() {
	//
	// List<String> ids = new ArrayList<String>();
	// ids.add("Investigador");
	// ids.add("Colaborador");
	// ids.add("Miembro");
	//
	// Query q =
	// em.createQuery("select rol from RolProyectoP rol where rol.rolProy IN :list ORDER BY rol.idRolProy");
	// q.setParameter("list", ids);
	// return q.getResultList();
	// }

	@Override
	public List<RolProyectoP> findrolproy() {

		Query q = em
				.createQuery("select rol from RolProyectoP rol  ORDER BY rol.idRolProy");

		return q.getResultList();
	}

	@Override
	public Convocatoria finconv(String idconv) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select conv from Convocatoria conv where conv.idConv = ?1");
		qUsuario.setParameter(1, idconv);
		return (Convocatoria) qUsuario.getSingleResult();

	}

	@Override
	public ObservacionProyecto finobsProy(int idobs) throws Exception {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select obs from ObservacionProyectoP obs where obs.idObservacion = ?1");
		qUsuario.setParameter(1, idobs);
		return (ObservacionProyecto) qUsuario.getSingleResult();

	}

	@Override
	public TipoObjetivo fintipoObj(Integer idtipo_obj) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select tobj from TipoObjetivo tobj where tobj.idTipoObj = ?1");
		qUsuario.setParameter(1, idtipo_obj);
		return (TipoObjetivo) qUsuario.getSingleResult();

	}

	@Override
	public RolProyectoP finrolproy(Integer idRol) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select rol from RolProyectoP rol where rol.idRolProy = ?1");
		qUsuario.setParameter(1, idRol);
		return (RolProyectoP) qUsuario.getSingleResult();

	}

	@Override
	public TipoProyectoP buscarProy(Integer idProy) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select tp from TipoProyectoP tp WHERE tp.idTipoProy = ?1");
		qUsuario.setParameter(1, idProy);
		return (TipoProyectoP) qUsuario.getSingleResult();
	}

	@Override
	public Departamento dept(Integer iddetp) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select dep from DepartamentoCatalogo dep WHERE dep.idDepart = ?1");
		qUsuario.setParameter(1, iddetp);
		return (Departamento) qUsuario.getSingleResult();
	}

	@Override
	public Emp empleado(String cedula) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select emp from Emp emp WHERE emp.nced = ?1");
		qUsuario.setParameter(1, cedula.trim());
		return (Emp) qUsuario.getSingleResult();

	}

	@Override
	public Dep departamento(String codddep) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select dep from Dep dep WHERE dep.codDep = ?1");
		qUsuario.setParameter(1, codddep.trim());
		return (Dep) qUsuario.getSingleResult();

	}

	@Override
	public ProyectoP buscarProyecto(Integer idProy) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select tp from ProyectoP tp WHERE tp.idProy = ?1");
		qUsuario.setParameter(1, idProy);
		return (ProyectoP) qUsuario.getSingleResult();

	}

	@Override
	public List<ProyectoP> buscarProyectoExiste(String codigo) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select tp from ProyectoP tp WHERE tp.codigoPr = ?1");
		qUsuario.setParameter(1, codigo);
		return qUsuario.getResultList();

	}

	@Override
	public ProyectoP buscarProyectoPornombre(String nombre) throws Exception {

		Query qUsuario = getEntityManager().createQuery(
				"select tp from ProyectoP tp WHERE tp.nombrePr = ?1");
		qUsuario.setParameter(1, nombre);

		try {
			ProyectoP r = (ProyectoP) qUsuario.getSingleResult();

			return r;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public EstadoProyecto estod(int idEstado) throws Exception {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select estp from EstadoProyectoP estp WHERE estp.idEstado = ?1");
		qUsuario.setParameter(1, idEstado);
		return (EstadoProyecto) qUsuario.getSingleResult();

	}

	@Override
	public HistoriaEstadoP histPory(int idProy) throws Exception {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select hist from HistoriaEstado hist WHERE hist.proyecto.idProy = ?1");
		qUsuario.setParameter(1, idProy);
		return (HistoriaEstadoP) qUsuario.getSingleResult();

	}

	@Override
	public LineasInvestigacion finLininv(Integer idlininv) throws Exception {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select linv from LineasInvestigacion linv where linv.idLinin = ?1");
		qUsuario.setParameter(1, idlininv);
		return (LineasInvestigacion) qUsuario.getSingleResult();

	}

	@Override
	public RecursohPr finrecProy(Integer idrecur) {
		Query qUsuario = getEntityManager().createQuery(
				"select rec from RecursohPr rec where rec.idRhPr = ?1");
		qUsuario.setParameter(1, idrecur);
		return (RecursohPr) qUsuario.getSingleResult();

	}

	@Override
	public TipoActividad finTip(Integer idTip) {
		Query qUsuario = getEntityManager().createQuery(
				"select tp from TipoActividad tp where tp.idTipoAct = ?1");
		qUsuario.setParameter(1, idTip);
		return (TipoActividad) qUsuario.getSingleResult();

	}

	@Override
	public void insertarProyecto(ProyectoP ProyectoP) throws Exception {
		getEntityManager().persist(ProyectoP);
	}

	@Override
	public void insertarActproy(ActividadProyectoP actividad) throws Exception {
		getEntityManager().persist(actividad);
	}

	@Override
	public void updateActproy(ActividadProyectoP actividad) throws Exception {
		getEntityManager().merge(actividad);
	}

	@Override
	public void insertarSegActr(SeguimientoPr seg) throws Exception {
		getEntityManager().persist(seg);
	}

	@Override
	public void updateSegActr(SeguimientoPr seg) throws Exception {
		getEntityManager().merge(seg);
	}

	@Override
	public void insertarObjetivoProyecto(ObjetivoProyecto objetivo_proy)
			throws Exception {
		getEntityManager().persist(objetivo_proy);
	}

	@Override
	public void editarObjetivoProyecto(ObjetivoProyecto objetivo_proy)
			throws Exception {
		getEntityManager().merge(objetivo_proy);
	}

	@Override
	public void ingresarEntregable(Entregable entr) throws Exception {
		getEntityManager().persist(entr);
	}

	@Override
	public void insertarrecursoProyecto(RecursohPr recurso_proy)
			throws Exception {
		getEntityManager().persist(recurso_proy);
	}

	@Override
	public void editarecursoProyecto(RecursohPr recurso_proy) throws Exception {
		getEntityManager().merge(recurso_proy);
	}

	@Override
	public void editarResultado(ResultadoP res) throws Exception {
		getEntityManager().merge(res);
	}

	@Override
	public void eliminarecursoProyecto(RecursohPr recurso_proy)
			throws Exception {
		getEntityManager().remove(getEntityManager().merge(recurso_proy));
	}

	@Override
	public void insertarAuspicienta(AuspicianteProyecto aus) throws Exception {
		getEntityManager().persist(aus);
	}

	@Override
	public void insertarResultado(ResultadoP res) throws Exception {
		getEntityManager().persist(res);
	}

	@Override
	public void editarAuspicienta(AuspicianteProyecto aus) throws Exception {
		getEntityManager().merge(aus);
	}

	@Override
	public void eliminarAuspicienta(AuspicianteProyecto aus) throws Exception {
		getEntityManager().remove(getEntityManager().merge(aus));
	}

	@Override
	public void eliminarresultado(ResultadoP res) throws Exception {
		getEntityManager().remove(getEntityManager().merge(res));
	}

	@Override
	public void insertarHistoriaestado(HistoriaEstadoP hisEs) throws Exception {
		getEntityManager().persist(hisEs);
	}

	@Override
	public void updateProy(ProyectoP proy) throws Exception {
		getEntityManager().merge(proy);
	}

	@Override
	public List<LineasInvestigacion> findlinInv(Integer iddept) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select linv from LineasInvestigacion linv where linv.departamento.idDepart = ?1  and linv.estLinea = ?2   order by linv.nomLinin ");
		qUsuario.setParameter(1, iddept);
		qUsuario.setParameter(2, "A");
		return qUsuario.getResultList();

	}

	@Override
	public List<LineasInvestigacion> findlinInvAntiguas(Integer iddept) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select linv from LineasInvestigacion linv where linv.departamento.idDepart = ?1  order by linv.nomLinin ");
		qUsuario.setParameter(1, iddept);

		return qUsuario.getResultList();

	}

	@Override
	public List<ObjetivoProyecto> findObjetivosproyec(Integer idproy) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select objproy from ObjetivoProyecto objproy where objproy.proyecto.idProy = ?1");
		qUsuario.setParameter(1, idproy);
		return qUsuario.getResultList();

	}

	@Override
	public List<ObjetivoProyecto> findObjetivosproyecExiste(Integer idproy,
			Integer idObj) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select objproy from ObjetivoProyecto objproy where objproy.proyecto.idProy = ?1 and objproy.tipoObjetivo.idTipoObj = ?2");
		qUsuario.setParameter(1, idproy);
		qUsuario.setParameter(2, idObj);
		return qUsuario.getResultList();

	}

	@Override
	public List<AuspicianteProyecto> findAuspProy(Integer idproy) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select ausp from AuspicianteProyectoP ausp where ausp.proyecto.idProy = ?1");
		qUsuario.setParameter(1, idproy);
		return qUsuario.getResultList();

	}

	@Override
	public List<ResultadoP> findResult(Integer idproy) {
		Query qUsuario = getEntityManager().createQuery(
				"select res from Resultado res where res.proyecto.idProy = ?1");
		qUsuario.setParameter(1, idproy);
		return qUsuario.getResultList();

	}

	@Override
	public List<RecursohPr> findrecProy(Integer idproy) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select rec from RecursohPr rec where rec.proyecto.idProy = ?1 order by rec.estadoPr DESC ,rec.rolProyecto.idRolProy  ");
		qUsuario.setParameter(1, idproy);
		return qUsuario.getResultList();

	}

	@Override
	public List<TipoActividad> findtiposASct() {
		Query qUsuario = getEntityManager().createQuery(
				"select tp from TipoActividad tp  ");

		return qUsuario.getResultList();

	}

	@Override
	public List<ActividadProyectoP> findActProy(Integer idproy) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select act from ActividadProyectoP act where act.proyecto.idProy = ?1 and act.clase = ?2 order by act.idActPr ");
		qUsuario.setParameter(1, idproy);
		qUsuario.setParameter(2, 1);
		return qUsuario.getResultList();

	}

	@Override
	public List<SeguimientoPr> findSegAct(Integer idact) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select seg from SeguimientoPr seg where seg.actividadProyectoP.idActPr = ?1");
		qUsuario.setParameter(1, idact);
		return qUsuario.getResultList();

	}

	@Override
	public List<SeguimientoPr> findSegActExiteMes(Integer idact, Integer mes) {

		Query qUsuario = getEntityManager()
				.createQuery(
						"select seg from SeguimientoPr seg where seg.actividadProyectoP.idActPr = ?1 and seg.mes = ?2");
		qUsuario.setParameter(1, idact);
		qUsuario.setParameter(2, mes);
		return qUsuario.getResultList();

	}

	@Override
	public List<ActividadProyectoP> findActProyExuste(Integer idproy,
			String nombreact, String partiipacion) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select act from ActividadProyectoP act where act.proyecto.idProy = ?1 and act.nomActividad like ?2 and act.participacion like ?3  order by act.idActPr");
		qUsuario.setParameter(1, idproy);
		qUsuario.setParameter(2, "%" + nombreact + "%");
		qUsuario.setParameter(3, "%" + partiipacion + "%");
		return qUsuario.getResultList();

	}

	@Override
	public List<ActividadProyectoP> findActProyTotales(Integer idproy,
			Integer clase) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select act from ActividadProyectoP act where act.proyecto.idProy = ?1 and act.clase = ?2 ");
		qUsuario.setParameter(1, idproy);
		qUsuario.setParameter(2, clase);

		return qUsuario.getResultList();

	}

	@Override
	public ActividadProyectoP findTotalesAct(Integer idproy, Integer clase,
			Integer serial) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select act from ActividadProyectoP act where act.proyecto.idProy = ?1 and act.clase = ?2  and act.serial = ?3 ");
		qUsuario.setParameter(1, idproy);
		qUsuario.setParameter(2, clase);
		qUsuario.setParameter(3, serial);

		return (ActividadProyectoP) qUsuario.getSingleResult();

	}

	@Override
	public int consultarIdSeg() {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(seg.idSegPr)FROM SeguimientoPr seg");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public Long calcularTotalhoras(int idact) {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager()
				.createQuery(
						"SELECT SUM(seg.horasDedi)FROM SeguimientoPr seg where seg.actividadProyectoP.idActPr = ?1 ");
		q.setParameter(1, idact);

		Long idReq = null;

		idReq = (Long) q.setMaxResults(1).getSingleResult();
		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public Double calcularTotalExtras(int idact) {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager()
				.createQuery(
						"SELECT SUM(seg.costoadicional)FROM SeguimientoPr seg where seg.actividadProyectoP.idActPr = ?1 ");
		q.setParameter(1, idact);

		Double idReq = null;

		idReq = (Double) q.setMaxResults(1).getSingleResult();
		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public Double calcularTotalAvanceAcumulado(int idProyectoP) {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager()
				.createQuery(
						"SELECT SUM(act.avanceacu)FROM ActividadProyectoP act where act.proyecto.idProy = ?1 and act.clase = ?2");
		q.setParameter(1, idProyectoP);
		q.setParameter(2, 1);

		Double idReq = null;

		idReq = (Double) q.setMaxResults(1).getSingleResult();
		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public Double calcularTotalAvanceMes(int idProyectoP, Integer mes) {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager()
				.createQuery(
						"SELECT SUM(seg.valor)FROM SeguimientoPr seg where seg.actividadProyectoP.proyecto.idProy = ?1 and seg.mes = ?2");
		q.setParameter(1, idProyectoP);
		q.setParameter(2, mes);

		Double idReq = null;

		idReq = (Double) q.setMaxResults(1).getSingleResult();
		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public Double calcularDineroFavor(int idproy, String estadopresup) {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager()
				.createQuery(
						"SELECT SUM(act.costoextra)FROM ActividadProyectoP act where act.proyecto.idProy = ?1 and act.estadopresupuesto like ?2");
		q.setParameter(1, idproy);
		q.setParameter(2, "%" + estadopresup + "%");

		Double idReq = null;

		idReq = (Double) q.setMaxResults(1).getSingleResult();
		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public Double calcularDineroEsperado(int idproy) {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager()
				.createQuery(
						"SELECT SUM(act.costototal)FROM ActividadProyectoP act where act.proyecto.idProy = ?1 ");
		q.setParameter(1, idproy);

		Double idReq = null;

		idReq = (Double) q.setMaxResults(1).getSingleResult();
		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public Double calcularDineroreal(int idproy) {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager()
				.createQuery(
						"SELECT SUM(act.costorealact)FROM ActividadProyectoP act where act.proyecto.idProy = ?1 ");
		q.setParameter(1, idproy);

		Double idReq = null;

		idReq = (Double) q.setMaxResults(1).getSingleResult();
		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public int consultarMaxPorcAvance(Integer idact) {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager()
				.createQuery(
						"SELECT MAX(seg.avanceAct)FROM SeguimientoPr seg where seg.actividadProyectoP.idActPr = ?1");
		q.setParameter(1, idact);

		Integer idReq = null;

		idReq = (Integer) q.setMaxResults(1).getSingleResult();

		if (idReq == null) {
			idReq = 0;

		}

		return idReq;

	}

	@Override
	public int consultarIdProy() {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(pr.idProy)FROM ProyectoP pr");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public int consultarNumeroSerial(int anio, int idtipo) {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(pr.serial)FROM ProyectoP pr"
						+ " where anio =?1 and pr.tipoProyecto.idTipoProy =?2 "
						+ "");

		Integer idReq = null;
		q.setParameter(1, anio);
		q.setParameter(2, idtipo);

		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public Integer consultarIdObje_Proy() {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(objProy.idObjproy)FROM ObjetivoProyecto objProy");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public Integer consultarIdEntrega() {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(ent.idEntregable)FROM Entregable ent");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public Integer consultarIdresult() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(res.idResultado)FROM Resultado res");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public Integer consultarIdAus() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(aus.idAusPry)FROM AuspicianteProyectoP aus");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public Integer consultarIdRec_Proy() {
		System.out.println("Entraaaaaaa ConsultarID");

		Query q = getEntityManager().createQuery(
				"SELECT MAX(recP.idRhPr)FROM RecursohPr recP");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public int consultarIdHistoriaEstado() {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(hp.idHp)FROM HistoriaEstado hp");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public int consultarIdActiProy() {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(act.idActPr)FROM ActividadProyectoP act");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public int consultarIdActiProySerial(Integer idproy) {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager()
				.createQuery(
						"SELECT MAX(act.serial)FROM ActividadProyectoP act where act.proyecto.idProy = ?1");

		q.setParameter(1, idproy);
		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public int consultaridObserProy() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(obs.idObservacion)FROM ObservacionProyectoP obs");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> findempByParams(String cedula, String apellidos,
			String nombre) {

		System.out.println("apellidos" + cedula);
		System.out.println("nombres" + nombre);
		System.out.println("apellidos" + apellidos);
		System.out.println("Entraaaaaaaaa la consulta de la busquedaaaaaaaaaa");

		StringBuilder queryString = new StringBuilder(
				"SELECT emp FROM Emp emp where emp.nced like ?0 ");

		if (apellidos != null) {
			queryString.append(" AND emp.apel like ?1 ");
		}

		if (nombre != null) {
			queryString.append(" AND emp.nom like ?2 ");
		}

		queryString.append("ORDER BY emp.apel ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, cedula);

		if (apellidos != null) {
			query.setParameter(1, "%" + apellidos.toUpperCase() + "%");
		}
		if (nombre != null) {
			query.setParameter(2, "%" + nombre.toUpperCase() + "%");
		}

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Auspiciante> findAuspByParams(String nombre, String cargo,
			String Institucion) {

		System.out.println("Entraaaaaaaaa la consulta de la busquedaaaaaaaaaa");

		StringBuilder queryString = new StringBuilder(
				"SELECT aus FROM Auspiciante aus where aus.nombreAuspiciante like ?0 ");

		if (cargo != null) {
			queryString.append(" AND aus.cargoAuspiciante like ?1 ");
		}

		if (Institucion != null) {
			queryString.append(" AND aus.institucionAuspiciante like ?2 ");
		}

		queryString.append("ORDER BY aus.nombreAuspiciante ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + nombre + "%");

		if (cargo != null) {
			query.setParameter(1, "%" + cargo + "%");
		}
		if (Institucion != null) {
			query.setParameter(2, "%" + Institucion + "%");
		}

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}

	@Override
	public void borrarObjetivo(ObjetivoProyecto objetivo_proy) {
		getEntityManager().remove(getEntityManager().merge(objetivo_proy));
	}

	@Override
	public void borrarObservacionNo(ObservacionProyecto obsd) {
		getEntityManager().remove(getEntityManager().merge(obsd));
	}

	// Nuevo Metodos de ProyectoPs

	@Override
	public List<Cronograma> findCornograma(Integer idProyectoP, int anio) {
		Query qUsuario = getEntityManager().createQuery(
				"select cr from Cronograma cr where cr.proyecto.idProy = ?1"
						+ " and cr.anio = ?2 order by cr.idCronograma");
		qUsuario.setParameter(1, idProyectoP);
		qUsuario.setParameter(2, anio);
		return qUsuario.getResultList();

	}

	@Override
	public List<Presupuesto> findPresupuesto(Integer idProyectoP, int anio) {
		Query qUsuario = getEntityManager().createQuery(
				"select pr from Presupuesto pr where pr.proyecto.idProy = ?1"
						+ " and pr.anio = ?2 order by pr.item.idIp");
		qUsuario.setParameter(1, idProyectoP);
		qUsuario.setParameter(2, anio);
		return qUsuario.getResultList();

	}

	@Override
	public List<HistoriaEstadoP> findhistorias(Integer idProyectoP) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select pr from HistoriaEstado pr where pr.proyecto.idProy = ?1");
		qUsuario.setParameter(1, idProyectoP);

		return qUsuario.getResultList();

	}

	@Override
	public List<ItemP> findItems() {
		Query qUsuario = getEntityManager().createQuery(
				"select pr from ItemP pr order by pr.idIp ");
		return qUsuario.getResultList();

	}

	@Override
	public int consultarIdCoronograma() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(seg.idCronograma)FROM Cronograma seg");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public void insertarCronograma(Cronograma cr) throws Exception {
		getEntityManager().persist(cr);
	}

	@Override
	public void eliminarCronograma(Cronograma cr) throws Exception {
		getEntityManager().remove(getEntityManager().merge(cr));
	}

	@Override
	public ItemP buscarItem(Integer iditem) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select tp from ItemP tp WHERE tp.idIp = ?1");
		qUsuario.setParameter(1, iditem);
		return (ItemP) qUsuario.getSingleResult();
	}

	@Override
	public int consultarIdPrepsupuesto() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(seg.idPresPr)FROM Presupuesto seg");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public void insertarPresupuesto(Presupuesto cr) throws Exception {
		getEntityManager().persist(cr);
	}

	@Override
	public void eliminarPresupuesto(Presupuesto cr) throws Exception {
		getEntityManager().remove(getEntityManager().merge(cr));
	}

	@Override
	public void eliminarProyecto(ProyectoP pr) throws Exception {
		getEntityManager().remove(getEntityManager().merge(pr));
	}

	@Override
	public void eliminarEstado(HistoriaEstadoP hist) throws Exception {
		getEntityManager().remove(getEntityManager().merge(hist));
	}

	@Override
	public void editarPresupuesto(Presupuesto cr) throws Exception {
		getEntityManager().merge(cr);
	}

	@Override
	public List<Presupuesto> findPresupuestoExiste(Integer idProyectoP,
			int anio, int iditem) {
		Query qUsuario = getEntityManager().createQuery(
				"select pr from Presupuesto pr where pr.proyecto.idProy = ?1"
						+ " and pr.anio = ?2 and pr.item.idIp = ?3");
		qUsuario.setParameter(1, idProyectoP);
		qUsuario.setParameter(2, anio);
		qUsuario.setParameter(3, iditem);
		return qUsuario.getResultList();

	}

	@Override
	public List<RecursohPr> findrecProyExiste(Integer idproy, Integer idtipoRec) {
		Query qUsuario = getEntityManager().createQuery(
				"select rec from RecursohPr rec where rec.proyecto.idProy = ?1 "
						+ " and rec.rolProyecto.idRolProy = ?2");
		qUsuario.setParameter(1, idproy);
		qUsuario.setParameter(2, idtipoRec);
		return qUsuario.getResultList();

	}

	@Override
	public List<RecursohPr> findrecProyExisteRG(Integer idproy, String nced,
			String codTesis) {

		StringBuilder queryString = new StringBuilder(
				"select rec from RecursohPr rec where rec.proyecto.idProy = ?1 ");

		if (nced != null) {
			queryString.append(" and rec.nced = ?2 ");
		}

		if (codTesis != null) {
			queryString.append(" and rec.nrotesis = ?3 ");
		}

		Query qUsuario = getEntityManager().createQuery(queryString.toString());

		qUsuario.setParameter(1, idproy);
		if (nced != null) {
			qUsuario.setParameter(2, nced);
		}

		if (codTesis != null) {
			qUsuario.setParameter(3, codTesis);
		}

		return qUsuario.getResultList();

	}

	@Override
	public Double calcularTotalPryActr(int idproy, int anio) {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager()
				.createQuery(
						"SELECT SUM(act.montosiva)FROM Presupuesto act where act.proyecto.idProy = ?1 and act.anio = ?2 ");
		q.setParameter(1, idproy);
		q.setParameter(2, anio);
		Double idReq = null;

		idReq = (Double) q.setMaxResults(1).getSingleResult();
		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public Double calcularTotalfinPory(int idproy, int anio) {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager()
				.createQuery(
						"SELECT SUM(act.montoPr)FROM Presupuesto act where act.proyecto.idProy = ?1 and act.anio = ?2 ");
		q.setParameter(1, idproy);
		q.setParameter(2, anio);
		Double idReq = null;

		idReq = (Double) q.setMaxResults(1).getSingleResult();
		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public RecursohPr findrecFirma(Integer idproy, int idRec) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select rec from RecursohPr rec where rec.proyecto.idProy = ?1 and rec.idRhPr =?2 ");
		qUsuario.setParameter(1, idproy);
		qUsuario.setParameter(2, idRec);
		return (RecursohPr) qUsuario.getSingleResult();

	}

	@Override
	public List<SeguimientoPr> findSegActExite100(Integer idact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarSeguimiento(SeguimientoPr seg) throws Exception {
		getEntityManager().remove(getEntityManager().merge(seg));
	}

	@Override
	public void updateCrono(Cronograma actividad) throws Exception {
		getEntityManager().merge(actividad);
	}

	@Override
	public void eliminarMiembro(Miembro cr) throws Exception {
		getEntityManager().remove(getEntityManager().merge(cr));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parametro> getParametros(Integer serial) {

		StringBuilder queryString = new StringBuilder(
				"SELECT aus FROM Parametro aus where aus.serial = ?1  ");
		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, serial);

		return query.getResultList();

	}

	@Override
	public void insertParamentro(Parametro aus) {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(aus.id) FROM Parametro aus");
		Integer idConv = null;
		try {
			idConv = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idConv = null;
		}
		if (idConv == null) {
			idConv = 1;
		} else {
			++idConv;
		}

		// Url_conv
		String url = " ";

		aus.setId(idConv);

		getEntityManager().persist(aus);

	}

	@Override
	public void eliminarParamentro(Parametro aus) throws Exception {
		getEntityManager().remove(getEntityManager().merge(aus));
	}

	@Override
	public int consultarIdLin() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(seg.idLinProy)FROM Lineasproy seg");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public void insertarLin(Lineasproy lin) throws Exception {

		List<Lineasproy> lineasPoryecto = new ArrayList<Lineasproy>();

		lineasPoryecto = findLineasProy(lin.getProyecto().getIdProy());

		System.out
				.println("Tamaño de los size" + lineasPoryecto.size() + " tipo"
						+ lin.getProyecto().getTipoProyecto().getIdTipoProy());

		if (lin.getProyecto().getTipoProyecto().getIdTipoProy().equals(1))

		{

			getEntityManager().persist(lin);

		}

		if (lin.getProyecto().getTipoProyecto().getIdTipoProy().equals(6))

		{

			getEntityManager().persist(lin);

		}

		if (lin.getProyecto().getTipoProyecto().getIdTipoProy().equals(2)
				&& lineasPoryecto.size() > 0)

		{

			System.out.println("No se guarda");

		}

		else {

			getEntityManager().persist(lin);

		}

		if (lin.getProyecto().getTipoProyecto().getIdTipoProy().equals(3)
				&& lineasPoryecto.size() > 0)

		{
			System.out.println("No se guarda");
		}

		else {

			getEntityManager().persist(lin);

		}

		if (lin.getProyecto().getTipoProyecto().getIdTipoProy().equals(4)
				&& lineasPoryecto.size() > 0)

		{
			System.out.println("No se guarda");
		}

		else {

			getEntityManager().persist(lin);

		}

		if (lin.getProyecto().getTipoProyecto().getIdTipoProy().equals(5)
				&& lineasPoryecto.size() > 0)

		{
			System.out.println("No se guarda");
		}

		else {

			getEntityManager().persist(lin);

		}

	}

	@Override
	public void eliminarLin(Lineasproy lin) throws Exception {
		getEntityManager().remove(getEntityManager().merge(lin));
	}

	@Override
	public List<Lineasproy> findLineasProy(Integer idProyect) {
		Query qUsuario = getEntityManager().createQuery(
				"select pr from Lineasproy pr where pr.proyecto.idProy = ?1");

		qUsuario.setParameter(1, idProyect);

		return qUsuario.getResultList();

	}

	@Override
	public List<String> findRecDirectorCedula() {
		Query qUsuario = getEntityManager().createQuery(
				"select DISTINCT(rec.nced) from RecursohPr rec where  "
						+ " rec.rolProyecto.idRolProy = ?1 ");
		qUsuario.setParameter(1, 1);
		return qUsuario.getResultList();

	}
	

	@Override
	public List<String> findRecDsitinct() {
		Query qUsuario = getEntityManager().createQuery(
				"select DISTINCT(rec.nced) from RecursohPr rec ");
		
		return qUsuario.getResultList();

	}

	@Override
	public List<RecursohPr> findRecDirector(String cedula) {
		Query qUsuario = getEntityManager().createQuery(
				"select rec from RecursohPr rec where  "
						+ " rec.nced  like ?1 ");

		qUsuario.setParameter(1, cedula);
		return qUsuario.getResultList();

	}

	@Override
	public List<LineasInvestigacion> findAllLineas() {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select linv from LineasInvestigacion linv  order by linv.nomLinin");

		return qUsuario.getResultList();

	}

	@Override
	public List<ProyectoP> findproyectosReporte(Integer idtipo, String area,
			String codigo, Integer idlinea, String coddep, String cedula,
			String estado, Integer anio) {

		System.out.println("voy a consultar pee");
		
		List<ProyectoP> proys = new ArrayList<ProyectoP>();
		try {
			
		
		
		StringBuilder queryString = new StringBuilder(
				"select DISTINCT(pr) from ProyectoP pr, RecursohPr rp, Lineasproy lp, LineasInvestigacion li where   pr.idProy = rp.proyecto.idProy and pr.idProy = lp.proyecto.idProy and lp.lineas.idLinin = li.idLinin and   pr.nombrePr like ?1 ");

		if (idtipo != 0) {
			queryString.append(" and pr.tipoProyecto.idTipoProy  = ?2 ");
		}

		if (area != null) {
			queryString.append(" and pr.area like ?3 ");
		}

		if (codigo != null) {
			queryString.append(" and pr.codigoPr like ?4 ");
		}

		if (idlinea != 0) {
			queryString.append(" and lp.lineas.idLinin  = ?5 ");
		}

		if (coddep != null) {
			queryString.append(" and pr.coddep like ?6 ");
		}
		if (cedula != null) {
			queryString.append(" and rp.nced like ?7 ");
		}

		if (estado != null) {
			queryString.append(" and pr.estado like ?8 ");
		}

		if (anio != 0) {
			queryString.append(" and pr.anio  = ?9 ");
		}

		queryString.append(" order by pr.codigoPr ");

		Query qUsuario = getEntityManager().createQuery(queryString.toString());

		qUsuario.setParameter(1, "%");
		if (idtipo != 0) {
			qUsuario.setParameter(2, idtipo);
		}

		if (area != null) {
			qUsuario.setParameter(3, area);
		}

		if (codigo != null) {
			qUsuario.setParameter(4, codigo);
		}

		if (idlinea != 0) {
			qUsuario.setParameter(5, idlinea);
		}

		if (coddep != null) {
			qUsuario.setParameter(6, coddep);
		}
		if (cedula != null) {
			qUsuario.setParameter(7, cedula);
		}

		if (estado != null) {
			qUsuario.setParameter(8, estado);
		}

		if (anio != 0) {
			qUsuario.setParameter(9, anio);
		}

		proys =  qUsuario.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			proys = null;
		}
		
		return proys;
		

	}

	@Override
	public List<RecursohPr> buscarRecursoExisteCedula(String nced,
			Integer idproy) throws Exception {

		Query qUsuario = getEntityManager()
				.createQuery(
						"select tp from RecursohPr tp WHERE tp.nced = ?1 and tp.proyecto.idProy = ?2 ");
		qUsuario.setParameter(1, nced);
		qUsuario.setParameter(2, idproy);
		return qUsuario.getResultList();

	}

	@Override
	public List<String> findRecCedulas() {
		Query qUsuario = getEntityManager().createQuery(
				"select DISTINCT(rec.nced) from RecursohPr rec ");

		return qUsuario.getResultList();

	}
	
	@Override
	public RecursohPr findDirectorVinculado(int idProyectoP) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select reh from RecursohPr reh where reh.proyecto.idProy = ?1  and reh.rolProyecto.idRolProy = ?2 and reh.estadoPr = 'VINCULADO' ");
		qUsuario.setParameter(1, idProyectoP);
		qUsuario.setParameter(2, 1);

		try {
			RecursohPr r = (RecursohPr) qUsuario.getSingleResult();

			return r;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

}
