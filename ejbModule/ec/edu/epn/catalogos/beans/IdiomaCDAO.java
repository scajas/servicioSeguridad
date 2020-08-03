package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.catalogos.entities.Idioma;
import ec.edu.epn.generic.DAO.DaoGenerico;


@Local
public interface IdiomaCDAO extends DaoGenerico<Idioma>{

	List<Idioma> finsAllIdiomas() throws Exception;

}
