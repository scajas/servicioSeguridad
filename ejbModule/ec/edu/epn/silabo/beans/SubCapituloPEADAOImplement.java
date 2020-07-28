package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.Subcapitulo;
import ec.edu.epn.silabo.entities.SubcapituloPea;

/**
 * Session Bean implementation class SubCapituloPEADAOImplement
 */
@Stateless
@LocalBean
public class SubCapituloPEADAOImplement extends DaoGenericoImplement<SubcapituloPea> implements SubCapituloPEADAO {

	@Override
	public List<SubcapituloPea> consultarSubCapitulosExiste(Integer idpea, String num, Integer idcapitulo) {

		StringBuilder querys = new StringBuilder("SELECT e From SubcapituloPea e where e.capituloPea.pea.idPea = ?1  and e.numeroCp = ?2  and e.capituloPea.idCapitulo = ?3 " );

	
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idpea);
		query.setParameter(2, num);
		query.setParameter(3, idcapitulo);

		return query.getResultList();
		
	}
	
	
	@Override
	public List<SubcapituloPea> consultarSubcapitlosdeCapitulo(Integer idcapitulo) {

		StringBuilder querys = new StringBuilder("SELECT e From SubcapituloPea e where e.capituloPea.idCapitulo = ?1 order by e.numeroCp " );

	
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idcapitulo);

		return query.getResultList();
		
		
		
	}
	
	@Override
	public void eliminar(Integer idsubcapitulo) {

		StringBuilder querys = new StringBuilder("Delete From SubcapituloPea e where e.idSubcapitulo = ?1  " );

	
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idsubcapitulo);

		 query.executeUpdate();
		
		
		
	}

}
