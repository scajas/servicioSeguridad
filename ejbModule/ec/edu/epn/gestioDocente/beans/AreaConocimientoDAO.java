package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.AreaConocimiento;

@Local
public interface AreaConocimientoDAO extends DaoGenerico<AreaConocimiento>{

	List<AreaConocimiento> finsAllareas() throws Exception;

	AreaConocimiento buscarAreaByID(String cod) throws Exception;

	

}
