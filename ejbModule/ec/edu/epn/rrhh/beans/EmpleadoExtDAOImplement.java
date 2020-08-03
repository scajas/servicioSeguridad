/**
 * 
 */
package ec.edu.epn.rrhh.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.EmpExt;

/**
 * @author Administrador
 * 
 */
@Stateless
public class EmpleadoExtDAOImplement extends DaoGenericoImplement<EmpExt> implements EmpleadoExtDAO {

	@Override
	public EmpExt buscarempExterno(String nced) throws Exception {

		StringBuilder queryString = new StringBuilder("SELECT e from EmpExt e where e.nced = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nced.trim());

		return (EmpExt) query.getSingleResult();
	}

}
