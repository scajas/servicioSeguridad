package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.Pago;

@Stateless
public class PagoDAOImplement extends DaoGenericoImplement<Pago> implements
		PagoDAO {

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(p.idPago) FROM Pago p");
		Integer idPiso = null;

		try {
			idPiso = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idPiso = null;
		}
		if (idPiso == null) {
			idPiso = 1;
		} else {
			++idPiso;
		}
		return idPiso;
	}

	@Override
	public List<Pago> listaPagos() {
		StringBuilder queryString = new StringBuilder(
				"SELECT pago FROM Pago pago ");
		Query query = getEntityManager().createQuery(queryString.toString());
	
		return query.getResultList();
	}
}
