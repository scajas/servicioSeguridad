package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.laboratory;

/**
 * Session Bean implementation class LaboratoryDAOImplement
 */
@Stateless
@LocalBean
public class LaboratoryDAOImplement extends DaoGenericoImplement<laboratory> implements LaboratoryDAO {

    /**
     * Default constructor. 
     */
    public LaboratoryDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
