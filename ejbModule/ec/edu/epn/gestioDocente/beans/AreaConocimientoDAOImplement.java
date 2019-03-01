package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.AreaConocimiento;

/**
 * Session Bean implementation class AreaConocimientoDAOImplement
 */
@Stateless
@LocalBean
public class AreaConocimientoDAOImplement extends DaoGenericoImplement<AreaConocimiento> implements AreaConocimientoDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<AreaConocimiento> finsAllareas() throws Exception {

		Query query = getEntityManager().createNamedQuery("AreaConocimiento.findAll");
		return query.getResultList();
	}
	
	@Override
	public AreaConocimiento buscarAreaByID(String cod) throws Exception {
		
		
		StringBuilder queryString = new StringBuilder(
				"SELECT s from AreaConocimiento s where s.idAreaCon = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cod);
		
	
		
		
		
		return (AreaConocimiento) query.getSingleResult();
	}
	
	
	
	
	

}
