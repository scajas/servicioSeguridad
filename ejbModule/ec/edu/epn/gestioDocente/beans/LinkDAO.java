package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.Link;

@Local
public interface LinkDAO extends DaoGenerico<Link> {

	List<Link> buscarLinks(String nced) throws Exception;

	int maxCodLink();

}
