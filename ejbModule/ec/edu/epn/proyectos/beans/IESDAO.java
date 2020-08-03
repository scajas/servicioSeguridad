package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.IesPublica;

@Local
public interface IESDAO extends DaoGenerico<IesPublica>{

	List<IesPublica> consultarIesProyecto(Integer idproy);

}
