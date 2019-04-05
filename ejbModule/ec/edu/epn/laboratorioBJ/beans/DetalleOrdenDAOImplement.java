package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Detalleorden;
import ec.edu.epn.laboratorioBJ.entities.Metodo;

/**
 * Session Bean implementation class DetalleOrdenDAOImplement
 */
@Stateless
@LocalBean
public class DetalleOrdenDAOImplement extends DaoGenericoImplement<Detalleorden> implements DetalleOrdenDAO {

    /**
     * Default constructor. 
     */
    public DetalleOrdenDAOImplement() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public Metodo findMetodoById(String id) {
		StringBuilder querys = new StringBuilder(
				"SELECT e FROM Metodo e where e.idMetodo = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, id);
		query.setMaxResults(1); 

		try {
			Metodo metodo = (Metodo) query.getSingleResult();
			return metodo;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

}
