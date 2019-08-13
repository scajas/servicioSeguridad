package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the recorrido_preplanificacion database table.
 * 
 */
@Entity
@Table(name="recorrido_preplanificacion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="RecorridoPreplanificacion.findAll", query="SELECT r FROM RecorridoPreplanificacion r")
public class RecorridoPreplanificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_recorrido_preplanif")
	private Integer idRecorridoPreplanif;
	

	@Column(name="direccion_ip")
	private String direccionIp;

	@Column(name="direccion_mac")
	private String direccionMac;

	@Column(name="enviado_por")
	private Integer enviadoPor;

	@Column(name="estado_actual")
	private String estadoActual;

	@Column(name="estado_anterior")
	private String estadoAnterior;

	@Column(name="fecha_envio")
	private Timestamp fechaEnvio;

	

	private String observacion;

	//bi-directional one-to-one association to PreplanificacionDocencia
	@OneToOne
	@JoinColumn(name="id_preplanif")
	private PreplanificacionDocencia preplanificacionDocencia;

	public RecorridoPreplanificacion() {
	}

	

	public String getDireccionIp() {
		return this.direccionIp;
	}

	public void setDireccionIp(String direccionIp) {
		this.direccionIp = direccionIp;
	}

	public String getDireccionMac() {
		return this.direccionMac;
	}

	public void setDireccionMac(String direccionMac) {
		this.direccionMac = direccionMac;
	}

	public Integer getEnviadoPor() {
		return this.enviadoPor;
	}

	public void setEnviadoPor(Integer enviadoPor) {
		this.enviadoPor = enviadoPor;
	}

	public String getEstadoActual() {
		return this.estadoActual;
	}

	public void setEstadoActual(String estadoActual) {
		this.estadoActual = estadoActual;
	}

	public String getEstadoAnterior() {
		return this.estadoAnterior;
	}

	public void setEstadoAnterior(String estadoAnterior) {
		this.estadoAnterior = estadoAnterior;
	}

	public Timestamp getFechaEnvio() {
		return this.fechaEnvio;
	}

	public void setFechaEnvio(Timestamp fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Integer getIdRecorridoPreplanif() {
		return this.idRecorridoPreplanif;
	}

	public void setIdRecorridoPreplanif(Integer idRecorridoPreplanif) {
		this.idRecorridoPreplanif = idRecorridoPreplanif;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public PreplanificacionDocencia getPreplanificacionDocencia() {
		return this.preplanificacionDocencia;
	}

	public void setPreplanificacionDocencia(PreplanificacionDocencia preplanificacionDocencia) {
		this.preplanificacionDocencia = preplanificacionDocencia;
	}

}