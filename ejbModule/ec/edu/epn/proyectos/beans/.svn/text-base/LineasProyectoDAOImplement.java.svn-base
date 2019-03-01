package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.Lineasproy;

/**
 * Session Bean implementation class LineasProyectoDAOImplement
 */
@Stateless
@LocalBean
public class LineasProyectoDAOImplement extends DaoGenericoImplement<Lineasproy> implements LineasProyectoDAO {


	@Override
	public List<Lineasproy> findLineasProy(Integer idProyect) {
		Query qUsuario = getEntityManager().createQuery(
				"select pr from Lineasproy pr where pr.proyecto.idProy = ?1");

		qUsuario.setParameter(1, idProyect);

		return qUsuario.getResultList();

	}

}
