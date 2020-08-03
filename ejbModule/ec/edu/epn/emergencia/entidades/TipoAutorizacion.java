package ec.edu.epn.emergencia.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_autorizacion database table.
 * 
 */
@Entity
@Table(name="tipo_autorizacion", catalog = "bddcorpepn", schema = "\"Emergencia\"")
@NamedQuery(name="TipoAutorizacion.findAll", query="SELECT t FROM TipoAutorizacion t")
public class TipoAutorizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo")
	private Integer idTipo;

	private String descripcion;

	private String estado;

	private Boolean horas;

	private String nombre;

	public TipoAutorizacion() {
	}

	public Integer getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Boolean getHoras() {
		return this.horas;
	}

	public void setHoras(Boolean horas) {
		this.horas = horas;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}