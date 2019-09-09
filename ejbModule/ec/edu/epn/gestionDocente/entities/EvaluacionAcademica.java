package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the evaluacion_academica database table.
 * 
 */
@Entity
@Table(name="evaluacion_academica",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="EvaluacionAcademica.findAll", query="SELECT e FROM EvaluacionAcademica e")
public class EvaluacionAcademica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"GestionDocente\".sec_evalaucion_academica")
	@SequenceGenerator(name = "\"GestionDocente\".sec_evalaucion_academica", sequenceName = "\"GestionDocente\".sec_evalaucion_academica", allocationSize = 1)		
	@Column(name="id_eval_acad")
	private Integer idEvalAcad;

	@Column(name="calificacion_ponderada")
	private double calificacionPonderada;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	@Column(name="id_pensum")
	private Integer idPensum;

	private String nced;

	@Column(name="nced_dir")
	private String ncedDir;
	
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="estado", insertable = false, updatable = false)
	private EstadoEvaluacion estadoEvaluacion;*/
	
	

	@Column(name="val_final_auto")
	private double valFinalAuto;

	@Column(name="val_final_coe")
	private double valFinalCoe;
	
	@Column(name="val_final_hetero")
	private double valFinalHetero;
	
	
	@Column(name="id_usuario_planif")
	private Integer idUsuarioPlanif;
	
	@Column(name="id_usuario_auto")
	private Integer idUsuarioAuto;
	
	@Column(name="id_usuario_coe")
	private Integer idUsuarioCoe;
	
	
	@Column(name="total_horas_planificadas")
	private double totalHorasPlanificadas;
	
	@Column(name="justificar_planificacion")
	private String justificarPlanificacion;
	
	@Column(name="path_evidencia")
	private String pathEvidencia;
	
	@Column(name="semanas_doc_dentro")
	private double semanasDocDentro;
	
	@Column(name="apelacion_consejo")
	private String apelacionConsejo;
	
	@Column(name="resultado_apelacion")
	private String resultadoApelacion;
	
	
	@Column(name="resolucion_consejo_facultad")
	private String resolucionConsejoFacultad;
	
	
	@Column(name="apelacion_consejo_dep")
	private String apelacionConsejoDep;
	
	@Column(name="resultado_apelacion_dep")
	private String resultadoApelacionDep;
	
	
	@Column(name="resolucion_consejo_facultad_dep")
	private String resolucionConsejoFacultadDep;
	
	
	@Column(name="hrs_planif_total")
	private Double hrsPlanifTotal;
	
	
	@Column(name="calf_ponderada_doc")
	private Double calfPonderadaDoc;
	
	@Column(name="calf_ponderada_inv")
	private Double calfPonderadaInv;
	
	@Column(name="calf_ponderada_gest")
	private Double calfPonderadaGest;
	

	
	 
	

	public EvaluacionAcademica() {
	}

	public Integer getIdEvalAcad() {
		return this.idEvalAcad;
	}

	public void setIdEvalAcad(Integer idEvalAcad) {
		this.idEvalAcad = idEvalAcad;
	}

	public double getCalificacionPonderada() {
		return this.calificacionPonderada;
	}

	public void setCalificacionPonderada(double calificacionPonderada) {
		this.calificacionPonderada = calificacionPonderada;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNcedDir() {
		return this.ncedDir;
	}

	public void setNcedDir(String ncedDir) {
		this.ncedDir = ncedDir;
	}

	

	

	/**
	 * @return the idUsuarioPlanif
	 */
	public Integer getIdUsuarioPlanif() {
		return idUsuarioPlanif;
	}

	/**
	 * @param idUsuarioPlanif the idUsuarioPlanif to set
	 */
	public void setIdUsuarioPlanif(Integer idUsuarioPlanif) {
		this.idUsuarioPlanif = idUsuarioPlanif;
	}

	/**
	 * @return the idUsuarioAuto
	 */
	public Integer getIdUsuarioAuto() {
		return idUsuarioAuto;
	}

	/**
	 * @param idUsuarioAuto the idUsuarioAuto to set
	 */
	public void setIdUsuarioAuto(Integer idUsuarioAuto) {
		this.idUsuarioAuto = idUsuarioAuto;
	}

	/**
	 * @return the idUsuarioCoe
	 */
	public Integer getIdUsuarioCoe() {
		return idUsuarioCoe;
	}

	/**
	 * @param idUsuarioCoe the idUsuarioCoe to set
	 */
	public void setIdUsuarioCoe(Integer idUsuarioCoe) {
		this.idUsuarioCoe = idUsuarioCoe;
	}

	/**
	 * @return the valFinalAuto
	 */
	public double getValFinalAuto() {
		return valFinalAuto;
	}

	/**
	 * @param valFinalAuto the valFinalAuto to set
	 */
	public void setValFinalAuto(double valFinalAuto) {
		this.valFinalAuto = valFinalAuto;
	}

	/**
	 * @return the valFinalCoe
	 */
	public double getValFinalCoe() {
		return valFinalCoe;
	}

	/**
	 * @param valFinalCoe the valFinalCoe to set
	 */
	public void setValFinalCoe(double valFinalCoe) {
		this.valFinalCoe = valFinalCoe;
	}

	/**
	 * @return the valFinalHetero
	 */
	public double getValFinalHetero() {
		return valFinalHetero;
	}

	/**
	 * @param valFinalHetero the valFinalHetero to set
	 */
	public void setValFinalHetero(double valFinalHetero) {
		this.valFinalHetero = valFinalHetero;
	}

	/**
	 * @return the totalHorasPlanificadas
	 */
	public double getTotalHorasPlanificadas() {
		return totalHorasPlanificadas;
	}

	/**
	 * @param totalHorasPlanificadas the totalHorasPlanificadas to set
	 */
	public void setTotalHorasPlanificadas(double totalHorasPlanificadas) {
		this.totalHorasPlanificadas = totalHorasPlanificadas;
	}

	/**
	 * @return the justificarPlanificacion
	 */
	public String getJustificarPlanificacion() {
		return justificarPlanificacion;
	}

	/**
	 * @param justificarPlanificacion the justificarPlanificacion to set
	 */
	public void setJustificarPlanificacion(String justificarPlanificacion) {
		this.justificarPlanificacion = justificarPlanificacion;
	}

	/**
	 * @return the pathEvidencia
	 */
	public String getPathEvidencia() {
		return pathEvidencia;
	}

	/**
	 * @param pathEvidencia the pathEvidencia to set
	 */
	public void setPathEvidencia(String pathEvidencia) {
		this.pathEvidencia = pathEvidencia;
	}

	/**
	 * @return the semanasDocDentro
	 */
	public double getSemanasDocDentro() {
		return semanasDocDentro;
	}

	/**
	 * @param semanasDocDentro the semanasDocDentro to set
	 */
	public void setSemanasDocDentro(double semanasDocDentro) {
		this.semanasDocDentro = semanasDocDentro;
	}

	/**
	 * @return the apelacionConsejo
	 */
	public String getApelacionConsejo() {
		return apelacionConsejo;
	}

	/**
	 * @return the resultadoApelacion
	 */
	public String getResultadoApelacion() {
		return resultadoApelacion;
	}

	/**
	 * @return the resolucionConsejoFacultad
	 */
	public String getResolucionConsejoFacultad() {
		return resolucionConsejoFacultad;
	}

	/**
	 * @param apelacionConsejo the apelacionConsejo to set
	 */
	public void setApelacionConsejo(String apelacionConsejo) {
		this.apelacionConsejo = apelacionConsejo;
	}

	/**
	 * @param resultadoApelacion the resultadoApelacion to set
	 */
	public void setResultadoApelacion(String resultadoApelacion) {
		this.resultadoApelacion = resultadoApelacion;
	}

	/**
	 * @param resolucionConsejoFacultad the resolucionConsejoFacultad to set
	 */
	public void setResolucionConsejoFacultad(String resolucionConsejoFacultad) {
		this.resolucionConsejoFacultad = resolucionConsejoFacultad;
	}

	/**
	 * @return the apelacionConsejoDep
	 */
	public String getApelacionConsejoDep() {
		return apelacionConsejoDep;
	}

	/**
	 * @return the resultadoApelacionDep
	 */
	public String getResultadoApelacionDep() {
		return resultadoApelacionDep;
	}

	/**
	 * @return the resolucionConsejoFacultadDep
	 */
	public String getResolucionConsejoFacultadDep() {
		return resolucionConsejoFacultadDep;
	}

	/**
	 * @param apelacionConsejoDep the apelacionConsejoDep to set
	 */
	public void setApelacionConsejoDep(String apelacionConsejoDep) {
		this.apelacionConsejoDep = apelacionConsejoDep;
	}

	/**
	 * @param resultadoApelacionDep the resultadoApelacionDep to set
	 */
	public void setResultadoApelacionDep(String resultadoApelacionDep) {
		this.resultadoApelacionDep = resultadoApelacionDep;
	}

	/**
	 * @param resolucionConsejoFacultadDep the resolucionConsejoFacultadDep to set
	 */
	public void setResolucionConsejoFacultadDep(String resolucionConsejoFacultadDep) {
		this.resolucionConsejoFacultadDep = resolucionConsejoFacultadDep;
	}

	

	/**
	 * @return the hrsPlanifTotal
	 */
	public Double getHrsPlanifTotal() {
		return hrsPlanifTotal;
	}

	/**
	 * @param hrsPlanifTotal the hrsPlanifTotal to set
	 */
	public void setHrsPlanifTotal(Double hrsPlanifTotal) {
		this.hrsPlanifTotal = hrsPlanifTotal;
	}

	/**
	 * @return the calfPonderadaDoc
	 */
	public Double getCalfPonderadaDoc() {
		return calfPonderadaDoc;
	}

	/**
	 * @return the calfPonderadaInv
	 */
	public Double getCalfPonderadaInv() {
		return calfPonderadaInv;
	}

	/**
	 * @return the calfPonderadaGest
	 */
	public Double getCalfPonderadaGest() {
		return calfPonderadaGest;
	}

	/**
	 * @param calfPonderadaDoc the calfPonderadaDoc to set
	 */
	public void setCalfPonderadaDoc(Double calfPonderadaDoc) {
		this.calfPonderadaDoc = calfPonderadaDoc;
	}

	/**
	 * @param calfPonderadaInv the calfPonderadaInv to set
	 */
	public void setCalfPonderadaInv(Double calfPonderadaInv) {
		this.calfPonderadaInv = calfPonderadaInv;
	}

	/**
	 * @param calfPonderadaGest the calfPonderadaGest to set
	 */
	public void setCalfPonderadaGest(Double calfPonderadaGest) {
		this.calfPonderadaGest = calfPonderadaGest;
	}



	

}