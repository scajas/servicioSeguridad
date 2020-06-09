package ec.edu.epn.publik.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.publik.entities.PerfilUsuario;
import ec.edu.epn.rrhh.DTO.PerfilDTO;
import ec.edu.epn.seguridad.vo.Perfil;



@Local
public interface PerfilDAO extends DaoGenerico<Perfil> {

	Perfil buscarPerfilPorNombre(String nombre);

	Perfil buscarbyID(Long id);

	List<PerfilUsuario> buscarbyIDALL(Integer id);

	List<PerfilDTO> listPerfilesUsuario(Long idUsuario, String nombreUsuario);

	List<Perfil> listPerfilXEstado();
		

}
