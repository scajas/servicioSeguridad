package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Norma;

/**
 * Session Bean implementation class NormaDAOImplement
 */
@Stateless
@LocalBean
public class NormaDAOImplement extends DaoGenericoImplement<Norma> implements NormaDAO {

    /**
     * Default constructor. 
     */
    public NormaDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
