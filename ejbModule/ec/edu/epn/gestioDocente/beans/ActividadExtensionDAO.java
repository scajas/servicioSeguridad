package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.ActividadExtension;

@Local
public interface ActividadExtensionDAO extends DaoGenerico<ActividadExtension> {

	List<ActividadExtension> buscarActividadExtensionBYParams(String cedula, String cargo, String idperiodo)
			throws Exception;

	int countActvExtensionXCedNombre(String cedula, String nombreActv, String idPeriodo,
			ActividadExtension actividadExtension) throws Exception;

	List<ActividadExtension> buscarActividadExtensionBYTipo(String cedula, String cargo, String idperiodo,
			String tipo) throws Exception;

}
