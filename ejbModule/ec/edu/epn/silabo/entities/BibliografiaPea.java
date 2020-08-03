package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bibliografia_pea database table.
 * 
 */
@Entity
@Table(name="bibliografia_pea", catalog = "`bddcorpepn`", schema = "`Silabo`")
@NamedQuery(name="BibliografiaPea.findAll", query="SELECT b FROM BibliografiaPea b")
public class BibliografiaPea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_bibliografia", unique=true, nullable=false)
	private Integer idBibliografia;

	private Integer ano;

	@Column(length=1000)
	private String autor;

	@Column(length=10)
	private String biblio;

	@Column(length=1000)
	private String edicion;

	@Column(length=1000)
	private String editorial;

	@Column(length=100)
	private String image;

	@Column(length=256)
	private String isbn;

	@Column(length=256)
	private String tipob;

	@Column(length=1000)
	private String titulo;

	//bi-directional many-to-one association to Pea
	@ManyToOne
	@JoinColumn(name="id_pea")
	private Pea pea;

	public BibliografiaPea() {
	}

	public Integer getIdBibliografia() {
		return this.idBibliografia;
	}

	public void setIdBibliografia(Integer idBibliografia) {
		this.idBibliografia = idBibliografia;
	}

	public Integer getAno() {
		return this.ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getBiblio() {
		return this.biblio;
	}

	public void setBiblio(String biblio) {
		this.biblio = biblio;
	}

	public String getEdicion() {
		return this.edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTipob() {
		return this.tipob;
	}

	public void setTipob(String tipob) {
		this.tipob = tipob;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Pea getPea() {
		return this.pea;
	}

	public void setPea(Pea pea) {
		this.pea = pea;
	}

}