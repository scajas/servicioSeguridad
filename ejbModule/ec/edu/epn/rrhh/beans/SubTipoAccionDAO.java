package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.SubtipoAccion;

@Remote
public interface SubTipoAccionDAO extends DaoGenerico<SubtipoAccion> {
	
	public SubtipoAccion findSubTipoAccionPorNombre(String nombreSubTipoAccion);
	
	public int findIdSubTipoAccionPorNombre(String nombreSubTipoAccion);

	public List<SubtipoAccion> findSubTipoAccionPorAccion(String nombreAccion);
	
	public List<SubtipoAccion> getAllAccionesSinRegistro();
	
	public SubtipoAccion findSubtipoByID(Integer stpId);

	public List<SubtipoAccion> getAllSubtipoRectificaciones();
	
	public SubtipoAccion findSubTipoAccionPorNombreYTipo(String nombreSubTipoAccion, String tipoAccion);
	
	public List<SubtipoAccion> findAccionesAdministrablesPlantilla();
	
	
}
