package ec.edu.epn.proyectos.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Moneda;

@Local
public interface MonedaDAO extends DaoGenerico<Moneda>{

}
