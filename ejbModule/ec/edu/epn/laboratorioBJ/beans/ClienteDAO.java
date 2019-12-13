package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Cliente;
import ec.edu.epn.laboratorioBJ.entities.Tipocliente;

@Local
public interface ClienteDAO extends DaoGenerico<Cliente>{

	List<Tipocliente> listaClienteTC(Integer id);

	List<Cliente> ListCliente();
 
}
