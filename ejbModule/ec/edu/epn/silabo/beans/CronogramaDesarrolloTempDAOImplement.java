package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.CronogramaDesarrollo;
import ec.edu.epn.silabo.entities.CronogramaDesarrolloTemp;
import ec.edu.epn.silabo.entities.Silabo;

/**
 * Session Bean implementation class CronogramaDesarrolloTempDAOImplement
 */
@Stateless
@LocalBean
public class CronogramaDesarrolloTempDAOImplement extends DaoGenericoImplement<CronogramaDesarrolloTemp>
		implements CronogramaDesarrolloTempDAO {

	@Override
	public List<CronogramaDesarrolloTemp> consultarCronograma(Integer idsilado) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From CronogramaDesarrolloTemp e where e.idSilabo = ?1  order by e.fechaCrono ASC");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);

		return query.getResultList();

	}

	@Override
	public int maxIdActividades() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idCronograma) FROM CronogramaDesarrolloTemp p");
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

	@Override
	public int maxNumCrono(Silabo silabo) {
		Query q = getEntityManager()
				.createQuery("SELECT MAX(p.numCronograma) FROM CronogramaDesarrolloTemp p where p.idSilabo = ?1 ");
		Integer idPagosV = null;

		q.setParameter(1, silabo.getIdSilabo());

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

	@Override
	public int maxNumCronoIndice(Silabo silabo) {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(p.indice) FROM CronogramaDesarrolloTemp p where p.idSilabo = ?1 and p.fechaCrono > '2019-10-02' ");
		Integer idPagosV = null;

		q.setParameter(1, silabo.getIdSilabo());

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

	@Override
	public CronogramaDesarrolloTemp consultarCronogramaUpdate(Integer idsilado, Integer indice) {

		try {

			StringBuilder querys = new StringBuilder(
					"SELECT e From CronogramaDesarrolloTemp e where e.idSilabo = ?1  and e.indice = ?2");

			Query query = getEntityManager().createQuery(querys.toString());
			query.setParameter(1, idsilado);
			query.setParameter(2, indice);

			return (CronogramaDesarrolloTemp) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

	}
	
	
	@Override
	public List<CronogramaDesarrolloTemp> consultarCronogramaVacios() {

		StringBuilder querys = new StringBuilder(
				"SELECT e From CronogramaDesarrolloTemp e where e.reemplazado is null ");

		Query query = getEntityManager().createQuery(querys.toString());
		

		return query.getResultList();

	}

}
