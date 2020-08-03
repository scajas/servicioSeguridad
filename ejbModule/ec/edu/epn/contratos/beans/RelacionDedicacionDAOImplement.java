/**
 * 
 */
package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.DedicacionContratos;
import ec.edu.epn.contratos.entities.RelacionDedicacion;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;



/**
 * @author Administrador
 * 
 */
@Stateless
public class RelacionDedicacionDAOImplement extends
		DaoGenericoImplement<RelacionDedicacion> implements
		RelacionDedicacionDAO {

	@Override
	public List<DedicacionContratos> listaDedicacionXRelacionDependencia(
			int relDependencia) {

		Query q = getEntityManager()
				.createQuery(
						"Select dep.dedicacion from RelacionDedicacion dep   where dep.relacionActual.idRelacion =?1 and dep.activo = 'SI'");

		q.setParameter(1, relDependencia);

		
		return q.getResultList();

	}

}
