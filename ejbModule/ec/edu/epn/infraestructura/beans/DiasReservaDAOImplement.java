/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.Dias_Reserva;
import ec.edu.epn.infraestructura.entities.Evento;

/**
 * @author Administrador
 * 
 */
@Stateless
public class DiasReservaDAOImplement extends DaoGenericoImplement<Dias_Reserva>
		implements DiasReservaDAO {

	@Override
	public int maxDiasReserva() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(diaR.idDiaReserva) FROM Dias_Reserva diaR");
		Integer idReservaDias = null;

		try {
			idReservaDias = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idReservaDias = null;
		}
		if (idReservaDias == null) {
			idReservaDias = 1;
		} else {
			++idReservaDias;
		}
		return idReservaDias;
	}

	@Override
	public List<Dias_Reserva> obtenerListaReservas(int idEspacio,
			Date fechaReservaI, Date fechaReservaF) {

		StringBuilder queryString = new StringBuilder(
				"SELECT diaR FROM Dias_Reserva diaR where diaR.eventoEspacio.espacio.idEspacio=?1 and "
						+ "diaR.fecha between ?2 and ?3 and diaR.estado = ?4");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idEspacio);
		query.setParameter(2, fechaReservaI);
		query.setParameter(3, fechaReservaF);
		query.setParameter(4, "ACTIVO");
	
		return query.getResultList();
	}

	@Override
	public List<Dias_Reserva> obtenerListaReservasConfirmados() {
		StringBuilder queryString = new StringBuilder(
				"SELECT diaR FROM Dias_Reserva diaR where diaR.eventoEspacio.evento.estadoEvento.idEvento in (1,3,4) and diaR.estado = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "ACTIVO");

		return query.getResultList();
	}

	@Override
	public List<Dias_Reserva> listarDiasReserva(Evento evento) {

		StringBuilder queryString = new StringBuilder(
				"SELECT diaR FROM Dias_Reserva diaR where diaR.eventoEspacio.evento.idEventos=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, evento.getIdEventos());

		return query.getResultList();
	}

	@Override
	public List<Dias_Reserva> obtenerXparametrosConfirmado(
			String cedulaResponsable, String nomTipoEvento, Date fecha) {
		StringBuilder queryString = new StringBuilder(
				"SELECT diaR FROM Dias_Reserva diaR where diaR.eventoEspacio.evento.estadoEvento.idEvento = ?0 ");

		if (!cedulaResponsable.equals("")) {

			queryString
					.append(" and diaR.eventoEspacio.evento.responsable.cedulaResp like ?1");
		}

		if (!nomTipoEvento.equals("")) {
		
			queryString
					.append(" and diaR.eventoEspacio.evento.tipoEvento.tipoEvento like ?2");
		}

		if (fecha != null) {
		
			queryString.append(" and diaR.fecha = ?3");
		}

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, 4);

		if (!cedulaResponsable.equals("")) {
		
			query.setParameter(1, "%" + cedulaResponsable + "%");
		}
		if (!nomTipoEvento.equals("")) {
		
			query.setParameter(2, "%" + nomTipoEvento + "%");
		}

		if (fecha != null) {
			
			query.setParameter(3, fecha);
		}

	
		return query.getResultList();
	}

	@Override
	public List<Dias_Reserva> obtenerListaXEvento(int idEvento) {
		StringBuilder queryString = new StringBuilder(
				"SELECT diaR FROM Dias_Reserva diaR where diaR.eventoEspacio.evento.idEventos = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idEvento);

		return query.getResultList();
	}

	@Override
	public List<Dias_Reserva> listarDiasReservaNoDetallados(Evento evento) {

		StringBuilder queryString = new StringBuilder(

				"SELECT diaR FROM Dias_Reserva diaR where diaR.eventoEspacio.evento.idEventos=?1 and diaR.idDiaReserva not in(SELECT DISTINCT (dae.diaReserva.idDiaReserva) from Detalle_Actividad_Evento dae)");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, evento.getIdEventos());
		
		return query.getResultList();

	}

	@Override
	public List<Dias_Reserva> listarDiasReservaActivos() {
		StringBuilder queryString = new StringBuilder(
				"SELECT diaR FROM Dias_Reserva diaR where diaR.estado = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "ACTIVO");

		return query.getResultList();
	}
}
