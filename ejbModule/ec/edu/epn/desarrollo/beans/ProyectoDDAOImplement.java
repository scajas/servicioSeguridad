package ec.edu.epn.desarrollo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.desarrollo.entities.ProyectoD;
import ec.edu.epn.desarrollo.entities.Requerimiento;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class ProyectoDDAOImplement
 */
@Stateless
@LocalBean
public class ProyectoDDAOImplement  extends DaoGenericoImplement<ProyectoD> implements ProyectoDDAO {

    
	@Override
	public List<ProyectoD> consultarProyectosBYArea(Integer idarea) {
		StringBuilder querys = new StringBuilder(
				"SELECT e From ProyectoD e where e.idarea = ?1 order by e.id ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idarea);
		return query.getResultList();
	}
	
	
	
	
	
	

}
