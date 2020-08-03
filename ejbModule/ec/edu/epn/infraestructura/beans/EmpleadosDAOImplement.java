/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Emp;

/**
 * @author Administrador
 * 
 */
@Stateless
public class EmpleadosDAOImplement extends DaoGenericoImplement<Emp> implements
		EmpleadosDAO {

	@Override
	public List<Emp> listaEmpleadoXCedula(String cedula) {
		StringBuilder queryString = new StringBuilder(
				"SELECT e FROM Emp e where e.nced =?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula);
		return query.getResultList();
	}
}
