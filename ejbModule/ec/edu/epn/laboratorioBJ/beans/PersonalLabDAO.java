package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.PersonalLab;
import ec.edu.epn.laboratorioBJ.entities.UnidadLabo;

@Local
public interface PersonalLabDAO extends DaoGenerico<PersonalLab> {
	
	String maxIdPersonal(int id);
	List<PersonalLab> listarPersonalById(int id);
	UnidadLabo buscarUnidadById(int id);

}
