package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import ec.edu.epn.laboratorioBJ.entities.Existencia;
import ec.edu.epn.laboratorioBJ.entities.Movimientosinventario;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;


@Stateless
@LocalBean
public class MovimientoInventarioLabDAOImplement extends DaoGenericoImplement<Movimientosinventario> implements MovimientoInventarioLabDAO {

    /**
     * Default constructor. 
     */
    public MovimientoInventarioLabDAOImplement() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public Existencia buscarExistenciaById(String id) {
		
		StringBuilder querys = new StringBuilder("SELECT e FROM Existencia e where e.idExistencia = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, id);
		query.setMaxResults(1);

		try {
			Existencia existencia = (Existencia) query.getSingleResult();
			return existencia;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}


}
