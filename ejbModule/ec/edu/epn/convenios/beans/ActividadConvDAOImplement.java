package ec.edu.epn.convenios.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.convenios.entities.ActividadeConvenio;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class ActividadConvDAOImplement
 */
@Stateless
@LocalBean
public class ActividadConvDAOImplement extends DaoGenericoImplement<ActividadeConvenio> implements ActividadConvDAO {

	@Override
	public List<ActividadeConvenio> findact(int serial) {

		StringBuilder queryString = new StringBuilder(
				"SELECT res FROM ActividadeConvenio  res where res.convenio.serial = ?1 order by res.idAct ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, serial);

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}

}
