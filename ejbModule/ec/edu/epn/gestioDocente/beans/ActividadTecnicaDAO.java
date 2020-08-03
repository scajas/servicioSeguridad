package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.ActividadTecnica;

@Local
public interface ActividadTecnicaDAO  extends DaoGenerico<ActividadTecnica>{

	List<ActividadTecnica> buscarActividadTecnicaBYParams(String cedula, String cargo, String idperiodo)
			throws Exception;

	int countActvTecnicaXCedNombre(String cedula, String nombreAdm, String idPeriodo, ActividadTecnica actividadTecnica)
			throws Exception;

	List<ActividadTecnica> buscarActividadTecnicaBYParamsTipo(String cedula, String tipo, String idperiodo)
			throws Exception;
	

}
