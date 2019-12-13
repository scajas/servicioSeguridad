package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Tipocliente;

@Local
public interface TipoClienteDAO extends DaoGenerico<Tipocliente>{

	List<Tipocliente> getLisTC();

}
