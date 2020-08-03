/**
 * 
 */
package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.calibracionequipos.entidades.Caracteristicastecnica;
import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class CaracteristicasTecnicasDAOImplement extends DaoGenericoImplement<Caracteristicastecnica>
		implements CaracteristicasTecnicasDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(a.idCaractertecnica) FROM Caracteristicastecnica a");
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
	public List<Caracteristicastecnica> buscarCarcateristicasxEquipo(Equiposcalibracionequipo equipo) {
		StringBuilder queryString = new StringBuilder(
				"select ct from Caracteristicastecnica ct where ct.equiposcalibracionequipo.idEquipo = ?1 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, equipo.getIdEquipo());
		return query.getResultList();
	}
}
