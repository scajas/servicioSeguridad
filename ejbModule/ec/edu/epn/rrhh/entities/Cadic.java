package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cadic database table.
 * 
 */
@Entity
@NamedQuery(name="Cadic.findAll", query="SELECT c FROM Cadic c")
public class Cadic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nsec_cadic")
	private Integer nsecCadic;

	@Column(name="cod_mencion")
	private String codMencion;

	@Column(name="durac_cadic")
	private String duracCadic;

	@Column(name="fini_cadic")
	private String finiCadic;

	@Column(name="fterm_cadic")
	private String ftermCadic;

	@Column(name="inst_cadic")
	private String instCadic;

	@Column(name="nom_curso")
	private String nomCurso;

	private String tdoc;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="nced")
	private Emp emp;

	public Cadic() {
	}

	public Integer getNsecCadic() {
		return this.nsecCadic;
	}

	public void setNsecCadic(Integer nsecCadic) {
		this.nsecCadic = nsecCadic;
	}

	public String getCodMencion() {
		return this.codMencion;
	}

	public void setCodMencion(String codMencion) {
		this.codMencion = codMencion;
	}

	public String getDuracCadic() {
		return this.duracCadic;
	}

	public void setDuracCadic(String duracCadic) {
		this.duracCadic = duracCadic;
	}

	public String getFiniCadic() {
		return this.finiCadic;
	}

	public void setFiniCadic(String finiCadic) {
		this.finiCadic = finiCadic;
	}

	public String getFtermCadic() {
		return this.ftermCadic;
	}

	public void setFtermCadic(String ftermCadic) {
		this.ftermCadic = ftermCadic;
	}

	public String getInstCadic() {
		return this.instCadic;
	}

	public void setInstCadic(String instCadic) {
		this.instCadic = instCadic;
	}

	public String getNomCurso() {
		return this.nomCurso;
	}

	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}

	public String getTdoc() {
		return this.tdoc;
	}

	public void setTdoc(String tdoc) {
		this.tdoc = tdoc;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}