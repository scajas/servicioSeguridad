package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the materia_area database table.
 * 
 */
@Entity
@Table(name="materia_area")
@NamedQuery(name="MateriaArea.findAll", query="SELECT m FROM MateriaArea m")
public class MateriaArea implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="cod_area_1")
	private String codArea1;

	@Column(name="cod_carrera")
	private String codCarrera;

	@Column(name="cod_materia")
	private String codMateria;

	@Column(name="id_ma")
	private String idMa;

	private String materia;

	private String si1;

	public MateriaArea() {
	}

	public String getCodArea1() {
		return this.codArea1;
	}

	public void setCodArea1(String codArea1) {
		this.codArea1 = codArea1;
	}

	public String getCodCarrera() {
		return this.codCarrera;
	}

	public void setCodCarrera(String codCarrera) {
		this.codCarrera = codCarrera;
	}

	public String getCodMateria() {
		return this.codMateria;
	}

	public void setCodMateria(String codMateria) {
		this.codMateria = codMateria;
	}

	public String getIdMa() {
		return this.idMa;
	}

	public void setIdMa(String idMa) {
		this.idMa = idMa;
	}

	public String getMateria() {
		return this.materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getSi1() {
		return this.si1;
	}

	public void setSi1(String si1) {
		this.si1 = si1;
	}

}