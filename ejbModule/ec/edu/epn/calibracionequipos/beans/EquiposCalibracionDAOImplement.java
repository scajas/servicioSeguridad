/**
 * 
 */
package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.calibracionequipos.entidades.Laboratorioscalibracionequipo;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class EquiposCalibracionDAOImplement extends DaoGenericoImplement<Equiposcalibracionequipo>
		implements EquiposCalibracionDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(ec.idEquipo) FROM Equiposcalibracionequipo ec");
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
	public List<Equiposcalibracionequipo> buscarEquipos(Laboratorioscalibracionequipo laboratorio,
			Equiposcalibracionequipo equipo) {

		StringBuilder queryString = new StringBuilder(
				"select eq from Equiposcalibracionequipo eq where eq.idEquipo > 0 ");

		if (laboratorio != null && laboratorio.getIdLaboratorio() != 0) {
			queryString.append(" and eq.laboratorioscalibracionequipo.idLaboratorio = ?1 ");
		}

		if (equipo.getCodbienesEquipo() != null && !equipo.getCodbienesEquipo().equals("")) {
			queryString.append(" and eq.codbienesEquipo like ?2 ");
		}

		if (equipo.getNombreEquipo() != null && !equipo.getNombreEquipo().equals("")) {
			queryString.append(" and eq.nombreEquipo like ?3 ");
		}

		queryString.append("ORDER BY eq.idEquipo asc ");

		Query query = getEntityManager().createQuery(queryString.toString());

		if (laboratorio != null && laboratorio.getIdLaboratorio() != 0) {
			query.setParameter(1, laboratorio.getIdLaboratorio());
		}

		if (equipo.getCodbienesEquipo() != null && !equipo.getCodbienesEquipo().equals("")) {
			query.setParameter(2, "%" + equipo.getCodbienesEquipo() + "%");
		}

		if (equipo.getNombreEquipo() != null && !equipo.getNombreEquipo().equals("")) {
			query.setParameter(3, "%" + equipo.getNombreEquipo() + "%");
		}

		return query.getResultList();
	}

	@Override
	public List<Equiposcalibracionequipo> buscarEquiposxLabo(Laboratorioscalibracionequipo laboratorio) {
		StringBuilder queryString = new StringBuilder(
				"select eq from Equiposcalibracionequipo eq where eq.idEquipo > 0 ");

		if (laboratorio != null && laboratorio.getIdLaboratorio() != 0) {
			queryString.append(" and eq.laboratorioscalibracionequipo.idLaboratorio = ?1 ");
		}

		queryString.append("ORDER BY eq.idEquipo asc ");

		Query query = getEntityManager().createQuery(queryString.toString());

		if (laboratorio != null && laboratorio.getIdLaboratorio() != 0) {
			query.setParameter(1, laboratorio.getIdLaboratorio());
		}

		return query.getResultList();
	}
}
