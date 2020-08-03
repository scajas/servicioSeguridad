package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.SubactividadEjecucion;

/**
 * Session Bean implementation class ActividadDocenciaDAOImplement
 */
@Stateless
@LocalBean
public class SubactividadEjecucionDAOImplement extends DaoGenericoImplement<SubactividadEjecucion>
		implements SubactividadEjecucionDAO {
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SubactividadEjecucion> listSubActvEjecXIdActv(Integer idActividadEjecuion) throws Exception {
		Query q = getEntityManager()
				.createQuery(
						"SELECT s FROM SubactividadEjecucion s WHERE s.actividadEjecucion.idActvEjec=?  ORDER BY idSubactvEjec");

		
		q.setParameter(1, idActividadEjecuion);		
		
		return q.getResultList();
	}
	
	@Override
	public Long countSubActEjecXIdActvEjec(Integer idActvEjecucion)
			throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(s) FROM SubactividadEjecucion s WHERE s.actividadEjecucion.idActvEjec=? ");

		
		q.setParameter(1, idActvEjecucion);
		
		
		
		return (Long) q.getSingleResult();
	}
	
}
