package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Local;


import ec.edu.epn.atencionmedica.entities.PersonalAtencion;

@Local
public interface PersonalDAO {

	/**
	 * M�todo que devuelve la lista de objetos seg�n el criterio. 
	 * @return Lista<Catalogo>
	 */
	public List<PersonalAtencion> obtenerListaPersonal(String criterio);
	
	/**
	 * M�todo para realizar los inserts
	 * @return void
	 */
	public boolean guardarPersonal(PersonalAtencion personal, String operacion);
	
	/**
	 * M�todo para eliminar un registro
	 * @return void
	 */
	public boolean eliminarPersonal(PersonalAtencion personal, String operacion);

	/**
	 * M�todo que devuelve el objeto seg�n el criterio. 
	 * @return Lista<Catalogo>
	 */
	public PersonalAtencion obtenerPersonal(String criterio);

	List<PersonalAtencion> obtenerListaPersonalReporte();
}
