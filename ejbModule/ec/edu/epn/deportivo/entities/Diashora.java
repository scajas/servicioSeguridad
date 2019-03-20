package ec.edu.epn.deportivo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the diashora database table.
 * 
 */
@Entity
@Table(name="diashora", catalog="`bddcorpepn`", schema="`Deportivo`")
@NamedQuery(name="Diashora.findAll", query="SELECT d FROM Diashora d")
public class Diashora implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DiashoraPK id;

	@Column(name="activo_diashora")
	private String activoDiashora;

	//bi-directional many-to-one association to DiasPlanificacion
	@ManyToOne
	@JoinColumn(name="id_diaplanificacion", insertable = false, updatable = false)
	private DiasPlanificacion diasPlanificacion;

	//bi-directional many-to-one association to HoraPlanificacion
	@ManyToOne
	@JoinColumn(name="id_horaplanificacion", insertable = false, updatable = false)
	private HoraPlanificacion horaPlanificacion;

	//bi-directional many-to-one association to Planificacion
	@OneToMany(mappedBy="diashora")
	private List<Planificacion> planificacions;

	public Diashora() {
	}

	public DiashoraPK getId() {
		return this.id;
	}

	public void setId(DiashoraPK id) {
		this.id = id;
	}

	public String getActivoDiashora() {
		return this.activoDiashora;
	}

	public void setActivoDiashora(String activoDiashora) {
		this.activoDiashora = activoDiashora;
	}

	public DiasPlanificacion getDiasPlanificacion() {
		return this.diasPlanificacion;
	}

	public void setDiasPlanificacion(DiasPlanificacion diasPlanificacion) {
		this.diasPlanificacion = diasPlanificacion;
	}

	public HoraPlanificacion getHoraPlanificacion() {
		return this.horaPlanificacion;
	}

	public void setHoraPlanificacion(HoraPlanificacion horaPlanificacion) {
		this.horaPlanificacion = horaPlanificacion;
	}

	public List<Planificacion> getPlanificacions() {
		return this.planificacions;
	}

	public void setPlanificacions(List<Planificacion> planificacions) {
		this.planificacions = planificacions;
	}

	public Planificacion addPlanificacion(Planificacion planificacion) {
		getPlanificacions().add(planificacion);
		planificacion.setDiashora(this);

		return planificacion;
	}

	public Planificacion removePlanificacion(Planificacion planificacion) {
		getPlanificacions().remove(planificacion);
		planificacion.setDiashora(null);

		return planificacion;
	}

}