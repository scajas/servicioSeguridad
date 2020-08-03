/**
 * 
 */
package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.RelacionActual;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class RelacionDependenciaDAOImplement extends DaoGenericoImplement<RelacionActual>
		implements RelacionDependenciaDAO {

	@Override
	public List<RelacionActual> listaRelacionActualxNombre(String nombre) {
		Query q = getEntityManager().createQuery(
				"Select dep from RelacionActual dep  where dep.relacionDependencia =?1 and dep.activo = 'SI'");

		q.setParameter(1, nombre);

		return q.getResultList();
	}

	@Override
	public List<RelacionActual> listaRelacionActualxTipoContrato(int tipoCont) {
		Query q = getEntityManager().createQuery(
				"Select dep from RelacionActual dep  where dep.tipoContrato.idTcont =?1 and dep.activo = 'SI'");

		q.setParameter(1, tipoCont);

		return q.getResultList();
	}

}
