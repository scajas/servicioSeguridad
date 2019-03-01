/**
 * 
 */
package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.calibracionequipos.entidades.Actividadespersonalcalificado;
import ec.edu.epn.calibracionequipos.entidades.Personalcalificado;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class ActividadesPersonalCalificadoDAOImplement extends DaoGenericoImplement<Actividadespersonalcalificado>
		implements ActividadesPersonalCalificadoDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager()
				.createQuery("SELECT MAX(a.idActividadecalif) FROM Actividadespersonalcalificado a");
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
	public List<Actividadespersonalcalificado> buscarActividadesXPesonal(Personalcalificado personal) {
		StringBuilder querys = new StringBuilder(
				"SELECT e.actividades FROM PerCalAct e where e.personal.idPersonalcalificado = ?1");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, personal.getIdPersonalcalificado());
		return query.getResultList();
	}

}
