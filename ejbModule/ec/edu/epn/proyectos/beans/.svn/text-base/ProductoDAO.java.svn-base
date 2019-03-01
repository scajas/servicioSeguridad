package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Producto;

@Local
public interface ProductoDAO extends DaoGenerico<Producto>{

	List<Producto> findPublicacionesProyecto(Integer idproyecto, String nrotesis);

	List<Producto> findPublicacionesProyectoReports(Integer idproyecto, Integer idpensum);

}
