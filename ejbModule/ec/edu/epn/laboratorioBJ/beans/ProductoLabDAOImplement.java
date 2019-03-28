package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.atencionmedica.entities.Catalogo;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
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

		StringBuilder queryString = new StringBuilder("SELECT d FROM ProductoLab d where nombre_pr like '%a%'");
		Query query = getEntityManager().createQuery(queryString.toString());
		//query.setParameter(1, dato);

		List<ProductoLab> resultados = query.getResultList();
		return resultados;

	}

}
