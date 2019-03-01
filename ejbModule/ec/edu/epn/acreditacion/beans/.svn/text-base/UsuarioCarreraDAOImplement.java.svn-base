package ec.edu.epn.acreditacion.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.acreditacion.entities.UsuarioCarrera;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;


/**
 * Session Bean implementation class UsuarioCarreraDAOImplement
 */
@Stateless
@LocalBean
public class UsuarioCarreraDAOImplement extends DaoGenericoImplement<UsuarioCarrera> implements UsuarioCarreraDAO {

	@Override
	public List<UsuarioCarrera> consultarUsuarioCarrera(Integer Idusuario) {

		StringBuilder querys = new StringBuilder("SELECT e From UsuarioCarrera e where e.idUsuario = ?1 order by e.idUc  ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, Idusuario);
		return query.getResultList();

	}

}
