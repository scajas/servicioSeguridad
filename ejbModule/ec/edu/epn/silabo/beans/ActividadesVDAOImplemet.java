package ec.edu.epn.silabo.beans;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.ActividadesVinculacion;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * Session Bean implementation class ActividadesVDAOImplemet
 */
@Stateless
@LocalBean
public class ActividadesVDAOImplemet extends DaoGenericoImplement<ActividadesVinculacion> implements ActividadesVDAO {


	@Override
	public List<ActividadesVinculacion> consultarActividades(Integer idsilado) {

		StringBuilder querys = new StringBuilder("SELECT e From ActividadesVinculacion e where e.silabo.idSilabo = ?1  order by e.idActividades" );

		

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);

		return query.getResultList();
		
		
		
	}
	
	@Override
	public int maxIdActividades() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idActividades) FROM ActividadesVinculacion p");
		Integer idPagosV = null;

		try {
			idPagosV = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idPagosV = null;
		}
		if (idPagosV == null) {
			idPagosV = 1;
		} else {
			++idPagosV;
		}
		return idPagosV;
	}






	
	
	
}
