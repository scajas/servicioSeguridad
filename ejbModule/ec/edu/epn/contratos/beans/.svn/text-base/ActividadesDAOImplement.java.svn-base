/**
 * 
 */
package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Actividades;
import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;



/**
 * @author Administrador
 * 
 */
@Stateless
public class ActividadesDAOImplement extends DaoGenericoImplement<Actividades>
		implements ActividadesDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(act.idActividad) FROM Actividades act");
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Actividades> findActividByParam(Pedido pedido) {
		StringBuilder queryString = new StringBuilder(
				"SELECT act FROM Actividades act WHERE act.pedido=?0 ");
		queryString.append(" ORDER BY LOWER(act.idActividad) ");

		Query query = getEntityManager().createQuery(queryString.toString());

		if (pedido != null) {
			query.setParameter(0, pedido);
		}

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actividades> buscarActividadXParametrosCarreraNombre(
			String parametro, String nombre) {
		StringBuilder queryString = null;
		if (parametro.equals("Actividad")) {
			queryString = new StringBuilder(
					"SELECT act FROM Actividades act where act.nombreActividad like ?1");
		} else if (parametro.equals("Carrera")) {
			queryString = new StringBuilder(
					"SELECT act FROM Actividades act where act.carrera like ?1");
		}
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + nombre + "%");
		System.out
				.println("LISTA DE ACTIVIDADES POR ACTIVIDAD O CARRERA...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actividades> findActividadesByParams(int nced) {
		System.out.println("Act");
		StringBuilder queryString = new StringBuilder(
				"SELECT act FROM Actividades act WHERE act.pedido.idPedido =?0 ORDER BY act.idActividad");

		if (nced == 0) {
			return null;
		}

		Query query = getEntityManager().createQuery(queryString.toString());

		if (nced != 0) {
			query.setParameter(0, nced);
		}

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actividades> buscarActividadSINPedido() {
		StringBuilder queryString = new StringBuilder(
				"SELECT act FROM Actividades act where act.pedido.idPedido is null");
		Query query = getEntityManager().createQuery(queryString.toString());

		System.out
				.println("LISTA DE ACTIVIDADES POR ACTIVIDAD O CARRERA...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<Actividades> buscarActividadXPedido(Pedido pedido) {
		StringBuilder queryString = new StringBuilder(
				"SELECT act FROM Actividades act where act.pedido.idPedido =?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, pedido.getIdPedido());

		System.out.println("LISTA DE ACTIVIDADES X PEDIDO...!!!!!!!!!!!!: "
				+ query.getResultList().size());
		return query.getResultList();
	}

	
	public long numHorasActividadesRmu(int idPed) {
		  System.out.println("Carga RMU ACTIVIDADES");

		  StringBuilder queryString = new StringBuilder(
		    "SELECT SUM(a.numHorasSemana) FROM Actividades a WHERE a.pedido.idPedido =?0 ");
		  
		  Query query = getEntityManager().createQuery(queryString.toString());
		  query.setMaxResults(1);
		  
		  if (idPed != 0) {
		   query.setParameter(0, idPed);
		  }
		  
		  List <Long>results = query.getResultList();

		  if(!results.isEmpty()){
		  // ignores multiple results
		  return 0;
		  }
		    
		  return results.get(0);
		    
		 }

}
