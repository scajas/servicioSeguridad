package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.EmpleadoPublica;

/**
 * Session Bean implementation class EmpleadoPublicaDAOImplement
 */
@Stateless
@LocalBean
public class EmpleadoPublicaDAOImplement extends DaoGenericoImplement<EmpleadoPublica> implements EmpleadoPublicaDAO {
	
	@Override
	public List<EmpleadoPublica> finaAutoresporPublicacion(String tipo, Integer Idpub) throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from EmpleadoPublica s where s.pub.idPublic =?0   ");
		
		
		
		if(tipo != null)
		{
			queryString.append(" and s.tipo =?1 ");
		}
		
		queryString.append(" order by s.emp.apel ");
		
		
		Query query = getEntityManager().createQuery(queryString.toString());
		
		query.setParameter(0, Idpub);
		
		if(tipo != null)
		{
			query.setParameter(1, tipo);
		}
		
		
		
		
		return query.getResultList();
	}
	
	
	@Override
	public List<EmpleadoPublica> finaAutoresporPublicacionExiste(String tipo, String nced, Integer idpub) throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from EmpleadoPublica s where s.pub.idPublic =?0  and s.emp.nced =?1 order by s.emp.apel ");
		Query query = getEntityManager().createQuery(queryString.toString());
		
		query.setParameter(0, idpub);
		query.setParameter(1, nced);
		
		
		return query.getResultList();
	}
	
	@Override
	public int maxIDEmpleadoPublica() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(p.id) FROM EmpleadoPublica p");
		Integer idPagosV = null;

		try {
			idPagosV = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idPagosV = null;
		}
		if (idPagosV == null) {
			idPagosV = 1;
		} else {
			++idPagosV;
		}
		return idPagosV;
	}

    

}
