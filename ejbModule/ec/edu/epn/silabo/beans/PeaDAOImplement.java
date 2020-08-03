package ec.edu.epn.silabo.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.Autorizacionretraso;
import ec.edu.epn.silabo.entities.Pea;

/**
 * Session Bean implementation class PeaDAOImplement
 */
@Stateless
@LocalBean
public class PeaDAOImplement extends DaoGenericoImplement<Pea> implements PeaDAO {

	@Override
	public Pea consultarPea(String codMat, String paralelo, String materia) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From Pea e where e.codigo = ?1 and e.paralelo = ?2 and e.asignatura = ?3 ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, codMat);
		query.setParameter(2, paralelo);
		query.setParameter(3, materia);

		query.setMaxResults(1);

		try {
			Pea sib = (Pea) query.getSingleResult();
			return sib;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

}
