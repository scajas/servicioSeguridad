package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Estemp;



@Local
public interface EstempDAO extends DaoGenerico<Estemp> {

	List<Estemp> findestadosEmp();
	
	

}
