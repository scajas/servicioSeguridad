/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.EstadoEvaluacion;

/**
 * @author German Romero
 * 
 */
@Stateless
public class EstadoEvaluacionDAOImplement extends DaoGenericoImplement<EstadoEvaluacion> implements EstadoEvaluacionDAO {

	@Override
	public EstadoEvaluacion estadoEvalXNombre(String nombre) throws Exception {
		
		try {
		Query q = getEntityManager()
				.createQuery(
						"SELECT e FROM EstadoEvaluacion e WHERE e.nombre like ? ");

		
		q.setParameter(1, nombre );
		
		
		
		
		return (EstadoEvaluacion) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoEvaluacion> listEstaodEval(){
		try {			
			Query q = getEntityManager()
					.createQuery(
							"SELECT e FROM EstadoEvaluacion e WHERE e.nombre NOT LIKE '%PRE%' ");
			
			
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoEvaluacion> listEstaodEvalPreplanif(){
		try {			
			Query q = getEntityManager()
					.createQuery(
							"SELECT e FROM EstadoEvaluacion e WHERE e.nombre LIKE '%PRE%' ");
			
			
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
}
