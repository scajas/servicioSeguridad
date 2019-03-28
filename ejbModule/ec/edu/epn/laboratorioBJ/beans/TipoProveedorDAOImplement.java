package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Tipoproveedor;

/**
 * Session Bean implementation class TipoProveedorDAOImplement
 */
@Stateless
@LocalBean
public class TipoProveedorDAOImplement extends DaoGenericoImplement<Tipoproveedor> implements TipoProveedorDAO {

    /**
     * Default constructor. 
     */
    public TipoProveedorDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
