package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Avanceestud;

@Local
public interface AvanceEstudDAO extends DaoGenerico<Avanceestud>{

	List<Avanceestud> findAvanceEstudProy(Integer idproy, Integer id_pensum, String tipo);

	Long countObjtvAvanceEst(Integer idEstudiante);

	List<Avanceestud> findAvanceEstudProyExiste(Integer idproy, Integer id_pensum, String tipo, Integer idEstud);

	Avanceestud findByProyectoReportePlanificada(Integer Idestud, Integer idpensum, String tipo);

}
