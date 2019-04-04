package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Detalleorden;
import ec.edu.epn.laboratorioBJ.entities.Metodo;

@Local
public interface DetalleOrdenDAO extends DaoGenerico<Detalleorden>{

	Metodo findMetodoById(String id);

}
