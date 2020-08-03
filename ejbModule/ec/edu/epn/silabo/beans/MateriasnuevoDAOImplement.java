package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Partind;
import ec.edu.epn.silabo.entities.MateriaSilabo;

/**
 * Session Bean implementation class MateriasnuevoDAOImplement
 */
@Stateless
@LocalBean
public class MateriasnuevoDAOImplement extends DaoGenericoImplement<MateriaSilabo> implements MateriasnuevoDAO {

	@Override
	public List<MateriaSilabo> findAllMaterias() {
		StringBuilder querys = new StringBuilder(
				"SELECT e From MateriaSilabo e order by e.id");
		Query query = getEntityManager().createQuery(querys.toString());

		return query.getResultList();
	}
}
