package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Proyectocarrera;

@Local
public interface ProyectoCarreraDAO  extends DaoGenerico<Proyectocarrera>{

	List<Proyectocarrera> findCarreproy(Integer idproy);

	List<Proyectocarrera> findCarreproyExiste(Integer idproy, String nombre);

}
