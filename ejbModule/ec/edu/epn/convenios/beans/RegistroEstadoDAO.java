package ec.edu.epn.convenios.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.convenios.entities.RegistroEstado;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface RegistroEstadoDAO extends DaoGenerico<RegistroEstado>{

	List<RegistroEstado> findregestados(int serial);

}
