/**
 * 
 */
package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.calibracionequipos.entidades.PerCalAct;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class PerCalfActDAOImplement extends DaoGenericoImplement<PerCalAct> implements PerCalfActDAO {

	@Override
	public PerCalAct buscarVinculacion(PerCalAct viculacion) {
		try {
			StringBuilder querys = new StringBuilder("SELECT e FROM PerCalAct e where e.id.idPersonalCalificado > 0");

			if (viculacion != null) {
				if (viculacion.getId() != null) {
					if (viculacion.getId().getIdPersonalCalificado() != 0) {
						querys.append(" and e.id.idPersonalCalificado = ?1");
					}
					if (viculacion.getId().getIdActividadeCalif() != 0) {
						querys.append(" and e.id.idActividadeCalif = ?2");
					}
				}

			}

			querys.append(" order by e.id.idPersonalCalificado asc");

			Query query = getEntityManager().createQuery(querys.toString());

			if (viculacion != null) {
				if (viculacion.getId() != null) {
					if (viculacion.getId().getIdPersonalCalificado() != 0) {
						query.setParameter(1, viculacion.getId().getIdPersonalCalificado());
					}
					if (viculacion.getId().getIdActividadeCalif() != 0) {
						query.setParameter(2, viculacion.getId().getIdActividadeCalif());
					}
				}

			}

			PerCalAct entidad = (PerCalAct) query.getSingleResult();

			return entidad;
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}

	}

}
