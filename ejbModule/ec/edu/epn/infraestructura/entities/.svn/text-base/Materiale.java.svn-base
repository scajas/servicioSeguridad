package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the materiales database table.
 * 
 */
@Entity
@Table(name = "materiales", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class Materiale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_material")
	private Integer idMaterial;

	@Column(name = "area_material")
	private String areaMaterial;

	@Column(name = "descripcion_material")
	private String descripcionMaterial;

	@Column(name = "dimensiones_material")
	private String dimensionesMaterial;

	@Column(name = "nombre_material")
	private String nombreMaterial;

	@Column(name = "largo")
	private Double largo;

	@Column(name = "ancho")
	private Double ancho;

	@Column(name = "observaciones_material")
	private String observacionesMaterial;

	// bi-directional many-to-one association to EstadoMateriale
	@ManyToOne
	@JoinColumn(name = "id_estadomaterial")
	private EstadoMateriale estadoMateriale;

	// bi-directional many-to-one association to Rubro
	@ManyToOne
	@JoinColumn(name = "id_rubro")
	private Rubro rubro;

	public Materiale() {
	}

	public Integer getIdMaterial() {
		return this.idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getAreaMaterial() {
		return this.areaMaterial;
	}

	public void setAreaMaterial(String areaMaterial) {
		this.areaMaterial = areaMaterial;
	}

	public String getDescripcionMaterial() {
		return this.descripcionMaterial;
	}

	public void setDescripcionMaterial(String descripcionMaterial) {
		this.descripcionMaterial = descripcionMaterial;
	}

	public String getDimensionesMaterial() {
		return this.dimensionesMaterial;
	}

	public void setDimensionesMaterial(String dimensionesMaterial) {
		this.dimensionesMaterial = dimensionesMaterial;
	}

	public String getNombreMaterial() {
		return this.nombreMaterial;
	}

	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}

	public String getObservacionesMaterial() {
		return this.observacionesMaterial;
	}

	public void setObservacionesMaterial(String observacionesMaterial) {
		this.observacionesMaterial = observacionesMaterial;
	}

	public EstadoMateriale getEstadoMateriale() {
		return this.estadoMateriale;
	}

	public void setEstadoMateriale(EstadoMateriale estadoMateriale) {
		this.estadoMateriale = estadoMateriale;
	}

	public Rubro getRubro() {
		return this.rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

	public Double getLargo() {
		return largo;
	}

	public void setLargo(Double largo) {
		this.largo = largo;
	}

	public Double getAncho() {
		return ancho;
	}

	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}
}