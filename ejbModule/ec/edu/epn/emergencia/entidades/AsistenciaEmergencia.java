package ec.edu.epn.emergencia.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the asistencia database table.
 * 
 */
@Entity
@Table(name = "asistencia", catalog = "bddcorpepn", schema = "\"Emergencia\"")
@NamedQuery(name="AsistenciaEmergencia.findAll", query="SELECT a FROM AsistenciaEmergencia a")
public class AsistenciaEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_asistencia")
	private Integer idAsistencia;

	@Column(name="fecha_ingreso")
	private Timestamp fechaIngreso;

	@Column(name="fecha_salida")
	private Timestamp fechaSalida;

	private Integer temperatura;

	//bi-directional many-to-one association to Autorizacion
	@ManyToOne
	@JoinColumn(name="id_autorizacion")
	private AutorizacionEmergencia autorizacion;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private EstadoEmergencia estado;

	//bi-directional many-to-one association to Guardia
	@ManyToOne
	@JoinColumn(name="id_guardia")
	private Guardia guardia;

	public AsistenciaEmergencia() {
	}

	public Integer getIdAsistencia() {
		return this.idAsistencia;
	}

	public void setIdAsistencia(Integer idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public Timestamp getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Timestamp getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Integer getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}

	public AutorizacionEmergencia getAutorizacionEmergencia() {
		return this.autorizacion;
	}

	public void setAutorizacionEmergencia(AutorizacionEmergencia autorizacion) {
		this.autorizacion = autorizacion;
	}

	public EstadoEmergencia getEstado() {
		return this.estado;
	}

	public void setEstado(EstadoEmergencia estado) {
		this.estado = estado;
	}

	public Guardia getGuardia() {
		return this.guardia;
	}

	public void setGuardia(Guardia guardia) {
		this.guardia = guardia;
	}

}