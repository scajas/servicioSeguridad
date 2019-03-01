package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.EstadoEvento;

@Local
public interface EstadoEventoDAO extends DaoGenerico<EstadoEvento> {
	int consultarId();

	List<EstadoEvento> listarEEvento();

	List<EstadoEvento> listarEEventoReserva();

	List<EstadoEvento> buscarEstadoEvento(int eevento);

	List<EstadoEvento> buscarEstadoEventoXNombre(String eevento);

}
