package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.DTO.UsuarioDTO;
import ec.edu.epn.seguridad.vo.Usuario;

@Local
public interface UsuarioDAO extends DaoGenerico<Usuario> {

	Usuario consultaXidUsuario(long idUsuario);

	List<UsuarioDTO> listUsuarioXEstado(Integer activo);

	Usuario consultaXCedula(String nced);
}
