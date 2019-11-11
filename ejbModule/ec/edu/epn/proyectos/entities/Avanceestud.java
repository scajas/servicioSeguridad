package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the avanceestud database table.
 * 
 */
@Entity
@Table(name="avanceestud", catalog = "bddcorpepn", schema = "`Proyectos`")
@NamedQuery(name="Avanceestud.findAll", query="SELECT a FROM Avanceestud a")
public class Avanceestud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Double avance;

	@Column(name="id_pensum")
	private Integer idPensum;

	private String meses;

	private String tipo;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="id_estud")
	private EstudianteProy estudiante;

	public Avanceestud() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	public String getMeses() {
		return this.meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public EstudianteProy getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(EstudianteProy estudiante) {
		this.estudiante = estudiante;
	}

	public Double getAvance() {
		return avance;
	}

	public void setAvance(Double avance) {
		this.avance = avance;
	}
	
	

}