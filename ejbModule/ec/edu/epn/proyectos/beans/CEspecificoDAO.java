package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Cespecifico;

@Local
public interface CEspecificoDAO extends DaoGenerico<Cespecifico>{

	List<Cespecifico> consultarCamplios(Integer idcamplio);

	Cespecifico consultarCespecifico(String nombre);

}
