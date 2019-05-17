package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Paciente;

@Local
public interface PacienteDAO {

	/**
	 * Método que devuelve la lista de pacientes según el criterio. 
	 * @return Lista<Catalogo>
	 */
	public List<Paciente> obtenerListaPacientes(String criterio);

	/**
	 * Método que devuelve el paciente según el criterio. 
	 * @return Lista<Catalogo>
	 */
	public Paciente obtenerPaciente(String criterio);
	
	/**
	 * Método para realizar los inserts
	 * @return void
	 */
	public boolean guardarPaciente(Paciente paciente, String operacion);	
	
	/**
	 * Método para eliminar un registro
	 * @return void
	 */
	public boolean eliminarPaciente(Paciente paciente, String operacion);
}
