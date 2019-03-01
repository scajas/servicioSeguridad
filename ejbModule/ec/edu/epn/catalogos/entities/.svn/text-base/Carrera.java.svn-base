package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carrera database table.
 * 
 */
@Entity(name = "CarreraCatalogo")
@Table(name = "`carrera`", catalog = "`bddcorpepn`", schema = "`Catalogos`")
@NamedQuery(name="CarreraCatalogo.findAll", query="SELECT c FROM Carrera c")
public class Carrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_carrera")
	private String idCarrera;

	@Column(name="id_subarea")
	private String idSubarea;

	@Column(name="nom_carrera")
	private String nomCarrera;

	//bi-directional many-to-one association to Facultad
	@ManyToOne
	@JoinColumn(name="id_facultad")
	private FacultadCatalogos facultad;

	//bi-directional many-to-one association to NivelTitulo
	@ManyToOne
	@JoinColumn(name="id_nivel_titulo")
	private NivelTitulo nivelTitulo;

	public Carrera() {
	}

	public String getIdCarrera() {
		return this.idCarrera;
	}

	public void setIdCarrera(String idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getIdSubarea() {
		return this.idSubarea;
	}

	public void setIdSubarea(String idSubarea) {
		this.idSubarea = idSubarea;
	}

	public String getNomCarrera() {
		return this.nomCarrera;
	}

	public void setNomCarrera(String nomCarrera) {
		this.nomCarrera = nomCarrera;
	}

	public FacultadCatalogos getFacultad() {
		return this.facultad;
	}

	public void setFacultad(FacultadCatalogos facultad) {
		this.facultad = facultad;
	}

	public NivelTitulo getNivelTitulo() {
		return this.nivelTitulo;
	}

	public void setNivelTitulo(NivelTitulo nivelTitulo) {
		this.nivelTitulo = nivelTitulo;
	}

}