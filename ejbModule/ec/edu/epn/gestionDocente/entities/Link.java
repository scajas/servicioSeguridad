package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the links database table.
 * 
 */
@Entity
@Table(name = "links", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name = "Link.findAll", query = "SELECT l FROM Link l")
public class Link implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_link")
	private Integer idLink;

	private String nced;

	private String url;

	public Link() {
	}

	public Integer getIdLink() {
		return this.idLink;
	}

	public void setIdLink(Integer idLink) {
		this.idLink = idLink;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}