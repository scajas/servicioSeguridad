/**
 * 
 */
package ec.edu.epn.contratos.beans;

import javax.ejb.Stateless;

import ec.edu.epn.contratos.entities.CategoriaContratos;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;




/**
 * @author Administrador
 * 
 */
@Stateless
public class CategoriaDAOImplement extends DaoGenericoImplement<CategoriaContratos>
		implements CategoriaDAO {

}
