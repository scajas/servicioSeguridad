/**
 * 
 */
package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.calibracionequipos.entidades.Accesorio;
import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class AccesoriosDAOImplement extends DaoGenericoImplement<Accesorio> implements AccesoriosDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(a.idAccesorio) FROM Accesorio a");
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
	public List<Accesorio> accesoriosxEquipo(Equiposcalibracionequipo equipo) {
		StringBuilder querys = new StringBuilder(
				"SELECT acc FROM Accesorio acc where acc.equiposcalibracionequipo.idEquipo = ?1");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, equipo.getIdEquipo());
		return query.getResultList();
	}
}
