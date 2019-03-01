/**
 * 
 */
package ec.edu.epn.deportivo.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.deportivo.entities.Estudiante;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class EstudianteDAOImplement extends DaoGenericoImplement<Estudiante> implements EstudianteDAO {

	@Override
	public List<Estudiante> findxCedula(String cedula) {
		try {
			StringBuilder queryString = new StringBuilder(
					"SELECT p FROM Estudiante p WHERE p.cedulaEstudiantes = ?0");
			queryString.append(" ORDER BY p.cedulaEstudiantes ");

			Query query = getEntityManager().createQuery(queryString.toString());

			if (!cedula.equals("")) {
				query.setParameter(0, cedula);
			}

			return query.getResultList();

		} catch (Exception e) {
			return null;
		}

	}


}
