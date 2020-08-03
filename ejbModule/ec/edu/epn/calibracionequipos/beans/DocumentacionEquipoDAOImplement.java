/**
 * 
 */
package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.calibracionequipos.entidades.Documentacionasociada;
import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class DocumentacionEquipoDAOImplement extends DaoGenericoImplement<Documentacionasociada>
		implements DocumentacionEquipoDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager()
				.createQuery("SELECT MAX(esteq.idDocumentoasociado) FROM Documentacionasociada esteq");
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

	@Override
	public List<Documentacionasociada> documentacionxEquipo(Equiposcalibracionequipo equipo) {
		StringBuilder queryString = new StringBuilder(
				"select cu from Documentacionasociada cu where cu.equiposcalibracionequipo.idEquipo = ?1 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, equipo.getIdEquipo());
		return query.getResultList();
	}
}
