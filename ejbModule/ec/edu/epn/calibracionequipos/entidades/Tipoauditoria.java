package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoauditoria database table.
 * 
 */
@Entity
@Table(name="tipoauditoria", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Tipoauditoria.findAll", query="SELECT t FROM Tipoauditoria t")
public class Tipoauditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipoaudit")
	private Integer idTipoaudit;

	@Column(name="frecuencia_tipoaudit")
	private String frecuenciaTipoaudit;

	@Column(name="nombre_tipoaudit")
	private String nombreTipoaudit;

	//bi-directional many-to-one association to Auditoria
	@OneToMany(mappedBy="tipoauditoria")
	private List<Auditoria> auditorias;

	public Tipoauditoria() {
	}

	public Integer getIdTipoaudit() {
		return this.idTipoaudit;
	}

	public void setIdTipoaudit(Integer idTipoaudit) {
		this.idTipoaudit = idTipoaudit;
	}

	public String getFrecuenciaTipoaudit() {
		return this.frecuenciaTipoaudit;
	}

	public void setFrecuenciaTipoaudit(String frecuenciaTipoaudit) {
		this.frecuenciaTipoaudit = frecuenciaTipoaudit;
	}

	public String getNombreTipoaudit() {
		return this.nombreTipoaudit;
	}

	public void setNombreTipoaudit(String nombreTipoaudit) {
		this.nombreTipoaudit = nombreTipoaudit;
	}

	public List<Auditoria> getAuditorias() {
		return this.auditorias;
	}

	public void setAuditorias(List<Auditoria> auditorias) {
		this.auditorias = auditorias;
	}

	public Auditoria addAuditoria(Auditoria auditoria) {
		getAuditorias().add(auditoria);
		auditoria.setTipoauditoria(this);

		return auditoria;
	}

	public Auditoria removeAuditoria(Auditoria auditoria) {
		getAuditorias().remove(auditoria);
		auditoria.setTipoauditoria(null);

		return auditoria;
	}

}