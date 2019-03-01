package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Atencionmedica;
import ec.edu.epn.atencionmedica.entities.Paciente;

@Local
public interface PacienteDAO {

	/**
	 * M�todo que devuelve la lista de pacientes seg�n el criterio. 
	 * @return Lista<Catalogo>
	 */
	public List<Paciente> obtenerListaPacientes(String criterio);

	/**
	 * M�todo que devuelve el paciente seg�n el criterio. 
	 * @return Lista<Catalogo>
	 */
	public Paciente obtenerPaciente(String criterio);
	
	/**
	 * M�todo para realizar los inserts
	 * @return void
	 */
	public boolean guardarPaciente(Paciente paciente, String operacion);	
	
	/**
	 * M�todo para eliminar un registro
	 * @return void
	 */
	public boolean eliminarPaciente(Paciente paciente, String operacion);
}
