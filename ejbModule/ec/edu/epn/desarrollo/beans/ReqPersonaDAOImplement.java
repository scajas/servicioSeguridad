package ec.edu.epn.desarrollo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.desarrollo.entities.DetalleRequerimiento;
import ec.edu.epn.desarrollo.entities.ReqPersona;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class ReqPersonaDAOImplement
 */
@Stateless
@LocalBean
public class ReqPersonaDAOImplement extends DaoGenericoImplement<ReqPersona> implements ReqPersonaDAO {

	@Override
	public List<ReqPersona> consultarDetallesbyReq(Integer idreq) {

		StringBuilder querys = new StringBuilder("SELECT e From ReqPersona e where e.requerimiento.id = ?1  order by e.id" );

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idreq);

		return query.getResultList();
		
		
		
	}
	
	
	@Override
	public List<ReqPersona> consultarDetallesbyDev(String nced) {

		StringBuilder querys = new StringBuilder("SELECT e From ReqPersona e where e.personal.empleado.nced = ?1  order by e.id" );

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, nced);

		return query.getResultList();
		
		
		
	}
	
	
	@Override
	public List<ReqPersona> consultarReqAsignadosByEstado(String estado) {

		StringBuilder querys = new StringBuilder("SELECT e From ReqPersona e where e.requerimiento.idestado = ?1  order by e.id" );

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, estado.trim());

		return query.getResultList();
		
		
		
	}

}
