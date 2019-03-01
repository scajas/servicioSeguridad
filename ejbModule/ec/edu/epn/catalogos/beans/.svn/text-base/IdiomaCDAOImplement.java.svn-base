package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.catalogos.entities.Idioma;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class IdiomaCDAOImplement
 */
@Stateless
@LocalBean
public class IdiomaCDAOImplement extends DaoGenericoImplement<Idioma> implements IdiomaCDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Idioma> finsAllIdiomas() throws Exception {

		Query query = getEntityManager().createNamedQuery("Idioma.findAll");
		return query.getResultList();
	}

}
