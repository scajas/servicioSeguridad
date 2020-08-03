/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.Sesione;

/**
 * @author Administrador
 * 
 */
@Stateless
public class SesionesDAOImplement extends DaoGenericoImplement<Sesione>
		implements SesionesDAO {

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(ses.idSesiones)FROM Sesione ses");
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
