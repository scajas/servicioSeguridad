/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.CalculoEval;

/**
 * @author EPN
 * 
 */
@Stateless
public class CalculoEvalDAOImplement extends
		DaoGenericoImplement<CalculoEval> implements CalculoEvalDAO {

	@Override
	public Long countCalcDocPeriodo(String nced, Integer idPensum) throws Exception {		
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(c) FROM CalculoEval c WHERE c.nced=? AND c.idPensum= ?");	
		
		q.setParameter(1, nced);
		q.setParameter(2, idPensum);				
		
		return (Long) q.getSingleResult();
	}
	
	
}
