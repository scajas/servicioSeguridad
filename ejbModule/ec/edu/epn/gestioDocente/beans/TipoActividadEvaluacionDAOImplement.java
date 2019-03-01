package ec.edu.epn.gestioDocente.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.TipoActividadEvaluacion;

/**
 * Session Bean implementation class ActividadDocenciaDAOImplement
 */
@Stateless
@LocalBean
public class TipoActividadEvaluacionDAOImplement extends DaoGenericoImplement<TipoActividadEvaluacion>
		implements TipoActividadEvaluacionDAO {

	
}
