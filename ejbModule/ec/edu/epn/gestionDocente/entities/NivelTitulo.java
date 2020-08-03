package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the nivel_titulo database table.
 * 
 */
@Entity
@Table(name="nivel_titulo", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name="NivelTitulo.findAll", query="SELECT n FROM NivelTitulo n order by n.idNivelTitulo")
public class NivelTitulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_nivel_titulo")
	private String idNivelTitulo;

	@Column(name="nom_nivel")
	private String nomNivel;
	
	@OneToMany(mappedBy="nivel")
	private List<TituloFormacionAcademica> titulo;

	public NivelTitulo() {
	}

	public String getIdNivelTitulo() {
		return this.idNivelTitulo;
	}

	public void setIdNivelTitulo(String idNivelTitulo) {
		this.idNivelTitulo = idNivelTitulo;
	}

	public String getNomNivel() {
		return this.nomNivel;
	}

	public void setNomNivel(String nomNivel) {
		this.nomNivel = nomNivel;
	}

	public List<TituloFormacionAcademica> getTitulo() {
		return titulo;
	}

	public void setTitulo(List<TituloFormacionAcademica> titulo) {
		this.titulo = titulo;
	}
	
	

}