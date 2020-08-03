package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the estado_materiale database table.
 * 
 */
@Entity
@Table(name = "estado_materiale", catalog = "bddcorpepn", schema = "`Infraestructura`")

public class EstadoMateriale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estadomaterial")
	private Integer idEstadomaterial;

	@Column(name="descripcion_estadomaterial")
	private String descripcionEstadomaterial;

	@Column(name="nombre_estadomaterial")
	private String nombreEstadomaterial;

	//bi-directional many-to-one association to Materiale
	@OneToMany(mappedBy="estadoMateriale")
	private List<Materiale> materiales;

    public EstadoMateriale() {
    }

	public Integer getIdEstadomaterial() {
		return this.idEstadomaterial;
	}

	public void setIdEstadomaterial(Integer idEstadomaterial) {
		this.idEstadomaterial = idEstadomaterial;
	}

	public String getDescripcionEstadomaterial() {
		return this.descripcionEstadomaterial;
	}

	public void setDescripcionEstadomaterial(String descripcionEstadomaterial) {
		this.descripcionEstadomaterial = descripcionEstadomaterial;
	}

	public String getNombreEstadomaterial() {
		return this.nombreEstadomaterial;
	}

	public void setNombreEstadomaterial(String nombreEstadomaterial) {
		this.nombreEstadomaterial = nombreEstadomaterial;
	}

	public List<Materiale> getMateriales() {
		return this.materiales;
	}

	public void setMateriales(List<Materiale> materiales) {
		this.materiales = materiales;
	}
	
}