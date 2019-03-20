/**
 * 
 */
package ec.edu.epn.deportivo.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.deportivo.entities.Deporte;
import ec.edu.epn.deportivo.entities.DiasPlanificacion;
import ec.edu.epn.deportivo.entities.Diashora;
import ec.edu.epn.deportivo.entities.HoraPlanificacion;
import ec.edu.epn.deportivo.entities.Planificacion;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class PlanificacionDAOImplement extends DaoGenericoImplement<Planificacion> implements PlanificacionDAO {

	@Override
	public List<Planificacion> findxDiaHorDep(DiasPlanificacion dia, HoraPlanificacion hora, Deporte deporte) {
		try {
			StringBuilder queryString = new StringBuilder(
					"SELECT p FROM Planificacion p WHERE p.diashora.diasPlanificacion.idDiaplanificacion=?0 and p.diashora.horaPlanificacion.idHoraplanificacion=?1 and p.deporte.idDeporte = ?2");
			queryString.append(" ORDER BY p.idPlanificacion ");

			Query query = getEntityManager().createQuery(queryString.toString());

			if (dia != null) {
				query.setParameter(0, dia.getIdDiaplanificacion());
			}

			if (hora != null) {
				query.setParameter(1, hora.getIdHoraplanificacion());
			}

			if (deporte != null) {
				query.setParameter(2, deporte.getIdDeporte());
			}

			return query.getResultList();

		} catch (Exception e) {
			return null;
		}

	}

}
