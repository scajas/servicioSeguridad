package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.PersonalLab;


/**
 * Session Bean implementation class PersonalLabDAOImplement
 */
@Stateless
@LocalBean
public class PersonalLabDAOImplement extends DaoGenericoImplement<PersonalLab> implements PersonalLabDAO {

    /**
     * Default constructor. 
     */
    public PersonalLabDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
