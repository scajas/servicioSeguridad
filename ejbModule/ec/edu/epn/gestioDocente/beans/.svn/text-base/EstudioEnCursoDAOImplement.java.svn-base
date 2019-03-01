package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.EstudioEnCurso;

/**
 * Session Bean implementation class PaisDAOImplement
 */
@Stateless
@LocalBean
public class EstudioEnCursoDAOImplement extends DaoGenericoImplement<EstudioEnCurso> implements EstudioEnCursoDAO {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstudioEnCurso> buscarEstudiosEnCursoDocente(String cedula) throws Exception{
		StringBuilder queryString = new StringBuilder(
				"SELECT e FROM EstudioEnCurso e WHERE e.emp.nced = ?1 ORDER BY fecha_ingreso DESC");
		
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		
		return query.getResultList();
	};
		
	
	
	
}
