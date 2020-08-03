/**
 * 
 */
package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.contratos.entities.RecorridoPedido;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;


/**
 * @author Administrador
 * 
 */
@Stateless
public class Recorrido_PedidoDAOImplement extends
		DaoGenericoImplement<RecorridoPedido> implements Recorrido_PedidoDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(act.idRecorrido) FROM RecorridoPedido act");
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

	@Override
	public List<RecorridoPedido> listaRecoridoXPedido(Pedido pedido) {

		StringBuilder queryString = new StringBuilder(
				"SELECT rec FROM RecorridoPedido rec where rec.pedido.idPedido = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, pedido.getIdPedido());

		System.out.println("EN CONSULTA" + pedido.getIdPedido() + "++++++"
				+ query.getResultList().size());
		return query.getResultList();
	}

}
