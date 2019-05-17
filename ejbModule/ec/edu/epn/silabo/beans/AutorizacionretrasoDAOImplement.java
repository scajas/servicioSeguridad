package ec.edu.epn.silabo.beans;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Ceduofi;
import ec.edu.epn.silabo.entities.Autorizacionretraso;
import ec.edu.epn.silabo.entities.PermisosSaew;

/**
 * Session Bean implementation class AutorizacionretrasoDAOImplement
 */
@Stateless
@LocalBean
public class AutorizacionretrasoDAOImplement extends DaoGenericoImplement<Autorizacionretraso> implements AutorizacionretrasoDAO {


	@Override
	public Autorizacionretraso consultarAutorizacion(String nced, String codMat, Integer idPensum, String paralelo,  String codcarrera, String año ) {

		StringBuilder querys = new StringBuilder("SELECT e From Autorizacionretraso e where e.cedula = ?1 and e.codigo = ?2 and e.idPensum=?3 and e.paralelo = ?4 and e.codcarrera = ?5 and e.anio = ?6 ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, nced);
		query.setParameter(2, codMat);
		query.setParameter(3, idPensum);
		query.setParameter(4, paralelo);
		query.setParameter(5, codcarrera);
		query.setParameter(6, año);
		query.setMaxResults(1);

		try {
			Autorizacionretraso sib = (Autorizacionretraso) query.getSingleResult();
			return sib;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}
		finally {
			getEntityManager().close();
		}
		
		
		
	}
	
	
	@Override
	public int maxIdAutorizacion() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idAutoriza) FROM Autorizacionretraso p");
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
