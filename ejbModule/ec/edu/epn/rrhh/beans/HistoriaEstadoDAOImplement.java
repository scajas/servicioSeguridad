package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.HistoriaEstado;

/**
 * Session Bean implementation class HistoriaEstadoDAOImplement
 */
@Stateless
@LocalBean
public class HistoriaEstadoDAOImplement extends DaoGenericoImplement<HistoriaEstado> implements HistoriaEstadoDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<HistoriaEstado> findHistoriaByEmp(String nced) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM HistoriaEstado fam where fam.emp.nced =?1 order by fam.idHe  ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, nced);

		return query.getResultList();

	}
	

	
	@Override
	public int consultarIdhisotrial() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(seg.idHe)FROM HistoriaEstado seg");

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
