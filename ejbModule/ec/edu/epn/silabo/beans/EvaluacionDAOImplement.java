package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.Evaluacion;
import ec.edu.epn.silabo.entities.MetodologiaDeEnsenanza;

/**
 * Session Bean implementation class EvaluacionDAOImplement
 */
@Stateless
@LocalBean
public class EvaluacionDAOImplement extends DaoGenericoImplement<Evaluacion> implements EvaluacionDAO {

   
	@Override
	public List<Evaluacion> consultarEvaluacion(Integer idsilado) {

		StringBuilder querys = new StringBuilder("SELECT e From Evaluacion e where e.silabo.idSilabo = ?1   order by e.idEvaluacion " );

	
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);
	

		return query.getResultList();
		
		
		
	}
	
	@Override
	public int maxIdEvaluacion() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idEvaluacion) FROM Evaluacion p");
		Integer idPagosV = null;

		try {
			idPagosV = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idPagosV = null;
		}
		if (idPagosV == null) {
			idPagosV = 1;
		} else {
			++idPagosV;
		}
		return idPagosV;
	}

	
	
}
