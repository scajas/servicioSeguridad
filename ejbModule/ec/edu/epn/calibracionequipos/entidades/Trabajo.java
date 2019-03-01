package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the trabajo database table.
 * 
 */
@Entity
@Table(name="trabajo", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Trabajo.findAll", query="SELECT t FROM Trabajo t")
public class Trabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_trabajo")
	private Integer idTrabajo;

	@Column(name="descripcion_trabajo")
	private String descripcionTrabajo;

	@Column(name="observacion_trabajo")
	private String observacionTrabajo;

	//bi-directional many-to-many association to Matrizcondisionesfisica
	@ManyToMany
	@JoinTable(
		name="matcftrab"
		, joinColumns={
			@JoinColumn(name="id_trabajo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_matrizcondisionesfisicas")
			}
		)
	private List<Matrizcondisionesfisica> matrizcondisionesfisicas;

	//bi-directional many-to-one association to Areasdetrabajo
	@ManyToOne
	@JoinColumn(name="id_areastrabajo")
	private Areasdetrabajo areasdetrabajo;

	//bi-directional many-to-one association to Tipodetrabajo
	@ManyToOne
	@JoinColumn(name="id_tipodetrabajo")
	private Tipodetrabajo tipodetrabajo;

	public Trabajo() {
	}

	public Integer getIdTrabajo() {
		return this.idTrabajo;
	}

	public void setIdTrabajo(Integer idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public String getDescripcionTrabajo() {
		return this.descripcionTrabajo;
	}

	public void setDescripcionTrabajo(String descripcionTrabajo) {
		this.descripcionTrabajo = descripcionTrabajo;
	}

	public String getObservacionTrabajo() {
		return this.observacionTrabajo;
	}

	public void setObservacionTrabajo(String observacionTrabajo) {
		this.observacionTrabajo = observacionTrabajo;
	}

	public List<Matrizcondisionesfisica> getMatrizcondisionesfisicas() {
		return this.matrizcondisionesfisicas;
	}

	public void setMatrizcondisionesfisicas(List<Matrizcondisionesfisica> matrizcondisionesfisicas) {
		this.matrizcondisionesfisicas = matrizcondisionesfisicas;
	}

	public Areasdetrabajo getAreasdetrabajo() {
		return this.areasdetrabajo;
	}

	public void setAreasdetrabajo(Areasdetrabajo areasdetrabajo) {
		this.areasdetrabajo = areasdetrabajo;
	}

	public Tipodetrabajo getTipodetrabajo() {
		return this.tipodetrabajo;
	}

	public void setTipodetrabajo(Tipodetrabajo tipodetrabajo) {
		this.tipodetrabajo = tipodetrabajo;
	}

}