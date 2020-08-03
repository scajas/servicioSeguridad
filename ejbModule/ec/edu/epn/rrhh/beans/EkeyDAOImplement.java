package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Ekey;

/**
 * Session Bean implementation class EkeyDAOImplement
 */
@Stateless
public class EkeyDAOImplement extends DaoGenericoImplement<Ekey>implements EkeyDAO {

    /**
     * Default constructor. 
     */
    public EkeyDAOImplement() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    @Override
	public List<Ekey> findekeyByCodigo(String codigo) {
		Query q = getEntityManager().createQuery(
				"Select dep from Ekey dep   where dep.id.codigouser =?1 order by dep.id.id ");
		
		
		q.setParameter(1, codigo);

		return q.getResultList();
	}
    
    
    @Override
	public String consultarcoordenada(String letra, Integer numero) {

	
    	System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery(
				"SELECT "+ "e."+letra.toLowerCase() +" FROM  Ekey e where e.id.id =?1 ");

		String result = null;
		
		q.setParameter(1, numero);
		try {
			
			result = (String) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			

		}
		

		System.out.println("IDDDDDDDDDD" + result);
		return result;

	}

    

}
