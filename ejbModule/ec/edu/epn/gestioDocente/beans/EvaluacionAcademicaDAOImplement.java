package ec.edu.epn.gestioDocente.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.sql.DataSource;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.ActAcademica;
import ec.edu.epn.gestionDocente.entities.ActividadEvaluacion;
import ec.edu.epn.gestionDocente.entities.EvaluacionAcademica;
import ec.edu.epn.gestionDocente.entities.PlanfActAcademica;
import ec.edu.epn.gestionDocente.entities.SubactividadEvaluacion;
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
						"SELECT e FROM EvaluacionAcademica e WHERE e.nced=? AND e.idPensum= ? AND e.estado  like ? ");

		
		q.setParameter(1, nced);
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
						"SELECT count(e) FROM EvaluacionAcademica e WHERE e.nced=? AND e.idPensum= ? AND e.estado like ? ");

		
		q.setParameter(1, nced);
		q.setParameter(2, idPensum);
		q.setParameter(3, estado);
		
		
		return (Long) q.getSingleResult();
	}
	
	
	@Override
	public EvaluacionAcademica evaluacionXCedulaPeriodoEstado(String nced, Integer idPensum, String estado, String estado2) throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT e FROM EvaluacionAcademica e WHERE e.nced=? AND e.idPensum= ? AND (e.estado  like ? OR e.estado  like ?) ");

		
		q.setParameter(1, nced);
		q.setParameter(2, idPensum);
		q.setParameter(3, estado);
		q.setParameter(4, estado2);
		
		
		
		return (EvaluacionAcademica) q.getSingleResult();
	}
	
	
	
	@Override
	public Long countEvalXDocPeriodoEstado(String nced, Integer idPensum, String estado,String estado2)throws Exception {
			
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(e) FROM EvaluacionAcademica e WHERE e.nced=? AND e.idPensum= ? AND (e.estado  like ? OR e.estado  like ?) ");

		
		q.setParameter(1, nced);
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
				
				
				String qry = "SELECT  e.NCED, e.nom, e.apel, " +
						"CASE cod_tiporelacionlab WHEN 1 THEN (SELECT MAX(p.cargo) FROM \"Rrhh\".nomb_temp n, \"Rrhh\".partind p WHERE n.cod_pind= p.cod_pind AND n.frige_nomb = (SELECT MAX(frige_nomb) FROM \"Rrhh\".nomb_temp WHERE nced=e.nced) AND n.nced=e.nced) "+ 
						"WHEN 2 THEN (SELECT MAX(cargoc) FROM \"Rrhh\".cont c WHERE c.frige_cont=  (SELECT MAX(frige_cont) FROM \"Rrhh\".cont WHERE nced = e.nced) AND c.nced = e.nced) END, "+
						"d.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), " +
						"CASE cod_tiporelacionlab WHEN 1 THEN 'NOMBRAMIENTO' WHEN 2 THEN 'CONTRATO' END, "+
						"ea.id_eval_acad, "+
						"est.descripcion "+
						//"CASE ea.estado WHEN 'ING' THEN 'INGRESADO' WHEN 'EJEC' THEN 'ENVIADO' WHEN 'REC' THEN 'POR RECTIFICAR' WHEN 'PLANIF' THEN 'PLANIFICADO' END "+
						"FROM \"Rrhh\".EMP E, \"Rrhh\".DEP D,  \"Contratos\".pensum P, \"GestionDocente\".evaluacion_academica EA, \"GestionDocente\".estado_evaluacion EST " +  
						"WHERE E.COD_DEP = D.COD_DEP " +												
						"AND e.cod_clase = '1' "+
						"AND e.nced= ea.nced "+
						"AND ea.id_pensum= p.id_pensum "+
						"AND e.nced like ? "+
						"AND e.nom like ? "+
						"AND e.apel like ? "+						
						"AND D.COD_DEP like ? "+
						"AND p.id_pensum= ? "+
						"AND ea.estado= est.nombre "+
						"UNION ALL "+
						"SELECT  e.NCED, e.nom, e.apel, "+
						"CASE cod_tiporelacionlab WHEN 1 THEN (SELECT MAX(p.cargo) FROM \"Rrhh\".nomb_temp n, \"Rrhh\".partind p WHERE n.cod_pind= p.cod_pind AND n.frige_nomb = (SELECT MAX(frige_nomb) FROM \"Rrhh\".nomb_temp WHERE nced=e.nced) AND n.nced=e.nced) "+  
						"WHEN 2 THEN (SELECT MAX(cargoc) FROM \"Rrhh\".cont c WHERE c.frige_cont=  (SELECT MAX(frige_cont) FROM \"Rrhh\".cont WHERE nced = e.nced) AND c.nced = e.nced) END, "+
						"d.nom_dep, to_date(e.fec_ingepn,'yyyy-MM-dd'), "+
						"CASE cod_tiporelacionlab WHEN 1 THEN 'NOMBRAMIENTO' WHEN 2 THEN 'CONTRATO' END, "+ 
						"0, '' "+
						"FROM \"Rrhh\".EMP E INNER JOIN \"Rrhh\".DEP D ON E.COD_DEP = D.COD_DEP "+									
						"WHERE e.cod_clase = '1'  "+
						"AND e.cod_est=1 "+
						"AND e.nced like ? "+ 
						"AND e.nom like ? "+
						"AND e.apel like ? "+						
						"AND D.COD_DEP like ? "+ 
						"AND e.nced NOT IN (SELECT  et.NCED "+
									"FROM \"GestionDocente\".evaluacion_academica eat INNER JOIN \"Rrhh\".EMP et ON eat.nced= et.nced "+ 
									"INNER JOIN \"Rrhh\".DEP dt ON e.COD_DEP = dt.COD_DEP "+
									"INNER JOIN \"Contratos\".pensum pt ON eat.id_pensum= pt.id_pensum "+ 						
									"WHERE et.cod_clase = '1' "+
									"AND pt.id_pensum= ?) "+
						"ORDER BY apel ";

				ps = con.prepareStatement(qry);

				ps.setString(1, auxCIDoc);
				ps.setString(2, auxNomDoc + "%");
				ps.setString(3, auxApelDoc + "%");
				ps.setString(4, auxDep);
				ps.setInt(5, idPensum);
				ps.setString(6, auxCIDoc);
				ps.setString(7, auxNomDoc + "%");
				ps.setString(8, auxApelDoc + "%");
				ps.setString(9, auxDep);
				ps.setInt(10, idPensum);
				
				

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
							//"AND COD_EST IN ('1', '3', '4', '5', '6', '7') "+																
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
							//"AND COD_EST IN ('1', '3', '4', '5', '6', '7') "+																
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
								"d.nom_dep, id_periodo, eval.val_final_auto, eval.val_final_coe, eval.val_final_hetero, eval.estado, eval.id_eval_acad "+																							
								"FROM \"Rrhh\".EMP E, \"Rrhh\".DEP D, \"GestionDocente\".evaluacion_academica eval, \"GestionDocente\".periodo p "+								 
								"WHERE E.COD_DEP = D.COD_DEP "+ 								
								"AND eval.nced= E.nced "+ 
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
								"GROUP BY  e.nom, e.apel, e.cod_tiporelacionlab, d.nom_dep, e.nced,  id_periodo, eval.val_final_auto, eval.val_final_coe, eval.val_final_hetero, eval.estado , eval.id_eval_acad "+
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
				
				String qry = "SELECT DISTINCT MAX(e.NCED), e.nom, e.apel, " +
								"CASE cod_tiporelacionlab WHEN 1 THEN (SELECT p.cargo FROM \"Rrhh\".nomb_temp n, \"Rrhh\".partind p WHERE n.cod_pind= p.cod_pind AND n.frige_nomb = (SELECT MAX(frige_nomb) FROM \"Rrhh\".nomb_temp WHERE nced=e.nced) AND n.nced=e.nced) "+ 
								"WHEN 2 THEN (SELECT MAX(cargoc) FROM \"Rrhh\".cont c WHERE c.frige_cont=  (SELECT MAX(frige_cont) FROM \"Rrhh\".cont WHERE nced = e.nced) AND c.nced = e.nced) END, "+
								"d.nom_dep, id_periodo, eval.val_final_auto, eval.val_final_coe, eval.val_final_hetero, eval.estado, eval.id_eval_acad "+																							
								"FROM \"Rrhh\".EMP E, \"Rrhh\".DEP D, \"GestionDocente\".evaluacion_academica eval, \"GestionDocente\".periodo p "+								 
								"WHERE E.COD_DEP = D.COD_DEP "+ 								
								"AND eval.nced= E.nced "+ 
								"AND COD_EST IN ('1', '3', '4', '5', '6', '7', '2') "+ 
								"AND e.cod_clase = '1' "+ 
								"AND p.id_pensum= eval.id_pensum "+								
								"AND e.nced LIKE ? "+
								"AND e.nom LIKE ? "+ 
								"AND e.apel LIKE ? "+ 
								"AND D.COD_DEP LIKE ? "+ 
								"AND eval.id_pensum = ? "+
								"AND (e.cod_tiporelacionlab = ? or 0=?) "+
								"GROUP BY  e.nom, e.apel, e.cod_tiporelacionlab, d.nom_dep, e.nced,  id_periodo, eval.val_final_auto, eval.val_final_coe, eval.val_final_hetero, eval.estado , eval.id_eval_acad "+
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
	
}

