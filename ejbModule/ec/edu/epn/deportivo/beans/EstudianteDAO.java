package ec.edu.epn.deportivo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.deportivo.entities.Estudiante;
import ec.edu.epn.generic.DAO.DaoGenerico;



@Local
public interface EstudianteDAO extends
		DaoGenerico<Estudiante> {


	List<Estudiante> findxCedula(String cedula);

	

}
