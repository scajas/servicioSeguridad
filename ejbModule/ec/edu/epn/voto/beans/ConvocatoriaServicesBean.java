package ec.edu.epn.voto.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.IdClass;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Hibernate;



import ec.edu.epn.voto.beans.ConvocatoriaServices;
import ec.edu.epn.voto.entities.Consejo;
import ec.edu.epn.voto.entities.ConvocatoriaVoto;
import ec.edu.epn.voto.entities.OrdenDia;

@Stateless
public class ConvocatoriaServicesBean implements ConvocatoriaServices {

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConvocatoriaVoto> findConvocatoriaByParams(int idConsejo,
			Date fechaConv) {
		StringBuilder queryString = new StringBuilder(
				"SELECT conv FROM ConvocatoriaVoto conv where conv.sesion_conv like ?0");

		if (idConsejo == 0 && fechaConv == null) {
			return null;
		}

		if (idConsejo != 0) {
			queryString.append(" and conv.consejo.idConsejo like ?1 ");
		}

		if (fechaConv != null) {
			queryString.append(" AND conv.fechaC = ?2 ");
		}
		queryString.append(" ORDER BY LOWER(conv.fechaC) ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%");

		if (idConsejo != 0) {
			query.setParameter(1, idConsejo);
		}

		if (fechaConv != null) {
			query.setParameter(2, fechaConv);
		}

		System.out.println("ANTES DE EJECUTAR");

		return query.getResultList();
	}

	@Override
	public List<OrdenDia> getListaOrdenDiaConv(ConvocatoriaVoto conv) {
		Hibernate.initialize(conv.getOrdenDias());
		return conv.getOrdenDias();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConvocatoriaVoto> findAllConvocatorias() {
		Query query = getEntityManager().createQuery(
				"SELECT conv FROM ConvocatoriaVoto conv ");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdenDia> findOrdenDiaByParams(int idConv) {

		StringBuilder queryString = new StringBuilder(
				"SELECT ord FROM OrdenDia ord WHERE ord.convocatoria.idCon =?0 ORDER BY ord.nroPunto ");

		if (idConv == 0) {
			return null;
		}

		Query query = getEntityManager().createQuery(queryString.toString());

		if (idConv != 0) {
			query.setParameter(0, idConv);
		}

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Consejo> findAllConsejo() {
		Query query = getEntityManager().createQuery(
				"SELECT csj FROM Consejo csj");
		return query.getResultList();
	}

	@Override
	public void insertConvocatoria(ConvocatoriaVoto conv) {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(conv.idCon) FROM ConvocatoriaVoto conv");
		Integer idConv = null;
		try {
			idConv = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idConv = null;
		}
		if (idConv == null) {
			idConv = 1;
		} else {
			++idConv;
		}

		// Url_conv
		String url = " ";

		conv.setIdCon(idConv);
		conv.setUrlConvocatoria(url);
		getEntityManager().persist(conv);

	}

	@Override
	public void updateConvocatoria(ConvocatoriaVoto conv) {
		getEntityManager().merge(conv);

	}

	@Override
	public void deleteConvocatoria(ConvocatoriaVoto conv) {
		try {
			Query q = getEntityManager().createQuery(
					"DELETE FROM ConvocatoriaVoto conv WHERE conv.idCon =?0 ");

			q.setParameter(0, conv.getIdCon());
			q.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);

		}
		
	}
	
	
	

}
