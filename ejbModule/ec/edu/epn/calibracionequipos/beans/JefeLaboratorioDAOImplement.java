/**
 * 
 */
package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.calibracionequipos.entidades.Jefelaboratorio;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class JefeLaboratorioDAOImplement extends DaoGenericoImplement<Jefelaboratorio> implements JefeLaboratorioDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(jl.idJefelab) FROM Jefelaboratorio jl");
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

	@Override
	public List<Jefelaboratorio> listXParams(String nombres, String cedula) {

		try {

			StringBuilder queryString = new StringBuilder(
					"SELECT lab FROM Jefelaboratorio lab where lab.idJefelab > 0");

			if (!nombres.equals(""))
				queryString.append(" and lab.nombreJefelab = ?1");
			if (!cedula.equals(""))
				queryString.append(" and lab.cedula = ?2");

			Query query = null;

			query =

					getEntityManager().createQuery(queryString.toString());

			if (!nombres.equals(""))
				query.setParameter(1, nombres);
			if (!cedula.equals(""))
				query.setParameter(2, cedula);

			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
}
