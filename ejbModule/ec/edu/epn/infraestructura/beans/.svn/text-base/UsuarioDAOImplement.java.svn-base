/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.seguridad.vo.Usuario;

/**
 * @author Administrador
 * 
 */
@Stateless
public class UsuarioDAOImplement extends DaoGenericoImplement<Usuario> implements UsuarioDAO {

	@Override
	public Usuario consultaXidUsuario(long idUsuario) {
		Query q = getEntityManager().createQuery("Select user from Usuario user where user.id = ?1");
		q.setParameter(1, idUsuario);
		return (Usuario) q.getSingleResult();
	}
}
