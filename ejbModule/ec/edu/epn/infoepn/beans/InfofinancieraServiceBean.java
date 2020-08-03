package ec.edu.epn.infoepn.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infoepn.entities.Infofinanciera;

/**
 * Session Bean implementation class InfofinancieraServiceBean
 */
@Stateless
public class InfofinancieraServiceBean extends
		DaoGenericoImplement<Infofinanciera> implements InfofinancieraService {

	@SuppressWarnings("unchecked")
	@Override
	public List<Infofinanciera> findallinfo(Integer anio) {

		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Infofinanciera fam  ");

		if (anio != 0) {
			queryString.append(" where fam.anio = ?0 ");
		}

		queryString.append(" order by fam.anio ");

		Query query = getEntityManager().createQuery(queryString.toString());

		if (anio != 0) {
			query.setParameter(0, anio);
		}

		return query.getResultList();

	}

	@Override
	public int consultarIdInfor() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(seg.id)FROM Infofinanciera seg");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
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

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

}
