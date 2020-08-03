package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.InformeTecnico;

@Local
public interface InformeTecnicoDAO extends DaoGenerico<InformeTecnico>{

	List<InformeTecnico> findInformebyProy(Integer idproy);

}
