/**
 * 
 */
package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Estemp;



/**
 * @author Administrador
 * 
 */
@Stateless
public class EstempDAOImplement extends DaoGenericoImplement<Estemp> implements
		EstempDAO {
	
	@Override
	public List<Estemp> findestadosEmp() {
		Query q = getEntityManager().createQuery(
				"Select dep from Estemp dep order by dep.codEst ");

		return q.getResultList();
	}

}
