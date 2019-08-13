package ec.edu.epn.gestioDocente.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.RecorridoPreplanificacion;

@Local
public interface RecorridoPreplanificacionDAO extends DaoGenerico<RecorridoPreplanificacion>{

	RecorridoPreplanificacion recorridoXEstado(Integer idPreplanificacion, String estadoActual) throws Exception;

	
	
}
