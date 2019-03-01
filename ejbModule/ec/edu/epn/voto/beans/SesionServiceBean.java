package ec.edu.epn.voto.beans;

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
public class SesionServiceBean implements SesionService {

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public Sesion listaSesionAsistencia(int id_concejo) {
		Query q = em
				.createQuery("select s from Sesion s where s.convocatoria.consejo.idConsejo=?1");
		q.setParameter(1, id_concejo);
		System.out.println("Sesiones de Usuario Logeado !!!!!!!!!!!!!!!!"
				+ q.getResultList().size());
		return (Sesion) q.getSingleResult();
	}

	@Override
	public List<Sesion> listaSesiones() {
		Query q = em.createQuery("select s from Sesion s ");
		return q.getResultList();
	}

	@Override
	public List<Sesion> listaSesionescedula(int idConsejo) {
		Query q = em.createQuery("select s" + " from Sesion "
				+ " where s.convocatoria.consejo.idConsejo=?1");
		q.setParameter(1, idConsejo);
		System.out.println("Sesiones de Usuario Logeado !!!!!!!!!!!!!!!!"
				+ q.getResultList().size());
		return q.getResultList();
	}

	@Override
	public Integer findIDConcejoSesionXIDSesion(int idSesion) {
		Query q = em
				.createQuery("Select s.convocatoria.consejo.idConsejo from Sesion s where s.idSesion=?");
		q.setParameter(1, idSesion);
		return (Integer) q.getSingleResult();
	}
}
// select a from Autorizacion as a
//
// join fetch a.perfil p
// join fetch a.menu m
// join fetch m.aplicacion
//
// where p.nombre=?1 and p.activo='SI' and m.activo='SI' order by
// COALESCE(m.menuPadre.id,0), m.orden"