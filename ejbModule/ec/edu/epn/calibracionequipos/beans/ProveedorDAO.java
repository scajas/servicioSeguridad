package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Proveedor;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface ProveedorDAO extends DaoGenerico<Proveedor> {
	int consultarId();

}
