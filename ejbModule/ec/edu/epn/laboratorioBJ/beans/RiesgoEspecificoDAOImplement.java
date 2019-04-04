package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Riesgoespecifico;

/**
 * Session Bean implementation class RiesgoEspecificoDAOImplement
 */
@Stateless
@LocalBean
public class RiesgoEspecificoDAOImplement extends DaoGenericoImplement<Riesgoespecifico> implements  RiesgoEspecificoDAO {

    /**
     * Default constructor. 
     */
    public RiesgoEspecificoDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
