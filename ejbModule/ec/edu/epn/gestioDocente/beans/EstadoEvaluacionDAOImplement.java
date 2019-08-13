/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

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

		
		q.setParameter(1, "%" + nombre + "%");
		
		
		
		
		return (EstadoEvaluacion) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}
}
