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
import ec.edu.epn.rrhh.entities.Clasemp;
import ec.edu.epn.rrhh.entities.Dep;
import ec.edu.epn.rrhh.movimientos.Clase;


/**
 * @author Administrador
 * 
 */
@Stateless
public class ClasempDAOImplement extends DaoGenericoImplement<Clasemp>
		implements ClasempDAO {
	
	
	@Override
	public Clasemp findClaseEmp(String claseemp) {
		Query q = getEntityManager().createQuery(
				"Select dep from Clasemp dep where dep.codClase =?1  ");

		q.setParameter(1, claseemp);

		return (Clasemp) q.getSingleResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Clasemp> findAllCalses() throws Exception {
		Query query = super.getEntityManager().createNamedQuery("Clasemp.findAll");
		return query.getResultList();

	}
	//Commment 
	@Override
	public Clasemp findClaseByNombre(String nombreClase) {
		Query q = getEntityManager().createQuery(
				"Select cls from Clasemp cls where cls.descClase like ?1  ");

		q.setParameter(1, nombreClase);
		Clasemp resultado = null;
		
		try{
			resultado = (Clasemp)q.getSingleResult();
		}catch(NoResultException e){
			return resultado;
		}catch (NonUniqueResultException e){
			 e.printStackTrace();
		}
		return resultado;
	}
	
	
	
	
}
