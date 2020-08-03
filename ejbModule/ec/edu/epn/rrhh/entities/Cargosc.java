package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the cargosc database table.
 * 
 */
@Entity
@NamedQuery(name="Cargosc.findAll", query="SELECT c FROM Cargosc c")
public class Cargosc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nsec_cargoc")
	private Integer nsecCargoc;

	private String cargoc;

	private String dedicacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fsis_cargosc")
	private Date fsisCargosc;

	private BigDecimal rem;

	private BigDecimal rem2;

	@Column(name="usr_cargosc")
	private String usrCargosc;

	//bi-directional many-to-one association to Tcont
	@ManyToOne
	@JoinColumn(name="tcont")
	private Tcont tcontBean;

	public Cargosc() {
	}

	public Integer getNsecCargoc() {
		return this.nsecCargoc;
	}

	public void setNsecCargoc(Integer nsecCargoc) {
		this.nsecCargoc = nsecCargoc;
	}

	public String getCargoc() {
		return this.cargoc;
	}

	public void setCargoc(String cargoc) {
		this.cargoc = cargoc;
	}

	public String getDedicacion() {
		return this.dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	public Date getFsisCargosc() {
		return this.fsisCargosc;
	}

	public void setFsisCargosc(Date fsisCargosc) {
		this.fsisCargosc = fsisCargosc;
	}

	public BigDecimal getRem() {
		return this.rem;
	}

	public void setRem(BigDecimal rem) {
		this.rem = rem;
	}

	public BigDecimal getRem2() {
		return this.rem2;
	}

	public void setRem2(BigDecimal rem2) {
		this.rem2 = rem2;
	}

	public String getUsrCargosc() {
		return this.usrCargosc;
	}

	public void setUsrCargosc(String usrCargosc) {
		this.usrCargosc = usrCargosc;
	}

	public Tcont getTcontBean() {
		return this.tcontBean;
	}

	public void setTcontBean(Tcont tcontBean) {
		this.tcontBean = tcontBean;
	}

}