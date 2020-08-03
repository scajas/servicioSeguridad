/**
 * 
 */
package ec.edu.epn.contratos.beans;

import javax.ejb.Stateless;

import ec.edu.epn.contratos.entities.Estado;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;



/**
 * @author Administrador
 * 
 */
@Stateless
public class EstadoDAOImplement extends DaoGenericoImplement<Estado> implements
		EstadoDAO {

}
