package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.AutoresProducto;

@Local
public interface AutorProyectoDAO extends DaoGenerico<AutoresProducto>{

	List<AutoresProducto> finaAutoresProducto(Integer Idproducto) throws Exception;

}
