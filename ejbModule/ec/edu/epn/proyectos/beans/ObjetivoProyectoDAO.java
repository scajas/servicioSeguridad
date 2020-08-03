package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.ObjetivoProyecto;

@Local
public interface ObjetivoProyectoDAO extends DaoGenerico<ObjetivoProyecto> {

	List<ObjetivoProyecto> findObjetivoByProyecto(Integer idproyecto);

	List<ObjetivoProyecto> findObjetivoByProyectoFaltante(Integer idproyecto, Integer idpensum, String tipo);

}
