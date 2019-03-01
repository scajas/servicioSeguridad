package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the recursoavance database table.
 * 
 */
@Entity
@Table(name = "recursoavance", catalog = "bddcorpepn", schema = "`Proyectos`")
@NamedQuery(name = "Recursoavance.findAll", query = "SELECT r FROM Recursoavance r")
public class Recursoavance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	
	@ManyToOne()
	@JoinColumn(name = "id_recurso")
	private RecursohPr recurso;

	private Integer idpensum;

	private String tipo;

	private Double valor;
	private String meses;
	private String justificacion;
	
	
	public Recursoavance() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public RecursohPr getRecurso() {
		return recurso;
	}

	public void setRecurso(RecursohPr recurso) {
		this.recurso = recurso;
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