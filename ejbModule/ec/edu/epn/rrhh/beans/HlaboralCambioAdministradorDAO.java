package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.Docadjunto;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboralPK;
import ec.edu.epn.rrhh.movimientos.HlaboralCambioAdministrador;

@Remote
public interface HlaboralCambioAdministradorDAO extends DaoGenerico<HlaboralCambioAdministrador>{
	
	public Integer getMaxID();



}
