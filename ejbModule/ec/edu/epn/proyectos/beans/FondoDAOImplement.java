package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.DisciplinaProyecto;
import ec.edu.epn.proyectos.entities.Fondoadicional;

/**
 * Session Bean implementation class FondoDAOImplement
 */
@Stateless
public class FondoDAOImplement extends DaoGenericoImplement<Fondoadicional> implements FondoDAO {

    
	
	@Override
   	public List<Fondoadicional> consultarFondosProyecto(Integer idproyecto) {

   		StringBuilder querys = new StringBuilder("SELECT e From Fondoadicional e where  e.proyecto.idProy = ?1 order by e.institucion" );
   		Query query = getEntityManager().createQuery(querys.toString());
   		query.setParameter(1, idproyecto);
   		return query.getResultList();
   		
   	}
	

}
