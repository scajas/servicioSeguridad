/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.EdificioInfra;
import ec.edu.epn.infraestructura.entities.Espacio;
import ec.edu.epn.infraestructura.entities.TipoEspacio;

/**
 * @author Administrador
 * 
 */
@Local
public interface EspacioDAO extends DaoGenerico<Espacio> {
	public int maxEspacio();

	public List<Espacio> buscarEspacioXTipo(String tipoEspacio);
	// 19/10/2014 para listar todos los edificios con determinado tipo
	// antes de que se realice un borrado del tipo de estado
	public List<Espacio> buscarEspacioXTipoEpacio(TipoEspacio tipoEspacio);

	public List<Espacio> buscarEspacioXEstado(String estadoEspacio);

	public List<Espacio> buscarEspacioXCosto(double costoEspacio);

	public List<Espacio> buscarEspacioXCapacidad(int capacidadEspacio);

	public List<Espacio> buscarEspacioXEdificio(String edificioEspacio);

	List<Espacio> reporteEspacios(String parametro);

	List<Espacio> busquedaxparametros(TipoEspacio tipoespacio,
			 EdificioInfra edicifio, int capacidad,
			double costo);

	public List<Espacio> buscarEspacioXPiso(int idpiso);

}
