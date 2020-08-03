package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the areasdetrabajo database table.
 * 
 */
@Entity
@Table(name="areasdetrabajo", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Areasdetrabajo.findAll", query="SELECT a FROM Areasdetrabajo a")
public class Areasdetrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_areastrabajo")
	private Integer idAreastrabajo;

	@Column(name="descripcion_areastrabajo")
	private String descripcionAreastrabajo;

	@Column(name="nombre_areastrabajo")
	private String nombreAreastrabajo;

	//bi-directional many-to-one association to Trabajo
	@OneToMany(mappedBy="areasdetrabajo")
	private List<Trabajo> trabajos;

	public Areasdetrabajo() {
	}

	public Integer getIdAreastrabajo() {
		return this.idAreastrabajo;
	}

	public void setIdAreastrabajo(Integer idAreastrabajo) {
		this.idAreastrabajo = idAreastrabajo;
	}

	public String getDescripcionAreastrabajo() {
		return this.descripcionAreastrabajo;
	}

	public void setDescripcionAreastrabajo(String descripcionAreastrabajo) {
		this.descripcionAreastrabajo = descripcionAreastrabajo;
	}

	public String getNombreAreastrabajo() {
		return this.nombreAreastrabajo;
	}

	public void setNombreAreastrabajo(String nombreAreastrabajo) {
		this.nombreAreastrabajo = nombreAreastrabajo;
	}

	public List<Trabajo> getTrabajos() {
		return this.trabajos;
	}

	public void setTrabajos(List<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public Trabajo addTrabajo(Trabajo trabajo) {
		getTrabajos().add(trabajo);
		trabajo.setAreasdetrabajo(this);

		return trabajo;
	}

	public Trabajo removeTrabajo(Trabajo trabajo) {
		getTrabajos().remove(trabajo);
		trabajo.setAreasdetrabajo(null);

		return trabajo;
	}

}