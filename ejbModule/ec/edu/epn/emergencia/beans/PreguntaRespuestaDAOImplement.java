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
import ec.edu.epn.generic.DAO.DaoGenericoImplement;



/**
 * @author Andres Cevallos
 * 
 */
@Stateless
public class PreguntaRespuestaDAOImplement extends DaoGenericoImplement<PreguntaRespuesta> implements
		PreguntaRespuestaDAO {

	@Override
	public List<PreguntaRespuesta> findPreguntasRespuesta() {
		Query q = getEntityManager().createQuery(
				"Select dep from PreguntaRespuesta dep");
		
		return q.getResultList();
	}
	
}
