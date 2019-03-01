package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the det_beca database table.
 * 
 */
@Entity
@Table(name="det_beca")
@NamedQuery(name="DetBeca.findAll", query="SELECT d FROM DetBeca d")
public class DetBeca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nro_detbeca")
	private Integer nroDetbeca;

	private String benef;

	private String cargojefe;

	private String dscto;

	@Temporal(TemporalType.DATE)
	private Date fecdoc;

	private Integer ncred;

	private Integer ncredb;

	private String nomjefe;

	@Column(name="nro_beca")
	private Integer nroBeca;

	private String nrodoc;

	private String periodo;

	private String recomjefe;

	private String repite;

	private Integer semact;

	public DetBeca() {
	}

	public Integer getNroDetbeca() {
		return this.nroDetbeca;
	}

	public void setNroDetbeca(Integer nroDetbeca) {
		this.nroDetbeca = nroDetbeca;
	}

	public String getBenef() {
		return this.benef;
	}

	public void setBenef(String benef) {
		this.benef = benef;
	}

	public String getCargojefe() {
		return this.cargojefe;
	}

	public void setCargojefe(String cargojefe) {
		this.cargojefe = cargojefe;
	}

	public String getDscto() {
		return this.dscto;
	}

	public void setDscto(String dscto) {
		this.dscto = dscto;
	}

	public Date getFecdoc() {
		return this.fecdoc;
	}

	public void setFecdoc(Date fecdoc) {
		this.fecdoc = fecdoc;
	}

	public Integer getNcred() {
		return this.ncred;
	}

	public void setNcred(Integer ncred) {
		this.ncred = ncred;
	}

	public Integer getNcredb() {
		return this.ncredb;
	}

	public void setNcredb(Integer ncredb) {
		this.ncredb = ncredb;
	}

	public String getNomjefe() {
		return this.nomjefe;
	}

	public void setNomjefe(String nomjefe) {
		this.nomjefe = nomjefe;
	}

	public Integer getNroBeca() {
		return this.nroBeca;
	}

	public void setNroBeca(Integer nroBeca) {
		this.nroBeca = nroBeca;
	}

	public String getNrodoc() {
		return this.nrodoc;
	}

	public void setNrodoc(String nrodoc) {
		this.nrodoc = nrodoc;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getRecomjefe() {
		return this.recomjefe;
	}

	public void setRecomjefe(String recomjefe) {
		this.recomjefe = recomjefe;
	}

	public String getRepite() {
		return this.repite;
	}

	public void setRepite(String repite) {
		this.repite = repite;
	}

	public Integer getSemact() {
		return this.semact;
	}

	public void setSemact(Integer semact) {
		this.semact = semact;
	}

}