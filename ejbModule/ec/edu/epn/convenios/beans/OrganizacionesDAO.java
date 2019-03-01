package ec.edu.epn.convenios.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.convenios.entities.Organizacion;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface OrganizacionesDAO extends DaoGenerico<Organizacion> {

	List<Organizacion> findOrga(String nombre);

}
