/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.Diaslaborable;

/**
 * @author Administrador
 * 
 */
@Stateless
public class DiasLaborablesDAOImplement extends
		DaoGenericoImplement<Diaslaborable> implements DiasLaborablesDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(alq.idDiaslab) FROM Diaslaborable alq");
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
	public List<Diaslaborable> listarDiasLabora() {
		StringBuilder queryString = new StringBuilder(
				"SELECT dl FROM Diaslaborable dl");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}

	@Override
	public List<Diaslaborable> listarDLXDias(String dl) {
		StringBuilder queryString = new StringBuilder(
				"SELECT dl FROM Diaslaborable dl where dl.descripcion like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + dl + "%");
		return query.getResultList();
	}
}
