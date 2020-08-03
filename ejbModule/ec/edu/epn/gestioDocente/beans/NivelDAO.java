package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.NivelTitulo;


@Local
public interface NivelDAO extends DaoGenerico<NivelTitulo>{

	List<NivelTitulo> finsAllNiveles() throws Exception;

	

}
