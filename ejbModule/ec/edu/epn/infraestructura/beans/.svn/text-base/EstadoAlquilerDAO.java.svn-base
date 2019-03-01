package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.EstadoAlquiler;

@Local
public interface EstadoAlquilerDAO extends DaoGenerico<EstadoAlquiler> {
	int consultarId();

	List<EstadoAlquiler> listarEAlquiler();

	List<EstadoAlquiler> buscarEAlquiler(int ealquiler);

	List<EstadoAlquiler> buscarEAlquilerXNombre(String ealquiler);

}
