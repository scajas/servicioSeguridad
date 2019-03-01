package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.CompromisoEvaluacion;

/**
 * Session Bean implementation class ActividadDocenciaDAOImplement
 */
@Stateless
@LocalBean
public class CompromisoEvaluacionDAOImplement extends DaoGenericoImplement<CompromisoEvaluacion>
		implements CompromisoEvaluacionDAO {
	
	
	@Override
	public List<CompromisoEvaluacion>  listCompromisosXEvaluacion (Integer idEvalaucionAcademica) throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT c FROM CompromisoEvaluacion c WHERE c.idEvalAcad=?  ");
		
		q.setParameter(1, idEvalaucionAcademica);
		
		
		
		
		return q.getResultList();
	}

	
		
}

