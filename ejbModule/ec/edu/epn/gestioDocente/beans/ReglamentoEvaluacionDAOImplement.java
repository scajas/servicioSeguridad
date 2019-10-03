package ec.edu.epn.gestioDocente.beans;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.sql.DataSource;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.DTO.CatalogoActividadesDTO;
import ec.edu.epn.gestionDocente.DTO.ReglamentoEvalDTO;
import ec.edu.epn.gestionDocente.entities.ReglamentoEvaluacion;

/**
 * Session Bean implementation class ActividadDocenciaDAOImplement
 */
@Stateless
@LocalBean
public class ReglamentoEvaluacionDAOImplement extends DaoGenericoImplement<ReglamentoEvaluacion>
		implements ReglamentoEvaluacionDAO {

	@Resource(mappedName = "java:jboss/datasources/SeguridadEPNDS")
	private DataSource dataSource;

	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogoActividadesDTO> listReglamentoActvXTipo(Integer tipoActvEval, String estado) throws Exception {
		List<CatalogoActividadesDTO> listCatalogo = new ArrayList<CatalogoActividadesDTO>();
		List<ReglamentoEvaluacion> listReglamento = new ArrayList<ReglamentoEvaluacion>();
		Query q = getEntityManager().createQuery(
				"SELECT r FROM ReglamentoEvaluacion r WHERE r.idTipoActvEval= ? AND estado= ? ORDER BY idReglamentoEvaluacion");

		q.setParameter(1, tipoActvEval);
		q.setParameter(2, estado);

		listReglamento = q.getResultList();

		if (!listReglamento.isEmpty()) {
			for (ReglamentoEvaluacion dto : listReglamento) {
				CatalogoActividadesDTO catalogoActividadesDTO = new CatalogoActividadesDTO();
				catalogoActividadesDTO.setActividad(dto.getActividad());
				catalogoActividadesDTO.setAsignacionHoras(dto.getAsignacionHoras());
				catalogoActividadesDTO.setIdTipoActvEval(dto.getIdTipoActvEval());
				catalogoActividadesDTO.setIdReglamentoEvaluacion(dto.getIdReglamentoEvaluacion());
				catalogoActividadesDTO.setValor(0.0);
				catalogoActividadesDTO.setCumplimiento(100.00);
				catalogoActividadesDTO.setAsignar(false);
				listCatalogo.add(catalogoActividadesDTO);
			}
		}

		return listCatalogo;
	}

	@Override
	public List<CatalogoActividadesDTO> listReglamentoActvXTipo(Integer tipoActvEval) throws Exception {
		List<CatalogoActividadesDTO> listCatalogo = new ArrayList<CatalogoActividadesDTO>();
		List<ReglamentoEvaluacion> listReglamento = new ArrayList<ReglamentoEvaluacion>();
		Query q = getEntityManager().createQuery(
				"SELECT r FROM ReglamentoEvaluacion r WHERE r.idTipoActvEval= ?  ORDER BY idReglamentoEvaluacion");

		q.setParameter(1, tipoActvEval);
		
		listReglamento = q.getResultList();

		if (!listReglamento.isEmpty()) {
			for (ReglamentoEvaluacion dto : listReglamento) {
				CatalogoActividadesDTO catalogoActividadesDTO = new CatalogoActividadesDTO();
				catalogoActividadesDTO.setActividad(dto.getActividad());
				catalogoActividadesDTO.setAsignacionHoras(dto.getAsignacionHoras());
				catalogoActividadesDTO.setIdTipoActvEval(dto.getIdTipoActvEval());
				catalogoActividadesDTO.setIdReglamentoEvaluacion(dto.getIdReglamentoEvaluacion());
				catalogoActividadesDTO.setValor(0.0);
				catalogoActividadesDTO.setCumplimiento(100.00);
				catalogoActividadesDTO.setAsignar(false);
				listCatalogo.add(catalogoActividadesDTO);
			}
		}

		return listCatalogo;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<CatalogoActividadesDTO> listReglamentoAll() throws Exception {
		List<CatalogoActividadesDTO> listCatalogo = new ArrayList<CatalogoActividadesDTO>();
		List<ReglamentoEvaluacion> listReglamento = new ArrayList<ReglamentoEvaluacion>();
		Query q = getEntityManager()
				.createQuery("SELECT r FROM ReglamentoEvaluacion r ORDER BY idReglamentoEvaluacion");

		listReglamento = q.getResultList();

		if (!listReglamento.isEmpty()) {
			for (ReglamentoEvaluacion dto : listReglamento) {
				CatalogoActividadesDTO catalogoActividadesDTO = new CatalogoActividadesDTO();
				catalogoActividadesDTO.setActividad(dto.getActividad());
				catalogoActividadesDTO.setAsignacionHoras(dto.getAsignacionHoras());
				catalogoActividadesDTO.setIdTipoActvEval(dto.getIdTipoActvEval());
				catalogoActividadesDTO.setIdReglamentoEvaluacion(dto.getIdReglamentoEvaluacion());
				catalogoActividadesDTO.setValor(0.0);
				catalogoActividadesDTO.setCumplimiento(100.00);
				catalogoActividadesDTO.setAsignar(false);
				listCatalogo.add(catalogoActividadesDTO);
			}
		}

		return listCatalogo;
	}

	@Override
	public List<ReglamentoEvalDTO> listCoevalReglamento(Integer idPensum, String nced, String apel, String nom,
			String codDep) throws Exception {
		List<ReglamentoEvalDTO> listReglam;

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();

			if (con != null) {
				
				
				String qry = "SELECT CONCAT(E.APEL, ' ', E.NOM) as nom, D.nom_dep, " 
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val6  FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 6 ), "
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val7 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 7 ), "
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val11 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 11 ), "
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val12 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 12 ), "
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val24 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 24 ), "						
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val26 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 26 ), "
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val27 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 27 ), "
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val28 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 28 ), "
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val29 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 29 ), "
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val30 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 30 ), "
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val31 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 31 ), "
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val32 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 32 ), "
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val33 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 33 ), "
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val34 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 34 ), "
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val35 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 35 ), "
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val36 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 36 ), "
						+ "(SELECT (CASE id_tipo_actv_eval WHEN 1 THEN (valor_coe * eval.semanas_doc_dentro) ELSE  valor_coe END) as val37 FROM \"GestionDocente\".actividad_ejecucion WHERE id_eval_acad= eval.id_eval_acad AND id_catalogo_actividad = 37 ) "
						+ "FROM \"GestionDocente\".evaluacion_academica eval,  \"Rrhh\".dep d, \"Rrhh\".emp e "  
						+ "WHERE e.nced= eval.nced "
						+ "AND d.cod_dep= e.cod_dep " 						 						
						+ "AND eval.id_pensum= ? "  
						+ "AND e.nced like ? "
						+ "AND e.apel like ? "
						+ "AND e.nom like ? "
						+ "AND d.cod_dep like ? ORDER BY e.nced ";

				ps = con.prepareStatement(qry);

				ps.setInt(1, idPensum);
				ps.setString(2, nced);
				ps.setString(3, apel);
				ps.setString(4, nom);
				ps.setString(5, codDep);

				ResultSet rs = ps.executeQuery();

				listReglam = new ArrayList<ReglamentoEvalDTO>();

				while (rs.next()) {
					ReglamentoEvalDTO dto = new ReglamentoEvalDTO();

					dto.setNombre(rs.getString(1));
					dto.setDepartamento(rs.getString(2));

					Double val =0.0;
					val = (double) Math.round(rs.getDouble(3) * 100);
					val = val / 100;
					BigDecimal bd = new BigDecimal(val);
					dto.setValActividad6(bd.setScale(2, RoundingMode.HALF_UP));
					
					val = (double) Math.round(rs.getDouble(4) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad7(bd.setScale(2, RoundingMode.HALF_UP));
					
					val = (double) Math.round(rs.getDouble(5) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad11(bd.setScale(2, RoundingMode.HALF_UP));
						
					
					val = (double) Math.round(rs.getDouble(6) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad12(bd.setScale(2, RoundingMode.HALF_UP));
					
					val = (double) Math.round(rs.getDouble(7) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad24(bd.setScale(2, RoundingMode.HALF_UP));
					
					
					val = (double) Math.round(rs.getDouble(8) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad26(bd.setScale(2, RoundingMode.HALF_UP));
						
					val = (double) Math.round(rs.getDouble(9) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad27(bd.setScale(2, RoundingMode.HALF_UP));
					
					
					val = (double) Math.round(rs.getDouble(10) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad28(bd.setScale(2, RoundingMode.HALF_UP));
					
					val = (double) Math.round(rs.getDouble(11) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad29(bd.setScale(2, RoundingMode.HALF_UP));
					
					
					val = (double) Math.round(rs.getDouble(12) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad30(bd.setScale(2, RoundingMode.HALF_UP));
					
					
					
					val = (double) Math.round(rs.getDouble(13) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad31(bd.setScale(2, RoundingMode.HALF_UP));
						
					
					val = (double) Math.round(rs.getDouble(14) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad32(bd.setScale(2, RoundingMode.HALF_UP));
					
					val = (double) Math.round(rs.getDouble(15) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad33(bd.setScale(2, RoundingMode.HALF_UP));
					
					val = (double) Math.round(rs.getDouble(16) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad34(bd.setScale(2, RoundingMode.HALF_UP));
					
					
					val = (double) Math.round(rs.getDouble(17) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad35(bd.setScale(2, RoundingMode.HALF_UP));
					
					val = (double) Math.round(rs.getDouble(18) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad36(bd.setScale(2, RoundingMode.HALF_UP));
					
					
					val = (double) Math.round(rs.getDouble(19) * 100);
					val = val / 100;
					bd = new BigDecimal(val);
					dto.setValActividad37(bd.setScale(2, RoundingMode.HALF_UP));
					

					listReglam.add(dto);
				}

				return listReglam;

			} else {
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
	public ReglamentoEvalDTO reglamentoReporte() throws Exception {
		
		
		try {
			ReglamentoEvalDTO listReglam= new ReglamentoEvalDTO();
			List<CatalogoActividadesDTO> listCatalogo = new ArrayList<CatalogoActividadesDTO>();
			listCatalogo = this.listReglamentoAll();
			
				for (CatalogoActividadesDTO val : listCatalogo) {
					switch (val.getIdReglamentoEvaluacion()) {
					case 6:
						listReglam.setActividad6(val.getActividad());
						break;
					case 7:
						listReglam.setActividad7(val.getActividad());
						break;
					case 11:
						listReglam.setActividad11(val.getActividad());
						break;
					case 12:
						listReglam.setActividad12(val.getActividad());
						break;
					case 24:
						listReglam.setActividad24(val.getActividad());
						break;
					case 26:
						listReglam.setActividad26(val.getActividad());
						break;
					case 27:
						listReglam.setActividad27(val.getActividad());
						break;
					case 28:
						listReglam.setActividad28(val.getActividad());
						break;
					case 29:
						listReglam.setActividad29(val.getActividad());
						break;
					case 30:
						listReglam.setActividad30(val.getActividad());
						break;
					case 31:
						listReglam.setActividad31(val.getActividad());
						break;
					case 32:
						listReglam.setActividad32(val.getActividad());
						break;
					case 33:
						listReglam.setActividad33(val.getActividad());
						break;
					case 34:
						listReglam.setActividad34(val.getActividad());
						break;
					case 35:
						listReglam.setActividad35(val.getActividad());
						break;
					case 36:
						listReglam.setActividad36(val.getActividad());
						break;
					case 37:
						listReglam.setActividad37(val.getActividad());
						break;
					default:
						break;
					}
				}

			return listReglam;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;		
		}
		
	}
}
