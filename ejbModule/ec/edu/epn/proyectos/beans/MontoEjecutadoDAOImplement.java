package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.Fondoadicional;
import ec.edu.epn.proyectos.entities.MontoEjecutado;

/**
 * Session Bean implementation class MontoEjecutadoDAOImplement
 */
@Stateless
public class MontoEjecutadoDAOImplement  extends DaoGenericoImplement<MontoEjecutado> implements MontoEjecutadoDAO {

	@Override
   	public List<MontoEjecutado> consultarMontoEjecutado(Integer idproyecto) {

   		StringBuilder querys = new StringBuilder("SELECT e From MontoEjecutado e where  e.proyecto.idProy = ?1 order by e.anio" );
   		Query query = getEntityManager().createQuery(querys.toString());
   		query.setParameter(1, idproyecto);
   		return query.getResultList();
   		
   	}
	
	
	@Override
   	public List<MontoEjecutado> consultarMontoEjecutadoExiste(Integer idproyecto,Integer anio) {

   		StringBuilder querys = new StringBuilder("SELECT e From MontoEjecutado e where  e.proyecto.idProy = ?1 and e.anio = ?2 order by e.anio" );
   		Query query = getEntityManager().createQuery(querys.toString());
   		query.setParameter(1, idproyecto);
   		query.setParameter(2, anio);
   		return query.getResultList();
   		
   	}

}
