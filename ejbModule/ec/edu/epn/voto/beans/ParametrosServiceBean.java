package ec.edu.epn.voto.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.epn.voto.beans.ParametrosService;
import ec.edu.epn.voto.entities.Consejo;
import ec.edu.epn.voto.entities.ConvocatoriaVoto;

@Stateless
public class ParametrosServiceBean implements ParametrosService {

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public int maxParametro() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(p.numresolucion) FROM ParametroVoto p");
		Integer idParam = null;

		try {
			idParam = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idParam = null;
		}
		if (idParam == null) {
			idParam = 1;
		} else {
			++idParam;
		}
		return idParam;

	}

	@Override
	public void actualizarParametro(int numResol, int idCon) {

		Query query = em
				.createQuery("update ParametroVoto pr set pr.numresolucion =  pr.numresolucion + 1 where pr.consejo.idConsejo = ?1");

		query.setParameter(1, idCon);
		query.executeUpdate();

	}

	@Override
	public List<Consejo> findConsejo() {
		// TODO Auto-generated method stub
		return null;
	}

}
