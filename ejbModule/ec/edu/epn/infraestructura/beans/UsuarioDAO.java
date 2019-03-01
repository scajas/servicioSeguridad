package ec.edu.epn.infraestructura.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.seguridad.vo.Usuario;

@Local
public interface UsuarioDAO extends DaoGenerico<Usuario> {

	Usuario consultaXidUsuario(long idUsuario);
}
