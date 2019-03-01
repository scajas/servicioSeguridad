package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Lineasproy;

@Local
public interface LineasProyectoDAO extends DaoGenerico<Lineasproy> {

	List<Lineasproy> findLineasProy(Integer idProyect);

}
