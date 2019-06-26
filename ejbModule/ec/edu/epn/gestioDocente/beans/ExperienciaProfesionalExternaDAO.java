package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.ExpProfesExt;

@Local
public interface ExperienciaProfesionalExternaDAO extends DaoGenerico<ExpProfesExt>{

	List<ExpProfesExt> buscarExperienciaProfExterna(String cedula, String validarecategoriza, String validarevaloriza,
			String tipo) throws Exception;
	
	
	List<ExpProfesExt> listExperienciaProfRecategoriza(String cedula);


	ArrayList<Integer> llenaAnios();
	
	//List<ExpProfesExt> listExperienciaProfExtXCed(String cedula, List<String> validaciones) throws Exception;

}
