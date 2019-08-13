/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.CalculoHorasExigible;
import ec.edu.epn.gestionDocente.entities.PreplanificacionDocencia;

/**
 * @author Administrador
 * 
 */
@Stateless
public class CalculoHorasExigibleDAOImplement extends
		DaoGenericoImplement<CalculoHorasExigible> implements CalculoHorasExigibleDAO {

	
	
	@Override
	public CalculoHorasExigible calculoHorasXPensum(Integer idPensum) throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT c FROM CalculoHorasExigible c WHERE c.idPensum= ?1 ");

		
		q.setParameter(1, idPensum);
		
		
		try {
			return  (CalculoHorasExigible) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
