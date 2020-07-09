/**
 * 
 */
package ec.edu.epn.emergencia.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.emergencia.entidades.AsistenciaEmergencia;
import ec.edu.epn.emergencia.entidades.AutorizacionEmergencia;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Ecivil;



/**
 * @author Andres Cevallos
 * 
 */
@Stateless
public class AsistenciaEmergenciaDAOImplement extends DaoGenericoImplement<AsistenciaEmergencia> implements
		AsistenciaEmergenciaDAO {

	@Override
	public List<AsistenciaEmergencia> findAsistencia() {
		Query q = getEntityManager().createQuery(
				"Select dep from AsistenciaEmergencia dep ");

		return q.getResultList();
	}

	@Override
	public List<AsistenciaEmergencia> getAsistenciasByDate(Date fechaDesde, Date fechaHasta, String nced, 
			char tipoPersona) {
		String queryPredicate = "";
		if(tipoPersona!='T') {
			queryPredicate = " and asist.autorizacion.tipoPersona = '" + tipoPersona +"'";
		}
		
		StringBuilder queryString = null;
		if(nced!=null) {
			queryString = new StringBuilder(
					"   SELECT asist "
					+ " from AsistenciaEmergencia asist where asist.autorizacion.nced = :cedula "
					+ " and asist.fechaIngreso BETWEEN :fechaDesde and :fechaHasta ");
			
		}else {
			queryString = new StringBuilder(
					"   SELECT asist "
					+ " from AsistenciaEmergencia asist "
					+ " where asist.fechaIngreso BETWEEN :fechaDesde and :fechaHasta ");
		}
		queryString.append(queryPredicate);			
		Query query = getEntityManager().createQuery(queryString.toString());
		if(nced!=null) {
			query.setParameter("cedula", nced);	
		}	
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta", fechaHasta);
		List<AsistenciaEmergencia> resultados = query.getResultList();
		return 	resultados;
		
	}

}
