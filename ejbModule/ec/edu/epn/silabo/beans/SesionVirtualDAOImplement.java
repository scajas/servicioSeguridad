package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.SesionVirtual;
import ec.edu.epn.silabo.entities.UbicacionHorario;

/**
 * Session Bean implementation class SesionVirtualDAOImplement
 */
@Stateless
@LocalBean
public class SesionVirtualDAOImplement extends DaoGenericoImplement<SesionVirtual> implements SesionVirtualDAO {

	@Override
	public List<SesionVirtual> consultarSesionVirtual(Integer idsilado) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From SesionVirtual e where e.silabo.idSilabo = ?1  order by e.idSesion");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);

		return query.getResultList();

	}

}
