package ec.edu.epn.convenios.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.convenios.entities.ResponsableIntConv;
import ec.edu.epn.convenios.entities.ResponsablesInt;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class ResponsableIntConvDAOImplement
 */
@Stateless
@LocalBean
public class ResponsableIntConvDAOImplement  extends DaoGenericoImplement<ResponsableIntConv> implements ResponsableIntConvDAO {

	@Override
	public List<ResponsableIntConv> findrespIntRoberto(String idconv) {

		StringBuilder queryString = new StringBuilder(
				"SELECT res FROM ResponsableIntConv  res where res.id.idConv like ?1 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%"+idconv+"%");

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}
	
	
	@Override
	public ResponsablesInt findrespinternoSolo(int serial) {

		StringBuilder queryString = new StringBuilder(
				"SELECT res FROM ResponsablesInt  res where res.idRespoint = ?1  ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, serial);

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return (ResponsablesInt) query.getSingleResult();
	}
	
	@Override
	public List<ResponsablesInt> findrespInternoSelectExiet(String nced) {

		StringBuilder queryString = new StringBuilder(
				"SELECT res FROM ResponsablesInt  res where res.nced = ?1 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nced);

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return  query.getResultList();
	}
	
	@Override
	public ResponsableIntConv findrespintRobertoElimina(String idconv, Integer idresp ) {

		StringBuilder queryString = new StringBuilder(
				"SELECT res FROM ResponsableIntConv  res where res.id.idConv like ?1 and res.id.idRespoint = ?2");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%"+idconv+"%");
		query.setParameter(2, idresp);

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return (ResponsableIntConv) query.getSingleResult();
	}

}
