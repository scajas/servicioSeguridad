/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.TipoInfraestructura;

/**
 * @author Administrador
 * 
 */
@Stateless
public class TipoInfraestructuraDAOImplement extends DaoGenericoImplement<TipoInfraestructura>
		implements TipoInfraestructuraDAO {

	@Override
	public int consultarID() {
		Query q = getEntityManager().createQuery("SELECT MAX(te.idTipoinfra) FROM TipoInfraestructura te");
		Integer idTipoEspacio = null;

		try {
			idTipoEspacio = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idTipoEspacio = null;
		}
		if (idTipoEspacio == null) {
			idTipoEspacio = 1;
		} else {
			++idTipoEspacio;
		}
		return idTipoEspacio;
	}

}
