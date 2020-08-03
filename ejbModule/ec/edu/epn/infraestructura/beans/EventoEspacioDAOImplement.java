/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.Espacio;
import ec.edu.epn.infraestructura.entities.EstadoEvento;
import ec.edu.epn.infraestructura.entities.Evento;
import ec.edu.epn.infraestructura.entities.EventoEspacio;
import ec.edu.epn.infraestructura.entities.ResponsableInfra;
import ec.edu.epn.infraestructura.entities.TipoEvento;

/**
 * @author Administrador
 * 
 */
@Stateless
public class EventoEspacioDAOImplement extends
		DaoGenericoImplement<EventoEspacio> implements EventoEspacioDAO {

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(ee.idEventoespacio) FROM EventoEspacio ee");
		Integer idEdificio = null;

		try {
			idEdificio = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idEdificio = null;
		}
		if (idEdificio == null) {
			idEdificio = 1;
		} else {
			++idEdificio;
		}
		return idEdificio;
	}

	@Override
	public EventoEspacio buscarXIDS(Evento ev, Espacio esp) {
		StringBuilder queryString = new StringBuilder(
				"SELECT ee FROM EventoEspacio ee where ee.evento.idEventos=?1 and ee.espacio.idEspacio=?2");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, ev.getIdEventos());
		query.setParameter(2, esp.getIdEspacio());

		return (EventoEspacio) query.getSingleResult();
	}

	@Override
	public List<EventoEspacio> buscarXIDEVENTO(Evento ev) {
		StringBuilder queryString = new StringBuilder(
				"SELECT ee FROM EventoEspacio ee where ee.evento.idEventos=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, ev.getIdEventos());

		return query.getResultList();
	}

	@Override
	public List<EventoEspacio> buscarxparametros(Evento evento,
			ResponsableInfra responsable, EstadoEvento estadoEvento,
			TipoEvento tipoEvento) {
		Query query = null;
		StringBuilder queryString = null;

		queryString = new StringBuilder(
				"SELECT eventEsp FROM EventoEspacio eventEsp where eventEsp.evento.nomEvento like ?1 ");

		if (responsable != null) {
			queryString
					.append(" and  eventEsp.evento.responsable.cedulaResp like ?2 ");
		}

		if (tipoEvento != null) {
			queryString
					.append(" and eventEsp.evento.tipoEvento.idTevento like ?3 ");
		}
		if (estadoEvento != null) {
			queryString
					.append(" and eventEsp.evento.estadoEvento.idEvento like ?4 ");
		}

		if (evento != null) {
			if (evento.getFechaInicioEvento() != null
					& evento.getFechaFinEvento() != null) {
				queryString
						.append(" and eventEsp.evento.fechaInicioEvento BETWEEN ?5 AND ?6  or eventEsp.evento.fechaFinEvento BETWEEN ?7 AND ?8");
			}
		}

		query = getEntityManager().createQuery(queryString.toString());

		if (evento != null && !evento.getNomEvento().equals("")) {
			query.setParameter(1, "%" + evento.getNomEvento() + "%");
		} else
			query.setParameter(1, "%");
		if (responsable != null) {
			query.setParameter(2, responsable.getCedulaResp() + "%");
		}

		if (tipoEvento != null) {
			query.setParameter(3, tipoEvento.getIdTevento());
		}

		if (estadoEvento != null) {
			query.setParameter(4, estadoEvento.getIdEvento());
		}
		if (evento != null) {
			if (evento.getFechaInicioEvento() != null
					&& evento.getFechaFinEvento() != null) {
				query.setParameter(5, evento.getFechaInicioEvento());
				query.setParameter(6, evento.getFechaFinEvento());
				query.setParameter(7, evento.getFechaInicioEvento());
				query.setParameter(8, evento.getFechaFinEvento());

			}
		}

		return query.getResultList();
	}

	@Override
	public List<EventoEspacio> buscarxidEspacio(Espacio esp) {
		StringBuilder queryString = new StringBuilder(
				"SELECT ee FROM EventoEspacio ee where ee.espacio.idEspacio=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, esp.getIdEspacio());

		return query.getResultList();
	}

}
