package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the aval database table.
 * 
 */
@Entity
@NamedQuery(name="Aval.findAll", query="SELECT a FROM Aval a")
public class Aval implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	private String url;

	//bi-directional many-to-one association to Publicacione
	@ManyToOne
	@JoinColumn(name="id_public")
	private Publicacione publicacione;

	public Aval() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Publicacione getPublicacione() {
		return this.publicacione;
	}

	public void setPublicacione(Publicacione publicacione) {
		this.publicacione = publicacione;
	}

}