package ec.edu.epn.proyectos.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.TipoProducto;

/**
 * Session Bean implementation class TipoProductoReporteDAOImplement
 */
@Stateless
@LocalBean
public class TipoProductoReporteDAOImplement extends DaoGenericoImplement<TipoProducto>  implements TipoProductoReporteDAO {

    /**
     * Default constructor. 
     */
    public TipoProductoReporteDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
