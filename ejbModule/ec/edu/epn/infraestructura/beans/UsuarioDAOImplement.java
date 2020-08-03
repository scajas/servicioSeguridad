/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.DTO.UsuarioDTO;
import ec.edu.epn.seguridad.vo.Usuario;

/**
 * @author Administrador
 * 
 */
@Stateless
public class UsuarioDAOImplement extends DaoGenericoImplement<Usuario> implements UsuarioDAO {

	@Override
	public Usuario consultaXidUsuario(long idUsuario) {
		Query q = getEntityManager().createQuery("Select user from Usuario user where user.id = ?1");
		q.setParameter(1, idUsuario);
		return (Usuario) q.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioDTO> listUsuarioXEstado (Integer activo){
		List<UsuarioDTO> listUsrDTO = new ArrayList<UsuarioDTO>();
		List<Usuario> listUsr= new ArrayList<Usuario>();
		
		try {
			Query q = getEntityManager().createQuery("Select user from Usuario user where user.activo like ?1");
			q.setParameter(1, activo==0?"SI":"NO");
			
			listUsr= q.getResultList();
			if(!listUsr.isEmpty()){
				for(Usuario dto: listUsr){
					UsuarioDTO usuarioDTO= new UsuarioDTO();
					usuarioDTO.setNumCedula(dto.getCedula());
					usuarioDTO.setActivo(dto.getActivo());
					usuarioDTO.setCorreo(dto.getNombreUsuario());
					usuarioDTO.setIdUsuario(Integer.valueOf(String.valueOf(dto.getId())));
					usuarioDTO.setNombreEmpleado(dto.getNombreapellido());
				}
			}
			
			
			
			return listUsrDTO;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	@Override
	public Usuario consultaXCedula(String nced) {
		Query q = getEntityManager().createQuery("Select user from Usuario user where user.cedula = :nced");
		q.setParameter("nced", nced);
		return (Usuario) q.getSingleResult();
	}
}
