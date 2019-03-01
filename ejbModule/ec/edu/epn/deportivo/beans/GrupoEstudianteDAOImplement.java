/**
 * 
 */
package ec.edu.epn.deportivo.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.deportivo.entities.Deporte;
import ec.edu.epn.deportivo.entities.Estudiante;
import ec.edu.epn.deportivo.entities.GrupoEstudiante;
import ec.edu.epn.deportivo.entities.Planificacion;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class GrupoEstudianteDAOImplement extends DaoGenericoImplement<GrupoEstudiante> implements GrupoEstudianteDAO {

	@Override
	public List<GrupoEstudiante> findxPlanificacion(Planificacion planif) {
		try {
			StringBuilder queryString = new StringBuilder(
					"SELECT p FROM GrupoEstudiante p WHERE p.planificacion.idPlanificacion = ?1 ");
			queryString.append(" ORDER BY p.planificacion.idPlanificacion ");

			Query query = getEntityManager().createQuery(queryString.toString());

			if (planif != null) {
				query.setParameter(1, planif.getIdPlanificacion());
			}

			return query.getResultList();

		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<GrupoEstudiante> findxDepEstu(Deporte dep, Estudiante est) {
		try {
			StringBuilder queryString = new StringBuilder(
					"SELECT p FROM GrupoEstudiante p WHERE p.planificacion.deporte.idDeporte = ?1 and p.estudiante.nombresEstudiantes like ?2");

			Query query = getEntityManager().createQuery(queryString.toString());

			if (dep != null) {
				query.setParameter(1, dep.getIdDeporte());
			}

			if (est != null) {
				query.setParameter(2, "%" + est.getNombresEstudiantes() + "%");
			}

			return query.getResultList();

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<GrupoEstudiante> findxEstu(Estudiante est) {
		try {
			StringBuilder queryString = new StringBuilder(
					"SELECT p FROM GrupoEstudiante p WHERE p.estudiante.idEstudiantes like ?1");

			Query query = getEntityManager().createQuery(queryString.toString());

			if (est != null) {
				query.setParameter(1, est.getIdEstudiantes());
			}

			return query.getResultList();

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<GrupoEstudiante> findxParamEstu(String nombres, String cedula) {
		try {
			StringBuilder queryString = new StringBuilder(
					"SELECT p FROM GrupoEstudiante p WHERE p.planificacion.idPlanificacion > 0 ");

			if (!nombres.equals("")) {
				queryString.append(" and p.estudiante.nombresEstudiantes like ?1");
			} 

			if (!cedula.equals("")) {
				queryString.append(" and p.estudiante.cedulaEstudiantes like ?2");
			} 
			
			
			
			System.out.println("CONSULTA"+ queryString.toString());

			
			
			Query query = getEntityManager().createQuery(queryString.toString());

			if (!nombres.equals("")) {
				query.setParameter(1, "%" + nombres + "%");
			} 

			if (!cedula.equals("")) {
				query.setParameter(2, cedula + "%");
			} 
			
			

			return query.getResultList();

		} catch (Exception e) {
			return null;
		}
	}

}
