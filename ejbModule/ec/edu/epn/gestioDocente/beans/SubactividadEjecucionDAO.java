package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
//import ec.edu.epn.gestionDocente.entities.SubactividadEjecucion;
import ec.edu.epn.gestionDocente.entities.SubactividadEjecucion;

@Local
public interface SubactividadEjecucionDAO extends DaoGenerico<SubactividadEjecucion>{

	List<SubactividadEjecucion> listSubActvEjecXIdActv(Integer idActividadEjecuion) throws Exception;

	Long countSubActEjecXIdActvEjec(Integer idActvEjecucion) throws Exception;
	
}
