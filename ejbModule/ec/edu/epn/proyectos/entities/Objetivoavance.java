package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the objetivoavance database table.
 * 
 */
@Entity
@Table(name = "objetivoavance", catalog = "bddcorpepn", schema = "`Proyectos`")
@NamedQuery(name = "Objetivoavance.findAll", query = "SELECT o FROM Objetivoavance o")
public class Objetivoavance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Double avance;

	private Integer idpensum;

	private String tipo;
	private String resultado;

	@ManyToOne
	@JoinColumn(name = "idobjetivo")
	private ObjetivoProyecto objetivo;

	private String meses,justificacion;

	public Objetivoavance() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAvance() {
		return this.avance;
	}

	public void setAvance(Double avance) {
		this.avance = avance;
	}

	public Integer getIdpensum() {
		return this.idpensum;
	}

	public void setIdpensum(Integer idpensum) {
		this.idpensum = idpensum;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public ObjetivoProyecto getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(ObjetivoProyecto objetivo) {
		this.objetivo = objetivo;
	}

	public String getMeses() {
		return meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

}