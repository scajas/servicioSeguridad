package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.OportunidadMejoraEvaluacion;

/**
 * Session Bean implementation class ActividadDocenciaDAOImplement
 */
@Stateless
@LocalBean
public class OportunidadMejoraEvaluacionDAOImplement extends DaoGenericoImplement<OportunidadMejoraEvaluacion>
		implements OportunidadMejoraEvaluacionDAO {
	
	
	
	@Override
	public List<OportunidadMejoraEvaluacion>  listOportunidadesXEvaluacion (Integer idEvalaucionAcademica) throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT o FROM OportunidadMejoraEvaluacion o WHERE o.idEvalAcad=?  ");

		
		q.setParameter(1, idEvalaucionAcademica);
		
		
		
		
		return q.getResultList();
	}

	
		
}

