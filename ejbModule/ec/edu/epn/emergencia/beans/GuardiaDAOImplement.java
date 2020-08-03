/**
 * 
 */
package ec.edu.epn.emergencia.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.emergencia.entidades.AsistenciaEmergencia;
import ec.edu.epn.emergencia.entidades.AutorizacionEmergencia;
import ec.edu.epn.emergencia.entidades.Guardia;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Ecivil;



/**
 * @author Andres Cevallos
 * 
 */
@Stateless
public class GuardiaDAOImplement extends DaoGenericoImplement<Guardia> implements
		GuardiaDAO {


	@Override
	public List<Guardia> findGuardia() {
		Query q = getEntityManager().createQuery(
				"Select dep from Guardia dep ");

		return q.getResultList();
	}
	
	@Override
	public Integer getMaxId() {
		StringBuilder queryString = new StringBuilder(
				"SELECT max(idGuardia) FROM Guardia fam ");
		Query query = getEntityManager().createQuery(queryString.toString());
		Integer max = (Integer) query.getSingleResult();
		if (max == null)
			return 0;
		else
			return max;
	}

}
