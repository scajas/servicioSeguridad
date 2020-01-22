package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Clasemp;
import ec.edu.epn.rrhh.movimientos.Clase;



@Local
public interface ClaseDAO extends DaoGenerico<Clase> {

	public Clase findClaseByNombre(String nombreClase);

	public List<Clase> findClaseByEstadoActivo();

}
