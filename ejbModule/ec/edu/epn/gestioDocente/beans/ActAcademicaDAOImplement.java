/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.ActAcademica;

/**
 * @author Administrador
 * 
 */
@Stateless
public class ActAcademicaDAOImplement extends
		DaoGenericoImplement<ActAcademica> implements ActAcademicaDAO {

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActAcademica> listActAcademTipo(Integer idPlanAcad, Integer idTipo) {
		String ncedSeleccion= "";
		
		
		Query q = getEntityManager().createQuery(
				"SELECT a FROM ActAcademica a WHERE a.planfActAcad.idPlanfActAcad=? AND a.idTipoPlanifActAcad=? ORDER BY idActAcademica" +
				ncedSeleccion);
		
		q.setParameter(1, idPlanAcad);
		q.setParameter(2, idTipo);
		
		
		return q.getResultList();
	}
	
	@Override
	public List<ActAcademica> listActAcademXPlanificacion(Integer idPlanAcad) {
		String ncedSeleccion= "";
		
		
		Query q = getEntityManager().createQuery(
				"SELECT a FROM ActAcademica a WHERE a.planfActAcad.idPlanfActAcad=? ORDER BY idActAcademica" +
				ncedSeleccion);
		
		q.setParameter(1, idPlanAcad);
		
		
		
		return q.getResultList();
	}
	
}
