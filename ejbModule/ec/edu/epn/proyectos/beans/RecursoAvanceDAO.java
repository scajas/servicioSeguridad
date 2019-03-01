package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Recursoavance;

@Local
public interface RecursoAvanceDAO extends DaoGenerico<Recursoavance> {

	List<Recursoavance> findByrecurso(Integer Idrecurso,String tipo);

	List<Recursoavance> findByrecursoExiste(Integer Idrecurso, Integer idpensum, String tipo);

	List<Recursoavance> findByProyectoReporte(Integer Idproyecto, Integer idpensum, String tipo);

	Recursoavance findByProyectoReportePlanificada(Integer Idrecurso, Integer idpensum, String tipo);

}
