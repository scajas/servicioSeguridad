package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the bibliografia database table.
 * 
 */
@Entity
@Table(name = "bibliografia", catalog = "`bddcorpepn`", schema = "`Silabo`")
@NamedQuery(name = "Bibliografia.findAll", query = "SELECT b FROM Bibliografia b")
public class Bibliografia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_bibliografia")
	private Integer idBibliografia;

	private Integer ano;

	private String autor;

	private String edicion;

	private String editorial;

	private String isbn;

	private String tipob;

	private String titulo;

	private String biblio;
	private String image;
	private String pea;

	// bi-directional many-to-one association to Silabo
	@ManyToOne
	@JoinColumn(name = "id_silabo")
	private Silabo silabo;

	public Bibliografia() {
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

	public Silabo getSilabo() {
		return this.silabo;
	}

	public void setSilabo(Silabo silabo) {
		this.silabo = silabo;
	}

	public String getBiblio() {
		return biblio;
	}

	public void setBiblio(String biblio) {
		this.biblio = biblio;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPea() {
		return pea;
	}

	public void setPea(String pea) {
		this.pea = pea;
	}

}