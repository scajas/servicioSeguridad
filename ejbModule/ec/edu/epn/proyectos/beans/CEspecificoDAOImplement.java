package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.Camplio;
import ec.edu.epn.proyectos.entities.Cespecifico;
import ec.edu.epn.proyectos.entities.MontoEjecutado;

/**
 * Session Bean implementation class CEspecificoDAOImplement
 */
@Stateless
public class CEspecificoDAOImplement extends DaoGenericoImplement<Cespecifico> implements CEspecificoDAO {

    
	
	@Override
   	public List<Cespecifico> consultarCamplios(Integer idcamplio) {

   		StringBuilder querys = new StringBuilder("SELECT e From Cespecifico e where  e.camplio.id = ?1 " );
   		Query query = getEntityManager().createQuery(querys.toString());
   		query.setParameter(1, idcamplio);
   		return query.getResultList();
   		
   	}
	
	@Override
	public Cespecifico consultarCespecifico(String nombre) {

		try {

			StringBuilder querys = new StringBuilder(
					"SELECT e From Cespecifico e where e.nombre = ?1  ");

			Query query = getEntityManager().createQuery(querys.toString());
			query.setParameter(1, nombre);

			return (Cespecifico) query.getSingleResult();

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
