package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sistemagestioncalidad database table.
 * 
 */
@Entity
@Table(name="sistemagestioncalidad", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Sistemagestioncalidad.findAll", query="SELECT s FROM Sistemagestioncalidad s")
public class Sistemagestioncalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sgc")
	private Integer idSgc;

	@Temporal(TemporalType.DATE)
	@Column(name="anioimplemnetacion_sgc")
	private Date anioimplemnetacionSgc;

	@Column(name="certificadocomisioninterna_sgc")
	private String certificadocomisioninternaSgc;

	@Column(name="tiene_sgc")
	private String tieneSgc;

	//bi-directional many-to-one association to Auditoria
	@ManyToOne
	@JoinColumn(name="id_auditoria")
	private Auditoria auditoria;

	public Sistemagestioncalidad() {
	}

	public Integer getIdSgc() {
		return this.idSgc;
	}

	public void setIdSgc(Integer idSgc) {
		this.idSgc = idSgc;
	}

	public Date getAnioimplemnetacionSgc() {
		return this.anioimplemnetacionSgc;
	}

	public void setAnioimplemnetacionSgc(Date anioimplemnetacionSgc) {
		this.anioimplemnetacionSgc = anioimplemnetacionSgc;
	}

	public String getCertificadocomisioninternaSgc() {
		return this.certificadocomisioninternaSgc;
	}

	public void setCertificadocomisioninternaSgc(String certificadocomisioninternaSgc) {
		this.certificadocomisioninternaSgc = certificadocomisioninternaSgc;
	}

	public String getTieneSgc() {
		return this.tieneSgc;
	}

	public void setTieneSgc(String tieneSgc) {
		this.tieneSgc = tieneSgc;
	}

	public Auditoria getAuditoria() {
		return this.auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

}