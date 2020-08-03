/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.HorarioEspacioOcupante;

/**
 * @author Administrador
 * 
 */
@Local
public interface HEODAO extends DaoGenerico<HorarioEspacioOcupante> {
	int consultarId();

	List<HorarioEspacioOcupante> listarHEO();

	List<HorarioEspacioOcupante> listarHEO_Ocupados();

	List<HorarioEspacioOcupante> reporteHEO(String carrera, String piso);

	List<HorarioEspacioOcupante> buscarHEO(int alq);

	List<HorarioEspacioOcupante> buscarHEOXOcupante(String nombreEvento);

	List<HorarioEspacioOcupante> buscarHEOXIDOcupante(int idOcupante);

	List<HorarioEspacioOcupante> buscarHEOXEspacio(int nombreTipoHEO);
}
