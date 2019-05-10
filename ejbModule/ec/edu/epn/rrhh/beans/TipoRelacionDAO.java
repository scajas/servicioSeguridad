package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.SubtipoAccion;
import ec.edu.epn.rrhh.movimientos.TipoAccion;
import ec.edu.epn.rrhh.movimientos.TipoRelacion;

@Remote
public interface TipoRelacionDAO extends DaoGenerico<TipoRelacion> {
	//Nuevo m�todo
	public List<TipoRelacion> findTipoRelacionActivo();
	
	public List<TipoRelacion> findTipoRelacionConvenioActivo();
	
	public List<TipoRelacion> findAllTipoRelacionActivos();

	public List<TipoRelacion> findAllTipoRelacionActivosMigrado();

}
