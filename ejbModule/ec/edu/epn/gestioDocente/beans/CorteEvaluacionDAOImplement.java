package ec.edu.epn.gestioDocente.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.CorteEvaluacion;

/**
 * Session Bean implementation class CorteEvaluacionDAOImplement
 */
@Stateless
@LocalBean
public class CorteEvaluacionDAOImplement extends DaoGenericoImplement<CorteEvaluacion> implements CorteEvaluacionDAO {

	
	
	@Override
	public List<Pensum> listaPensumXDepCortePlanif(String tipoEvaluacion, String codDep) {	
		
		
		StringBuilder sbQuery = new StringBuilder();
		sbQuery.append(" SELECT pen FROM Pensum pen, CorteEvaluacion c WHERE pen.idPensum= c.idPensum AND c.codDep= ?");
		if(tipoEvaluacion.equals("PLANIF")){
			sbQuery.append(" AND c.fechaPlanif>= ?");
			
		}else if(tipoEvaluacion.equals("AUTOEVAL")){
			sbQuery.append(" WHERE c.fechaAuto>= ?");
			
		}else if(tipoEvaluacion.equals("COEVAL")){
			sbQuery.append(" WHERE c.fechaCoe>= ?");
		}
		
		
		//sbQuery.append(" ORDER BY CAST(pen.añoPensum AS integer) DESC ");
		Query q = getEntityManager().createQuery(sbQuery.toString());
		q.setParameter(1, codDep);
		q.setParameter(2,new Date());
		return q.getResultList();
	}
	
	@Override
	public CorteEvaluacion corteEvalXPensumDep(String codDep, Integer idPensum) {	
		
		
		StringBuilder sbQuery = new StringBuilder();
		sbQuery.append(" SELECT c FROM CorteEvaluacion c WHERE c.idPensum= ? AND c.codDep= ?");
		
		//sbQuery.append(" ORDER BY CAST(pen.añoPensum AS integer) DESC ");
		Query q = getEntityManager().createQuery(sbQuery.toString());
		q.setParameter(1, idPensum);
		q.setParameter(2, codDep);
		
		return (CorteEvaluacion) q.getSingleResult();
	}
}
