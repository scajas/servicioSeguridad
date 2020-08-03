package ec.edu.epn.gestioDocente.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Recodificacion;

/**
 * Session Bean implementation class RecodificacionDAOImplement
 */
@Stateless
@LocalBean
public class RecodificacionDAOImplement extends DaoGenericoImplement<Recodificacion> implements RecodificacionDAO {

	@Override
	public int consultarIdRecodifica() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(seg.id)FROM Recodificacion seg");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
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

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

}
