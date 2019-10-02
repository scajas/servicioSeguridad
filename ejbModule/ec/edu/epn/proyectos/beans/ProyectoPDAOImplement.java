/**
 * 
 */
package ec.edu.epn.proyectos.beans;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.DTO.ProyectoDTO;
import ec.edu.epn.proyectos.entities.Convocatoria;
import ec.edu.epn.proyectos.entities.ProyectoP;

/**
 * @author Administrador
 * 
 */
@Stateless
public class ProyectoPDAOImplement extends
		DaoGenericoImplement<ProyectoP> implements ProyectoPDAO {

	
	@Override
	public Long countProyectosXNced(String nced) {
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(p) FROM ProyectoP p, RecursohPr r WHERE r.proyecto.idProy= p.idProy AND UPPER(p.estado) not like '%CERRADO%' AND r.nced=? ");
		q.setParameter(1, nced);		
		return (Long) q.getSingleResult();
	}
	
	
	@Override
	public List<ProyectoP> findproyectosReporte(Integer idtipo, String area,
			String codigo, Integer idlinea, String coddep, String cedula,
			String estado, Integer anio) {

		StringBuilder queryString = new StringBuilder(
				"select DISTINCT(pr) from ProyectoP pr, RecursohPr rp, Lineasproy lp, LineasInvestigacion li where   pr.idProy = rp.proyecto.idProy and pr.idProy = lp.proyecto.idProy and lp.lineas.idLinin = li.idLinin and   pr.nombrePr like ?1 ");

		if (idtipo != 0) {
			queryString.append(" and pr.tipoProyecto.idTipoProy  = ?2 ");
		}

		if (area != null) {
			queryString.append(" and pr.area = ?3 ");
		}

		if (codigo != null) {
			queryString.append(" and pr.codigoPr = ?4 ");
		}

		if (idlinea != 0) {
			queryString.append(" and lp.lineas.idLinin  = ?5 ");
		}

		if (coddep != null) {
			queryString.append(" and pr.coddep = ?6 ");
		}
		if (cedula != null) {
			queryString.append(" and rp.nced = ?7 ");
		}

		if (estado != null) {
			queryString.append(" and pr.estado = ?8 ");
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

		return qUsuario.getResultList();

	}
	
	
	@Override
	public List<ProyectoP> findproyectos(String coddep, String nombre, String cedula) {

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
		
		
		if (cedula != null) {
			queryString.append(" and rp.rolProyecto.idRolProy = 1   ");
		}
		
		
		queryString.append(" order by pr.codigoPr ");

		Query qUsuario = getEntityManager().createQuery(queryString.toString());

		qUsuario.setParameter(0, "%");
		
		if (coddep != null) {
			qUsuario.setParameter(1, coddep);
		}
		
		if (nombre != null) {
			qUsuario.setParameter(2,"%"+ nombre+"%");
		}
		
		if (cedula != null) {
			qUsuario.setParameter(3, cedula);
		}

		return qUsuario.getResultList();

	}
	

	@Override
	public List<ProyectoP> buscarProyectoExiste(String codigo) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select tp from ProyectoP tp WHERE tp.codigoPr = ?1");
		qUsuario.setParameter(1, codigo);
		return qUsuario.getResultList();

	}
	
	@Override
	public Convocatoria finconv(String idconv) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select conv from Convocatoria conv where conv.idConv = ?1");
		qUsuario.setParameter(1, idconv);
		return (Convocatoria) qUsuario.getSingleResult();

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
	public ProyectoP buscarProyecto(Integer idProy) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select tp from ProyectoP tp WHERE tp.idProy = ?1");
		qUsuario.setParameter(1, idProy);
		return (ProyectoP) qUsuario.getSingleResult();

	}
	
	
	@Override
	public List<ProyectoDTO> listProyectoPlanificacion(String cedula, Integer idPensum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
				

		try {
			con = getDataSource().getConnection();
			if (con != null) {
				ps = con.prepareStatement(
						"SELECT p.id_proy, p.codigo_pr, p.nombre_pr, rp.rol_proy, re.valor, p.fechaini, (p.fechaf -p.fechaini) AS estimado, r.idpensum "+
						"FROM \"Proyectos\".proyecto p, \"Proyectos\".recursoh_pr r, \"Proyectos\".rol_proyecto rp, \"Proyectos\".recursoavance re "+
						"WHERE p.id_proy= r.id_proy "+
						"AND re.id_recurso= r.id_rh_pr "+
						"AND re.tipo = 'P' "+						
						"AND r.id_rol_proy=rp.id_rol_proy "+
						"AND p.estado IN ('En ejecución', 'Prórroga Ordinaria', 'Prórroga Extraordinaria') "+
						"AND r.nced=? "+
						"AND re.idpensum= ? ") ;
		
				ps.setString(1, cedula);
				ps.setInt(2, idPensum);
				

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

	
	
	@Override
	public String findDirectorXProyecto(Integer idProyecto) {
		
		StringBuilder queryString = new StringBuilder(
				"SELECT MAX(rp.nced) FROM ProyectoP pr ,RecursohPr rp WHERE rp.proyecto.idProy = pr.idProy AND rp.rolProyecto.idRolProy = 1 AND pr.idProy=?0 ");

		
		Query qUsuario = getEntityManager().createQuery(queryString.toString());
		qUsuario.setParameter(0, idProyecto);
		return (String) qUsuario.getSingleResult();
	}

	
	@Override
	public List<ProyectoP> findproyectosActivos(String coddep, String nombre, String cedula) {




		StringBuilder queryString = new StringBuilder(
				"select pr from ProyectoP pr ");

		if (cedula != null) {
			queryString.append(" ,RecursohPr rp   ");
		}
		
		queryString.append(" where pr.estado IN ('En ejecución', 'Prórroga Ordinaria', 'Prórroga Extraordinaria','Proceso de cierre','Suspendido') and pr.tipoProyecto.idTipoProy != 4 ");
		
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
		
		
		if (cedula != null) {
			queryString.append(" and rp.rolProyecto.idRolProy = 1   ");
		}
		
		
		queryString.append(" order by pr.codigoPr ");

		Query qUsuario = getEntityManager().createQuery(queryString.toString());

		
		
		if (coddep != null) {
			qUsuario.setParameter(1, coddep);
		}
		
		if (nombre != null) {
			qUsuario.setParameter(2,"%"+ nombre+"%");
		}
		
		if (cedula != null) {
			qUsuario.setParameter(3, cedula);
		}

		return qUsuario.getResultList();

	}

	

	
}
