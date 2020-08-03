package ec.edu.epn.gestioDocente.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.DescansoObligatorio;
import ec.edu.epn.gestionDocente.entities.EvaluacionAcademica;

/**
 * Session Bean implementation class DescansoObligatorioDAOImplement
 */
@Stateless
@LocalBean
public class DescansoObligatorioDAOImplement extends DaoGenericoImplement<DescansoObligatorio>
		implements DescansoObligatorioDAO {

	
	@Override
	public int diasDescansoObligatorio(Date fechaIncio, Date fechaFin) {		
		try {
			Query q = getEntityManager()
					.createQuery(
							"SELECT count(d) FROM DescansoObligatorio d WHERE d.fechaDescanso BETWEEN ? AND ? ");

			
			q.setParameter(1, fechaIncio);
			q.setParameter(2, fechaFin);
			
			
			Long val= (Long) q.getSingleResult();
			
			return val.intValue();
			
			
		} catch (Exception e) {
			return 0;
		}
	}
	
	
	
	@Override
	public List<DescansoObligatorio> listDescansoObligatorio(Date fechaIncio, Date fechaFin) {		
		try {
			Query q = getEntityManager()
					.createQuery(
							"SELECT d FROM DescansoObligatorio d WHERE d.fechaDescanso BETWEEN ? AND ? ");

			
			q.setParameter(1, fechaIncio);
			q.setParameter(2, fechaFin);
			
			return q.getResultList();
			
			
		} catch (Exception e) {
			return null;
		}
	}

}
