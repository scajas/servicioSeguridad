package ec.edu.epn.rrhh.beans;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.DetalleVacacionCatalogo;
import ec.edu.epn.rrhh.movimientos.Docadjunto;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboralPK;

@Remote
public interface DetalleVacacionDAO extends DaoGenerico<DetalleVacacionCatalogo>{
	
	

}
