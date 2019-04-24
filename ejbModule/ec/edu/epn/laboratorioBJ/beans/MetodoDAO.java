package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Metodo;

@Local
public interface MetodoDAO extends DaoGenerico<Metodo> {

}
