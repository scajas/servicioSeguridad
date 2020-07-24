/**
 * 
 */
package ec.edu.epn.emergencia.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.emergencia.entidades.Autoridade;
import ec.edu.epn.emergencia.entidades.AutorizacionEmergencia;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Ecivil;



/**
 * @author Andres Cevallos
 * 
 */
@Stateless
public class AutoridadeDAOImplement extends DaoGenericoImplement<Autoridade> implements
		AutoridadeDAO {
	
	
	@Override
	public List<Autoridade> findAutorizaciones() {
		Query q = getEntityManager().createQuery(
				"Select dep from Autoridade dep ");

		return q.getResultList();
	}
	
	
	
	@Override
	public Autoridade findAutoridadxCedula(String identificacion) {
		Query q = getEntityManager().createQuery(
				"Select dep from Autoridade dep where identificacion = :identificacion");
		q.setParameter("identificacion", identificacion);
		return (Autoridade) q.getSingleResult();
	}
	

}
