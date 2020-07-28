package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.RecursohPr;

@Local
public interface RecursoProyectoDAO extends DaoGenerico<RecursohPr> {

	List<String> findRecDirectorCedula();

	List<RecursohPr> findRecDirector(String cedula);

	RecursohPr findDirector(int idProyecto);

	List<RecursohPr> findrecProyExiste(Integer idproy, Integer idtipoRec);

	List<RecursohPr> buscarRecursoExisteCedula(String nced, Integer idproy) throws Exception;

	List<RecursohPr> findrecProy(Integer idproy);

	RecursohPr findDirectorbycedula(String cedula);

	List<RecursohPr> findAllDirectores();

	List<RecursohPr> findrecProyFaltante(Integer idproy, Integer idpensum, String tipo);

	List<RecursohPr> findrecProyEPN(Integer idproy);

	List<RecursohPr> findrecProyREG(Integer idproy);

	List<RecursohPr> findRecursosByCedula(String nced);
	
	

}
