package ec.edu.epn.contratos.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DetalleDocenteAdminstrativoDTO {

	@Id
	private String cedula;
	private String nombre;
	private String apellido;
	private String codNacimiento;
	private String genero;
	private String email;
	private String direccion;
	private String tipoRelacionLaboral;
	private String dedicacion;
	private String cargo;
	private String departamento;
	private String codDepartamento;
	private String facultad;
	private String nivel;

	public DetalleDocenteAdminstrativoDTO() {
		super();
	}

	public DetalleDocenteAdminstrativoDTO(String cedula, String nombre, String apellido, String codNacimiento,
			String genero, String email, String direccion, String tipoRelacionLaboral, String dedicacion, String cargo,
			String departamento, String codDepartamento, String facultad, String nivel) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.codNacimiento = codNacimiento;
		this.genero = genero;
		this.email = email;
		this.direccion = direccion;
		this.tipoRelacionLaboral = tipoRelacionLaboral;
		this.dedicacion = dedicacion;
		this.cargo = cargo;
		this.departamento = departamento;
		this.codDepartamento = codDepartamento;
		this.facultad = facultad;
		this.nivel = nivel;

	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula
	 *            the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido
	 *            the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the codNacimiento
	 */
	public String getCodNacimiento() {
		return codNacimiento;
	}

	/**
	 * @param codNacimiento
	 *            the codNacimiento to set
	 */
	public void setCodNacimiento(String codNacimiento) {
		this.codNacimiento = codNacimiento;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the tipoRelacionLaboral
	 */
	public String getTipoRelacionLaboral() {
		return tipoRelacionLaboral;
	}

	/**
	 * @param tipoRelacionLaboral
	 *            the tipoRelacionLaboral to set
	 */
	public void setTipoRelacionLaboral(String tipoRelacionLaboral) {
		this.tipoRelacionLaboral = tipoRelacionLaboral;
	}

	/**
	 * @return the dedicacion
	 */
	public String getDedicacion() {
		return dedicacion;
	}

	/**
	 * @param dedicacion
	 *            the dedicacion to set
	 */
	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 *            the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the departamento
	 */
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento
	 *            the departamento to set
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	/**
	 * @return the codDepartamento
	 */
	public String getCodDepartamento() {
		return codDepartamento;
	}

	/**
	 * @param codDepartamento
	 *            the codDepartamento to set
	 */
	public void setCodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	/**
	 * @return the facultad
	 */
	public String getFacultad() {
		return facultad;
	}

	/**
	 * @param facultad
	 *            the facultad to set
	 */
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	/**
	 * @return the nivel
	 */
	public String getNivel() {
		return nivel;
	}

	/**
	 * @param nivel
	 *            the nivel to set
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero
	 *            the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

}
