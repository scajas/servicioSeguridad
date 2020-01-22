/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.ActividadPreplanificacion;

/**
 * @author Administrador
 * 
 */
@Stateless
public class ActividadPreplanificacionDAOImplement extends
		DaoGenericoImplement<ActividadPreplanificacion> implements ActividadPreplanificacionDAO {
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadPreplanificacion> findActividadByIdPreplanif(Integer idPreplanificacion, Integer idTipoActv) {

		try {

			StringBuilder queryString = new StringBuilder(
					"SELECT a FROM ActividadPreplanificacion a WHERE a.preplanificacionDocencia.idPreplanif=?0 AND a.idTipoActv=?1");

			
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, idPreplanificacion);
			query.setParameter(1, idTipoActv);
			
			

			return query.getResultList();

		} catch (Exception e) {
			return new ArrayList<ActividadPreplanificacion>();
		}
	}
	
	
	@Override
	public Double sumValorActPreplanif(Integer idPreplanificacion) {
		Query q = getEntityManager()
				.createQuery(
						"SELECT sum(a.valorPreplanif) FROM ActividadPreplanificacion a WHERE a.preplanificacionDocencia.idPreplanif=?  ");

		
		q.setParameter(1, idPreplanificacion);		
		
		try {
			return (Double) q.getSingleResult();
		} catch (Exception e) {
			return 0.0;
		}
		
	}
	
	
	@Override
	public ActividadPreplanificacion actividadXTipoCatalogo(Integer idPreplanificacion, Integer idTipoActv, Integer idCatalogo) {
		Query q = getEntityManager()
				.createQuery(
						"SELECT a FROM ActividadPreplanificacion a WHERE a.preplanificacionDocencia.idPreplanif=?1 AND a.idTipoActv=?2 AND a.reglamentoEvaluacion.idReglamentoEvaluacion=?3  ");

		
		q.setParameter(1, idPreplanificacion);		
		q.setParameter(2, idTipoActv);
		q.setParameter(3, idCatalogo);
		
		try {
			return  (ActividadPreplanificacion) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadPreplanificacion> findActividadByIdPreplanifGeneral(Integer idPreplanificacion) {

		try {

			StringBuilder queryString = new StringBuilder(
					"SELECT a FROM ActividadPreplanificacion a WHERE a.preplanificacionDocencia.idPreplanif=?0 ");

			
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, idPreplanificacion);

			return query.getResultList();

		} catch (Exception e) {
			return new ArrayList<ActividadPreplanificacion>();
		}
	}

		
}
