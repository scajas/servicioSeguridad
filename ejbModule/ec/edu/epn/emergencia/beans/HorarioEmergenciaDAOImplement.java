/**
 * 
 */
package ec.edu.epn.emergencia.beans;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.emergencia.entidades.AutorizacionEmergencia;
import ec.edu.epn.emergencia.entidades.HorarioEmergencia;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;



/**
 * @author Andres Cevallos
 * 
 */
@Stateless
public class HorarioEmergenciaDAOImplement extends DaoGenericoImplement<HorarioEmergencia> implements
		HorarioEmergenciaDAO {

	@Override
	public List<HorarioEmergencia> findHorarioActivo() {
		Query q = getEntityManager().createQuery(
				"Select dep from HorarioEmergencia dep where dep.estado = 'ACTIVO'");
		
		return q.getResultList();
	}
	
}
