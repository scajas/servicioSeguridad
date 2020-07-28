package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Paciente;

@Local
public interface PacienteDAO {

	/**
	 * Metodo que devuelve la lista de pacientes segun el criterio. 
	 * @return Lista<Catalogo>
	 */
	public List<Paciente> obtenerListaPacientes(String criterio);

	/**
	 * Metodo que devuelve el paciente segun el criterio. 
	 * @return Lista<Catalogo>
	 */
	public Paciente obtenerPaciente(String criterio);
	
	/**
	 * Metodo para realizar los inserts
	 * @return void
	 */
	public boolean guardarPaciente(Paciente paciente, String operacion);	
	
	/**
	 * Metodo para eliminar un registro
	 * @return void
	 */
	public boolean eliminarPaciente(Paciente paciente, String operacion);
}
