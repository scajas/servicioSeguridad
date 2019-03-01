/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.Espacio;
import ec.edu.epn.infraestructura.entities.EstadoEspacio;
import ec.edu.epn.infraestructura.entities.Horario;
import ec.edu.epn.infraestructura.entities.HorarioEspacio;

/**
 * @author Administrador
 * 
 */
@Local
public interface HorarioEspacioDAO extends DaoGenerico<HorarioEspacio> {
	int consultarId();

	List<HorarioEspacio> listarHE();
	List<HorarioEspacio> listarHELibres();
	
	List<HorarioEspacio> listarHEOcupados();
	
	List<HorarioEspacio> buscarHE(int he);

	List<Horario> buscarHorarioXIDEspacio(Espacio espacio);

	List<HorarioEspacio> buscarHorarioEspacioXIDEspacio(Espacio espacio);

	List<HorarioEspacio> buscarEspacioXTipo(String tipoEspacio);

	List<HorarioEspacio> buscarEspacioXEstado(String estadoEspacio);
	//19/10/2014 Utilizado para comprobar que el estado espacio ha eliminar
	//no este siendo usado en ningun Horario Epacio
	List<HorarioEspacio> buscarHorarioEspacioXEstadoEspacio(EstadoEspacio estadoEspacio);

	List<HorarioEspacio> buscarEspacioXCosto(double costoEspacio);

	List<HorarioEspacio> buscarEspacioXCapacidad(int capacidadEspacio);

	List<HorarioEspacio> buscarEspacioXEdificio(String edificioEspacio);

	List<HorarioEspacio> buscarEspacioXPiso(int idPiso);
}
