/**
 * 
 */
package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.calibracionequipos.entidades.Detalleplan;
import ec.edu.epn.calibracionequipos.entidades.Plan;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class DetallePlanDAOImplement extends DaoGenericoImplement<Detalleplan> implements DetallePlanDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(esteq.idDetalleplan) FROM Detalleplan esteq");
		Integer idReq = null;
		try {
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}
		return idReq;

	}

	@Override
	public List<Detalleplan> detallesxPlan(Plan plan) {
		StringBuilder queryString = new StringBuilder(
				"select cu from Detalleplan cu where cu.plan.idPlan = ?1 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, plan.getIdPlan());
		return query.getResultList();
	}

}
