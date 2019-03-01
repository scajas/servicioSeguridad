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
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class DiasHoraDAOImplement extends DaoGenericoImplement<Diashora> implements DiasHoraDAO {

	@Override
	public List<DiasPlanificacion> findDiasxHora(HoraPlanificacion hora) {
		try {
			StringBuilder queryString = new StringBuilder(
					"SELECT dh FROM Diashora dh WHERE dh.horaPlanificacion.idHoraplanificacion=?0 ");
			queryString.append(" ORDER BY dh.id ");

			Query query = getEntityManager().createQuery(queryString.toString());

			if (hora != null) {
				query.setParameter(0, hora.getIdHoraplanificacion());
			}

			List<Diashora> list = query.getResultList();
			List<DiasPlanificacion> listDias = new ArrayList<>();
			for (Diashora dh : list) {
				listDias.add(dh.getDiasPlanificacion());
			}

			return listDias;

		} catch (Exception e) {
			return null;
		}
	}

	
}