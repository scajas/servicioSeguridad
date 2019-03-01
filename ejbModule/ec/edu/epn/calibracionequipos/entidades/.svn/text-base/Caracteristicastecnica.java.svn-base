package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the caracteristicastecnicas database table.
 * 
 */
@Entity
@Table(name="caracteristicastecnicas", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Caracteristicastecnica.findAll", query="SELECT c FROM Caracteristicastecnica c")
public class Caracteristicastecnica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_caractertecnica")
	private Integer idCaractertecnica;

	@Column(name="descripcion_caractertecnica")
	private String descripcionCaractertecnica;

	@Column(name="nombre_caractertecnica")
	private String nombreCaractertecnica;

	//bi-directional many-to-one association to Equiposcalibracionequipo
	@ManyToOne
	@JoinColumn(name="id_equipo")
	private Equiposcalibracionequipo equiposcalibracionequipo;

	public Caracteristicastecnica() {
	}

	public Integer getIdCaractertecnica() {
		return this.idCaractertecnica;
	}

	public void setIdCaractertecnica(Integer idCaractertecnica) {
		this.idCaractertecnica = idCaractertecnica;
	}

	public String getDescripcionCaractertecnica() {
		return this.descripcionCaractertecnica;
	}

	public void setDescripcionCaractertecnica(String descripcionCaractertecnica) {
		this.descripcionCaractertecnica = descripcionCaractertecnica;
	}

	public String getNombreCaractertecnica() {
		return this.nombreCaractertecnica;
	}

	public void setNombreCaractertecnica(String nombreCaractertecnica) {
		this.nombreCaractertecnica = nombreCaractertecnica;
	}

	public Equiposcalibracionequipo getEquiposcalibracionequipo() {
		return this.equiposcalibracionequipo;
	}

	public void setEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		this.equiposcalibracionequipo = equiposcalibracionequipo;
	}

}