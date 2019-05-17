package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Local;


import ec.edu.epn.atencionmedica.entities.PersonalAtencion;

@Local
public interface PersonalDAO {

	/**
	 * Método que devuelve la lista de objetos según el criterio. 
	 * @return Lista<Catalogo>
	 */
	public List<PersonalAtencion> obtenerListaPersonal(String criterio);
	
	/**
	 * Método para realizar los inserts
	 * @return void
	 */
	public boolean guardarPersonal(PersonalAtencion personal, String operacion);
	
	/**
	 * Método para eliminar un registro
	 * @return void
	 */
	public boolean eliminarPersonal(PersonalAtencion personal, String operacion);

	/**
	 * Método que devuelve el objeto según el criterio. 
	 * @return Lista<Catalogo>
	 */
	public PersonalAtencion obtenerPersonal(String criterio);

	List<PersonalAtencion> obtenerListaPersonalReporte();
	
	/**
	 * Metodo para obtener la lista de personal medico
	 * @return List<PersonalAtencion>
	 */
	public List<PersonalAtencion> obtenerListaPersonal();
}
