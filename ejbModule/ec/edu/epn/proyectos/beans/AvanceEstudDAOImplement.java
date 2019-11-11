package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.Avanceestud;
import ec.edu.epn.proyectos.entities.EstudianteProy;
import ec.edu.epn.proyectos.entities.Recursoavance;

/**
 * Session Bean implementation class AvanceEstudDAOImplement
 */
@Stateless
@LocalBean
public class AvanceEstudDAOImplement extends DaoGenericoImplement<Avanceestud> implements AvanceEstudDAO {

    
	@Override
	public List<Avanceestud> findAvanceEstudProy(Integer idproy, Integer id_pensum,String tipo) {
		Query qUsuario = getEntityManager()
				.createQuery("select rec from Avanceestud rec where rec.estudiante.proyecto.idProy = ?1 and rec.idPensum = ?2 and rec.tipo = ?3  order by rec.estudiante.nombre ");
		qUsuario.setParameter(1, idproy);
		qUsuario.setParameter(2, id_pensum);
		qUsuario.setParameter(3, tipo);
		return qUsuario.getResultList();

	}
	
	
	@Override
	public List<Avanceestud> findAvanceEstudProyExiste(Integer idproy, Integer id_pensum,String tipo,Integer idEstud) {
		Query qUsuario = getEntityManager()
				.createQuery("select rec from Avanceestud rec where rec.estudiante.proyecto.idProy = ?1 and rec.idPensum = ?2 and rec.tipo = ?3   and rec.estudiante.id = ?4 order by rec.estudiante.nombre ");
		qUsuario.setParameter(1, idproy);
		qUsuario.setParameter(2, id_pensum);
		qUsuario.setParameter(3, tipo);
		qUsuario.setParameter(4, idEstud);
		return qUsuario.getResultList();

	}
	
	
	@Override
	public Long countObjtvAvanceEst(Integer idEstudiante) {
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(oa) FROM  Avanceestud oa WHERE oa.estudiante.id= ? ");
			
		q.setParameter(1, idEstudiante);		
		return (Long) q.getSingleResult();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Avanceestud findByProyectoReportePlanificada(Integer Idestud, Integer idpensum, String tipo) {

		try {

			StringBuilder queryString = new StringBuilder(
					"SELECT plan FROM Avanceestud plan where plan.estudiante.id = ?1 and plan.idPensum = ?2 and plan.tipo =  ?3 ");

			Query query = getEntityManager().createQuery(queryString.toString());

			query.setParameter(1, Idestud);
			query.setParameter(2, idpensum);
			query.setParameter(3, tipo);

			return (Avanceestud) query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
