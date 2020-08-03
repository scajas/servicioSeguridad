package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Periodo;

/**
 * Session Bean implementation class PeriodoDAOImplement
 */
@Stateless
public class PeriodoDAOImplement extends DaoGenericoImplement<Periodo> implements PeriodoDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Periodo> finsAllPeriodos() throws Exception {

		Query query = getEntityManager().createNamedQuery("Periodo.findAll");

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Periodo> findPeriodos() {
		StringBuilder queryString = new StringBuilder(
				"SELECT pr FROM Periodo pr WHERE pr.mostrar ='S' ORDER BY id_periodo DESC");
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

	@Override
	public Periodo findPeriodos(String idPeriodo) {
		StringBuilder queryString = new StringBuilder("select pr from Periodo pr where pr.idPeriodo = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idPeriodo);

		return (Periodo) query.getSingleResult();
	}

	@Override
	public Periodo findPeriodoByPensum(Integer idpensum) {

		try {
			StringBuilder queryString = new StringBuilder("select pr from Periodo pr where pr.idPensum = ?1");
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, idpensum);
			return (Periodo) query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException n) {
			return null;
		}
	}

}
