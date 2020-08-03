package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Dep;
import ec.edu.epn.rrhh.entities.Tnomb;

/**
 * Session Bean implementation class TnomDAOImplement
 */
@Stateless
@LocalBean
public class TnomDAOImplement extends DaoGenericoImplement<Tnomb> implements TnomDAO {

	@Override
	public Tnomb findTnomByID(String tnom) {
		Query q = getEntityManager().createQuery(
				"Select dep from Tnomb dep where dep.tnomb = ?1 ");
		q.setParameter(1, tnom);
		return (Tnomb) q.getSingleResult();
	}
	
	@Override
	public List<Tnomb> findTiposNombramiento() {
		Query q = getEntityManager().createQuery(
				"Select dep from Tnomb dep order by dep.tnomb ");

		return q.getResultList();
	}
	
	

}
