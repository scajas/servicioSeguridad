package ec.edu.epn.desarrollo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.desarrollo.entities.PersonalArea;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface PersonalAreaDAO extends DaoGenerico<PersonalArea>{

	PersonalArea findPersonalArear(String nced, String estado);

	List<PersonalArea> consultarPersonalByArea(Integer idarea, String activo);

}
