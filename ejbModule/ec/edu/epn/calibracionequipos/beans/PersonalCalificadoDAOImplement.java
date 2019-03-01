/**
 * 
 */
package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.calibracionequipos.entidades.Personalcalificado;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class PersonalCalificadoDAOImplement extends DaoGenericoImplement<Personalcalificado>
		implements PersonalCalificadoDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idPersonalcalificado) FROM Personalcalificado p");
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
	public List<Personalcalificado> buscarPersonal(String nombres, String cedula) {
		StringBuilder querys = new StringBuilder(
				"SELECT e FROM Personalcalificado e where e.idPersonalcalificado <> 0");

		if (nombres != null) {
			querys.append(" and e.nombrePersonalcalificado like ?1");

		}

		if (cedula != null) {
			querys.append(" and e.cedula like ?2");

		}

		querys.append(" order by e.nombrePersonalcalificado asc");

		Query query = getEntityManager().createQuery(querys.toString());

		if (nombres != null) {
			query.setParameter(1, "%" + nombres.toUpperCase() + "%");

		}

		if (cedula != null) {
			query.setParameter(2, cedula + "%");

		}

		return query.getResultList();
	}

}
