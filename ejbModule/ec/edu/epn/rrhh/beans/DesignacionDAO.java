package ec.edu.epn.rrhh.beans;

import java.util.Date;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Emp;
import ec.edu.epn.rrhh.movimientos.Designacion;

@Remote
public interface DesignacionDAO extends DaoGenerico<Designacion> {
	
	public Integer getMaxID();
	
	public Designacion findDesignacionByTipoAndEstado(String dignidad, 
			String estado, String tipoDesginacion );
	
	
	
	
	
	
	
	
	
	

}
