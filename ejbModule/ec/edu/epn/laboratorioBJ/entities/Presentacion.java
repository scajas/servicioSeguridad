package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the presentacion database table.
 * 
 */
@Entity
@Table(name = "presentacion", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name = "Presentacion.findAll", query = "SELECT p FROM Presentacion p")
public class Presentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PRESENTACION_IDPRESENTACION_GENERATOR", sequenceName = "secuencia_presentacion", allocationSize = 1, catalog = "bddcorpepn", schema = "`Laboratorios`")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRESENTACION_IDPRESENTACION_GENERATOR")
	@Column(name = "id_presentacion")
	private Integer idPresentacion;

	@Column(name = "descr_prs")
	private String descrPrs;

	@Column(name = "nombre_prs")
	private String nombrePrs;

	// bi-directional many-to-one association to Existencia
	//@OneToMany(mappedBy = "presentacion")
	//private List<Existencia> existencias;

	public Presentacion() {
	}

	public Integer getIdPresentacion() {
		return this.idPresentacion;
	}

	public void setIdPresentacion(Integer idPresentacion) {
		this.idPresentacion = idPresentacion;
	}

	public String getDescrPrs() {
		return this.descrPrs;
	}

	public void setDescrPrs(String descrPrs) {
		this.descrPrs = descrPrs;
	}

	public String getNombrePrs() {
		return this.nombrePrs;
	}

	public void setNombrePrs(String nombrePrs) {
		this.nombrePrs = nombrePrs;
	}

	
	/***
	public List<Existencia> getExistencias() {
		return this.existencias;
	}

	public void setExistencias(List<Existencia> existencias) {
		this.existencias = existencias;
	}
*   ***/
	
	/*
	public Existencia addExistencia(Existencia existencia) {
		getExistencias().add(existencia);
		existencia.setPresentacion(this);

		return existencia;
	}

	public Existencia removeExistencia(Existencia existencia) {
		getExistencias().remove(existencia);
		existencia.setPresentacion(null);

		return existencia;
	}
*/
}