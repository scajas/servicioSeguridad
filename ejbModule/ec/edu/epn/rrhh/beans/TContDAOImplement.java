package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Tcont;

@Stateless
public class TContDAOImplement extends DaoGenericoImplement<Tcont> implements TContDAO {

	@Override
	public List<Tcont> findTipoCOntrato() {
		Query q = getEntityManager().createQuery(
				"Select dep from Tcont dep order by dep.tcont ");

		return q.getResultList();
	}
	
}
