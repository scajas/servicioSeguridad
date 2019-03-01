package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.Capitulo;
import ec.edu.epn.silabo.entities.Resultado;

/**
 * Session Bean implementation class CapituloDAOImplement
 */
@Stateless
@LocalBean
public class CapituloDAOImplement extends DaoGenericoImplement<Capitulo> implements CapituloDAO {

	@Override
	public List<Capitulo> consultarCapitulos(Integer idsilado) {

		StringBuilder querys = new StringBuilder("SELECT e From Capitulo e where e.silabo.idSilabo = ?1  order by e.numeroCap " );

		

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);

		return query.getResultList();
		
		
		
	}
	
	
	@Override
	public List<Capitulo> consultarCapitulosExiste(Integer idsilado, Integer num) {

		StringBuilder querys = new StringBuilder("SELECT e From Capitulo e where e.silabo.idSilabo = ?1  and e.numeroCap = ?2 " );

		

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);
		query.setParameter(2, num);

		return query.getResultList();
		
		
		
	}
	
	
	
	@Override
	public int maxIdCapitulo() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idCapitulo) FROM Capitulo p");
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
