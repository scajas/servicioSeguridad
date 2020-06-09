package ec.edu.epn.publik.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.sql.DataSource;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.RecursohPr;
import ec.edu.epn.rrhh.DTO.UsuarioDTO;
import ec.edu.epn.seguridad.vo.Usuario;

@Stateless
public class UsuarioServiceBean extends DaoGenericoImplement<Usuario> implements UsuarioService {	
	

	@Resource(mappedName = "java:jboss/datasources/SeguridadEPNDS")
	private DataSource dataSource;
	
	
	@Override
	public Usuario consultaXidUsuario(Long idUsuario) {
		Query q = super.getEntityManager().createQuery("Select user from Usuario user where user.id = ?1");
		q.setParameter(1, idUsuario);
		return (Usuario) q.getSingleResult();
	}
	
	@Override
	public String getCedulaUsuario(Long idUsuario) {
		Query q = super.getEntityManager().createQuery("Select user.cedula from Usuario user where user.id = ?1");
		q.setParameter(1, idUsuario);
		return (String) q.getSingleResult();
	}
	
	
	@Override
	public Usuario usuarioPorCedula(String cedula) {
		Query q = super.getEntityManager().createQuery("Select user from Usuario user where user.cedula = ?1");
		q.setParameter(1, cedula);
		
		try {
			Usuario r = (Usuario) q.getSingleResult();
			return r;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}
		
	}
	
	@Override
	public Long maxIdUser() {
		Query q = super.getEntityManager().createQuery("Select Max(user.id) from Usuario user");		
		return (Long) q.getSingleResult();
	}
	
	@Override
	public Long countUsuarioNombre(String nombreUsuario) {
		Query q = getEntityManager().createQuery("Select count(user) from Usuario user where user.nombreUsuario = ?1");
		q.setParameter(1, nombreUsuario);
		return (Long) q.getSingleResult();
	}
	
	
	
	

	

	
	@Override
	public List<UsuarioDTO> listUsuarioXEstado(Integer idUsuario) throws SQLException{
	Connection con = null;
	PreparedStatement ps = null;
	try {
		con = dataSource.getConnection();
		if (con != null) {				
			
			String qry = "SELECT e.nced AS ced1 , u.cedula AS ced2, CONCAT(e.apel, ' ' , e.nom) AS nom1, u.nombres AS nom2, "+
					 "u.nombre_usuario AS usuario, d.nom_dep AS dep, id_usuario AS id "+
					"FROM public.usuario u LEFT OUTER JOIN \"Rrhh\".emp e ON u.cedula= e.nced "+
					"LEFT OUTER JOIN \"Rrhh\".dep d ON d.cod_dep= e.cod_dep "+
					"WHERE (u.id_usuario= ? OR 0=?) ";

			ps = con.prepareStatement(qry);
			ps.setInt(1, idUsuario);
			ps.setInt(2, idUsuario);
			ResultSet rs = ps.executeQuery();

			ArrayList<UsuarioDTO> listaUsuarios = new ArrayList<UsuarioDTO>();

			while (rs.next()) {

				UsuarioDTO dto = new UsuarioDTO();
				dto.setNumCedula(rs.getString(1)==null?rs.getString(2):(rs.getString(1).equals("")?rs.getString(2):rs.getString(1)));
				dto.setNombreEmpleado(rs.getString(3)==null?rs.getString(4):(rs.getString(3).equals("")?rs.getString(4):rs.getString(3)));	
				dto.setUsuario(rs.getString(5)==null?"NO EXISTE" :rs.getString(5));
				dto.setDepartamento(rs.getString(6)==null?"" :rs.getString(6));
				dto.setIdUsuario(rs.getInt(7));
				listaUsuarios.add(dto);
			}

			ps.close();
			con.close();

			return listaUsuarios;
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
	public List<UsuarioDTO> listEmpSNUsuario(String nombre, String apellido, String nced) throws SQLException{
	Connection con = null;
	PreparedStatement ps = null;
	try {
		con = dataSource.getConnection();
		if (con != null) {				
			
			String qry = "SELECT e.nced AS ced1 , CONCAT(e.apel, ' ' , e.nom) AS nom1,  "+
					 "e.email1 as email "+
					"FROM \"Rrhh\".emp e WHERE e.nced NOT IN (SELECT u.cedula FROM public.usuario u) "+					
					"AND apel like ? AND nom like ? AND nced like ? ";

			ps = con.prepareStatement(qry);
			ps.setString(1, "%" + apellido + "%");
			ps.setString(2, "%" + nombre + "%");
			ps.setString(3, "%" + nced + "%");
			ResultSet rs = ps.executeQuery();

			ArrayList<UsuarioDTO> listaUsuarios = new ArrayList<UsuarioDTO>();

			while (rs.next()) {

				UsuarioDTO dto = new UsuarioDTO();
				dto.setNumCedula(rs.getString(1)==null?"":rs.getString(1));
				dto.setNombreEmpleado(rs.getString(2)==null?"":rs.getString(2));	
				dto.setCorreo(rs.getString(3)==null?"":rs.getString(3));
				listaUsuarios.add(dto);
			}

			ps.close();
			con.close();

			return listaUsuarios;
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

}
