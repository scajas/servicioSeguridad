package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.DetalleProforma;

/**
 * Session Bean implementation class DetalleProDAOImplement
 */
@Stateless
@LocalBean
public class DetalleProDAOImplement extends DaoGenericoImplement<DetalleProforma> implements DetalleProDAO {

    /**
     * Default constructor. 
     */
    public DetalleProDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
