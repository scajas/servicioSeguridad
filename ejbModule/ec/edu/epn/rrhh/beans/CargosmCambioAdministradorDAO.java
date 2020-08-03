package ec.edu.epn.rrhh.beans;


import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.CargosmCambioAdministrador;


@Remote
public interface CargosmCambioAdministradorDAO extends DaoGenerico<CargosmCambioAdministrador>{
	
	public Integer getMaxID();



}
