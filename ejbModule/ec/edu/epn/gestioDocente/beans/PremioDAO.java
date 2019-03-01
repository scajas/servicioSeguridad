package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.Premio;

@Local
public interface PremioDAO extends DaoGenerico<Premio>{

	List<Premio> buscarPremio(String cedula, String nombre, Integer anio);

	int countPremioAdquiridoXNombre(String cedula, String nombrePremio, String institucion, Integer añoPremio,
			Premio premio) throws Exception;

}
