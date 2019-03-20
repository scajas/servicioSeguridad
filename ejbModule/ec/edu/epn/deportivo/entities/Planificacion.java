package ec.edu.epn.deportivo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the planificacion database table.
 * 
 */
@Entity
@Table(name="planificacion", catalog="`bddcorpepn`", schema="`Deportivo`")
@NamedQuery(name="Planificacion.findAll", query="SELECT p FROM Planificacion p")
public class Planificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_planificacion")
	private Integer idPlanificacion;

	@Column(name="activo_planificacion")
	private String activoPlanificacion;

	@Column(name="cupo_planificacion")
	private Integer cupoPlanificacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_planificacion")
	private Date fechaPlanificacion;

	@Column(name="periodo_planificacion")
	private Integer periodoPlanificacion;

	//bi-directional many-to-one association to Deporte
	@ManyToOne
	@JoinColumn(name="id_deporte")
	private Deporte deporte;

	//bi-directional many-to-one association to Diashora
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_diaplanificacion", referencedColumnName="id_diaplanificacion"),
		@JoinColumn(name="id_horaplanificacion", referencedColumnName="id_horaplanificacion")
		})
	private Diashora diashora;

	//bi-directional many-to-many association to Estudiante
	@ManyToMany
	@JoinTable(
		name="grupoestudiante"
		, joinColumns={
			@JoinColumn(name="id_planificacion")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_estudiantes")
			}
		)
	private List<Estudiante> estudiantes;

	public Planificacion() {
	}

	public Integer getIdPlanificacion() {
		return this.idPlanificacion;
	}

	public void setIdPlanificacion(Integer idPlanificacion) {
		this.idPlanificacion = idPlanificacion;
	}

	public String getActivoPlanificacion() {
		return this.activoPlanificacion;
	}

	public void setActivoPlanificacion(String activoPlanificacion) {
		this.activoPlanificacion = activoPlanificacion;
	}

	public Integer getCupoPlanificacion() {
		return this.cupoPlanificacion;
	}

	public void setCupoPlanificacion(Integer cupoPlanificacion) {
		this.cupoPlanificacion = cupoPlanificacion;
	}

	public Date getFechaPlanificacion() {
		return this.fechaPlanificacion;
	}

	public void setFechaPlanificacion(Date fechaPlanificacion) {
		this.fechaPlanificacion = fechaPlanificacion;
	}

	public Integer getPeriodoPlanificacion() {
		return this.periodoPlanificacion;
	}

	public void setPeriodoPlanificacion(Integer periodoPlanificacion) {
		this.periodoPlanificacion = periodoPlanificacion;
	}

	public Deporte getDeporte() {
		return this.deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public Diashora getDiashora() {
		return this.diashora;
	}

	public void setDiashora(Diashora diashora) {
		this.diashora = diashora;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

}