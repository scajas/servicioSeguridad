package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.HabilitanteAccion;

@Remote
public interface HabilitanteAccionDAO extends DaoGenerico<HabilitanteAccion> {
	
	public List<HabilitanteAccion> findAllHabilitantesAccion();
	
	
	
	
	
	
	
	
	

}
