package ec.edu.epn.silabo.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.ActividadesVinculacion;
import ec.edu.epn.silabo.entities.CronogramaDesarrollo;
import ec.edu.epn.silabo.entities.Silabo;

/**
 * Session Bean implementation class CronogramaDAOImplement
 */
@Stateless
@LocalBean
public class CronogramaDAOImplement extends DaoGenericoImplement<CronogramaDesarrollo> implements CronogramaDAO {

	@Override
	public List<CronogramaDesarrollo> consultarCronograma(Integer idsilado) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From CronogramaDesarrollo e where e.silabo.idSilabo = ?1  order by e.fechaCrono ASC");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);

		return query.getResultList();

	}
	
	
	
	@Override
	public List<CronogramaDesarrollo> consultarCronogramaExiste(Integer idsilado,Date fecha) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From CronogramaDesarrollo e where e.silabo.idSilabo = ?1 and e.fechaCrono = ?2 order by e.fechaCrono ASC");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);
		query.setParameter(2, fecha);

		return query.getResultList();

	}

	@Override
	public int maxIdActividades() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idCronograma) FROM CronogramaDesarrollo p");
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
		Query q = getEntityManager().createQuery("SELECT MAX(p.numCronograma) FROM CronogramaDesarrollo p where p.silabo.idSilabo = ?1 ");
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

}
