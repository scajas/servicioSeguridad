package ec.edu.epn.proyectos.beans;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.Camplio;
import ec.edu.epn.proyectos.entities.Cdetallado;
import ec.edu.epn.proyectos.entities.CierrePeriodo;

/**
 * Session Bean implementation class CAmplioDAOImplement
 */
@Stateless
public class CAmplioDAOImplement extends DaoGenericoImplement<Camplio>
		implements CAmplioDAO {

	@Override
	public Camplio consultarCamplio(String nombre) {

		try {

			StringBuilder querys = new StringBuilder(
					"SELECT e From Camplio e where e.nombre like ?1  ");

			Query query = getEntityManager().createQuery(querys.toString());
			query.setParameter(1, nombre+"%");

			return (Camplio) query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}

		catch (NonUniqueResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

	}

}
