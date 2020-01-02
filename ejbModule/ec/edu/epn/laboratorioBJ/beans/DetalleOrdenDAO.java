package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Detalleorden;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.Servicio;

@Local
public interface DetalleOrdenDAO extends DaoGenerico<Detalleorden> {

	Metodo findMetodoById(String id);

	Servicio findServicioById(String id);

	List<Detalleorden> listTAbyId(String id);

}
