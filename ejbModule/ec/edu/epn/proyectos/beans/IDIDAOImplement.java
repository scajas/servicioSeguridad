package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.CierrePeriodo;
import ec.edu.epn.proyectos.entities.Idi;

/**
 * Session Bean implementation class IDIDAOImplement
 */
@Stateless
public class IDIDAOImplement extends DaoGenericoImplement<Idi> implements
		IDIDAO {

	@Override
	public List<Idi> consultarIdiProyecto(Integer idproy) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From Idi e where e.proyecto.idProy = ?1  ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idproy);

		return query.getResultList();

	}

}
