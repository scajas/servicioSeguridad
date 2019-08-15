/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.CargaAcademicaPreplanif;

/**
 * @author Administrador
 * 
 */
@Stateless
public class CargaAcademicaPreplanifDAOImplement extends DaoGenericoImplement<CargaAcademicaPreplanif>
		implements CargaAcademicaPreplanifDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<CargaAcademicaPreplanif> findCargaAcadByIdPreplanif(int idPreplanificacion) {

		try {

			StringBuilder queryString = new StringBuilder(
					"SELECT c FROM CargaAcademicaPreplanif c WHERE c.preplanificacionDocencia.idPreplanif=?0");

			if (idPreplanificacion == 0) {
				return null;
			}

			Query query = getEntityManager().createQuery(queryString.toString());

			if (idPreplanificacion != 0) {
				query.setParameter(0, idPreplanificacion);
			}

			return query.getResultList();

		} catch (Exception e) {
			return new ArrayList<CargaAcademicaPreplanif>();
		}
	}
	
	
	
	@Override
	public Double sumValorAsignaturas(Integer idPreplanificacion) {
		Query q = getEntityManager()
				.createQuery(
						"SELECT sum((c.horasTotalSemana * c.preplanificacionDocencia.semanasDocDentro) + c.horasModulo) FROM CargaAcademicaPreplanif c WHERE c.preplanificacionDocencia.idPreplanif=?  ");

		
		q.setParameter(1, idPreplanificacion);		
		
		try {
			return (Double) q.getSingleResult();
		} catch (Exception e) {
			return 0.0;
		}
		
	}
	
	
	@Override
	public Long countAsignXPreplanif(Integer idPreplanificacion) throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(c) FROM CargaAcademicaPreplanif c WHERE c.preplanificacionDocencia.idPreplanif=?  ");

				
		q.setParameter(1, idPreplanificacion);
		
		
		
		return (Long) q.getSingleResult();
	}

}
