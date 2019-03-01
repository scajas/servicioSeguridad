
package ec.edu.epn.gestioDocente.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.ResultadoEval;

/**
 * @author Administrador
 * 
 */
@Stateless
public class ResultadoEvalDAOImplement extends
		DaoGenericoImplement<ResultadoEval> implements ResultadoEvalDAO {

	@Override
	public Long countPregEvalDocente(String nced, Integer idPensum, String tipoEval, String ncedDir)
			throws Exception {
		String ncedSeleccion= "";		
		ncedSeleccion= "AND r.nced=?";
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(r) FROM ResultadoEval r WHERE r.idPensum=? AND r.tipoEval= ? " +
						ncedSeleccion);

		
		q.setParameter(1, idPensum);
		q.setParameter(2, tipoEval);		
		q.setParameter(3, nced);
		
		
		return (Long) q.getSingleResult();
	}
	
	
	@Override
	public ResultadoEval buscarXCedulaResultEval(String nced, Integer idPensum, String tipoEval, String ncedDir) {
		String ncedSeleccion= "";		
		ncedSeleccion= "AND r.nced=?";
		
		Query q = getEntityManager().createQuery(
				"SELECT r FROM ResultadoEval r WHERE r.idPensum=? AND r.tipoEval= ? " +
				ncedSeleccion);
		
		q.setParameter(1, idPensum);
		q.setParameter(2, tipoEval);
		q.setParameter(3, nced);		
		return (ResultadoEval) q.getSingleResult();
	}
	

}
