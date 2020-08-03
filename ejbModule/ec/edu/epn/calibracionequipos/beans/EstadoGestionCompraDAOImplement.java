/**
 * 
 */
package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.calibracionequipos.entidades.Estadogestioncompra;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class EstadoGestionCompraDAOImplement extends DaoGenericoImplement<Estadogestioncompra>
		implements EstadoGestionCompraDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(esteq.idEstadogcompra) FROM Estadogestioncompra esteq");
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
