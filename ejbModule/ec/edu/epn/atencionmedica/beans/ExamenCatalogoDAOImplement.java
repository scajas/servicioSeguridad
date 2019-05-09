/**
 * 
 */
package ec.edu.epn.atencionmedica.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.atencionmedica.entities.ExamenCatalogo;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author EPN
 * 
 */
@Stateless
public class ExamenCatalogoDAOImplement extends
		DaoGenericoImplement<ExamenCatalogo> implements ExamenCatalogoDAO {
	
	
	
	@Override
	public List<ExamenCatalogo> listCatalogoExamenes(String examenes){				
		String[] parts= examenes.split(",");
		List<String> list = new ArrayList<String>();
		
		for(int i=0; i<parts.length; i++){
			list.add(parts[i]);
		}
		
		StringBuilder queryString = new StringBuilder("SELECT c FROM ExamenCatalogo c WHERE c.orden IN :list ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("1ist", list);		
		
		return query.getResultList();
	}
	
	
}
