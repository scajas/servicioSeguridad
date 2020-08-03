package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the funciones database table.
 * 
 */
@Entity
@Table(name="funciones")
@NamedQuery(name="Funcione.findAll", query="SELECT f FROM Funcione f")
public class Funcione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_funciones")
	private Integer idFunciones;

	@Column(name="activ_event")
	private String activEvent;

	@Column(name="activ_period")
	private String activPeriod;

	@Column(name="activ_perm")
	private String activPerm;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_sis")
	private Date fecSis;

	private String periodo;

	private String usr;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="nced")
	private Emp emp;

	public Funcione() {
	}

	public Integer getIdFunciones() {
		return this.idFunciones;
	}

	public void setIdFunciones(Integer idFunciones) {
		this.idFunciones = idFunciones;
	}

	public String getActivEvent() {
		return this.activEvent;
	}

	public void setActivEvent(String activEvent) {
		this.activEvent = activEvent;
	}

	public String getActivPeriod() {
		return this.activPeriod;
	}

	public void setActivPeriod(String activPeriod) {
		this.activPeriod = activPeriod;
	}

	public String getActivPerm() {
		return this.activPerm;
	}

	public void setActivPerm(String activPerm) {
		this.activPerm = activPerm;
	}

	public Date getFecSis() {
		return this.fecSis;
	}

	public void setFecSis(Date fecSis) {
		this.fecSis = fecSis;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getUsr() {
		return this.usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}