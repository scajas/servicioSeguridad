package ec.edu.epn.rrhh.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Emp;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboral;
import ec.edu.epn.rrhh.movimientos.Nominacion;

@Remote
public interface NominacionDAO extends DaoGenerico<Nominacion> {

	public List<Nominacion> findHistoriaByEmp(Emp emp);
	
	public long getMaxNominacion();
	
}
