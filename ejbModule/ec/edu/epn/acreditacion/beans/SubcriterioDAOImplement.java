package ec.edu.epn.acreditacion.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.acreditacion.entities.Subcriterio;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class SubcriterioDAOImplement
 */
@Stateless
@LocalBean
public class SubcriterioDAOImplement extends DaoGenericoImplement<Subcriterio> implements SubcriterioDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Subcriterio> listSubCriterioxIdCriterio(Integer idCriterio) throws Exception{
		
		Query q = getEntityManager().createQuery(
				"SELECT s FROM Subcriterio s WHERE s.criterio.idCriterio = ?1");
		q.setParameter(1, idCriterio);
		return q.getResultList();
		
	}
	
	
	@Override
	public String detalleSubCriterio(Integer idSubcriterio) {
		Query q = getEntityManager().createQuery(
				"SELECT CONCAT(s.codSubcr, '-', s.nomSubcr) FROM Subcriterio s WHERE s.idSubcr = ?1");
		q.setParameter(1, idSubcriterio);
		String detalle = null;

		try {
			detalle = (String) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			detalle = "";
		}
		
		return detalle;
	}

}
