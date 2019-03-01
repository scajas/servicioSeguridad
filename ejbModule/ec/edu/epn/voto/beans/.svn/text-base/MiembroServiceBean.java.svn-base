package ec.edu.epn.voto.beans;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.epn.voto.entities.Asistencia;
import ec.edu.epn.voto.entities.Consejo;
import ec.edu.epn.voto.entities.MiembroVoto;

/**
 * Session Bean implementation class OrdenTrabajoServiceBean
 */
@Stateless
public class MiembroServiceBean implements MiembroService {

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MiembroVoto> findConcejoXCIMiembro(String cedulaMiembro) {
		Query q = em
				.createQuery("SELECT m.idMiembro, m.consejo.idConsejo, m.nced, m.rol, m.pos, m.numSilla FROM MiembroVoto as m where m.nced=? group by m.consejo.idConsejo,m.idMiembro, m.consejo.idConsejo, m.nced, m.rol, m.pos, m.numSilla");
		q.setParameter(1, cedulaMiembro);
		return (List<MiembroVoto>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MiembroVoto> findConcejo(String cedulaMiembro) {
		Query q = em.createQuery("Select m from MiembroVoto m where m.nced=?");
		q.setParameter(1, cedulaMiembro);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> findidsConcejo(String cedulaMiembro) {
		Query q = em
				.createQuery("Select m.consejo.idConsejo from MiembroVoto m where m.nced=? group by m.consejo.idConsejo");
		q.setParameter(1, cedulaMiembro);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MiembroVoto> findMiembro() {
		Query q = em.createQuery("Select m from MiembroVoto m order by m.apellido ");
		return q.getResultList();
	}

	@Override
	public void guardarMiembro(MiembroVoto miembro) {
		em.persist(miembro);
		System.out.println("Nuevo miembro de consejo ingresado!!!!!!!");
	}

	@Override
	public void eliminarMiembro(MiembroVoto miembro) {
		try {
			Query q = getEntityManager().createQuery(
					"DELETE FROM MiembroVoto m where m.idMiembro = ?0");
			q.setParameter(0, miembro.getIdMiembro());
			q.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);

		}
		System.out.println("MiembroVoto Eliminada...");

	}

	@Override
	public void actualizarMiembro(MiembroVoto miembro) {
		em.merge(miembro);
		System.out.println("MiembroVoto actualizado!!!!!!!!!!!!");

	}

	@Override
	public int maxMiembro() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(mi.idMiembro) FROM MiembroVoto mi");
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

	@SuppressWarnings("unchecked")
	@Override
	public List<MiembroVoto> findMiembroExiste(String cedulaMiembro,
			Integer id_consejo) {
		Query q = em
				.createQuery("Select m from MiembroVoto m where m.nced=?0 and m.consejo.idConsejo =?1 ");
		q.setParameter(0, cedulaMiembro);
		q.setParameter(1, id_consejo);

		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MiembroVoto> findMiembroPreside() {
		List<String> ids = new ArrayList<String>();
		ids.add("RECTOR");
		ids.add("VICERRECTOR DE DOCENCIA");
		ids.add("VICERRECTOR DE INVESTIGACION Y PROYECCION SOCIAL");
		
		
		Query q = em
				.createQuery("Select m from MiembroVoto m where m.rol IN :list  Order by m.rol ");
		q.setParameter("list", ids);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Consejo> findAllConsejo() {
		Query query = getEntityManager().createQuery(
				"SELECT csj FROM Consejo csj");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MiembroVoto> findMiembroConsejo(Integer id_consejo) {
		Query q = em
				.createQuery("Select m from MiembroVoto m where  m.consejo.idConsejo =?1 ");

		q.setParameter(1, id_consejo);

		return q.getResultList();
	}

	@Override
	public void guardarAsistencia(Asistencia asis) {
		em.persist(asis);
		System.out.println("Asistencia ingresada!!!!!!!");
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

}