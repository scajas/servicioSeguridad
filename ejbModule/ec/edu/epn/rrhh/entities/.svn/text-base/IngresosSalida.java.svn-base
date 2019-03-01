package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ingresos_salidas database table.
 * 
 */
@Entity
@Table(name="ingresos_salidas")
@NamedQuery(name="IngresosSalida.findAll", query="SELECT i FROM IngresosSalida i")
public class IngresosSalida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nsec_ingsal")
	private Integer nsecIngsal;

	@Temporal(TemporalType.DATE)
	private Date fecing;

	@Temporal(TemporalType.DATE)
	private Date fecsal;

	private String nced;

	private Integer ndias;

	public IngresosSalida() {
	}

	public Integer getNsecIngsal() {
		return this.nsecIngsal;
	}

	public void setNsecIngsal(Integer nsecIngsal) {
		this.nsecIngsal = nsecIngsal;
	}

	public Date getFecing() {
		return this.fecing;
	}

	public void setFecing(Date fecing) {
		this.fecing = fecing;
	}

	public Date getFecsal() {
		return this.fecsal;
	}

	public void setFecsal(Date fecsal) {
		this.fecsal = fecsal;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public Integer getNdias() {
		return this.ndias;
	}

	public void setNdias(Integer ndias) {
		this.ndias = ndias;
	}

}