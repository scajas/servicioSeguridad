package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.Recursoavance;
import ec.edu.epn.rrhh.entities.Emp;

/**
 * Session Bean implementation class RecursoAvanceDAOImplement
 */
@Stateless
@LocalBean
public class RecursoAvanceDAOImplement extends DaoGenericoImplement<Recursoavance> implements RecursoAvanceDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Recursoavance> findByrecurso(Integer Idrecurso, String tipo) {

		StringBuilder queryString = new StringBuilder(
				"SELECT plan FROM Recursoavance plan where plan.recurso.idRhPr = ?1 and plan.tipo = ?2  order by plan.recurso.rolProyecto.idRolProy");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, Idrecurso);
		query.setParameter(2, tipo);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recursoavance> findByrecursoExiste(Integer Idrecurso, Integer idpensum, String tipo) {

		StringBuilder queryString = new StringBuilder(
				"SELECT plan FROM Recursoavance plan where plan.recurso.idRhPr = ?1 and plan.idpensum = ?2 and plan.tipo =  ?3 order by plan.recurso.rolProyecto.idRolProy");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, Idrecurso);
		query.setParameter(2, idpensum);
		query.setParameter(3, tipo);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recursoavance> findByProyectoReporte(Integer Idproyecto, Integer idpensum, String tipo) {

		StringBuilder queryString = new StringBuilder(
				"SELECT plan FROM Recursoavance plan where plan.recurso.proyecto.idProy = ?1 and plan.idpensum = ?2 and plan.tipo =  ?3 order by plan.recurso.rolProyecto.idRolProy ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, Idproyecto);
		query.setParameter(2, idpensum);
		query.setParameter(3, tipo);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Recursoavance findByProyectoReportePlanificada(Integer Idrecurso, Integer idpensum, String tipo) {

		try {

			StringBuilder queryString = new StringBuilder(
					"SELECT plan FROM Recursoavance plan where plan.recurso.idRhPr = ?1 and plan.idpensum = ?2 and plan.tipo =  ?3 order by plan.recurso.rolProyecto.idRolProy");

			Query query = getEntityManager().createQuery(queryString.toString());

			query.setParameter(1, Idrecurso);
			query.setParameter(2, idpensum);
			query.setParameter(3, tipo);

			return (Recursoavance) query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
