/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.Detalle_Actividad_Evento;
import ec.edu.epn.infraestructura.entities.Evento;

/**
 * @author Administrador
 * 
 */
@Stateless
public class DetalleActividadDAOImplement extends
		DaoGenericoImplement<Detalle_Actividad_Evento> implements
		DetalleActividadDAO {

	@Override
	public int maxDetalleActividad() {
		Query q = getEntityManager()
				.createQuery(
						"SELECT MAX(detalleAct.idActividad) FROM Detalle_Actividad_Evento detalleAct");
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
	public List<Detalle_Actividad_Evento> buscarDetalleXEvento(Evento evento) {
		StringBuilder queryString = new StringBuilder(
				"SELECT detalq FROM Detalle_Actividad_Evento detalq where detalq.diaReserva.eventoEspacio.evento.idEventos = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, evento.getIdEventos());
		return query.getResultList();
	}

}
