package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.IesPublica;
import ec.edu.epn.proyectos.entities.Informeobservacione;

/**
 * Session Bean implementation class InformeObservacionesDAOImplement
 */
@Stateless
public class InformeObservacionesDAOImplement extends DaoGenericoImplement<Informeobservacione> implements InformeObservacionesDAO {

   
	@Override
	public List<Informeobservacione> consultarInformes(Integer idproy) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From Informeobservacione e where e.proyecto.idProy = ?1  ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idproy);

		return query.getResultList();

	}
}
