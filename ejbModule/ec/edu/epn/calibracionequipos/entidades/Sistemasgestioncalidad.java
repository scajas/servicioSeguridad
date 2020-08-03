package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the sistemasgestioncalidad database table.
 * 
 */
@Entity
@Table(name = "sistemasgestioncalidad", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "Sistemasgestioncalidad.findAll", query = "SELECT s FROM Sistemasgestioncalidad s")
public class Sistemasgestioncalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_sistcalidad")
	private Integer idSistcalidad;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaimplementacion_sistcalidad")
	private Date fechaimplementacionSistcalidad;

	@Column(name = "nombre_sistcalidad")
	private String nombreSistcalidad;

	@ManyToOne
	@JoinColumn(name = "id_laboratorio")
	private Laboratorioscalibracionequipo laboratorio;

	public Laboratorioscalibracionequipo getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorioscalibracionequipo laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Sistemasgestioncalidad() {
	}

	public Integer getIdSistcalidad() {
		return this.idSistcalidad;
	}

	public void setIdSistcalidad(Integer idSistcalidad) {
		this.idSistcalidad = idSistcalidad;
	}

	public Date getFechaimplementacionSistcalidad() {
		return this.fechaimplementacionSistcalidad;
	}

	public void setFechaimplementacionSistcalidad(Date fechaimplementacionSistcalidad) {
		this.fechaimplementacionSistcalidad = fechaimplementacionSistcalidad;
	}

	public String getNombreSistcalidad() {
		return this.nombreSistcalidad;
	}

	public void setNombreSistcalidad(String nombreSistcalidad) {
		this.nombreSistcalidad = nombreSistcalidad;
	}
}