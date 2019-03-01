package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trabant database table.
 * 
 */
@Entity
@NamedQuery(name="Trabant.findAll", query="SELECT t FROM Trabant t")
public class Trabant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nsec_tant")
	private Integer nsecTant;

	private String depe;

	@Column(name="fing_tant")
	private String fingTant;

	@Column(name="fsal_tant")
	private String fsalTant;

	private String motsal;

	private String nced;

	@Column(name="nom_emp")
	private String nomEmp;

	private String ucargo;

	public Trabant() {
	}

	public Integer getNsecTant() {
		return this.nsecTant;
	}

	public void setNsecTant(Integer nsecTant) {
		this.nsecTant = nsecTant;
	}

	public String getDepe() {
		return this.depe;
	}

	public void setDepe(String depe) {
		this.depe = depe;
	}

	public String getFingTant() {
		return this.fingTant;
	}

	public void setFingTant(String fingTant) {
		this.fingTant = fingTant;
	}

	public String getFsalTant() {
		return this.fsalTant;
	}

	public void setFsalTant(String fsalTant) {
		this.fsalTant = fsalTant;
	}

	public String getMotsal() {
		return this.motsal;
	}

	public void setMotsal(String motsal) {
		this.motsal = motsal;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNomEmp() {
		return this.nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public String getUcargo() {
		return this.ucargo;
	}

	public void setUcargo(String ucargo) {
		this.ucargo = ucargo;
	}

}