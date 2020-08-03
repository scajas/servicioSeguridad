package ec.edu.epn.proyectos.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.RolProyecto;
import ec.edu.epn.proyectos.entities.RolProyectoP;

@Local
public interface RolProyectoDAO extends DaoGenerico<RolProyectoP>{

	RolProyectoP finrolproy(Integer idRol) throws Exception;

}
