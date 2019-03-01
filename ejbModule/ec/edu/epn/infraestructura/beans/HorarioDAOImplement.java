/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.Horario;

/**
 * @author Administrador
 * 
 */
@Stateless
public class HorarioDAOImplement extends DaoGenericoImplement<Horario>
		implements HorarioDAO {

	@Override
	public int maxHorario() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(h.idHorario) FROM Horario h");
		Integer idHorario = null;

		try {
			idHorario = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idHorario = null;
		}
		if (idHorario == null) {
			idHorario = 1;
		} else {
			++idHorario;
		}
		return idHorario;
	}

	@Override
	public List<Horario> listaHorariosConincide(Horario hirario) {
		StringBuilder queryString = new StringBuilder(
				"SELECT h FROM Horario h where h.horaInicio = ?1 and h.horaFin = ?2 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, hirario.getHoraInicio());
		query.setParameter(2, hirario.getHoraFin());

		return (List<Horario>) query.getResultList();
	}

}
