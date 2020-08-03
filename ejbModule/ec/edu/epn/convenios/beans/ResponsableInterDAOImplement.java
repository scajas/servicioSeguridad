package ec.edu.epn.convenios.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.convenios.entities.ResponsablesInt;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class ResponsableInterDAOImplement
 */
@Stateless
@LocalBean
public class ResponsableInterDAOImplement  extends DaoGenericoImplement<ResponsablesInt> implements ResponsableInterDAO {

	@Override
	public ResponsablesInt findrespInternoSelect(String nced) {

		StringBuilder queryString = new StringBuilder(
				"SELECT res FROM ResponsablesInt  res where res.nced = ?1 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nced);

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return (ResponsablesInt) query.getSingleResult();
	}

}
