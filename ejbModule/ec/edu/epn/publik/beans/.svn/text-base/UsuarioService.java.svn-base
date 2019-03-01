package ec.edu.epn.publik.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.seguridad.vo.Usuario;




@Local
public interface UsuarioService extends DaoGenerico<Usuario>{
	
	Usuario consultaXidUsuario(Long idUsuario);
	
	public String getCedulaUsuario(Long idUsuario);

	Usuario usuarioPorCedula(String cedula);

}
