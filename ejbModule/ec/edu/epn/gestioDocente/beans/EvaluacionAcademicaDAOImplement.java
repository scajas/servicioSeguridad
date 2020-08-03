package ec.edu.epn.gestioDocente.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.sql.DataSource;

import ec.edu.epn.contratos.beans.PedidoDAO;
import ec.edu.epn.contratos.beans.PensumDAO;
import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.DTO.HorasPeriodoAcademicoDTO;
import ec.edu.epn.gestionDocente.entities.ActAcademica;
import ec.edu.epn.gestionDocente.entities.ActividadEvaluacion;
import ec.edu.epn.gestionDocente.entities.ActividadPreplanificacion;
import ec.edu.epn.gestionDocente.entities.EstadoEvaluacion;
import ec.edu.epn.gestionDocente.entities.EvaluacionAcademica;
import ec.edu.epn.gestionDocente.entities.PlanfActAcademica;
import ec.edu.epn.gestionDocente.entities.PreplanificacionDocencia;
import ec.edu.epn.gestionDocente.entities.SubactividadEvaluacion;
import ec.edu.epn.gestionDocente.entities.SubactividadPreplanificacion;
import ec.edu.epn.rrhh.DTO.DocenteDTO;
import ec.edu.epn.rrhh.DTO.DocentesEvaluacionDTO;

/**
 * Session Bean implementation class ActividadDocenciaDAOImplement
 */
@Stateless
@LocalBean
public class EvaluacionAcademicaDAOImplement extends DaoGenericoImplement<EvaluacionAcademica>
		implements EvaluacionAcademicaDAO {

	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/PlanfActAcademicaDAOImplement!ec.edu.epn.gestioDocente.beans.PlanfActAcademicaDAO")
	private PlanfActAcademicaDAO planfActAcademicaDAO;

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/ActAcademicaDAOImplement!ec.edu.epn.gestioDocente.beans.ActAcademicaDAO")
	private ActAcademicaDAO actAcademicaDAO;
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/ActividadEvaluacionDAOImplement!ec.edu.epn.gestioDocente.beans.ActividadEvaluacionDAO")
	private ActividadEvaluacionDAO actividadEvaluacionDAO;
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/SubactividadEvaluacionDAOImplement!ec.edu.epn.gestioDocente.beans.SubactividadEvaluacionDAO")
	private SubactividadEvaluacionDAO subactividadEvaluacionDAO;
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/EstadoEvaluacionDAOImplement!ec.edu.epn.gestioDocente.beans.EstadoEvaluacionDAO")
	private EstadoEvaluacionDAO estadoEvaluacionDAO;
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/PreplanificacionDocenciaDAOImplement!ec.edu.epn.gestioDocente.beans.PreplanificacionDocenciaDAO")
	private PreplanificacionDocenciaDAO preplanificacionDocenciaDAO;	
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/PedidoDAOImplement!ec.edu.epn.contratos.beans.PedidoDAO")
	private PedidoDAO pedidoDAO;
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/ActividadPreplanificacionDAOImplement!ec.edu.epn.gestioDocente.beans.ActividadPreplanificacionDAO")
	private ActividadPreplanificacionDAO actividadPreplanificacionDAO;
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/SubactividadPreplanificacionDAOImplement!ec.edu.epn.gestioDocente.beans.SubactividadPreplanificacionDAO")
	private SubactividadPreplanificacionDAO subactividadPreplanificacionDAO;
	
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/PensumDAOImplement!ec.edu.epn.contratos.beans.PensumDAO")
	private PensumDAO pensumDAO;
	
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/DescansoObligatorioDAOImplement!ec.edu.epn.gestioDocente.beans.DescansoObligatorioDAO")
	private DescansoObligatorioDAO descansoObligatorioDAO;
	
	@Resource(mappedName = "java:jboss/datasources/SeguridadEPNDS")
	private DataSource dataSource;
	
	
	
	
	@Override
	public void llenarRegistrosAutoEvalaucion()  throws Exception {
		
		List<PlanfActAcademica> listPlanificacion= new ArrayList<PlanfActAcademica>();
		listPlanificacion= planfActAcademicaDAO.listPlanifXPeriodo(8);
		
		if(!listPlanificacion.isEmpty()){
			for(PlanfActAcademica planfActAcademica: listPlanificacion){
				
				EvaluacionAcademica evaluacionAcademica= new EvaluacionAcademica();
				
				evaluacionAcademica.setEstado("PLANIF");
				evaluacionAcademica.setNced(planfActAcademica.getNced());
				evaluacionAcademica.setNcedDir(planfActAcademica.getNcedDir());
				evaluacionAcademica.setIdPensum(planfActAcademica.getIdPensum());				
				evaluacionAcademica.setFechaIngreso(planfActAcademica.getFechaIngreso());				
				this.save(evaluacionAcademica);
				
				List<ActAcademica> listActAcademicas= new ArrayList<ActAcademica>();				
				listActAcademicas= actAcademicaDAO.listActAcademXPlanificacion(planfActAcademica.getIdPlanfActAcad());
				
				for(ActAcademica academica: listActAcademicas){
					
					ActividadEvaluacion actividadEvaluacion= new ActividadEvaluacion();
					
					actividadEvaluacion.setNombreActividad(academica.getNombreActividad());					
					actividadEvaluacion.setIdTipoActvEval(academica.getIdTipoPlanifActAcad()==1?academica.getIdTipoPlanifActAcad():(academica.getIdTipoPlanifActAcad()+1));
					actividadEvaluacion.setValor16Planif(academica.getValor16());
					actividadEvaluacion.setValor8Planif(academica.getValor8());
					actividadEvaluacion.setValor16Auto(academica.getValor16());
					actividadEvaluacion.setCumplimientoAuto(0.0);
					actividadEvaluacion.setCalificacionPonderadaAuto(0.0);
					actividadEvaluacion.setValor16Coe(academica.getValor16());
					actividadEvaluacion.setCumplimientoCoe(0.0);
					actividadEvaluacion.setCalificacionPonderadaCoe(0.0);
					actividadEvaluacion.setEvaluacionAcademica(evaluacionAcademica);
					
					actividadEvaluacionDAO.save(actividadEvaluacion);
				}
			}
		}
	}
	
	
	@Override
	public EvaluacionAcademica evaluacionXCedulaPeriodo(String nced, Integer idPensum, String estado) throws Exception {
		
		try {
		Query q = getEntityManager()
				.createQuery(
						"SELECT e FROM EvaluacionAcademica e WHERE e.nced like ? AND e.idPensum= ? AND e.estado  like ? ");

		
		q.setParameter(1, "%"+ nced + "%");
		q.setParameter(2, idPensum);
		q.setParameter(3, estado);
		
		
		
		return (EvaluacionAcademica) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	@Override
	public Long countEvalXDocPeriodo(String nced, Integer idPensum, String estado)
			throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(e) FROM EvaluacionAcademica e WHERE e.nced like ? AND e.idPensum= ? AND e.estado like ? ");

		
		q.setParameter(1, "%" + nced + "%");
		q.setParameter(2, idPensum);
		q.setParameter(3, estado);
		
		
		return (Long) q.getSingleResult();
	}
	
	
	@Override
	public EvaluacionAcademica evaluacionXCedulaPeriodoEstado(String nced, Integer idPensum, String estado, String estado2) throws Exception {
		
		try {
			
		
		
			Query q = getEntityManager()
					.createQuery(
							"SELECT e FROM EvaluacionAcademica e WHERE e.nced like ? AND e.idPensum= ? AND (e.estado  like ? OR e.estado  like ?) ");
	
			
			q.setParameter(1, "%" + nced + "%");
			q.setParameter(2, idPensum);
			q.setParameter(3, estado);
			q.setParameter(4, estado2);
			
			
			
			return (EvaluacionAcademica) q.getSingleResult();
		
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	@Override
	public Long countEvalXDocPeriodoEstado(String nced, Integer idPensum, String estado,String estado2)throws Exception {
			
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(e) FROM EvaluacionAcademica e WHERE e.nced like ? AND e.idPensum= ? AND (e.estado  like ? OR e.estado  like ?) ");

		
		q.setParameter(1, "%" + nced + "%");
		q.setParameter(2, idPensum);
		q.setParameter(3, estado);
		q.setParameter(4, estado2);
		
		
		return (Long) q.getSingleResult();
	}
	
	
	
	
	
	
	@Override
	public ArrayList<DocenteDTO> docenteConsultaPlanif(Long idUser, String auxCIDoc, String auxNomDoc, String auxApelDoc, String auxDep, String perfilUsuario, Integer idPensum) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();			

			if (con != null) {
				
				
				String qry = "SELECT  e.NCED, e.nom, e.apel, ''," +						
						"d.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), " +
						"CASE cod_tiporelacionlab WHEN 1 THEN 'NOMBRAMIENTO' WHEN 2 THEN 'CONTRATO' END, "+
						"ea.id_eval_acad, "+
						"est.descripcion "+						
						"FROM \"Rrhh\".EMP E, \"Rrhh\".DEP D,  \"Contratos\".pensum P, \"GestionDocente\".evaluacion_academica EA, \"GestionDocente\".estado_evaluacion EST " +  
						"WHERE E.COD_DEP = D.COD_DEP " +												
						"AND e.cod_clase = '1' "+
						"AND e.nced= ea.nced "+
						"AND ea.id_pensum= p.id_pensum "+
						"AND e.nced like ? "+
						"AND e.nom like ? "+
						"AND e.cod_est=1 "+
						"AND e.apel like ? "+						
						"AND (D.COD_DEP like ? OR 0= ?)"+
						"AND p.id_pensum= ? "+
						"AND ea.estado= est.nombre "+						
						"ORDER BY apel ";

				ps = con.prepareStatement(qry);

				ps.setString(1, auxCIDoc);
				ps.setString(2, auxNomDoc + "%");
				ps.setString(3, auxApelDoc + "%");
				ps.setString(4, auxDep);
				ps.setString(5, auxDep.replace("%", "").trim());
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
					
					dto.setTipoDocente(rs.getString(7));
					dto.setObservacionPlanificacion(rs.getString(8));
					
					if (rs.getString(9) == null || rs.getString(9).trim() == "") {
						dto.setEstado("  ");						
					} else {
						dto.setEstado(rs.getString(9));						
					}
					
					
					dto.setCargo("");
					dto.setDedicacion("");
					dto.setRelacionLab("");
					
					DocenteDTO doc= new DocenteDTO();
					try {
						doc= this.presentarCargoDedicacionRelLab(idPensum,  dto.getnCed());
					} catch (Exception e) {						
						e.printStackTrace();
						return null;
					}
					dto.setCargo(doc==null?"":doc.getCargo());
					dto.setDedicacion(doc==null?"":doc.getDedicacion());
					dto.setRelacionLab(doc==null?"":doc.getRelacionLab());

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
	public ArrayList<DocenteDTO> docenteXEvaluacion(Long idUser, String auxCIDoc, String auxNomDoc, String auxApelDoc, String auxDep, String perfilUsuario, Integer idPensum) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			
			if (con != null
					&& (perfilUsuario.equals("Vicerrectorado Docencia")
							|| perfilUsuario.equals("Jefe Departamento"))) {
				
				
				String qry = "SELECT  e.NCED, e.nom, e.apel, "+ 
	                            "CASE cod_tiporelacionlab WHEN 1 THEN (SELECT MAX(p.cargo) FROM \"Rrhh\".nomb_temp n, \"Rrhh\".partind p WHERE n.cod_pind= p.cod_pind AND n.frige_nomb = (SELECT MAX(frige_nomb) FROM \"Rrhh\".nomb_temp WHERE nced=e.nced) AND n.nced=e.nced) "+ 
	                            "WHEN 2 THEN (SELECT MAX(cargoc) FROM \"Rrhh\".cont c WHERE c.frige_cont=  (SELECT MAX(frige_cont) FROM \"Rrhh\".cont WHERE nced = e.nced) AND c.nced = e.nced) END, "+ 
	                            "d.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), "+
	                            "CASE cod_tiporelacionlab WHEN 1 THEN 'NOMBRAMIENTO' WHEN 2 THEN 'CONTRATO' END, "+
	                            "0.0, '', '' , 18.00, max(nro_cont), max(c.path)" +	                            
							"FROM \"Rrhh\".EMP E INNER JOIN \"Rrhh\".DEP D ON E.COD_DEP = D.COD_DEP "+ 
	                            				"LEFT OUTER JOIN \"Rrhh\".cont c ON c.nced=e.nced AND c.id_pensum= ? "+
							"WHERE  e.cod_clase = '1' "+ 
							"AND COD_EST = '1' "+							
							"AND e.nced like ? "+                       
							"AND e.nom like ? "+
							"AND e.apel like ? "+
							"AND D.COD_DEP like ? "+
	                        "AND e.nced NOT IN (SELECT  e.NCED "+
	                                            "FROM \"Rrhh\".EMP E INNER JOIN \"Rrhh\".DEP D ON E.COD_DEP = D.COD_DEP "+
	                                                    "INNER JOIN \"GestionDocente\".evaluacion_academica ea ON e.nced= ea.nced "+
	                                            "WHERE  e.cod_clase = '1' "+ 						
	                                            "AND ea.id_pensum=? "+ 
	                                            "AND e.nced like ? "+                        
	                                            "AND e.nom like ? "+
	                                            "AND e.apel like ? "+
	                                            "AND D.COD_DEP like ? ) "+
	                        "GROUP BY e.NCED, e.nom, e.apel,cod_tiporelacionlab,d.nom_dep, e.fec_ingepn, nro_cont, c.path "+
	                        "UNION ALL "+
	                        "SELECT  e.NCED, e.nom, e.apel, "+
	                            "CASE cod_tiporelacionlab WHEN 1 THEN (SELECT MAX(p.cargo) FROM \"Rrhh\".nomb_temp n, \"Rrhh\".partind p WHERE n.cod_pind= p.cod_pind AND n.frige_nomb = (SELECT MAX(frige_nomb) FROM \"Rrhh\".nomb_temp WHERE nced=e.nced) AND n.nced=e.nced) "+ 
	                            "WHEN 2 THEN (SELECT MAX(cargoc) FROM \"Rrhh\".cont c WHERE c.frige_cont=  (SELECT MAX(frige_cont) FROM \"Rrhh\".cont WHERE nced = e.nced) AND c.nced = e.nced) END, "+ 
	                            "d.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), "+
	                            "CASE cod_tiporelacionlab WHEN 1 THEN 'NOMBRAMIENTO' WHEN 2 THEN 'CONTRATO' END, "+
	                            "ea.total_horas_planificadas, ea.justificar_planificacion, ea.path_evidencia, ea.semanas_doc_dentro, max(nro_cont), max(c.path)"+	                            
							"FROM \"Rrhh\".EMP E INNER JOIN \"Rrhh\".DEP D ON E.COD_DEP = D.COD_DEP "+
	                        		"INNER JOIN \"GestionDocente\".evaluacion_academica ea ON e.nced= ea.nced "+
	                        		"LEFT OUTER JOIN \"Rrhh\".cont c ON c.nced=e.nced AND c.id_pensum= ? "+
							"WHERE  e.cod_clase = '1' "+ 
							"AND COD_EST ='1' "+																
	                        "AND ea.id_pensum=? "+
							"AND e.nced like ? "+                        
							"AND e.nom like ? "+
							"AND e.apel like ? "+
							"AND D.COD_DEP like ? "+
							"GROUP BY e.NCED, e.nom, e.apel,cod_tiporelacionlab,d.nom_dep, e.fec_ingepn, nro_cont, c.path ,ea.total_horas_planificadas, ea.justificar_planificacion, ea.path_evidencia, ea.semanas_doc_dentro "+
	                        "ORDER BY apel";

				ps = con.prepareStatement(qry);
				ps.setInt(1, idPensum);				
				ps.setString(2, auxCIDoc);
				ps.setString(3, auxNomDoc + "%");
				ps.setString(4, auxApelDoc + "%");
				ps.setString(5, auxDep);
				
				ps.setInt(6, idPensum);
				
				ps.setString(7, auxCIDoc);
				ps.setString(8, auxNomDoc + "%");
				ps.setString(9, auxApelDoc + "%");
				ps.setString(10, auxDep);
				
				ps.setInt(11, idPensum);
				ps.setInt(12, idPensum);
				
				ps.setString(13, auxCIDoc);
				ps.setString(14, auxNomDoc + "%");
				ps.setString(15, auxApelDoc + "%");
				ps.setString(16, auxDep);

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
					dto.setTotalHorasPlanificacion(Double.valueOf(rs.getString(8)));
					dto.setObservacionPlanificacion(rs.getString(9));
					dto.setPath(rs.getString(10));
					dto.setSemanasDocDentro(Double.valueOf(rs.getString(11)));
					
					if(rs.getString(12)!=null){
						dto.setContrato(rs.getString(12));
					}else{
						dto.setContrato(null);
					}
					
					if(rs.getString(13)!=null){
						dto.setPathContrato(rs.getString(13));
						dto.setPresentacion(true);
					}else{
						dto.setPathContrato(null);
						dto.setPresentacion(false);
					}
					
					
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
	public ArrayList<DocentesEvaluacionDTO> calcEvaluacionXCedulaDoc(String auxCIDoc, String auxNomDoc, String auxApelDoc, String auxDep, String perfilUsuario,  Integer idPensum, String codTipoRelacionLab) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			if (con != null) {				
				
				String qry = "SELECT DISTINCT MAX(e.NCED), e.nom, e.apel, " +
								"CASE cod_tiporelacionlab WHEN 1 THEN (SELECT p.cargo FROM \"Rrhh\".nomb_temp n, \"Rrhh\".partind p WHERE n.cod_pind= p.cod_pind AND n.frige_nomb = (SELECT MAX(frige_nomb) FROM \"Rrhh\".nomb_temp WHERE nced=e.nced) AND n.nced=e.nced) "+ 
								"WHEN 2 THEN (SELECT MAX(cargoc) FROM \"Rrhh\".cont c WHERE c.frige_cont=  (SELECT MAX(frige_cont) FROM \"Rrhh\".cont WHERE nced = e.nced) AND c.nced = e.nced) END, "+
								"d.nom_dep, id_periodo, eval.val_final_auto, eval.val_final_coe, eval.val_final_hetero, eval.estado, eval.id_eval_acad, est.descripcion "+																							
								"FROM \"Rrhh\".EMP E, \"Rrhh\".DEP D, \"GestionDocente\".evaluacion_academica eval, \"GestionDocente\".periodo p, \"GestionDocente\".estado_evaluacion est "+								 
								"WHERE E.COD_DEP = D.COD_DEP "+ 								
								"AND eval.nced= E.nced "+ 
								"AND est.nombre= eval.estado "+
								"AND COD_EST IN ('1', '3', '4', '5', '6', '7', '2') "+  
								"AND e.cod_clase = '1' "+ 
								"AND p.id_pensum= eval.id_pensum "+								
								"AND e.nced LIKE ? "+ 
								//"AND (eval.estado= 'COEVAL' OR eval.estado= 'FIN') "+
								"AND e.nom LIKE ? "+ 
								"AND e.apel LIKE ? "+ 
								"AND D.COD_DEP LIKE ? "+ 
								"AND eval.id_pensum = ? "+
								"AND (e.cod_tiporelacionlab = ? or 0=?) "+
								"GROUP BY  e.nom, e.apel, e.cod_tiporelacionlab, d.nom_dep, e.nced,  id_periodo, eval.val_final_auto, eval.val_final_coe, eval.val_final_hetero, eval.estado , eval.id_eval_acad, est.descripcion "+
								"ORDER BY e.apel";

				ps = con.prepareStatement(qry);
				ps.setString(1, auxCIDoc);
				ps.setString(2, auxNomDoc + "%");
				ps.setString(3, auxApelDoc + "%");
				ps.setString(4, auxDep);
				ps.setInt(5, idPensum);
				ps.setString(6, codTipoRelacionLab);
				ps.setString(7, codTipoRelacionLab);

				ResultSet rs = ps.executeQuery();

				ArrayList<DocentesEvaluacionDTO> listaDocentes = new ArrayList<DocentesEvaluacionDTO>();

				while (rs.next()) {

					DocentesEvaluacionDTO dto = new DocentesEvaluacionDTO();
					dto.setCedula(rs.getString(1));
					dto.setNombre(rs.getString(2));					
					dto.setApellido(rs.getString(3));
					dto.setCargo(rs.getString(4));	
					dto.setNomDepartamento(rs.getString(5));
					dto.setPeriodo(rs.getString(6));					
					dto.setIdPeriodo(String.valueOf(idPensum));
					dto.setTotalAutoEval(rs.getDouble(7));
					dto.setTotalCoeEval(rs.getDouble(8));
					dto.setTotalHeteroEval(rs.getDouble(9));
					dto.setRenderVerEvalFinal(rs.getString(10).equals("FIN")?true:false);
					dto.setIdEvalAcad(rs.getInt(11));
					dto.setEstado(rs.getString(12));
					
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
	public ArrayList<DocentesEvaluacionDTO> reportePlanificacionDoc(String auxCIDoc, String auxNomDoc, String auxApelDoc, String auxDep, String perfilUsuario,  Integer idPensum, String codTipoRelacionLab) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			if (con != null) {				
				
				String qry = "SELECT DISTINCT MAX(e.NCED), e.nom, e.apel, ' ' ," +
								/*"CASE cod_tiporelacionlab WHEN 1 THEN (SELECT p.cargo FROM \"Rrhh\".nomb_temp n, \"Rrhh\".partind p WHERE n.cod_pind= p.cod_pind AND n.frige_nomb = (SELECT MAX(frige_nomb) FROM \"Rrhh\".nomb_temp WHERE nced=e.nced) AND n.nced=e.nced) "+ 
								"WHEN 2 THEN (SELECT MAX(cargoc) FROM \"Rrhh\".cont c WHERE c.frige_cont=  (SELECT MAX(frige_cont) FROM \"Rrhh\".cont WHERE nced = e.nced) AND c.nced = e.nced) END, "+*/
								//"d.nom_dep, id_periodo, eval.val_final_auto, eval.val_final_coe, eval.val_final_hetero, eval.estado, eval.id_eval_acad, est.descripcion  "+																							
								"' ' , id_periodo, eval.val_final_auto, eval.val_final_coe, eval.val_final_hetero, eval.estado, eval.id_eval_acad, est.descripcion  "+
								"FROM \"Rrhh\".EMP E,"+
								//"\"Rrhh\".dep d,  "+
								"\"GestionDocente\".evaluacion_academica eval, \"GestionDocente\".periodo p, \"GestionDocente\".estado_evaluacion EST "+								 
								//"WHERE E.COD_DEP = D.COD_DEP "+ 								
								"WHERE eval.nced= E.nced "+ 
								//"AND COD_EST IN ('1', '3', '4', '5', '6', '7', '2') "+ 
							//	"AND e.cod_clase = '1' "+ 
								"AND p.id_pensum= eval.id_pensum "+								
								"AND e.nced LIKE ? "+
								"AND e.nom LIKE ? "+ 
								"AND e.apel LIKE ? "+ 
								"AND E.COD_DEP LIKE ? "+ 
								"AND eval.id_pensum = ? "+
								"AND (e.cod_tiporelacionlab = ? or 0=?) "+
								"AND eval.estado= est.nombre "+
								"GROUP BY  e.nom, e.apel, e.cod_tiporelacionlab, e.nced,  id_periodo, eval.val_final_auto, eval.val_final_coe, eval.val_final_hetero, eval.estado , eval.id_eval_acad, est.descripcion "+
								"ORDER BY e.apel";

				ps = con.prepareStatement(qry);
				ps.setString(1, auxCIDoc);
				ps.setString(2, auxNomDoc + "%");
				ps.setString(3, auxApelDoc + "%");
				ps.setString(4, "%%");
				ps.setInt(5, idPensum);
				ps.setString(6, codTipoRelacionLab);
				ps.setString(7, codTipoRelacionLab);

				ResultSet rs = ps.executeQuery();

				ArrayList<DocentesEvaluacionDTO> listaDocentes = new ArrayList<DocentesEvaluacionDTO>();

				while (rs.next()) {

					DocentesEvaluacionDTO dto = new DocentesEvaluacionDTO();
					dto.setCedula(rs.getString(1));
					dto.setNombre(rs.getString(2));					
					dto.setApellido(rs.getString(3));
					//dto.setCargo(rs.getString(4));	
					//dto.setNomDepartamento(rs.getString(5));
					dto.setCargo("");	
					dto.setNomDepartamento("");
					dto.setPeriodo(rs.getString(6));					
					dto.setIdPeriodo(String.valueOf(idPensum));
					dto.setTotalAutoEval(rs.getDouble(7));
					dto.setTotalCoeEval(rs.getDouble(8));
					dto.setTotalHeteroEval(rs.getDouble(9));
					dto.setRenderVerEvalFinal(rs.getString(10).equals("FIN")?true:false);
					dto.setEstado(rs.getString(12));
					dto.setIdEvalAcad(rs.getInt(11));
					
					
					
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
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EvaluacionAcademica> listEvalXEstadosPlanif(String nced){		
		try {
			
			Query q = getEntityManager()
					.createQuery(
							"SELECT e FROM EvaluacionAcademica e WHERE e.estado  NOT IN ('ING','REC','EJEC') AND e.idPensum>9 AND e.nced= ? ");
			
			q.setParameter(1, nced);	
			return  q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();			
			return null;
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EvaluacionAcademica> listEvalXEstadosDocente(String nced, String estado){		
		try {
			
			Query q = getEntityManager()
					.createQuery(
							"SELECT e FROM EvaluacionAcademica e WHERE e.nced= ? AND e.estado =? AND e.idPensum>9 ORDER BY idPensum DESC  ");
			
			q.setParameter(1, nced);	
			q.setParameter(2, estado);
			return  q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();			
			return null;
		}
		
	}
	
	
	
	@Override
	public void generarReplicaPlanificacionXPeriodo(String nced, Integer idPensumActual, Integer idPensumRepl, EvaluacionAcademica evalAcadActual, Long idUser){
		
		EvaluacionAcademica evalAcadReplica= new EvaluacionAcademica();
		try {
			List<ActividadEvaluacion> listActvidades= new ArrayList<ActividadEvaluacion>();
			List<SubactividadEvaluacion> listSubAct= new ArrayList<SubactividadEvaluacion>();
			evalAcadReplica= this.evaluacionXCedulaPeriodo(nced, idPensumRepl, "%%");
			
			if(evalAcadReplica!=null){
				listActvidades= actividadEvaluacionDAO.listActvEvalXIdEval(evalAcadReplica.getIdEvalAcad());				
				if(!listActvidades.isEmpty()){
					for(ActividadEvaluacion dto: listActvidades){
						if(dto.getIdTipoActvEval()!=1){
							
							ActividadEvaluacion actividadEvaluacion= new ActividadEvaluacion();
							actividadEvaluacion.setCalificacionPonderadaAuto(dto.getCalificacionPonderadaAuto());
							actividadEvaluacion.setCalificacionPonderadaCoe(dto.getCalificacionPonderadaCoe());
							actividadEvaluacion.setCumplimientoAuto(dto.getCumplimientoAuto());
							actividadEvaluacion.setCumplimientoCoe(dto.getCumplimientoCoe());
							actividadEvaluacion.setDescripcion(dto.getDescripcion());
							actividadEvaluacion.setEvaluacionAcademica(evalAcadActual);
							actividadEvaluacion.setFechaAuto(dto.getFechaAuto());
							actividadEvaluacion.setFechaCoe(dto.getFechaCoe());
							actividadEvaluacion.setFechaPlanif(new Date());
							actividadEvaluacion.setIdTipoActvEval(dto.getIdTipoActvEval());
							actividadEvaluacion.setReglamentoEvaluacion(dto.getReglamentoEvaluacion());
							actividadEvaluacion.setNombreActividad(dto.getNombreActividad());
							actividadEvaluacion.setValActvDocHrsDentro(dto.getValActvDocHrsDentro());
							actividadEvaluacion.setValor16Auto(dto.getValor16Planif());
							actividadEvaluacion.setValor16Coe(dto.getValor16Planif());
							actividadEvaluacion.setValor16Planif(dto.getValor16Planif());
							actividadEvaluacion.setValor8Planif(0.0);
							actividadEvaluacion.setIdUsuarioPlanif(Integer.valueOf(String.valueOf(idUser)));							
							
							actividadEvaluacionDAO.save(actividadEvaluacion);
							
							listSubAct= subactividadEvaluacionDAO.listSubActvXIdActv(dto.getIdActividadEvaluacion());
							
							if(!listSubAct.isEmpty()){
								for(SubactividadEvaluacion subDto : listSubAct){
									SubactividadEvaluacion subactividadEvaluacion= new SubactividadEvaluacion();
									subactividadEvaluacion.setActividadEvaluacion(actividadEvaluacion);
									subactividadEvaluacion.setCumplAuto(subDto.getCumplAuto());
									subactividadEvaluacion.setCumplCoe(subDto.getCumplCoe());
									subactividadEvaluacion.setHorasAuto(subDto.getHorasAuto());
									subactividadEvaluacion.setHorasCoe(subDto.getHorasCoe());
									subactividadEvaluacion.setHorasPlanif(subDto.getHorasPlanif());
									subactividadEvaluacion.setNombreSubactividad(subDto.getNombreSubactividad());
									
									subactividadEvaluacionDAO.save(subactividadEvaluacion);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<EvaluacionAcademica> evaluacionXPeriodo(Integer idPensum) throws Exception {
		
		try {
		Query q = getEntityManager()
				.createQuery(
						"SELECT e FROM EvaluacionAcademica e WHERE e.idPensum= ? ");

		
		
		q.setParameter(1, idPensum);
		
		
		
		
		return (List<EvaluacionAcademica>) q.getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	
	@Override
	public ArrayList<DocentesEvaluacionDTO> reportePlanificacion2017A() throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			if (con != null) {				
				
				String qry = "SELECT DISTINCT MAX(e.NCED), e.nom, e.apel, " +
								"CASE cod_tiporelacionlab WHEN 1 THEN (SELECT p.cargo FROM \"Rrhh\".nomb_temp n, \"Rrhh\".partind p WHERE n.cod_pind= p.cod_pind AND n.frige_nomb = (SELECT MAX(frige_nomb) FROM \"Rrhh\".nomb_temp WHERE nced=e.nced) AND n.nced=e.nced) "+ 
								"WHEN 2 THEN (SELECT MAX(cargoc) FROM \"Rrhh\".cont c WHERE c.frige_cont=  (SELECT MAX(frige_cont) FROM \"Rrhh\".cont WHERE nced = e.nced) AND c.nced = e.nced) END, "+
								"d.nom_dep, id_periodo, eval.val_final_auto, eval.val_final_coe, eval.val_final_hetero, eval.estado, eval.id_eval_acad, est.descripcion  "+																							
								"FROM \"Rrhh\".EMP E, \"Rrhh\".DEP D, \"GestionDocente\".evaluacion_academica eval, \"GestionDocente\".periodo p, \"GestionDocente\".estado_evaluacion EST "+								 
								"WHERE E.COD_DEP = D.COD_DEP "+ 								
								"AND eval.nced= E.nced "+ 
								"AND COD_EST IN ('1', '3', '4', '5', '6', '7', '2') "+ 
								"AND e.cod_clase = '1' "+ 
								"AND p.id_pensum= eval.id_pensum "+								
								"AND e.nced LIKE '%%' "+
								"AND e.nom LIKE '%%' "+ 
								"AND e.apel LIKE '%%' "+ 
								"AND eval.fecha_ingreso like '%2018-07%' "+
								"AND D.COD_DEP LIKE '%%' "+ 
								"AND eval.id_pensum = 9 "+								
								"AND eval.estado= est.nombre "+
								"GROUP BY  e.nom, e.apel, e.cod_tiporelacionlab, d.nom_dep, e.nced,  id_periodo, eval.val_final_auto, eval.val_final_coe, eval.val_final_hetero, eval.estado , eval.id_eval_acad, est.descripcion "+
								"ORDER BY e.apel";

				ps = con.prepareStatement(qry);
				

				ResultSet rs = ps.executeQuery();

				ArrayList<DocentesEvaluacionDTO> listaDocentes = new ArrayList<DocentesEvaluacionDTO>();

				while (rs.next()) {

					DocentesEvaluacionDTO dto = new DocentesEvaluacionDTO();
					dto.setCedula(rs.getString(1));
					dto.setNombre(rs.getString(2));					
					dto.setApellido(rs.getString(3));
					dto.setCargo(rs.getString(4));	
					dto.setNomDepartamento(rs.getString(5));
					dto.setPeriodo(rs.getString(6));					
					dto.setIdPeriodo("9");
					dto.setTotalAutoEval(rs.getDouble(7));
					dto.setTotalCoeEval(rs.getDouble(8));
					dto.setTotalHeteroEval(rs.getDouble(9));
					dto.setRenderVerEvalFinal(rs.getString(10).equals("FIN")?true:false);
					dto.setEstado(rs.getString(12));
					dto.setIdEvalAcad(rs.getInt(11));
					
					
					
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
	public ArrayList<DocentesEvaluacionDTO> calcEvaluacionXCedulaDocReporteGIEPN(String auxCIDoc, String auxNomDoc, String auxApelDoc, String auxDep, String perfilUsuario,  Integer idPensum, String codTipoRelacionLab) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			if (con != null) {				
				
				String qry = "SELECT DISTINCT MAX(e.NCED), e.nom, e.apel, "+									
									 "'' AS CARGO, "+ 								
									"d.nom_dep, id_periodo, eval.val_final_auto, eval.val_final_coe, eval.val_final_hetero, eval.estado, eval.id_eval_acad, est.descripcion, "+
									"'' AS dedicacion, "+
									"'' AS tipo, eval.justificar_planificacion "+	
								"FROM \"Rrhh\".EMP E, \"Rrhh\".DEP D, \"GestionDocente\".evaluacion_academica eval, \"GestionDocente\".periodo p, \"GestionDocente\".estado_evaluacion est "+
								"WHERE E.COD_DEP = D.COD_DEP "+ 							
								"AND eval.nced= E.nced "+
								"AND est.nombre= eval.estado "+ 
								"AND COD_EST IN ('1', '3', '4', '5', '6', '7', '2') "+ 
								"AND e.cod_clase = '1' "+
								"AND p.id_pensum= eval.id_pensum "+ 
								"AND e.nced LIKE ? "+
								"AND (eval.estado= 'COEVAL' OR eval.estado= 'FIN') "+ 
								"AND e.nom LIKE ? "+  
								"AND e.apel LIKE ? "+ 
								"AND D.COD_DEP LIKE ? "+   
								"AND eval.id_pensum = ? "+
								"AND (e.cod_tiporelacionlab = ? or 0=?) "+ 
								"GROUP BY  e.nom, e.apel, e.cod_tiporelacionlab, d.nom_dep, e.nced,  id_periodo, eval.val_final_auto, eval.val_final_coe, eval.val_final_hetero, eval.estado , eval.id_eval_acad, est.descripcion "+
								"ORDER BY e.apel";

				ps = con.prepareStatement(qry);
				ps.setString(1, auxCIDoc);
				ps.setString(2, auxNomDoc + "%");
				ps.setString(3, auxApelDoc + "%");
				ps.setString(4, auxDep);
				ps.setInt(5, idPensum);
				ps.setString(6, codTipoRelacionLab);
				ps.setString(7, codTipoRelacionLab);

				ResultSet rs = ps.executeQuery();

				ArrayList<DocentesEvaluacionDTO> listaDocentes = new ArrayList<DocentesEvaluacionDTO>();

				while (rs.next()) {

					DocentesEvaluacionDTO dto = new DocentesEvaluacionDTO();
					dto.setCedula(rs.getString(1));
					dto.setNombre(rs.getString(2));					
					dto.setApellido(rs.getString(3));						
					dto.setNomDepartamento(rs.getString(5));
					dto.setPeriodo(rs.getString(6));					
					dto.setIdPeriodo(String.valueOf(idPensum));
					dto.setTotalAutoEval(rs.getDouble(7));
					dto.setTotalCoeEval(rs.getDouble(8));
					dto.setTotalHeteroEval(rs.getDouble(9));
					dto.setRenderVerEvalFinal(rs.getString(10).equals("FIN")?true:false);
					dto.setIdEvalAcad(rs.getInt(11));
					dto.setEstado(rs.getString(12));
					
					
					//dto.setTipo(rs.getString(14));
					dto.setJustificacionHorasPlanif(rs.getString(15)==null?"":rs.getString(15));
				
				/*dto.setCargo("");
					dto.setDedicacion("");
					dto.setRelacionLab("");*/
					
					DocenteDTO doc= new DocenteDTO();
					try {
						doc= this.presentarCargoDedicacionRelLab(idPensum,  dto.getCedula());
					} catch (Exception e) {						
						e.printStackTrace();
						return null;
					}
					dto.setCargo(doc==null?"":doc.getCargo());
					dto.setDedicacion(doc==null?"":doc.getDedicacion());
					dto.setRelacionLab(doc==null?"":doc.getRelacionLab());
					
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
	public DocenteDTO presentarCargoDedicacionRelLab(Integer idPensum,  String nced)throws Exception {
		
		DocenteDTO val = new DocenteDTO();
		Query query = null;
		query = getEntityManager().createNativeQuery("SELECT  * FROM \"Rrhh\".bi_reportecargodeprrhh(?,?);");
		
		query.setParameter(1, idPensum);
		query.setParameter(2, nced);
		
		List<?> lists = query.getResultList();
		
		if (!lists.isEmpty()) {
			for (Object list : lists) {
				val = new DocenteDTO();
				Object[] col = (Object[]) list;
				if (col[0] != null && col[0].toString().length() != 0)
					val.setnCed(col[0]==null? "" : col[0].toString());
				
				
				if (col[1] != null && col[1].toString().length() != 0){
					String dato= null;
					dato=(col[1]==null ? "" : col[1].toString());
					val.setCargo(dato);
					
				}
				
				if (col[2] != null && col[2].toString().length() != 0){
					String dato= null;
					dato=(col[2]==null ? "" : col[2].toString());
					val.setDedicacion(dato);
					
				}
				
				if (col[3] != null && col[3].toString().length() != 0){
					String dato= null;
					dato=(col[3]==null ? "" : col[3].toString());
					val.setRelacionLab(dato);
					
				}
				
				if (col[4] != null && col[4].toString().length() != 0){
					String dato= null;
					dato=(col[4]==null ? "" : col[4].toString());
					val.setNomDepartamento(dato);
					
				}
			}
		
		}else{
			val= null;
		}
		
		return val;
		
	}
	
	
	@Override
	public DocenteDTO consultaPlanificacion(String auxCIDoc, Integer idPensum, DocenteDTO dto) throws Exception {

		
		try {	
				Query q = getEntityManager()
						.createQuery(
								"SELECT e FROM EvaluacionAcademica e WHERE e.nced like ? AND e.idPensum= ? ");

				
				q.setParameter(1, "%" + auxCIDoc + "%");
				q.setParameter(2, idPensum);
				
				
				EvaluacionAcademica evaluacionAcademica= new EvaluacionAcademica();
				evaluacionAcademica= (EvaluacionAcademica) q.getSingleResult();
				
				
					
				
				if(evaluacionAcademica!=null){
					EstadoEvaluacion estado= estadoEvaluacionDAO.estadoEvalXNombre(evaluacionAcademica.getEstado());
					dto.setCategoria(evaluacionAcademica.getIdEvalAcad().toString());					
					dto.setEstado(estado.getDescripcion());
					dto.setTotalHorasPlanificacion(evaluacionAcademica.getTotalHorasPlanificadas());
					dto.setObservacionPlanificacion(evaluacionAcademica.getJustificarPlanificacion());
					dto.setPath(evaluacionAcademica.getPathEvidencia());
					dto.setSemanasDocDentro(evaluacionAcademica.getSemanasDocDentro());
					dto.setIdEvalAcad(evaluacionAcademica.getIdEvalAcad());
				}
				else{
					dto.setObservacionPlanificacion("0");
					dto.setIdEvalAcad(0);
					dto.setEstado("");
				}
				
				
				return dto;
			
			

		} catch (Exception e) {
			dto.setIdEvalAcad(0);
			dto.setObservacionPlanificacion("0");
			dto.setEstado("");
			return dto;
		} 
	}
	
	
	
	@Override
	public DocenteDTO consultaReporteEvaluacion(String auxCIDoc, Integer idPensum, DocenteDTO dto) throws Exception {

		
		try {	
				Query q = getEntityManager()
						.createQuery(
								"SELECT e FROM EvaluacionAcademica e WHERE e.nced like ? AND e.idPensum= ? ");

				
				q.setParameter(1, "%" + auxCIDoc + "%");
				q.setParameter(2, idPensum);
				
				
				EvaluacionAcademica evaluacionAcademica= new EvaluacionAcademica();
				evaluacionAcademica= (EvaluacionAcademica) q.getSingleResult();
				
				
					
				
				if(evaluacionAcademica!=null){
					dto.setIdEvalAcad(evaluacionAcademica.getIdEvalAcad());
					EstadoEvaluacion estado= estadoEvaluacionDAO.estadoEvalXNombre(evaluacionAcademica.getEstado());					
					dto.setEstado(estado.getDescripcion());
					
					if(estado.getNombre().equals("PLANIF") || estado.getNombre().equals("RECAUTO")){
						dto.setRenderVerPlanif(true);
						dto.setRenderVerAuto(false);
						dto.setRenderVerCoe(false);
						dto.setRenderVerEvalFinal(false);

					}else if(estado.getNombre().equals("AUTOEVAL")){
						dto.setRenderVerPlanif(true);
						dto.setRenderVerAuto(true);
						dto.setRenderVerCoe(false);
						dto.setRenderVerEvalFinal(false);
						
					}else if(estado.getNombre().equals("COEVAL")){						
						dto.setRenderVerPlanif(true);
						dto.setRenderVerAuto(true);
						dto.setRenderVerCoe(true);
						dto.setRenderVerEvalFinal(false);
						
					}else if(estado.getNombre().equals("FIN")){
						dto.setRenderVerPlanif(true);
						dto.setRenderVerAuto(true);
						dto.setRenderVerCoe(true);
						dto.setRenderVerEvalFinal(true);
						
					}else{
						dto.setRenderVerPlanif(false);
						dto.setRenderVerAuto(false);
						dto.setRenderVerCoe(false);
						dto.setRenderVerEvalFinal(false);
					}
					
				}
				else{
					dto.setObservacionPlanificacion("0");
					dto.setIdEvalAcad(0);
					dto.setEstado("");
					dto.setRenderVerPlanif(false);
					dto.setRenderVerAuto(false);
					dto.setRenderVerCoe(false);
					dto.setRenderVerEvalFinal(false);
				}
				
				
				return dto;

		} catch (Exception e) {
			dto.setIdEvalAcad(0);
			dto.setObservacionPlanificacion("0");
			dto.setEstado("");
			return dto;
		} 
	}
	
	@Override
	public void generaPlanifXPreplanif(EvaluacionAcademica evaluacionAcademica, Integer idUsuarioLog){
		try {
			
			PreplanificacionDocencia preplanificacion= new PreplanificacionDocencia();
			Pedido pedidoPreplanif= new Pedido();
			PreplanificacionDocencia preplanificacionAp= new PreplanificacionDocencia();
			preplanificacion= preplanificacionDocenciaDAO.preplanifXPeriodo(evaluacionAcademica.getNced(), "", evaluacionAcademica.getIdPensum(), "PREPLANIF", "");
			
			
			if(preplanificacion==null){
				preplanificacion= new PreplanificacionDocencia();
				pedidoPreplanif= preplanificacionDocenciaDAO.findPedidoPreplanif(evaluacionAcademica.getNced(), evaluacionAcademica.getIdPensum(), 12);
				
				if(pedidoPreplanif!=null){				
						
							preplanificacion= preplanificacionDocenciaDAO.findByPedido(pedidoPreplanif.getIdPedido());
							
							if(preplanificacion!=null && preplanificacion.getEstado().equals("PREPLANIF")){
								preplanificacionAp= preplanificacion;
							}else{
								preplanificacionAp= null;
							}
				}
				
			}else{
				preplanificacionAp= preplanificacion;
			}
			
			if(preplanificacionAp!=null){
				if(evaluacionAcademica.getTotalHorasPlanificadas()==0){
					evaluacionAcademica.setTotalHorasPlanificadas(preplanificacionAp.getHorasExigibles());
					super.update(evaluacionAcademica);
				}
					
				
			
				List<ActividadPreplanificacion> listActvPrep= new ArrayList<ActividadPreplanificacion>();			
				List<SubactividadPreplanificacion> listSUbAcPrep= new ArrayList<SubactividadPreplanificacion>();
				
				
				listActvPrep= actividadPreplanificacionDAO.findActividadByIdPreplanifGeneral(preplanificacionAp.getIdPreplanif());
				
				if(!listActvPrep.isEmpty()){
					for(ActividadPreplanificacion actvPrep: listActvPrep){
						ActividadEvaluacion actividadEvaluacion= new ActividadEvaluacion();
						if(actvPrep.getReglamentoEvaluacion().getIdReglamentoEvaluacion()!=41){							
							
							actividadEvaluacion.setIdTipoActvEval(actvPrep.getIdTipoActv());
							actividadEvaluacion.setValor16Auto(actvPrep.getValorPreplanif());
							actividadEvaluacion.setValor16Planif(actvPrep.getValorPreplanif());
							actividadEvaluacion.setValor16Coe(actvPrep.getValorPreplanif());
							actividadEvaluacion.setEvaluacionAcademica(evaluacionAcademica);
							actividadEvaluacion.setReglamentoEvaluacion(actvPrep.getReglamentoEvaluacion());
							actividadEvaluacion.setCalificacionPonderadaAuto(0.0);
							actividadEvaluacion.setCalificacionPonderadaCoe(0.0);
							actividadEvaluacion.setCumplimientoAuto(100.0);
							actividadEvaluacion.setCumplimientoCoe(100.0);			
							actividadEvaluacion.setValor8Planif(0.0);
							actividadEvaluacion.setIdUsuarioPlanif(Integer.valueOf(String.valueOf(idUsuarioLog)));
							actividadEvaluacion.setFechaPlanif(new Date());
							actividadEvaluacion.setFechaAuto(new Date());
							actividadEvaluacion.setFechaCoe(new Date());
						
						
							actividadEvaluacionDAO.save(actividadEvaluacion);
						
							listSUbAcPrep= subactividadPreplanificacionDAO.listSubActvXIdActvPreplanif(actvPrep.getIdActividadPreplanif());
							
							if(!listSUbAcPrep.isEmpty()){
								for(SubactividadPreplanificacion subPrep: listSUbAcPrep){
									SubactividadEvaluacion subactividadEvaluacion= new SubactividadEvaluacion();
									
									subactividadEvaluacion.setHorasPlanif(subPrep.getHorasPreplanif());
									subactividadEvaluacion.setHorasAuto(0.0);
									subactividadEvaluacion.setHorasCoe(0.0);
									subactividadEvaluacion.setActividadEvaluacion(actividadEvaluacion);
									subactividadEvaluacion.setNombreSubactividad(subPrep.getNombreSubactividad());
									
									subactividadEvaluacionDAO.save(subactividadEvaluacion);
								}
							}
						}	
					}
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public EvaluacionAcademica evalXAnioPensum(String cedula, String anioPensum, String numeroPensum){
		try {
			EvaluacionAcademica evaluacion= new EvaluacionAcademica();
			String meses= anioPensum + "-" +(numeroPensum.equals("2")?"B":(numeroPensum.equals("1")?"A":0));
			Pensum pensum= new Pensum();
			
			Query q = getEntityManager().createQuery("SELECT pen FROM Pensum pen where pen.meses = ?1 ");

			q.setParameter(1, meses);
			
			try {
				pensum= (Pensum) q.getSingleResult();
			} catch (Exception e) {
				pensum= null;
			}
			
			if(pensum!=null){
				
				evaluacion= this.evaluacionXCedulaPeriodo(cedula, pensum.getIdPensum(), "%%");
			}
			
			
			return evaluacion;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	@Override
	public HorasPeriodoAcademicoDTO datosDocenteEvaluacionHorasPeriodo(Integer idPensum, String nced) throws Exception {

		HorasPeriodoAcademicoDTO datosDocente = new HorasPeriodoAcademicoDTO();		
		Query query = null;
		query = getEntityManager().createNativeQuery("SELECT  * FROM \"Rrhh\".bi_reportecargodeprrhh(?,?,?,?,?) "
														+ "sp LEFT JOIN \"Rrhh\".bi_reportelicenperiodonomb(?) licen on sp.nced = licen.ncedlic "
														+ "LEFT JOIN \"Rrhh\".bi_reporteperiodocontratonomb(?) cont on sp.nced = cont.ncedcont "
														+ "LEFT JOIN \"Rrhh\".bi_reportejubilados(?) jub on jub.ncedjub = sp.nced;");

		query.setParameter(1, idPensum);
		query.setParameter(2, nced);
		query.setParameter(3, "%%");
		query.setParameter(4, "%%");
		query.setParameter(5, "%%");
		query.setParameter(6, idPensum);
		query.setParameter(7, idPensum);
		query.setParameter(8, idPensum);

		List<?> lists = query.getResultList();
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");  
		
		
		Pensum pensum= new Pensum();
		pensum= pensumDAO.obtenerPensumById(idPensum);

		if (!lists.isEmpty()) {
			for (Object list : lists) {
				HorasPeriodoAcademicoDTO val = new HorasPeriodoAcademicoDTO();
				Object[] col = (Object[]) list;

				if (col[0] != null && col[0].toString().length() != 0)
					val.setnCed(col[0] == null ? "" : col[0].toString());

				

				if (col[5] != null && col[5].toString().length() != 0) {
					String dato = null;
					dato = (col[5] == null ? "" : col[5].toString());
					val.setDedicacion(dato);
				}

				if (col[6] != null && col[6].toString().length() != 0) {
					String dato = null;
					dato = (col[6] == null ? "" : col[6].toString());
					val.setTipo(dato);
				}

				
				if (col[17] != null && col[17].toString().length() != 0) {
					String dato = null;
					dato = col[17].toString();
					val.setFechaInicioPeriodo(format.parse(dato));

				}else{
					val.setFechaInicioPeriodo(null);
				}
				
				if (col[18] != null && col[18].toString().length() != 0) {
					String dato = null;
					dato = col[18].toString();
					val.setFechaFinPeriodo(format.parse(dato));

				}else{
					val.setFechaFinPeriodo(null);
				}

				datosDocente= val;
			}
			
			datosDocente.setDiasPermiso(0);
			datosDocente.setDiasVacacion(0);
			datosDocente.setHorasPeriodoAcademico(0.0);			
			Date fechaInicio= datosDocente.getFechaInicioPeriodo();
			Date fechaFin= datosDocente.getFechaFinPeriodo();
			
			if((datosDocente.getDedicacion().trim().equals("TC") || datosDocente.getDedicacion().trim().equals("TP")) 
											&& datosDocente.getTipo().trim().toUpperCase().equals("NOMBRAMIENTO")){
				if(fechaInicio==null && fechaFin==null){
					fechaInicio= pensum.getFechaInicioEval();
					fechaFin= pensum.getFechaFinEval();
				}
			}else if((datosDocente.getDedicacion().trim().equals("TC") || datosDocente.getDedicacion().trim().equals("TP")) 
					&& datosDocente.getTipo().trim().toUpperCase().equals("CONTRATO")){
				if(fechaInicio!=null && fechaFin!=null){
					if(fechaInicio.compareTo(pensum.getFechaInicioEval())==-1){
						fechaInicio= pensum.getFechaInicioEval();
					}
					
					
					if(fechaFin.compareTo(pensum.getFechaFinEval())==1){
						fechaFin= pensum.getFechaFinEval();
					}
				}
			}
			
			
			datosDocente.setFechaInicioPeriodo(fechaInicio);
			datosDocente.setFechaFinPeriodo(fechaFin);
			Calendar calendarI = Calendar.getInstance();			
			calendarI.setTime(fechaInicio);
			
			Calendar calendarF = Calendar.getInstance();				
			calendarF.setTime(fechaFin);
				
			int l=this.diasHabiles(calendarI, calendarF);				
			datosDocente.setDiasLaborables(l);				
			datosDocente.setDiasDescanso(descansoObligatorioDAO.diasDescansoObligatorio(datosDocente.getFechaInicioPeriodo(), datosDocente.getFechaFinPeriodo()));
				
			datosDocente.setDiasLabDesc(datosDocente.getDiasLaborables() - datosDocente.getDiasDescanso());
			
			
			if((datosDocente.getTipo().trim().toUpperCase().equals("NOMBRAMIENTO") || datosDocente.getTipo().trim().toUpperCase().equals("CONTRATO")) 
					&& datosDocente.getDedicacion().trim().equals("TP")){
				
				datosDocente.setDedicacionTP(true);
				datosDocente.setHorasDedicacion(0);
				datosDocente.setPromedioHorasDiaria(0.00);
			}else{
				datosDocente.setDedicacionTP(false);
				datosDocente.setHorasDedicacion(40);
				datosDocente.setPromedioHorasDiaria(8.00);
			}
			
			

		} else {
			datosDocente = new HorasPeriodoAcademicoDTO();
		}
		
		
		
		

		return datosDocente;
	}
	
	
	
	
	public int diasHabiles(Calendar fechaInicial, Calendar fechaFinal) {
		int diffDays = 0;
		boolean diaHabil = false;
		// mientras la fecha inicial sea menor o igual que la fecha final se
		// cuentan los dias
		while (fechaInicial.before(fechaFinal) || fechaInicial.equals(fechaFinal)) {

			if (fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
					&& fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
				// se aumentan los dias de diferencia entre min y max
				diffDays++;
			}

			if (diaHabil == true) {
				diffDays++;
			}
			// se suma 1 dia para hacer la validacion del siguiente dia.
			fechaInicial.add(Calendar.DATE, 1);
		}
		return diffDays;
	}
	

		

}


