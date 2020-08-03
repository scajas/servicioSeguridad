package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.EstudioEnCurso;

@Local
public interface EstudioEnCursoDAO extends DaoGenerico<EstudioEnCurso>{
	
	
	public List<EstudioEnCurso> buscarEstudiosEnCursoDocente(String cedula) throws Exception;;


	

}
