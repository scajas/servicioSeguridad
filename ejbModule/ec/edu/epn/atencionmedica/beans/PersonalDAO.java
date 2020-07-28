package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Local;


import ec.edu.epn.atencionmedica.entities.PersonalAtencion;

@Local
public interface PersonalDAO {

	/**
	 * Metodo que devuelve la lista de objetos segun el criterio. 
	 * @return Lista<Catalogo>
	 */
	public List<PersonalAtencion> obtenerListaPersonal(String criterio);
	
	/**
	 * Metodo para realizar los inserts
	 * @return void
	 */
	public boolean guardarPersonal(PersonalAtencion personal, String operacion);
	
	/**
	 * Metodo para eliminar un registro
	 * @return void
	 */
	public boolean eliminarPersonal(PersonalAtencion personal, String operacion);

	/**
	 * Metodo que devuelve el objeto segun el criterio. 
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
