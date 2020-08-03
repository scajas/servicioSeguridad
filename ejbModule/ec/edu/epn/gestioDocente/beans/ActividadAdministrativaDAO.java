package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.ActividadAdministrativa;

@Local
public interface ActividadAdministrativaDAO  extends DaoGenerico<ActividadAdministrativa>{

	List<ActividadAdministrativa> buscarActividadAdministrativaBYParams(String cedula, String cargo, String idperiodo, String tipo) throws Exception;

	int countActAdministrativaXCedCargo(String cedula, String cargo, String idPeriodo,
			ActividadAdministrativa actividadAdministrativa) throws Exception;

}
