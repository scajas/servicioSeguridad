package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the funcionesequipo database table.
 * 
 */
@Entity
@Table(name="funcionesequipo", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Funcionesequipo.findAll", query="SELECT f FROM Funcionesequipo f")
public class Funcionesequipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_funcioneq")
	private Integer idFuncioneq;

	@Column(name="descripcion_funcioneq")
	private String descripcionFuncioneq;

	@Column(name="nombre_funcioneq")
	private String nombreFuncioneq;

	//bi-directional many-to-one association to Equiposcalibracionequipo
	@ManyToOne
	@JoinColumn(name="id_equipo")
	private Equiposcalibracionequipo equiposcalibracionequipo;

	public Funcionesequipo() {
	}

	public Integer getIdFuncioneq() {
		return this.idFuncioneq;
	}

	public void setIdFuncioneq(Integer idFuncioneq) {
		this.idFuncioneq = idFuncioneq;
	}

	public String getDescripcionFuncioneq() {
		return this.descripcionFuncioneq;
	}

	public void setDescripcionFuncioneq(String descripcionFuncioneq) {
		this.descripcionFuncioneq = descripcionFuncioneq;
	}

	public String getNombreFuncioneq() {
		return this.nombreFuncioneq;
	}

	public void setNombreFuncioneq(String nombreFuncioneq) {
		this.nombreFuncioneq = nombreFuncioneq;
	}

	public Equiposcalibracionequipo getEquiposcalibracionequipo() {
		return this.equiposcalibracionequipo;
	}

	public void setEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		this.equiposcalibracionequipo = equiposcalibracionequipo;
	}

}