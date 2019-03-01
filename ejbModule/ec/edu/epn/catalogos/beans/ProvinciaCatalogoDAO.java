package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.catalogos.entities.Provincia;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface ProvinciaCatalogoDAO extends DaoGenerico<Provincia> {
	

	List<Provincia> findAll();
	
}
