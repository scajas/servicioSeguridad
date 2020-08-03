package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.DisciplinaProyecto;

@Local
public interface DisciplinaPoryectoDAO extends DaoGenerico<DisciplinaProyecto>{

	int consultarId();

	List<DisciplinaProyecto> consultardisExiste(Integer idproyecto,
			Integer iddisciplina);

	List<DisciplinaProyecto> consultardisProyecto(Integer idproyecto);

}
