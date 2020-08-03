package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the doccarrera database table.
 * 
 */
@Entity
@NamedQuery(name="Doccarrera.findAll", query="SELECT d FROM Doccarrera d")
public class Doccarrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_carrera")
	private String codCarrera;

	private Integer horasdictadas;

	private String nced;

	private BigDecimal remuneracion;

	public Doccarrera() {
	}

	public String getCodCarrera() {
		return this.codCarrera;
	}

	public void setCodCarrera(String codCarrera) {
		this.codCarrera = codCarrera;
	}

	public Integer getHorasdictadas() {
		return this.horasdictadas;
	}

	public void setHorasdictadas(Integer horasdictadas) {
		this.horasdictadas = horasdictadas;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public BigDecimal getRemuneracion() {
		return this.remuneracion;
	}

	public void setRemuneracion(BigDecimal remuneracion) {
		this.remuneracion = remuneracion;
	}

}