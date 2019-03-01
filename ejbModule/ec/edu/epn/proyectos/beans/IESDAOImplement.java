package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.Idi;
import ec.edu.epn.proyectos.entities.IesPublica;

/**
 * Session Bean implementation class IESDAOImplement
 */
@Stateless
public class IESDAOImplement extends DaoGenericoImplement<IesPublica> implements IESDAO {

	@Override
	public List<IesPublica> consultarIesProyecto(Integer idproy) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From IesPublica e where e.proyecto.idProy = ?1  ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idproy);

		return query.getResultList();

	}

}
