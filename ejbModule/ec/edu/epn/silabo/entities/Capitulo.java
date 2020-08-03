package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the capitulo database table.
 * 
 */
@Entity
@Table(name="capitulo", catalog = "`bddcorpepn`", schema = "`Silabo`" )
@NamedQuery(name="Capitulo.findAll", query="SELECT c FROM Capitulo c")
public class Capitulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_capitulo")
	private Integer idCapitulo;

	@Column(name="nom_cap")
	private String nomCap;

	@Column(name="numero_cap")
	private Integer numeroCap;

	//bi-directional many-to-one association to Silabo
	@ManyToOne
	@JoinColumn(name="id_silabo")
	private Silabo silabo;

	//bi-directional many-to-one association to Subcapitulo
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="capitulo", cascade = CascadeType.ALL )
	@OrderBy("numeroCp")
	private List<Subcapitulo> subcapitulos;

	public Capitulo() {
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

	public Silabo getSilabo() {
		return this.silabo;
	}

	public void setSilabo(Silabo silabo) {
		this.silabo = silabo;
	}

	public List<Subcapitulo> getSubcapitulos() {
		return this.subcapitulos;
	}

	public void setSubcapitulos(List<Subcapitulo> subcapitulos) {
		this.subcapitulos = subcapitulos;
	}

	public Subcapitulo addSubcapitulo(Subcapitulo subcapitulo) {
		getSubcapitulos().add(subcapitulo);
		subcapitulo.setCapitulo(this);

		return subcapitulo;
	}

	public Subcapitulo removeSubcapitulo(Subcapitulo subcapitulo) {
		getSubcapitulos().remove(subcapitulo);
		subcapitulo.setCapitulo(null);

		return subcapitulo;
	}

}