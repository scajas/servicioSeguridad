package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Pureza;

/**
 * Session Bean implementation class PuerzaDAOImplement
 */
@Stateless
@LocalBean
public class PurezaDAOImplement extends DaoGenericoImplement<Pureza> implements PurezaDAO {

    /**
     * Default constructor. 
     */
    public PurezaDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
