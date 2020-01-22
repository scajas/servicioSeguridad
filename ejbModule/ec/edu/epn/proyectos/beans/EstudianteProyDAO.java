package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.EstudianteProy;

@Local
public interface EstudianteProyDAO extends DaoGenerico<EstudianteProy> {

	List<EstudianteProy> findEstProy(Integer idproy);

	List<EstudianteProy> findEstProyFaltante(Integer idproy, Integer idpensum, String tipo);

	List<EstudianteProy> findEstProyExiste(Integer idproy, String nced);

}
