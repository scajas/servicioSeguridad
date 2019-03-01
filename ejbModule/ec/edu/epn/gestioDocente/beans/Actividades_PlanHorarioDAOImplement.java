/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Actividad_PlanHorario;
import ec.edu.epn.gestionDocente.entities.PlanTrabajo;

/**
 * @author Administrador
 * 
 */
@Stateless
public class Actividades_PlanHorarioDAOImplement extends DaoGenericoImplement<Actividad_PlanHorario>
		implements Actividades_PlanHorarioDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager()
				.createQuery("SELECT MAX(act.idActividadPlanhorario) FROM Actividad_PlanHorario act");
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
	public List<Actividad_PlanHorario> listaActividadesHorarioExistentesEnplanTrabajo(PlanTrabajo p, Pensum pe) {
		try {
			StringBuilder queryString = new StringBuilder(
					"SELECT plan FROM Actividad_PlanHorario plan where plan.planTrabajo.idPlan like ?1 and plan.planTrabajo.pensum.idPensum = ?2 order by plan.idActividadPlanhorario asc");
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, p.getIdPlan());
			query.setParameter(2, pe.getIdPensum());
			

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actividad_PlanHorario> listaPlantrabajoPedido(Pedido pedido) {
		try {
			StringBuilder queryString = new StringBuilder(
					"SELECT plan FROM Actividad_PlanHorario plan where plan.planTrabajo.nced like ?1 and plan.planTrabajo.pensum.idPensum = ?2 order by plan.idActividadPlanhorario asc");
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, pedido.getNced());
			query.setParameter(2, pedido.getPensum().getIdPensum());
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
