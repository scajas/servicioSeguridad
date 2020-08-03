package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.Capitulo;
import ec.edu.epn.silabo.entities.CapituloPea;

/**
 * Session Bean implementation class CapituloPeaDAOImplement
 */
@Stateless
@LocalBean
public class CapituloPeaDAOImplement extends DaoGenericoImplement<CapituloPea> implements CapituloPeaDAO {

	@Override
	public List<CapituloPea> consultarCapitulos(Integer idpea) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From CapituloPea e where e.pea.idPea = ?1  order by e.numeroCap ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idpea);

		return query.getResultList();

	}

	@Override
	public List<CapituloPea> consultarCapitulosExiste(Integer idpea, Integer num) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From CapituloPea e where e.pea.idPea = ?1  and e.numeroCap = ?2 ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idpea);
		query.setParameter(2, num);

		return query.getResultList();

	}

}
