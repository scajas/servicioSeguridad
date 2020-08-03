package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the subcapitulo_pea database table.
 * 
 */
@Entity
@Table(name="subcapitulo_pea", catalog = "`bddcorpepn`", schema = "`Silabo`")
@NamedQuery(name="SubcapituloPea.findAll", query="SELECT s FROM SubcapituloPea s")
public class SubcapituloPea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_subcapitulo", unique=true, nullable=false)
	private Integer idSubcapitulo;

	@Column(name="nombre_cp", length=1000)
	private String nombreCp;

	@Column(name="numero_cp", length=1000)
	private String numeroCp;

	//bi-directional many-to-one association to CapituloPea
	@ManyToOne
	@JoinColumn(name="id_capitulo_pea")
	private CapituloPea capituloPea;

	public SubcapituloPea() {
	}

	public Integer getIdSubcapitulo() {
		return this.idSubcapitulo;
	}

	public void setIdSubcapitulo(Integer idSubcapitulo) {
		this.idSubcapitulo = idSubcapitulo;
	}

	public String getNombreCp() {
		return this.nombreCp;
	}

	public void setNombreCp(String nombreCp) {
		this.nombreCp = nombreCp;
	}

	public String getNumeroCp() {
		return this.numeroCp;
	}

	public void setNumeroCp(String numeroCp) {
		this.numeroCp = numeroCp;
	}

	public CapituloPea getCapituloPea() {
		return this.capituloPea;
	}

	public void setCapituloPea(CapituloPea capituloPea) {
		this.capituloPea = capituloPea;
	}

}