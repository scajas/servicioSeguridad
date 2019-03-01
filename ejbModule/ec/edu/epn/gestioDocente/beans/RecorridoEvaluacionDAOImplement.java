package ec.edu.epn.gestioDocente.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.RecorridoEvaluacion;

/**
 * Session Bean implementation class RecorridoEvaluacionDAOImplement
 */
@Stateless
@LocalBean
public class RecorridoEvaluacionDAOImplement extends DaoGenericoImplement<RecorridoEvaluacion>
		implements RecorridoEvaluacionDAO {
	
	
	
	@Override
	public RecorridoEvaluacion recorridoXEstado(Integer idEvaluacion, String estadoAnterior) throws Exception{
		Query q = getEntityManager().createQuery(
				"Select max(rec) from RecorridoEvaluacion rec where rec.idEvalAcad = ?1 and rec.estadoActual= ?2");
		q.setParameter(1, idEvaluacion );
		q.setParameter(2, estadoAnterior);
		return (RecorridoEvaluacion) q.getSingleResult();
	}
	
}
