/**
 * 
 */
package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.calibracionequipos.entidades.EqPerCalf;
import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.calibracionequipos.entidades.Personalcalificado;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class EquipoPersonalDAOImplement extends DaoGenericoImplement<EqPerCalf> implements EquipoPersonalDAO {
	@Override
	public List<Personalcalificado> buscarPersonalxEquipo(Equiposcalibracionequipo equipo) {
		StringBuilder queryString = new StringBuilder("select cu.personal from EqPerCalf cu where cu.equipo.idEquipo = ?1 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, equipo.getIdEquipo());
		return query.getResultList();
	}
}
