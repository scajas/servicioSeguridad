package ec.edu.epn.atencionmedica.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.atencionmedica.entities.Psicologia;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

@Stateless
@LocalBean
public class PsicologiaDAOImplement extends DaoGenericoImplement<Psicologia> implements PsicologiaDAO {
	
	
	@Override	
	public Psicologia psicologiaXidPaciente(Integer idPaciente){		
		try {
			Query q = getEntityManager()
					.createQuery(
							"SELECT p FROM Psicologia p WHERE p.idPaciente=? ");

			
			q.setParameter(1, idPaciente);
			return (Psicologia) q.getSingleResult();
			} catch (NoResultException e) {
				return null;
			} catch (Exception e) {
				return null;
			}
		
	}
	
	
	@Override
	public Long countPsicologXIdPaciente(Integer idPaciente) {
		
		Long val= 0L;
		
		try {
			Query q = getEntityManager()
					.createQuery(
							"SELECT count(p) FROM Psicologia p WHERE p.idPaciente=? ");

			
			q.setParameter(1, idPaciente);
			
			return (Long) q.getSingleResult();
		} catch (NoResultException e) {
			return 0L;
		} catch (Exception e) {
			return 0L;
		}
		
		
	}
}
