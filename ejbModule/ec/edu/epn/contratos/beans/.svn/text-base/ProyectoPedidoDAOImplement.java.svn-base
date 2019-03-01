/**
 * 
 */
package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.ProyectoPedido;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author German
 * 
 */
@Stateless
public class ProyectoPedidoDAOImplement extends DaoGenericoImplement<ProyectoPedido> implements ProyectoPedidoDAO {
	
	@Override
	public int consultarProyectoPedidoId() throws Exception{
		Query q = getEntityManager().createQuery(
				"SELECT MAX(p.idProyectoPedido) FROM ProyectoPedido p");
		Integer idProyPedido = null;

		try {
			idProyPedido = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idProyPedido = null;
		}
		if (idProyPedido == null) {
			idProyPedido = 1;
		} else {
			++idProyPedido;
		}
		return idProyPedido;
	}
	
	@Override
	public List<ProyectoPedido> proyPedidoxId (Integer idPedido) throws Exception{
		Query q = getEntityManager().createQuery("SELECT p FROM ProyectoPedido p WHERE p.idPedido= ?1 ");		
		q.setParameter(1, idPedido);
		return q.getResultList();
	}

}
