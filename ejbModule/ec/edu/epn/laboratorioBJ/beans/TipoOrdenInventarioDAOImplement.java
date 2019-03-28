/**
 * 
 */
package ec.edu.epn.laboratorioBJ.beans;



import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Tipordeninv;

/**
 * @author Administrador
 * 
 */
@Stateless
@LocalBean

public class TipoOrdenInventarioDAOImplement extends DaoGenericoImplement<Tipordeninv> implements TipoOrdenInventarioDAO {

	
	
	 public TipoOrdenInventarioDAOImplement() {
	       
	    }
	 
	
	 
	 
}
