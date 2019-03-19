package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.RecursohPr;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 * Session Bean implementation class RecursoProyectoDAOImplement
 */
@Stateless
@LocalBean
public class RecursoProyectoDAOImplement extends DaoGenericoImplement<RecursohPr> implements RecursoProyectoDAO {

	@Override
	public List<String> findRecDirectorCedula() {
		Query qUsuario = getEntityManager().createQuery(
				"select DISTINCT(rec.nced) from RecursohPr rec where  " + " rec.rolProyecto.idRolProy = ?1 ");
		qUsuario.setParameter(1, 1);
		return qUsuario.getResultList();

	}

	@Override
	public List<RecursohPr> findRecDirector(String cedula) {
		Query qUsuario = getEntityManager()
				.createQuery("select rec from RecursohPr rec where  " + " rec.nced  like ?1 ");

		qUsuario.setParameter(1, cedula);
		return qUsuario.getResultList();

	}

	@Override
	public RecursohPr findDirector(int idProyecto) {
		Query qUsuario = getEntityManager().createQuery(
				"select reh from RecursohPr reh where reh.proyecto.idProy = ?1  and reh.rolProyecto.idRolProy = ?2 and reh.estadoPr = ?3 ");
		qUsuario.setParameter(1, idProyecto);
		qUsuario.setParameter(2, 1);
		qUsuario.setParameter(3, "VINCULADO");

		try {
			RecursohPr r = (RecursohPr) qUsuario.getSingleResult();

			return r;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public RecursohPr findDirectorbycedula(String cedula) {
		Query qUsuario = getEntityManager().createQuery(
				"select reh from RecursohPr reh where reh.nced = ?1  and reh.rolProyecto.idRolProy = ?2 and reh.estadoPr = ?3 ");
		qUsuario.setParameter(1, cedula);
		qUsuario.setParameter(2, 1);
		qUsuario.setParameter(3, "VINCULADO");

		try {
			RecursohPr r = (RecursohPr) qUsuario.getSingleResult();

			return r;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public List<RecursohPr> findrecProyExiste(Integer idproy, Integer idtipoRec) {
		Query qUsuario = getEntityManager().createQuery("select rec from RecursohPr rec where rec.proyecto.idProy = ?1 "
				+ " and rec.rolProyecto.idRolProy = ?2");
		qUsuario.setParameter(1, idproy);
		qUsuario.setParameter(2, idtipoRec);
		return qUsuario.getResultList();

	}

	@Override
	public List<RecursohPr> buscarRecursoExisteCedula(String nced, Integer idproy) throws Exception {

		Query qUsuario = getEntityManager()
				.createQuery("select tp from RecursohPr tp WHERE tp.nced = ?1 and tp.proyecto.idProy = ?2 ");
		qUsuario.setParameter(1, nced);
		qUsuario.setParameter(2, idproy);
		return qUsuario.getResultList();

	}

	@Override
	public List<RecursohPr> findrecProy(Integer idproy) {
		Query qUsuario = getEntityManager().createQuery(
				"select rec from RecursohPr rec where rec.proyecto.idProy = ?1 and rec.estadoPr = 'VINCULADO' order by rec.rolProyecto.idRolProy");
		qUsuario.setParameter(1, idproy);
		return qUsuario.getResultList();

	}

	@Override
	public List<RecursohPr> findAllDirectores() {
		Query qUsuario = getEntityManager().createQuery(
				"select reh from RecursohPr reh where  reh.rolProyecto.idRolProy = ?1 and reh.estadoPr = ?2 ");

		qUsuario.setParameter(1, 1);
		qUsuario.setParameter(2, "VINCULADO");

		try {
			return qUsuario.getResultList();

		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

}
