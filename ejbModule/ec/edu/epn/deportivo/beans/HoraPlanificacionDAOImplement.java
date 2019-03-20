/**
 * 
 */
package ec.edu.epn.deportivo.beans;

import javax.ejb.Stateless;

import ec.edu.epn.deportivo.entities.HoraPlanificacion;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class HoraPlanificacionDAOImplement extends DaoGenericoImplement<HoraPlanificacion>
		implements HoraPlanificacionDAO {

}
