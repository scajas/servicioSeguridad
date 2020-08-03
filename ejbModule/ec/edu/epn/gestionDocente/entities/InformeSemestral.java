package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the informe_semestral database table.
 * 
 */
@Entity
@Table(name="informe_semestral")
@NamedQuery(name="InformeSemestral.findAll", query="SELECT i FROM InformeSemestral i")
public class InformeSemestral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_informe_sem")
	private String idInformeSem;

	private String nced;

	@Column(name="sum_num_horas_adm")
	private Integer sumNumHorasAdm;

	@Column(name="sum_num_horas_doc")
	private Integer sumNumHorasDoc;

	@Column(name="sum_num_horas_ext")
	private Integer sumNumHorasExt;

	@Column(name="sum_num_horas_inv")
	private Integer sumNumHorasInv;

	//bi-directional many-to-one association to Periodo
	@ManyToOne
	@JoinColumn(name="id_periodo")
	private Periodo periodo;

	public InformeSemestral() {
	}

	public String getIdInformeSem() {
		return this.idInformeSem;
	}

	public void setIdInformeSem(String idInformeSem) {
		this.idInformeSem = idInformeSem;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public Integer getSumNumHorasAdm() {
		return this.sumNumHorasAdm;
	}

	public void setSumNumHorasAdm(Integer sumNumHorasAdm) {
		this.sumNumHorasAdm = sumNumHorasAdm;
	}

	public Integer getSumNumHorasDoc() {
		return this.sumNumHorasDoc;
	}

	public void setSumNumHorasDoc(Integer sumNumHorasDoc) {
		this.sumNumHorasDoc = sumNumHorasDoc;
	}

	public Integer getSumNumHorasExt() {
		return this.sumNumHorasExt;
	}

	public void setSumNumHorasExt(Integer sumNumHorasExt) {
		this.sumNumHorasExt = sumNumHorasExt;
	}

	public Integer getSumNumHorasInv() {
		return this.sumNumHorasInv;
	}

	public void setSumNumHorasInv(Integer sumNumHorasInv) {
		this.sumNumHorasInv = sumNumHorasInv;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

}