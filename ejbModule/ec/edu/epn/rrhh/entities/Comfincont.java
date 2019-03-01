package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the comfincont database table.
 * 
 */
@Entity
@NamedQuery(name="Comfincont.findAll", query="SELECT c FROM Comfincont c")
public class Comfincont implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nsec_comfincont")
	private Integer nsecComfincont;

	private String cargojefe;

	private String ella;

	@Temporal(TemporalType.DATE)
	private Date feclimtram;

	@Temporal(TemporalType.DATE)
	private Date fecmemo;

	private String iniciales;

	private String nomjefe;

	private String nummemo;

	private String titulocont;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="nced")
	private Emp emp;

	public Comfincont() {
	}

	public Integer getNsecComfincont() {
		return this.nsecComfincont;
	}

	public void setNsecComfincont(Integer nsecComfincont) {
		this.nsecComfincont = nsecComfincont;
	}

	public String getCargojefe() {
		return this.cargojefe;
	}

	public void setCargojefe(String cargojefe) {
		this.cargojefe = cargojefe;
	}

	public String getElla() {
		return this.ella;
	}

	public void setElla(String ella) {
		this.ella = ella;
	}

	public Date getFeclimtram() {
		return this.feclimtram;
	}

	public void setFeclimtram(Date feclimtram) {
		this.feclimtram = feclimtram;
	}

	public Date getFecmemo() {
		return this.fecmemo;
	}

	public void setFecmemo(Date fecmemo) {
		this.fecmemo = fecmemo;
	}

	public String getIniciales() {
		return this.iniciales;
	}

	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}

	public String getNomjefe() {
		return this.nomjefe;
	}

	public void setNomjefe(String nomjefe) {
		this.nomjefe = nomjefe;
	}

	public String getNummemo() {
		return this.nummemo;
	}

	public void setNummemo(String nummemo) {
		this.nummemo = nummemo;
	}

	public String getTitulocont() {
		return this.titulocont;
	}

	public void setTitulocont(String titulocont) {
		this.titulocont = titulocont;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}