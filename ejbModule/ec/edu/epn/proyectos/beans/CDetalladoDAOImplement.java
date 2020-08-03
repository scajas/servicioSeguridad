package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.Cdetallado;
import ec.edu.epn.proyectos.entities.Cespecifico;

/**
 * Session Bean implementation class CDetalladoDAOImplement
 */
@Stateless
public class CDetalladoDAOImplement extends DaoGenericoImplement<Cdetallado> implements CDetalladoDAO {

	@Override
   	public List<Cdetallado> consultarCEspecificos(Integer idcamplio) {

   		StringBuilder querys = new StringBuilder("SELECT e From Cdetallado e where  e.cespecifico.id = ?1 " );
   		Query query = getEntityManager().createQuery(querys.toString());
   		query.setParameter(1, idcamplio);
   		return query.getResultList();
   		
   	}
	
	@Override
	public Cdetallado consultarCespecifico(String nombre) {

		try {

			StringBuilder querys = new StringBuilder(
					"SELECT e From Cdetallado e where e.nombre = ?1  ");

			Query query = getEntityManager().createQuery(querys.toString());
			query.setParameter(1, nombre);

			return (Cdetallado) query.getSingleResult();

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
