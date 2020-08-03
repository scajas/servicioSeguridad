/**
 * 
 */
package ec.edu.epn.emergencia.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.emergencia.entidades.AsistenciaEmergencia;
import ec.edu.epn.emergencia.entidades.AutorizacionEmergencia;
import ec.edu.epn.emergencia.entidades.EstadoEmergencia;
import ec.edu.epn.emergencia.entidades.Guardia;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Ecivil;



/**
 * @author Andres Cevallos
 * 
 */
@Stateless
public class EstadoEmergenciaDAOImplement extends DaoGenericoImplement<EstadoEmergencia> implements
		EstadoEmergenciaDAO {

	@Override
	public List<EstadoEmergencia> findEstadoEmergencia() {
		Query q = getEntityManager().createQuery(
				"Select dep from EstadoEmergencia dep ");

		return q.getResultList();
	}

}
