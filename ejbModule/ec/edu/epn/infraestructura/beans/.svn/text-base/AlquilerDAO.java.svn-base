package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.Alquiler;



@Local
public interface AlquilerDAO extends DaoGenerico<Alquiler> {

	int consultarId();

	List<Alquiler> listarAlquiler();

	List<Alquiler> listaAlquilerSINPago();

	List<Alquiler> buscarAlquiler(int alq);

	List<Alquiler> buscarAlquilerXEvento(String nombreEvento);

	List<Alquiler> buscarAlquilerXTipoAlquiler(String nombreTipoAlquiler);

	boolean buscarEventoAlquilado(int idevento);

}
