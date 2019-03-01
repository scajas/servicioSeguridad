/**
 * 
 */
package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Genero;



/**
 * @author Administrador
 * 
 */
@Stateless
public class GeneroDAOImplement extends DaoGenericoImplement<Genero> implements
		GeneroDAO {
	
	
	@Override
	public List<Genero> findgeneros() {
		Query q = getEntityManager().createQuery(
				"Select dep from Genero dep order by dep.codSexo ");

		return q.getResultList();
	}

}
