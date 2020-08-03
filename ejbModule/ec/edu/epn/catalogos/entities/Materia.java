package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the materias database table.
 * 
 */
@Entity

@Table(name = "`materias`", catalog = "`bddcorpepn`", schema = "`Catalogos`")
@NamedQuery(name="Materia.findAll", query="SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_materia")
	private String codMateria;

	@Column(name="carrera_materia")
	private String carreraMateria;

	@Column(name="nombre_materia")
	private String nombreMateria;

	public Materia() {
	}

	public String getCodMateria() {
		return this.codMateria;
	}

	public void setCodMateria(String codMateria) {
		this.codMateria = codMateria;
	}

	public String getCarreraMateria() {
		return this.carreraMateria;
	}

	public void setCarreraMateria(String carreraMateria) {
		this.carreraMateria = carreraMateria;
	}

	public String getNombreMateria() {
		return this.nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

}