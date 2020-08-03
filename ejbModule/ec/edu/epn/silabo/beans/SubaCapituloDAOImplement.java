package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.Capitulo;
import ec.edu.epn.silabo.entities.Subcapitulo;

/**
 * Session Bean implementation class SubaCapituloDAOImplement
 */
@Stateless
@LocalBean
public class SubaCapituloDAOImplement  extends DaoGenericoImplement<Subcapitulo> implements SubaCapituloDAO {

	@Override
	public int maxIdSubCapitulo() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idSubcapitulo) FROM Subcapitulo p");
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
	public List<Subcapitulo> consultarSubCapitulos(Integer idsilado) {

		StringBuilder querys = new StringBuilder("SELECT e From Subcapitulo e where e.capitulo.silabo.idSilabo = ?1  order by e.capitulo.numeroCap" );

		

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);

		return query.getResultList();
		
		
		
	}
	
	@Override
	public Subcapitulo consultarIdSubcapitulo(Integer idsubcapitulo) {

		StringBuilder querys = new StringBuilder("SELECT e From Subcapitulo e where e.idSubcapitulo = ?1 " );

	
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsubcapitulo);

		return (Subcapitulo)query.getSingleResult();
		
		
		
	}
	
	@Override
	public List<Subcapitulo> consultarSubcapitlosdeCapitulo(Integer idcapitulo) {

		StringBuilder querys = new StringBuilder("SELECT e From Subcapitulo e where e.capitulo.idCapitulo = ?1 order by e.numeroCp " );

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idcapitulo);

		return query.getResultList();
		
		
		
	}
	
	@Override
	public List<Subcapitulo> consultarSubCapitulosExiste(Integer idsilado, String num, Integer idcapitulo) {

		StringBuilder querys = new StringBuilder("SELECT e From Subcapitulo e where e.capitulo.silabo.idSilabo = ?1  and e.numeroCp = ?2  and e.capitulo.idCapitulo = ?3 " );

	
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsilado);
		query.setParameter(2, num);
		query.setParameter(3, idcapitulo);

		return query.getResultList();
		
		
		
	}
	
	
	@Override
	public void eliminar(Integer idsubcapitulo) {

		StringBuilder querys = new StringBuilder("Delete From Subcapitulo e where e.idSubcapitulo = ?1  " );

	
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsubcapitulo);

		 query.executeUpdate();
		
		
		
	}
	

}
