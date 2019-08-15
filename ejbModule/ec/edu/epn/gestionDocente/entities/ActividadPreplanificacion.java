package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the actividad_preplanificacion database table.
 * 
 */
@Entity
@Table(name="actividad_preplanificacion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="ActividadPreplanificacion.findAll", query="SELECT a FROM ActividadPreplanificacion a")
public class ActividadPreplanificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_actividad_preplanif")
	private Integer idActividadPreplanif;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_preplanif")
	private Date fechaPreplanif;

	@Column(name="id_tipo_actv")
	private Integer idTipoActv;

	@Column(name="id_usuario_preplanif")
	private Integer idUsuarioPreplanif;

	@Column(name="nombre_actividad")
	private String nombreActividad;

	@Column(name="valor_preplanif")
	private double valorPreplanif;
	
	@ManyToOne
	@JoinColumn(name="id_catalogo_actividad")
	private ReglamentoEvaluacion reglamentoEvaluacion;

	//bi-directional many-to-one association to PreplanificacionDocencia
	@ManyToOne
	@JoinColumn(name="id_preplanif")
	private PreplanificacionDocencia preplanificacionDocencia;

	public ActividadPreplanificacion() {
	}

	public Integer getIdActividadPreplanif() {
		return this.idActividadPreplanif;
	}

	public void setIdActividadPreplanif(Integer idActividadPreplanif) {
		this.idActividadPreplanif = idActividadPreplanif;
	}

	public Date getFechaPreplanif() {
		return this.fechaPreplanif;
	}

	public void setFechaPreplanif(Date fechaPreplanif) {
		this.fechaPreplanif = fechaPreplanif;
	}


	public Integer getIdTipoActv() {
		return this.idTipoActv;
	}

	public void setIdTipoActv(Integer idTipoActv) {
		this.idTipoActv = idTipoActv;
	}

	public Integer getIdUsuarioPreplanif() {
		return this.idUsuarioPreplanif;
	}

	public void setIdUsuarioPreplanif(Integer idUsuarioPreplanif) {
		this.idUsuarioPreplanif = idUsuarioPreplanif;
	}

	public String getNombreActividad() {
		return this.nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public double getValorPreplanif() {
		return this.valorPreplanif;
	}

	public void setValorPreplanif(double valorPreplanif) {
		this.valorPreplanif = valorPreplanif;
	}

	public PreplanificacionDocencia getPreplanificacionDocencia() {
		return this.preplanificacionDocencia;
	}

	public void setPreplanificacionDocencia(PreplanificacionDocencia preplanificacionDocencia) {
		this.preplanificacionDocencia = preplanificacionDocencia;
	}

	public ReglamentoEvaluacion getReglamentoEvaluacion() {
		return reglamentoEvaluacion;
	}

	public void setReglamentoEvaluacion(ReglamentoEvaluacion reglamentoEvaluacion) {
		this.reglamentoEvaluacion = reglamentoEvaluacion;
	}

}