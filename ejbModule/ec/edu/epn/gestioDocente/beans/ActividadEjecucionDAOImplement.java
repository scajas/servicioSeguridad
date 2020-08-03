package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.ActividadEjecucion;

/**
 * Session Bean implementation class ActividadEjecucionDAOImplement
 */
@Stateless
@LocalBean
public class ActividadEjecucionDAOImplement extends DaoGenericoImplement<ActividadEjecucion>
		implements ActividadEjecucionDAO {
	
	
	@Override
	public Long actvEvalXNombre(Integer idEvalAcademica, Integer tipoActvEval, String nombre) {
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(a) FROM ActividadEjecucion a WHERE a.evaluacionAcademica.idEvalAcad=? AND a.idTipoActvEval= ? AND a.nombreActividad= ? ");

		
		q.setParameter(1, idEvalAcademica);
		q.setParameter(2, tipoActvEval);
		q.setParameter(3, nombre);
		return (Long) q.getSingleResult();
	}
	
	
	
	@Override
	public Long actvEvalEjecucion(Integer idEvalAcademica) {
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(a) FROM ActividadEjecucion a WHERE a.evaluacionAcademica.idEvalAcad=? ");

		
		q.setParameter(1, idEvalAcademica);		
		return (Long) q.getSingleResult();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadEjecucion> listActvEvalXEvalTipo(Integer idEvalAcademica, Integer tipoActvEval) throws Exception {
		Query q = getEntityManager()
				.createQuery(
						"SELECT a FROM ActividadEjecucion a WHERE a.evaluacionAcademica.idEvalAcad=? AND a.idTipoActvEval= ? ORDER BY idActvEjec");

		
		q.setParameter(1, idEvalAcademica);
		q.setParameter(2, tipoActvEval);
		
		return q.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadEjecucion> listActvEvalXIdEval(Integer idEvalAcademica) throws Exception {
		Query q = getEntityManager()
				.createQuery(
						"SELECT a FROM ActividadEjecucion a WHERE a.evaluacionAcademica.idEvalAcad=? ORDER BY idActvEjec");

		
		q.setParameter(1, idEvalAcademica);		
		
		return q.getResultList();
	}
	
	
	@Override
	public Double sumValorActvEjec(Integer idEvalAcademica) {
		Query q = getEntityManager()
				.createQuery(
						"SELECT sum(a.valorAuto) FROM ActividadEjecucion a WHERE a.evaluacionAcademica.idEvalAcad=? ");

		
		q.setParameter(1, idEvalAcademica);		
		try {
			return (Double) q.getSingleResult();
		} catch (Exception e) {
			return 0.0;
		}
		
	}
		
}
