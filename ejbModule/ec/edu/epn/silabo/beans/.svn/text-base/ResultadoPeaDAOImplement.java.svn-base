package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.Resultado;
import ec.edu.epn.silabo.entities.ResultadosPea;

/**
 * Session Bean implementation class ResultadoPeaDAOImplement
 */
@Stateless
@LocalBean
public class ResultadoPeaDAOImplement  extends DaoGenericoImplement<ResultadosPea> implements ResultadoPeaDAO {

	@Override
	public List<ResultadosPea> consultarResultados(Integer idPea) {

		StringBuilder querys = new StringBuilder("SELECT e From ResultadosPea e where e.pea.idPea = ?1  order by e.idResultados" );

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idPea);

		return query.getResultList();
		
		
		
	}

}
