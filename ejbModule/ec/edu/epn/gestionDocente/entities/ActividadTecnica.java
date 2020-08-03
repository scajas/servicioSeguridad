package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the actividad_tecnica database table.
 * 
 */
@Entity
@Table(name="actividad_tecnica" , catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name="ActividadTecnica.findAll", query="SELECT a FROM ActividadTecnica a")
public class ActividadTecnica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "actividad_tecnica_idat_seq", sequenceName="actividad_tecnica_idat_seq",allocationSize=1, catalog="bddcorpepn",schema="`GestionDocente`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="actividad_tecnica_idat_seq")
	
	@Column(name="id_activid_tecadm")
	private Integer idActividTecadm;

	private String cargo;

	@Column(name="descripcion_ata")
	private String descripcionAta;

	private String descripcion1;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_ata")
	private Date fechaFinAta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_ata")
	private Date fechaInicioAta;

	@Column(name="fecha_sis")
	private Timestamp fechaSis;

	@Column(name="id_cargo_adm")
	private String idCargoAdm;

	private String nced;

	@Column(name="nombre_adm")
	private String nombreAdm;

	@Column(name="num_horas_ata")
	private Integer numHorasAta;

	@Column(name="num_horas_semana")
	private Integer numHorasSemana;

	private String semestre;

	private String tipo;

	@Column(name="usuario_log")
	private String usuarioLog;

	private String validacion;

	//bi-directional many-to-one association to Periodo
	@ManyToOne
	@JoinColumn(name="id_periodo")
	private Periodo periodo;

	public ActividadTecnica() {
	}

	public Integer getIdActividTecadm() {
		return this.idActividTecadm;
	}

	public void setIdActividTecadm(Integer idActividTecadm) {
		this.idActividTecadm = idActividTecadm;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescripcionAta() {
		return this.descripcionAta;
	}

	public void setDescripcionAta(String descripcionAta) {
		this.descripcionAta = descripcionAta;
	}

	public String getDescripcion1() {
		return this.descripcion1;
	}

	public void setDescripcion1(String descripcion1) {
		this.descripcion1 = descripcion1;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFinAta() {
		return this.fechaFinAta;
	}

	public void setFechaFinAta(Date fechaFinAta) {
		this.fechaFinAta = fechaFinAta;
	}

	public Date getFechaInicioAta() {
		return this.fechaInicioAta;
	}

	public void setFechaInicioAta(Date fechaInicioAta) {
		this.fechaInicioAta = fechaInicioAta;
	}

	public Timestamp getFechaSis() {
		return this.fechaSis;
	}

	public void setFechaSis(Timestamp fechaSis) {
		this.fechaSis = fechaSis;
	}

	public String getIdCargoAdm() {
		return this.idCargoAdm;
	}

	public void setIdCargoAdm(String idCargoAdm) {
		this.idCargoAdm = idCargoAdm;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombreAdm() {
		return this.nombreAdm;
	}

	public void setNombreAdm(String nombreAdm) {
		this.nombreAdm = nombreAdm;
	}

	public Integer getNumHorasAta() {
		return this.numHorasAta;
	}

	public void setNumHorasAta(Integer numHorasAta) {
		this.numHorasAta = numHorasAta;
	}

	public Integer getNumHorasSemana() {
		return this.numHorasSemana;
	}

	public void setNumHorasSemana(Integer numHorasSemana) {
		this.numHorasSemana = numHorasSemana;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsuarioLog() {
		return this.usuarioLog;
	}

	public void setUsuarioLog(String usuarioLog) {
		this.usuarioLog = usuarioLog;
	}

	public String getValidacion() {
		return this.validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

}