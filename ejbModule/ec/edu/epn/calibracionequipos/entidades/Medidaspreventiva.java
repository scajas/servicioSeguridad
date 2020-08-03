package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the medidaspreventivas database table.
 * 
 */
@Entity
@Table(name="medidaspreventivas", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Medidaspreventiva.findAll", query="SELECT m FROM Medidaspreventiva m")
public class Medidaspreventiva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pedidapreventiva")
	private Integer idPedidapreventiva;

	@Column(name="descripcion_medidapreventiva")
	private String descripcionMedidapreventiva;

	@Column(name="nombre_medidapreventiva")
	private String nombreMedidapreventiva;

	//bi-directional many-to-one association to Equiposcalibracionequipo
	@ManyToOne
	@JoinColumn(name="id_equipo")
	private Equiposcalibracionequipo equiposcalibracionequipo;

	public Medidaspreventiva() {
	}

	public Integer getIdPedidapreventiva() {
		return this.idPedidapreventiva;
	}

	public void setIdPedidapreventiva(Integer idPedidapreventiva) {
		this.idPedidapreventiva = idPedidapreventiva;
	}

	public String getDescripcionMedidapreventiva() {
		return this.descripcionMedidapreventiva;
	}

	public void setDescripcionMedidapreventiva(String descripcionMedidapreventiva) {
		this.descripcionMedidapreventiva = descripcionMedidapreventiva;
	}

	public String getNombreMedidapreventiva() {
		return this.nombreMedidapreventiva;
	}

	public void setNombreMedidapreventiva(String nombreMedidapreventiva) {
		this.nombreMedidapreventiva = nombreMedidapreventiva;
	}

	public Equiposcalibracionequipo getEquiposcalibracionequipo() {
		return this.equiposcalibracionequipo;
	}

	public void setEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		this.equiposcalibracionequipo = equiposcalibracionequipo;
	}

}