/**
 * 
 */
package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Nac;



/**
 * @author Administrador
 * 
 */
@Stateless
public class NacDAOImplement extends DaoGenericoImplement<Nac> implements
		NacDAO {
	
	@Override
	public List<Nac> findNacionalidades() {
		Query q = getEntityManager().createQuery(
				"Select dep from Nac dep order by dep.codNac ");

		return q.getResultList();
	}

}
