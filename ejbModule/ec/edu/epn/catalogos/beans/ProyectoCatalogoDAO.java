package ec.edu.epn.catalogos.beans;

import javax.ejb.Local;

import ec.edu.epn.catalogos.entities.ProyectoCatalogo;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface ProyectoCatalogoDAO extends DaoGenerico<ProyectoCatalogo> {

	
}
