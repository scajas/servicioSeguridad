package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estadocondicionesfisicas database table.
 * 
 */
@Entity
@Table(name="estadocondicionesfisicas", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Estadocondicionesfisica.findAll", query="SELECT e FROM Estadocondicionesfisica e")
public class Estadocondicionesfisica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estadocondfisica")
	private Integer idEstadocondfisica;

	@Column(name="descripcion_estadocondfisica")
	private String descripcionEstadocondfisica;

	@Column(name="nombre_estadocondfisica")
	private String nombreEstadocondfisica;

	//bi-directional many-to-one association to Matrizcondisionesfisica
	@OneToMany(mappedBy="estadocondicionesfisica")
	private List<Matrizcondisionesfisica> matrizcondisionesfisicas;

	public Estadocondicionesfisica() {
	}

	public Integer getIdEstadocondfisica() {
		return this.idEstadocondfisica;
	}

	public void setIdEstadocondfisica(Integer idEstadocondfisica) {
		this.idEstadocondfisica = idEstadocondfisica;
	}

	public String getDescripcionEstadocondfisica() {
		return this.descripcionEstadocondfisica;
	}

	public void setDescripcionEstadocondfisica(String descripcionEstadocondfisica) {
		this.descripcionEstadocondfisica = descripcionEstadocondfisica;
	}

	public String getNombreEstadocondfisica() {
		return this.nombreEstadocondfisica;
	}

	public void setNombreEstadocondfisica(String nombreEstadocondfisica) {
		this.nombreEstadocondfisica = nombreEstadocondfisica;
	}

	public List<Matrizcondisionesfisica> getMatrizcondisionesfisicas() {
		return this.matrizcondisionesfisicas;
	}

	public void setMatrizcondisionesfisicas(List<Matrizcondisionesfisica> matrizcondisionesfisicas) {
		this.matrizcondisionesfisicas = matrizcondisionesfisicas;
	}

	public Matrizcondisionesfisica addMatrizcondisionesfisica(Matrizcondisionesfisica matrizcondisionesfisica) {
		getMatrizcondisionesfisicas().add(matrizcondisionesfisica);
		matrizcondisionesfisica.setEstadocondicionesfisica(this);

		return matrizcondisionesfisica;
	}

	public Matrizcondisionesfisica removeMatrizcondisionesfisica(Matrizcondisionesfisica matrizcondisionesfisica) {
		getMatrizcondisionesfisicas().remove(matrizcondisionesfisica);
		matrizcondisionesfisica.setEstadocondicionesfisica(null);

		return matrizcondisionesfisica;
	}

}