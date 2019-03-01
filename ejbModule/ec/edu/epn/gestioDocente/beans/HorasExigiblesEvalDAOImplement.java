package ec.edu.epn.gestioDocente.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.HorasExigiblesEval;

/**
 * Session Bean implementation class HorasExigiblesEvalDAOImplement
 */
@Stateless
@LocalBean
public class HorasExigiblesEvalDAOImplement extends DaoGenericoImplement<HorasExigiblesEval>
		implements HorasExigiblesEvalDAO {
	
	
	@Override
	public HorasExigiblesEval horasExigiblesXPensum(Integer idPensum){		
		try {
			Query q = getEntityManager()
					.createQuery(
							"SELECT h FROM HorasExigiblesEval h WHERE h.idPensum=  ? ");
			
			q.setParameter(1, idPensum);			
			
			return (HorasExigiblesEval) q.getSingleResult();
			} catch (NoResultException e) {
				return null;
			} catch (Exception e) {
				return null;
			}
	}
		
}
