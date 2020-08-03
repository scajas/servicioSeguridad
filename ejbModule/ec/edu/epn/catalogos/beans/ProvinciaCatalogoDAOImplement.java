/**
 * 
 */
package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.catalogos.entities.Provincia;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class ProvinciaCatalogoDAOImplement extends DaoGenericoImplement<Provincia> implements ProvinciaCatalogoDAO {

	@Override
	public List<Provincia> findAll() {
		Query consulta = getEntityManager().createNamedQuery("ProvinciaCatalogo.findAll");
		return consulta.getResultList();
	}

}
