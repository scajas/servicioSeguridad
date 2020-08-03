/**
 * 
 */
package ec.edu.epn.contratos.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.CorreosPedidosNotificacione;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;



/**
 * @author Administrador
 * 
 */
@Stateless
public class CorreoesNotificacionesDAOImplement extends
		DaoGenericoImplement<CorreosPedidosNotificacione> implements
		CorreosNotificacionesDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager()
				.createQuery(
						"SELECT MAX(cor.idCorreo) FROM CorreosPedidosNotificacione cor");
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
		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}
}
