/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.PlanfActAcademica;

/**
 * @author Administrador
 * 
 */
@Stateless
public class PlanfActAcademicaDAOImplement extends
		DaoGenericoImplement<PlanfActAcademica> implements PlanfActAcademicaDAO {

	@Override
	public Long countPlanifActDocente(String nced, Integer idPensum)
			throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(p) FROM PlanfActAcademica p WHERE p.nced=? AND p.idPensum= ? ");

		
		q.setParameter(1, nced);
		q.setParameter(2, idPensum);		
		
		
		return (Long) q.getSingleResult();
	}
	
	
	@Override
	public PlanfActAcademica valPlanifCedulaPeriodo(String nced, Integer idPensum)
			throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT p FROM PlanfActAcademica p WHERE p.nced=? AND p.idPensum= ? ");

		
		q.setParameter(1, nced);
		q.setParameter(2, idPensum);		
		
		
		return (PlanfActAcademica) q.getSingleResult();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override 
	public List<PlanfActAcademica> listPlanifXPeriodo(Integer idPensum) throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT p FROM PlanfActAcademica p WHERE p.idPensum= ? ");
		q.setParameter(1, idPensum);		
		
		
		return q.getResultList();
	}
	
	
	
}
