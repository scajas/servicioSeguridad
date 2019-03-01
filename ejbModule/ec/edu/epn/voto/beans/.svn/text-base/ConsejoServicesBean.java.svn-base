package ec.edu.epn.voto.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.epn.voto.beans.ConsejoServices;
import ec.edu.epn.voto.entities.Consejo;

@Stateless
public class ConsejoServicesBean implements ConsejoServices {

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Consejo> findAllConsejoConv() {
		StringBuilder queryString = new StringBuilder("SELECT c FROM Consejo c");

		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}

}
