/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.LugarEspacio;
import ec.edu.epn.infraestructura.entities.PisoInfra;

/**
 * @author Leonardo Guachamín
 * 
 */
@Stateless
public class LugarEspacioDAOImplement extends DaoGenericoImplement<LugarEspacio> implements LugarEspacioDAO {



	@Override
	public int maxLugarEspacio() {
		Query q = getEntityManager().createQuery("SELECT MAX(le.idLugarEspacio) FROM LugarEspacio le");
		Integer idLugarEspacio = null;

		try {
			idLugarEspacio = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idLugarEspacio = null;
		}
		if (idLugarEspacio == null) {
			idLugarEspacio = 1;
		} else {
			++idLugarEspacio;
		}
		return idLugarEspacio;
	}
	




}
