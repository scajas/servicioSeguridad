package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.Bibliografia;
import ec.edu.epn.silabo.entities.PracticasLaboratorio;

/**
 * Session Bean implementation class BibliografiaDAOImplement
 */
@Stateless
@LocalBean
public class BibliografiaDAOImplement extends DaoGenericoImplement<Bibliografia> implements BibliografiaDAO {

	@Override
	public List<Bibliografia> consultarBilbiografia(Integer idsilado, String tipo) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From Bibliografia e where e.silabo.idSilabo = ?1  and e.tipob = ?2 order by e.idBibliografia");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);
		query.setParameter(2, tipo.trim());

		return query.getResultList();

	}

	@Override
	public List<Bibliografia> consultarBilbiografiaExiste(Integer idsilado, String tipo, String titulo) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From Bibliografia e where e.silabo.idSilabo = ?1  and e.tipob = ?2 and e.titulo = ?3 order by e.idBibliografia");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);
		query.setParameter(2, tipo.trim());
		query.setParameter(3, titulo);

		return query.getResultList();

	}

	@Override
	public int maxIdBibliografia() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idBibliografia) FROM Bibliografia p");
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

}
