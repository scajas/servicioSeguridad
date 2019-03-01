package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nivel_titulo database table.
 * 
 */
@Entity(name = "nivel_tituloCatalogo")
@Table(name="nivel_titulo", catalog = "`bddcorpepn`", schema = "`Catalogos`")
@NamedQuery(name="NivelTituloCatalogo.findAll", query="SELECT n FROM NivelTitulo n")
public class NivelTitulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_nivel_titulo")
	private String idNivelTitulo;

	@Column(name="descr_nivel")
	private String descrNivel;

	@Column(name="nom_nivel")
	private String nomNivel;

	//bi-directional many-to-one association to Carrera
	@OneToMany(mappedBy="nivelTitulo")
	private List<Carrera> carreras;

	public NivelTitulo() {
	}

	public String getIdNivelTitulo() {
		return this.idNivelTitulo;
	}

	public void setIdNivelTitulo(String idNivelTitulo) {
		this.idNivelTitulo = idNivelTitulo;
	}

	public String getDescrNivel() {
		return this.descrNivel;
	}

	public void setDescrNivel(String descrNivel) {
		this.descrNivel = descrNivel;
	}

	public String getNomNivel() {
		return this.nomNivel;
	}

	public void setNomNivel(String nomNivel) {
		this.nomNivel = nomNivel;
	}

	public List<Carrera> getCarreras() {
		return this.carreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}

	public Carrera addCarrera(Carrera carrera) {
		getCarreras().add(carrera);
		carrera.setNivelTitulo(this);

		return carrera;
	}

	public Carrera removeCarrera(Carrera carrera) {
		getCarreras().remove(carrera);
		carrera.setNivelTitulo(null);

		return carrera;
	}

}