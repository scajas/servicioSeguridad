package ec.edu.epn.acreditacion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the evidencia database table.
 * 
 */
@Entity(name="EvidenciaCatalogo")
@Table(name="evidencia", catalog="`bddcorpepn`", schema="`Acreditacion`")
@NamedQuery(name="Evidencia.findAllCatalogo", query="SELECT e FROM Evidencia e")
public class Evidencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_evid")
	private Integer idEvid;

	@Column(name="cod_evid")
	private String codEvid;

	@Column(name="descr_evid")
	private String descrEvid;

	@Column(name="id_pefil_valida_firma")
	private Integer idPefilValidaFirma;

	@Column(name="id_perfil_encargado")
	private Integer idPerfilEncargado;

	@Column(name="id_perfil_verifica")
	private Integer idPerfilVerifica;

	@Column(name="nom_evid")
	private String nomEvid;

	@Column(name="tipo_evid")
	private String tipoEvid;

	//bi-directional many-to-one association to Subcriterio
	@ManyToOne
	@JoinColumn(name="id_subcr")
	private Subcriterio subcriterio;

	//bi-directional many-to-one association to EvidenciaDetalle
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="evidencia", cascade = CascadeType.ALL )
	private List<EvidenciaDetalle> evidenciaDetalles;

	public Evidencia() {
	}

	public Integer getIdEvid() {
		return this.idEvid;
	}

	public void setIdEvid(Integer idEvid) {
		this.idEvid = idEvid;
	}

	public String getCodEvid() {
		return this.codEvid;
	}

	public void setCodEvid(String codEvid) {
		this.codEvid = codEvid;
	}

	public String getDescrEvid() {
		return this.descrEvid;
	}

	public void setDescrEvid(String descrEvid) {
		this.descrEvid = descrEvid;
	}

	public Integer getIdPefilValidaFirma() {
		return this.idPefilValidaFirma;
	}

	public void setIdPefilValidaFirma(Integer idPefilValidaFirma) {
		this.idPefilValidaFirma = idPefilValidaFirma;
	}

	public Integer getIdPerfilEncargado() {
		return this.idPerfilEncargado;
	}

	public void setIdPerfilEncargado(Integer idPerfilEncargado) {
		this.idPerfilEncargado = idPerfilEncargado;
	}

	public Integer getIdPerfilVerifica() {
		return this.idPerfilVerifica;
	}

	public void setIdPerfilVerifica(Integer idPerfilVerifica) {
		this.idPerfilVerifica = idPerfilVerifica;
	}

	public String getNomEvid() {
		return this.nomEvid;
	}

	public void setNomEvid(String nomEvid) {
		this.nomEvid = nomEvid;
	}

	public String getTipoEvid() {
		return this.tipoEvid;
	}

	public void setTipoEvid(String tipoEvid) {
		this.tipoEvid = tipoEvid;
	}

	public Subcriterio getSubcriterio() {
		return this.subcriterio;
	}

	public void setSubcriterio(Subcriterio subcriterio) {
		this.subcriterio = subcriterio;
	}

	public List<EvidenciaDetalle> getEvidenciaDetalles() {
		return this.evidenciaDetalles;
	}

	public void setEvidenciaDetalles(List<EvidenciaDetalle> evidenciaDetalles) {
		this.evidenciaDetalles = evidenciaDetalles;
	}

	public EvidenciaDetalle addEvidenciaDetalle(EvidenciaDetalle evidenciaDetalle) {
		getEvidenciaDetalles().add(evidenciaDetalle);
		evidenciaDetalle.setEvidencia(this);

		return evidenciaDetalle;
	}

	public EvidenciaDetalle removeEvidenciaDetalle(EvidenciaDetalle evidenciaDetalle) {
		getEvidenciaDetalles().remove(evidenciaDetalle);
		evidenciaDetalle.setEvidencia(null);

		return evidenciaDetalle;
	}

}