package ec.edu.epn.desarrollo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.desarrollo.entities.ProyectoD;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface ProyectoDDAO extends DaoGenerico<ProyectoD>{

	List<ProyectoD> consultarProyectosBYArea(Integer idarea);

}
