package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the cercalacrasignado database table.
 * 
 */
@Entity
@Table(name = "cercalacrasignado", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "Cercalacrasignado.findAll", query = "SELECT c FROM Cercalacrasignado c")
public class Cercalacrasignado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_certificacion")
	private Integer idCertificacion;

	@Column(name = "anexo_certificacion")
	private String anexoCertificacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaobtencion_certificacion")
	private Date fechaobtencionCertificacion;

	@Column(name = "norma_certificacion")
	private String normaCertificacion;

	@Column(name = "periodovigencia_certificacion")
	private Integer periodovigenciaCertificacion;

	// bi-directional many-to-one association to Auditoria
	@ManyToOne
	@JoinColumn(name = "id_auditoria")
	private Auditoria auditoria;

	public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public Cercalacrasignado() {
	}

	public Integer getIdCertificacion() {
		return this.idCertificacion;
	}

	public void setIdCertificacion(Integer idCertificacion) {
		this.idCertificacion = idCertificacion;
	}

	public String getAnexoCertificacion() {
		return this.anexoCertificacion;
	}

	public void setAnexoCertificacion(String anexoCertificacion) {
		this.anexoCertificacion = anexoCertificacion;
	}

	public Date getFechaobtencionCertificacion() {
		return this.fechaobtencionCertificacion;
	}

	public void setFechaobtencionCertificacion(Date fechaobtencionCertificacion) {
		this.fechaobtencionCertificacion = fechaobtencionCertificacion;
	}

	public String getNormaCertificacion() {
		return this.normaCertificacion;
	}

	public void setNormaCertificacion(String normaCertificacion) {
		this.normaCertificacion = normaCertificacion;
	}

	public Integer getPeriodovigenciaCertificacion() {
		return this.periodovigenciaCertificacion;
	}

	public void setPeriodovigenciaCertificacion(Integer periodovigenciaCertificacion) {
		this.periodovigenciaCertificacion = periodovigenciaCertificacion;
	}


	
}