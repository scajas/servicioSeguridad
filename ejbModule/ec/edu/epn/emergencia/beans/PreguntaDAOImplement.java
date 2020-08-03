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
import ec.edu.epn.generic.DAO.DaoGenericoImplement;



/**
 * @author Andres Cevallos
 * 
 */
@Stateless
public class PreguntaDAOImplement extends DaoGenericoImplement<Pregunta> implements
		PreguntaDAO {


	@Override
	public List<Pregunta> findPreguntasActivo() {
		Query q = getEntityManager().createQuery(
				"Select dep from Pregunta dep where dep.estado = 'ACTIVO'");
		
		return q.getResultList();
	}
	
}
