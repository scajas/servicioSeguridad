package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Servicio;

@Local
public interface ServicioDAO extends DaoGenerico<Servicio> {
	
	List<Servicio> listaServicioUnidad(int id);

	String maxIdServ(int id);

}
