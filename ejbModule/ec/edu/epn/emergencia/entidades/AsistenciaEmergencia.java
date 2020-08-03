package ec.edu.epn.emergencia.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the asistencia database table.
 * 
 */
@Entity
@Table(name = "asistencia", catalog = "bddcorpepn", schema = "\"Emergencia\"")
@NamedQuery(name = "AsistenciaEmergencia.findAll", query = "SELECT a FROM AsistenciaEmergencia a")
public class AsistenciaEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "id_asistencia")
	private Integer idAsistencia;
	
	@Column(name = "fecha_ingreso")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaIngreso;
	
	@Column(name = "temperatura")
	private Double temperatura;
	
	@Column(name = "fecha_salida")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaSalida;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	@Column(name = "q1")
	private Boolean q1;
	
	@Column(name = "q2")
	private Boolean q2;
	
	@Column(name = "q3")
	private Boolean q3;
	
	@JoinColumn(name = "id_autorizacion", referencedColumnName = "id_autorizacion")
	@ManyToOne
	private AutorizacionEmergencia autorizacion;
	
	@JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
	@ManyToOne
	private EstadoEmergencia estado;
	
	@JoinColumn(name = "id_guardia", referencedColumnName = "id_guardia")
	@ManyToOne
	private Guardia guardia;
	
	
	public Integer getIdAsistencia() {
		return idAsistencia;
	}
	public void setIdAsistencia(Integer idAsistencia) {
		this.idAsistencia = idAsistencia;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Boolean getQ1() {
		return q1;
	}
	public void setQ1(Boolean q1) {
		this.q1 = q1;
	}
	public Boolean getQ2() {
		return q2;
	}
	public void setQ2(Boolean q2) {
		this.q2 = q2;
	}
	public Boolean getQ3() {
		return q3;
	}
	public void setQ3(Boolean q3) {
		this.q3 = q3;
	}
	public AutorizacionEmergencia getIdAutorizacion() {
		return autorizacion;
	}
	public void setAutorizacionEmergencia(AutorizacionEmergencia idAutorizacion) {
		this.autorizacion = idAutorizacion;
	}
	public EstadoEmergencia getIdEstado() {
		return estado;
	}
	public void setEstado(EstadoEmergencia idEstado) {
		this.estado = idEstado;
	}
	public Guardia getIdGuardia() {
		return guardia;
	}
	public void setGuardia(Guardia idGuardia) {
		this.guardia = idGuardia;
	}
	
	
}