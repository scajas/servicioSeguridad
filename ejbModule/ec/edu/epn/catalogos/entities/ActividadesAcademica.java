package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the actividades_academicas database table.
 * 
 */
@Entity
@Table(name = "actividades_academicas", catalog = "bddcorpepn", schema = "`Catalogos`")
@NamedQueries({ @NamedQuery(name = "ActividadesAcademica.findAll", query = "SELECT a FROM ActividadesAcademica a"),
		@NamedQuery(name = "ActividadesAcademica.findByTipo", query = "SELECT a FROM ActividadesAcademica a where a.tipo = :tipoactividad") })
public class ActividadesAcademica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_actividad")
	private String idActividad;

	private String descripcion;

	private String detalle;

	@Column(name = "horasfinperiodo_academico")
	private Integer horasfinperiodoAcademico;

	@Column(name = "horasperiodo_academico")
	private Integer horasperiodoAcademico;

	@Column(name = "orden_actividad")
	private Integer ordenActividad;

	@Column(name = "subtotal_horas")
	private Integer subtotalHoras;

	private String tipo;

	public ActividadesAcademica() {
	}

	public String getIdActividad() {
		return this.idActividad;
	}

	public void setIdActividad(String idActividad) {
		this.idActividad = idActividad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Integer getHorasfinperiodoAcademico() {
		return this.horasfinperiodoAcademico;
	}

	public void setHorasfinperiodoAcademico(Integer horasfinperiodoAcademico) {
		this.horasfinperiodoAcademico = horasfinperiodoAcademico;
	}

	public Integer getHorasperiodoAcademico() {
		return this.horasperiodoAcademico;
	}

	public void setHorasperiodoAcademico(Integer horasperiodoAcademico) {
		this.horasperiodoAcademico = horasperiodoAcademico;
	}

	public Integer getOrdenActividad() {
		return this.ordenActividad;
	}

	public void setOrdenActividad(Integer ordenActividad) {
		this.ordenActividad = ordenActividad;
	}

	public Integer getSubtotalHoras() {
		return this.subtotalHoras;
	}

	public void setSubtotalHoras(Integer subtotalHoras) {
		this.subtotalHoras = subtotalHoras;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}