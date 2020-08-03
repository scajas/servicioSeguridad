package ec.edu.epn.rrhh.beans;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.UsuarioRrhh;


@Remote
public interface UsuarioRRHHDAO extends DaoGenerico<UsuarioRrhh> {

	public UsuarioRrhh getUsuarioById(String idUsuario);
	

}
