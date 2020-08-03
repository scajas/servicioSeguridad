package ec.edu.epn.rrhh.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.sql.DataSource;

import ec.edu.epn.acreditacion.reportes.dto.ReporteChartDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReporteDistributivoAcademicoDTO;
import ec.edu.epn.contratos.beans.PensumDAO;
import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.DTO.NombramientoDTO;
import ec.edu.epn.rrhh.DTO.DocenteDTO;
import ec.edu.epn.rrhh.DTO.EmpleadoDTO;
import ec.edu.epn.rrhh.entities.Dep;
import ec.edu.epn.rrhh.entities.Emp;

/**
 * @author Administrador
 * 
 */
@Stateless
public class EmpleadoDAOImplement extends DaoGenericoImplement<Emp> implements EmpleadoDAO {

	@Resource(mappedName = "java:jboss/datasources/SeguridadEPNDS")
	private DataSource dataSource;

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/PensumDAOImplement!ec.edu.epn.contratos.beans.PensumDAO")
	private PensumDAO pensumDAO;

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/DepDAOImplement!ec.edu.epn.rrhh.beans.DepDAO")
	private DepDAO depDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> findempByParams(String cedula, String apellidos, String nombre) {
		

		StringBuilder queryString = new StringBuilder("SELECT emp FROM Emp emp where emp.nced like ?0 and (emp.estemp.codEst != '2' and emp.estemp.codEst != '8' and emp.estemp.codEst != '10') ");

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

		return query.getResultList();
	}
	
	
	@Override
	public Emp buscaremp(String nced) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Emp empleado = new Emp();
			StringBuilder queryString = new StringBuilder("SELECT e from Emp e where e.nced = ?1 ");
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, nced.trim());

			empleado = (Emp) query.getSingleResult();

//			con = dataSource.getConnection();
//			if (empleado != null && con != null) {
//				String qry = "SELECT "
//						+ "CASE cod_tiporelacionlab WHEN 1 THEN (SELECT MAX(p.cargo) FROM \"Rrhh\".nomb_temp n, \"Rrhh\".partind p WHERE n.cod_pind= p.cod_pind AND n.frige_nomb = (SELECT MAX(frige_nomb) FROM \"Rrhh\".nomb_temp WHERE nced=e.nced) AND n.nced=e.nced) "
//						+ "WHEN 2 THEN (SELECT MAX(cargoc) FROM \"Rrhh\".cont c WHERE c.frige_cont=  (SELECT MAX(frige_cont) FROM \"Rrhh\".cont WHERE nced = e.nced) AND c.nced = e.nced) END "
//						+ "FROM \"Rrhh\".EMP E " + "WHERE e.nced like ?  ";
//
//				ps = con.prepareStatement(qry);
//				ps.setString(1, empleado.getNced());
//
//				ResultSet rs = ps.executeQuery();
//
//				while (rs.next()) {
//
//					empleado.setCargook(rs.getString(1));
//				}
//			}

			return empleado;

		} catch (NoResultException n) {
			return null;
		}

		catch (NonUniqueResultException n) {
			return null;

		} finally {
			super.cerrarConexion(con, ps);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> listaEmpleadoXCedula(String cedula) {
		StringBuilder queryString = new StringBuilder("SELECT e FROM Emp e where e.nced =?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> listaEmpleadoXCedulaActivo(String cedula) {
		StringBuilder queryString = new StringBuilder("SELECT e FROM Emp e where e.nced =?1 and (e.estemp.codEst != '2' and e.estemp.codEst != '8' and e.estemp.codEst != '10')" );
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula);
		return query.getResultList();
	}
	
	@Override
	public List<Emp> listaEmpleadonoContrato(int firstResult, int maxResults) {
		StringBuilder queryString = new StringBuilder("SELECT e FROM Emp e where (e.estemp = '1') "
				+ "and e.nced in (SELECT h.emp.nced FROM HistoriaLaboral h where h.accionP is null and h.fechaFin<now() and "
				+ "h.fechaRige = (Select max(hl.fechaRige) from HistoriaLaboral hl where h.emp.nced = hl.emp.nced ) "
				+ "and h.id.fechaI = (Select max(t.id.fechaI) "
				+ "from HistoriaLaboral t where t.id.idHist=h.id.idHist and h.emp.nced = t.emp.nced ) "
				+ "and h.id.idHist not in (Select g.id.idHist FROM HistoriaLaboral g where "
				+ " (trim(g.id.estado) = 'Duplicado' or trim(g.id.estado) = 'Anulado' or "
				+ " trim(g.id.estado) = 'Insubsistente' ) and h.emp.nced = g.emp.nced)) ");
		Query query = getEntityManager().createQuery(queryString.toString());
		if (firstResult > 0) {
			query.setFirstResult(firstResult);
		}

		if (maxResults > 0) {
			query.setMaxResults(maxResults);
		}
		return query.getResultList();
	}
	
	@Override
	public List<Emp> findEmpsByCedula(String nced, int firstResult, int maxResults){
		StringBuilder queryString = new StringBuilder("SELECT e FROM Emp e where (e.estemp = '1') "
				+ "and e.nced in (SELECT h.emp.nced FROM HistoriaLaboral h where h.accionP is null and h.fechaFin<now() and "
				+ "h.fechaRige = (Select max(hl.fechaRige) from HistoriaLaboral hl where h.emp.nced = hl.emp.nced )"
				+ "and h.id.fechaI = (Select max(t.id.fechaI) "
				+ "from HistoriaLaboral t where t.id.idHist=h.id.idHist and h.emp.nced = t.emp.nced ) "
				+ "and h.id.idHist not in (Select g.id.idHist FROM HistoriaLaboral g where "
				+ " (trim(g.id.estado) = 'Duplicado' or trim(g.id.estado) = 'Anulado' or "
				+ " trim(g.id.estado) = 'Insubsistente' ) and h.emp.nced = g.emp.nced)) and  e.nced like :cedula ");
		Query query = getEntityManager().createQuery(queryString.toString());	
		query.setParameter("cedula", nced);
		
		if (firstResult > 0) {
			query.setFirstResult(firstResult);
		}

		if (maxResults > 0) {
			query.setMaxResults(maxResults);
		}
		return query.getResultList();
	}
	
	
	@Override
	public long getCountEmpContrato() {
		StringBuilder queryString = new StringBuilder("SELECT count(e) FROM Emp e where (e.estemp = '1')"
				+ "and e.nced in (SELECT h.emp.nced FROM HistoriaLaboral h where h.accionP is null and h.fechaFin<now() and "
				+ "h.fechaRige = (Select max(hl.fechaRige) from HistoriaLaboral hl where h.emp.nced = hl.emp.nced ) "
				+ "and h.id.fechaI = (Select max(t.id.fechaI) "
				+ "from HistoriaLaboral t where t.id.idHist=h.id.idHist and h.emp.nced = t.emp.nced ) "
				+ "and h.id.idHist not in (Select g.id.idHist FROM HistoriaLaboral g where "
				+ " (trim(g.id.estado) = 'Duplicado' or trim(g.id.estado) = 'Anulado' or "
				+ " trim(g.id.estado) = 'Insubsistente' ) and h.emp.nced = g.emp.nced)) ");
		Query query = getEntityManager().createQuery(queryString.toString());
		return (long) query.getSingleResult();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> listaXParametros(String nombre, String apellido) {
		String estado = "A";
		StringBuilder queryString = new StringBuilder("SELECT plan FROM Emp plan where plan.nom like ?1");

		if (nombre != null && !nombre.equals(""))
			queryString.append(" and plan.nom like ?2 ");

		if (apellido != null && !apellido.equals(""))
			queryString.append(" and plan.apel like ?3");

		queryString.append(" order by plan.apel asc");
		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, "%" + estado + "%");

		if (nombre != null && !nombre.equals("")) {
			query.setParameter(2, "%" + nombre + "%");
		}

		if (apellido != null && !apellido.equals("")) {
			query.setParameter(3, "%" + apellido + "%");
		}

		return query.getResultList();
	}

	// **DATOS ALMACENADOS DE LA CLASE DOCENTE IMPL*/

	public ArrayList<DocenteDTO> docenteCIPersonal(String auxCIDoc, String auxNomDoc, String auxApelDoc, String auxDep,
			Long idUser, String perfilUsuario) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = super.getDataSource().getConnection();
			if (con != null && perfilUsuario.equals("Docente") || perfilUsuario.equals("Empleado")
					|| perfilUsuario.equals("Profesores")) {

				String qry = "SELECT  e.NCED, e.nom, e.apel, "
						+ "CASE cod_tiporelacionlab WHEN 1 THEN (SELECT p.cargo FROM \"Rrhh\".nomb_temp n, \"Rrhh\".partind p WHERE n.cod_pind= p.cod_pind AND n.frige_nomb = (SELECT MAX(frige_nomb) FROM \"Rrhh\".nomb_temp WHERE nced=e.nced) AND n.nced=e.nced) "
						+ "WHEN 2 THEN (SELECT MAX(cargoc) FROM \"Rrhh\".cont c WHERE c.frige_cont=  (SELECT MAX(frige_cont) FROM \"Rrhh\".cont WHERE nced = e.nced) AND c.nced = e.nced) END, "
						+ "d.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), e.ext, e.email1, e.email2, e.fec_ingsp "
						+ "FROM \"Rrhh\".EMP E, \"Rrhh\".DEP D , usuario u " + "WHERE E.COD_DEP = D.COD_DEP "
						+ "AND u.cedula= e.nced " + "AND e.cod_clase = '1' " +
						// "AND COD_EST IN ('1', '3', '4', '5', '6', '7')
						"AND u.id_usuario=? ";

				ps = con.prepareStatement(qry);

				ps.setLong(1, idUser);
				/*
				 * ps.setLong(2, idUser); ps.setLong(3, idUser);
				 */
				ResultSet rs = ps.executeQuery();

				ArrayList<DocenteDTO> listaDocenteCI = new ArrayList<DocenteDTO>();

				while (rs.next()) {

					DocenteDTO docen = new DocenteDTO();
					docen.setnCed(rs.getString(1));
					docen.setNombre(rs.getString(2));
					docen.setApel(rs.getString(3));
					docen.setDedicacion(rs.getString(4));
					docen.setNomDepartamento(rs.getString(5));
					docen.setCargo(rs.getString(4));

					if (rs.getString(6) == null || rs.getString(6).trim() == "") {
						docen.setAuxFechaIngresoEPN("     ");
					} else {
						docen.setAuxFechaIngresoEPN(rs.getString(6));
					}

					if (rs.getString(7) == null || rs.getString(7).trim() == "") {
						docen.setExtTelef("     ");
					} else {
						docen.setExtTelef(rs.getString(7));
					}

					if (rs.getString(8) == null || rs.getString(8).trim() == "") {
						docen.setEmail1("     ");
					} else {
						docen.setEmail1(rs.getString(8));
					}

					if (rs.getString(9) == null || rs.getString(9).trim() == "") {
						docen.setEmail2("     ");
					} else {
						docen.setEmail2(rs.getString(9));
					}

					docen.setFechaIngresoSP(rs.getDate(10));
					listaDocenteCI.add(docen);

				}

				ps.close();
				con.close();

				return listaDocenteCI;
			}

			if (con != null && (perfilUsuario.equals("Supervisor Talento Humano")
					|| perfilUsuario.equals("Revisor 1 Talento Humano") || perfilUsuario.equals("Decano")
					|| perfilUsuario.equals("Jefe Departamento") || perfilUsuario.equals("Rector")
					|| (perfilUsuario.equals("Planificacion")))) {
				String qry = "SELECT  e.NCED, e.nom, e.apel, "
						+ "CASE cod_tiporelacionlab WHEN 1 THEN (SELECT MAX(p.cargo) FROM \"Rrhh\".nomb_temp n, \"Rrhh\".partind p WHERE n.cod_pind= p.cod_pind AND n.frige_nomb = (SELECT MAX(frige_nomb) FROM \"Rrhh\".nomb_temp WHERE nced=e.nced) AND n.nced=e.nced) "
						+ "WHEN 2 THEN (SELECT MAX(cargoc) FROM \"Rrhh\".cont c WHERE c.frige_cont=  (SELECT MAX(frige_cont) FROM \"Rrhh\".cont WHERE nced = e.nced) AND c.nced = e.nced) END, "
						+ "d.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), "
						+ "CASE cod_tiporelacionlab WHEN 1 THEN 'NOMBRAMIENTO' WHEN 2 THEN 'CONTRATO' END "
						+ "FROM \"Rrhh\".EMP E, \"Rrhh\".DEP D " + "WHERE E.COD_DEP = D.COD_DEP " +
						// "AND COD_EST IN ('1', '3', '4', '5', '6', '7') "+
						"AND e.cod_clase = '1' " + "AND e.nced like ? " + "AND e.nom like ? " + "AND e.apel like ? ";

				String aux2 = "";
				if (auxDep.equals("%%")) {
					aux2 = "AND D.COD_DEP like ? ORDER BY e.apel";
				} else {
					aux2 = "AND D.COD_DEP = ? ORDER BY e.apel";
				}

				ps = con.prepareStatement(qry + " " + aux2);

				ps.setString(1, auxCIDoc);
				ps.setString(2, auxNomDoc + "%");
				ps.setString(3, auxApelDoc + "%");
				ps.setString(4, auxDep);

				ResultSet rs = ps.executeQuery();

				ArrayList<DocenteDTO> listaDocentes = new ArrayList<DocenteDTO>();

				while (rs.next()) {

					DocenteDTO docen = new DocenteDTO();
					docen.setnCed(rs.getString(1));
					docen.setNombre(rs.getString(2));
					docen.setApel(rs.getString(3));
					docen.setDedicacion(rs.getString(4));
					docen.setCargo(rs.getString(4));
					docen.setTipoDocente(rs.getString(7));
					docen.setNomDepartamento(rs.getString(5));
					if (rs.getString(6) == null || rs.getString(6).trim() == "") {
						docen.setAuxFechaIngresoEPN("     ");
					} else {
						docen.setAuxFechaIngresoEPN(rs.getString(6));
					}

					listaDocentes.add(docen);

				}

				ps.close();
				con.close();

				return listaDocentes;
			}

			else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			super.cerrarConexion(con, ps);
		}
	}

	// **DATOS ALMACENADOS DE LA CLASE DOCENTE IMPL*/

	public ArrayList<DocenteDTO> conusltaDatosDocentesGeneralPT(String cedula, Long idUsuario, String perfilUsuario) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = super.getDataSource().getConnection();
			if (con != null) {

				String qry = "SELECT  DISTINCT(e.NCED), e.nom, e.apel, p.cargo, d.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), e.ext, e.email1, e.email2 FROM "
						+ "\"Rrhh\".EMP E , \"Rrhh\".NOMB_TEMP N , \"Rrhh\".PARTIND P , \"Rrhh\".DEP D , "
						+ "\"Rrhh\". UNOMB UN, USUARIO U WHERE " + "E.NCED = N.NCED " + "AND  N.NCED = UN.NCED "
						+ "AND N.FRIGE_NOMB  =  UN.FRIGE_NOMB " + "AND  N.COD_PIND = P.COD_PIND "
						+ "AND  E.COD_DEPA = D.COD_DEP " + "AND   COD_EST IN ('1', '3', '4', '5', '6', '7') "
						+ "AND  E.COD_TIPORELACIONLAB = '1' " + "AND e.nced = u.cedula " + "AND e.nced = ? "
						+ "UNION ALL "
						+ "select DISTINCT(e.NCED), e.nom, e.apel, tc.desc_tcont, d.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), e.ext, e.email1, e.email2 "
						+ "from \"Rrhh\".EMP E, \"Rrhh\".DEP D, \"Rrhh\".cont C, \"Rrhh\".tcont tc, USUARIO U "
						+ "where E.COD_DEPA = D.COD_DEP " + "and tc.tcont in ('CPSA','CPSC','AC') "
						+ "and c.tcont = tc.tcont " + "and e.nced = c.nced " + "AND e.nced = u.cedula "
						+ "AND e.nced = ? " + "UNION ALL "
						+ "select CT.nced, e.nom, e.apel, CT.cargoc, D.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), e.ext, e.email1, e.email2 FROM \"Rrhh\".cont CT, "
						+ "\"Rrhh\".EMP E, \"Rrhh\".DEP D, \"Rrhh\".clasemp C, USUARIO U  "
						+ "where e.nced = u.cedula  " + "AND  E.COD_DEPA = D.COD_DEP  "
						+ "and C.cod_clase not in ('1') " + "and e.nced = CT.nced  " + "AND e.nced = ? "
						+ "GROUP BY CT.nced, e.nom, e.apel, CT.cargoc, D.nom_dep, e.fec_ingepn, e.ext, e.email1, e.email2  "
						+ "limit 1 ";

				ps = con.prepareStatement(qry);

				ps.setString(1, cedula);
				ps.setString(2, cedula);
				ps.setString(3, cedula);

				ResultSet rs = ps.executeQuery();

				ArrayList<DocenteDTO> listaDocenteCI = new ArrayList<DocenteDTO>();

				while (rs.next()) {

					DocenteDTO docen = new DocenteDTO();
					docen.setnCed(rs.getString(1));
					docen.setNombre(rs.getString(2));
					docen.setApel(rs.getString(3));
					docen.setDedicacion(rs.getString(4));
					docen.setNomDepartamento(rs.getString(5));

					if (rs.getString(6) == null || rs.getString(6).trim() == "") {
						docen.setAuxFechaIngresoEPN("     ");
					} else {
						docen.setAuxFechaIngresoEPN(rs.getString(6));
					}

					if (rs.getString(7) == null || rs.getString(7).trim() == "") {
						docen.setExtTelef("     ");
					} else {
						docen.setExtTelef(rs.getString(7));
					}

					if (rs.getString(8) == null || rs.getString(8).trim() == "") {
						docen.setEmail1("     ");
					} else {
						docen.setEmail1(rs.getString(8));
					}

					if (rs.getString(9) == null || rs.getString(9).trim() == "") {
						docen.setEmail2("     ");
					} else {
						docen.setEmail2(rs.getString(9));
					}

					listaDocenteCI.add(docen);

				}

				ps.close();
				con.close();

				return listaDocenteCI;
			}

			else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			super.cerrarConexion(con, ps);
		}
	}

	@Override
	public List<Emp> listaEmpleadoTipoContrato(Long idusuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DocenteDTO> listBusquedaDocentesXDep(String cedula, String nombre, String apellido,
			String departamento) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = super.getDataSource().getConnection();
			if (con != null) {
				String query = "SELECT  DISTINCT(e.NCED), e.nom, e.apel, d.nom_dep,  p.cargo,  e.cod_tiporelacionlab , to_date(e.fec_ingepn,'yyyy-MM-dd'), to_date(UN.frige_nomb,'yyyy-MM-dd') ,"
						+ "case when (e.cod_tiporelacionlab) = '1' then 'NOMBRAMIENTO' when (e.cod_tiporelacionlab) = '2' then 'CONTRATO' else '' end  "
						+ "FROM  \"Rrhh\".EMP E , \"Rrhh\".NOMB_TEMP N , \"Rrhh\".PARTIND P , \"Rrhh\".DEP D , "
						+ "\"Rrhh\". UNOMB UN, \"Rrhh\".clasemp C WHERE  " + "E.NCED = N.NCED  "
						+ "AND  N.NCED = UN.NCED  " + "AND N.FRIGE_NOMB  =  UN.FRIGE_NOMB  "
						+ "AND  N.COD_PIND = P.COD_PIND  " + "AND  E.COD_DEPA = D.COD_DEP  "
						+ "AND c.cod_clase = e.cod_clase " + "AND  E.COD_TIPORELACIONLAB = '1' "
						+ "AND  COD_EST IN ('1', '3', '4', '5', '6', '7') " + "AND c.cod_clase = '1' "
						+ "AND e.nced like ? " + "AND e.nom like ?  " + "AND e.apel like ? " + "AND D.COD_DEP like ?  "
						+ "UNION ALL "
						+ "select DISTINCT(e.NCED), e.nom, e.apel, d.nom_dep, tc.desc_tcont, e.cod_tiporelacionlab ,  to_date(e.fec_ingepn,'yyyy-MM-dd'),  to_date(vtc.frige_cont,'yyyy-MM-dd'),"
						+ "case when (e.cod_tiporelacionlab) = '1' then 'NOMBRAMIENTO' when (e.cod_tiporelacionlab) = '2' then 'CONTRATO' else '' end "
						+ "from \"Rrhh\".EMP E, \"Rrhh\".DEP D, \"Rrhh\".cont C, \"Rrhh\".tcont tc, \"Rrhh\".unCONT vtc "
						+ "where E.COD_DEPA = D.COD_DEP  " + " and vtc.nced = C.nced  "
						+ " and vtc.frige_cont = C.frige_cont  " + "AND tc.tcont in ('CPSA','CPSC','AC','CSO')  "
						+ "AND c.tcont = tc.tcont  " + "and e.nced = c.nced  " + "AND e.nced like ? "
						+ "AND e.nom like ?   " + "AND e.apel like ?  " + "AND D.COD_DEP like ?  "
						+ " AND e.nced not in (select DISTINCT(e.NCED) FROM  \"Rrhh\".EMP E , \"Rrhh\".NOMB_TEMP N , \"Rrhh\".PARTIND P , \"Rrhh\".DEP D , "
						+ " \"Rrhh\". UNOMB UN, \"Rrhh\".clasemp C WHERE  E.NCED = N.NCED  " + " AND  N.NCED = N.NCED  "
						+ " AND N.FRIGE_NOMB  =  UN.FRIGE_NOMB  " + " AND  N.COD_PIND = P.COD_PIND  "
						+ " AND  E.COD_DEPA = D.COD_DEP  " + " AND c.cod_clase = e.cod_clase "
						+ " AND  E.COD_TIPORELACIONLAB = '1' " + " AND  COD_EST IN ('1', '3', '4', '5', '6', '7') "
						+ " AND c.cod_clase = '1' " + " AND e.nced like ? )  ";

				ps = con.prepareStatement(query);
				ps.setString(1, cedula);
				ps.setString(2, nombre + "%");
				ps.setString(3, apellido + "%");
				ps.setString(4, departamento);
				ps.setString(5, cedula);
				ps.setString(6, nombre + "%");
				ps.setString(7, apellido + "%");
				ps.setString(8, departamento);
				ps.setString(9, cedula);

				ResultSet rs = ps.executeQuery();

				ArrayList<DocenteDTO> listaDocentes = new ArrayList<DocenteDTO>();

				while (rs.next()) {
					DocenteDTO docen = new DocenteDTO();
					docen.setnCed(rs.getString(1));
					docen.setNombre(rs.getString(2));
					docen.setApel(rs.getString(3));
					docen.setNomDepartamento(rs.getString(4));
					docen.setCargo(rs.getString(5));
					docen.setRelacionLab(rs.getString(6));

					if (rs.getString(7) == null || rs.getString(7).trim() == "") {
						docen.setAuxFechaIngresoEPN(" ");
					} else {
						docen.setAuxFechaIngresoEPN(rs.getString(7));
					}

					if (rs.getString(8) == null || rs.getString(8).trim() == "") {
						docen.setFechaContrat(" ");
					} else {
						docen.setFechaContrat(rs.getString(8));
					}

					listaDocentes.add(docen);

				}

				return listaDocentes;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			super.cerrarConexion(con, ps);
		}
	}

	@Override
	public ArrayList<DocenteDTO> BusqeudaDocenteRevalorizacion(String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep, List<String> depar) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		System.out.println("Departaments" + depar.size());

		if (depar.size() == 0) {
			depar.add("A");
			depar.add("B");
			depar.add("C");
			depar.add("D");

		}

		try {
			con = super.getDataSource().getConnection();
			if (con != null) {
				String qry = "SELECT  DISTINCT(e.NCED), e.nom, e.apel, d.nom_dep,  p.cargo,  e.cod_tiporelacionlab , to_date(e.fec_ingepn,'yyyy-MM-dd'), to_date(UN.frige_nomb,'yyyy-MM-dd') , d.cod_dep ,"
						+ "case when (e.cod_tiporelacionlab) = '1' then 'NOMBRAMIENTO' when (e.cod_tiporelacionlab) = '2' then 'CONTRATO' else '' end  "
						+ "FROM  \"Rrhh\".EMP E , \"Rrhh\".NOMB_TEMP N , \"Rrhh\".PARTIND P , \"Rrhh\".DEP D , "
						+ "\"Rrhh\". UNOMB UN, \"Rrhh\".clasemp C WHERE  " + "E.NCED = N.NCED  "
						+ "AND  N.NCED = UN.NCED  " + "AND N.FRIGE_NOMB  =  UN.FRIGE_NOMB  "
						+ "AND  N.COD_PIND = P.COD_PIND  " + "AND  E.COD_DEPA = D.COD_DEP  "
						+ "AND c.cod_clase = e.cod_clase " + "AND  E.COD_TIPORELACIONLAB = '1' "
						+ "AND  COD_EST IN ('1', '3', '4', '5', '6', '7') " + "AND c.cod_clase = '1' "
						+ "AND e.nced like ? " + "AND e.nom like ?  " + "AND e.apel like ? "
						+ "AND D.COD_DEP in (?,?,?,?)  " + "AND e.revaloriza in ('S','V','D')" + "UNION ALL "
						+ "select DISTINCT(e.NCED), e.nom, e.apel, d.nom_dep, tc.desc_tcont, e.cod_tiporelacionlab ,  to_date(e.fec_ingepn,'yyyy-MM-dd'),  to_date(vtc.frige_cont,'yyyy-MM-dd'),  d.cod_dep ,"
						+ "case when (e.cod_tiporelacionlab) = '1' then 'NOMBRAMIENTO' when (e.cod_tiporelacionlab) = '2' then 'CONTRATO' else '' end "
						+ "from \"Rrhh\".EMP E, \"Rrhh\".DEP D, \"Rrhh\".cont C, \"Rrhh\".tcont tc, \"Rrhh\".unCONT vtc "
						+ "where E.COD_DEPA = D.COD_DEP  " + " and vtc.nced = C.nced  "
						+ " and vtc.frige_cont = C.frige_cont  " + "AND tc.tcont in ('CPSA','CPSC','AC','CSO')  "
						+ "AND c.tcont = tc.tcont  " + "and e.nced = c.nced  " + "AND e.nced like ? "
						+ "AND e.nom like ?   " + "AND e.apel like ?  " + "AND D.COD_DEP in (?,?,?,?)  "
						+ " AND e.revaloriza in ('S','V','D') "
						+ " and e.nced not in (select DISTINCT(e.NCED) FROM  \"Rrhh\".EMP E , \"Rrhh\".NOMB_TEMP N , \"Rrhh\".PARTIND P , \"Rrhh\".DEP D , "
						+ " \"Rrhh\". UNOMB UN, \"Rrhh\".clasemp C WHERE  E.NCED = N.NCED  " + " AND  N.NCED = N.NCED  "
						+ " AND N.FRIGE_NOMB  =  UN.FRIGE_NOMB  " + " AND  N.COD_PIND = P.COD_PIND  "
						+ " AND  E.COD_DEPA = D.COD_DEP  " + " AND c.cod_clase = e.cod_clase "
						+ " AND  E.COD_TIPORELACIONLAB = '1' " + " AND  COD_EST IN ('1', '3', '4', '5', '6', '7') "
						+ " AND c.cod_clase = '1' " + " AND e.nced like ? " + " AND e.revaloriza in ('S','V','D') )  ";

				ps = con.prepareStatement(qry);

				ps.setString(1, auxCIDoc + "%");
				ps.setString(2, auxNomDoc + "%");
				ps.setString(3, auxApelDoc + "%");
				ps.setString(4, depar.get(0));
				ps.setString(5, depar.get(1));
				ps.setString(6, depar.get(2));
				ps.setString(7, depar.get(3));
				ps.setString(8, auxCIDoc + "%");
				ps.setString(9, auxNomDoc + "%");
				ps.setString(10, auxApelDoc + "%");
				ps.setString(11, depar.get(0));
				ps.setString(12, depar.get(1));
				ps.setString(13, depar.get(2));
				ps.setString(14, depar.get(3));
				ps.setString(15, auxCIDoc + "%");
				// ps.setString(5, auxCargo);

				ResultSet rs = ps.executeQuery();

				ArrayList<DocenteDTO> listaDocentes = new ArrayList<DocenteDTO>();

				while (rs.next()) {

					DocenteDTO docen = new DocenteDTO();
					docen.setnCed(rs.getString(1));
					docen.setNombre(rs.getString(2));
					docen.setApel(rs.getString(3));
					docen.setNomDepartamento(rs.getString(4));
					docen.setCargo(rs.getString(5));
					docen.setRelacionLab(rs.getString(6));
					if (rs.getString(7) == null || rs.getString(7).trim() == "") {
						docen.setAuxFechaIngresoEPN("     ");
					} else {
						docen.setAuxFechaIngresoEPN(rs.getString(7));
					}

					if (rs.getString(8) == null || rs.getString(8).trim() == "") {
						docen.setFechaContrat("     ");
					} else {
						docen.setFechaContrat(rs.getString(8));
					}

					if (rs.getString(9) == null || rs.getString(9).trim() == "") {
						docen.setNomFacultad("     ");
					} else {

						String coddep = rs.getString(9);

						System.out.println("Cod Facultad" + coddep.substring(0, 4));

						Dep depa = new Dep();

						depa = depDao.findDepbyCodigo(coddep.substring(0, 4));

						docen.setNomFacultad(depa.getNomDep());

					}

					listaDocentes.add(docen);

				}

				ps.close();
				con.close();

				return listaDocentes;
			} else {
				System.out.println("Error en la conexion");
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ENTRAMOS AL catch 1");
			return null;
		} finally {
			super.cerrarConexion(con, ps);
		}
	}

	@Override
	public ArrayList<NombramientoDTO> nombramientos(String cedula) {

		Connection con = null;
		PreparedStatement ps = null;

		// Cedula del Docente en Sesi�n
		String CI = cedula;
		ArrayList<NombramientoDTO> listanom = new ArrayList<NombramientoDTO>();

		try {
			con = super.getDataSource().getConnection();
			if (con != null)

			{
				String qry = "select p.cargo, p.categoria, to_date(n.frige_nomb,'yyyy-MM-dd') as inicio,  to_date(n.ffin_nomb,'yyyy-MM-dd')  "

						+ "from \"Rrhh\".partind p, " + "\"Rrhh\".nomb_temp n  "

						+ " where " + " trim(n.cod_pind ) = trim(p.cod_pind) and " + " n.nced = ?    " + " UNION ALL"
						+ "  select c.cargoc, tc.desc_tcont, to_date(c.frige_cont,'yyyy-MM-dd') inicio ,to_date(c.ffin_cont,'yyyy-MM-dd')"
						+ " from \"Rrhh\".cont c, \"Rrhh\".tcont tc " + " where trim(c.tcont) = trim(tc.tcont) and "
						+ " c.nced = ?   order by inicio DESC ";

				ps = con.prepareStatement(qry);

				ps.setString(1, CI);
				ps.setString(2, CI);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					NombramientoDTO ap = new NombramientoDTO();
					ap.setCargo(rs.getString(1));
					ap.setCategoria(rs.getString(2));
					ap.setFecha(rs.getString(3));

					if (rs.getString(4) == null || rs.getString(4).trim() == "") {
						ap.setFechaF("     ");
					} else {
						ap.setFechaF(rs.getString(4));
					}

					listanom.add(ap);

				}
				ps.close();
				con.close();

				return listanom;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ENTRAMOS AL catch 1");
			return null;

		} finally {
			super.cerrarConexion(con, ps);
		}
		return listanom;
	}

	@Override
	public ArrayList<DocenteDTO> BusqeudaDocenteRevalorizacionEnviada(String auxCIDoc, String auxNomDoc,
			String auxApelDoc, String auxDep) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = super.getDataSource().getConnection();
			if (con != null) {
				String qry = "SELECT  DISTINCT(e.NCED), e.nom, e.apel, d.nom_dep,  p.cargo,  e.cod_tiporelacionlab , to_date(e.fec_ingepn,'yyyy-MM-dd'), to_date(UN.frige_nomb,'yyyy-MM-dd') , d.cod_dep ,"
						+ "case when (e.cod_tiporelacionlab) = '1' then 'NOMBRAMIENTO' when (e.cod_tiporelacionlab) = '2' then 'CONTRATO' else '' end  "
						+ "FROM  \"Rrhh\".EMP E , \"Rrhh\".NOMB_TEMP N , \"Rrhh\".PARTIND P , \"Rrhh\".DEP D , "
						+ "\"Rrhh\". UNOMB UN, \"Rrhh\".clasemp C WHERE  " + "E.NCED = N.NCED  "
						+ "AND  N.NCED = UN.NCED  " + "AND N.FRIGE_NOMB  =  UN.FRIGE_NOMB  "
						+ "AND  N.COD_PIND = P.COD_PIND  " + "AND  E.COD_DEPA = D.COD_DEP  "
						+ "AND c.cod_clase = e.cod_clase " + "AND  E.COD_TIPORELACIONLAB = '1' "
						+ "AND  COD_EST IN ('1', '3', '4', '5', '6', '7') " + "AND c.cod_clase = '1' "
						+ "AND e.nced like ? " + "AND e.nom like ?  " + "AND e.apel like ? "

						+ "AND e.revaloriza in ('S','E') " + "UNION ALL "
						+ "select DISTINCT(e.NCED), e.nom, e.apel, d.nom_dep, tc.desc_tcont, e.cod_tiporelacionlab ,  to_date(e.fec_ingepn,'yyyy-MM-dd'),  to_date(vtc.frige_cont,'yyyy-MM-dd'),  d.cod_dep ,"
						+ "case when (e.cod_tiporelacionlab) = '1' then 'NOMBRAMIENTO' when (e.cod_tiporelacionlab) = '2' then 'CONTRATO' else '' end "
						+ "from \"Rrhh\".EMP E, \"Rrhh\".DEP D, \"Rrhh\".cont C, \"Rrhh\".tcont tc, \"Rrhh\".unCONT vtc "
						+ "where E.COD_DEPA = D.COD_DEP  " + " and vtc.nced = C.nced  "
						+ " and vtc.frige_cont = C.frige_cont  " + "AND tc.tcont in ('CPSA','CPSC','AC','CSO')  "
						+ "AND c.tcont = tc.tcont  " + "and e.nced = c.nced  " + "AND e.nced like ? "
						+ "AND e.nom like ?   " + "AND e.apel like ?  "

						+ " AND e.revaloriza in ('S','E')  "
						+ " and e.nced not in (select DISTINCT(e.NCED) FROM  \"Rrhh\".EMP E , \"Rrhh\".NOMB_TEMP N , \"Rrhh\".PARTIND P , \"Rrhh\".DEP D , "
						+ " \"Rrhh\". UNOMB UN, \"Rrhh\".clasemp C WHERE  E.NCED = N.NCED  " + " AND  N.NCED = N.NCED  "
						+ " AND N.FRIGE_NOMB  =  UN.FRIGE_NOMB  " + " AND  N.COD_PIND = P.COD_PIND  "
						+ " AND  E.COD_DEPA = D.COD_DEP  " + " AND c.cod_clase = e.cod_clase "
						+ " AND  E.COD_TIPORELACIONLAB = '1' " + " AND  COD_EST IN ('1', '3', '4', '5', '6', '7') "
						+ " AND c.cod_clase = '1' " + " AND e.nced like ? " + " AND e.revaloriza in ('S','E') )  ";

				ps = con.prepareStatement(qry);

				ps.setString(1, auxCIDoc + "%");
				ps.setString(2, auxNomDoc + "%");
				ps.setString(3, auxApelDoc + "%");

				ps.setString(4, auxCIDoc + "%");
				ps.setString(5, auxNomDoc + "%");
				ps.setString(6, auxApelDoc + "%");

				ps.setString(7, auxCIDoc);
				// ps.setString(5, auxCargo);

				ResultSet rs = ps.executeQuery();

				ArrayList<DocenteDTO> listaDocentes = new ArrayList<DocenteDTO>();

				DepDAOImplement dep = new DepDAOImplement();

				while (rs.next()) {

					DocenteDTO docen = new DocenteDTO();
					docen.setnCed(rs.getString(1));
					docen.setNombre(rs.getString(2));
					docen.setApel(rs.getString(3));
					docen.setNomDepartamento(rs.getString(4));
					docen.setCargo(rs.getString(5));
					docen.setRelacionLab(rs.getString(6));
					if (rs.getString(7) == null || rs.getString(7).trim() == "") {
						docen.setAuxFechaIngresoEPN("     ");
					} else {
						docen.setAuxFechaIngresoEPN(rs.getString(7));
					}

					if (rs.getString(8) == null || rs.getString(8).trim() == "") {
						docen.setFechaContrat("     ");
					} else {
						docen.setFechaContrat(rs.getString(8));
					}

					if (rs.getString(9) == null || rs.getString(9).trim() == "") {
						docen.setNomFacultad("     ");
					} else {

						String coddep = rs.getString(9);

						System.out.println("Cod Facultad" + coddep.substring(0, 4));

						Dep depa = new Dep();

						depa = depDao.findDepbyCodigo(coddep.substring(0, 4));

						docen.setNomFacultad(depa.getNomDep());

					}

					listaDocentes.add(docen);

				}

				ps.close();
				con.close();

				return listaDocentes;
			} else {
				System.out.println("Error en la conexion");
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ENTRAMOS AL catch 1");
			return null;
		} finally {
			super.cerrarConexion(con, ps);
		}
	}

	@Override
	public DocenteDTO buscarEmpHistoriaLab(String nced, Integer idPensum) throws Exception {

		try {
			Emp empleado = new Emp();
			DocenteDTO doc = new DocenteDTO();
			StringBuilder queryString = new StringBuilder("SELECT e from Emp e where e.nced = ?1 ");
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, nced.trim());

			empleado = (Emp) query.getSingleResult();

			Pensum pensum = new Pensum();
			pensum = pensumDAO.obtenerPensumById(idPensum);

			doc.setApel(empleado.getApel());
			doc.setNombre(empleado.getNom());
			doc.setnCed(empleado.getNced());
			doc.setAuxFechaIngresoEPN(empleado.getFecIngepn().toString());
			doc.setPeriodo(pensum == null ? "" : pensum.getMeses());

			DocenteDTO dto = new DocenteDTO();
			try {
				dto = this.cargoDedicacionRelLab(idPensum, 1, empleado.getNced());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			doc.setCargo(dto == null ? "" : dto.getCargo());

			try {
				dto = new DocenteDTO();
				dto = this.cargoDedicacionRelLab(idPensum, 2, empleado.getNced());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

			doc.setDedicacion(dto == null ? "" : dto.getDedicacion());

			try {
				dto = new DocenteDTO();
				dto = this.cargoDedicacionRelLab(idPensum, 3, empleado.getNced());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

			doc.setRelacionLab(dto == null ? "" : dto.getRelacionLab());

			try {
				dto = new DocenteDTO();
				dto = this.cargoDedicacionRelLab(idPensum, 4, empleado.getNced());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

			doc.setNomDepartamento(dto == null ? "" : dto.getNomDepartamento());

			try {
				dto = new DocenteDTO();
				dto = this.cargoDedicacionRelLab(idPensum, 6, empleado.getNced());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

			doc.setFechaContrat((dto == null ? "" : dto.getFechaContrat()));

			return doc;

		} catch (NoResultException n) {
			return null;
		}

		catch (NonUniqueResultException n) {
			return null;
		}

	}

	@Override
	public EmpleadoDTO buscarHistoriaEmpleado(String nced, Integer idPensum) throws Exception {

		try {
			Emp empleado = new Emp();
			EmpleadoDTO emp = new EmpleadoDTO();
			StringBuilder queryString = new StringBuilder("SELECT e from Emp e where e.nced = ?1 ");
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, nced.trim());

			empleado = (Emp) query.getSingleResult();

			Pensum pensum = new Pensum();
			pensum = pensumDAO.obtenerPensumById(idPensum);

			emp.setNombreEmpleado(empleado.getApel() + " " + empleado.getNom());
			emp.setNumCedula(empleado.getNced());
			emp.setFechaIngresoEPN(empleado.getFecIngepn().toString());
			// doc.setPeriodo(pensum==null?"":pensum.getMeses());

			DocenteDTO dto = new DocenteDTO();
			try {
				dto = this.cargoDedicacionRelLab(idPensum, 1, empleado.getNced());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			emp.setCargo(dto == null ? "" : dto.getCargo());
			try {
				dto = new DocenteDTO();
				dto = this.cargoDedicacionRelLab(idPensum, 2, empleado.getNced());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

			emp.setDedicacion(dto == null ? "" : dto.getDedicacion());

			try {
				dto = new DocenteDTO();
				dto = this.cargoDedicacionRelLab(idPensum, 3, empleado.getNced());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

			emp.setTipoContrato(dto == null ? "" : dto.getRelacionLab());

			try {
				dto = new DocenteDTO();
				dto = this.cargoDedicacionRelLab(idPensum, 4, empleado.getNced());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

			emp.setNombreDepartamento(dto == null ? "" : dto.getNomDepartamento());

			return emp;

		} catch (NoResultException n) {
			return null;
		}

		catch (NonUniqueResultException n) {
			return null;
		}

	}




	@Override
	public ArrayList<DocenteDTO> BusqeudaDocenteRecategorizacion(String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep, List<String> depar) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		if (depar.size() == 0) {
			depar.add("A");
			depar.add("B");
			depar.add("C");
			depar.add("D");

		}

		try {
			con = super.getDataSource().getConnection();
			if (con != null) {
				String qry = "SELECT  DISTINCT(e.NCED), e.nom, e.apel, d.nom_dep,  p.cargo,  e.cod_tiporelacionlab , to_date(e.fec_ingepn,'yyyy-MM-dd'), to_date(UN.frige_nomb,'yyyy-MM-dd') , d.cod_dep ,"
						+ "case when (e.cod_tiporelacionlab) = '1' then 'NOMBRAMIENTO' when (e.cod_tiporelacionlab) = '2' then 'CONTRATO' else '' end  "
						+ "FROM  \"Rrhh\".EMP E , \"Rrhh\".NOMB_TEMP N , \"Rrhh\".PARTIND P , \"Rrhh\".DEP D , "
						+ "\"Rrhh\". UNOMB UN, \"Rrhh\".clasemp C WHERE  " + "E.NCED = N.NCED  "
						+ "AND  N.NCED = UN.NCED  " + "AND N.FRIGE_NOMB  =  UN.FRIGE_NOMB  "
						+ "AND  N.COD_PIND = P.COD_PIND  " + "AND  E.COD_DEPA = D.COD_DEP  "
						+ "AND c.cod_clase = e.cod_clase " + "AND  E.COD_TIPORELACIONLAB = '1' "
						+ "AND  COD_EST IN ('1', '3', '4', '5', '6', '7') " + "AND c.cod_clase = '1' "
						+ "AND e.nced like ? " + "AND e.nom like ?  " + "AND e.apel like ? "
						+ "AND D.COD_DEP in (?,?,?,?)  " + "AND e.recategoriza in ('S','R','D')" + "UNION ALL "
						+ "select DISTINCT(e.NCED), e.nom, e.apel, d.nom_dep, tc.desc_tcont, e.cod_tiporelacionlab ,  to_date(e.fec_ingepn,'yyyy-MM-dd'),  to_date(vtc.frige_cont,'yyyy-MM-dd'), d.cod_dep ,"
						+ "case when (e.cod_tiporelacionlab) = '1' then 'NOMBRAMIENTO' when (e.cod_tiporelacionlab) = '2' then 'CONTRATO' else '' end "
						+ "from \"Rrhh\".EMP E, \"Rrhh\".DEP D, \"Rrhh\".cont C, \"Rrhh\".tcont tc, \"Rrhh\".unCONT vtc "
						+ "where E.COD_DEPA = D.COD_DEP  " + " and vtc.nced = C.nced  "
						+ " and vtc.frige_cont = C.frige_cont  " + "AND tc.tcont in ('CPSA','CPSC','AC','CSO')  "
						+ "AND c.tcont = tc.tcont  " + "and e.nced = c.nced  " + "AND e.nced like ? "
						+ "AND e.nom like ?   " + "AND e.apel like ?  " + "AND D.COD_DEP in (?,?,?,?)  "
						+ " AND e.recategoriza in ('S','R','D') "
						+ " and e.nced not in (select DISTINCT(e.NCED) FROM  \"Rrhh\".EMP E , \"Rrhh\".NOMB_TEMP N , \"Rrhh\".PARTIND P , \"Rrhh\".DEP D , "
						+ " \"Rrhh\". UNOMB UN, \"Rrhh\".clasemp C WHERE  E.NCED = N.NCED  " + " AND  N.NCED = N.NCED  "
						+ " AND N.FRIGE_NOMB  =  UN.FRIGE_NOMB  " + " AND  N.COD_PIND = P.COD_PIND  "
						+ " AND  E.COD_DEPA = D.COD_DEP  " + " AND c.cod_clase = e.cod_clase "
						+ " AND  E.COD_TIPORELACIONLAB = '1' " + " AND  COD_EST IN ('1', '3', '4', '5', '6', '7') "
						+ " AND c.cod_clase = '1' " + " AND e.nced like ? "
						+ " AND e.recategoriza in ('S','R','D') )  ";

				ps = con.prepareStatement(qry);

				ps.setString(1, auxCIDoc + "%");
				ps.setString(2, auxNomDoc + "%");
				ps.setString(3, auxApelDoc + "%");
				ps.setString(4, depar.get(0));
				ps.setString(5, depar.get(1));
				ps.setString(6, depar.get(2));
				ps.setString(7, depar.get(3));
				ps.setString(8, auxCIDoc + "%");
				ps.setString(9, auxNomDoc + "%");
				ps.setString(10, auxApelDoc + "%");
				ps.setString(11, depar.get(0));
				ps.setString(12, depar.get(1));
				ps.setString(13, depar.get(2));
				ps.setString(14, depar.get(3));
				ps.setString(15, auxCIDoc + "%");
				// ps.setString(5, auxCargo);

				ResultSet rs = ps.executeQuery();

				ArrayList<DocenteDTO> listaDocentes = new ArrayList<DocenteDTO>();

				while (rs.next()) {

					DocenteDTO docen = new DocenteDTO();
					docen.setnCed(rs.getString(1));
					docen.setNombre(rs.getString(2));
					docen.setApel(rs.getString(3));
					docen.setNomDepartamento(rs.getString(4));
					docen.setCargo(rs.getString(5));
					docen.setRelacionLab(rs.getString(6));
					if (rs.getString(7) == null || rs.getString(7).trim() == "") {
						docen.setAuxFechaIngresoEPN("     ");
					} else {
						docen.setAuxFechaIngresoEPN(rs.getString(7));
					}

					if (rs.getString(8) == null || rs.getString(8).trim() == "") {
						docen.setFechaContrat("     ");
					} else {
						docen.setFechaContrat(rs.getString(8));
					}

					if (rs.getString(9) == null || rs.getString(9).trim() == "") {
						docen.setNomFacultad("     ");
					} else {

						String coddep = rs.getString(9);

						System.out.println("Cod Facultad" + coddep.substring(0, 4));

						Dep depa = new Dep();

						depa = depDao.findDepbyCodigo(coddep.substring(0, 4));

						docen.setNomFacultad(depa.getNomDep());

					}

					listaDocentes.add(docen);

				}

				ps.close();
				con.close();

				return listaDocentes;
			} else {
				System.out.println("Error en la conexion");
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ENTRAMOS AL catch 1");
			return null;
		} finally {
			super.cerrarConexion(con, ps);
		}
	}

	@Override
	public ArrayList<DocenteDTO> BusqeudaDocenteRecateogrizacionEnviada(String auxCIDoc, String auxNomDoc,
			String auxApelDoc, String auxDep) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = super.getDataSource().getConnection();
			if (con != null) {
				String qry = "SELECT  DISTINCT(e.NCED), e.nom, e.apel, d.nom_dep,  p.cargo,  e.cod_tiporelacionlab , to_date(e.fec_ingepn,'yyyy-MM-dd'), to_date(UN.frige_nomb,'yyyy-MM-dd') , d.cod_dep ,"
						+ "case when (e.cod_tiporelacionlab) = '1' then 'NOMBRAMIENTO' when (e.cod_tiporelacionlab) = '2' then 'CONTRATO' else '' end  "
						+ "FROM  \"Rrhh\".EMP E , \"Rrhh\".NOMB_TEMP N , \"Rrhh\".PARTIND P , \"Rrhh\".DEP D , "
						+ "\"Rrhh\". UNOMB UN, \"Rrhh\".clasemp C WHERE  " + "E.NCED = N.NCED  "
						+ "AND  N.NCED = UN.NCED  " + "AND N.FRIGE_NOMB  =  UN.FRIGE_NOMB  "
						+ "AND  N.COD_PIND = P.COD_PIND  " + "AND  E.COD_DEPA = D.COD_DEP  "
						+ "AND c.cod_clase = e.cod_clase " + "AND  E.COD_TIPORELACIONLAB = '1' "
						+ "AND  COD_EST IN ('1', '3', '4', '5', '6', '7') " + "AND c.cod_clase = '1' "
						+ "AND e.nced like ? " + "AND e.nom like ?  " + "AND e.apel like ? "

						+ "AND e.recategoriza in ('S','R','E') and e.estadorecategoriza in ('E') " + "UNION ALL "
						+ "select DISTINCT(e.NCED), e.nom, e.apel, d.nom_dep, tc.desc_tcont, e.cod_tiporelacionlab ,  to_date(e.fec_ingepn,'yyyy-MM-dd'),  to_date(vtc.frige_cont,'yyyy-MM-dd'), d.cod_dep ,"
						+ "case when (e.cod_tiporelacionlab) = '1' then 'NOMBRAMIENTO' when (e.cod_tiporelacionlab) = '2' then 'CONTRATO' else '' end "
						+ "from \"Rrhh\".EMP E, \"Rrhh\".DEP D, \"Rrhh\".cont C, \"Rrhh\".tcont tc, \"Rrhh\".unCONT vtc "
						+ "where E.COD_DEPA = D.COD_DEP  " + " and vtc.nced = C.nced  "
						+ " and vtc.frige_cont = C.frige_cont  " + "AND tc.tcont in ('CPSA','CPSC','AC','CSO')  "
						+ "AND c.tcont = tc.tcont  " + "and e.nced = c.nced  " + "AND e.nced like ? "
						+ "AND e.nom like ?   " + "AND e.apel like ?  "

						+ " AND e.recategoriza in ('S','R','E') and e.estadorecategoriza in ('E') "
						+ " and e.nced not in (select DISTINCT(e.NCED) FROM  \"Rrhh\".EMP E , \"Rrhh\".NOMB_TEMP N , \"Rrhh\".PARTIND P , \"Rrhh\".DEP D , "
						+ " \"Rrhh\". UNOMB UN, \"Rrhh\".clasemp C WHERE  E.NCED = N.NCED  " + " AND  N.NCED = N.NCED  "
						+ " AND N.FRIGE_NOMB  =  UN.FRIGE_NOMB  " + " AND  N.COD_PIND = P.COD_PIND  "
						+ " AND  E.COD_DEPA = D.COD_DEP  " + " AND c.cod_clase = e.cod_clase "
						+ " AND  E.COD_TIPORELACIONLAB = '1' " + " AND  COD_EST IN ('1', '3', '4', '5', '6', '7') "
						+ " AND c.cod_clase = '1' " + " AND e.nced like ? "
						+ " AND e.recategoriza in ('S','R','E') and e.estadorecategoriza in ('E'))  ";

				ps = con.prepareStatement(qry);

				ps.setString(1, auxCIDoc + "%");
				ps.setString(2, auxNomDoc + "%");
				ps.setString(3, auxApelDoc + "%");

				ps.setString(4, auxCIDoc + "%");
				ps.setString(5, auxNomDoc + "%");
				ps.setString(6, auxApelDoc + "%");

				ps.setString(7, auxCIDoc + "%");
				// ps.setString(5, auxCargo);

				ResultSet rs = ps.executeQuery();

				ArrayList<DocenteDTO> listaDocentes = new ArrayList<DocenteDTO>();
				DepDAOImplement dep = new DepDAOImplement();

				while (rs.next()) {

					DocenteDTO docen = new DocenteDTO();
					docen.setnCed(rs.getString(1));
					docen.setNombre(rs.getString(2));
					docen.setApel(rs.getString(3));
					docen.setNomDepartamento(rs.getString(4));
					docen.setCargo(rs.getString(5));
					docen.setRelacionLab(rs.getString(6));
					if (rs.getString(7) == null || rs.getString(7).trim() == "") {
						docen.setAuxFechaIngresoEPN("     ");
					} else {
						docen.setAuxFechaIngresoEPN(rs.getString(7));
					}

					if (rs.getString(8) == null || rs.getString(8).trim() == "") {
						docen.setFechaContrat("     ");
					} else {
						docen.setFechaContrat(rs.getString(8));
					}

					if (rs.getString(9) == null || rs.getString(9).trim() == "") {
						docen.setNomFacultad("     ");
					} else {

						String coddep = rs.getString(9);

						System.out.println("Cod Facultad" + coddep.substring(0, 4));

						Dep depa = new Dep();

						depa = depDao.findDepbyCodigo(coddep.substring(0, 4));

						docen.setNomFacultad(depa.getNomDep());

					}

					listaDocentes.add(docen);

				}

				ps.close();
				con.close();

				return listaDocentes;
			} else {
				System.out.println("Error en la conexion");
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ENTRAMOS AL catch 1");
			return null;
		} finally {
			super.cerrarConexion(con, ps);
		}
	}

	@Override
	public List<Emp> findEMPBYPARAMS(String nom, String apel, String coddep, String nced) {
		StringBuilder querys = new StringBuilder("SELECT e FROM Emp e where e.clasemp.codClase =?0");

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

	public ArrayList<DocenteDTO> listDocenteSeleccionado(String cedula, String nombre, String apellido,
			String departamento, String idPeriodo, String perfilSeleccionado) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String estadoPlanificacion;

		try {

			estadoPlanificacion = perfilSeleccionado.equals("Decano") ? " AND PD.estado ='REV' "
					: (perfilSeleccionado.equals("Jefe Departamento") ? " AND PD.estado IN('ENV', 'REV') " : "");
			con = dataSource.getConnection();
			if (con != null) {
				String qry = "SELECT  DISTINCT(e.NCED), e.nom, e.apel, d.nom_dep,  p.cargo,  "
						+ "case when (e.cod_tiporelacionlab) = '1' then 'NOMBRAMIENTO' when (e.cod_tiporelacionlab) = '2' then 'CONTRATO' else '' end , PER.periodo, PER.id_periodo "
						+ "FROM \"Rrhh\".EMP E ,\"Rrhh\".NOMB_TEMP N ,\"Rrhh\".PARTIND P ,\"Rrhh\".DEP D , "
						+ "\"Rrhh\". UNOMB UN,\"Rrhh\".clasemp C, \"GestionDocente\".planif_docente PD, \"GestionDocente\".periodo PER "
						+ "WHERE E.NCED = N.NCED " + "AND  N.NCED = UN.NCED " + "AND N.FRIGE_NOMB  =  UN.FRIGE_NOMB "
						+ "AND  N.COD_PIND = P.COD_PIND " + "AND  E.COD_DEPA = D.COD_DEP "
						+ "AND c.cod_clase = e.cod_clase " + "AND UN.NCED= PD.nced "
						+ "AND PD.id_pensum=PER.id_periodo " + "AND PER.mostrar='S' " + "AND e.nced LIKE ? "
						+ "AND e.nom LIKE ? " + "AND e.apel LIKE ? " + "AND PER.id_periodo LIKE ? "
						+ "AND D.COD_DEP like ? " + estadoPlanificacion + "ORDER BY e.apel, e.nom ";

				ps = con.prepareStatement(qry);

				ps.setString(1, cedula);
				ps.setString(2, nombre + "%");
				ps.setString(3, apellido + "%");
				ps.setString(4, idPeriodo);
				ps.setString(5, departamento);
				ResultSet rs = ps.executeQuery();

				ArrayList<DocenteDTO> listaDocentes = new ArrayList<DocenteDTO>();

				while (rs.next()) {

					DocenteDTO docen = new DocenteDTO();
					docen.setnCed(rs.getString(1));
					docen.setNombre(rs.getString(2));
					docen.setApel(rs.getString(3));
					docen.setNomDepartamento(rs.getString(4));
					docen.setCargo(rs.getString(5));
					docen.setRelacionLab(rs.getString(6));
					docen.setPeriodo(rs.getString(7));
					docen.setIdPeriodo(rs.getString(8));
					listaDocentes.add(docen);

				}

				return listaDocentes;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			ps.close();
			con.close();
		}
	}

	public ArrayList<DocenteDTO> listDocenteSeleccionadoEjecucion(String cedula, String nombre, String apellido,
			String departamento, String idPeriodo, String perfilSeleccionado) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String estadoPlanificacion;

		try {

			// estadoPlanificacion= perfilSeleccionado.equals("Decano")?" AND
			// PD.estado ='EJEC' ":(perfilSeleccionado.equals("Jefe
			// Departamento")?" AND PD.estado IN('ENV', 'REV') ":"");
			estadoPlanificacion = "AND PD.estado IN ('EJEC', 'REVEJ')";
			con = dataSource.getConnection();
			if (con != null) {
				String qry = "SELECT  DISTINCT(e.NCED), e.nom, e.apel, d.nom_dep,  p.cargo,  "
						+ "case when (e.cod_tiporelacionlab) = '1' then 'NOMBRAMIENTO' when (e.cod_tiporelacionlab) = '2' then 'CONTRATO' else '' end , PER.periodo, PER.id_periodo "
						+ "FROM \"Rrhh\".EMP E ,\"Rrhh\".NOMB_TEMP N ,\"Rrhh\".PARTIND P ,\"Rrhh\".DEP D , "
						+ "\"Rrhh\". UNOMB UN,\"Rrhh\".clasemp C, \"GestionDocente\".planif_docente PD, \"GestionDocente\".periodo PER "
						+ "WHERE E.NCED = N.NCED " + "AND  N.NCED = UN.NCED " + "AND N.FRIGE_NOMB  =  UN.FRIGE_NOMB "
						+ "AND  N.COD_PIND = P.COD_PIND " + "AND  E.COD_DEPA = D.COD_DEP "
						+ "AND c.cod_clase = e.cod_clase " + "AND UN.NCED= PD.nced "
						+ "AND PD.id_pensum=PER.id_periodo " + "AND PER.mostrar='S' " + "AND e.nced LIKE ? "
						+ "AND e.nom LIKE ? " + "AND e.apel LIKE ? " + "AND PER.id_periodo LIKE ? "
						+ "AND D.COD_DEP like ? " + estadoPlanificacion + "ORDER BY e.apel, e.nom ";

				ps = con.prepareStatement(qry);

				ps.setString(1, cedula);
				ps.setString(2, nombre + "%");
				ps.setString(3, apellido + "%");
				ps.setString(4, idPeriodo);
				ps.setString(5, departamento);
				ResultSet rs = ps.executeQuery();

				ArrayList<DocenteDTO> listaDocentes = new ArrayList<DocenteDTO>();

				while (rs.next()) {

					DocenteDTO docen = new DocenteDTO();
					docen.setnCed(rs.getString(1));
					docen.setNombre(rs.getString(2));
					docen.setApel(rs.getString(3));
					docen.setNomDepartamento(rs.getString(4));
					docen.setCargo(rs.getString(5));
					docen.setRelacionLab(rs.getString(6));
					docen.setPeriodo(rs.getString(7));
					docen.setIdPeriodo(rs.getString(8));
					listaDocentes.add(docen);

				}

				return listaDocentes;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			ps.close();
			con.close();
		}
	}

	@Override
	public List<EmpleadoDTO> findEmpFacDep(String nombreCedulaEmpelado) throws Exception {
		System.out.println("Lista Empleados");

		List<EmpleadoDTO> listEmpDTO = new ArrayList<EmpleadoDTO>();
		Query query = null;

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
				dto.setNombreDepartamento(fila[2] == null ? "" : fila[2].toString());
				dto.setTipoPersona(fila[3] == null ? "" : fila[3].toString());
				dto.setTipoContrato(fila[4] == null ? "" : fila[4].toString());
				dto.setDedicacion(fila[5] == null ? "" : fila[5].toString());
				dto.setNombrefacultad(fila[6] == null ? "" : fila[6].toString());

				listEmpDTO.add(dto);
			}
		}
		return listEmpDTO;
	}

	@Override
	public ArrayList<DocenteDTO> listDocenteDepartamento(Long idUser, String auxCIDoc, String auxNomDoc,
			String auxApelDoc, String auxDep, String perfilUsuario) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			if (con != null && perfilUsuario.contains("Docente") || perfilUsuario.equals("Empleado")
					|| perfilUsuario.equals("Profesores")) {

				String qry = "SELECT  e.NCED, e.nom, e.apel, ''," +
				// "CASE cod_tiporelacionlab WHEN 1 THEN (SELECT p.cargo FROM
				// \"Rrhh\".nomb_temp n, \"Rrhh\".partind p WHERE n.cod_pind=
				// p.cod_pind AND n.frige_nomb = (SELECT MAX(frige_nomb) FROM
				// \"Rrhh\".nomb_temp WHERE nced=e.nced) AND n.nced=e.nced) "+
				// "WHEN 2 THEN (SELECT MAX(cargoc) FROM \"Rrhh\".cont c WHERE
				// c.frige_cont= (SELECT MAX(frige_cont) FROM \"Rrhh\".cont
				// WHERE nced = e.nced) AND c.nced = e.nced) END, "+
						"d.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), e.ext, e.email1, "
						+ "CASE cod_tiporelacionlab WHEN 1 THEN 'NOMBRAMIENTO' WHEN 2 THEN 'CONTRATO' END, "
						+ "e.fec_ingsp, d.cod_dep " + "FROM \"Rrhh\".EMP E, \"Rrhh\".DEP D , usuario u "
						+ "WHERE E.COD_DEP = D.COD_DEP " + "AND u.cedula= e.nced " + "AND e.cod_clase = '1' " +
						// "AND COD_EST IN ('1', '3', '4', '5', '6', '7')
						"AND u.id_usuario=? ";

				ps = con.prepareStatement(qry);

				ps.setLong(1, idUser);

				ResultSet rs = ps.executeQuery();

				ArrayList<DocenteDTO> listaDocenteCI = new ArrayList<DocenteDTO>();

				while (rs.next()) {

					DocenteDTO dto = new DocenteDTO();
					dto.setnCed(rs.getString(1));
					dto.setNombre(rs.getString(2));
					dto.setApel(rs.getString(3));
					dto.setCargo(rs.getString(4));
					dto.setNomDepartamento(rs.getString(5));
					dto.setTipoDocente(rs.getString(9));
					dto.setIdDepartamento(rs.getString(11));

					if (rs.getString(6) == null || rs.getString(6).trim() == "") {
						dto.setAuxFechaIngresoEPN("  ");
					} else {
						dto.setAuxFechaIngresoEPN(rs.getString(6));
					}

					listaDocenteCI.add(dto);

				}

				ps.close();
				con.close();

				return listaDocenteCI;
			}

			if (con != null
					&& (perfilUsuario.equals("Vicerrectorado Docencia") || perfilUsuario.equals("Jefe Departamento"))) {

				String qry = "SELECT  e.NCED, e.nom, e.apel, "
						+ "CASE cod_tiporelacionlab WHEN 1 THEN (SELECT p.cargo FROM \"Rrhh\".nomb_temp n, \"Rrhh\".partind p WHERE n.cod_pind= p.cod_pind AND n.frige_nomb = (SELECT MAX(frige_nomb) FROM \"Rrhh\".nomb_temp WHERE nced=e.nced) AND n.nced=e.nced) "
						+ "WHEN 2 THEN (SELECT MAX(cargoc) FROM \"Rrhh\".cont c WHERE c.frige_cont=  (SELECT MAX(frige_cont) FROM \"Rrhh\".cont WHERE nced = e.nced) AND c.nced = e.nced) END, "
						+ "d.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), "
						+ "CASE cod_tiporelacionlab WHEN 1 THEN 'NOMBRAMIENTO' WHEN 2 THEN 'CONTRATO' END "
						+ "FROM \"Rrhh\".EMP E, \"Rrhh\".DEP D " + "WHERE E.COD_DEP = D.COD_DEP "
						+ "AND COD_EST IN ('1', '3', '4', '5', '6', '7') " + "AND e.cod_clase = '1' "
						+ "AND e.nced like ? " + "AND e.nom like ? " + "AND e.apel like ? "
						+ "AND D.COD_DEP like ? ORDER BY e.apel";

				ps = con.prepareStatement(qry);

				ps.setString(1, auxCIDoc);
				ps.setString(2, auxNomDoc + "%");
				ps.setString(3, auxApelDoc + "%");
				ps.setString(4, auxDep);

				ResultSet rs = ps.executeQuery();

				ArrayList<DocenteDTO> listaDocentes = new ArrayList<DocenteDTO>();

				while (rs.next()) {

					DocenteDTO dto = new DocenteDTO();
					dto.setnCed(rs.getString(1));
					dto.setNombre(rs.getString(2));
					dto.setApel(rs.getString(3));
					dto.setCargo(rs.getString(4));
					dto.setNomDepartamento(rs.getString(5));

					if (rs.getString(6) == null || rs.getString(6).trim() == "") {
						dto.setAuxFechaIngresoEPN("  ");
					} else {
						dto.setAuxFechaIngresoEPN(rs.getString(6));
					}

					dto.setTipoDocente(rs.getString(7));

					listaDocentes.add(dto);

				}

				ps.close();
				con.close();

				return listaDocentes;
			}

			else {
				System.out.println("Error en la conexion");
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			ps.close();
			con.close();
		}
	}

	@Override
	public ArrayList<DocenteDTO> calculoEvaluacionXCedulaDoc(String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep, String perfilUsuario, Integer idPensum) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			if (con != null) {

				String qry = "SELECT DISTINCT MAX(e.NCED), e.nom, e.apel, "
						+ "CASE cod_tiporelacionlab WHEN 1 THEN (SELECT p.cargo FROM \"Rrhh\".nomb_temp n, \"Rrhh\".partind p WHERE n.cod_pind= p.cod_pind AND n.frige_nomb = (SELECT MAX(frige_nomb) FROM \"Rrhh\".nomb_temp WHERE nced=e.nced) AND n.nced=e.nced) "
						+ "WHEN 2 THEN (SELECT MAX(cargoc) FROM \"Rrhh\".cont c WHERE c.frige_cont=  (SELECT MAX(frige_cont) FROM \"Rrhh\".cont WHERE nced = e.nced) AND c.nced = e.nced) END as cargook, "
						+ "d.nom_dep, id_periodo, "
						+ "(SELECT CASE max(r.tipo_eval) WHEN 'EVAL' THEN 'AutoEvaluaci�n' ELSE '' END  FROM \"GestionDocente\".resultado_eval  r WHERE  r.nced=  MAX(e.NCED)) AS auto, "
						+ "(SELECT CASE min(r.tipo_eval) WHEN 'COEV' THEN 'CoEvaluaci�n' ELSE '' END  FROM \"GestionDocente\".resultado_eval  r WHERE  r.nced=  MAX(e.NCED)) AS coe "
						+ "FROM \"Rrhh\".EMP E, \"Rrhh\".DEP D, \"GestionDocente\".resultado_eval reval, \"GestionDocente\".periodo p "
						+ "WHERE E.COD_DEP = D.COD_DEP " + "AND reval.nced= E.nced "
						+ "AND COD_EST IN ('1', '3', '4', '5', '6', '7') " + "AND e.cod_clase = '1' "
						+ "AND p.id_pensum= reval.id_pensum " + "AND e.nced LIKE ? " + "AND e.nom LIKE ? "
						+ "AND e.apel LIKE ? " + "AND D.COD_DEP LIKE ? " + "AND reval.id_pensum = ? "
						+ "GROUP BY  e.nom, e.apel, cargook, d.nom_dep, tipo_eval, id_periodo " + "ORDER BY e.apel";

				ps = con.prepareStatement(qry);
				ps.setString(1, auxCIDoc);
				ps.setString(2, auxNomDoc + "%");
				ps.setString(3, auxApelDoc + "%");
				ps.setString(4, auxDep);
				ps.setInt(5, idPensum);

				ResultSet rs = ps.executeQuery();

				ArrayList<DocenteDTO> listaDocentes = new ArrayList<DocenteDTO>();

				while (rs.next()) {

					DocenteDTO dto = new DocenteDTO();
					dto.setnCed(rs.getString(1));
					dto.setNombre(rs.getString(2));
					dto.setApel(rs.getString(3));
					dto.setCargo(rs.getString(4));
					dto.setNomDepartamento(rs.getString(5));
					dto.setPeriodo(rs.getString(6));
					dto.setTipoEval(rs.getString(7));
					dto.setTipoCoEval(rs.getString(8));

					listaDocentes.add(dto);

				}

				ps.close();
				con.close();

				return listaDocentes;
			}

			else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			ps.close();
			con.close();
		}
	}

	@Override
	public ArrayList<DocenteDTO> docenteCIPersonalEvaluacion(String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep, String perfilUsuario, String tipoEval, Integer idPensum) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			if (con != null && (perfilUsuario.equals("Supervisor Talento Humano")
					|| perfilUsuario.equals("Revisor 1 Talento Humano") || perfilUsuario.equals("Decano")
					|| perfilUsuario.equals("Jefe Departamento") || perfilUsuario.equals("Rector")
					|| (perfilUsuario.equals("Planificacion")))) {

				String qry = "SELECT  e.NCED, e.nom, e.apel, "
						+ "CASE cod_tiporelacionlab WHEN 1 THEN (SELECT p.cargo FROM \"Rrhh\".nomb_temp n, \"Rrhh\".partind p WHERE n.cod_pind= p.cod_pind AND n.frige_nomb = (SELECT MAX(frige_nomb) FROM \"Rrhh\".nomb_temp WHERE nced=e.nced) AND n.nced=e.nced) "
						+ "WHEN 2 THEN (SELECT MAX(cargoc) FROM \"Rrhh\".cont c WHERE c.frige_cont=  (SELECT MAX(frige_cont) FROM \"Rrhh\".cont WHERE nced = e.nced) AND c.nced = e.nced) END as cargook, "
						+ "d.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), "
						+ "CASE tipo_eval WHEN 'EVAL' THEN 'AutoEvaluaci�n' WHEN 'COEV' THEN 'CoEvaluaci�n' END "
						+ "FROM \"Rrhh\".EMP E, \"Rrhh\".DEP D, \"GestionDocente\".resultado_eval reval "
						+ "WHERE E.COD_DEP = D.COD_DEP " + "AND reval.nced= E.nced "
						+ "AND COD_EST IN ('1', '3', '4', '5', '6', '7') " + "AND e.cod_clase = '1' "
						+ "AND reval.tipo_eval LIKE ? " + "AND e.nced LIKE ? " + "AND e.nom LIKE ? "
						+ "AND e.apel LIKE ? " + "AND D.COD_DEP LIKE ? " + "AND reval.id_pensum = ? "
						+ "ORDER BY e.apel";

				ps = con.prepareStatement(qry);

				ps.setString(1, tipoEval);
				ps.setString(2, auxCIDoc);
				ps.setString(3, auxNomDoc + "%");
				ps.setString(4, auxApelDoc + "%");
				ps.setString(5, auxDep);
				ps.setInt(6, idPensum);

				ResultSet rs = ps.executeQuery();

				ArrayList<DocenteDTO> listaDocentes = new ArrayList<DocenteDTO>();

				while (rs.next()) {

					DocenteDTO dto = new DocenteDTO();
					dto.setnCed(rs.getString(1));
					dto.setNombre(rs.getString(2));
					dto.setApel(rs.getString(3));
					dto.setCargo(rs.getString(4));
					dto.setNomDepartamento(rs.getString(5));

					if (rs.getString(6) == null || rs.getString(6).trim() == "") {
						dto.setAuxFechaIngresoEPN("  ");
					} else {
						dto.setAuxFechaIngresoEPN(rs.getString(6));
					}

					dto.setTipoEval(rs.getString(7));
					listaDocentes.add(dto);
				}

				ps.close();
				con.close();

				return listaDocentes;
			}

			else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			ps.close();
			con.close();
		}
	}

	@Override
	public Long countEmpxCed(String nced) throws Exception {
		Query q = getEntityManager().createQuery("SELECT count(e) FROM Emp e WHERE e.nced like ?");

		q.setParameter(1, nced);
		return (Long) q.getSingleResult();
	}

	@Override
	public ArrayList<DocenteDTO> docenteCIPlanifActividades(String auxCIDoc, String auxNomDoc, String auxApelDoc,
			String auxDep, Integer idPensum) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			if (con != null) {

				String qry = "SELECT e.nced, e.apel, e.nom, d.nom_dep, COALESCE(UPPER(e.cargook), ''),COALESCE(e.\"COD_DEDICACION\", ''), "
						+ "to_char((coev + autoev + heteroev), '990.09') AS notaFinal, "
						+ "(SELECT to_char((((pre.valor * 16) + (pre.valor_2 * 8)) * 100)/960, '990.09') "
						+ "FROM \"Catalogos\".preguntas_evaluacion pe, \"GestionDocente\".preg_resultado_eval pre, \"GestionDocente\".resultado_eval re "
						+ "WHERE pe.id_preguntas_eval= pre.id_preguntas_eval "
						+ "AND pre.id_resultado_eval= re.id_resultado_eval " + "AND pe.tipo= 'COEV' "
						+ "AND pe.asignacion ='HORAS' AND re.nced LIKE  e.nced "
						+ "AND re.id_pensum = ce.id_pensum AND upper(pe.detalle) like  '%DOCENCIA%') as docencia, "
						+ "(SELECT to_char((((pre.valor * 16) + (pre.valor_2 * 8)) * 100)/960, '990.09') "
						+ "FROM \"Catalogos\".preguntas_evaluacion pe, \"GestionDocente\".preg_resultado_eval pre, \"GestionDocente\".resultado_eval re "
						+ "WHERE pe.id_preguntas_eval= pre.id_preguntas_eval "
						+ "AND pre.id_resultado_eval= re.id_resultado_eval " + "AND pe.tipo= 'COEV' "
						+ "AND pe.asignacion ='HORAS' AND re.nced LIKE  e.nced "
						+ "AND re.id_pensum = ce.id_pensum AND upper(pe.detalle) like  'INVEST%') AS investigacion, "
						+ "(SELECT to_char((((pre.valor * 16) + (pre.valor_2 * 8)) * 100)/960, '990.09') "
						+ "FROM \"Catalogos\".preguntas_evaluacion pe, \"GestionDocente\".preg_resultado_eval pre, \"GestionDocente\".resultado_eval re "
						+ "WHERE pe.id_preguntas_eval= pre.id_preguntas_eval "
						+ "AND pre.id_resultado_eval= re.id_resultado_eval " + "AND pe.tipo= 'COEV' "
						+ "AND pe.asignacion ='HORAS' AND re.nced LIKE  e.nced "
						+ "AND re.id_pensum = ce.id_pensum AND upper(pe.detalle) like  'GEST%') as gestion, "
						+ "CONCAT(\"a�o_pensum\", '-',  numero_pensum), '' "
						+ "FROM \"GestionDocente\".calculo_eval ce, \"Rrhh\".emp e, \"Rrhh\".dep d, \"Contratos\".pensum p "
						+ "WHERE ce.nced= e.nced " + "AND e.cod_dep= d.cod_dep " + "AND ce.id_pensum= p.id_pensum "
						+ "AND e.nced LIKE ? " + "AND e.nom LIKE ? " + "AND e.apel LIKE ? " + "AND d.COD_DEP LIKE ? "
						+ "AND p.id_pensum= ? " + "ORDER BY e.apel;";

				ps = con.prepareStatement(qry);
				ps.setString(1, auxCIDoc);
				ps.setString(2, auxNomDoc + "%");
				ps.setString(3, auxApelDoc + "%");
				ps.setString(4, auxDep);
				ps.setInt(5, idPensum);

				ResultSet rs = ps.executeQuery();

				ArrayList<DocenteDTO> listaDocentes = new ArrayList<DocenteDTO>();

				while (rs.next()) {

					DocenteDTO dto = new DocenteDTO();
					dto.setnCed(rs.getString(1));
					dto.setNombre(rs.getString(2));
					dto.setApel(rs.getString(3));
					dto.setNomDepartamento(rs.getString(4));
					dto.setCargo(rs.getString(5));
					dto.setRelacionLab(rs.getString(6));
					dto.setNotaFinal(rs.getString(7));
					dto.setDocencia(rs.getString(8));
					dto.setInvestigacion(rs.getString(9));
					dto.setGestion(rs.getString(10));
					dto.setPeriodo(rs.getString(11));
					dto.setAprobEstudiantes(rs.getString(12));

					listaDocentes.add(dto);
				}

				ps.close();
				con.close();

				return listaDocentes;
			}

			else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			ps.close();
			con.close();
		}
	}

	// variables
	public Query query = null;
	public String q = "";
	public StringBuilder queryString = null;

	@Override
	public List<Emp> obtenerListaEmpleados(String criterio) {
		// Busca todos los empleados
		if (criterio.isEmpty() || criterio.equals("") || criterio.equals(" ") || criterio.equals("0")) {
			q = "SELECT e FROM Emp e " + " order by e.apel, e.nom ";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());

		} else {
			try {
				try {
					// Busca empleado por c�dula
					if (Integer.parseInt(criterio) > 0 || Integer.parseInt(criterio) == 0) {
						q = "SELECT e FROM Emp e WHERE e.nced LIKE ?0 " + " order by e.apel, e.nom ";
						queryString = new StringBuilder(q);
						query = getEntityManager().createQuery(queryString.toString());
						query.setParameter(0, "%" + criterio + "%");
					}
				} catch (Exception e) {
					// Busca empleado por nombre
					q = "SELECT e FROM Emp e WHERE " + " OR e.nom LIKE ?1 " + " order by e.apel, e.nom ";
					queryString = new StringBuilder(q);
					query = getEntityManager().createQuery(queryString.toString());
					query.setParameter(1, "%" + criterio + "%");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return query.getResultList();
	}

	/*
	 * Busca empleado por c�dula
	 * 
	 * @see ec.edu.epn.rrhh.beans.EmpleadoDAO#obtenerEmpleado(java.lang.String)
	 */
	@Override
	public Emp obtenerEmpleado(String criterio) {
		query = getEntityManager().createQuery("SELECT e FROM Emp e WHERE e.nced LIKE ?0");

		query.setParameter(0, "%" + Integer.parseInt(criterio.trim()) + "%");

		Emp aux = new Emp();
		Emp obj = new Emp();

		try {
			aux = (Emp) query.getSingleResult();
			obj = aux;

		} catch (NoResultException e) {
			obj = null;
		} catch (NonUniqueResultException e) {
			obj = aux;
		} catch (Exception e) {
			obj = null;
		}
		return obj;
	}

	/**
	 * Lista los empleados por una lista de c�dulas
	 * 
	 * @param docentes- lista de string con las c�dulas de los docentes a buscar
	 * @param nombre    - String con el nombre que se desa buscar.
	 * @return lista de empleados con los parameotrs buscados
	 * @throws NoResultException - Excepcion lanzada cuando no se encuentra la
	 *                           entidad
	 * @throws Exception         - Excepcion general
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> listarEmpXlistCedulas(List<String> docentes, String nombre) throws NoResultException, Exception {
		List<Emp> retorno = null;
		try {
			StringBuilder stQuery = new StringBuilder();
			stQuery.append(" SELECT emp from Emp emp ");
			stQuery.append(" where emp.nced in :docentes and emp.clasemp.codClase=1 ");
			if (nombre.isEmpty()) {
				stQuery.append(
						" and (upper(emp.nom || ' '|| emp.apel) like :nombre OR upper(emp.apel || ' '|| emp.nom) like :nombre)");
			}
			stQuery.append(" ORDER BY emp.apel, emp.nom");
			Query q = getEntityManager().createQuery(stQuery.toString());
			q.setParameter("docentes", docentes);
			if (nombre.isEmpty()) {
				q.setParameter("nombre", "%" + nombre.replaceAll(" +", " ").trim().toUpperCase() + "%");
			}
			retorno = q.getResultList();
		} catch (NoResultException e) {
			throw new NoResultException("No se encontr� Empleados por las c�dulas enviadas");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al buscar los empleados");
		}
		return retorno;
	}

	/**
	 * Lista los empleados por el id de : departamento
	 * 
	 * @param idDepartamento - string con el id del departamentos a listar
	 * @param nombre         - string con el nombre del docente a buscar
	 * @return lista de empleados con los parameotrs buscados
	 * @throws NoResultException - Excepcion lanzada cuando no se encuentra la
	 *                           entidad
	 * @throws Exception         - Excepcion general
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> listarEmpXidDep(String idDepartamento, String nombre, String codClase, String tipoRelLaboral,
			String estadoDocente) throws NoResultException, Exception {
		List<Emp> retorno = null;
		try {
			StringBuilder stQuery = new StringBuilder();
			stQuery.append(" SELECT emp from Emp emp ");
			if (!idDepartamento.equals("-99")) {
				stQuery.append(" where emp.dep.codDep = :idDepartamento and emp.clasemp.codClase=:codClase ");
			} else {
				stQuery.append(" where emp.clasemp.codClase=:codClase ");
			}

			if (!tipoRelLaboral.isEmpty()) {
				if (tipoRelLaboral.equals("0")) {
					stQuery.append(" and emp.codTiporelacionlab IN ('1','2') ");
				} else {
					stQuery.append(" and emp.codTiporelacionlab = :tipoRelLaboral ");
				}

			}
			if (!estadoDocente.isEmpty()) {
				stQuery.append(" and emp.estemp.codEst=:estadoDocente ");
			}

			if (!nombre.isEmpty()) {
				stQuery.append(
						" and (upper(emp.nom || ' '|| emp.apel) like :nombre OR upper(emp.apel || ' '|| emp.nom) like :nombre)");
			}
			stQuery.append(" ORDER BY emp.apel, emp.nom");
			Query q = getEntityManager().createQuery(stQuery.toString());
			if (!idDepartamento.equals("-99")) {
				q.setParameter("idDepartamento", idDepartamento);
			}

			if (codClase != null) {
				q.setParameter("codClase", codClase);
			}

			if (!tipoRelLaboral.isEmpty()) {
				if (!tipoRelLaboral.equals("0")) {
					q.setParameter("tipoRelLaboral", tipoRelLaboral);
				}
			}

			if (!estadoDocente.isEmpty()) {
				q.setParameter("estadoDocente", estadoDocente);
			}

			if (!nombre.isEmpty()) {
				q.setParameter("nombre", "%" + nombre.replaceAll(" +", " ").trim().toUpperCase() + "%");
			}
			retorno = q.getResultList();
		} catch (NoResultException e) {
			throw new NoResultException("No se encontr� Empleados por el departamento seleccionado");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al buscar los empleados");
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> findempByParamsDep(String cedula, String apellidos, String nombre, String coddep) {

		List<String> clases = new ArrayList<String>();
		String v1 = "1";
		String v4 = "4";
		String v3 = "3";
		clases.add(v1);
		clases.add(v4);
		clases.add(v3);

		List<String> estados = new ArrayList<String>();
		String e1 = "1";
		String e4 = "11";

		estados.add(e1);
		estados.add(e4);

		StringBuilder queryString = new StringBuilder(
				"SELECT emp FROM Emp emp where emp.nced like ?0  and emp.clasemp.codClase IN :clases and emp.estemp.codEst IN :estados ");

		if (apellidos != null) {
			queryString.append(" AND emp.apel like ?3 ");
		}

		if (nombre != null) {
			queryString.append(" AND emp.nom like ?4 ");
		}

		if (coddep != null) {
			queryString.append(" and emp.dep.codDep like ?5 ");

		}

		queryString.append("  ORDER BY emp.apel ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + cedula + "%");
		query.setParameter("clases", clases);
		query.setParameter("estados", estados);

		if (apellidos != null) {
			query.setParameter(3, "%" + apellidos + "%");
		}
		if (nombre != null) {
			query.setParameter(4, "%" + nombre + "%");
		}

		if (coddep != null) {
			query.setParameter(5, "%" + coddep + "%");
		}

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> findempByParamsReporteGI(String cedula, String apellidos, String nombre, String codRelacionLab,
			String coddep, String tipo) {

		StringBuilder queryString = new StringBuilder("SELECT emp FROM Emp emp where emp.estemp.codEst = ?0   ");

		if (cedula != null) {
			queryString.append(" AND emp.nced like ?1 ");
		}

		if (apellidos != null) {
			queryString.append(" AND emp.apel like ?2 ");
		}

		if (nombre != null) {
			queryString.append(" AND emp.nom like ?3 ");
		}
		if (coddep != null) {
			queryString.append(" AND emp.dep.codDep = ?4 ");
		}

		if (tipo != null) {
			queryString.append(" and emp.clasemp.codClase = ?5 ");
		}

		queryString.append("ORDER BY emp.apel ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "1");

		if (cedula != null) {
			query.setParameter(1, "%" + cedula + "%");
		}

		if (apellidos != null) {
			query.setParameter(2, "%" + apellidos + "%");
		}
		if (nombre != null) {
			query.setParameter(3, "%" + nombre + "%");
		}

		if (coddep != null) {
			query.setParameter(4, coddep);
		}

		if (tipo != null) {
			query.setParameter(5, tipo);
		}

		return query.getResultList();
	}

	@Override
	public Emp obtenerEmpleadoAcreditacion(String criterio) {
		query = getEntityManager().createQuery("SELECT e FROM Emp e WHERE e.nced = ?0");

		query.setParameter(0, criterio.trim());

		Emp aux = new Emp();
		Emp obj = new Emp();

		try {
			aux = (Emp) query.getSingleResult();
			obj = aux;

		} catch (NoResultException e) {
			obj = null;
		} catch (NonUniqueResultException e) {
			obj = aux;
		} catch (Exception e) {
			obj = null;
		}
		return obj;
	}

	@Override
	public ArrayList<ReporteChartDTO> totalProyectos(String cedula) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = super.getDataSource().getConnection();
			if (con != null) {
				String qry = "select count(id_activid_proy), "
						+ "CASE a.id_periodo WHEN '2016-1' THEN '2016A' WHEN '2016-2' THEN '2016B' WHEN '2017-1' THEN '2017A' WHEN '2017-2' THEN '2017B' WHEN '2018-1' THEN '2018A' END "
						+ " from \"GestionDocente\".actividad_proyecto a, \"GestionDocente\".periodo p "
						+ " where  a.id_periodo = p.id_periodo "
						+ " and a.id_periodo in ('2016-1','2016-2','2017-1','2017-2','2018-1') and a.nced = ?"
						+ " group by a.id_periodo order by a.id_periodo ";

				ps = con.prepareStatement(qry);

				ps.setString(1, cedula);

				ResultSet rs = ps.executeQuery();

				ArrayList<ReporteChartDTO> listaDocenteCI = new ArrayList<ReporteChartDTO>();

				while (rs.next()) {

					ReporteChartDTO docen = new ReporteChartDTO();
					docen.setTotal(rs.getDouble(1));
					docen.setPeriodo(rs.getString(2));
					listaDocenteCI.add(docen);
				}
				ps.close();
				con.close();
				return listaDocenteCI;
			}

			else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			super.cerrarConexion(con, ps);
		}
	}

	@Override
	public ArrayList<ReporteChartDTO> totalPublicaciones(String cedula) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = super.getDataSource().getConnection();
			if (con != null) {
				String qry = "select count(id_public), CASE id_periodo WHEN '2016-1' THEN '2016A' WHEN '2016-2' THEN '2016B' WHEN '2017-1' THEN '2017A' WHEN '2017-2' THEN '2017B' WHEN '2018-1' THEN '2018A' END"
						+ " from \"GestionDocente\".publicaciones "
						+ " where id_periodo in ('2016-1','2016-2','2017-1','2017-2','2018-1')  and nced = ? "
						+ " group by id_periodo order by id_periodo ";

				ps = con.prepareStatement(qry);

				ps.setString(1, cedula);

				ResultSet rs = ps.executeQuery();

				ArrayList<ReporteChartDTO> listaDocenteCI = new ArrayList<ReporteChartDTO>();

				while (rs.next()) {

					ReporteChartDTO docen = new ReporteChartDTO();
					docen.setTotal(rs.getDouble(1));
					docen.setPeriodo(rs.getString(2));
					listaDocenteCI.add(docen);
				}
				ps.close();
				con.close();
				return listaDocenteCI;
			}

			else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			super.cerrarConexion(con, ps);
		}
	}

	@Override
	public ArrayList<ReporteChartDTO> totalHorasDoc(String cedula) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = super.getDataSource().getConnection();
			if (con != null) {
				String qry = " SELECT ROUND(AVG((select COALESCE(sum(COALESCE(valor_16_planif, 0) * semanas_doc_dentro),0) from \"GestionDocente\".actividad_evaluacion  where id_eval_acad= ea.id_eval_acad AND id_tipo_actv_eval=1) + (select COALESCE(sum(COALESCE(valor_16_planif, 0)), 0) from \"GestionDocente\".actividad_evaluacion  where id_eval_acad= ea.id_eval_acad AND id_tipo_actv_eval=2))::numeric,2) AS DOCENCIA_PLANIF , "
						+ " CASE p.id_pensum WHEN 9 THEN '2017A' WHEN 17 THEN '2017B' WHEN 18 THEN '2018A'  END "
						+ " FROM  \"GestionDocente\".evaluacion_academica ea, \"Contratos\".pensum p "
						+ " WHERE ea.id_pensum= p.id_pensum	 " + " and ea.nced = ?" + " and p.id_pensum in (17,9,18) "
						+ " GROUP BY p.id_pensum ";

				ps = con.prepareStatement(qry);

				ps.setString(1, cedula);

				ResultSet rs = ps.executeQuery();

				ArrayList<ReporteChartDTO> listaDocenteCI = new ArrayList<ReporteChartDTO>();

				while (rs.next()) {

					ReporteChartDTO docen = new ReporteChartDTO();
					docen.setTotal(rs.getDouble(1));
					docen.setPeriodo(rs.getString(2));
					listaDocenteCI.add(docen);
				}
				ps.close();
				con.close();
				return listaDocenteCI;
			}

			else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			super.cerrarConexion(con, ps);
		}
	}

	@Override
	public ArrayList<ReporteChartDTO> totalHorasInv(String cedula) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = super.getDataSource().getConnection();
			if (con != null) {
				String qry = " SELECT ROUND(AVG((select COALESCE(sum(COALESCE(valor_16_planif, 0)), 0) from \"GestionDocente\".actividad_evaluacion  where id_eval_acad= ea.id_eval_acad AND id_tipo_actv_eval=3))::numeric, 2) AS INVESTIGACION_PLANIF, "
						+ " CASE p.id_pensum WHEN 9 THEN '2017A' WHEN 17 THEN '2017B' WHEN 18 THEN '2018A' END "
						+ " FROM  \"GestionDocente\".evaluacion_academica ea, \"Contratos\".pensum p "
						+ " WHERE ea.id_pensum= p.id_pensum	 " + " and ea.nced = ?" + " and p.id_pensum in (17,9,18)"
						+ " GROUP BY p.id_pensum ";

				ps = con.prepareStatement(qry);

				ps.setString(1, cedula);

				ResultSet rs = ps.executeQuery();

				ArrayList<ReporteChartDTO> listaDocenteCI = new ArrayList<ReporteChartDTO>();

				while (rs.next()) {

					ReporteChartDTO docen = new ReporteChartDTO();
					docen.setTotal(rs.getDouble(1));
					docen.setPeriodo(rs.getString(2));
					listaDocenteCI.add(docen);
				}
				ps.close();
				con.close();
				return listaDocenteCI;
			}

			else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			super.cerrarConexion(con, ps);
		}
	}

	@Override
	public ArrayList<ReporteChartDTO> totalHorasGes(String cedula) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = super.getDataSource().getConnection();
			if (con != null) {
				String qry = " SELECT ROUND(AVG((select COALESCE(sum(COALESCE(valor_16_planif, 0)), 0) from \"GestionDocente\".actividad_evaluacion  where id_eval_acad= ea.id_eval_acad AND id_tipo_actv_eval=4))::numeric,2) AS GESTION_PLANIF,"
						+ " CASE p.id_pensum WHEN 9 THEN '2017A' WHEN 17 THEN '2017B' WHEN 18 THEN '2018A' END "
						+ " FROM  \"GestionDocente\".evaluacion_academica ea, \"Contratos\".pensum p "
						+ " WHERE ea.id_pensum= p.id_pensum	 " + " and ea.nced = ?" + " and p.id_pensum in (17,9,18)"
						+ " GROUP BY p.id_pensum ";

				ps = con.prepareStatement(qry);

				ps.setString(1, cedula);

				ResultSet rs = ps.executeQuery();

				ArrayList<ReporteChartDTO> listaDocenteCI = new ArrayList<ReporteChartDTO>();

				while (rs.next()) {

					ReporteChartDTO docen = new ReporteChartDTO();
					docen.setTotal(rs.getDouble(1));
					docen.setPeriodo(rs.getString(2));
					listaDocenteCI.add(docen);
				}
				ps.close();
				con.close();
				return listaDocenteCI;
			}

			else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			super.cerrarConexion(con, ps);
		}
	}

	@Override
	public Emp buscarempJefeDepartamento(String coddep) throws Exception {

		try {
			Emp empleado = new Emp();
			StringBuilder queryString = new StringBuilder("SELECT e from Emp e where e.codDepJefe = ?1 ");
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, coddep.trim());

			empleado = (Emp) query.getSingleResult();

			return empleado;

		} catch (NoResultException n) {
			return null;
		}

		catch (NonUniqueResultException n) {
			return null;
		}

	}

	@Override
	public List<Emp> findinvAcreditadosSenescyt() {
		StringBuilder queryString = new StringBuilder("SELECT emp FROM Emp emp where emp.acreditasenescyt like ?0 ");
		queryString.append("ORDER BY emp.apel ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%REG-INV%");

		return query.getResultList();
	}

	@Override
	public Emp buscarempLivianoRG(String nced) throws Exception {
		try {
			Emp empleado = new Emp();
			StringBuilder queryString = new StringBuilder("SELECT e from Emp e where e.nced = ?1 ");
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, nced.trim());
			return (Emp) query.getSingleResult();
		} catch (NoResultException n) {
			return null;
		} catch (NonUniqueResultException n) {
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> findEmpXCeduNombre(String cedula, String apellidos, String nombre) {

		StringBuilder queryString = new StringBuilder("SELECT emp FROM Emp emp where emp.nced like ?0 ");

		if (apellidos != null && nombre != null) {
			queryString.append(" AND (emp.apel like ?1 OR emp.nom like ?2) ");
		}

		/*
		 * if (nombre != null) { queryString.append(" AND emp.nom like ?2 "); }
		 */

		queryString.append("ORDER BY emp.apel ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + cedula + "%");

		if (apellidos != null) {
			query.setParameter(1, "%" + apellidos + "%");
		}
		if (nombre != null) {
			query.setParameter(2, "%" + nombre + "%");
		}

		return query.getResultList();
	}

	@Override
	public DocenteDTO cargoDedicacionRelLab(Integer idPensum, Integer idOpcion, String nced) throws Exception {

		DocenteDTO val = new DocenteDTO();
		Query query = null;
		query = getEntityManager().createNativeQuery("SELECT  * FROM \"Rrhh\".bi_reportetipodedicacion(?,?,?);");

		query.setParameter(1, idPensum);
		query.setParameter(2, idOpcion);
		query.setParameter(3, nced);

		List<?> lists = query.getResultList();

		if (!lists.isEmpty()) {
			for (Object list : lists) {
				val = new DocenteDTO();
				Object[] fila = (Object[]) list;
				if (fila[0] != null && fila[0].toString().length() != 0)
					val.setnCed(fila[0] == null ? "" : fila[0].toString());

				if (fila[1] != null && fila[1].toString().length() != 0) {
					String dato = null;
					dato = (fila[1] == null ? "" : fila[1].toString());
					if (idOpcion == 1) {
						val.setCargo(dato);
					} else if (idOpcion == 2) {
						val.setDedicacion(dato);
					} else if (idOpcion == 3) {
						val.setRelacionLab(dato);
					} else if (idOpcion == 4) {
						val.setNomDepartamento(dato);
					} else if (idOpcion == 6) {
						val.setFechaContrat(dato);
					}
				}

			}
		} else {
			val = null;
		}

		return val;

	}

	@Override
	public List<DocenteDTO> buscarEmpHistoriaLab(String nced, Integer idPensum, String apel, String nom, String dep)
			throws Exception {

		try {

			List<DocenteDTO> listDoc = new ArrayList<DocenteDTO>();
			List<DocenteDTO> listDocPen = new ArrayList<DocenteDTO>();
			try {
				listDoc = this.presentarCargoDedicacionRelLab(idPensum, nced, apel, nom, dep);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

			if (!listDoc.isEmpty()) {
				for (DocenteDTO dto : listDoc) {
					if (dto == null) {
						dto = new DocenteDTO();
						dto.setExistePeriodo(false);
					} else {
						dto.setExistePeriodo(true);
					}

					Pensum pensum = new Pensum();
					pensum = pensumDAO.obtenerPensumById(idPensum);
					dto.setPeriodo(pensum == null ? "" : pensum.getMeses());
					dto.setIdPeriodo(pensum.getIdPensum().toString());

					listDocPen.add(dto);
				}
			} else {
				DocenteDTO dto = new DocenteDTO();
				dto.setExistePeriodo(false);
				listDocPen.add(dto);
			}

			return listDocPen;

		} catch (NoResultException n) {
			return null;
		}

		catch (NonUniqueResultException n) {
			return null;
		}

	}



	@Override
	public List<DocenteDTO> presentarCargoDedicacionRelLab(Integer idPensum, String nced, String apel, String nom,
			String dep) throws Exception {

		List<DocenteDTO> listDoc = new ArrayList<DocenteDTO>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Query query = null;
		query = getEntityManager().createNativeQuery("SELECT * FROM (SELECT  * ,row_number() over (partition by nced order by fecha_ini_licen desc) as rn FROM \"Rrhh\".bi_reportecargodeprrhh(?,?,?,?,?) "
														+ "sp LEFT JOIN \"Rrhh\".bi_reportelicenperiodonomb(?) licen on sp.nced = licen.ncedlic "
														+ "LEFT JOIN \"Rrhh\".bi_reporteperiodocontratonomb(?) cont on sp.nced = cont.ncedcont "
														+ "LEFT JOIN \"Rrhh\".bi_reportejubilados(?) jub on jub.ncedjub = sp.nced) t WHERE  rn= 1;");

		query.setParameter(1, idPensum);
		query.setParameter(2, nced);
		query.setParameter(3, apel);
		query.setParameter(4, nom);
		query.setParameter(5, dep);
		query.setParameter(6, idPensum);
		query.setParameter(7, idPensum);
		query.setParameter(8, idPensum);

		List<?> lists = query.getResultList();

		if (!lists.isEmpty()) {
			for (Object list : lists) {
				DocenteDTO val = new DocenteDTO();
				Object[] col = (Object[]) list;

				if (col[0] != null && col[0].toString().length() != 0)
					val.setnCed(col[0] == null ? "" : col[0].toString());

				if (col[1] != null && col[1].toString().length() != 0)
					val.setApel(col[1] == null ? "" : col[1].toString());

				if (col[2] != null && col[2].toString().length() != 0)
					val.setNombre(col[2] == null ? "" : col[2].toString());

				if (col[3] != null && col[3].toString().length() != 0)
					val.setAuxFechaIngresoEPN(col[3] == null ? null : col[3].toString());

				if (col[4] != null && col[4].toString().length() != 0) {
					String dato = null;
					dato = (col[4] == null ? "" : col[4].toString());
					val.setCargo(dato);

				}

				if (col[5] != null && col[5].toString().length() != 0) {
					String dato = null;
					dato = (col[5] == null ? "" : col[5].toString());
					val.setDedicacion(dato);

				}

				if (col[6] != null && col[6].toString().length() != 0) {
					String dato = null;
					dato = (col[6] == null ? "" : col[6].toString());
					val.setRelacionLab(dato);

				}

				if (col[7] != null && col[7].toString().length() != 0) {
					String dato = null;
					dato = (col[7] == null ? "" : col[7].toString());
					val.setNomDepartamento(dato);

				}

				if (col[8] != null) {
					String dato = null;
					dato = (col[8] == null ? "" : col[8].toString());
					val.setPathContrato(dato);
					val.setPresentacion(true);

				} else {
					val.setPathContrato(null);
					val.setPresentacion(false);
				}
				
				
				if (col[13] != null && col[13].toString().length() != 0) {
					String dato = null;
					dato = (col[13] == null ? "" : col[13].toString());
					val.setLicencia(dato);

				}
				
				if (col[14] != null && col[14].toString().length() != 0) {
					String dato = null;
					dato = (col[14] == null ? "" : col[14].toString());
					val.setFechaIniLic(dato);;

				}
				
				if (col[15] != null && col[15].toString().length() != 0) {
					String dato = null;
					dato = (col[15] == null ? "" : col[15].toString());
					val.setFechaReintegro(dato);

				}
				
				if (col[17] != null && col[17].toString().length() != 0) {
					String dato = null;
					dato = (col[17] == null ? "" : col[17].toString());
					val.setFechaIniContrato(dato);

				}
				
				if (col[18] != null && col[18].toString().length() != 0) {
					String dato = null;
					dato = (col[18] == null ? "" : col[18].toString());
					val.setFechaFinContrato(dato);

				}
				
				
				if (col[22] != null && col[22].toString().length() != 0) {
					String dato = null;
					dato = (col[22] == null ? "" : col[22].toString());
					val.setFechaJubilicacion(dato);

				}

				listDoc.add(val);
			}

		} else {
			listDoc = new ArrayList<DocenteDTO>();
		}

		Map<String, DocenteDTO> mapPersonas = new HashMap<String, DocenteDTO>(listDoc.size());

		for (DocenteDTO p : listDoc) {
			mapPersonas.put(p.getnCed(), p);
		}

		listDoc = new ArrayList<DocenteDTO>();

		for (Entry<String, DocenteDTO> p : mapPersonas.entrySet()) {
			listDoc.add(p.getValue());
		}

		return this.ordenar(listDoc);
		
		

	}

	public List<DocenteDTO> ordenar(List<DocenteDTO> listDoc) {
		Collections.sort(listDoc, new Comparator<DocenteDTO>() {
			@Override
			public int compare(DocenteDTO o1, DocenteDTO o2) {
				return o1.getApel().compareToIgnoreCase(o2.getApel());
			}
		});
		return listDoc;

	}

	

	@Override
	public List<Emp> listaEmpleadonoContrato() {
		StringBuilder queryString = new StringBuilder("SELECT e FROM Emp e where e.estemp = '1' "
				+ "and e.nced in (SELECT h.emp.nced FROM HistoriaLaboral h where h.accionP is null and h.fechaFin<now() and "
				+ "h.fechaRige = (Select max(hl.fechaRige) from HistoriaLaboral hl where h.emp.nced = hl.emp.nced )"
				+ "and h.id.fechaI = (Select max(t.id.fechaI) "
				+ "from HistoriaLaboral t where t.id.idHist=h.id.idHist) "
				+ "and h.id.idHist not in (Select g.id.idHist FROM HistoriaLaboral g where "
				+ " (trim(g.id.estado) = 'Duplicado' or trim(g.id.estado) = 'Anulado' or "
				+ " trim(g.id.estado) = 'Insubsistente' ))) ");
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

}

