/**
 * 
 */
package ec.edu.epn.contratos.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class PensumDAOImplement extends DaoGenericoImplement<Pensum> implements PensumDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(act.idPensum) FROM Pensum pen");
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
	public Pensum obtenerPensumVigente() {
		Query q = getEntityManager().createQuery("SELECT pen FROM Pensum pen where pen.estado like '%V%'");
		return (Pensum) q.getSingleResult();
	}

	@Override
	public Pensum obtenerPensumXAnterior(int idPensumAnterior) {
		try {
			Query q = getEntityManager().createQuery("SELECT pen FROM Pensum pen where pen.idPensumAnterior = ?0");
			q.setParameter(0, idPensumAnterior);
			return (Pensum) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pensum> listaPensumOrdenAsc() {
		Query q = getEntityManager().createQuery("SELECT pen FROM Pensum pen order by pen.idPensum desc");

		return q.getResultList();
	}

	/**
	 * Lista las entidades pensum ordenado descendente o ascendentemete
	 * 
	 * @param orden
	 *            - string para escribir el orden que quiere desplegar la lista
	 *            : asc Ã³ desc
	 * @return lista de entidades por el orden enviado
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Pensum> listaPensum(String orden) {
		StringBuilder sbQuery = new StringBuilder();
		sbQuery.append(" SELECT pen FROM Pensum pen ");
		sbQuery.append(" ORDER BY CONCAT(pen.añoPensum, '-' ,pen.numeroPensum) ");
		sbQuery.append(orden);
		Query q = getEntityManager().createQuery(sbQuery.toString());
		return q.getResultList();
	}

	@Override
	public Pensum obtenerPensumById(Integer idpensum) {
		Query q = getEntityManager().createQuery("SELECT pen FROM Pensum pen where pen.idPensum = ?1 ");

		q.setParameter(1, idpensum);
		return (Pensum) q.getSingleResult();
	}

	@Override
	public List<Pensum> listaPensumXFechaActual(String tipoEvaluacion) {

		StringBuilder sbQuery = new StringBuilder();
		sbQuery.append(" SELECT pen FROM Pensum pen");
		if (tipoEvaluacion.equals("PLANIF")) {
			sbQuery.append(" WHERE pen.fechaPlanif>= ?");

		} else if (tipoEvaluacion.equals("AUTOEVAL")) {
			sbQuery.append(" WHERE pen.fechaAuto>= ?");

		} else if (tipoEvaluacion.equals("COEVAL")) {
			sbQuery.append(" WHERE pen.fechaCoe>= ?");
			
		} else if (tipoEvaluacion.equals("PREPLANIF")) {
			sbQuery.append(" WHERE pen.fechaPreplanif>= ?");
		}
		

		// sbQuery.append(" ORDER BY CONCAT(CAST(pen.añoPensum AS integer), '-'
		// ,CAST(pen.numeroPensum AS integer)) ");
		// sbQuery.append("DESC");
		sbQuery.append(" ORDER BY pen.añoPensum DESC ");
		Query q = getEntityManager().createQuery(sbQuery.toString());
		q.setParameter(1, new Date());
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pensum> listaPensumVIPS(String orden) {
		StringBuilder sbQuery = new StringBuilder();
		sbQuery.append(" SELECT pen FROM Pensum pen where pen.visibledips = 'S' ");
		sbQuery.append(" ORDER BY CONCAT(pen.añoPensum, '-' ,pen.numeroPensum) ");
		sbQuery.append(orden);
		Query q = getEntityManager().createQuery(sbQuery.toString());
		return q.getResultList();
	}

	@Override
	public Pensum obtenerPensumSilaboTemporalRG(String estado) {
		Query q = getEntityManager().createQuery("SELECT pen FROM Pensum pen where pen.estado = ?1 ");

		q.setParameter(1, estado);
		return (Pensum) q.getSingleResult();
	}

	@Override
	public List<Pensum> listaPensumXFechaActualInvestigacion(String tipoInforme) {

		StringBuilder sbQuery = new StringBuilder();
		sbQuery.append(" SELECT pen FROM Pensum pen");
		if (tipoInforme.equals("P")) {
			sbQuery.append(" WHERE pen.vipsplanifica>= ?");

		} else if (tipoInforme.equals("R")) {
			sbQuery.append(" WHERE pen.vipsreporta>= ?");

		}
		// sbQuery.append(" ORDER BY CONCAT(CAST(pen.añoPensum AS integer), '-'
		// ,CAST(pen.numeroPensum AS integer)) ");
		// sbQuery.append("DESC");
		sbQuery.append(" ORDER BY pen.añoPensum DESC ");
		Query q = getEntityManager().createQuery(sbQuery.toString());
		q.setParameter(1, new Date());
		return q.getResultList();
	}
}
