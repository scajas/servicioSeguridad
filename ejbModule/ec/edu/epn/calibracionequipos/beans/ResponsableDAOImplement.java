/**
 * 
 */
package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.calibracionequipos.entidades.Responsable;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class ResponsableDAOImplement extends DaoGenericoImplement<Responsable> implements ResponsableDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(res.idResponsable) FROM Responsable res");
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
	public List<Responsable> buscarResponsable(Responsable responsable) {
		StringBuilder queryString = new StringBuilder("select res from Responsable res where res.idResponsable > 0 ");

		if (responsable != null) {
			if (!responsable.getCedulaResponsable().equals(""))
				queryString.append(" and res.cedulaResponsable like ?1 ");
			if (!responsable.getNombreResponsable().equals(""))
				queryString.append(" and res.nombreResponsable like ?2 ");

		}

		queryString.append("ORDER BY res.idResponsable asc");

		Query query = getEntityManager().createQuery(queryString.toString());

		if (responsable != null) {
			if (!responsable.getCedulaResponsable().equals(""))
				query.setParameter(1, responsable.getCedulaResponsable() + "%");
			if (!responsable.getNombreResponsable().equals(""))
				query.setParameter(2, "%" + responsable.getNombreResponsable() + "%");
		}

		return query.getResultList();
	}

}
