package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the personalcalificado database table.
 * 
 */
@Entity
@Table(name = "personalcalificado", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "Personalcalificado.findAll", query = "SELECT p FROM Personalcalificado p")
public class Personalcalificado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_personalcalificado")
	private Integer idPersonalcalificado;

	@Column(name = "nombre_personalcalificado")
	private String nombrePersonalcalificado;

	@Column(name = "cedula")
	private String cedula;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	// bi-directional many-to-many association to Equiposcalibracionequipo
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "eqpercalf", joinColumns = { @JoinColumn(name =
	 * "id_personalcalificado") }, inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "id_equipo") }) private List<Equiposcalibracionequipo>
	 * equiposcalibracionequipos;
	 */
	@OneToMany(mappedBy = "personal")
	private List<EqPerCalf> eqpercalf;

	public List<EqPerCalf> getEqpercalf() {
		return eqpercalf;
	}

	public void setEqpercalf(List<EqPerCalf> eqpercalf) {
		this.eqpercalf = eqpercalf;
	}

	// bi-directional many-to-many association to Actividadespersonalcalificado
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "percalact", joinColumns = { @JoinColumn(name =
	 * "id_personalcalificado") }, inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "id_actividadecalif") }) private
	 * List<Actividadespersonalcalificado> actividadespersonalcalificados;
	 */

	/*
	 * @OneToMany(mappedBy = "personal") private List<PerCalAct> perCalAct;
	 * 
	 * public List<PerCalAct> getPerCalAct() { return perCalAct; }
	 * 
	 * public void setPerCalAct(List<PerCalAct> perCalAct) { this.perCalAct =
	 * perCalAct; }
	 */

	public Personalcalificado() {
	}

	public Integer getIdPersonalcalificado() {
		return this.idPersonalcalificado;
	}

	public void setIdPersonalcalificado(Integer idPersonalcalificado) {
		this.idPersonalcalificado = idPersonalcalificado;
	}

	public String getNombrePersonalcalificado() {
		return this.nombrePersonalcalificado;
	}

	public void setNombrePersonalcalificado(String nombrePersonalcalificado) {
		this.nombrePersonalcalificado = nombrePersonalcalificado;
	}

	/*
	 * public List<Equiposcalibracionequipo> getEquiposcalibracionequipos() {
	 * return this.equiposcalibracionequipos; }
	 * 
	 * public void setEquiposcalibracionequipos(List<Equiposcalibracionequipo>
	 * equiposcalibracionequipos) { this.equiposcalibracionequipos =
	 * equiposcalibracionequipos; }
	 */

	/*
	 * public List<Actividadespersonalcalificado>
	 * getActividadespersonalcalificados() { return
	 * this.actividadespersonalcalificados; }
	 * 
	 * public void
	 * setActividadespersonalcalificados(List<Actividadespersonalcalificado>
	 * actividadespersonalcalificados) { this.actividadespersonalcalificados =
	 * actividadespersonalcalificados; }
	 */

}