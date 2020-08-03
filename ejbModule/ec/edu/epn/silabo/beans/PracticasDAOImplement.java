package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.PracticasLaboratorio;
import ec.edu.epn.silabo.entities.Resultado;

/**
 * Session Bean implementation class PracticasDAOImplement
 */
@Stateless
@LocalBean
public class PracticasDAOImplement  extends DaoGenericoImplement<PracticasLaboratorio> implements PracticasDAO {

	
	@Override
	public List<PracticasLaboratorio> consultarPracticas(Integer idsilado) {

		StringBuilder querys = new StringBuilder("SELECT e From PracticasLaboratorio e where e.silabo.idSilabo = ?1  order by e.idPractica" );

		

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);

		return query.getResultList();
		
		
		
	}
	
	@Override
	public int maxIdPracticas() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idPractica) FROM PracticasLaboratorio p");
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
