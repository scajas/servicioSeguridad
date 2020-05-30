package ec.edu.epn.emergencia.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the autorizacion database table.
 * 
 */
@Entity
@Table(name = "autorizacion", catalog = "bddcorpepn", schema = "\"Emergencia\"")
@NamedQuery(name="AutorizacionEmergencia.findAll", query="SELECT a FROM AutorizacionEmergencia a")
public class AutorizacionEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_autorizacion")
	private Integer idAutorizacion;

	@Column(name="autorizado_por")
	private String autorizadoPor;

	@Column(name="cargo_autoriza")
	private String cargoAutoriza;

	@Column(name="dependencia_destino")
	private String dependenciaDestino;

	@Column(name="dependencia_origen")
	private String dependenciaOrigen;
	
	@Column(name="placa")
	private String placa;
	
	@Column(name="semaforo")
	private String semaforo;

	@Column(name="fecha_desde")
	private Date fechaDesde;

	@Column(name="fecha_hasta")
	private Date fechaHasta;

	@Column(name="fecha_registro")
	private Timestamp fechaRegistro;

	@Column(name="motivo_autorizacion")
	private String motivoAutorizacion;

	private String nced;

	@Column(name="nombre_usuario_registro")
	private String nombreUsuarioRegistro;

	private String nombres;
	
	private String cargo;


	//bi-directional many-to-one association to Asistencia
	@OneToMany(mappedBy="autorizacion")
	private List<AsistenciaEmergencia> asistencias;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private EstadoEmergencia estado;

	public AutorizacionEmergencia() {
	}

	public Integer getIdAutorizacion() {
		return this.idAutorizacion;
	}

	public void setIdAutorizacion(Integer idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}

	public String getAutorizadoPor() {
		return this.autorizadoPor;
	}

	public void setAutorizadoPor(String autorizadoPor) {
		this.autorizadoPor = autorizadoPor;
	}

	public String getCargoAutoriza() {
		return this.cargoAutoriza;
	}

	public void setCargoAutoriza(String cargoAutoriza) {
		this.cargoAutoriza = cargoAutoriza;
	}

	public String getDependenciaDestino() {
		return this.dependenciaDestino;
	}

	public void setDependenciaDestino(String dependenciaDestino) {
		this.dependenciaDestino = dependenciaDestino;
	}

	public String getDependenciaOrigen() {
		return this.dependenciaOrigen;
	}

	public void setDependenciaOrigen(String dependenciaOrigen) {
		this.dependenciaOrigen = dependenciaOrigen;
	}

	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getMotivoAutorizacion() {
		return this.motivoAutorizacion;
	}

	public void setMotivoAutorizacion(String motivoAutorizacion) {
		this.motivoAutorizacion = motivoAutorizacion;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombreUsuarioRegistro() {
		return this.nombreUsuarioRegistro;
	}

	public void setNombreUsuarioRegistro(String nombreUsuarioRegistro) {
		this.nombreUsuarioRegistro = nombreUsuarioRegistro;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<AsistenciaEmergencia> getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(List<AsistenciaEmergencia> asistencias) {
		this.asistencias = asistencias;
	}

	public AsistenciaEmergencia addAsistencia(AsistenciaEmergencia asistencia) {
		getAsistencias().add(asistencia);
		asistencia.setAutorizacionEmergencia(this);

		return asistencia;
	}

	public AsistenciaEmergencia removeAsistencia(AsistenciaEmergencia asistencia) {
		getAsistencias().remove(asistencia);
		asistencia.setAutorizacionEmergencia(null);

		return asistencia;
	}

	public EstadoEmergencia getEstado() {
		return this.estado;
	}

	public void setEstado(EstadoEmergencia estado) {
		this.estado = estado;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(String semaforo) {
		this.semaforo = semaforo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}