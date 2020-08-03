package ec.edu.epn.convenios.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.convenios.entities.ResponsableExt;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class ResponsableExternoDAOImplement
 */
@Stateless
@LocalBean
public class ResponsableExternoDAOImplement extends DaoGenericoImplement<ResponsableExt> implements ResponsableExternoDAO {

	@Override
	public ResponsableExt findrespExternosSolo(int serial) {

		try{
		StringBuilder queryString = new StringBuilder(
				"SELECT res FROM ResponsableExt  res where res.codPerx = ?1  ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, serial);

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		
		return (ResponsableExt) query.getSingleResult();
		
		} catch(NoResultException e) {
	        return null;
	    }
	}
		
		
		
		@Override
		public List<ResponsableExt> findRespExte(String nombre, String cargo,
				String titulo) {

			System.out.println("Entraaaaaaaaa la consulta de la busquedaaaaaaaaaa");

			StringBuilder queryString = new StringBuilder(
					"SELECT res FROM ResponsableExt res where res.nombres like ?0 ");

			if (cargo != null) {
				queryString.append(" AND res.cargo like ?1 ");
			}

			if (titulo != null) {
				queryString.append(" AND res.tit like ?2 ");
			}

			queryString.append("ORDER BY res.nombres ");

			Query query = getEntityManager().createQuery(queryString.toString());

			query.setParameter(0, "%" + nombre + "%");

			if (cargo != null) {
				query.setParameter(1, "%" + cargo + "%");
			}
			if (titulo != null) {
				query.setParameter(2, "%" + titulo + "%");
			}

			System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
			return query.getResultList();
		}
		
		
	

}
