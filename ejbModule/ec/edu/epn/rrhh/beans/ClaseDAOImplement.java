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
public class ClaseDAOImplement extends DaoGenericoImplement<Clase>
		implements ClaseDAO {

	@Override
	public Clase findClaseByNombre(String nombreClase) {
		Query q = getEntityManager().createQuery(
				"Select cls from Clase cls where cls.nomClase like ?1  ");

		q.setParameter(1, nombreClase);
		Clase resultado = null;
		
		try{
			resultado = (Clase)q.getSingleResult();
		}catch(NoResultException e){
			return resultado;
		}catch (NonUniqueResultException e){
			 e.printStackTrace();
		}
		return resultado;
		
	}
	
	@Override
	public List<Clase> findClaseByEstadoActivo() {
		Query q = getEntityManager().createQuery(
				"Select cls from Clase cls where cls.estado = 'ACTIVO'  ");

		
		List<Clase> resultado = null;
		
		try{
			resultado = q.getResultList();
		}catch(NoResultException e){
			return resultado;
		}catch (NonUniqueResultException e){
			 e.printStackTrace();
		}
		return resultado;
		
	}
	
	
	
	
	
}
