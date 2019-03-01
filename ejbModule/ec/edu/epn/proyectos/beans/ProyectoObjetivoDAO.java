package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.DisciplinaProyecto;
import ec.edu.epn.proyectos.entities.Objetivo;
import ec.edu.epn.proyectos.entities.ProyectoObjetivo;

@Local
public interface ProyectoObjetivoDAO extends DaoGenerico<ProyectoObjetivo>{

	int consultarId();

	List<ProyectoObjetivo> consultardisExiste(Integer idproyecto,
			Integer idobjetivo);

	List<ProyectoObjetivo> consultardisProyecto(Integer idproyecto);

}
