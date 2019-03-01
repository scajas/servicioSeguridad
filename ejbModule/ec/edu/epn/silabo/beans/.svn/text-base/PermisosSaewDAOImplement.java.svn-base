package ec.edu.epn.silabo.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.PermisosSaew;
import ec.edu.epn.silabo.entities.PiliticasDesarrollo;
import ec.edu.epn.silabo.entities.Silabo;

/**
 * Session Bean implementation class PermisosSaewDAOImplement
 */
@Stateless
@LocalBean
public class PermisosSaewDAOImplement  extends DaoGenericoImplement<PermisosSaew> implements PermisosSaewDAO {

    
	@Override
	public List<PermisosSaew> consultarPermisosSAEW(String carrera, String anio, String semestre) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From PermisosSaew e where e.carrera = ?1 and e.anio = ?2 and e.semestre = ?3 order by e.idPermiso ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, carrera.trim());
		query.setParameter(2, anio.trim());
		query.setParameter(3, semestre.trim());

		return query.getResultList();

	}

	@Override
	public int maxId() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idPermiso) FROM PermisosSaew p");
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
	
	
	@Override
	public PermisosSaew consultarPermiso(Date fecha, String codcarre) {

		StringBuilder querys = new StringBuilder("SELECT e From PermisosSaew e where e.fecha = ?1 and e.carrera = ?2 ");
  
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, fecha);
		query.setParameter(2, codcarre);

		
		query.setMaxResults(1);
		
		try {
			PermisosSaew sib = (PermisosSaew) query.getSingleResult();
			return sib;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
