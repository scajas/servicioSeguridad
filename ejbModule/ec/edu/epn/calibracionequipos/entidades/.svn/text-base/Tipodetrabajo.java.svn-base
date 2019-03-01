package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipodetrabajo database table.
 * 
 */
@Entity
@Table(name="tipodetrabajo", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Tipodetrabajo.findAll", query="SELECT t FROM Tipodetrabajo t")
public class Tipodetrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipodetrabajo")
	private Integer idTipodetrabajo;

	@Column(name="descripcion_tipodetrabajo")
	private String descripcionTipodetrabajo;

	@Column(name="nombre_tipodetrabajo")
	private String nombreTipodetrabajo;

	//bi-directional many-to-one association to Trabajo
	@OneToMany(mappedBy="tipodetrabajo")
	private List<Trabajo> trabajos;

	public Tipodetrabajo() {
	}

	public Integer getIdTipodetrabajo() {
		return this.idTipodetrabajo;
	}

	public void setIdTipodetrabajo(Integer idTipodetrabajo) {
		this.idTipodetrabajo = idTipodetrabajo;
	}

	public String getDescripcionTipodetrabajo() {
		return this.descripcionTipodetrabajo;
	}

	public void setDescripcionTipodetrabajo(String descripcionTipodetrabajo) {
		this.descripcionTipodetrabajo = descripcionTipodetrabajo;
	}

	public String getNombreTipodetrabajo() {
		return this.nombreTipodetrabajo;
	}

	public void setNombreTipodetrabajo(String nombreTipodetrabajo) {
		this.nombreTipodetrabajo = nombreTipodetrabajo;
	}

	public List<Trabajo> getTrabajos() {
		return this.trabajos;
	}

	public void setTrabajos(List<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public Trabajo addTrabajo(Trabajo trabajo) {
		getTrabajos().add(trabajo);
		trabajo.setTipodetrabajo(this);

		return trabajo;
	}

	public Trabajo removeTrabajo(Trabajo trabajo) {
		getTrabajos().remove(trabajo);
		trabajo.setTipodetrabajo(null);

		return trabajo;
	}

}