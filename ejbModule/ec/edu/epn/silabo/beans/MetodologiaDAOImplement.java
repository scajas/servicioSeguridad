package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.Bibliografia;
import ec.edu.epn.silabo.entities.MetodologiaDeEnsenanza;

/**
 * Session Bean implementation class MetodologiaDAOImplement
 */
@Stateless
@LocalBean
public class MetodologiaDAOImplement extends DaoGenericoImplement<MetodologiaDeEnsenanza> implements MetodologiaDAO {

	@Override
	public List<MetodologiaDeEnsenanza> consultarMetodologia(Integer idsilado) {

		StringBuilder querys = new StringBuilder("SELECT e From MetodologiaDeEnsenanza e where e.silabo.idSilabo = ?1   order by e.idMetodologia " );

	
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);
	

		return query.getResultList();
		
		
		
	}
	
	@Override
	public int maxIdMetodologia() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idMetodologia) FROM MetodologiaDeEnsenanza p");
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
