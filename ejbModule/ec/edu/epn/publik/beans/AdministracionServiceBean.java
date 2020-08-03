package ec.edu.epn.publik.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
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
import ec.edu.epn.jdbc.JDBCUtil;
import ec.edu.epn.publik.entities.PerfilUsuario;
import ec.edu.epn.rrhh.entities.Emp;
import ec.edu.epn.rrhh.entities.EmpExt;
import ec.edu.epn.rrhh.entities.Vehiculo;
import ec.edu.epn.seguridad.vo.Perfil;
import ec.edu.epn.seguridad.vo.Usuario;

/**
 * Session Bean implementation class AdministracionServiceBean
 */
@Stateless
@LocalBean
public class AdministracionServiceBean extends DaoGenericoImplement<Usuario>
		implements AdministracionService {

	@Resource(mappedName = "java:jboss/datasources/SeguridadEPNDS")
	DataSource ds;

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	/**
	 * Default constructor.
	 */
	public AdministracionServiceBean() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> usuarioExiste(String cedula) {

		StringBuilder queryString = new StringBuilder(
				"SELECT aus FROM Usuario aus where aus.cedula = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Perfil buscarperfil(Integer idPerfil) {

		StringBuilder queryString = new StringBuilder(
				"SELECT aus FROM Perfil aus where aus.idPerfil = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idPerfil);
		return (Perfil) query.getSingleResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PerfilUsuario> perfilesUsuario(Integer idUsuario,
			Integer Idperfil) {

		StringBuilder queryString = new StringBuilder(
				"SELECT aus FROM PerfilUsuario aus where aus.id.idPerfil = ?1 and aus.id.idUsuario = ?2");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(2, idUsuario);
		query.setParameter(1, Idperfil);
		return query.getResultList();

	}

	@Override
	public int consultarIdUser() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(seg.idUsuario)FROM Usuario seg");

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
	public void actualizarPassword(Integer idusuario, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement("update usuario set clave = crypt(?,gen_salt('md5')) where id_usuario=?;");
			ps.setString(1, password);
			ps.setInt(2, idusuario);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}
	}

	@Override
	public String obtenerCArgo(String cedula) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ds.getConnection();
			String qry = "SELECT  DISTINCT(e.NCED), e.nom, e.apel, p.cargo, d.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), e.ext, e.email1, e.email2,e.fec_ingsp  FROM "
					+ "\"Rrhh\".EMP E , \"Rrhh\".NOMB_TEMP N , \"Rrhh\".PARTIND P , \"Rrhh\".DEP D , "
					+ "\"Rrhh\". UNOMB UN, USUARIO U WHERE "
					+ "E.NCED = N.NCED "
					+ "AND  N.NCED = UN.NCED "
					+ "AND N.FRIGE_NOMB  =  UN.FRIGE_NOMB "
					+ "AND  N.COD_PIND = P.COD_PIND "
					+ "AND  E.COD_DEPA = D.COD_DEP "
					+ "AND   COD_EST IN ('1', '3', '4', '5', '6', '7' , '9') "
					+ "AND  E.COD_TIPORELACIONLAB = '1' "
					+ "AND e.nced = u.cedula "
					+ "AND e.nced = ? "
					+ "UNION ALL "
					+ "select DISTINCT(e.NCED), e.nom, e.apel, tc.desc_tcont, d.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), e.ext, e.email1, e.email2,e.fec_ingsp "
					+ "from \"Rrhh\".EMP E, \"Rrhh\".DEP D, \"Rrhh\".cont C, \"Rrhh\".tcont tc, USUARIO U "
					+ "where E.COD_DEPA = D.COD_DEP "
					+ "and tc.tcont in ('CPSA','CPSC','AC') "
					+ "and c.tcont = tc.tcont "
					+ "and e.nced = c.nced "
					+ "AND e.nced = u.cedula "
					+ "AND e.nced = ? "
					+ "UNION ALL "
					+ "select CT.nced, e.nom, e.apel, CT.cargoc, D.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), e.ext, e.email1, e.email2,e.fec_ingsp FROM \"Rrhh\".cont CT, "
					+ "\"Rrhh\".EMP E, \"Rrhh\".DEP D, \"Rrhh\".clasemp C, USUARIO U  "
					+ "where e.nced = u.cedula  "
					+ "AND  E.COD_DEPA = D.COD_DEP  "
					+ "and C.cod_clase not in ('1') "
					+ "and e.nced = CT.nced  "
					+ "AND e.nced = ? "
					+ "GROUP BY CT.nced, e.nom, e.apel, CT.cargoc, D.nom_dep, e.fec_ingepn, e.ext, e.email1, e.email2,e.fec_ingsp  "
					+ "limit 1 ";

			ps = con.prepareStatement(qry);

			ps.setString(1, cedula);
			ps.setString(2, cedula);
			ps.setString(3, cedula);

			ResultSet rs = ps.executeQuery();

			String cargo = null;

			while (rs.next()) {

				cargo = rs.getString(4);

				System.out.println(rs.getString(4));

			}

			ps.close();
			con.close();

			System.out.println("cargo" + cargo);

			return cargo;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ENTRAMOS AL catch 1");
			return null;
		} finally {
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}
	}

	@Override
	public int consultarIdVehiculo() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(seg.id)FROM Vehiculo seg");

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
	public Emp buscaremp(String nced) throws Exception {

		System.out.println("Cedula" + nced);
		StringBuilder queryString = new StringBuilder(
				"SELECT e from Emp e where e.nced = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nced.trim());
		System.out.println("Empleado");
		return (Emp) query.getSingleResult();
	}

	@Override
	public void insertarVehiculo(Vehiculo auto) {
		System.out
				.println("entraaaaaaaaaaaaaaaaa al metodo inserta del servicio");
		getEntityManager().persist(auto);
	}

	@Override
	public EmpExt buscarempExterno(String nced) throws Exception {

		System.out.println("Cedula" + nced);
		StringBuilder queryString = new StringBuilder(
				"SELECT e from EmpExt e where e.nced = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nced.trim());
		System.out.println("Empleado");
		return (EmpExt) query.getSingleResult();
	}

	@Override
	public void modificarEmp(Emp emp) throws Exception {
		getEntityManager().merge(emp);
	}

	@Override
	public void modificarTitulo(TituloFormacionAcademica titu) throws Exception {
		getEntityManager().merge(titu);
	}

	@Override
	public void modificarpub(Publicacione pub) throws Exception {
		getEntityManager().merge(pub);
	}

	@Override
	public List<DocumentoGD> buscarDocumento(String idPublic) throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from DocumentoGD s where s.idevidencia = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, Integer.parseInt(idPublic.trim()));
		System.out.println("documentos");
		return query.getResultList();
	}

	@Override
	public int maxIdDocumento() {

		Query q = getEntityManager().createQuery(
				"SELECT MAX(p.iddocumento) FROM DocumentoGD p");
		Integer idPagosV = null;

		try {
			idPagosV = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idPagosV = null;
		}
		if (idPagosV == null) {
			idPagosV = 1;
		} else {
			++idPagosV;
		}
		return idPagosV;
	}

	@Override
	public void insertarDocumento(DocumentoGD doc) {
		System.out
				.println("entraaaaaaaaaaaaaaaaa al metodo inserta del servicio");
		getEntityManager().persist(doc);
	}

	@Override
	public void modificarDoc(DocumentoGD doc) throws Exception {
		getEntityManager().merge(doc);
	}

	@Override
	public void modificarProy(ActividadProyecto proy) throws Exception {
		getEntityManager().merge(proy);
	}

	@Override
	public void modificarExp(ExpProfesExt exp) throws Exception {
		getEntityManager().merge(exp);
	}

	@Override
	public List<DocumentoGD> buscarDocumentoExiste(String idPublic,
			Integer idEstado) throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from DocumentoGD s where s.idevidencia = ?1 and s.tipodocumento.idtipo =?2 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, Integer.parseInt(idPublic.trim()));
		query.setParameter(2, idEstado);
		System.out.println("documentos");
		return query.getResultList();
	}

	@Override
	public void insertarTesisSAEW(Tesissaew tesis) {

		getEntityManager().persist(tesis);
	}

	@Override
	public List<Tesissaew> buscarTesisSaew(String cedula, String categoria,
			String proceso) throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from Tesissaew s where s.codigoprofe = ?1  and s.cateogoria =?2 and s.proceso =?3 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter(2, categoria.trim());
		query.setParameter(3, proceso);

		return query.getResultList();
	}

	@Override
	public List<Tesissaew> buscarTesisSaewExiste(String cedula,
			String categoria, String proceso, Integer tesis) throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from Tesissaew s where s.codigoprofe = ?1  and s.cateogoria =?2 and s.proceso =?3 and s.idtesis =?4 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter(2, categoria.trim());
		query.setParameter(3, proceso);
		query.setParameter(4, tesis);

		return query.getResultList();
	}

	@Override
	public List<TituloFormacionAcademica> buscarTutlosRegSDenescyt(String cedula)
			throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		StringBuilder queryString = new StringBuilder(
				"SELECT s from TituloFormacionAcademica s where s.nced = ?1  and s.estado IN :list and s.regSenescyt IS NOT NULL order by fecRegSenescyt DESC");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Infoactividad> consultarinformes(String cedula, String proceso,
			String categoria, Integer idrecategorizacion) {

		StringBuilder queryString = new StringBuilder(
				"select  inf from Infoactividad inf  where inf.nced = ?0  and inf.proceso =?1 and inf.categoria = ?2 ");

		if (idrecategorizacion != 0) {
			queryString.append(" and inf.idrecategoriza = ?3 ");
		}

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, cedula);
		query.setParameter(1, proceso);
		query.setParameter(2, categoria);

		if (idrecategorizacion != 0) {
			query.setParameter(3, idrecategorizacion);
		}

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}

	@Override
	public int maxInfor() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(p.id) FROM Infoactividad p");
		Integer idPagosV = null;

		try {
			idPagosV = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idPagosV = null;
		}
		if (idPagosV == null) {
			idPagosV = 1;
		} else {
			++idPagosV;
		}
		return idPagosV;
	}

	@Override
	public void insertarInforme(Infoactividad inf) {

		getEntityManager().persist(inf);
	}

	@Override
	public void modificarInfor(Infoactividad emp) throws Exception {
		getEntityManager().merge(emp);
	}

	@Override
	public List<CategoriasD> buscarCategorias(Integer serie) throws Exception {
		StringBuilder queryString = new StringBuilder(
				"SELECT s from CategoriasD s where s.serie = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, serie);
		return query.getResultList();
	}

	@Override
	public CategoriasD buscarCategoriaSELECT(int idcategoria) throws Exception {
		StringBuilder queryString = new StringBuilder(
				"SELECT s from CategoriasD s  where s.idCat = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idcategoria);
		return (CategoriasD) query.getSingleResult();
	}

	@Override
	public List<Recategorizacion> buscarRecExiste(String nced,
		
		
			
			String categoria, String proceso) throws Exception {
		
		List<String> ids = new ArrayList<String>();
		ids.add("D");
		ids.add("I");
		ids.add("T");
		ids.add("E");
		StringBuilder queryString = new StringBuilder(
				"SELECT s from Recategorizacion s where s.nced = ?1 and s.categoria = ?2 and s.proceso = ?3 and s.estado IN :list");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nced);
		query.setParameter(2, categoria);
		query.setParameter(3, proceso);
		query.setParameter("list", ids);
		
		System.out.println("patentes");
		return query.getResultList();
	}

	@Override
	public int maxCodRecategorizacion() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(p.idRec) FROM Recategorizacion p");
		Integer idPagosV = null;

		try {
			idPagosV = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idPagosV = null;
		}
		if (idPagosV == null) {
			idPagosV = 1;
		} else {
			++idPagosV;
		}
		return idPagosV;
	}

	@Override
	public void insertarRecategorizacion(Recategorizacion rec) {
		System.out
				.println("entraaaaaaaaaaaaaaaaa al metodo inserta del servicio");
		getEntityManager().persist(rec);
	}

	@Override
	public void modificarTesis(Tesissaew te) throws Exception {
		getEntityManager().merge(te);
	}

	@Override
	public List<TituloFormacionAcademica> buscarTutlosRegSDenescytRevaloriza(
			String cedula) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		String valida = "S";

		StringBuilder queryString = new StringBuilder(
				"SELECT s from TituloFormacionAcademica s where s.nced = ?1  and s.estado IN :list and s.regSenescyt IS NOT NULL and s.validarevalorazion = ?2 order by fecRegSenescyt DESC");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);
		query.setParameter(2, valida);

		return query.getResultList();
	}
	
	@Override
	public List<TituloFormacionAcademica> buscarTutlosRegSDenescytRevalorizarec(
			String cedula) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		String valida = "S";

		StringBuilder queryString = new StringBuilder(
				"SELECT s from TituloFormacionAcademica s where s.nced = ?1  and s.estado IN :list and s.regSenescyt IS NOT NULL and s.validarecategorza = ?2 order by fecRegSenescyt DESC");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);
		query.setParameter(2, valida);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> findPublicacionIndexasa(String nced,
			String categoria) {
		StringBuilder queryString = new StringBuilder(
				"SELECT p FROM Publicacione p, Emp e, EmpleadoPublica ep WHERE p.idPublic = ep.pub.idPublic AND e.nced = ep.emp.nced AND e.nced = ?0 AND p.clase =?1 AND p.validarevalorazion = ?2 order by p.fechaPublic ");


		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());
		query.setParameter(1, categoria);
		query.setParameter(2, "S");

		return query.getResultList();

	}

	@Override
	public List<Patente> buscarpatentesRel(String nced, String clase)
			throws Exception {
		StringBuilder queryString = new StringBuilder(
				"SELECT s from Patente s where s.nced = ?1 and s.clase =?2 and s.validarevalorazion =?3");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nced);
		query.setParameter(2, clase);
		query.setParameter(3, "S");
		System.out.println("patentes");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadProyecto> findActividadProyectoCierre(String nced,
			String marca) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ActividadProyecto fam where fam.nced = ?0 and fam.cierre = ?1  and fam.validarevalorazion = ?2 order by fam.periodo.idPeriodo DESC");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());
		query.setParameter(1, marca);
		query.setParameter(2, "S");

		return query.getResultList();

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadProyecto> findActividadProyectoCierreRec(String nced,
			String marca) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ActividadProyecto fam where fam.nced = ?0 and fam.cierre = ?1  and fam.validarecategorza = ?2 order by fam.periodo.idPeriodo DESC");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());
		query.setParameter(1, marca);
		query.setParameter(2, "S");

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExpProfesExt> findExperieprofeExt(String cedula) {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ExpProfesExt fam where fam.nced like ?0 and fam.estado IN :list AND fam.tipo IN ('D') and fam.validarevalorazion = ?1 order by fam.fechaInicioTrabajo DESC");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%" + cedula + "%");
		query.setParameter(1, "S");

		query.setParameter("list", ids);
		return query.getResultList();

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ExpProfesExt> listExpProfesionalExtNoDocente(String cedula) {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ExpProfesExt fam where fam.nced like ?0 and fam.estado IN :list AND (fam.tipo NOT IN ('D') OR fam.tipo=null) and fam.validarevalorazion = ?1 order by fam.fechaInicioTrabajo DESC");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%" + cedula + "%");
		query.setParameter(1, "S");

		query.setParameter("list", ids);
		return query.getResultList();

	}
	
	@Override
	public void modificarRecategorizacion(Recategorizacion rec) throws Exception {
		getEntityManager().merge(rec);
	}
	
	@Override
	public List<Patente> buscarpatentesRel1(String nced, String clase) throws Exception {
		StringBuilder queryString = new StringBuilder(
				"SELECT s from Patente s where s.nced = ?1 and s.clase =?2");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nced);
		query.setParameter(2, clase);
		System.out.println("patentes");
		return query.getResultList();
	}
	
	
	@Override
	public void modificarPatente(Patente pat) throws Exception {
		getEntityManager().merge(pat);
	}
	
	@Override
	public List<Capacitacion> buscarCapacitacionesDocente(
			String cedula, String valida) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");
		
		
		
		List<String> capc = new ArrayList<String>();
		
		capc.add("ASISTE");
		capc.add("Asiste");
		capc.add("asiste");
		

		

		StringBuilder queryString = new StringBuilder(
				"SELECT s from Capacitacion s where s.nced = ?1  and s.estado IN :list  and s.tipo IN :dicta");
		
		if(valida != null)
		{
			queryString.append(" and s.validarecategorza = ?2 ");
		}
		
		
		queryString.append(" ORDER BY s.fechaInicioCapac DESC");
		
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);
		query.setParameter("dicta", capc);
		
		
		
		if(valida != null)
		{
			query.setParameter(2, valida);
		}
		
		

		return query.getResultList();
	}
	
	
	@Override
	public void modificarCapacitacion(Capacitacion cap) throws Exception {
		getEntityManager().merge(cap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> findPublicacionIndexasaRec(String nced,
			String categoria) {
		StringBuilder queryString = new StringBuilder(				
				"SELECT p FROM Publicacione p, Emp e, EmpleadoPublica ep WHERE p.idPublic = ep.pub.idPublic AND e.nced = ep.emp.nced AND e.nced = ?0 AND p.clase =?1 AND p.validarecategorza = ?2 order by p.fechaPublic ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());
		query.setParameter(1, categoria);
		query.setParameter(2, "S");

		return query.getResultList();

	}
	
	@Override
	public List<Patente> buscarpatentesRelrec(String nced, String clase)
			throws Exception {
		StringBuilder queryString = new StringBuilder(
				"SELECT s from Patente s where s.nced = ?1 and s.clase =?2 and s.validarecategorza =?3");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nced);
		query.setParameter(2, clase);
		query.setParameter(3, "S");
		System.out.println("patentes");
		return query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ExpProfesExt> findExperieprofeExtRec(String cedula) {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ExpProfesExt fam where fam.nced like ?0 and fam.estado IN :list AND fam.tipo IN ('D') and fam.validarecategorza = ?1 order by fam.fechaInicioTrabajo DESC");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%" + cedula + "%");
		query.setParameter(1, "S");

		query.setParameter("list", ids);
		return query.getResultList();

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ExpProfesExt> listExpProfExtNoDocenteRecat(String cedula) {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ExpProfesExt fam where fam.nced like ?0 and fam.estado IN :list AND (fam.tipo NOT IN ('D') OR fam.tipo=null) and fam.validarecategorza = ?1 order by fam.fechaInicioTrabajo DESC");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%" + cedula + "%");
		query.setParameter(1, "S");

		query.setParameter("list", ids);
		return query.getResultList();

	}
	
	
	@Override
	public List<Recategorizacion> buscarRecExisteccOM(String nced,
		
		
			
			String categoria, String proceso) throws Exception {
		
		List<String> ids = new ArrayList<String>();
		ids.add("D");
		ids.add("I");
		ids.add("T");
		ids.add("E");
		StringBuilder queryString = new StringBuilder(
				"SELECT s from Recategorizacion s where s.nced = ?1 and s.categoria = ?2 and s.proceso = ?3 AND s.estado = ?4 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nced);
		query.setParameter(2, categoria);
		query.setParameter(3, proceso);
	
		query.setParameter(4, "E");
		
		System.out.println("patentes");
		return query.getResultList();
	}
	
	@Override
	public List<Recategorizacion> buscarRecExistConsejo(String nced,
		
			String categoria, String proceso) throws Exception {
		
		
		StringBuilder queryString = new StringBuilder(
				"SELECT s from Recategorizacion s where s.nced = ?1 and s.categoria = ?2 and s.proceso = ?3 AND s.estado = ?4 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nced);
		query.setParameter(2, categoria);
		query.setParameter(3, proceso);
	
		query.setParameter(4, "T");
		
		System.out.println("patentes");
		return query.getResultList();
	}
	
	
	@Override
	public List<Recategorizacion> buscarRecReporte(String nced,
		
			String categoria, String proceso, String estado) throws Exception {
		
		StringBuilder queryString = new StringBuilder(
				"SELECT s from Recategorizacion s where s.nced = ?1 and s.categoria = ?2 and s.proceso = ?3 AND s.estado = ?4 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nced);
		query.setParameter(2, categoria);
		query.setParameter(3, proceso);
	
		query.setParameter(4, estado);
		return query.getResultList();
	}
	
	
	
	@Override
	public List<Emp> buscarEmpRev(String proceso
			 ) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("I");
		ids.add("E");
		ids.add("S");
		ids.add("V");
		ids.add("D");
		ids.add("T");
		ids.add("R");
		StringBuilder queryString = new StringBuilder(
				"SELECT s from Emp s ");
				
		if(proceso == "R")
		{
			queryString.append(" where s.recategoriza IN :list ");
		}
		
		if(proceso == "V")
		{
			queryString.append(" where s.revaloriza IN :list ");
		}
		
		queryString.append(" ORDER BY s.apel DESC");
		
		Query query = getEntityManager().createQuery(queryString.toString());
		
		query.setParameter("list", ids);
		return query.getResultList();
	}
	
	
	@Override
	public List<AreaConocimiento> finaAllAreas() throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from AreaConocimiento s order by s.nombreSubindice ");
		Query query = getEntityManager().createQuery(queryString.toString());
		
		
		return query.getResultList();
	}
	
	
	@Override
	public AreaConocimiento buscarAreaByID(String cod) throws Exception {
		
		
		StringBuilder queryString = new StringBuilder(
				"SELECT s from AreaConocimiento s where s.idAreaCon = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cod);
		
	
		
		
		
		return (AreaConocimiento) query.getSingleResult();
	}
	
	
	@Override
	public void insertarPublicacion(Publicacione pub) {

		getEntityManager().persist(pub);
	}
	
	@Override
	public Publicacione buscarPubByID(String cod) throws Exception {
		
		
		StringBuilder queryString = new StringBuilder(
				"SELECT s from Publicacione s where s.codigo = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cod);

		return (Publicacione) query.getSingleResult();
	}
	
	@Override
	public void insertarEMpleadoPublica(EmpleadoPublica emp) {

		getEntityManager().persist(emp);
	}
	
	@Override
	public int maxIDEmpleadoPublica() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(p.id) FROM EmpleadoPublica p");
		Integer idPagosV = null;

		try {
			idPagosV = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idPagosV = null;
		}
		if (idPagosV == null) {
			idPagosV = 1;
		} else {
			++idPagosV;
		}
		return idPagosV;
	}
	
	
	
	@Override
	public List<EmpleadoPublica> finaAutoresporPublicacion(String tipo, Integer Idpub) throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from EmpleadoPublica s where s.pub.idPublic =?0 and s.tipo =?1 order by s.emp.apel ");
		Query query = getEntityManager().createQuery(queryString.toString());
		
		query.setParameter(0, Idpub);
		query.setParameter(1, tipo);
		
		
		return query.getResultList();
	}
	
	@Override
	public List<String> finaAutoresporPublicacionReporte(String tipo) throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT DISTINCT(s.emp.nced) from EmpleadoPublica s where s.tipo =?0 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		
		
		query.setParameter(0, tipo);
		
		
		return query.getResultList();
	}
	
	
	@Override
	public List<EmpleadoPublica> finaAutoresporPublicacionExiste(String tipo, String nced, Integer idpub) throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from EmpleadoPublica s where s.pub.idPublic =?0  and s.emp.nced =?1 order by s.emp.apel ");
		Query query = getEntityManager().createQuery(queryString.toString());
		
		query.setParameter(0, idpub);
		query.setParameter(1, nced);
		
		
		return query.getResultList();
	}
	
	
	@Override
	public List<Pais> findAllPais() throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from Pais s  order by s.nomPais ");
		Query query = getEntityManager().createQuery(queryString.toString());
		
		return query.getResultList();
	}
	
	@Override
	public void borrarEmpP(EmpleadoPublica EmpP) throws Exception {
		getEntityManager().remove(getEntityManager().merge(EmpP));
	}
	
	
	
	
	
	@Override
	public int consultarIdRecodifica() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(seg.id)FROM Recodificacion seg");

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
	public void insertarRecodificación(Recodificacion emp) {

		getEntityManager().persist(emp);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
