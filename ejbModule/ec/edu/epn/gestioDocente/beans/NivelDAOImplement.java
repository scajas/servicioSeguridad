package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.NivelTitulo;

/**
 * Session Bean implementation class NivelDAOImplement
 */
@Stateless
@LocalBean
public class NivelDAOImplement  extends DaoGenericoImplement<NivelTitulo> implements NivelDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<NivelTitulo> finsAllNiveles() throws Exception {

		Query query = getEntityManager().createNamedQuery("NivelTitulo.findAll");
		return query.getResultList();
	}
	
	
	
	
	

}
