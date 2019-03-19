/**
 * 
 */
package ec.edu.epn.publik.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.publik.entities.PerfilUsuario;
import ec.edu.epn.seguridad.vo.Perfil;

/**
 * @author Administrador
 * 
 */
@Stateless
public class PerfilDAOImplement extends DaoGenericoImplement<Perfil> implements PerfilDAO {

	@Override
	public Perfil buscarPerfilPorNombre(String nombre) {
		Query q = getEntityManager().createQuery("Select p from Perfil as p where p.nombre=?1");
		q.setParameter(1, nombre);
		return (Perfil) q.getSingleResult();
	}

	@Override
	public Perfil buscarbyID(Long id) {
		Query q = getEntityManager().createQuery("Select p from Perfil as p where p.id=?1");
		q.setParameter(1, id);
		return (Perfil) q.getSingleResult();
	}

	@Override
	public List<PerfilUsuario> buscarbyIDALL(Integer id) {
		Query q = getEntityManager().createQuery("Select p from PerfilUsuario as p where p.id.idPerfil=?1");
		q.setParameter(1, id);
		return q.getResultList();
	}
}
