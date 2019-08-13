package ec.edu.epn.gestioDocente.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.RecorridoPreplanificacion;;

/**
 * Session Bean implementation class RecorridoPreplanificacionDAOImplement
 */
@Stateless
@LocalBean
public class RecorridoPreplanificacionDAOImplement extends DaoGenericoImplement<RecorridoPreplanificacion>
		implements RecorridoPreplanificacionDAO {
	
	
	@Override
	public RecorridoPreplanificacion recorridoXEstado(Integer idPreplanificacion, String estadoActual) throws Exception{
		Query q = getEntityManager().createQuery(
				"Select max(rec) from RecorridoPreplanificacion rec where rec.preplanificacionDocencia.idPreplanif = ?1 and rec.estadoActual= ?2");
		q.setParameter(1, idPreplanificacion );
		q.setParameter(2, estadoActual);
		return (RecorridoPreplanificacion) q.getSingleResult();
	}
	
		
}
