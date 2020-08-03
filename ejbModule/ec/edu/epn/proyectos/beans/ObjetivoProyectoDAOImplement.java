package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.ObjetivoProyecto;

/**
 * Session Bean implementation class ObjetivoProyectoDAOImplement
 */
@Stateless
@LocalBean
public class ObjetivoProyectoDAOImplement extends DaoGenericoImplement<ObjetivoProyecto>
		implements ObjetivoProyectoDAO {

	@Override
	public List<ObjetivoProyecto> findObjetivoByProyecto(Integer idproyecto) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From ObjetivoProyecto e where e.proyecto.idProy = ?1  order by e.idObjproy");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idproyecto);

		return query.getResultList();

	}
	
	
	@Override
	public List<ObjetivoProyecto> findObjetivoByProyectoFaltante(Integer idproyecto, Integer idpensum, String tipo) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From ObjetivoProyecto e where e.proyecto.idProy = ?1  "
				+ " and e.idObjproy not in (Select o.objetivo.idObjproy  from Objetivoavance o where o.idpensum  = ?2 and o.tipo = ?3 ))"
				+ "order by e.idObjproy");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idproyecto);
		query.setParameter(2, idpensum);
		query.setParameter(3, tipo);

		return query.getResultList();

	}
	
	
	
	

}
