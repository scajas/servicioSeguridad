package ec.edu.epn.infraestructura.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.EstadoEspacio;

@Local
public interface EstadoEspacioDAO extends DaoGenerico<EstadoEspacio> {
	public int maxEstadoEspacio();

	

}
