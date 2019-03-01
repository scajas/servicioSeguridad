/**
 * 
 */
package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Secuenciales;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class SecuenciaPedidoDAOImplement extends DaoGenericoImplement<Secuenciales> implements SecuenciaPedidoDAO {

	@Override
	public List<Secuenciales> listxPensum(int idPensum) {
		try {
			StringBuilder queryString = new StringBuilder(
					"SELECT sec FROM Secuenciales sec where sec.pensum.idPensum =?1");
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, idPensum);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public List<Secuenciales> listxFacultadPensum(String idFacultad, int idPensum) {
		try {
			StringBuilder queryString = new StringBuilder(
					"SELECT sec FROM Secuenciales sec where sec.pensum.idPensum =?1 and sec.facultad.idFacultad=?2 and sec.activo = TRUE");
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, idPensum);
			query.setParameter(2, idFacultad);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
