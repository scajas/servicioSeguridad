package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the capitulo_pea database table.
 * 
 */
@Entity
@Table(name = "capitulo_pea", catalog = "`bddcorpepn`", schema = "`Silabo`")
@NamedQuery(name = "CapituloPea.findAll", query = "SELECT c FROM CapituloPea c")
public class CapituloPea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_capitulo", unique = true, nullable = false)
	private Integer idCapitulo;

	@Column(name = "nom_cap", length = 1000)
	private String nomCap;

	@Column(name = "numero_cap")
	private Integer numeroCap;

	// bi-directional many-to-one association to Pea
	@ManyToOne
	@JoinColumn(name = "id_pea")
	private Pea pea;

	// bi-directional many-to-one association to SubcapituloPea
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "capituloPea", cascade = CascadeType.ALL)

	private List<SubcapituloPea> subcapituloPeas;

	public CapituloPea() {
	}

	public Integer getIdCapitulo() {
		return this.idCapitulo;
	}

	public void setIdCapitulo(Integer idCapitulo) {
		this.idCapitulo = idCapitulo;
	}

	public String getNomCap() {
		return this.nomCap;
	}

	public void setNomCap(String nomCap) {
		this.nomCap = nomCap;
	}

	public Integer getNumeroCap() {
		return this.numeroCap;
	}

	public void setNumeroCap(Integer numeroCap) {
		this.numeroCap = numeroCap;
	}

	public Pea getPea() {
		return this.pea;
	}

	public void setPea(Pea pea) {
		this.pea = pea;
	}

	public List<SubcapituloPea> getSubcapituloPeas() {
		return this.subcapituloPeas;
	}

	public void setSubcapituloPeas(List<SubcapituloPea> subcapituloPeas) {
		this.subcapituloPeas = subcapituloPeas;
	}

	public SubcapituloPea addSubcapituloPea(SubcapituloPea subcapituloPea) {
		getSubcapituloPeas().add(subcapituloPea);
		subcapituloPea.setCapituloPea(this);

		return subcapituloPea;
	}

	public SubcapituloPea removeSubcapituloPea(SubcapituloPea subcapituloPea) {
		getSubcapituloPeas().remove(subcapituloPea);
		subcapituloPea.setCapituloPea(null);

		return subcapituloPea;
	}

}