package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.Cronograma;
import ec.edu.epn.proyectos.entities.Objetivoavance;

/**
 * Session Bean implementation class CronogramaProyectoDAOImplement
 */
@Stateless
@LocalBean
public class CronogramaProyectoDAOImplement extends DaoGenericoImplement<Cronograma> implements CronogramaProyectoDAO {

	@Override
	public List<Cronograma> findCronogramabyProyecto(Integer idproyecto) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From Cronograma e where e.proyecto.idProy = ?1    order by e.idCronograma");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idproyecto);

		return query.getResultList();

	}

	

}
