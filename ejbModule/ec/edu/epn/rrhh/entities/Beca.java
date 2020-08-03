package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the beca database table.
 * 
 */
@Entity
@NamedQuery(name="Beca.findAll", query="SELECT b FROM Beca b")
public class Beca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nro_beca")
	private Integer nroBeca;

	private String carrera;

	@Temporal(TemporalType.DATE)
	@Column(name="fing_carrera")
	private Date fingCarrera;

	private String nced;

	private Integer ncredtot;

	private Integer nsem;

	public Beca() {
	}

	public Integer getNroBeca() {
		return this.nroBeca;
	}

	public void setNroBeca(Integer nroBeca) {
		this.nroBeca = nroBeca;
	}

	public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Date getFingCarrera() {
		return this.fingCarrera;
	}

	public void setFingCarrera(Date fingCarrera) {
		this.fingCarrera = fingCarrera;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public Integer getNcredtot() {
		return this.ncredtot;
	}

	public void setNcredtot(Integer ncredtot) {
		this.ncredtot = ncredtot;
	}

	public Integer getNsem() {
		return this.nsem;
	}

	public void setNsem(Integer nsem) {
		this.nsem = nsem;
	}

}