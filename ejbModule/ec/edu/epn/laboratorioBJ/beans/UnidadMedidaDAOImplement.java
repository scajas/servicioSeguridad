/**
 * 
 */
package ec.edu.epn.laboratorioBJ.beans;



import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Unidadmedida;

/**
 * @author Administrador
 * 
 */
@Stateless
@LocalBean

public class UnidadMedidaDAOImplement extends DaoGenericoImplement<Unidadmedida> implements UnidadMedidaDAO {

	
	
	 public UnidadMedidaDAOImplement() {
	       
	    }
	 
	
	 
	 
}
