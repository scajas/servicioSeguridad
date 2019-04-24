package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.PersonalLab;

@Local
public interface PersonalLabDAO extends DaoGenerico<PersonalLab> {
	

}
