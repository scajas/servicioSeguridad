package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carreras database table.
 * 
 */
@Entity
@Table(name="carreras")
@NamedQuery(name="Carrera.findAll", query="SELECT c FROM Carrera c")
public class Carrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_carrera")
	private String codCarrera;

	@Column(name="id_area1")
	private String idArea1;

	@Column(name="id_area2")
	private String idArea2;

	@Column(name="id_area3")
	private String idArea3;

	@Column(name="nombre_c")
	private String nombreC;

	public Carrera() {
	}

	public String getCodCarrera() {
		return this.codCarrera;
	}

	public void setCodCarrera(String codCarrera) {
		this.codCarrera = codCarrera;
	}

	public String getIdArea1() {
		return this.idArea1;
	}

	public void setIdArea1(String idArea1) {
		this.idArea1 = idArea1;
	}

	public String getIdArea2() {
		return this.idArea2;
	}

	public void setIdArea2(String idArea2) {
		this.idArea2 = idArea2;
	}

	public String getIdArea3() {
		return this.idArea3;
	}

	public void setIdArea3(String idArea3) {
		this.idArea3 = idArea3;
	}

	public String getNombreC() {
		return this.nombreC;
	}

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}

}