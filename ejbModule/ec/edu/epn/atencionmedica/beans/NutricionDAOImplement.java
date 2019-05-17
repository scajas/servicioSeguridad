package ec.edu.epn.atencionmedica.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.atencionmedica.entities.Nutricion;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

@Stateless
@LocalBean
public class NutricionDAOImplement extends DaoGenericoImplement<Nutricion> implements NutricionDAO {
	
	
	@Override
	public Nutricion nutricionXIdAsistencia(Integer idAsistenciaMedica){
		
		Query query = null;
		String q ="";
		StringBuilder queryString = null;
		
		try {
			q = "SELECT nut FROM Nutricion nut WHERE nut.idAtencionmed = ?0 ";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, idAsistenciaMedica);
			
			return (Nutricion) query.getSingleResult();
		} catch (Exception e) {
			return null;
			
		}
	}
	
	
}
