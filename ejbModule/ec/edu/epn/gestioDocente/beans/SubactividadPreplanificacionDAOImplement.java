package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.SubactividadPreplanificacion;

/**
 * Session Bean implementation class ActividadDocenciaDAOImplement
 */
@Stateless
@LocalBean
public class SubactividadPreplanificacionDAOImplement extends DaoGenericoImplement<SubactividadPreplanificacion>
		implements SubactividadPreplanificacionDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SubactividadPreplanificacion> listSubActvXIdActvPreplanif(Integer idActividad) throws Exception {
		Query q = getEntityManager()
				.createQuery(						
						"SELECT s FROM SubactividadPreplanificacion s WHERE s.actividadPreplanificacion.idActividadPreplanif=? ORDER BY s.idSubactividadPreplanif");

		
		q.setParameter(1, idActividad);		
		
		return q.getResultList();
	}
}
