package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the act_plan database table.
 * 
 */
@Entity
@Table(name = "act_plan", catalog = "bddcorpepn", schema = "\"GestionDocente\"")
@NamedQuery(name="ActPlan.findAll", query="SELECT a FROM ActPlan a")
public class ActPlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_activ")
	private Integer idActiv;

	@Column(name="nombre_act")
	private String nombreAct;

	private String tipoactividad;

	//bi-directional many-to-one association to PlanTrabajo
	@ManyToOne
	@JoinColumn(name="id_plan")
	private PlanTrabajo planTrabajo;

	public ActPlan() {
	}

	public Integer getIdActiv() {
		return this.idActiv;
	}

	public void setIdActiv(Integer idActiv) {
		this.idActiv = idActiv;
	}

	public String getNombreAct() {
		return this.nombreAct;
	}

	public void setNombreAct(String nombreAct) {
		this.nombreAct = nombreAct;
	}

	public String getTipoactividad() {
		return this.tipoactividad;
	}

	public void setTipoactividad(String tipoactividad) {
		this.tipoactividad = tipoactividad;
	}

	public PlanTrabajo getPlanTrabajo() {
		return this.planTrabajo;
	}

	public void setPlanTrabajo(PlanTrabajo planTrabajo) {
		this.planTrabajo = planTrabajo;
	}

}