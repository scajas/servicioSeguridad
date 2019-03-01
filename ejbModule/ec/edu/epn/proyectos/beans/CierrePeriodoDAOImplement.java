package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.CierrePeriodo;

/**
 * Session Bean implementation class CierrePeriodoDAOImplement
 */
@Stateless
@LocalBean
public class CierrePeriodoDAOImplement extends DaoGenericoImplement<CierrePeriodo> implements CierrePeriodoDAO {

	@Override
	public List<CierrePeriodo> consultarCierreProyecto(Integer idproy, Integer idpensun, String tipo) {

		StringBuilder querys = new StringBuilder("SELECT e From CierrePeriodo e where e.proyecto.idProy = ?1  ");

		if (idpensun != 0) {
			querys.append(" and e.idPensum = ?2 ");

		}

		if (tipo != null) {
			querys.append(" and e.tipo = ?3 ");

		}

		querys.append(" order by e.meses DESC");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idproy);

		if (idpensun != 0) {
			query.setParameter(2, idpensun);

		}

		if (tipo != null) {
			query.setParameter(3, tipo);

		}
		return query.getResultList();

	}

	@Override
	public CierrePeriodo consultarCierreProyectoPensum(Integer idproy, Integer idpensun, String tipo, String cerrado) {

		try {

			StringBuilder querys = new StringBuilder(
					"SELECT e From CierrePeriodo e where e.proyecto.idProy = ?1 and e.cerrado = ?2  ");

			if (idpensun != 0) {
				querys.append(" and e.idPensum = ?3 ");

			}

			if (tipo != null) {
				querys.append(" and e.tipo = ?4 ");

			}

			querys.append(" order by e.meses DESC");

			Query query = getEntityManager().createQuery(querys.toString());
			query.setParameter(1, idproy);
			query.setParameter(2, cerrado);

			if (idpensun != 0) {
				query.setParameter(3, idpensun);

			}

			if (tipo != null) {
				query.setParameter(4, tipo);

			}
			return (CierrePeriodo) query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}

		catch (NonUniqueResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<CierrePeriodo> consultarCierreProyectoDept(String estado, String coddep) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From CierrePeriodo e where e.cerrado = ?1 and e.proyecto.coddep  = ?2 ");
		querys.append(" order by e.meses DESC");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, estado);
		query.setParameter(2, coddep);

		return query.getResultList();

	}

	@Override
	public List<CierrePeriodo> consultarCierres() {

		StringBuilder querys = new StringBuilder(
				"SELECT e From CierrePeriodo e where e.cerrado = 'S' order by e.proyecto.codigoPr ");

		Query query = getEntityManager().createQuery(querys.toString());

		return query.getResultList();

	}

}
