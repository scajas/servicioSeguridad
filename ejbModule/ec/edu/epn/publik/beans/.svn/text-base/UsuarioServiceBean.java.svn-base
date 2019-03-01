package ec.edu.epn.publik.beans;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.RecursohPr;
import ec.edu.epn.seguridad.vo.Usuario;

@Stateless
public class UsuarioServiceBean extends DaoGenericoImplement<Usuario> implements UsuarioService {	
	

	@Override
	public Usuario consultaXidUsuario(Long idUsuario) {
		Query q = super.getEntityManager().createQuery("Select user from Usuario user where user.id = ?1");
		q.setParameter(1, idUsuario);
		return (Usuario) q.getSingleResult();
	}
	
	@Override
	public String getCedulaUsuario(Long idUsuario) {
		Query q = super.getEntityManager().createQuery("Select user.cedula from Usuario user where user.id = ?1");
		q.setParameter(1, idUsuario);
		return (String) q.getSingleResult();
	}
	
	
	@Override
	public Usuario usuarioPorCedula(String cedula) {
		Query q = super.getEntityManager().createQuery("Select user from Usuario user where user.cedula = ?1");
		q.setParameter(1, cedula);
		
		try {
			Usuario r = (Usuario) q.getSingleResult();
			return r;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}
		
	}

}
