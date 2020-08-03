package ec.edu.epn.desarrollo.beans;

import javax.ejb.Local;

import ec.edu.epn.desarrollo.entities.PersonalD;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface PersonalDDAO extends DaoGenerico<PersonalD> {

}
