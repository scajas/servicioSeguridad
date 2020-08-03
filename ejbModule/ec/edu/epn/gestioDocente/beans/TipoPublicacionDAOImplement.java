package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.TipoPublicacion;

/**
 * Session Bean implementation class TipoPublicacionDAOImplement
 */
@Stateless
@LocalBean
public class TipoPublicacionDAOImplement extends DaoGenericoImplement<TipoPublicacion> implements TipoPublicacionDAO {

	@SuppressWarnings("unchecked")
	@Override
	public TipoPublicacion findById(String id) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM TipoPublicacion fam where fam.idTipoPublic = ?1   order by fam.idTipoPublic  ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id.trim());

		return (TipoPublicacion) query.getSingleResult();

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPublicacion> findAllTipos() {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM TipoPublicacion fam order by fam.idTipoPublic  ");

		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();

	}
	
}
