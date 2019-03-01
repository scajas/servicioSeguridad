package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.CronogramaDesarrollo;
import ec.edu.epn.silabo.entities.UbicacionHorario;

/**
 * Session Bean implementation class UbicacionDAOImplement
 */
@Stateless
@LocalBean
public class UbicacionDAOImplement extends DaoGenericoImplement<UbicacionHorario> implements UbicacionDAO {

	@Override
	public List<UbicacionHorario> consultarUbicacion(Integer idsilado) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From UbicacionHorario e where e.silabo.idSilabo = ?1  order by e.idHorario");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);

		return query.getResultList();

	}

	@Override
	public int maxIdHorario() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idHorario) FROM UbicacionHorario p");
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
