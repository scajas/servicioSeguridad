package ec.edu.epn.voto.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ec.edu.epn.voto.entities.Asistencia;
import ec.edu.epn.voto.entities.Sesion;

/**
 * Session Bean implementation class OrdenTrabajoServiceBean
 */
@Stateless
public class AsistenciaServiceBean implements AsistenciaService {

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public List<Asistencia> listaAsistencia() {
		Query q = em
				.createQuery("Select asis from Asistencia asis where asis.estado = ?1");
		q.setParameter(1, "PRESENTE");

		;
		return q.getResultList();
	}

	@Override
	public List<Asistencia> listaAsistenciaSesion(Date fechaActual,
			Integer Idconsejo, String estado) {

		StringBuilder queryString = new StringBuilder(
				"SELECT asis FROM Asistencia asis where asis.sesion.fechaSesion = ?0 and asis.miembro.consejo.idConsejo = ?1 and asis.estado = ?2");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, fechaActual);
		query.setParameter(1, Idconsejo);
		query.setParameter(2, estado);

		return query.getResultList();

	}
	
	@Override
	public List<Sesion> listaSesionConsejo(int idconsejo) {

		StringBuilder queryString = new StringBuilder(
				"SELECT ses FROM Sesion ses where ses.convocatoria.consejo.idConsejo = ?0 ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, idconsejo);
		
		return query.getResultList();

	}

	@Override
	public List<Asistencia> listaNoAsistencia() {
		Query q = em
				.createQuery("Select asis from Asistencia asis where asis.estado = ?1");
		q.setParameter(1, "AUSENTE");

		return q.getResultList();
	}

	@Override
	public List<Asistencia> listaTodosAsistencia() {
		Query q = em
				.createQuery("Select asis from Asistencia as asis join fetch asis.miembro as miemb order by miemb.numeroSilla asc");

		return q.getResultList();
	}

	@Override
	public List<Asistencia> listaAA1() {
		Query q = em
				.createQuery("Select asis from Asistencia asis where asis.estado = ?1");
		q.setParameter(1, "PRESENTE");

		return q.getResultList();
	}

	@Override
	public void guardarAsistencia(Asistencia asistencia) {
		em.persist(asistencia);

	}

	@Override
	public int maxAssitencia() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(a.idAsistencia) FROM Asistencia a");
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

	@Override
	public void actualizarAsistencia(Asistencia asistencia) {
		em.merge(asistencia);

	}

	@Override
	public List<Asistencia> listaAsistencia(String cedula) {
		Query q = em
				.createQuery("Select asis from Asistencia asis where asis.miembro.nced = ?1 and asis.estado=?2 and asis.sesion.estado =?3 order by asis.sesion.fechaSesion");
		q.setParameter(1, cedula);
		q.setParameter(2, "AUSENTE");
		q.setParameter(3, "ABIERTA");

		return q.getResultList();
	}

	@Override
	public void eliminarAsistencia(Asistencia asistencia) {
		try {
			Query q = getEntityManager().createQuery(
					"DELETE FROM Asistencia asi where asi.idAsistencia = ?0");
			q.setParameter(0, asistencia.getIdAsistencia());
			q.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@Override
	public List<Asistencia> constarAsisExiste(Integer id_sesion,
			Integer id_miembro) {
		StringBuilder queryString = new StringBuilder(
				"SELECT asis FROM Asistencia asis where asis.sesion.idSesion = ?0 and asis.miembro.idMiembro = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, id_sesion);
		query.setParameter(1, id_miembro);
		return query.getResultList();
	}

}
