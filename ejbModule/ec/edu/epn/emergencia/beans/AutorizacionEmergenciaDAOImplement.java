/**
 * 
 */
package ec.edu.epn.emergencia.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.emergencia.entidades.AutorizacionEmergencia;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Ecivil;



/**
 * @author Andres Cevallos
 * 
 */
@Stateless
public class AutorizacionEmergenciaDAOImplement extends DaoGenericoImplement<AutorizacionEmergencia> implements
		AutorizacionEmergenciaDAO {
	
	
	@Override
	public List<AutorizacionEmergencia> findAutorizaciones() {
		Query q = getEntityManager().createQuery(
				"Select dep from AutorizacionEmergencia dep ");

		return q.getResultList();
	}
	
	@Override
	public List<AutorizacionEmergencia> findAutorizacionesXCedula(String cedula) {
		Query q = getEntityManager().createQuery(
				"Select dep from AutorizacionEmergencia dep where dep.nced = :cedula");
		q.setParameter("cedula", cedula);	  
		return q.getResultList();
	}
	
	@Override
	public Integer getMaxId() {
		StringBuilder queryString = new StringBuilder(
				"SELECT max(idAutorizacion) FROM AutorizacionEmergencia fam ");
		Query query = getEntityManager().createQuery(queryString.toString());
		Integer max = (Integer) query.getSingleResult();
		if (max == null)
			return 0;
		else
			return max;
	}
	

}
