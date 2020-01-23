package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Insumomedico;

@Local
public interface InsumoMedicoDAO {
	
	/**
	 * Metodo que devuelve la lista de Objetos segun el criterio. 
	 * @return Lista<Catalogo>
	 */
	public List<Insumomedico> obtenerListaInsumos(String criterio);
	
	/**
	 * Metodo que devuelve el Objeto segun el criterio. 
	 * @return Lista<Objeto>
	 */
	public Insumomedico obtenerInsumomedico(String criterio);
	

	/**
	 * Metodo para realizar los inserts
	 * @return void
	 */
	public boolean guardarInsumomedico(Insumomedico obj, String operacion);
	
	/**
	 * Metodo para eliminar un registro
	 * @return void
	 */
	public boolean eliminarInsumomedico(Insumomedico obj, String operacion);
	
	/**
	 * Metodo que devuelve la lista de Objetos segun el criterio (AsistenteMEdico). 
	 * @return Lista<Catalogo>
	 */
	public List<Insumomedico> obtenerListaInsumosAsistenteM(String criterio);
	
	/**
	 * Metodo que devuelve el Objeto segun el criterio. 
	 * @return Lista<Objeto>
	 */
	public Insumomedico obtenerInsumomedicoAsistente(String criterio);

	List<Insumomedico> obtenerListaInsumosEnfMed(String criterio, Integer opcion);

	Long countInsumosMedDesc();

	
}
