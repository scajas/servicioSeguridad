package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Fondoadicional;

@Local
public interface FondoDAO extends DaoGenerico<Fondoadicional>{

	List<Fondoadicional> consultarFondosProyecto(Integer idproyecto);

}
