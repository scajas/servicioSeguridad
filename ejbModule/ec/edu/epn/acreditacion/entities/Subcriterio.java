package ec.edu.epn.acreditacion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subcriterio database table.
 * 
 */
@Entity
@Table(name="subcriterio", catalog="`bddcorpepn`", schema="`Acreditacion`")
@NamedQuery(name="Subcriterio.findAll", query="SELECT s FROM Subcriterio s")
public class Subcriterio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_subcr")
	private Integer idSubcr;

	@Column(name="cod_subcr")
	private String codSubcr;

	@Column(name="descr_subcr")
	private String descrSubcr;

	@Column(name="nom_subcr")
	private String nomSubcr;
	
	@Column(name="peso")
	private Double peso;

	//bi-directional many-to-one association to Evidencia
	@OneToMany(mappedBy="subcriterio")
	private List<Evidencia> evidencias;

	//bi-directional many-to-one association to Indicador
	@OneToMany(mappedBy="subcriterio")
	private List<Indicador> indicadors;

	//bi-directional many-to-one association to Criterio
	@ManyToOne
	@JoinColumn(name="id_criterio")
	private Criterio criterio;

	public Subcriterio() {
	}

	public Integer getIdSubcr() {
		return this.idSubcr;
	}

	public void setIdSubcr(Integer idSubcr) {
		this.idSubcr = idSubcr;
	}

	public String getCodSubcr() {
		return this.codSubcr;
	}

	public void setCodSubcr(String codSubcr) {
		this.codSubcr = codSubcr;
	}

	public String getDescrSubcr() {
		return this.descrSubcr;
	}

	public void setDescrSubcr(String descrSubcr) {
		this.descrSubcr = descrSubcr;
	}

	public String getNomSubcr() {
		return this.nomSubcr;
	}

	public void setNomSubcr(String nomSubcr) {
		this.nomSubcr = nomSubcr;
	}

	public List<Evidencia> getEvidencias() {
		return this.evidencias;
	}

	public void setEvidencias(List<Evidencia> evidencias) {
		this.evidencias = evidencias;
	}

	public Evidencia addEvidencia(Evidencia evidencia) {
		getEvidencias().add(evidencia);
		evidencia.setSubcriterio(this);

		return evidencia;
	}

	public Evidencia removeEvidencia(Evidencia evidencia) {
		getEvidencias().remove(evidencia);
		evidencia.setSubcriterio(null);

		return evidencia;
	}

	public List<Indicador> getIndicadors() {
		return this.indicadors;
	}

	public void setIndicadors(List<Indicador> indicadors) {
		this.indicadors = indicadors;
	}

	public Indicador addIndicador(Indicador indicador) {
		getIndicadors().add(indicador);
		indicador.setSubcriterio(this);

		return indicador;
	}

	public Indicador removeIndicador(Indicador indicador) {
		getIndicadors().remove(indicador);
		indicador.setSubcriterio(null);

		return indicador;
	}

	public Criterio getCriterio() {
		return this.criterio;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
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

}