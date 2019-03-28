package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.ProveedorLab;

/**
 * Session Bean implementation class ProveedorLabDAOImplement
 */
@Stateless
@LocalBean
public class ProveedorLabDAOImplement extends DaoGenericoImplement<ProveedorLab> implements ProveedorLabDAO {

    /**
     * Default constructor. 
     */
    public ProveedorLabDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
