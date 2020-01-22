package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.ProveedorLab;

/**
 * Session Bean implementation class ProveedorLabDAOImplement
 */
@Stateless
@LocalBean
public class ProveedorLabDAOImplement extends DaoGenericoImplement<ProveedorLab> implements ProveedorLabDAO {

	/**
	 * Default constructor.
	 */
	public ProveedorLabDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ProveedorLab> getListProveedor() {

		StringBuilder queryString = new StringBuilder("SELECT p FROM ProveedorLab p ORDER BY p.nombrePv ASC");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<ProveedorLab> resultados = query.getResultList();

		return resultados;
	}

}
