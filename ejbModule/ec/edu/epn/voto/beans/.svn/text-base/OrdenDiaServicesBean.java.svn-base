package ec.edu.epn.voto.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.epn.voto.beans.OrdenDiaServices;
import ec.edu.epn.voto.entities.ConvocatoriaVoto;
import ec.edu.epn.voto.entities.OrdenDia;
import ec.edu.epn.voto.entities.Sesion;

@Stateless
public class OrdenDiaServicesBean implements OrdenDiaServices {

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdenDia> findOrdenByParam(ConvocatoriaVoto convocatoria) {
		StringBuilder queryString = new StringBuilder(
				"SELECT ordenDiaC FROM OrdenDia ordenDiaC WHERE ordenDiaC.convocatoria=?0 ");
		queryString.append(" ORDER BY LOWER(ordenDiaC.idOrden) ");

		Query query = getEntityManager().createQuery(queryString.toString());

		if (convocatoria != null) {
			query.setParameter(0, convocatoria);
		}

		return query.getResultList();

	}

	@Override
	public void guardarSesionConvocatoria(Sesion sec) {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(sec.idSesion) FROM Sesion sec");

		Integer idOrdenDia = null;
		try {
			idOrdenDia = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idOrdenDia = null;
		}
		if (idOrdenDia == null) {
			idOrdenDia = 1;
		} else {
			++idOrdenDia;
		}
		
		sec.setIdSesion(idOrdenDia);
		

		getEntityManager().persist(sec);
	}
	
	
	
	
	@Override
	public Sesion findSesion(Integer idConv) {
		StringBuilder queryString = new StringBuilder(
				"SELECT sec FROM Sesion sec WHERE sec.convocatoria.idCon=?0 ");
		

		Query query = getEntityManager().createQuery(queryString.toString());

		
			query.setParameter(0, idConv);
		

		return (Sesion)query.getSingleResult();

	}
	
	
	
	
	@Override
	public void guardarOrdenDiaConvocatoria(OrdenDia od) {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(ordenDiaC.idOrden) FROM OrdenDia ordenDiaC");

		Integer idOrdenDia = null;
		try {
			idOrdenDia = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idOrdenDia = null;
		}
		if (idOrdenDia == null) {
			idOrdenDia = 1;
		} else {
			++idOrdenDia;
		}

		od.setIdOrden(idOrdenDia);

		getEntityManager().persist(od);
	}
	

	@Override
	public void updateOrdenDiaConvocatoria(OrdenDia od) {
		getEntityManager().merge(od);

	}

	@Override
	public void deleteOrdenDiaConvocatoria(OrdenDia od) {
		try {
			Query q = getEntityManager().createQuery(
					"DELETE FROM OrdenDia od WHERE od.idOrden =?0 ");

			q.setParameter(0, od.getIdOrden());
			q.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);

		}

	}
	
	
	@Override
	public void updateOSesion(Sesion ses) {
		getEntityManager().merge(ses);

	}

}
