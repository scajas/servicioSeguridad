package ec.edu.epn.acreditacion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the criterio database table.
 * 
 */
@Entity
@Table(name="criterio", catalog="`bddcorpepn`", schema="`Acreditacion`")
@NamedQuery(name="Criterio.findAll", query="SELECT c FROM Criterio c")
public class Criterio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_criterio")
	private Integer idCriterio;

	@Column(name="cod_criterio")
	private String codCriterio;

	@Column(name="descr_criterio")
	private String descrCriterio;

	@Column(name="nom_criterio")
	private String nomCriterio;
	
	@Column(name="peso")
	private Double peso;

	//bi-directional many-to-one association to Subcriterio
	@OneToMany(mappedBy="criterio")
	private List<Subcriterio> subcriterios;

	public Criterio() {
	}

	public Integer getIdCriterio() {
		return this.idCriterio;
	}

	public void setIdCriterio(Integer idCriterio) {
		this.idCriterio = idCriterio;
	}

	public String getCodCriterio() {
		return this.codCriterio;
	}

	public void setCodCriterio(String codCriterio) {
		this.codCriterio = codCriterio;
	}

	public String getDescrCriterio() {
		return this.descrCriterio;
	}

	public void setDescrCriterio(String descrCriterio) {
		this.descrCriterio = descrCriterio;
	}

	public String getNomCriterio() {
		return this.nomCriterio;
	}

	public void setNomCriterio(String nomCriterio) {
		this.nomCriterio = nomCriterio;
	}

	public List<Subcriterio> getSubcriterios() {
		return this.subcriterios;
	}

	public void setSubcriterios(List<Subcriterio> subcriterios) {
		this.subcriterios = subcriterios;
	}

	public Subcriterio addSubcriterio(Subcriterio subcriterio) {
		getSubcriterios().add(subcriterio);
		subcriterio.setCriterio(this);

		return subcriterio;
	}

	public Subcriterio removeSubcriterio(Subcriterio subcriterio) {
		getSubcriterios().remove(subcriterio);
		subcriterio.setCriterio(null);

		return subcriterio;
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