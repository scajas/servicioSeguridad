package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.UnidadLabo;

@Local
public interface MetodoDAO extends DaoGenerico<Metodo> {

	List<Metodo> getListMetodos(String id);

	UnidadLabo obtenerUnidad(int id);

	String maxIdMetodo(int id);

}
