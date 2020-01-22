package ec.edu.epn.atencionmedica.beans;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Psicologia;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface PsicologiaDAO extends DaoGenerico<Psicologia>{

	Psicologia psicologiaXidPaciente(Integer idPaciente);

	Long countPsicologXIdPaciente(Integer idPaciente); 
	
	
	

	
}
