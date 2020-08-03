package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the matrizcondisionesfisicas database table.
 * 
 */
@Entity
@Table(name="matrizcondisionesfisicas", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Matrizcondisionesfisica.findAll", query="SELECT m FROM Matrizcondisionesfisica m")
public class Matrizcondisionesfisica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_matrizcondisionesfisicas")
	private Integer idMatrizcondisionesfisicas;

	@Column(name="cantidad_condisionesfisicas")
	private Integer cantidadCondisionesfisicas;

	@Column(name="obs_condisionesfisicas")
	private String obsCondisionesfisicas;

	@Column(name="presref_condisionesfisicas")
	private float presrefCondisionesfisicas;

	@Column(name="unidad_condisionesfisicas")
	private String unidadCondisionesfisicas;

	//bi-directional many-to-many association to Laboratorioscalibracionequipo
	@ManyToMany
	@JoinTable(
		name="labmacf"
		, joinColumns={
			@JoinColumn(name="id_matrizcondisionesfisicas")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_laboratorio")
			}
		)
	private List<Laboratorioscalibracionequipo> laboratorioscalibracionequipos;

	//bi-directional many-to-many association to Trabajo
	@ManyToMany(mappedBy="matrizcondisionesfisicas")
	private List<Trabajo> trabajos;

	//bi-directional many-to-one association to Estadocondicionesfisica
	@ManyToOne
	@JoinColumn(name="id_estadocondfisica")
	private Estadocondicionesfisica estadocondicionesfisica;

	public Matrizcondisionesfisica() {
	}

	public Integer getIdMatrizcondisionesfisicas() {
		return this.idMatrizcondisionesfisicas;
	}

	public void setIdMatrizcondisionesfisicas(Integer idMatrizcondisionesfisicas) {
		this.idMatrizcondisionesfisicas = idMatrizcondisionesfisicas;
	}

	public Integer getCantidadCondisionesfisicas() {
		return this.cantidadCondisionesfisicas;
	}

	public void setCantidadCondisionesfisicas(Integer cantidadCondisionesfisicas) {
		this.cantidadCondisionesfisicas = cantidadCondisionesfisicas;
	}

	public String getObsCondisionesfisicas() {
		return this.obsCondisionesfisicas;
	}

	public void setObsCondisionesfisicas(String obsCondisionesfisicas) {
		this.obsCondisionesfisicas = obsCondisionesfisicas;
	}

	public float getPresrefCondisionesfisicas() {
		return this.presrefCondisionesfisicas;
	}

	public void setPresrefCondisionesfisicas(float presrefCondisionesfisicas) {
		this.presrefCondisionesfisicas = presrefCondisionesfisicas;
	}

	public String getUnidadCondisionesfisicas() {
		return this.unidadCondisionesfisicas;
	}

	public void setUnidadCondisionesfisicas(String unidadCondisionesfisicas) {
		this.unidadCondisionesfisicas = unidadCondisionesfisicas;
	}

	public List<Laboratorioscalibracionequipo> getLaboratorioscalibracionequipos() {
		return this.laboratorioscalibracionequipos;
	}

	public void setLaboratorioscalibracionequipos(List<Laboratorioscalibracionequipo> laboratorioscalibracionequipos) {
		this.laboratorioscalibracionequipos = laboratorioscalibracionequipos;
	}

	public List<Trabajo> getTrabajos() {
		return this.trabajos;
	}

	public void setTrabajos(List<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public Estadocondicionesfisica getEstadocondicionesfisica() {
		return this.estadocondicionesfisica;
	}

	public void setEstadocondicionesfisica(Estadocondicionesfisica estadocondicionesfisica) {
		this.estadocondicionesfisica = estadocondicionesfisica;
	}

}