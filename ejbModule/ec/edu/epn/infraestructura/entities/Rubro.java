package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the rubro database table.
 * 
 */
@Entity
@Table(name = "rubro", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class Rubro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_rubro")
	private Integer idRubro;

	@Column(name = "descripcion_rubro")
	private String descripcionRubro;

	
	@Column(name = "fecha_registro")
	private Date fechaRegistro;
	
	@Column(name = "ultima_actualizacion")
	private Date fechaActualizacion;

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	@Column(name = "nombre_rubro")
	private String nombreRubro;

	// bi-directional many-to-one association to TipoRubro
	@ManyToOne
	@JoinColumn(name = "id_tiporubro")
	private TipoRubro tipoRubro;

	@ManyToOne
	@JoinColumn(name = "id_espacio")
	private Espacio espacio;
	// bi-directional many-to-one association to Materiale
	@OneToMany(mappedBy = "rubro")
	private List<Materiale> materiales;

	public Rubro() {
	}

	public Integer getIdRubro() {
		return this.idRubro;
	}

	public void setIdRubro(Integer idRubro) {
		this.idRubro = idRubro;
	}

	public String getDescripcionRubro() {
		return this.descripcionRubro;
	}

	public void setDescripcionRubro(String descripcionRubro) {
		this.descripcionRubro = descripcionRubro;
	}

	

	public String getNombreRubro() {
		return this.nombreRubro;
	}

	public void setNombreRubro(String nombreRubro) {
		this.nombreRubro = nombreRubro;
	}

	public TipoRubro getTipoRubro() {
		return this.tipoRubro;
	}

	public void setTipoRubro(TipoRubro tipoRubro) {
		this.tipoRubro = tipoRubro;
	}

	public Espacio getEspacio() {
		return espacio;
	}

	public void setEspacio(Espacio espacio) {
		this.espacio = espacio;
	}

	public List<Materiale> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<Materiale> materiales) {
		this.materiales = materiales;
	}

}