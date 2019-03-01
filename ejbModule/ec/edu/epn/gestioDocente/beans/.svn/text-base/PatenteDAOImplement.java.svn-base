package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Patente;

/**
 * Session Bean implementation class NivelDAOImplement
 */
@Stateless
@LocalBean
public class PatenteDAOImplement extends DaoGenericoImplement<Patente> implements PatenteDAO {

	@Override
	public List<Patente> buscarPatenteByParams(String cedula, String validarecategoriza, String validarevaloriza,
			String codigoIEPI, String clase) throws Exception {

		StringBuilder queryString = new StringBuilder("SELECT s from Patente s where s.nced = ?1   ");

		if (validarecategoriza != null) {
			queryString.append(" and s.validarecategorza = ?2 ");
		}

		if (validarevaloriza != null) {
			queryString.append(" and s.validarevalorazion = ?3 ");
		}

		if (codigoIEPI != null) {
			queryString.append(" and s.codigoIepi = ?4 ");
		}

		if (clase != null) {
			queryString.append(" and s.clase = ?5 ");
		}

		queryString.append(" ORDER BY s.periodo.idPeriodo DESC ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());

		if (validarecategoriza != null) {
			query.setParameter(2, validarecategoriza);
		}

		if (validarevaloriza != null) {
			query.setParameter(3, validarevaloriza);
		}

		if (codigoIEPI != null) {
			query.setParameter(4, codigoIEPI);
		}

		if (clase != null) {
			query.setParameter(5, clase);
		}

		return query.getResultList();
	}

	@Override
	public int maxCodPatente() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idPatente) FROM Patente p");
		Integer idPagosV = null;

		try {
			idPagosV = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idPagosV = null;
		}
		if (idPagosV == null) {
			idPagosV = 1;
		} else {
			++idPagosV;
		}
		return idPagosV;
	}

}
