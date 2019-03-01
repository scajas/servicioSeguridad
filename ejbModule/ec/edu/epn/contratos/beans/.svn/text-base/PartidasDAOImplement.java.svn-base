/**
 * 
 */
package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Partida;
import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class PartidasDAOImplement extends DaoGenericoImplement<Partida> implements PartidasDAO {
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(car.idPartida) FROM Partida car");

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
	public List<Partida> consultarPartidasxPedido(Pedido pedido) {
		Query q = getEntityManager().createQuery("Select p from Partida p   where p.pedido.idPedido = ?1");
		q.setParameter(1, pedido.getIdPedido());
		return q.getResultList();
	}
}
