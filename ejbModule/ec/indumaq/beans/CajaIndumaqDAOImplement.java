/**
 * 
 */
package ec.indumaq.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.indumaq.entidades.CajaIndumaq;

/**
 * @author Administrador
 * 
 */
@Stateless
public class CajaIndumaqDAOImplement extends DaoGenericoImplement<CajaIndumaq> implements CajaIndumaqDAO {

	@Override
	public CajaIndumaq consultarSecuencialCaja(int idUsuario) {
		try {
			Query q = getEntityManager().createQuery("SELECT c FROM CajaIndumaq c where c.idUsuario = ?1");
			q.setParameter(1, idUsuario);

			CajaIndumaq caja = (CajaIndumaq) q.setMaxResults(1).getSingleResult();

			return caja;
		} catch (Exception e) {
			return null;
		}

	}

}
