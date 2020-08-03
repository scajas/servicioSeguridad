package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the carre database table.
 * 
 */
@Entity
@Table(name="carre", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name="Carre.findAll", query="SELECT c FROM Carre c")
public class Carre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_carre")
	private String codCarre;

	private String carrera;

	private String facultad;

	private String nivel;

	public Carre() {
	}

	public String getCodCarre() {
		return this.codCarre;
	}

	public void setCodCarre(String codCarre) {
		this.codCarre = codCarre;
	}

	public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getFacultad() {
		return this.facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

}