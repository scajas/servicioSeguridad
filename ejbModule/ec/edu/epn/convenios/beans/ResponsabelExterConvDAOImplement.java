package ec.edu.epn.convenios.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.convenios.entities.ResponsableExtConv;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class ResponsabelExterConvDAOImplement
 */
@Stateless
@LocalBean
public class ResponsabelExterConvDAOImplement extends DaoGenericoImplement<ResponsableExtConv> implements ResponsabelExterConvDAO {

	@Override
	public List<ResponsableExtConv> findrespExtRobertoSigna(String idconv, Integer signa) {

		StringBuilder queryString = new StringBuilder(
				"SELECT res FROM ResponsableExtConv  res where res.id.idConv like ?1 and res.id.signa = ?2 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%"+idconv+"%");
		query.setParameter(2, signa);

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}
	
	
	@Override
	public ResponsableExtConv findrespExtRobertoElimina(String idconv, Integer idresp, Integer signa ) {

		StringBuilder queryString = new StringBuilder(
				"SELECT res FROM ResponsableExtConv  res where res.id.idConv like ?1 and res.id.codPerx = ?2 and res.id.signa = ?3 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%"+idconv+"%");
		query.setParameter(2, idresp);
		query.setParameter(3, signa);

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return (ResponsableExtConv) query.getSingleResult();
	}

}
