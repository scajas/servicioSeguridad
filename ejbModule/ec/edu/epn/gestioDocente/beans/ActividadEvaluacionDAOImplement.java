package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.ActividadEvaluacion;

/**
 * Session Bean implementation class ActividadDocenciaDAOImplement
 */
@Stateless
@LocalBean
public class ActividadEvaluacionDAOImplement extends DaoGenericoImplement<ActividadEvaluacion>
		implements ActividadEvaluacionDAO {
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadEvaluacion> listActvEvalXEvalTipo(Integer idEvalAcademica, Integer tipoActvEval) throws Exception {
		Query q = getEntityManager()
				.createQuery(
						"SELECT a FROM ActividadEvaluacion a WHERE a.evaluacionAcademica.idEvalAcad=? AND a.idTipoActvEval= ? ORDER BY idActividadEvaluacion");

		
		q.setParameter(1, idEvalAcademica);
		q.setParameter(2, tipoActvEval);
		
		return q.getResultList();
	}
	
	
	
	@SuppressWarnings("unchecked")
	//@Override
	public List<ActividadEvaluacion> listPlanifXEvalTipo(Integer idEvalAcademica, Integer tipoActvEval) throws Exception {
		Query q = getEntityManager()
				.createQuery(
						"SELECT a FROM ActividadEvaluacion a WHERE a.idCatalogoActividad=a.reglamentoEvaluacion.idReglamentoEvaluacion AND a.evaluacionAcademica.idEvalAcad=? AND a.idTipoActvEval= ? ORDER BY idActividadEvaluacion");

		
		q.setParameter(1, idEvalAcademica);
		q.setParameter(2, tipoActvEval);
		
		return q.getResultList();
	}
	
	
	@Override
	public Long actvEvalXNombre(Integer idEvalAcademica, Integer tipoActvEval, String nombre) {
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(a) FROM ActividadEvaluacion a WHERE a.evaluacionAcademica.idEvalAcad=? AND a.idTipoActvEval= ? AND a.nombreActividad= ? ");

		
		q.setParameter(1, idEvalAcademica);
		q.setParameter(2, tipoActvEval);
		q.setParameter(3, nombre);
		return (Long) q.getSingleResult();
	}
	
	
	@Override
	public Long actvEvalXCatalogo(Integer idEvalAcademica, Integer tipoActvEval, Integer idCatalogoAct) {
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(a) FROM ActividadEvaluacion a WHERE a.evaluacionAcademica.idEvalAcad=? AND a.idTipoActvEval= ? AND a.reglamentoEvaluacion.idReglamentoEvaluacion= ? ");

		
		q.setParameter(1, idEvalAcademica);
		q.setParameter(2, tipoActvEval);
		q.setParameter(3, idCatalogoAct);
		return (Long) q.getSingleResult();
	}
	
	
	
	@Override
	public ActividadEvaluacion actvEvalXEvalTipo(Integer idEvalAcademica, Integer idCatalogo) throws Exception {
		Query q = getEntityManager()
				.createQuery(
						"SELECT a FROM ActividadEvaluacion a WHERE a.evaluacionAcademica.idEvalAcad=? AND a.reglamentoEvaluacion.idReglamentoEvaluacion= ? ");

		
		q.setParameter(1, idEvalAcademica);
		q.setParameter(2, idCatalogo);
		
		return (ActividadEvaluacion) q.getSingleResult();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadEvaluacion> listActvEvalXIdEval(Integer idEvalAcademica) throws Exception {
		Query q = getEntityManager()
				.createQuery(
						"SELECT a FROM ActividadEvaluacion a WHERE a.evaluacionAcademica.idEvalAcad=? ORDER BY idActividadEvaluacion");

		
		q.setParameter(1, idEvalAcademica);		
		
		return q.getResultList();
	}
	
	
	@Override
	public Long actvEvalNotIdTipoActv(Integer idEvalAcademica, Integer tipoActvEval) {
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(a) FROM ActividadEvaluacion a WHERE a.evaluacionAcademica.idEvalAcad=? AND a.idTipoActvEval NOT IN (?) ");

		
		q.setParameter(1, idEvalAcademica);
		q.setParameter(2, tipoActvEval);		
		return (Long) q.getSingleResult();
	}
	
}
