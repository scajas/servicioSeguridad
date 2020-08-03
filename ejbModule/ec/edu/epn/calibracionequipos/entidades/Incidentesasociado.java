package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the incidentesasociados database table.
 * 
 */
@Entity
@Table(name="incidentesasociados", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Incidentesasociado.findAll", query="SELECT i FROM Incidentesasociado i")
public class Incidentesasociado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_incidente")
	private Integer idIncidente;

	@Column(name="descripcion_incidente")
	private String descripcionIncidente;

	@Column(name="nombre_incidente")
	private String nombreIncidente;

	//bi-directional many-to-one association to Equiposcalibracionequipo
	@ManyToOne
	@JoinColumn(name="id_equipo")
	private Equiposcalibracionequipo equiposcalibracionequipo;

	public Incidentesasociado() {
	}

	public Integer getIdIncidente() {
		return this.idIncidente;
	}

	public void setIdIncidente(Integer idIncidente) {
		this.idIncidente = idIncidente;
	}

	public String getDescripcionIncidente() {
		return this.descripcionIncidente;
	}

	public void setDescripcionIncidente(String descripcionIncidente) {
		this.descripcionIncidente = descripcionIncidente;
	}

	public String getNombreIncidente() {
		return this.nombreIncidente;
	}

	public void setNombreIncidente(String nombreIncidente) {
		this.nombreIncidente = nombreIncidente;
	}

	public Equiposcalibracionequipo getEquiposcalibracionequipo() {
		return this.equiposcalibracionequipo;
	}

	public void setEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		this.equiposcalibracionequipo = equiposcalibracionequipo;
	}

}