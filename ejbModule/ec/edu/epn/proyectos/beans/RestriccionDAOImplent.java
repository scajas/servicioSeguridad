package ec.edu.epn.proyectos.beans;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.RecursohPr;
import ec.edu.epn.proyectos.entities.Restringerecurso;

/**
 * Session Bean implementation class RestriccionDAOImplent
 */
@Stateless
public class RestriccionDAOImplent extends DaoGenericoImplement<Restringerecurso> implements RestriccionDAO {

    
	@Override
	public Restringerecurso findRestriccionRecurso(int idtipoProyecto, int idrol) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select reh from Restringerecurso reh where reh.idtipoproy = ?1  and reh.idrol = ?2 ");
		qUsuario.setParameter(1, idtipoProyecto);
		qUsuario.setParameter(2, idrol);

		try {
			Restringerecurso r = (Restringerecurso) qUsuario.getSingleResult();

			return r;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}
	
	
	
	
	
}
