package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.Cronosubcapitulo;
import ec.edu.epn.silabo.entities.PiliticasDesarrollo;

/**
 * Session Bean implementation class CronosubcapituloDAOImplement
 */
@Stateless
@LocalBean
public class CronosubcapituloDAOImplement  extends DaoGenericoImplement<Cronosubcapitulo> implements CronosubcapituloDAO {

 
	
	
	@Override
	public List<Cronosubcapitulo> findCronobyid(Integer idcrono) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From Cronosubcapitulo e where e.cronograma.idCronograma = ?1 order by e.subcapitulo.capitulo.idCapitulo ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idcrono);

		return query.getResultList();

	}

	@Override
	public int maxId() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.id) FROM Cronosubcapitulo p");
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
	public List<Cronosubcapitulo> findCronobyidExiste(Integer idcrono, Integer idSubcapitulo) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From Cronosubcapitulo e where e.cronograma.idCronograma = ?1 and e.subcapitulo.idSubcapitulo =?2 ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idcrono);
		query.setParameter(2, idSubcapitulo);

		return query.getResultList();

	}
	
	@Override
	public void boorar(Cronosubcapitulo crono)
	{
		try {
			StringBuilder querys = new StringBuilder(
					"DELETE From Cronosubcapitulo e where e.id = ?1 ");
			Query query = getEntityManager().createQuery(querys.toString());
			query.setParameter(1, crono.getId());
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
