/**
 * 
 */
package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.calibracionequipos.entidades.Sistemasgestioncalidad;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class SistemasGCalidadDAOImplement extends DaoGenericoImplement<Sistemasgestioncalidad>
		implements SistemasGCalidadDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(a.idAuditoria) FROM Sistemasgestioncalidad a");
		Integer idReq = null;
		try {
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}
		return idReq;

	}
}
