/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.ActPlan;
import ec.edu.epn.gestionDocente.entities.PlanTrabajo;


/**
 * @author Administrador
 * 
 */
@Stateless
public class Actividades_PlanDAOImplement extends DaoGenericoImplement<ActPlan>
		implements Actividades_PlanDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(act.idActiv) FROM ActPlan act");
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

	@SuppressWarnings("unchecked")
	@Override
	public List<ActPlan> listaActividadesExistentesEnplanTrabajo(PlanTrabajo p,
			Pensum pe) {
		try {
			StringBuilder queryString = new StringBuilder(
					"SELECT plan FROM ActPlan plan where plan.planTrabajo.idPlan like ?1 and plan.planTrabajo.pensum.idPensum = ?2");
			Query query = getEntityManager()
					.createQuery(queryString.toString());
			query.setParameter(1, p.getIdPlan());
			query.setParameter(2, pe.getIdPensum());			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
