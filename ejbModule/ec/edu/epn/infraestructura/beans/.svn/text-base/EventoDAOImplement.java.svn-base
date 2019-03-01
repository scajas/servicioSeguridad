/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.EdificioInfra;
import ec.edu.epn.infraestructura.entities.Espacio;
import ec.edu.epn.infraestructura.entities.EstadoEspacio;
import ec.edu.epn.infraestructura.entities.EstadoEvento;
import ec.edu.epn.infraestructura.entities.Evento;
import ec.edu.epn.infraestructura.entities.EventoEspacio;
import ec.edu.epn.infraestructura.entities.PisoInfra;
import ec.edu.epn.infraestructura.entities.ResponsableInfra;
import ec.edu.epn.infraestructura.entities.TipoEspacio;
import ec.edu.epn.infraestructura.entities.TipoEvento;

/**
 * @author Administrador
 * 
 */
@Stateless
public class EventoDAOImplement extends DaoGenericoImplement<Evento> implements EventoDAO {

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(evento.idEventos) FROM Evento evento");

		Integer idReq = null;
		try {
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}
		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public List<Evento> listarEvento() {
		StringBuilder queryString = new StringBuilder("SELECT eves FROM Evento eves");
		Query query = getEntityManager().createQuery(queryString.toString());
		System.out.println("LISTA DE EVENTOS...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<Evento> listarSoloEventos() {
		StringBuilder queryString = new StringBuilder("SELECT ev FROM Evento ev");
		Query query = getEntityManager().createQuery(queryString.toString());
		System.out.println("LISTA DE EVENTOS...!!!!!!!!!!!!");

		return query.getResultList();
	}

	@Override
	public List<Evento> buscarEvento(int evento) {
		StringBuilder queryString = new StringBuilder("SELECT evento FROM Evento evento where evento.idEventos=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, evento);
		System.out.println("EVENTO CONSULTADO...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<Evento> buscarEventoXNombre(String evento) {
		StringBuilder queryString = new StringBuilder(
				"SELECT evento FROM Evento evento where evento.nomEvento like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + evento + "%");
		System.out.println("EVENTO CONSULTADO X NOMBRE EVENTO...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<Evento> buscarEventoXResponsable(String resp) {
		StringBuilder queryString = new StringBuilder(
				"SELECT evento FROM Evento evento where evento.responsable.cedulaResp like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, resp + "%");
		System.out.println("EVENTO CONSULTADO X CEDULA RESPONSABLE...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<Evento> buscarEventoXTipo(String tipoEvento) {
		StringBuilder queryString = new StringBuilder(
				"SELECT evento FROM Evento evento where evento.tipoEvento.tipoEvento=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, tipoEvento);
		System.out.println("EVENTO CONSULTADO X TIPO DE EVENTO...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<Evento> buscarEventoXEstado(String estado) {
		StringBuilder queryString = new StringBuilder(
				"SELECT evento FROM Evento evento where evento.estadoEvento.estadoEvento=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, estado);
		System.out.println("EVENTO CONSULTADO X ESTADO DEL EVENTO...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<Espacio> listaEspacios() {
		StringBuilder queryString = new StringBuilder("SELECT espacio FROM Espacio espacio");
		Query query = getEntityManager().createQuery(queryString.toString());
		System.out.println("LISTA DE ESPACIOS DESDE EVENTOS...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<TipoEspacio> listaTipoEspacio() {
		StringBuilder queryString = new StringBuilder("SELECT tespacio FROM TipoEspacio tespacio");
		Query query = getEntityManager().createQuery(queryString.toString());
		System.out.println("LISTA DE TIPOESPACIOS DESDE EVENTOS...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<EstadoEspacio> listaEstadoEspacio() {
		StringBuilder queryString = new StringBuilder("SELECT eespacio FROM EstadoEspacio eespacio");
		Query query = getEntityManager().createQuery(queryString.toString());
		System.out.println("LISTA DE ESTADOESPACIOS DESDE EVENTOS...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<EdificioInfra> listaEdificio() {
		StringBuilder queryString = new StringBuilder("SELECT edif FROM Edificio edif");
		Query query = getEntityManager().createQuery(queryString.toString());
		System.out.println("LISTA DE EDIFICIOS DESDE EVENTOS...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<PisoInfra> listaPiso() {
		StringBuilder queryString = new StringBuilder("SELECT piso FROM Piso piso");
		Query query = getEntityManager().createQuery(queryString.toString());
		System.out.println("LISTA DE PISOS DESDE EVENTOS...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public boolean buscarEventoXFechas(Evento ev) {
		try {
			Query query = getEntityManager().createQuery(
					"select ev from Evento ev where ev.fechaInicioEvento between ?1 and ?2 or ev.fechaFinEvento between ?3 and ?4 or ?5 between ev.fechaInicioEvento and ev.fechaFinEvento or ?6 between ev.fechaInicioEvento and ev.fechaFinEvento");
			query.setParameter(1, ev.getFechaInicioEvento());
			query.setParameter(2, ev.getFechaFinEvento());
			query.setParameter(3, ev.getFechaInicioEvento());
			query.setParameter(4, ev.getFechaFinEvento());
			query.setParameter(5, ev.getFechaInicioEvento());
			query.setParameter(6, ev.getFechaFinEvento());

			Query query1 = getEntityManager().createQuery(
					"select ev from Evento ev where ev.horaInicioEvento between ?7 and ?8 or ev.hpraFinEvento between ?9 and ?10 or ?11 between ev.horaInicioEvento and ev.hpraFinEvento or ?12 between ev.horaInicioEvento and ev.hpraFinEvento");

			query1.setParameter(7, ev.getHoraInicioEvento());
			query1.setParameter(8, ev.getHpraFinEvento());
			query1.setParameter(9, ev.getHoraInicioEvento());
			query1.setParameter(10, ev.getHpraFinEvento());
			query1.setParameter(11, ev.getHoraInicioEvento());
			query1.setParameter(12, ev.getHpraFinEvento());

			System.out.println(
					"EVENTO CONSULTADO X FECHAS DEL EVENTO...!!!!!!!!!!!!: tamaño : " + query.getResultList().size());

			System.out.println(
					"EVENTO CONSULTADO X HORAS DEL EVENTO...!!!!!!!!!!!!: tamaño : " + query1.getResultList().size());
			List<Evento> listaEvn = new ArrayList<Evento>();
			listaEvn = query.getResultList();
			List<Evento> listaEvn1 = new ArrayList<Evento>();
			listaEvn1 = query1.getResultList();

			String match = "";

			if (listaEvn.size() > 0 && listaEvn1.size() > 0) {
				match = "SI";
			} else
				System.out.println("LISTA DE COMPARACIONES EVENTOS <= 0");

			if (match.equals("SI"))
				return false;
			else
				return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Evento buscarEventoXFIFFNombre(Date fechaI, Date fechaF, String nombre) {
		StringBuilder queryString = new StringBuilder(
				"select ev from Evento ev where ev.fechaInicioEvento = ?1 and ev.fechaFinEvento = ?2 and ev.nomEvento=?3");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, fechaI);
		query.setParameter(2, fechaF);
		query.setParameter(3, nombre);
		System.out
				.println("LISTA DE EVENTOS X NOMBRE FECHA INICIO Y FIN...!!!!!!!!!!!!" + query.getResultList().size());
		return (Evento) query.getSingleResult();
	}

	@Override
	public List<Evento> buscarEventoXFechaInicio(Evento ev) {
		StringBuilder queryString = new StringBuilder("select ev from Evento ev where ev.fechaInicioEvento = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, ev.getFechaInicioEvento());
		System.out
				.println("LISTA DE EVENTOS X NOMBRE FECHA INICIO Y FIN...!!!!!!!!!!!!" + query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public List<Evento> buscarEventoXFechaFin(Evento ev) {
		StringBuilder queryString = new StringBuilder("select ev from Evento ev where ev.fechaFinEvento = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, ev.getFechaFinEvento());
		System.out
				.println("LISTA DE EVENTOS X NOMBRE FECHA INICIO Y FIN...!!!!!!!!!!!!" + query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public List<Evento> listarEventoSINAlquiler() {
		StringBuilder queryString = new StringBuilder(
				"select ev from Evento ev where ev.idEventos not IN (select alq.evento.idEventos from Alquiler alq)");
		Query query = getEntityManager().createQuery(queryString.toString());
		System.out.println("LISTA EVENTO SIN ALQUILER...!!!!!!!!!!!!");
		return query.getResultList();
	}

	// METODOS PARA BUSCAR CON EVENTS SIN ALQUILER
	@Override
	public List<Evento> buscarEventoXNombreSA(String evento) {
		StringBuilder queryString = new StringBuilder(
				"SELECT evento FROM Evento evento where evento.nomEvento like ?1 and evento.idEventos not IN (select alq.evento.idEventos from Alquiler alq)");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + evento + "%");
		System.out.println("EVENTO CONSULTADO X NOMBRE EVENTO SA...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<Evento> buscarEventoXResponsableSA(String resp) {
		StringBuilder queryString = new StringBuilder(
				"SELECT evento FROM Evento evento where evento.responsable.cedulaResp like ?1 and evento.idEventos not IN (select alq.evento.idEventos from Alquiler alq)");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, resp + "%");
		System.out.println("EVENTO CONSULTADO X CEDULA RESPONSABLE SA...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<Evento> buscarEventoXTipoSA(String tipoEvento) {
		StringBuilder queryString = new StringBuilder(
				"SELECT evento FROM Evento evento where evento.tipoEvento.tipoEvento=?1 and evento.idEventos not IN (select alq.evento.idEventos from Alquiler alq)");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, tipoEvento);
		System.out.println("EVENTO CONSULTADO X TIPO DE EVENTO... SA!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<Evento> buscarEventoXEstadoSA(String estado) {
		StringBuilder queryString = new StringBuilder(
				"SELECT evento FROM Evento evento where evento.estadoEvento.estadoEvento=?1 and evento.idEventos not IN (select alq.evento.idEventos from Alquiler alq) ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, estado);
		System.out.println("EVENTO CONSULTADO X ESTADO DEL EVENTO...SA!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<Evento> buscarEventoXFechaInicioSA(Evento ev) {
		StringBuilder queryString = new StringBuilder(
				"select ev from Evento ev where ev.fechaInicioEvento = ?1 and ev.idEventos not IN (select alq.evento.idEventos from Alquiler alq)");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, ev.getFechaInicioEvento());
		System.out.println(
				"LISTA DE EVENTOS X NOMBRE FECHA INICIO Y FIN...SA!!!!!!!!!!!!" + query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public List<Evento> buscarEventoXFechaFinSA(Evento ev) {
		StringBuilder queryString = new StringBuilder(
				"select ev from Evento ev where ev.fechaFinEvento = ?1 and ev.idEventos not IN (select alq.evento.idEventos from Alquiler alq)");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, ev.getFechaFinEvento());
		System.out.println(
				"LISTA DE EVENTOS X NOMBRE FECHA INICIO Y FIN...SA!!!!!!!!!!!!" + query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public List<EventoEspacio> reporteEventoXFechas(Date fechaI, Date fechaF, TipoEvento tipo, ResponsableInfra resp) {
		StringBuilder queryString = new StringBuilder(
				"select ev from EventoEspacio ev where evento.descripcion like ?1 ");
		if (resp != null) {
			System.out.println("RESPONSABLE:" + resp.getCedulaResp());
			queryString.append(" and ev.evento.responsable.cedulaResp = ?2");
		}
		if (tipo != null) {
			System.out.println("TIPO ENVENTO:" + tipo.getIdTevento());
			queryString.append(" and ev.evento.tipoEvento.idTevento = ?3");
		}
		if (fechaI != null && fechaF != null) {
			System.out.println("FECHAS: " + fechaI + "-" + fechaF);
			queryString.append(" and ev.evento.fechaReserveEvento between ?4 and ?5 ");
		}
		System.out.println("CONSULTA: " + queryString.toString());

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%");

		if (resp != null) {
			query.setParameter(2, resp.getCedulaResp());
		}
		if (tipo != null) {
			query.setParameter(3, tipo.getIdTevento());
		}
		if (fechaI != null && fechaF != null) {

			query.setParameter(4, fechaI);
			query.setParameter(5, fechaF);
		}

		System.out.println("REPORTE EVENTO CONSULTADO X FECHAS DEL EVENTO...!!!!!!!!!!!!: tamaño : "
				+ query.getResultList().size());

		return query.getResultList();
	}

	@Override
	public List<Evento> buscarEventoXFechaReserva(Evento ev) {
		StringBuilder queryString = new StringBuilder("select ev from Evento ev where ev.fechaReserveEvento = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, ev.getFechaFinEvento());
		System.out.println("LISTA DE EVENTOS X FECHA RESERVA...!!!!!!!!!!!!" + query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public List<Evento> buscarxparametros(Evento evento, ResponsableInfra reponsable, TipoEvento tipoEvento,
			EstadoEvento estadoEvento) {
		Query query = null;
		StringBuilder queryString = null;

		queryString = new StringBuilder("SELECT evento FROM Evento evento where evento.descripcion like ?1 ");

		if (evento != null && evento.getFechaReserveEvento() != null) {
			System.out.println("Evento: " + evento);
			queryString.append(" and  evento.fechaReserveEvento = ?2 ");
		}

		if (evento != null && !evento.getNomEvento().equals("")) {
			System.out.println("Evento: " + evento);
			queryString.append(" and  evento.nomEvento like ?3 ");
		}

		if (reponsable != null) {
			queryString.append(" and evento.responsable.cedulaResp like ?4 ");
		}

		if (tipoEvento != null) {
			queryString.append(" and evento.tipoEvento.tipoEvento like ?5 ");
		}

		if (estadoEvento != null) {
			queryString.append(" and evento.estadoEvento.estadoEvento like ?6 ");
		}

		System.out.println("CONSULTA: " + queryString.toString());

		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%");

		if (evento != null && evento.getFechaReserveEvento() != null) {
			query.setParameter(2, evento.getFechaReserveEvento());
		}
		if (evento != null && !evento.getNomEvento().equals("")) {
			query.setParameter(3, "%" + evento.getNomEvento() + "%");
		}

		if (reponsable != null) {
			query.setParameter(4, "%" + reponsable.getCedulaResp() + "%");
		}

		if (tipoEvento != null) {
			query.setParameter(5, "%" + tipoEvento.getTipoEvento() + "%");
		}
		if (estadoEvento != null) {
			query.setParameter(6, "%" + estadoEvento.getEstadoEvento() + "%");
		}

		System.out.println("Eventos recuperados");
		return query.getResultList();
	}

	@Override
	public List<Evento> buscarEventoXEstadoNoConfirmado() {
		StringBuilder queryString = new StringBuilder(
				"SELECT evento FROM Evento evento where evento.estadoEvento.estadoEvento=?1 or evento.estadoEvento.estadoEvento=?2");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "RESERVADO");
		query.setParameter(2, "CONFIRMADO POR DETALLAR");
		System.out.println("EVENTO CONSULTADO X ESTADO DEL EVENTO...!!!!!!!!!!!!");
		return query.getResultList();
	}

}
