package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Escala;



public @Stateless class EscalaServiceBean implements EscalaService {
	
	
	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Escala> listaEscalas() {
	
		String tit = "%";

		StringBuilder queryString = new StringBuilder(
				"SELECT e FROM Escala e where e.titulo like ?0 ");
		
		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + tit + "%");
		return query.getResultList();
	}


	@Override
	public double rmuAsistCatedra() {
		StringBuilder queryString = new StringBuilder("SELECT e.remuneracion FROM Escala e WHERE e.idEscala = 9 ");
		
		Query query = getEntityManager().createQuery(queryString.toString());		
		return (Double) query.getSingleResult();
	}
	
	
}
