package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personal_proyecto database table.
 * 
 */
@Entity
@Table(name="personal_proyecto")
@NamedQuery(name="PersonalProyecto.findAll", query="SELECT p FROM PersonalProyecto p")
public class PersonalProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_personal_proy")
	private String idPersonalProy;

	@Column(name="apellido_pers_proy")
	private String apellidoPersProy;

	@Column(name="direccion_pers_proy")
	private String direccionPersProy;

	@Column(name="id_proy")
	private String idProy;

	@Column(name="id_rol_proy")
	private String idRolProy;

	@Column(name="id_tipo_pers_proy")
	private String idTipoPersProy;

	@Column(name="nombre_pers_proy")
	private String nombrePersProy;

	@Column(name="num_horas")
	private Integer numHoras;

	@Column(name="sueldo_pers_proy")
	private double sueldoPersProy;

	@Column(name="telef_pers_proy")
	private String telefPersProy;

	public PersonalProyecto() {
	}

	public String getIdPersonalProy() {
		return this.idPersonalProy;
	}

	public void setIdPersonalProy(String idPersonalProy) {
		this.idPersonalProy = idPersonalProy;
	}

	public String getApellidoPersProy() {
		return this.apellidoPersProy;
	}

	public void setApellidoPersProy(String apellidoPersProy) {
		this.apellidoPersProy = apellidoPersProy;
	}

	public String getDireccionPersProy() {
		return this.direccionPersProy;
	}

	public void setDireccionPersProy(String direccionPersProy) {
		this.direccionPersProy = direccionPersProy;
	}

	public String getIdProy() {
		return this.idProy;
	}

	public void setIdProy(String idProy) {
		this.idProy = idProy;
	}

	public String getIdRolProy() {
		return this.idRolProy;
	}

	public void setIdRolProy(String idRolProy) {
		this.idRolProy = idRolProy;
	}

	public String getIdTipoPersProy() {
		return this.idTipoPersProy;
	}

	public void setIdTipoPersProy(String idTipoPersProy) {
		this.idTipoPersProy = idTipoPersProy;
	}

	public String getNombrePersProy() {
		return this.nombrePersProy;
	}

	public void setNombrePersProy(String nombrePersProy) {
		this.nombrePersProy = nombrePersProy;
	}

	public Integer getNumHoras() {
		return this.numHoras;
	}

	public void setNumHoras(Integer numHoras) {
		this.numHoras = numHoras;
	}

	public double getSueldoPersProy() {
		return this.sueldoPersProy;
	}

	public void setSueldoPersProy(double sueldoPersProy) {
		this.sueldoPersProy = sueldoPersProy;
	}

	public String getTelefPersProy() {
		return this.telefPersProy;
	}

	public void setTelefPersProy(String telefPersProy) {
		this.telefPersProy = telefPersProy;
	}

}