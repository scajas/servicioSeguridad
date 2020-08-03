package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.MontoEjecutado;

@Local
public interface MontoEjecutadoDAO extends DaoGenerico<MontoEjecutado>{

	List<MontoEjecutado> consultarMontoEjecutado(Integer idproyecto);

	List<MontoEjecutado> consultarMontoEjecutadoExiste(Integer idproyecto,
			Integer anio);

}
