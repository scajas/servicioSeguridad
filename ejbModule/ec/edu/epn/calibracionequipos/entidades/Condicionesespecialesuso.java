package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the condicionesespecialesuso database table.
 * 
 */
@Entity
@Table(name="condicionesespecialesuso", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Condicionesespecialesuso.findAll", query="SELECT c FROM Condicionesespecialesuso c")
public class Condicionesespecialesuso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_condicionuso")
	private Integer idCondicionuso;

	@Column(name="caarcteristica_condicionuso")
	private String caarcteristicaCondicionuso;

	@Column(name="nombre_condicionuso")
	private String nombreCondicionuso;

	//bi-directional many-to-one association to Equiposcalibracionequipo
	@ManyToOne
	@JoinColumn(name="id_equipo")
	private Equiposcalibracionequipo equiposcalibracionequipo;

	public Condicionesespecialesuso() {
	}

	public Integer getIdCondicionuso() {
		return this.idCondicionuso;
	}

	public void setIdCondicionuso(Integer idCondicionuso) {
		this.idCondicionuso = idCondicionuso;
	}

	public String getCaarcteristicaCondicionuso() {
		return this.caarcteristicaCondicionuso;
	}

	public void setCaarcteristicaCondicionuso(String caarcteristicaCondicionuso) {
		this.caarcteristicaCondicionuso = caarcteristicaCondicionuso;
	}

	public String getNombreCondicionuso() {
		return this.nombreCondicionuso;
	}

	public void setNombreCondicionuso(String nombreCondicionuso) {
		this.nombreCondicionuso = nombreCondicionuso;
	}

	public Equiposcalibracionequipo getEquiposcalibracionequipo() {
		return this.equiposcalibracionequipo;
	}

	public void setEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		this.equiposcalibracionequipo = equiposcalibracionequipo;
	}

}