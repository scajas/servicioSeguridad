package ec.edu.epn.proyectos.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Objetivo;
import ec.edu.epn.proyectos.entities.ProyectoObjetivo;

@Local
public interface ObjetivoDAO extends DaoGenerico<Objetivo>{

}
