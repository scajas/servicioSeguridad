package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.Cronogramaavance;
import ec.edu.epn.proyectos.entities.Objetivoavance;

/**
 * Session Bean implementation class CronogramaAvanceDAOImplement
 */
@Stateless
@LocalBean
public class CronogramaAvanceDAOImplement extends DaoGenericoImplement<Cronogramaavance>
		implements CronogramaAvanceDAO {

	@Override
	public List<Cronogramaavance> findAvanceByCronograma(Integer idcronograma, String tipo) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From Cronogramaavance e where e.cronograma.idCronograma = ?1 and e.tipo = ?2 order by e.id");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idcronograma);
		query.setParameter(2, tipo);

		return query.getResultList();

	}

	@Override
	public List<Cronogramaavance> findAvanceByCronogramaExiste(Integer idcronograma, String tipo, Integer idpensum) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From Cronogramaavance e where e.cronograma.idCronograma = ?1 and e.tipo = ?2 and e.idpensum  = ?3 order by e.id");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idcronograma);
		query.setParameter(2, tipo);
		query.setParameter(3, idpensum);

		return query.getResultList();

	}
	
	@Override
	public List<Cronogramaavance> findAvanceByCronogramaReporte(Integer idcronograma, String tipo, Integer idpensum) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From Cronogramaavance e where e.cronograma.proyecto.idProy = ?1 and e.tipo = ?2 and e.idpensum = ?3 order by e.id");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idcronograma);
		query.setParameter(2, tipo);
		query.setParameter(3, idpensum);

		return query.getResultList();

	}
	
	@Override
	public Long countCronoAvanceXidObjProy(Integer idCronograma) {
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(oa) FROM  Cronogramaavance oa WHERE oa.cronograma.idCronograma = ? ");
			
		q.setParameter(1, idCronograma);		
		return (Long) q.getSingleResult();
	}
}
