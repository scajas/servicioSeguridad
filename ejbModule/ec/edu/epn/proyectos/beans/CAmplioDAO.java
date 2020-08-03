package ec.edu.epn.proyectos.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.Camplio;

@Local
public interface CAmplioDAO extends DaoGenerico<Camplio> {

	Camplio consultarCamplio(String nombre);

}
