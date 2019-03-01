package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.Universidad;

@Local
public interface UniversidadDAO extends DaoGenerico<Universidad>{

	List<Universidad> finsUniversidades(String idPais) throws Exception;

	
	
	
	
	

}
