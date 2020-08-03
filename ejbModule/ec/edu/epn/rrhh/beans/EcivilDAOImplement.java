/**
 * 
 */
package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Ecivil;



/**
 * @author Administrador
 * 
 */
@Stateless
public class EcivilDAOImplement extends DaoGenericoImplement<Ecivil> implements
		EcivilDAO {
	
	@Override
	public List<Ecivil> findestadoCivil() {
		Query q = getEntityManager().createQuery(
				"Select dep from Ecivil dep order by dep.codEcivil ");

		return q.getResultList();
	}

}
