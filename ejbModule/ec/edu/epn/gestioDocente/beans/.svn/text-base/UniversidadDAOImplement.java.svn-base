package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Universidad;

/**
 * Session Bean implementation class UniversidadDAOImplement
 */
@Stateless
@LocalBean
public class UniversidadDAOImplement extends DaoGenericoImplement<Universidad> implements UniversidadDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Universidad> finsUniversidades(String idPais) throws Exception {

		StringBuilder queryString = new StringBuilder("SELECT s from Universidad s");

		if (idPais != null) {
			queryString.append(" where s.pais.idPais = ?1");
		}
		
		queryString.append(" order by s.nomUniversid");
		Query query = getEntityManager().createQuery(queryString.toString());		
		
		if (idPais != null) {
			query.setParameter(1, idPais );
		}	
		
		//List<Universidad> universidades = new ArrayList<Universidad>();		
		return query.getResultList();
		//return universidades;
	}
	
	
	
	
	
	
	
	
	
	

}
