package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the periodo database table.
 * 
 */
@Entity
@Table(name = "periodo", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name = "Periodo.findAll", query = "SELECT p FROM Periodo p order by p.idPeriodo desc")
public class Periodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name = "id_periodo")
	private String idPeriodo;

	private String mostrar;

	private String periodo;

	@Column(name = "id_pensum")
	private Integer idPensum;

	// bi-directional many-to-one association to ActividadAdministrativa
	@OneToMany(mappedBy = "periodo")
	private List<Capacitacion> capacitacion;
	// bi-directional many-to-one association to ActividadAdministrativa
	@OneToMany(mappedBy = "periodo")
	private List<ActividadAdministrativa> actividadAdministrativas;

	// bi-directional many-to-one association to ActividadDocencia
	@OneToMany(mappedBy = "periodo")
	private List<ActividadDocencia> actividadDocencias;

	// bi-directional many-to-one association to ActividadExtension
	@OneToMany(mappedBy = "periodo")
	private List<ActividadExtension> actividadExtensions;

	// bi-directional many-to-one association to ActividadProyecto
	@OneToMany(mappedBy = "periodo")
	private List<ActividadProyecto> actividadProyectos;

	// bi-directional many-to-one association to ActividadProyectotraspaso
	@OneToMany(mappedBy = "periodo")
	private List<ActividadProyectotraspaso> actividadProyectotraspasos;

	// bi-directional many-to-one association to ActividadTecnica
	@OneToMany(mappedBy = "periodo")
	private List<ActividadTecnica> actividadTecnicas;

	// bi-directional many-to-one association to InformeSemestral
	@OneToMany(mappedBy = "periodo")
	private List<InformeSemestral> informeSemestrals;

	// bi-directional many-to-one association to PlanifDocente
	@OneToMany(mappedBy = "periodo")
	private List<PlanifDocente> planifDocentes;

	// bi-directional many-to-one association to PlanifDocente
	@OneToMany(mappedBy = "periodo")
	private List<TesisDirigida> tesisDirigidas;

	public Periodo() {
	}

	public String getIdPeriodo() {
		return this.idPeriodo;
	}

	public void setIdPeriodo(String idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getMostrar() {
		return this.mostrar;
	}

	public void setMostrar(String mostrar) {
		this.mostrar = mostrar;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public List<ActividadAdministrativa> getActividadAdministrativas() {
		return this.actividadAdministrativas;
	}

	public void setActividadAdministrativas(List<ActividadAdministrativa> actividadAdministrativas) {
		this.actividadAdministrativas = actividadAdministrativas;
	}

	public ActividadAdministrativa addActividadAdministrativa(ActividadAdministrativa actividadAdministrativa) {
		getActividadAdministrativas().add(actividadAdministrativa);
		actividadAdministrativa.setPeriodo(this);

		return actividadAdministrativa;
	}

	public ActividadAdministrativa removeActividadAdministrativa(ActividadAdministrativa actividadAdministrativa) {
		getActividadAdministrativas().remove(actividadAdministrativa);
		actividadAdministrativa.setPeriodo(null);

		return actividadAdministrativa;
	}

	public List<ActividadDocencia> getActividadDocencias() {
		return this.actividadDocencias;
	}

	public void setActividadDocencias(List<ActividadDocencia> actividadDocencias) {
		this.actividadDocencias = actividadDocencias;
	}

	public ActividadDocencia addActividadDocencia(ActividadDocencia actividadDocencia) {
		getActividadDocencias().add(actividadDocencia);
		actividadDocencia.setPeriodo(this);

		return actividadDocencia;
	}

	public ActividadDocencia removeActividadDocencia(ActividadDocencia actividadDocencia) {
		getActividadDocencias().remove(actividadDocencia);
		actividadDocencia.setPeriodo(null);

		return actividadDocencia;
	}

	public List<ActividadExtension> getActividadExtensions() {
		return this.actividadExtensions;
	}

	public void setActividadExtensions(List<ActividadExtension> actividadExtensions) {
		this.actividadExtensions = actividadExtensions;
	}

	public ActividadExtension addActividadExtension(ActividadExtension actividadExtension) {
		getActividadExtensions().add(actividadExtension);
		actividadExtension.setPeriodo(this);

		return actividadExtension;
	}

	public ActividadExtension removeActividadExtension(ActividadExtension actividadExtension) {
		getActividadExtensions().remove(actividadExtension);
		actividadExtension.setPeriodo(null);

		return actividadExtension;
	}

	public List<ActividadProyecto> getActividadProyectos() {
		return this.actividadProyectos;
	}

	public void setActividadProyectos(List<ActividadProyecto> actividadProyectos) {
		this.actividadProyectos = actividadProyectos;
	}

	public ActividadProyecto addActividadProyecto(ActividadProyecto actividadProyecto) {
		getActividadProyectos().add(actividadProyecto);
		actividadProyecto.setPeriodo(this);

		return actividadProyecto;
	}

	public ActividadProyecto removeActividadProyecto(ActividadProyecto actividadProyecto) {
		getActividadProyectos().remove(actividadProyecto);
		actividadProyecto.setPeriodo(null);

		return actividadProyecto;
	}

	public List<ActividadProyectotraspaso> getActividadProyectotraspasos() {
		return this.actividadProyectotraspasos;
	}

	public void setActividadProyectotraspasos(List<ActividadProyectotraspaso> actividadProyectotraspasos) {
		this.actividadProyectotraspasos = actividadProyectotraspasos;
	}

	public ActividadProyectotraspaso addActividadProyectotraspaso(ActividadProyectotraspaso actividadProyectotraspaso) {
		getActividadProyectotraspasos().add(actividadProyectotraspaso);
		actividadProyectotraspaso.setPeriodo(this);

		return actividadProyectotraspaso;
	}

	public ActividadProyectotraspaso removeActividadProyectotraspaso(
			ActividadProyectotraspaso actividadProyectotraspaso) {
		getActividadProyectotraspasos().remove(actividadProyectotraspaso);
		actividadProyectotraspaso.setPeriodo(null);

		return actividadProyectotraspaso;
	}

	public List<ActividadTecnica> getActividadTecnicas() {
		return this.actividadTecnicas;
	}

	public void setActividadTecnicas(List<ActividadTecnica> actividadTecnicas) {
		this.actividadTecnicas = actividadTecnicas;
	}

	public ActividadTecnica addActividadTecnica(ActividadTecnica actividadTecnica) {
		getActividadTecnicas().add(actividadTecnica);
		actividadTecnica.setPeriodo(this);

		return actividadTecnica;
	}

	public ActividadTecnica removeActividadTecnica(ActividadTecnica actividadTecnica) {
		getActividadTecnicas().remove(actividadTecnica);
		actividadTecnica.setPeriodo(null);

		return actividadTecnica;
	}

	public List<InformeSemestral> getInformeSemestrals() {
		return this.informeSemestrals;
	}

	public void setInformeSemestrals(List<InformeSemestral> informeSemestrals) {
		this.informeSemestrals = informeSemestrals;
	}

	public InformeSemestral addInformeSemestral(InformeSemestral informeSemestral) {
		getInformeSemestrals().add(informeSemestral);
		informeSemestral.setPeriodo(this);

		return informeSemestral;
	}

	public InformeSemestral removeInformeSemestral(InformeSemestral informeSemestral) {
		getInformeSemestrals().remove(informeSemestral);
		informeSemestral.setPeriodo(null);

		return informeSemestral;
	}

	public List<PlanifDocente> getPlanifDocentes() {
		return this.planifDocentes;
	}

	public void setPlanifDocentes(List<PlanifDocente> planifDocentes) {
		this.planifDocentes = planifDocentes;
	}

	public PlanifDocente addPlanifDocente(PlanifDocente planifDocente) {
		getPlanifDocentes().add(planifDocente);
		planifDocente.setPeriodo(this);

		return planifDocente;
	}

	public PlanifDocente removePlanifDocente(PlanifDocente planifDocente) {
		getPlanifDocentes().remove(planifDocente);
		planifDocente.setPeriodo(null);

		return planifDocente;
	}

	public List<Capacitacion> getCapacitacion() {
		return capacitacion;
	}

	public void setCapacitacion(List<Capacitacion> capacitacion) {
		this.capacitacion = capacitacion;
	}

	public List<TesisDirigida> getTesisDirigidas() {
		return tesisDirigidas;
	}

	public void setTesisDirigidas(List<TesisDirigida> tesisDirigidas) {
		this.tesisDirigidas = tesisDirigidas;
	}

	/**
	 * @return the idPensum
	 */
	public Integer getIdPensum() {
		return idPensum;
	}

	/**
	 * @param idPensum
	 *            the idPensum to set
	 */
	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

}