package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.Comentario;
import ec.edu.epn.proyectos.entities.Cronogramaavance;

/**
 * Session Bean implementation class ComentariosDAOImplement
 */
@Stateless
@LocalBean
public class ComentariosDAOImplement extends DaoGenericoImplement<Comentario> implements ComentariosDAO {

	@Override
	public List<Comentario> findComentarioByproyecto(String estado, Integer idproy, String cedula, String departamento,
			String tipo, String vips,Integer idpensum) {

		StringBuilder querys = new StringBuilder("SELECT e From Comentario e where e.cometario like ?1  ");

		if (estado != null) {

			querys.append(" and   e.estado = ?2  ");
		}

		if (idproy != 0) {

			querys.append(" and e.cierre.proyecto.idProy = ?3  ");
		}

		if (cedula != null) {

			querys.append(" and e.nced = ?4  ");
		}

		if (departamento != null) {

			querys.append(" and  e.coddep = ?5  ");
		}
		if (tipo != null) {

			querys.append(" and  e.tipo = ?6  ");
		}

		if (vips != null) {

			querys.append(" and  e.vips = ?7  ");
		}
		
		if (idpensum != 0) {

			querys.append(" and e.cierre.idPensum = ?8  ");
		}
		
		

		querys.append(" order by e.fecha DESC ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, "%");

		if (estado != null) {

			query.setParameter(2, estado);
		}

		if (idproy != 0) {

			query.setParameter(3, idproy);
		}

		if (cedula != null) {

			query.setParameter(4, cedula);
		}

		if (departamento != null) {

			query.setParameter(5, departamento);
		}
		if (tipo != null) {

			query.setParameter(6, tipo);
		}

		if (vips != null) {

			query.setParameter(7, vips);
		}
		
		if (idpensum != 0) {

			query.setParameter(8, idpensum);
		}

		return query.getResultList();

	}

}
