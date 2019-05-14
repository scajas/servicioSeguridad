package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Insumomedico;

@Local
public interface InsumoMedicoDAO {
	
	/**
	 * Método que devuelve la lista de Objetos según el criterio. 
	 * @return Lista<Catalogo>
	 */
	public List<Insumomedico> obtenerListaInsumos(String criterio);
	
	/**
	 * Método que devuelve el Objeto según el criterio. 
	 * @return Lista<Objeto>
	 */
	public Insumomedico obtenerInsumomedico(String criterio);
	

	/**
	 * Método para realizar los inserts
	 * @return void
	 */
	public boolean guardarInsumomedico(Insumomedico obj, String operacion);
	
	/**
	 * Método para eliminar un registro
	 * @return void
	 */
	public boolean eliminarInsumomedico(Insumomedico obj, String operacion);
	
	/**
	 * Método que devuelve la lista de Objetos según el criterio (AsistenteMEdico). 
	 * @return Lista<Catalogo>
	 */
	public List<Insumomedico> obtenerListaInsumosAsistenteM(String criterio);
	
	/**
	 * Método que devuelve el Objeto según el criterio. 
	 * @return Lista<Objeto>
	 */
	public Insumomedico obtenerInsumomedicoAsistente(String criterio);

	
}
