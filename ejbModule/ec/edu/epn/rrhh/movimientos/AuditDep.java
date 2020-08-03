package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "audit_dep", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name = "AuditDep.findAll", query = "SELECT a FROM AuditDep a")
public class AuditDep implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_audep")
	private Integer idAudDep;

	@Column(name = "estado_anterior_dep")
	private String estadoAnteriorDep;

	@Column(name = "estado_nuevo_dep")
	private String estadoNuevoDep;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "motivo_cambio")
	private String motivoCambio;

	@Column(name = "usuario_cambio")
	private String usuarioCambio;

	// bi-directional many-to-one association to Dependencia
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_dep")
	private Dependencia dependencia;

	public Integer getIdAudDep() {
		return idAudDep;
	}

	public void setIdAudDep(Integer idAudDep) {
		this.idAudDep = idAudDep;
	}

	public String getEstadoAnteriorDep() {
		return estadoAnteriorDep;
	}

	public void setEstadoAnteriorDep(String estadoAnteriorDep) {
		this.estadoAnteriorDep = estadoAnteriorDep;
	}

	public String getEstadoNuevoDep() {
		return estadoNuevoDep;
	}

	public void setEstadoNuevoDep(String estadoNuevoDep) {
		this.estadoNuevoDep = estadoNuevoDep;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getMotivoCambio() {
		return motivoCambio;
	}

	public void setMotivoCambio(String motivoCambio) {
		this.motivoCambio = motivoCambio;
	}

	public String getUsuarioCambio() {
		return usuarioCambio;
	}

	public void setUsuarioCambio(String usuarioCambio) {
		this.usuarioCambio = usuarioCambio;
	}

	public Dependencia getDependencia() {
		return dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}
	
	

}
