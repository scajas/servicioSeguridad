package ec.edu.epn.voto.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ec.edu.epn.voto.entities.Asistencia;
import ec.edu.epn.voto.entities.Consejo;

/**
 * Session Bean implementation class OrdenTrabajoServiceBean
 */
@Stateless
public class ConsejoServiceBean implements ConsejoService {

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public List<Consejo> listaConsejo() {
		Query q = em.createQuery("Select con from Consejo con");
		return q.getResultList();
	}

	@Override
	public void eliminarConsejo(int idConsejo) {
		try {
			Query q = getEntityManager().createQuery(
					"DELETE FROM Consejo as con where con.idConsejo = ?0");
			q.setParameter(0, idConsejo);
			q.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);

		}
		System.out.println("Consejo Eliminado...");

	}

	@Override
	public void actualizarConsejo(Consejo consejo) {
		em.merge(consejo);
		System.out.println("Consejo actualizado!!!!!");

	}

	@Override
	public void guardarNUevoConsejo(Consejo consejo) {
		em.persist(consejo);
		System.out.println("Se ingreso un nuevo consejo!!!!!!");

	}

	@Override
	public int maxConsejo() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(c.idConsejo) FROM Consejo c");
		Integer idAsistencia = null;

		try {
			idAsistencia = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idAsistencia = null;
		}
		if (idAsistencia == null) {
			idAsistencia = 1;
		} else {
			++idAsistencia;
		}
		return idAsistencia;
	}

}
