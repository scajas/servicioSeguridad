package ec.edu.epn.publik.beans;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.DTO.UsuarioDTO;
import ec.edu.epn.seguridad.vo.Usuario;




@Local
public interface UsuarioService extends DaoGenerico<Usuario>{
	
	Usuario consultaXidUsuario(Long idUsuario);
	
	public String getCedulaUsuario(Long idUsuario);

	Usuario usuarioPorCedula(String cedula);

	List<UsuarioDTO> listUsuarioXEstado(Integer idUsuario) throws SQLException;

	Long countUsuarioNombre(String nombreUsuario);

	Long maxIdUser();

	List<UsuarioDTO> listEmpSNUsuario(String nombre, String apellido, String nced) throws SQLException;

}
