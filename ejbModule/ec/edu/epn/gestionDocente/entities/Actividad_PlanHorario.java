package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Actividad_PlanHorario" database table.
 * 
 */
@Entity
@Table(name = "\"Actividad_PlanHorario\"", catalog = "bddcorpepn", schema = "\"GestionDocente\"")
@NamedQuery(name="Actividad_PlanHorario.findAll", query="SELECT a FROM Actividad_PlanHorario a")
public class Actividad_PlanHorario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_actividad_planhorario")
	private Integer idActividadPlanhorario;

	@Column(name="fechafinal_planhorario")
	private String fechafinalPlanhorario;

	@Column(name="fechainicial_planhorario")
	private String fechainicialPlanhorario;

	@Column(name="horario_planhorario")
	private String horarioPlanhorario;

	@Column(name="jueves_planhorario")
	private String juevesPlanhorario;

	@Column(name="lunes_planhorario")
	private String lunesPlanhorario;

	@Column(name="martes_planhorario")
	private String martesPlanhorario;

	@Column(name="miercoles_planhorario")
	private String miercolesPlanhorario;

	@Column(name="sabado_planhorario")
	private String sabadoPlanhorario;

	@Column(name="viernes_planhorario")
	private String viernesPlanhorario;

	//bi-directional many-to-one association to PlanTrabajo
	@ManyToOne
	@JoinColumn(name="id_plantrabajo")
	private PlanTrabajo planTrabajo;

	public Actividad_PlanHorario() {
	}

	public Integer getIdActividadPlanhorario() {
		return this.idActividadPlanhorario;
	}

	public void setIdActividadPlanhorario(Integer idActividadPlanhorario) {
		this.idActividadPlanhorario = idActividadPlanhorario;
	}

	public String getFechafinalPlanhorario() {
		return this.fechafinalPlanhorario;
	}

	public void setFechafinalPlanhorario(String fechafinalPlanhorario) {
		this.fechafinalPlanhorario = fechafinalPlanhorario;
	}

	public String getFechainicialPlanhorario() {
		return this.fechainicialPlanhorario;
	}

	public void setFechainicialPlanhorario(String fechainicialPlanhorario) {
		this.fechainicialPlanhorario = fechainicialPlanhorario;
	}

	public String getHorarioPlanhorario() {
		return this.horarioPlanhorario;
	}

	public void setHorarioPlanhorario(String horarioPlanhorario) {
		this.horarioPlanhorario = horarioPlanhorario;
	}

	public String getJuevesPlanhorario() {
		return this.juevesPlanhorario;
	}

	public void setJuevesPlanhorario(String juevesPlanhorario) {
		this.juevesPlanhorario = juevesPlanhorario;
	}

	public String getLunesPlanhorario() {
		return this.lunesPlanhorario;
	}

	public void setLunesPlanhorario(String lunesPlanhorario) {
		this.lunesPlanhorario = lunesPlanhorario;
	}

	public String getMartesPlanhorario() {
		return this.martesPlanhorario;
	}

	public void setMartesPlanhorario(String martesPlanhorario) {
		this.martesPlanhorario = martesPlanhorario;
	}

	public String getMiercolesPlanhorario() {
		return this.miercolesPlanhorario;
	}

	public void setMiercolesPlanhorario(String miercolesPlanhorario) {
		this.miercolesPlanhorario = miercolesPlanhorario;
	}

	public String getSabadoPlanhorario() {
		return this.sabadoPlanhorario;
	}

	public void setSabadoPlanhorario(String sabadoPlanhorario) {
		this.sabadoPlanhorario = sabadoPlanhorario;
	}

	public String getViernesPlanhorario() {
		return this.viernesPlanhorario;
	}

	public void setViernesPlanhorario(String viernesPlanhorario) {
		this.viernesPlanhorario = viernesPlanhorario;
	}

	public PlanTrabajo getPlanTrabajo() {
		return this.planTrabajo;
	}

	public void setPlanTrabajo(PlanTrabajo planTrabajo) {
		this.planTrabajo = planTrabajo;
	}

}