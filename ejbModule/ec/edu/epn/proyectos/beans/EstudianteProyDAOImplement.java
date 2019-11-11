package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.EstudianteProy;
import ec.edu.epn.proyectos.entities.Proyectocarrera;
import ec.edu.epn.proyectos.entities.RecursohPr;

/**
 * Session Bean implementation class EstudianteProyDAOImplement
 */
@Stateless
@LocalBean
public class EstudianteProyDAOImplement  extends DaoGenericoImplement<EstudianteProy> implements EstudianteProyDAO {
	
	
	@Override
	public List<EstudianteProy> findEstProy(Integer idproy) {
		Query qUsuario = getEntityManager()
				.createQuery("select rec from EstudianteProy rec where rec.proyecto.idProy = ?1 order by rec.nombre ");
		qUsuario.setParameter(1, idproy);
		return qUsuario.getResultList();

	}
	
	
	@Override
	public List<EstudianteProy> findEstProyExiste(Integer idproy,String nced) {
		Query qUsuario = getEntityManager()
				.createQuery("select rec from EstudianteProy rec where rec.proyecto.idProy = ?1 and rec.cedula = ?2 order by rec.nombre ");
		qUsuario.setParameter(1, idproy);
		qUsuario.setParameter(2, nced);
		return qUsuario.getResultList();

	}
	
	@Override
	public List<EstudianteProy> findEstProyFaltante(Integer idproy, Integer idpensum, String tipo) {
		Query qUsuario = getEntityManager().createQuery(
				"select rec from EstudianteProy rec where rec.proyecto.idProy = ?1    "
				+ " and rec.id NOT IN (SELECT a.estudiante.id  FROM Avanceestud a where a.idPensum  = ?2 and a.tipo = ?3 )" );
		qUsuario.setParameter(1, idproy);
		qUsuario.setParameter(2, idpensum);
		qUsuario.setParameter(3, tipo);
		return qUsuario.getResultList();

	}




    
}
