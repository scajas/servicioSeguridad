package ec.edu.epn.rrhh.beans;



import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Emp;
import ec.edu.epn.rrhh.entities.Vaca;

@Remote
public interface VacaDAO extends DaoGenerico<Vaca> {

	public List<Vaca> findVacaByEmpleado(Emp emp);
	
	Integer getMaxID();

	Vaca getSaldo(String cedemp);

		

}
