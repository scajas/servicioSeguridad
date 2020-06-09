package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.HorariosTutoria;
import ec.edu.epn.silabo.entities.SesionVirtual;

/**
 * Session Bean implementation class HorariosTutoriasDAOImplement
 */
@Stateless
@LocalBean
public class HorariosTutoriasDAOImplement extends DaoGenericoImplement<HorariosTutoria> implements HorariosTutoriasDAO {

	@Override
	public List<HorariosTutoria> consultarHorariosTutorias(Integer idsilado) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From HorariosTutoria e where e.silabo.idSilabo = ?1  order by e.idHorario");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);

		return query.getResultList();

	}

}
