/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.MateriaDocenteSae;

/**
 * @author EPN
 * 
 */
@Stateless
public class MateriaDocenteSaeDAOImplement extends
		DaoGenericoImplement<MateriaDocenteSae> implements MateriaDocenteSaeDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<MateriaDocenteSae> listMateriaDoc(String nced)
			throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT m FROM MateriaDocenteSae m WHERE m.nCed=? ORDER BY periodo DESC ");
		
		q.setParameter(1, nced);
		
		return q.getResultList();
	}
	
	
	
}
