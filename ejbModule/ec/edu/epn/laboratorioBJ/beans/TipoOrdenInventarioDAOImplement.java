/**
 * 
 */
package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.ProductoLab;
import ec.edu.epn.laboratorioBJ.entities.Tipordeninv;

/**
 * @author Administrador
 * 
 */
@Stateless
@LocalBean

public class TipoOrdenInventarioDAOImplement extends DaoGenericoImplement<Tipordeninv>
		implements TipoOrdenInventarioDAO {

	public TipoOrdenInventarioDAOImplement() {

	}

	@Override
	public List<Tipordeninv> orderById() {

		StringBuilder queryString = new StringBuilder("SELECT t FROM Tipordeninv t order by t.idTipordeninv asc");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Tipordeninv> resultados = query.getResultList();
		return resultados;

	}

}
