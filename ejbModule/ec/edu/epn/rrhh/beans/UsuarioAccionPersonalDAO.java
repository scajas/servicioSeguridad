package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.Usuarioaccion;


@Remote
public interface UsuarioAccionPersonalDAO extends DaoGenerico<Usuarioaccion> {
	
	public List<Usuarioaccion> getPermisosAccionesByIdUsuario(Long idUsuario);

}
