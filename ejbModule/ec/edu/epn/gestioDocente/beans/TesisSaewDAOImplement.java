package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Tesissaew;

/**
 * Session Bean implementation class TesisSaewDAOImplement
 */
@Stateless
@LocalBean
public class TesisSaewDAOImplement extends DaoGenericoImplement<Tesissaew> implements TesisSaewDAO {

	@Override
	public List<Tesissaew> buscarTesisSaew(String cedula, String categoria, String proceso, Integer tesis)
			throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from Tesissaew s where s.codigoprofe = ?1  and s.cateogoria =?2 and s.proceso =?3 ");

		if (tesis != 0) {
			queryString.append(" and s.idtesis =?4 ");
		}

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter(2, categoria.trim());
		query.setParameter(3, proceso);

		if (tesis != 0) {
			query.setParameter(4, tesis);
		}

		return query.getResultList();
	}

}
