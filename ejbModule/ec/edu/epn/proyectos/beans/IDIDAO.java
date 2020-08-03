package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Idi;

@Local
public interface IDIDAO extends DaoGenerico<Idi>{

	List<Idi> consultarIdiProyecto(Integer idproy);

}
