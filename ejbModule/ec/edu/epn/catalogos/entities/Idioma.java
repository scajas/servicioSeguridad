package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ec.edu.epn.gestionDocente.entities.IdiomasDocente;


/**
 * The persistent class for the idiomas database table.
 * 
 */
@Entity
@Table(name="idiomas",catalog = "bddcorpepn", schema = "`Catalogos`")
@NamedQuery(name="Idioma.findAll", query="SELECT i FROM Idioma i order by i.nombreIdioma")
public class Idioma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_idioma")
	private String idIdioma;

	@Column(name="nombre_idioma")
	private String nombreIdioma;
	
	@OneToMany(mappedBy="idioma")
	private List<IdiomasDocente> idioma;

	public Idioma() {
	}

	public String getIdIdioma() {
		return this.idIdioma;
	}

	public void setIdIdioma(String idIdioma) {
		this.idIdioma = idIdioma;
	}

	public String getNombreIdioma() {
		return this.nombreIdioma;
	}

	public void setNombreIdioma(String nombreIdioma) {
		this.nombreIdioma = nombreIdioma;
	}

}