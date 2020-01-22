package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.ActividadPreplanificacion;


@Local
public interface ActividadPreplanificacionDAO extends DaoGenerico<ActividadPreplanificacion> {

	List<ActividadPreplanificacion> findActividadByIdPreplanif(Integer idPreplanificacion, Integer idTipoActv);

	Double sumValorActPreplanif(Integer idPreplanificacion);	

	ActividadPreplanificacion actividadXTipoCatalogo(Integer idPreplanificacion, Integer idTipoActv,
			Integer idCatalogo);

	List<ActividadPreplanificacion> findActividadByIdPreplanifGeneral(Integer idPreplanificacion);

	
	
}
