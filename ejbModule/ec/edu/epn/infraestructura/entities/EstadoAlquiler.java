package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the estado_alquiler database table.
 * 
 */
@Entity

@Table(name = "estado_alquiler", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class EstadoAlquiler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ealquiler")
	private Integer idEalquiler;

	@Column(name="descripcion_ealquiler")
	private String descripcionEalquiler;

	@Column(name="estado_alquiler")
	private String estadoAlquiler;

	//bi-directional many-to-one association to Alquiler
	@OneToMany(mappedBy="estadoAlquiler")
	private Set<Alquiler> alquilers;

    public EstadoAlquiler() {
    }

	public Integer getIdEalquiler() {
		return this.idEalquiler;
	}

	public void setIdEalquiler(Integer idEalquiler) {
		this.idEalquiler = idEalquiler;
	}

	public String getDescripcionEalquiler() {
		return this.descripcionEalquiler;
	}

	public void setDescripcionEalquiler(String descripcionEalquiler) {
		this.descripcionEalquiler = descripcionEalquiler;
	}

	public String getEstadoAlquiler() {
		return this.estadoAlquiler;
	}

	public void setEstadoAlquiler(String estadoAlquiler) {
		this.estadoAlquiler = estadoAlquiler;
	}

	public Set<Alquiler> getAlquilers() {
		return this.alquilers;
	}

	public void setAlquilers(Set<Alquiler> alquilers) {
		this.alquilers = alquilers;
	}
	
}