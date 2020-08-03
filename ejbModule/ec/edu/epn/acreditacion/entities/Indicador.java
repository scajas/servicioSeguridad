package ec.edu.epn.acreditacion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the indicador database table.
 * 
 */
@Entity
@Table(name="indicador", catalog="`bddcorpepn`", schema="`Acreditacion`")
@NamedQuery(name="Indicador.findAll", query="SELECT i FROM Indicador i")
public class Indicador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_indi")
	private Integer idIndi;

	@Column(name="cod_indi")
	private String codIndi;

	@Column(name="descr_indi")
	private String descrIndi;

	private String formula;

	@Column(name="nom_indi")
	private String nomIndi;

	private String tipo;
	
	private Double peso;
	
	
	
	@Column(name="descr_formula")
	private String descrFormula;

	//bi-directional many-to-one association to Subcriterio
	@ManyToOne
	@JoinColumn(name="id_subcr")
	private Subcriterio subcriterio;

	

	public Indicador() {
	}

	public Integer getIdIndi() {
		return this.idIndi;
	}

	public void setIdIndi(Integer idIndi) {
		this.idIndi = idIndi;
	}

	public String getCodIndi() {
		return this.codIndi;
	}

	public void setCodIndi(String codIndi) {
		this.codIndi = codIndi;
	}

	public String getDescrIndi() {
		return this.descrIndi;
	}

	public void setDescrIndi(String descrIndi) {
		this.descrIndi = descrIndi;
	}

	public String getFormula() {
		return this.formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getNomIndi() {
		return this.nomIndi;
	}

	public void setNomIndi(String nomIndi) {
		this.nomIndi = nomIndi;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Subcriterio getSubcriterio() {
		return this.subcriterio;
	}

	public void setSubcriterio(Subcriterio subcriterio) {
		this.subcriterio = subcriterio;
	}

	/**
	 * @return the peso
	 */
	public Double getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(Double peso) {
		this.peso = peso;
	}

	/**
	 * @return the descrFormula
	 */
	public String getDescrFormula() {
		return descrFormula;
	}

	/**
	 * @param descrFormula the descrFormula to set
	 */
	public void setDescrFormula(String descrFormula) {
		this.descrFormula = descrFormula;
	}



}