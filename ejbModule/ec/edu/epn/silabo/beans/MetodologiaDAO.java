package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.MetodologiaDeEnsenanza;

@Local
public interface MetodologiaDAO extends DaoGenerico<MetodologiaDeEnsenanza>{

	List<MetodologiaDeEnsenanza> consultarMetodologia(Integer idsilado);

	int maxIdMetodologia();

}
