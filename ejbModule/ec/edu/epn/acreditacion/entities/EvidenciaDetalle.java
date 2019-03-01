package ec.edu.epn.acreditacion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the evidencia_detalle database table.
 * 
 */
@Entity
@Table(name="evidencia_detalle", catalog="`bddcorpepn`", schema="`Acreditacion`")
@NamedQuery(name="EvidenciaDetalle.findAll", query="SELECT e FROM EvidenciaDetalle e")
public class EvidenciaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"Acreditacion\".sec_evidencia_detalle")
	@SequenceGenerator(name = "\"Acreditacion\".sec_evidencia_detalle", sequenceName = "\"Acreditacion\".sec_evidencia_detalle", allocationSize = 1)
	@Column(name="id_evidet")
	private Integer idEvidet;

	@Column(name="enviada_alfresco")
	private String enviadaAlfresco;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ge")
	private Date fechaGe;

	private String firma;

	@Column(name="id_carrera")
	private String idCarrera;

	@Column(name="id_pensum")
	private Integer idPensum;

	@Column(name="id_usuario_ge")
	private Integer idUsuarioGe;

	@Column(name="nom_evid_det")
	private String nomEvidDet;

	@Column(name="observ_evid")
	private String observEvid;

	private String observalida;

	private String observerifica;

	private String path;

	@Column(name="responsable_valida")
	private String responsableValida;

	@Column(name="responsable_verifica")
	private String responsableVerifica;
	
	private String existencia;
	
	private Double calificacion;

	//bi-directional many-to-one association to Evidencia
	@ManyToOne
	@JoinColumn(name="id_evid")
	private Evidencia evidencia;

	public EvidenciaDetalle() {
	}

	public Integer getIdEvidet() {
		return this.idEvidet;
	}

	public void setIdEvidet(Integer idEvidet) {
		this.idEvidet = idEvidet;
	}

	public String getEnviadaAlfresco() {
		return this.enviadaAlfresco;
	}

	public void setEnviadaAlfresco(String enviadaAlfresco) {
		this.enviadaAlfresco = enviadaAlfresco;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaGe() {
		return this.fechaGe;
	}

	public void setFechaGe(Date fechaGe) {
		this.fechaGe = fechaGe;
	}

	public String getFirma() {
		return this.firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getIdCarrera() {
		return this.idCarrera;
	}

	public void setIdCarrera(String idCarrera) {
		this.idCarrera = idCarrera;
	}

	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	public Integer getIdUsuarioGe() {
		return this.idUsuarioGe;
	}

	public void setIdUsuarioGe(Integer idUsuarioGe) {
		this.idUsuarioGe = idUsuarioGe;
	}

	public String getNomEvidDet() {
		return this.nomEvidDet;
	}

	public void setNomEvidDet(String nomEvidDet) {
		this.nomEvidDet = nomEvidDet;
	}

	public String getObservEvid() {
		return this.observEvid;
	}

	public void setObservEvid(String observEvid) {
		this.observEvid = observEvid;
	}

	public String getObservalida() {
		return this.observalida;
	}

	public void setObservalida(String observalida) {
		this.observalida = observalida;
	}

	public String getObserverifica() {
		return this.observerifica;
	}

	public void setObserverifica(String observerifica) {
		this.observerifica = observerifica;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getResponsableValida() {
		return this.responsableValida;
	}

	public void setResponsableValida(String responsableValida) {
		this.responsableValida = responsableValida;
	}

	public String getResponsableVerifica() {
		return this.responsableVerifica;
	}

	public void setResponsableVerifica(String responsableVerifica) {
		this.responsableVerifica = responsableVerifica;
	}

	public Evidencia getEvidencia() {
		return this.evidencia;
	}

	public void setEvidencia(Evidencia evidencia) {
		this.evidencia = evidencia;
	}

	/**
	 * @return the existencia
	 */
	public String getExistencia() {
		return existencia;
	}

	/**
	 * @return the calificacion
	 */
	public Double getCalificacion() {
		return calificacion;
	}

	/**
	 * @param existencia the existencia to set
	 */
	public void setExistencia(String existencia) {
		this.existencia = existencia;
	}

	/**
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}

}