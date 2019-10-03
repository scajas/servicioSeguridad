package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.SubactividadPreplanificacion;

@Local
public interface SubactividadPreplanificacionDAO extends DaoGenerico<SubactividadPreplanificacion>{

	List<SubactividadPreplanificacion> listSubActvXIdActvPreplanif(Integer idActividad) throws Exception;	
}
