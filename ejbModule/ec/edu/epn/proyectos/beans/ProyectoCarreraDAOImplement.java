package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.Proyectocarrera;
import ec.edu.epn.proyectos.entities.RecursohPr;

/**
 * Session Bean implementation class ProyectoCarreraDAOImplement
 */
@Stateless
@LocalBean
public class ProyectoCarreraDAOImplement extends DaoGenericoImplement<Proyectocarrera> implements ProyectoCarreraDAO {

	@Override
	public List<Proyectocarrera> findCarreproy(Integer idproy) {
		Query qUsuario = getEntityManager()
				.createQuery("select rec from Proyectocarrera rec where rec.proyecto.idProy = ?1 order by rec.nombre ");
		qUsuario.setParameter(1, idproy);
		return qUsuario.getResultList();

	}

	@Override
	public List<Proyectocarrera> findCarreproyExiste(Integer idproy, String nombre) {
		Query qUsuario = getEntityManager().createQuery(
				"select rec from Proyectocarrera rec where rec.proyecto.idProy = ?1 and rec.nombre = ?2 order by rec.nombre ");
		qUsuario.setParameter(1, idproy);
		qUsuario.setParameter(2, nombre);
		return qUsuario.getResultList();

	}

}
