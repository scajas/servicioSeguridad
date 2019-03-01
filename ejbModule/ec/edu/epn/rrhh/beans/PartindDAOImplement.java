/**
 * 
 */
package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Emp;
import ec.edu.epn.rrhh.entities.NombTemp;
import ec.edu.epn.rrhh.entities.Partind;

/**
 * @author Administrador
 * 
 */
@Stateless
public class PartindDAOImplement extends DaoGenericoImplement<Partind> implements PartindDAO {

	@Override
	public Partind findbyCodPind(String codpind) {
		StringBuilder querys = new StringBuilder("SELECT e From Partind e where e.codPind = ?1");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, codpind);

		try {
			Partind nom = (Partind) query.getSingleResult();
			return nom;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public List<Partind> findPartidas() {
		StringBuilder querys = new StringBuilder("SELECT e From Partind e order by e.cargo");
		Query query = getEntityManager().createQuery(querys.toString());

		return query.getResultList();
	}

}
