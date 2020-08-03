package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.ActividadEvaluacion;
import ec.edu.epn.gestionDocente.entities.SubactividadEvaluacion;

/**
 * Session Bean implementation class ActividadDocenciaDAOImplement
 */
@Stateless
@LocalBean
public class SubactividadEvaluacionDAOImplement extends DaoGenericoImplement<SubactividadEvaluacion>
		implements SubactividadEvaluacionDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SubactividadEvaluacion> listSubActvXIdActv(Integer idActividad) throws Exception {
		Query q = getEntityManager()
				.createQuery(
						"SELECT s FROM SubactividadEvaluacion s WHERE s.actividadEvaluacion.idActividadEvaluacion=?  ORDER BY idSubactividadEval");

		
		q.setParameter(1, idActividad);		
		
		return q.getResultList();
	}
}
