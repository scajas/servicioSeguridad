package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.UnidadLabo;

/**
 * Session Bean implementation class UnidadDAOImplement
 */
@Stateless
@LocalBean
public class UnidadDAOImplement extends DaoGenericoImplement<UnidadLabo> implements UnidadDAO {

    /**
     * Default constructor. 
     */
    public UnidadDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
