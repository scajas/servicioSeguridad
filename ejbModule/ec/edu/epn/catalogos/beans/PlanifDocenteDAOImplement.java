/**
 * 
 */
package ec.edu.epn.catalogos.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.sql.DataSource;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.DTO.PlanifDocenteDTO;
import ec.edu.epn.gestionDocente.entities.PlanifDocente;
import ec.edu.epn.proyectos.DTO.ProyectoDTO;

/**
 * @author Administrador
 * 
 */
@Stateless
public class PlanifDocenteDAOImplement extends DaoGenericoImplement<PlanifDocente> implements PlanifDocenteDAO {

	@Resource(mappedName = "java:jboss/datasources/SeguridadEPNDS")
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(act.idPd) FROM PlanifDocente act");
		Integer idReq = null;
		try {
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

	public List<ProyectoDTO> listProyectoDTO(String cedula) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getDataSource().getConnection();
			if (con != null) {
				ps = con.prepareStatement(
						"SELECT id_proy, codigo_pr, nombre_pr, estado FROM \"Proyectos\".proyecto WHERE nced= ?");

				ps.setString(1, cedula);

				ResultSet rs = ps.executeQuery();
				List<ProyectoDTO> listProyectoDtos = new ArrayList<ProyectoDTO>();

				while (rs.next()) {
					ProyectoDTO dto = new ProyectoDTO();
					dto.setIdProyecto(rs.getInt(1));
					dto.setCodidoProy(rs.getString(2));
					dto.setNombreProyecto(rs.getString(3));
					dto.setEstado(rs.getString(4));

					listProyectoDtos.add(dto);
				}
				return listProyectoDtos;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
			ps.close();
		}

	}
	
	@Override
	public List<ProyectoDTO> listProyectoXNcedDocenteDTO(String cedula) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getDataSource().getConnection();
			if (con != null) {
				ps = con.prepareStatement(
						"SELECT p.id_proy, p.codigo_pr, p.nombre_pr, rp.rol_proy, r.nro_horas, p.fechaini, (p.fechaf -p.fechaini) AS estimado, r.idpensum "+
						"FROM \"Proyectos\".proyecto p, \"Proyectos\".recursoh_pr r, \"Proyectos\".rol_proyecto rp "+
						"WHERE p.id_proy= r.id_proy "+
						"AND r.id_rol_proy=rp.id_rol_proy "+
						"AND r.nced=?");

				ps.setString(1, cedula);

				ResultSet rs = ps.executeQuery();
				List<ProyectoDTO> listProyectoDtos = new ArrayList<ProyectoDTO>();

				while (rs.next()) {
					ProyectoDTO dto = new ProyectoDTO();
					dto.setIdProyecto(rs.getInt(1));
					dto.setCodidoProy(rs.getString(2)==null?"":rs.getString(2));
					dto.setNombreProyecto(rs.getString(3)==null?"":rs.getString(3));
					dto.setRol(rs.getString(4)==null?"":rs.getString(4));
					dto.setHoras(rs.getString(5)==null?"":rs.getString(5));
					dto.setFechaInicio(rs.getString(6)==null?"":rs.getString(6));
					dto.setTiempoEstimado(rs.getString(7)==null?"":rs.getString(7));
					dto.setIdPensum((rs.getString(8)==null || rs.getString(8).equals(""))?0: rs.getInt(8));

					listProyectoDtos.add(dto);
				}
				return listProyectoDtos;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
			ps.close();
		}

	}
	
	  

	public List<PlanifDocenteDTO> listPlanificacionDocenteDTO(String cedula, String tipoActividad, String idPeriodo)
			throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getDataSource().getConnection();
			if (con != null) {
				ps = con.prepareStatement(
						"SELECT  AC.id_actividad, PD.id_pd, AC.detalle, PD.horas_cclase, PD.horas_sclase, PD.total, PD.descripcion "
								+ "FROM \"GestionDocente\".planif_docente PD INNER JOIN \"Catalogos\".actividades_academicas AC ON PD.id_actividad=AC.id_actividad "
								+ "WHERE PD.nced LIKE ? " + "AND AC.tipo LIKE ?"
								+ "AND PD.id_pensum LIKE ? ORDER BY AC.id_actividad ");

				ps.setString(1, cedula);
				ps.setString(2, tipoActividad);
				ps.setString(3, idPeriodo);

				ResultSet rs = ps.executeQuery();
				List<PlanifDocenteDTO> listplanificacionDTO = new ArrayList<PlanifDocenteDTO>();

				while (rs.next()) {
					PlanifDocenteDTO dto = new PlanifDocenteDTO();
					dto.setIdActividad(rs.getString(1));
					dto.setIdPlanificacion(rs.getInt(2));
					dto.setDetalleActividad(rs.getString(3));
					dto.setHorasPeriodo(rs.getInt(4));
					dto.setHorasFinPeriodo(rs.getInt(5));
					dto.setHorasSubTotal(rs.getInt(6));
					dto.setDescripcion(rs.getString(7));

					listplanificacionDTO.add(dto);
				}
				return listplanificacionDTO;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
			ps.close();
		}

	}

	public List<PlanifDocenteDTO> listPlanificacionDocenteEjecucionDTO(String cedula, String tipoActividad,
			String idPeriodo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getDataSource().getConnection();
			if (con != null) {
				ps = con.prepareStatement(
						"SELECT  AC.id_actividad, PD.id_pd, AC.detalle, PD.horas_cclase, PD.horas_sclase, PD.total, PD.descripcion, "
								+ "PD.horas_cclase_ejec, PD.horas_sclase_ejec, PD.total_ejec "
								+ "FROM \"GestionDocente\".planif_docente PD INNER JOIN \"Catalogos\".actividades_academicas AC ON PD.id_actividad=AC.id_actividad "
								+ "WHERE PD.nced LIKE ? " + "AND AC.tipo LIKE ?"
								+ "AND PD.id_pensum LIKE ? ORDER BY AC.id_actividad ");

				ps.setString(1, cedula);
				ps.setString(2, tipoActividad);
				ps.setString(3, idPeriodo);

				ResultSet rs = ps.executeQuery();
				List<PlanifDocenteDTO> listplanificacionDTO = new ArrayList<PlanifDocenteDTO>();

				while (rs.next()) {
					PlanifDocenteDTO dto = new PlanifDocenteDTO();
					dto.setIdActividad(rs.getString(1));
					dto.setIdPlanificacion(rs.getInt(2));
					dto.setDetalleActividad(rs.getString(3));
					dto.setHorasPeriodo(rs.getInt(4));
					dto.setHorasFinPeriodo(rs.getInt(5));
					dto.setHorasSubTotal(rs.getInt(6));
					dto.setDescripcion(rs.getString(7));
					dto.setHorasPeriodoEjec(rs.getInt(8));
					dto.setHorasFinPeriodoEjec(rs.getInt(9));
					dto.setHorasSubTotalEjec(rs.getInt(10));

					if (dto.getHorasSubTotalEjec() > 0) {
						dto.setDisabledEvidencia(false);
					} else {
						dto.setDisabledEvidencia(true);
					}

					listplanificacionDTO.add(dto);
				}
				return listplanificacionDTO;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
			ps.close();
		}

	}

	@Override
	public String estadoPlanificacion(String cedula, String idPeriodo) {
		Connection con = null;
		PreparedStatement ps = null;
		String estado = null;		
		try {
			
			con = getDataSource().getConnection();
			if (con != null) {
				ps = con.prepareStatement(
						"SELECT  MAX(PD.estado) "
								+ "FROM \"GestionDocente\".planif_docente PD "
								+ "WHERE PD.nced LIKE ? " + "AND PD.id_pensum LIKE ?");

				ps.setString(1, cedula);				
				ps.setString(2, idPeriodo);

				ResultSet rs = ps.executeQuery();				

				while (rs.next()) {
					estado= "";
					estado= rs.getString(1);					
				}

				if (estado == null) {
					estado = "ING";
				}
			}				

		} catch (Exception e) {
			e.printStackTrace();			
		}
		return estado;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanifDocente> verificarPlanifEjecucion(String cedula, String periodo) {
		Query consulta = getEntityManager().createQuery(
				"SELECT pd FROM PlanifDocente pd WHERE pd.nced = ? AND pd.periodo.idPeriodo = ? AND pd.estado IN ('REV', 'EJEC', 'REVEJ') ORDER BY pd.actividadAcademica.ordenActividad asc");
		consulta.setParameter(1, cedula);
		consulta.setParameter(2, periodo);
		return consulta.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanifDocente> verificarPlanifEjecucionXcedula(String cedula) {
		try {
			Query consulta = getEntityManager().createQuery(
					"SELECT pd FROM PlanifDocente pd WHERE pd.nced = ? AND PD.estado IN ('REV', 'EJEC', 'REVEJ') ORDER BY pd.periodo.idPeriodo asc");
			consulta.setParameter(1, cedula);
			return consulta.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void actualizarPlanificacion(PlanifDocenteDTO planifDocenteDTO) throws Exception {

		try {
			PlanifDocente planifDocente = new PlanifDocente();
			planifDocente = (PlanifDocente) this.getById(PlanifDocente.class, planifDocenteDTO.getIdPlanificacion());

			if (planifDocente != null) {
				planifDocente.setHorasCclaseEjec(planifDocenteDTO.getHorasPeriodoEjec());
				planifDocente.setHorasSclaseEjec(planifDocenteDTO.getHorasFinPeriodoEjec());
				planifDocente.setTotalEjec(planifDocenteDTO.getHorasSubTotalEjec());

				this.update(planifDocente);
			}
		} catch (Exception e) {
			throw new PersistenceException("Errora al guardar la PLanificación");
		}

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PlanifDocente> verificarEvaluacionRegistrada(String cedula,
			String periodo) {
		Query consulta = getEntityManager()
				.createQuery(
						"select pd from PlanifDocente pd where pd.nced = ? and pd.periodo.idPeriodo = ? order by pd.actividadAcademica.ordenActividad asc");
		consulta.setParameter(1, cedula);
		consulta.setParameter(2, periodo);
		return consulta.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanifDocente> verificarEvaluacionRegistradaXcedula(
			String cedula) {
		try {
			Query consulta = getEntityManager()
					.createQuery(
							"select pd from PlanifDocente pd where pd.nced = ? order by pd.periodo.idPeriodo asc");
			consulta.setParameter(1, cedula);
			System.out.println("TAMAÑO CONSULTA:"
					+ consulta.getResultList().size());
			return consulta.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	

}
