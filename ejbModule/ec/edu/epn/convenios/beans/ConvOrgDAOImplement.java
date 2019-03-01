package ec.edu.epn.convenios.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.convenios.entities.ConvOrganizacion;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class ConvOrgDAOImplement
 */
@Stateless
@LocalBean
public class ConvOrgDAOImplement extends DaoGenericoImplement<ConvOrganizacion> implements ConvOrgDAO {

	@Override
	public List<ConvOrganizacion> findConvOrg(int idOrg, String id_conv) {

		StringBuilder queryString = new StringBuilder(
				"SELECT est FROM ConvOrganizacion  est where  est.convenio.idConv like ?1  and est.organizacion.idOrganizacion = ?2 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%"+id_conv+"%");
		query.setParameter(2, idOrg);

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return  query.getResultList();
	}
	
	@Override
	public List<ConvOrganizacion> findConvOrgSelect( String id_conv) {

		StringBuilder queryString = new StringBuilder(
				"SELECT est FROM ConvOrganizacion  est where  est.convenio.idConv like ?1 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%"+id_conv+"%");
		

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return  query.getResultList();
	}

}
