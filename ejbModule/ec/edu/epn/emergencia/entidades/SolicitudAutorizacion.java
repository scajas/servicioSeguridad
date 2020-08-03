package ec.edu.epn.emergencia.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the solicitud database table.
 * 
 */
@Entity
@Table(name="solicitud", catalog = "bddcorpepn", schema = "\"Emergencia\"")
@NamedQuery(name="SolicitudAutorizacion.findAll", query="SELECT s FROM SolicitudAutorizacion s")
public class SolicitudAutorizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_solicitud")
	private Integer idSolicitud;

	@Column(name="dependencia_codigo")
	private String dependenciaCodigo;

	@Column(name="dependencia_destino")
	private String dependenciaDestino;

	@Column(name="dependencia_origen")
	private String dependenciaOrigen;

	@Column(name="email_solicita")
	private String emailSolicita;

	private Integer estado;

	@Column(name="fecha_actualizacion")
	private String fechaActualizacion;

	
	@Column(name="fecha_fin")
	private Date fechaFin;

	
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_solicitud")
	private Date fechaSolicitud;

	@Column(name="fin_de_semana")
	private String finDeSemana;

	private String identificacion;

	@Column(name="identificacion_aprueba")
	private String identificacionAprueba;

	private String motivo;

	@Column(name="motivo_rechazo")
	private String motivoRechazo;

	private String nombre;

	private String observacion;

	@Column(name="observacion_medica")
	private String observacionMedica;

	private String placa;

	private String telefono;

	@Column(name="tipo_persona")
	private String tipoPersona;

	@Column(name="tipo_solicitud")
	private String tipoSolicitud;

	@Column(name="usuario_rechaza")
	private String usuarioRechaza;

	@Column(name="usuario_solicita")
	private String usuarioSolicita;

	//bi-directional many-to-one association to PreguntaRespuesta
	@OneToMany(mappedBy="solicitud", fetch=FetchType.EAGER)
	private List<PreguntaRespuesta> preguntaRespuestas;

	public SolicitudAutorizacion() {
	}

	public Integer getIdSolicitud() {
		return this.idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getDependenciaCodigo() {
		return this.dependenciaCodigo;
	}

	public void setDependenciaCodigo(String dependenciaCodigo) {
		this.dependenciaCodigo = dependenciaCodigo;
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

	public String getEmailSolicita() {
		return this.emailSolicita;
	}

	public void setEmailSolicita(String emailSolicita) {
		this.emailSolicita = emailSolicita;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(String fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getFinDeSemana() {
		return this.finDeSemana;
	}

	public void setFinDeSemana(String finDeSemana) {
		this.finDeSemana = finDeSemana;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getIdentificacionAprueba() {
		return this.identificacionAprueba;
	}

	public void setIdentificacionAprueba(String identificacionAprueba) {
		this.identificacionAprueba = identificacionAprueba;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getMotivoRechazo() {
		return this.motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getObservacionMedica() {
		return this.observacionMedica;
	}

	public void setObservacionMedica(String observacionMedica) {
		this.observacionMedica = observacionMedica;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoPersona() {
		return this.tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getTipoSolicitud() {
		return this.tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public String getUsuarioRechaza() {
		return this.usuarioRechaza;
	}

	public void setUsuarioRechaza(String usuarioRechaza) {
		this.usuarioRechaza = usuarioRechaza;
	}

	public String getUsuarioSolicita() {
		return this.usuarioSolicita;
	}

	public void setUsuarioSolicita(String usuarioSolicita) {
		this.usuarioSolicita = usuarioSolicita;
	}

	public List<PreguntaRespuesta> getPreguntaRespuestas() {
		return this.preguntaRespuestas;
	}

	public void setPreguntaRespuestas(List<PreguntaRespuesta> preguntaRespuestas) {
		this.preguntaRespuestas = preguntaRespuestas;
	}

	public PreguntaRespuesta addPreguntaRespuesta(PreguntaRespuesta preguntaRespuesta) {
		getPreguntaRespuestas().add(preguntaRespuesta);
		preguntaRespuesta.setSolicitud(this);

		return preguntaRespuesta;
	}

	public PreguntaRespuesta removePreguntaRespuesta(PreguntaRespuesta preguntaRespuesta) {
		getPreguntaRespuestas().remove(preguntaRespuesta);
		preguntaRespuesta.setSolicitud(null);

		return preguntaRespuesta;
	}
}