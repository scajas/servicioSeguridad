package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.EmpleadoPublica;
import ec.edu.epn.proyectos.entities.AutoresProducto;

/**
 * Session Bean implementation class AutorProyectoDAOImplement
 */
@Stateless
@LocalBean
public class AutorProyectoDAOImplement extends DaoGenericoImplement<AutoresProducto>  implements AutorProyectoDAO {

	@Override
	public List<AutoresProducto> finaAutoresProducto(Integer Idproducto) throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from AutoresProducto s where s.producto.id =?0   ");	
		Query query = getEntityManager().createQuery(queryString.toString());		
		query.setParameter(0, Idproducto);
		return query.getResultList();
	}

}
