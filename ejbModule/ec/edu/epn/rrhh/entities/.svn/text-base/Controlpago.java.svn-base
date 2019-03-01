package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the controlpagos database table.
 * 
 */
@Entity
@Table(name="controlpagos")
@NamedQuery(name="Controlpago.findAll", query="SELECT c FROM Controlpago c")
public class Controlpago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idcontrolpagos;

	private String cumple;

	@Temporal(TemporalType.DATE)
	@Column(name="fecsis_controlpagos")
	private Date fecsisControlpagos;

	@Temporal(TemporalType.DATE)
	private Date fecsolicpagos;

	private String numsolicpagos;

	private String obsr;

	private String periodo;

	@Column(name="usr_controlpagos")
	private String usrControlpagos;

	//bi-directional many-to-one association to Cont
	@ManyToOne
	@JoinColumn(name="nro_cont")
	private Cont cont;

	public Controlpago() {
	}

	public Integer getIdcontrolpagos() {
		return this.idcontrolpagos;
	}

	public void setIdcontrolpagos(Integer idcontrolpagos) {
		this.idcontrolpagos = idcontrolpagos;
	}

	public String getCumple() {
		return this.cumple;
	}

	public void setCumple(String cumple) {
		this.cumple = cumple;
	}

	public Date getFecsisControlpagos() {
		return this.fecsisControlpagos;
	}

	public void setFecsisControlpagos(Date fecsisControlpagos) {
		this.fecsisControlpagos = fecsisControlpagos;
	}

	public Date getFecsolicpagos() {
		return this.fecsolicpagos;
	}

	public void setFecsolicpagos(Date fecsolicpagos) {
		this.fecsolicpagos = fecsolicpagos;
	}

	public String getNumsolicpagos() {
		return this.numsolicpagos;
	}

	public void setNumsolicpagos(String numsolicpagos) {
		this.numsolicpagos = numsolicpagos;
	}

	public String getObsr() {
		return this.obsr;
	}

	public void setObsr(String obsr) {
		this.obsr = obsr;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getUsrControlpagos() {
		return this.usrControlpagos;
	}

	public void setUsrControlpagos(String usrControlpagos) {
		this.usrControlpagos = usrControlpagos;
	}

	public Cont getCont() {
		return this.cont;
	}

	public void setCont(Cont cont) {
		this.cont = cont;
	}

}