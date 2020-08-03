/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.TipoEspacio;

/**
 * @author Administrador
 * 
 */
@Stateless
public class TipoEspacioDAOImplement extends DaoGenericoImplement<TipoEspacio>
		implements TipoEspacioDAO {

	@Override
	public int maxTipoEspacio() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(te.idTipoEspacio) FROM TipoEspacio te");
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
