package ec.edu.epn.convenios.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.convenios.entities.Organizacion;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class OrganizacionesDAOImplement
 */
@Stateless
@LocalBean
public class OrganizacionesDAOImplement extends DaoGenericoImplement<Organizacion> implements OrganizacionesDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Organizacion> findOrga(String nombre) {

		System.out.println("Entraaaaaaaaa la consulta de la busquedaaaaaaaaaa");

		StringBuilder queryString = new StringBuilder(
				"SELECT res FROM Organizacion res where res.nombreOr like ?0 ");

		queryString.append("ORDER BY res.nombreOr ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + nombre + "%");

		
		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}

}
