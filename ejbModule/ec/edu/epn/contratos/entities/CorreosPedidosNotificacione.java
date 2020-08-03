package ec.edu.epn.contratos.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the correos_pedidos_notificaciones database table.
 * 
 */
@Entity
@Table(name = "correos_pedidos_notificaciones", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class CorreosPedidosNotificacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_correo")
	private Integer idCorreo;

	private String cargo;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	private String cedula;

	private String correo;

	private String nombre;

	public CorreosPedidosNotificacione() {
	}

	public Integer getIdCorreo() {
		return this.idCorreo;
	}

	public void setIdCorreo(Integer idCorreo) {
		this.idCorreo = idCorreo;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}