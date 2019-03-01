package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.PiliticasDesarrollo;
import ec.edu.epn.silabo.entities.UbicacionHorario;

/**
 * Session Bean implementation class PoliticasDAOImplement
 */
@Stateless
@LocalBean
public class PoliticasDAOImplement extends DaoGenericoImplement<PiliticasDesarrollo> implements PoliticasDAO {

	@Override
	public List<PiliticasDesarrollo> consultarPoliticas(Integer idsilado) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From PiliticasDesarrollo e where e.silabo.idSilabo = ?1  order by e.idPoliticas");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);

		return query.getResultList();

	}

	@Override
	public int maxId() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idPoliticas) FROM PiliticasDesarrollo p");
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
