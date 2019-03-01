/**
 * 
 */
package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.DedicacionContratos;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;



/**
 * @author Administrador
 * 
 */
@Stateless
public class DedicacionDAOImplement extends DaoGenericoImplement<DedicacionContratos>
		implements DedicacionDAO {

	@Override
	public List<DedicacionContratos> lisDedicacionxNombre(String nombre) {
		Query q = getEntityManager()
				.createQuery(
						"Select dep from DedicacionContratos dep   where dep.dedicacion =?1 ");

		q.setParameter(1, nombre);

		
		return q.getResultList();
	}

	
	
}
