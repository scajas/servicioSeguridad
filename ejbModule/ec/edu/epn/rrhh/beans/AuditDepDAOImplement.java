package ec.edu.epn.rrhh.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.AuditDep;

@Stateless
public class AuditDepDAOImplement extends DaoGenericoImplement<AuditDep> implements AuditDepDAO {

	@Override
	public Integer getMaxId() {
		StringBuilder queryString = new StringBuilder("SELECT max(fam.idAudDep) FROM AuditDep fam ");
		Query query = getEntityManager().createQuery(queryString.toString());
		Integer max = (Integer) query.getSingleResult();
		if (max == null) {
			return 0;
		} else {
			return max;
		}

	}

}
