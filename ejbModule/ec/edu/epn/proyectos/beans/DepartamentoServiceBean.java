package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.epn.proyectos.entities.Convocatoria;
import ec.edu.epn.rrhh.entities.Dep;

/**
 * Session Bean implementation class DepartamentoServiceBean
 */
@Stateless
public class DepartamentoServiceBean implements DepartamentoService {

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Dep> departamentos() {

		StringBuilder queryString = new StringBuilder(
				"SELECT conv FROM Dep conv where conv.tipoDep = 'DEP'  ORDER BY conv.nomDep ");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();

	}

}
