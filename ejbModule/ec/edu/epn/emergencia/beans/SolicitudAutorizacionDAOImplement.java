/**
 * 
 */
package ec.edu.epn.emergencia.beans;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.emergencia.entidades.AutorizacionEmergencia;
import ec.edu.epn.emergencia.entidades.HorarioEmergencia;
import ec.edu.epn.emergencia.entidades.Pregunta;
import ec.edu.epn.emergencia.entidades.PreguntaRespuesta;
import ec.edu.epn.emergencia.entidades.SolicitudAutorizacion;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;



/**
 * @author Andres Cevallos
 * 
 */
@Stateless
public class SolicitudAutorizacionDAOImplement extends DaoGenericoImplement<SolicitudAutorizacion> implements
		SolicitudAutorizacionDAO {


	@Override
	public List<SolicitudAutorizacion> findSolicitudes() {
		Query q = getEntityManager().createQuery(
				"Select dep from SolicitudAutorizacion dep");
		
		return q.getResultList();
	}

	@Override
	public Integer getMaxId() {
		final StringBuilder queryString = new StringBuilder("SELECT max(idSolicitud) FROM SolicitudAutorizacion fam ");
        final Query query = this.getEntityManager().createQuery(queryString.toString());
        final Integer max = (Integer)query.getSingleResult();
        if (max == null) {
            return 0;
        }
        return max;
	}

	@Override
	public List<SolicitudAutorizacion> findSolicitudesxPersonaAutoriza(String cedula) {
		Query q = getEntityManager().createQuery(
				"Select dep from SolicitudAutorizacion dep where identificacionAprueba = :cedula and estado = 1");
		q.setParameter("cedula", cedula);
		
		return q.getResultList();
	}
	
	@Override
	public List<SolicitudAutorizacion> findSolicitudesxMedico() {
		Query q = getEntityManager().createQuery(
				"Select dep from SolicitudAutorizacion dep where estado = 2");
	
		
		return q.getResultList();
	}
	
	@Override
	public List<SolicitudAutorizacion> findSolicitudesxTalento() {
		Query q = getEntityManager().createQuery(
				"Select dep from SolicitudAutorizacion dep where estado = 3");
	
		
		return q.getResultList();
	}
	
	@Override
	public List<SolicitudAutorizacion> findSolicitudesxCedula(String cedula) {
		Query q = getEntityManager().createQuery(
				"Select dep from SolicitudAutorizacion dep where identificacion = :cedula ");
		q.setParameter("cedula", cedula);
		return q.getResultList();
	}
	
	
}
