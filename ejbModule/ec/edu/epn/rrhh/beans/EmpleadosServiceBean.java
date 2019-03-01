package ec.edu.epn.rrhh.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
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

/**
 * Session Bean implementation class EmpleadosServiceBean
 */
@Stateless
public class EmpleadosServiceBean extends DaoGenericoImplement<Emp> implements
		EmpleadosService {

	/**
	 * Default constructor.
	 */
	public EmpleadosServiceBean() {
		// TODO Auto-generated constructor stub
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> findempByParams(String cedula, String nombre, String apellido,
			String codDep, String codRelLaboral) {

		System.out.println("Entraaaaaaaaa la consulta de la busquedaaaaaaaaaa");

		StringBuilder queryString = new StringBuilder(
				"SELECT emp FROM Emp emp where emp.nced like ?0 ");

		if (apellido != null) {
			queryString.append(" AND emp.apel like ?1 ");
		}
		
		

		if (nombre != null) {
			queryString.append(" AND emp.nom like ?2 ");
		}
		
		if (codDep != null) {
			queryString.append(" AND emp.dep.codDep like ?3 ");
		}
		
		if (codRelLaboral != null) {
			queryString.append(" AND emp.codTiporelacionlab like ?4 ");
		}

		queryString.append("ORDER BY emp.apel ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + cedula + "%");

		if (apellido != null) {
			query.setParameter(1, "%" + apellido + "%");
		}
		if (nombre != null) {
			query.setParameter(2, "%" + nombre + "%");
		}
		
		
		if (codDep != null) {
			query.setParameter(3, "%" + codDep + "%");
		}
		
		if (codRelLaboral != null) {
			query.setParameter(4, "%" + codRelLaboral + "%");
		}

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> findempByParams(String cedula, String apellidos,
			String nombre) {

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

		query.setParameter(0, "%" + cedula + "%");

		if (apellidos != null) {
			query.setParameter(1, "%" + apellidos + "%");
		}
		if (nombre != null) {
			query.setParameter(2, "%" + nombre + "%");
		}

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmpleadoDTO> findEmpFacDep(String nombreCedulaEmpelado)
			throws Exception {

		List<EmpleadoDTO> listEmpDTO = new ArrayList<EmpleadoDTO>();
		Query query = null;

		/*
		 * StringBuilder queryString = new StringBuilder(
		 * "SELECT e.nced, upper(CONCAT(CONCAT(e.nom, ' '), e.apel)), d.nomDep, "
		 * +
		 * "clemp.descClase, CASE e.codTiporelacionlab WHEN '1' THEN 'NOMBRAMIENTO' ELSE 'CONTRATO' END, "
		 * +
		 * "CASE e.codDedicacion WHEN 'TC' THEN 'TIEMPO COMPLETO' WHEN 'TP' THEN 'TIEMPO PARCIAL' END, "
		 * +
		 * "COALESCE((SELECT f.nomDep FROM Dep f WHERE f.codDep = substring(d.codDep from 0 for 5) AND f.idFacultad is not null), 'NINGUNO') "
		 * + "FROM Emp e JOIN e.clasemp clemp JOIN e.dep d " +
		 * "WHERE (trim(e.nced) like ?0 OR upper(CONCAT(CONCAT(e.apel, ' '), e.nom)) LIKE ?1 OR upper(CONCAT(CONCAT(e.nom, ' '), e.apel)) LIKE ?2) "
		 * + "ORDER BY e.apel"); Query query =
		 * getEntityManager().createQuery(queryString.toString());
		 * query.setParameter(0, "%" + nombreCedulaEmpelado + "%");
		 * query.setParameter(1, "%" + nombreCedulaEmpelado + "%");
		 * query.setParameter(2, "%" + nombreCedulaEmpelado + "%");
		 */

		StringBuilder queryString = new StringBuilder(
				"SELECT e.nced AS var1, upper(CONCAT(e.nom, ' ', e.apel)) AS var2, d.nom_dep AS var3, ce.desc_clase AS var4, "
						+ "CASE e.cod_tiporelacionlab WHEN '1' THEN 'NOMBRAMIENTO' ELSE 'CONTRATO' END AS var5, "
						+ "CASE e.\"COD_DEDICACION\" WHEN 'TC' THEN 'TIEMPO COMPLETO' WHEN 'TP' THEN 'TIEMPO PARCIAL' END AS var6, "
						+ "COALESCE((SELECT f.nom_dep FROM \"Rrhh\".dep f WHERE f.cod_dep = substring(d.cod_dep from 0 for 5) AND f.id_Facultad is not null), 'NINGUNO') AS var7 "
						+ "FROM \"Rrhh\".clasemp ce, \"Rrhh\".emp e, \"Rrhh\".dep d WHERE e.cod_dep= d.cod_dep AND e.cod_clase= ce.cod_clase "
						+ "AND (trim(e.nced) like ? OR upper(CONCAT(e.apel, ' ', e.nom)) LIKE ? OR upper(CONCAT(e.nom, ' ', e.apel)) LIKE ?) ");

		query = getEntityManager().createNativeQuery(queryString.toString());
		query.setParameter(1, "%" + nombreCedulaEmpelado + "%");
		query.setParameter(2, "%" + nombreCedulaEmpelado + "%");
		query.setParameter(3, "%" + nombreCedulaEmpelado + "%");

		List<?> listEquipos = query.getResultList();

		if (!listEquipos.isEmpty()) {
			for (Object list : listEquipos) {
				EmpleadoDTO dto = new EmpleadoDTO();
				Object[] fila = (Object[]) list;
				dto.setNumCedula(fila[0] == null ? "" : fila[0].toString());
				dto.setNombreEmpleado(fila[1] == null ? "" : fila[1].toString());
				dto.setNombreDepartamento(fila[2] == null ? "" : fila[2]
						.toString());
				dto.setTipoPersona(fila[3] == null ? "" : fila[3].toString());
				dto.setTipoContrato(fila[4] == null ? "" : fila[4].toString());
				dto.setDedicacion(fila[5] == null ? "" : fila[5].toString());
				dto.setNombrefacultad(fila[6] == null ? "" : fila[6].toString());

				listEmpDTO.add(dto);
			}
		}
		return listEmpDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Familiare> findfamilieares(String cedula) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Familiare fam where fam.emp.nced like ?0 ");

		queryString.append("ORDER BY fam.apelFam ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%" + cedula + "%");
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudio> findEstudios(String cedula) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Estudio fam where fam.emp.nced like ?0 ORDER BY fam.fechaT ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%" + cedula + "%");
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Eventocapac> findCapacitaciones(String cedula) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Eventocapac fam where fam.nced like ?0 order by fam.fechadesde ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%" + cedula + "%");
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IdiomasDocente> findIdiomas(String cedula) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM IdiomasDocente fam where fam.nced like ?0 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%" + cedula + "%");
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExpProfesExt> findExperieprofeExt(String cedula) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ExpProfesExt fam where fam.nced like ?0 AND fam.tipo IN ('D') order by fam.fechaInicioTrabajo DESC");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%" + cedula + "%");
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExpProfesExt> listExpProfesionalExterna(String cedula) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ExpProfesExt fam where fam.nced like ?0 AND (fam.tipo NOT IN ('D') OR fam.tipo=null) AND fam.estado IN ('A', 'I', 'U') order by fam.fechaInicioTrabajo DESC");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%" + cedula + "%");
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PubliPart> findPublicacionesEMp(String cedula) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM PubliPart fam where fam.emp.nced like ?0 order by fam.fechaIni ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%" + cedula + "%");
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TituloFormacionAcademica> findTitulosDocente(String cedula) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM TituloFormacionAcademica fam where fam.nced like ?0  order by fam.fecRegSenescyt ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%" + cedula + "%");
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Capacitacion> findCapacDocente(String cedula) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Capacitacion fam where fam.nced like ?0 order by fam.fechaInicioCapac");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%" + cedula + "%");
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Premio> findPremios(String cedula) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Premio fam where fam.nced like ?0 order by fam.anioPremio");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%" + cedula + "%");
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AreaConocDocente> findareasDocente(String idusuario) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM AreaConocDocente fam where fam.usuarioLog = ?0 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, idusuario.trim());
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadDocencia> findactividad(String nced, String nivel) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ActividadDocencia fam where fam.nced = ?0 and fam.nivel = ?1 order by fam.periodo.idPeriodo ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());
		query.setParameter(1, nivel.trim());
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TesisDirigida> findTesisDir(String nced) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM TesisDirigida fam where fam.nced = ?0 order by fam.periodo.idPeriodo ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TesisCalificada> findTesisCAlif(String nced) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM TesisCalificada fam where fam.nced = ?0 order by fam.periodo1.idPeriodo ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadProyecto> findActividadProyecto(String nced) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ActividadProyecto fam where fam.nced = ?0 order by fam.periodo.idPeriodo DESC");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> findPublicacion(String nced, String idPublicacion) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Publicacione fam where fam.nced = ?0 and fam.tipoPublicacion.idTipoPublic =?1 order by fam.fechaPublic ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());
		query.setParameter(1, idPublicacion.trim());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> findPublicacionDocente(String nced) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Publicacione fam where fam.nced = ?0  order by fam.fechaPublic ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadAdministrativa> findActividadAdm(String nced) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ActividadAdministrativa fam where fam.nced = ?0 order by fam.periodo.idPeriodo");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadTecnica> findActividadTecnica(String nced) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ActividadTecnica fam where fam.nced = ?0 order by fam.periodo.idPeriodo");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadExtension> findActividadExtension(String nced) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ActividadExtension fam where fam.nced = ?0 order by fam.periodo.idPeriodo ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Capacitacion> findCapcitacionDcita(String nced) {

		List<String> ids = new ArrayList<String>();
		ids.add("DICTA");
		ids.add("dicta");
		ids.add("Dicta");

		Query q = getEntityManager()
				.createQuery("SELECT fam FROM Capacitacion fam where fam.nced = ?0 and fam.tipo IN :list order by fam.fechaInicioCapac");
		q.setParameter(0, nced.trim());
		q.setParameter("list", ids);

		return q.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario finduserLog(Integer idUsuario) {

		Query q = getEntityManager()
				.createQuery("SELECT fam FROM Usuario fam where fam.idUsuario = ?0 ");
		q.setParameter(0, idUsuario);

		return (Usuario) q.getSingleResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> findVehiculo(String nced, String placa) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Vehiculo fam where fam.emp.nced = ?0 and fam.placa = ?1  ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());
		query.setParameter(1, placa.trim());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> findVehiculo1(String nced) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Vehiculo fam where fam.emp.nced = ?0   ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> findVehiculo2(String nced) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Vehiculo fam where fam.cedulaext = ?0   ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> findVehiculo3(String nced, String placa) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Vehiculo fam where fam.cedulaext = ?0 and fam.placa = ?1  ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());
		query.setParameter(1, placa.trim());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> findPublicacionTodas(String nced) {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		Query q = getEntityManager()
				.createQuery("SELECT fam FROM Publicacione fam where fam.nced = ?0 and fam.estado IN :list order by fam.tipoPublicacion.idTipoPublic");
		q.setParameter(0, nced.trim());
		q.setParameter("list", ids);

		return q.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public ActividadProyecto findActividadProyectoDocumento(String idActividad) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ActividadProyecto fam where fam.idActividProy = ?0 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, idActividad.trim());

		return (ActividadProyecto) query.getSingleResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> findPublicacionIndexasa(String nced,
			String categoria) {
		StringBuilder queryString = new StringBuilder(
				"SELECT p FROM Publicacione p, Emp e, EmpleadoPublica ep WHERE p.idPublic = ep.pub.idPublic AND e.nced = ep.emp.nced AND e.nced = ?0 and p.clase =?1 order by p.fechaPublic ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());
		query.setParameter(1, categoria);

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadProyecto> findActividadProyectoCierre(String nced,
			String marca) {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ActividadProyecto fam where fam.nced = ?0 and fam.cierre = ?1 and fam.estado IN :list  order by fam.periodo.idPeriodo DESC");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());
		query.setParameter(1, marca);
		query.setParameter("list", ids);

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> listaEmpleadoXCedula(String cedula) {
		StringBuilder queryString = new StringBuilder(
				"SELECT e FROM Emp e where e.nced =?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula);
		return query.getResultList();
	}

	@Override
	public NombTemp consultarNombramiento(String nced) {
		// Query q = getEntityManager().createQuery(
		// "SELECT MAX(seg.frigeNomb), seg.ffinNomb , seg.codPind, seg.nroNomb
		// FROM NombTemp seg where seg.nced =?1 group by seg.ffinNomb,
		// seg.codPind,seg.nroNomb order by seg.nroNomb desc limit 1");
		//
		// q.setParameter(1, nced);

		StringBuilder querys = new StringBuilder(
				"SELECT e From NombTemp e where e.nced = ?1 order by e.nroNomb desc");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, nced);
		query.setMaxResults(1);

		try {
			NombTemp nom = (NombTemp) query.getSingleResult();
			return nom;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Cont findContratobyCedula(String cedula) {
		StringBuilder querys = new StringBuilder(
				"SELECT e FROM Cont e where e.emp.nced = ?1 order by e.nroCont desc ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, cedula);
		query.setMaxResults(1);

		try {
			Cont cont = (Cont) query.getSingleResult();
			return cont;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Partind findbyCodPind(String codpind) {
		StringBuilder querys = new StringBuilder(
				"SELECT e From Partind e where e.codPind = ?1");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, codpind);
		return (Partind) query.getSingleResult();
	}

	@Override
	public Dep findDepbyCodigo(String cod_dep) {
		Query q = getEntityManager().createQuery(
				"Select dep from Dep dep where dep.codDep = ?1 ");
		q.setParameter(1, cod_dep);

		try {
			return (Dep) q.getSingleResult();

		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Tnomb findTnomByID(String tnom) {
		Query q = getEntityManager().createQuery(
				"Select dep from Tnomb dep where dep.tnomb = ?1 ");
		q.setParameter(1, tnom);
		return (Tnomb) q.getSingleResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Dep> listDepartamentos() throws Exception {
		Query q = getEntityManager().createQuery(
				"Select dep from Dep dep  order by  dep.nomDep");

		// q.setParameter(1, "%DEP%");
		return q.getResultList();

	}

	@Override
	public List<NombTemp> consultarNombramientosHistoria(String nced) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From NombTemp e where e.nced = ?1 order by e.nroNomb ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, nced);

		return query.getResultList();

	}

	@Override
	public List<Cont> findContratosHisotiral(String cedula) {
		StringBuilder querys = new StringBuilder(
				"SELECT e FROM Cont e where e.emp.nced = ?1 order by e.nroCont ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, cedula);

		return query.getResultList();
	}

	@Override
	public List<Partind> findPartidas() {
		StringBuilder querys = new StringBuilder(
				"SELECT e From Partind e order by e.cargo");
		Query query = getEntityManager().createQuery(querys.toString());

		return query.getResultList();
	}

	@Override
	public List<Tnomb> findTiposNombramiento() {
		Query q = getEntityManager().createQuery(
				"Select dep from Tnomb dep order by dep.tnomb ");

		return q.getResultList();
	}

	@Override
	public int consultarIdnombramiento() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(seg.nroNomb)FROM NombTemp seg");

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
	public void insertarNombramiento(NombTemp nom) {
		System.out
				.println("entraaaaaaaaaaaaaaaaa al metodo inserta del servicio");
		getEntityManager().persist(nom);
	}

	@Override
	public void insertarContrato(Cont nom) {
		System.out
				.println("entraaaaaaaaaaaaaaaaa al metodo inserta del servicio");
		getEntityManager().persist(nom);
	}

	@Override
	public void insertarEMP(Emp emp) {
		System.out
				.println("entraaaaaaaaaaaaaaaaa al metodo inserta del servicio");
		getEntityManager().persist(emp);
	}

	@Override
	public void insertarHE(HistoriaEstado his) {
		System.out
				.println("entraaaaaaaaaaaaaaaaa al metodo inserta del servicio");
		getEntityManager().persist(his);
	}

	@Override
	public List<Tcont> findTipoCOntrato() {
		Query q = getEntityManager().createQuery(
				"Select dep from Tcont dep order by dep.tcont ");

		return q.getResultList();
	}

	@Override
	public Tcont findTipoCOntratoByCodigo() {
		Query q = getEntityManager()
				.createQuery(
						"Select dep from Tcont dep where dep.tcont =?1 order by dep.tcont ");

		return (Tcont) q.getSingleResult();
	}

	@Override
	public List<Cargosc> findCargosContratoByTipoCOntrato(String tipoCont) {
		Query q = getEntityManager().createQuery(
				"Select dep from Cargosc dep where dep.tcontBean.tcont =?1 ");

		q.setParameter(1, tipoCont);

		return q.getResultList();
	}

	@Override
	public List<Ecivil> findestadoCivil() {
		Query q = getEntityManager().createQuery(
				"Select dep from Ecivil dep order by dep.codEcivil ");

		return q.getResultList();
	}

	@Override
	public List<Clasemp> findClaseEmp() {
		Query q = getEntityManager().createQuery(
				"Select dep from Clasemp dep order by dep.codClase ");

		return q.getResultList();
	}

	@Override
	public List<Genero> findgeneros() {
		Query q = getEntityManager().createQuery(
				"Select dep from Genero dep order by dep.codSexo ");

		return q.getResultList();
	}

	@Override
	public List<Estemp> findestadosEmp() {
		Query q = getEntityManager().createQuery(
				"Select dep from Estemp dep order by dep.codEst ");

		return q.getResultList();
	}

	@Override
	public List<Nac> findNacionalidades() {
		Query q = getEntityManager().createQuery(
				"Select dep from Nac dep order by dep.codNac ");

		return q.getResultList();
	}

	@Override
	public void updateNombramiento(Integer idnom, String path) {

		Query q = getEntityManager().createQuery(
				"UPDATE NombTemp SET path = ?1 where nroNomb = ?2 ");
		q.setParameter(2, idnom);
		q.setParameter(1, path);

		q.executeUpdate();

	}

	@Override
	public NombTemp findNombyID(Integer idnom) {

		Query q = getEntityManager().createQuery(
				" Select nom from NombTemp  nom where nom.nroNomb = ?1 ");
		q.setParameter(1, idnom);

		return (NombTemp) q.getSingleResult();

	}

	@Override
	public void updatecONTRATO(String idnom, String path) {

		Query q = getEntityManager().createQuery(
				"UPDATE Cont SET path = ?1 where nroCont = ?2 ");
		q.setParameter(2, idnom);
		q.setParameter(1, path);

		q.executeUpdate();

	}

	@Override
	public Estemp findEstadoEmp(String codEst) {
		Query q = getEntityManager().createQuery(
				"Select dep from Estemp dep where dep.codEst =?1  ");

		q.setParameter(1, codEst);

		return (Estemp) q.getSingleResult();
	}

	@Override
	public Clasemp findClaseEmp(String claseemp) {
		Query q = getEntityManager().createQuery(
				"Select dep from Clasemp dep where dep.codClase =?1  ");

		q.setParameter(1, claseemp);

		return (Clasemp) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> findPublicacionEmp(String nced, String idtipoPub,
			String coddep) {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Publicacione fam where  fam.tipoPublicacion.idTipoPublic = ?0 and fam.estado IN :list ");

		if (nced != null) {
			queryString.append(" and fam.nced = ?2 ");

		}

		if (coddep != null) {
			queryString.append(" and fam.departamento.codDep = ?3 ");

		}

		queryString.append("order by fam.fechaPublic ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, idtipoPub);

		query.setParameter("list", ids);

		if (nced != null) {
			query.setParameter(2, nced);

		}
		if (coddep != null) {
			query.setParameter(3, coddep);

		}

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findCodigosSinRepetir(String idtipoPub, Integer año,
			String coddep, String autores, String calalog) {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		StringBuilder queryString = new StringBuilder(
				"SELECT DISTINCT(fam.codigo) FROM Publicacione fam where  fam.tituloPublic like ?0 and fam.estado IN :list and fam.codigo is not null  ");

		if (idtipoPub != null) {
			queryString.append(" and fam.tipoPublicacion.idTipoPublic = ?1 ");

		}

		if (año != 0) {
			queryString.append(" and fam.anio = ?2 ");

		}

		if (coddep != null) {
			queryString.append(" and fam.departamento.codDep = ?3 ");

		}

		if (autores != null) {
			queryString.append(" and fam.autores = ?4 ");

		}

		if (calalog != null) {
			queryString.append(" and fam.catalogo like ?5 ");

		}

		queryString.append("    order by fam.codigo");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%");

		query.setParameter("list", ids);

		if (idtipoPub != null) {
			query.setParameter(1, idtipoPub);

		}

		if (año != 0) {
			query.setParameter(2, año);

		}

		if (coddep != null) {
			query.setParameter(3, coddep);

		}

		if (autores != null) {
			query.setParameter(4, autores);

		}

		System.out.println("Catalogo" + calalog);
		if (calalog != null) {
			query.setParameter(5, "%" + calalog + "%");

		}

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> findPublicacionesReporte(String codigoPublicacion) {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Publicacione fam where  fam.codigo = ?0 and fam.estado IN :list and fam.codigo is not null  ");

		queryString.append("  order by fam.codigo");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, codigoPublicacion);

		query.setParameter("list", ids);

		return query.getResultList();

	}

	@Override
	public Emp findEMPbyapelNom(String nom, String apel) {
		StringBuilder querys = new StringBuilder("SELECT e FROM Emp e where e.");

		if (nom != null && apel != null) {
			querys.append(" e.nom = ?1 and e.apel = ?2  ");

		} else {
			if (nom == null) {
				System.out.println("Nombre NUll");

			} else {
				querys.append(" e.nom like ?3 ");
			}

			if (apel == null) {
				System.out.println("apellido NUll");

			} else {
				querys.append(" e.apel like ?4 ");
			}

		}

		Query query = getEntityManager().createQuery(querys.toString());

		if (nom != null && apel != null) {
			query.setParameter(1, nom.toUpperCase());
			query.setParameter(2, apel.toUpperCase());

		} else {
			if (nom == null) {
				System.out.println("Nombre NUll");

			} else {
				query.setParameter(3, nom.toUpperCase());
			}

			if (apel == null) {
				System.out.println("apellido NUll");

			} else {
				query.setParameter(4, nom.toUpperCase());
			}

		}
		try {
			Emp e = (Emp) query.getSingleResult();
			query.setMaxResults(1);
			return e;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public List<Emp> findEMPBYPARAMS(String nom, String apel, String coddep,
			String nced) {
		StringBuilder querys = new StringBuilder(
				"SELECT e FROM Emp e where e.clasemp.codClase =?0");

		if (nom != null) {
			querys.append(" and e.nom like ?1");

		}

		if (apel != null) {
			querys.append(" and e.apel like ?2");

		}

		if (coddep != null) {
			querys.append(" and e.dep.codDep = ?3");

		}

		if (nced != null) {
			querys.append(" and e.nced = ?4");

		}

		querys.append(" order by e.apel");

		Query query = getEntityManager().createQuery(querys.toString());

		query.setParameter(0, "1");

		if (nom != null) {
			query.setParameter(1, "%" + nom.toUpperCase() + "%");

		}

		if (apel != null) {
			query.setParameter(2, "%" + apel.toUpperCase() + "%");

		}

		if (coddep != null) {
			query.setParameter(3, coddep);

		}

		if (nced != null) {
			query.setParameter(4, nced);

		}

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPublicacion> findAllTipos() {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM TipoPublicacion fam order by fam.idTipoPublic  ");

		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public TipoPublicacion findById(String id) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM TipoPublicacion fam where fam.idTipoPublic = ?1   order by fam.idTipoPublic  ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id.trim());

		return (TipoPublicacion) query.getSingleResult();

	}

	@Override
	public int consultarNumeroSerial(int anio, String idtipo, String coddep) {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager()
				.createQuery(
						"SELECT MAX(pr.serial)FROM Publicacione pr"
								+ " where pr.anio =?1 and pr.departamento.codDep =?2 and pr.tipoPublicacion.idTipoPublic =?3 ");

		Integer idReq = null;
		q.setParameter(1, anio);
		q.setParameter(2, coddep);
		q.setParameter(3, idtipo);

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
	public List<HistoriaEstado> findHistoriaByEmp(String nced) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM HistoriaEstado fam where fam.emp.nced =?1 order by fam.idHe  ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, nced);

		return query.getResultList();

	}

	@Override
	public int consultarIdhisotrial() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(seg.idHe)FROM HistoriaEstado seg");

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
	public void modificarNomb(NombTemp nom) throws Exception {
		getEntityManager().merge(nom);
	}

	@Override
	public void borrarNom(NombTemp nom) throws Exception {
		getEntityManager().remove(getEntityManager().merge(nom));
	}

	@Override
	public Cont findContID(String idnom) {

		Query q = getEntityManager().createQuery(
				" Select nom from Cont  nom where nom.nroCont = ?1 ");
		q.setParameter(1, idnom);

		return (Cont) q.getSingleResult();

	}

	@Override
	public void modificarCont(Cont con) throws Exception {
		getEntityManager().merge(con);
	}

	@Override
	public void borrarCont(Cont con) throws Exception {
		getEntityManager().remove(getEntityManager().merge(con));
	}

	@Override
	public void modificarHist(HistoriaEstado his) throws Exception {
		getEntityManager().merge(his);
	}

	@Override
	public void borrarhist(HistoriaEstado his) throws Exception {
		getEntityManager().remove(getEntityManager().merge(his));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> findPublicacionVIPS(String vips, String idtipoPub) {

		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Publicacione fam where fam.vips = ?0 ");

		if (idtipoPub != null) {
			queryString.append(" and fam.tipoPublicacion.idTipoPublic = ?1 ");

		}

		queryString.append("order by fam.fechaPublic ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, vips);

		if (idtipoPub != null) {
			query.setParameter(1, idtipoPub);

		}

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> findPublicacionVIPSPorAño(String vips,
			String idtipoPub, Integer anio) {

		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Publicacione fam where fam.vips = ?0 ");

		if (idtipoPub != null) {
			queryString.append(" and fam.tipoPublicacion.idTipoPublic = ?1 ");

		}

		if (anio != 0) {
			queryString.append(" and fam.tipoPublicacion.idTipoPublic = ?1 ");

		}

		queryString.append("order by fam.fechaPublic ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, vips);

		if (idtipoPub != null) {
			query.setParameter(1, idtipoPub);

		}

		return query.getResultList();

	}

	@Override
	public void updateAccionPersonal(String idaccp, String path) {

		Query q = getEntityManager().createQuery(
				"UPDATE Aper SET path = ?1 where nroAccion = ?2 ");
		q.setParameter(2, idaccp);
		q.setParameter(1, path);

		q.executeUpdate();

	}

}
