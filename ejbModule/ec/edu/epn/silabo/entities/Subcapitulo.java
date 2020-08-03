package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the subcapitulo database table.
 * 
 */
@Entity
@Table(name="subcapitulo", catalog = "`bddcorpepn`", schema = "`Silabo`" )
@NamedQuery(name="Subcapitulo.findAll", query="SELECT s FROM Subcapitulo s")
public class Subcapitulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_subcapitulo")
	private Integer idSubcapitulo;

	@Column(name="nombre_cp")
	private String nombreCp;

	@Column(name="numero_cp")
	private String numeroCp;

	//bi-directional many-to-one association to Capitulo
	@ManyToOne
	@JoinColumn(name="id_capitulo")
	private Capitulo capitulo;
	
	
	

	public Subcapitulo() {
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

	public Capitulo getCapitulo() {
		return this.capitulo;
	}

	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}

	
	
	

}