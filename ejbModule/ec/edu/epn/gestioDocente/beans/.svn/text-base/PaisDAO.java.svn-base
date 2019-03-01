package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.Pais;

@Local
public interface PaisDAO extends DaoGenerico<Pais>{

	List<Pais> findAllPaises() throws Exception;

	Pais findAllPaisesByNombre(String nombrePais) throws Exception;

}
