package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Cont;
import ec.edu.epn.rrhh.entities.Evidencia;

/**
 * Session Bean implementation class EvidenciaDAOImplement
 */
@Stateless
@LocalBean
public class EvidenciaDAOImplement extends DaoGenericoImplement<Evidencia> implements EvidenciaDAO {

	@Override
	public Evidencia findEvidenciaBYCarrea(String cod_carrera, Integer idmodelo) {
		StringBuilder querys = new StringBuilder(
				"SELECT e FROM Evidencia e where e.carrera.codCarre = ?0 and e.modeloAcreditacion.id = ?1  order by e.id");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, cod_carrera);
		query.setParameter(1, idmodelo);
		query.setMaxResults(1);

		try {
			Evidencia evi = (Evidencia) query.getSingleResult();
			return evi;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public int maxEvidencia() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.id) FROM Evidencia p");
		Integer idPagosV = null;

		try {
			idPagosV = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idPagosV = null;
		}
		if (idPagosV == null) {
			idPagosV = 1;
		} else {
			++idPagosV;
		}
		return idPagosV;
	}

	@Override
	public List<Evidencia> findAllEvidenciaBYCarrea(String cod_carrera, Integer idmodelo) {
		StringBuilder querys = new StringBuilder(
				"SELECT e FROM Evidencia e where e.carrera.codCarre = ?0 and e.modeloAcreditacion.id = ?1  order by e.id ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, cod_carrera);
		query.setParameter(1, idmodelo);
		return query.getResultList();

	}

}
