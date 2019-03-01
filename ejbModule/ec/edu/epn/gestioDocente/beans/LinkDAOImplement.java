package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Link;


@Stateless
@LocalBean
public class LinkDAOImplement extends DaoGenericoImplement<Link> implements LinkDAO {

	@Override
	public List<Link> buscarLinks(String nced) throws Exception {
		StringBuilder queryString = new StringBuilder(
				"SELECT s from Link s where s.nced = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nced);
		System.out.println("links");
		return query.getResultList();
	}
	
	
	@Override
	public int maxCodLink() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(p.idLink) FROM Link p");
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
