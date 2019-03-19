package ec.edu.epn.desarrollo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.desarrollo.entities.EstadoReq;
import ec.edu.epn.desarrollo.entities.ReqPersona;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class EsatdoReqDAOImplement
 */
@Stateless
@LocalBean
public class EsatdoReqDAOImplement extends DaoGenericoImplement<EstadoReq> implements EsatdoReqDAO {

	@Override
	public List<EstadoReq> consultarDetallesbyReq(Integer idreq) {

		StringBuilder querys = new StringBuilder("SELECT e From EstadoReq e where e.reqPersona.id = ?1  order by e.id" );

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idreq);

		return query.getResultList();
		
		
		
	}
	
	@Override
	public List<EstadoReq> consultarDetallesbyReqExiste(Integer idEstado, Integer idreq) {

		StringBuilder querys = new StringBuilder("SELECT e From EstadoReq e where e.reqPersona.id = ?1 and e.estado.id = ?2 order by e.id" );

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idreq);
		query.setParameter(2, idEstado);

		return query.getResultList();
		
		
		
	}
	
	@Override
	public List<EstadoReq> consultarDetallesbyReqFinal(Integer idEstado, Integer idreq) {

		StringBuilder querys = new StringBuilder("SELECT e From EstadoReq e where e.reqPersona.requerimiento.id = ?1 and e.estado.id = ?2 order by e.id" );

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idreq);
		query.setParameter(2, idEstado);

		return query.getResultList();
		
		
		
	}
}
