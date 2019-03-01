package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.Patente;

@Local
public interface PatenteDAO extends DaoGenerico<Patente>{

	List<Patente> buscarPatenteByParams(String cedula, String validarecategoriza, String validarevaloriza,
			String codigoIEPI, String clase) throws Exception;

	int maxCodPatente();

}
