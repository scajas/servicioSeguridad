package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the universidad database table.
 * 
 */
@Entity(name = "UniversidadCatalogo")
@NamedQuery(name="UniversidadCatalogo.findAll", query="SELECT u FROM Universidad u")
public class UniversidadCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_universidad")
	private String idUniversidad;

	@Column(name="cat_senescyt")
	private String catSenescyt;

	@Column(name="nom_universid")
	private String nomUniversid;

	@Column(name="rank_mundial")
	private Integer rankMundial;

	//bi-directional many-to-one association to Pai
	@ManyToOne
	@JoinColumn(name="id_pais")
	private PaisCatalogo pais;

	public UniversidadCatalogo() {
	}

	public String getIdUniversidad() {
		return this.idUniversidad;
	}

	public void setIdUniversidad(String idUniversidad) {
		this.idUniversidad = idUniversidad;
	}

	public String getCatSenescyt() {
		return this.catSenescyt;
	}

	public void setCatSenescyt(String catSenescyt) {
		this.catSenescyt = catSenescyt;
	}

	public String getNomUniversid() {
		return this.nomUniversid;
	}

	public void setNomUniversid(String nomUniversid) {
		this.nomUniversid = nomUniversid;
	}

	public Integer getRankMundial() {
		return this.rankMundial;
	}

	public void setRankMundial(Integer rankMundial) {
		this.rankMundial = rankMundial;
	}

	public PaisCatalogo getPais() {
		return this.pais;
	}

	public void setPais(PaisCatalogo pais) {
		this.pais = pais;
	}

}