package ec.edu.epn.desarrollo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.desarrollo.entities.PersonalArea;
import ec.edu.epn.desarrollo.entities.Requerimiento;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.Objetivoavance;

/**
 * Session Bean implementation class PersonalAreaDAOImplement
 */
@Stateless
@LocalBean
public class PersonalAreaDAOImplement  extends DaoGenericoImplement<PersonalArea> implements PersonalAreaDAO {

   
	@Override
	public PersonalArea findPersonalArear(String  nced, String estado) {

		try {

			StringBuilder querys = new StringBuilder(
					"SELECT e From PersonalArea e where e.empleado.nced = ?1 and e.activo = ?2  ");

			Query query = getEntityManager().createQuery(querys.toString());
			query.setParameter(1, nced);
			query.setParameter(2, estado);
			

			return (PersonalArea) query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

	}
	
	
	@Override
	public List<PersonalArea> consultarPersonalByArea(Integer idarea,String activo) {
		StringBuilder querys = new StringBuilder(
				"SELECT e From PersonalArea e where e.dgipArea.id = ?1  and e.activo = ?2 order by e.empleado.apel asc ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idarea);
		query.setParameter(2, activo);
		return query.getResultList();
	}
	
	
}
