package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the deteventocapac database table.
 * 
 */
@Entity
@NamedQuery(name="Deteventocapac.findAll", query="SELECT d FROM Deteventocapac d")
public class Deteventocapac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddeteventocapac;

	private String aprobo;

	private BigDecimal calificacion;

	private Integer ndiasasist;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="nced")
	private Emp emp;

	//bi-directional many-to-one association to Eventocapac
	@ManyToOne
	@JoinColumn(name="codigoevento")
	private Eventocapac eventocapac;

	public Deteventocapac() {
	}

	public Integer getIddeteventocapac() {
		return this.iddeteventocapac;
	}

	public void setIddeteventocapac(Integer iddeteventocapac) {
		this.iddeteventocapac = iddeteventocapac;
	}

	public String getAprobo() {
		return this.aprobo;
	}

	public void setAprobo(String aprobo) {
		this.aprobo = aprobo;
	}

	public BigDecimal getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(BigDecimal calificacion) {
		this.calificacion = calificacion;
	}

	public Integer getNdiasasist() {
		return this.ndiasasist;
	}

	public void setNdiasasist(Integer ndiasasist) {
		this.ndiasasist = ndiasasist;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Eventocapac getEventocapac() {
		return this.eventocapac;
	}

	public void setEventocapac(Eventocapac eventocapac) {
		this.eventocapac = eventocapac;
	}

}