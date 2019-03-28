package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Tipoproducto;

/**
 * Session Bean implementation class TipoProductoDAOImplement
 */
@Stateless
@LocalBean
public class TipoProductoDAOImplement extends DaoGenericoImplement<Tipoproducto> implements TipoProductoDAO {

    /**
     * Default constructor. 
     */
    public TipoProductoDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
