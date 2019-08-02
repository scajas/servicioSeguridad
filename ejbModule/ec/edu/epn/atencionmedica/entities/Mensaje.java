package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mensajes database table.
 * 
 */
@Entity
@Table(name="mensajes", catalog="`bddcorpepn`", schema="`Medico`")
@NamedQuery(name="Mensaje.findAll", query="SELECT m FROM Mensaje m")
public class Mensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String estado;

	private String mensaje;

	private String tipo;

	public Mensaje() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}