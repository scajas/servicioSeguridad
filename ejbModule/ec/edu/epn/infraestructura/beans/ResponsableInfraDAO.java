package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.ResponsableInfra;

@Local
public interface ResponsableInfraDAO extends DaoGenerico<ResponsableInfra> {
	int consultarId();

	List<ResponsableInfra> listarResponsable();

	List<ResponsableInfra> buscarResponsable(int resp);

	List<ResponsableInfra> buscarResponsableXNombre(String nombre);

	List<ResponsableInfra> buscarResponsableXApellido(String apellido);

	List<ResponsableInfra> buscarResponsableXCedula(String cedula);
}
