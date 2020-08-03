package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.Resultado;
import ec.edu.epn.silabo.entities.Silabo;

/**
 * Session Bean implementation class ResultadoDAOImplement
 */
@Stateless
@LocalBean
public class ResultadoDAOImplement extends DaoGenericoImplement<Resultado> implements ResultadoDAO {

	@Override
	public List<Resultado> consultarResultados(Integer idsilado) {

		StringBuilder querys = new StringBuilder("SELECT e From Resultado e where e.silabo.idSilabo = ?1  order by e.idResultados" );

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);

		return query.getResultList();
		
		
		
	}
	
	@Override
	public int maxResultado() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idResultados) FROM Resultado p");
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
