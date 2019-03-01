package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the recorrido_evaluacion database table.
 * 
 */
@Entity
@Table(name="recorrido_evaluacion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="RecorridoEvaluacion.findAll", query="SELECT r FROM RecorridoEvaluacion r")
public class RecorridoEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"GestionDocente\".sec_recorrido_eval")
	@SequenceGenerator(name = "\"GestionDocente\".sec_recorrido_eval", sequenceName = "\"GestionDocente\".sec_recorrido_eval", allocationSize = 1)
	@Column(name="id_recorrido_eval")
	private Integer idRecorridoEval;

	@Column(name="enviado_por")
	private Integer enviadoPor;

	@Column(name="estado_actual")
	private String estadoActual;

	@Column(name="estado_anterior")
	private String estadoAnterior;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_envio")
	private Date fechaEnvio;

	@Column(name="id_eval_acad")
	private Integer idEvalAcad;

	private String observacion;

	public RecorridoEvaluacion() {
	}

	public Integer getIdRecorridoEval() {
		return this.idRecorridoEval;
	}

	public void setIdRecorridoEval(Integer idRecorridoEval) {
		this.idRecorridoEval = idRecorridoEval;
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

	public Date getFechaEnvio() {
		return this.fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Integer getIdEvalAcad() {
		return this.idEvalAcad;
	}

	public void setIdEvalAcad(Integer idEvalAcad) {
		this.idEvalAcad = idEvalAcad;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}