package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Cronograma;

@Local
public interface CronogramaProyectoDAO extends DaoGenerico<Cronograma>{

	List<Cronograma> findCronogramabyProyecto(Integer idproyecto);

	List<Cronograma> findCronogramabyProyectoFaltante(Integer idproyecto, Integer idpensum, String tipo);

}
