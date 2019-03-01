package ec.edu.epn.catalogos.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.catalogos.entities.RubrosEspacio;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class EmpleadosServiceBean
 */
@Stateless
public class RubrosEspaciosDAOImplement extends
		DaoGenericoImplement<RubrosEspacio> implements
		RubrosEspaciosDAO {

	@Override
	public int consultarID() {

		Query q = getEntityManager().createQuery(
				"SELECT MAX(seg.idRubro)FROM RubrosEspacio seg");

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

}
