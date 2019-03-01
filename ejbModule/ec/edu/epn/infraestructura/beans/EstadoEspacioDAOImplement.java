package ec.edu.epn.infraestructura.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.EstadoEspacio;

@Stateless
public class EstadoEspacioDAOImplement extends
		DaoGenericoImplement<EstadoEspacio> implements EstadoEspacioDAO {

	@Override
	public int maxEstadoEspacio() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(ee.idEstadoEspacio) FROM EstadoEspacio ee");
		Integer idEstadoEspacio = null;

		try {
			idEstadoEspacio = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idEstadoEspacio = null;
		}
		if (idEstadoEspacio == null) {
			idEstadoEspacio = 1;
		} else {
			++idEstadoEspacio;
		}
		return idEstadoEspacio;
	}

}
