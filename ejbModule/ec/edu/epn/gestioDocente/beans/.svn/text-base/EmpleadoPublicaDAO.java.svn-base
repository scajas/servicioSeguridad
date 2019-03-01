package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.EmpleadoPublica;

@Local
public interface EmpleadoPublicaDAO extends DaoGenerico<EmpleadoPublica>{

	List<EmpleadoPublica> finaAutoresporPublicacion(String tipo, Integer Idpub) throws Exception;

	List<EmpleadoPublica> finaAutoresporPublicacionExiste(String tipo, String nced, Integer idpub) throws Exception;

	int maxIDEmpleadoPublica();

}
