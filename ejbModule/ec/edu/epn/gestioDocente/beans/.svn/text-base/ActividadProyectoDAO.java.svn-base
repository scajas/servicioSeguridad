package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.ActividadProyecto;

@Local
public interface ActividadProyectoDAO extends DaoGenerico<ActividadProyecto>{

	List<ActividadProyecto> findActividadProyecto(String nced, String validarecategoriza, String validarevaloriza,
			String cierre,String nombrepr, String idperiodo, String rol);

	
	int countActProyInvXCed(String cedula, String nombreProyecto, String rol, String idPeriodo,
			ActividadProyecto actividadProyecto) throws Exception;  

}
