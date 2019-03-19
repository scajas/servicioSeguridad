package ec.edu.epn.desarrollo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.desarrollo.entities.DetalleRequerimiento;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.Resultado;

/**
 * Session Bean implementation class DetalleRequerimientoDAOImplement
 */
@Stateless
@LocalBean
public class DetalleRequerimientoDAOImplement extends DaoGenericoImplement<DetalleRequerimiento> implements DetalleRequerimientoDAO {

	
	@Override
	public List<DetalleRequerimiento> consultarDetallesbyReq(Integer idreq) {

		StringBuilder querys = new StringBuilder("SELECT e From DetalleRequerimiento e where e.requerimiento.id = ?1  order by e.id" );

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idreq);

		return query.getResultList();
		
		
		
	}
    
}
