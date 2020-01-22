package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.ProductoLab;

/**
 * Session Bean implementation class ProductoLabDAOImplement
 */
@Stateless
@LocalBean
public class ProductoLabDAOImplement extends DaoGenericoImplement<ProductoLab> implements ProductoLabDAO {

	/**
	 * Default constructor.
	 */
	public ProductoLabDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ProductoLab> filtrarLista(String dato) {

		StringBuilder queryString = new StringBuilder(
				"SELECT p FROM ProductoLab p where UPPER (nombrePr) like UPPER ('%" + dato + "%') ORDER BY idProducto");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<ProductoLab> resultados = query.getResultList();

		return resultados;

	}

	@Override
	public List<ProductoLab> getListPro() {

		StringBuilder queryString = new StringBuilder("SELECT p FROM ProductoLab p ORDER BY idProducto");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<ProductoLab> resultados = query.getResultList();
		return resultados;
	}

}
