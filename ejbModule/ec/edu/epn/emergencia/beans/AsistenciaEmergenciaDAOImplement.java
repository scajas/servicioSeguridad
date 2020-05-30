/**
 * 
 */
package ec.edu.epn.emergencia.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.emergencia.entidades.AsistenciaEmergencia;
import ec.edu.epn.emergencia.entidades.AutorizacionEmergencia;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Ecivil;



/**
 * @author Andres Cevallos
 * 
 */
@Stateless
public class AsistenciaEmergenciaDAOImplement extends DaoGenericoImplement<AsistenciaEmergencia> implements
		AsistenciaEmergenciaDAO {

	@Override
	public List<AsistenciaEmergencia> findAsistencia() {
		Query q = getEntityManager().createQuery(
				"Select dep from AsistenciaEmergencia dep ");

		return q.getResultList();
	}

}
