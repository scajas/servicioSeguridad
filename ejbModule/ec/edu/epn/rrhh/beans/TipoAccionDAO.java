package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.SubtipoAccion;
import ec.edu.epn.rrhh.movimientos.TipoAccion;

@Remote
public interface TipoAccionDAO extends DaoGenerico<TipoAccion> {
	
	
	public SubtipoAccion findSubTipoAccionPorNombre(String nombreSubTipoAccion);
	
	public int findIdSubTipoAccionPorNombre(String nombreSubTipoAccion);

	public List<TipoAccion> findSubTipoAccionPorAccion(String nombreAccion);
	
	public List<TipoAccion> getAccionesFiltrables();
}
