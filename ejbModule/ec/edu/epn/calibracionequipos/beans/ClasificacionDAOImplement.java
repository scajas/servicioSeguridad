/**
 * 
 */
package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.calibracionequipos.entidades.Clasificacion;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class ClasificacionDAOImplement extends DaoGenericoImplement<Clasificacion> implements ClasificacionDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(clas.idClasificacion) FROM Clasificacion clas");
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
