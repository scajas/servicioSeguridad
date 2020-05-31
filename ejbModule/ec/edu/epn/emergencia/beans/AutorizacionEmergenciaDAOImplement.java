/**
 * 
 */
package ec.edu.epn.emergencia.beans;

import java.util.Date;
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
	public List<AutorizacionEmergencia> findAutorizacionesXCedulaXFechaDesdexFechaHasta(String cedula,Date fechaDesde, Date fechaHasta){
		StringBuilder query = new StringBuilder("Select dep from AutorizacionEmergencia dep ");
		
		if(cedula!=null && !cedula.equals("")) {
			query.append("where dep.nced = :cedula ");
		}
		if(fechaDesde!=null ) {
			if(cedula!=null && !cedula.equals("")) {
				query.append("and ");
			}
			else query.append("where ");
				
			query.append("dep.fechaHasta <= :fechaHasta ");
		}
		if(fechaHasta!=null) {
			if((cedula!=null && !cedula.equals("")) || fechaDesde!=null) {
				query.append("and ");
			}
			else query.append("where ");
			query.append("dep.fechaHasta >= :fechaDesde ");
		}
		
		Query q = getEntityManager().createQuery(query.toString());
		if(cedula!=null && !cedula.equals("")) {
			q.setParameter("cedula", cedula);
		}
		if(fechaHasta!=null) {
			q.setParameter("fechaDesde", fechaHasta);
		}
		if(fechaDesde!=null) {
			q.setParameter("fechaHasta", fechaDesde);
		}
		
		
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
