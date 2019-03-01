package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Eventocapac;

@Stateless
public class EventoCapacDAOImplement extends DaoGenericoImplement<Eventocapac> implements EventoCapacDAO {

	@Override
	public int consultarId() {

		Query q = getEntityManager().createQuery("SELECT MAX(seg.idevento)FROM Eventocapac seg");

		Integer idReq = null;
		try {
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}
		return idReq;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Eventocapac> listaCapacitacionXCedula(String cedula) {
		StringBuilder queryString = new StringBuilder("SELECT ec FROM Eventocapac ec where ec.nced =?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula);
		return query.getResultList();
	}

}
