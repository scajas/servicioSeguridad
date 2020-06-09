/**
 * 
 */
package ec.edu.epn.publik.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.publik.entities.PerfilUsuario;
import ec.edu.epn.rrhh.DTO.PerfilDTO;
import ec.edu.epn.seguridad.servicio.ServicioSeguridad;
import ec.edu.epn.seguridad.vo.Perfil;

/**
 * @author Administrador
 * 
 */
@Stateless
public class PerfilDAOImplement extends DaoGenericoImplement<Perfil> implements PerfilDAO {
	
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/ServicioSeguridadBean!ec.edu.epn.seguridad.servicio.ServicioSeguridad")
	private ServicioSeguridad seguridadDAO;

	@Override
	public Perfil buscarPerfilPorNombre(String nombre) {
		Query q = getEntityManager().createQuery("Select p from Perfil as p where p.nombre=?1");
		q.setParameter(1, nombre);
		return (Perfil) q.getSingleResult();
	}

	@Override
	public Perfil buscarbyID(Long id) {
		Query q = getEntityManager().createQuery("Select p from Perfil as p where p.id=?1");
		q.setParameter(1, id);
		return (Perfil) q.getSingleResult();
	}

	@Override
	public List<PerfilUsuario> buscarbyIDALL(Integer id) {
		Query q = getEntityManager().createQuery("Select p from PerfilUsuario as p where p.id.idPerfil=?1");
		q.setParameter(1, id);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> listPerfilXEstado() {
		Query q = getEntityManager().createQuery("Select p from Perfil as p where p.activo='SI'");
		
		return q.getResultList();
	}
	

	
	
	@Override
	public List<PerfilDTO> listPerfilesUsuario (Long idUsuario, String nombreUsuario){
		try {
			List<PerfilDTO> listDTO = new ArrayList<PerfilDTO>();
 			List<Perfil> listPerfiles= new ArrayList<Perfil>();
 			List<Perfil> listPerfilUsuario= new ArrayList<Perfil>();
 			
 			listPerfiles= this.listPerfilXEstado(); 			
 			listPerfilUsuario= seguridadDAO.obtenerPerfilesUsuario(nombreUsuario);
 			/*SE LLAMA A LOS PERFILES DEL USUARIO*/
 			
 			
 			if(!listPerfilUsuario.isEmpty()){
 				if(!listPerfiles.isEmpty()){
 					for(Perfil perfil: listPerfiles){
 						PerfilDTO dto= new PerfilDTO();
 						for(Perfil perfilUsuario: listPerfilUsuario){
 							if(perfil.getId()== perfilUsuario.getId()){
 								dto.setIdPerfil(perfil.getId());
 								dto.setIdUsuario(idUsuario);
 								dto.setSeleccion(true);
 								dto.setPerfil(perfil.getNombre());
 								listDTO.add(dto);
 								break;
 							}
 						}
 						if(!dto.isSeleccion()){
 							dto.setIdPerfil(perfil.getId());
							dto.setIdUsuario(idUsuario);
							dto.setSeleccion(false);
							dto.setPerfil(perfil.getNombre());
							listDTO.add(dto);							
 						}
 					}
 				}
 			}else{
 				if(!listPerfiles.isEmpty()){
 					for(Perfil perfil: listPerfiles){
 						PerfilDTO dto= new PerfilDTO();
 						dto.setIdPerfil(perfil.getId());
						dto.setIdUsuario(idUsuario);
						dto.setSeleccion(false);
						dto.setPerfil(perfil.getNombre());
						listDTO.add(dto);
 					}
 				}
 			}
			return listDTO;
		} catch (Exception e) {
			return null;
		}
	}

}
