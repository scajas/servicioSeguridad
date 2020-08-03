package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the riesgosasociados database table.
 * 
 */
@Entity
@Table(name="riesgosasociados", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Riesgosasociado.findAll", query="SELECT r FROM Riesgosasociado r")
public class Riesgosasociado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_riesgo")
	private Integer idRiesgo;

	@Column(name="descripcion_riesgo")
	private String descripcionRiesgo;

	@Column(name="nombre_riesgo")
	private String nombreRiesgo;

	//bi-directional many-to-one association to Equiposcalibracionequipo
	@ManyToOne
	@JoinColumn(name="id_equipo")
	private Equiposcalibracionequipo equiposcalibracionequipo;

	public Riesgosasociado() {
	}

	public Integer getIdRiesgo() {
		return this.idRiesgo;
	}

	public void setIdRiesgo(Integer idRiesgo) {
		this.idRiesgo = idRiesgo;
	}

	public String getDescripcionRiesgo() {
		return this.descripcionRiesgo;
	}

	public void setDescripcionRiesgo(String descripcionRiesgo) {
		this.descripcionRiesgo = descripcionRiesgo;
	}

	public String getNombreRiesgo() {
		return this.nombreRiesgo;
	}

	public void setNombreRiesgo(String nombreRiesgo) {
		this.nombreRiesgo = nombreRiesgo;
	}

	public Equiposcalibracionequipo getEquiposcalibracionequipo() {
		return this.equiposcalibracionequipo;
	}

	public void setEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		this.equiposcalibracionequipo = equiposcalibracionequipo;
	}

}