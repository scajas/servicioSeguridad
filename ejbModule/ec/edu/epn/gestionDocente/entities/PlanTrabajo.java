package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.contratos.entities.Pensum;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the plan_trabajo database table.
 * 
 */
@Entity
@Table(name = "plan_trabajo", catalog = "bddcorpepn", schema = "\"GestionDocente\"")
@NamedQuery(name="PlanTrabajo.findAll", query="SELECT p FROM PlanTrabajo p")
public class PlanTrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_plan")
	private Integer idPlan;

	@Column(name="apellido_docente")
	private String apellidoDocente;

	private String cargo;

	@Column(name="cargo_con")
	private String cargoCon;

	@Column(name="dedica_tc")
	private String dedicaTc;

	@Column(name="empresa_propia")
	private String empresaPropia;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_con")
	private Date fechaCon;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_envio")
	private Date fechaEnvio;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingepn")
	private Date fechaIngepn;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Column(name="horassemana_ou")
	private Integer horassemanaOu;

	/*@Column(name="id_pensum")
	private Integer idPensum;*/
	@ManyToOne
	@JoinColumn(name = "id_pensum")
	private Pensum pensum;

	public Pensum getPensum() {
		return pensum;
	}

	public void setPensum(Pensum pensum) {
		this.pensum = pensum;
	}

	@Column(name="instru_academia")
	private String instruAcademia;

	@Column(name="instru_seminario")
	private String instruSeminario;

	private String nced;

	@Column(name="nombre_docente")
	private String nombreDocente;

	@Column(name="nombre_empresa")
	private String nombreEmpresa;

	@Column(name="nombre_ou")
	private String nombreOu;

	private String observaciones;

	@Column(name="tipo_empresa")
	private String tipoEmpresa;

	@Column(name="trabaja_ou")
	private String trabajaOu;

	//bi-directional many-to-one association to Actividad_PlanHorario
	@OneToMany(mappedBy="planTrabajo")
	private List<Actividad_PlanHorario> actividadPlanHorarios;

	//bi-directional many-to-one association to ActPlan
	@OneToMany(mappedBy="planTrabajo")
	private List<ActPlan> actPlans;

	public PlanTrabajo() {
	}

	public Integer getIdPlan() {
		return this.idPlan;
	}

	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}

	public String getApellidoDocente() {
		return this.apellidoDocente;
	}

	public void setApellidoDocente(String apellidoDocente) {
		this.apellidoDocente = apellidoDocente;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCargoCon() {
		return this.cargoCon;
	}

	public void setCargoCon(String cargoCon) {
		this.cargoCon = cargoCon;
	}

	public String getDedicaTc() {
		return this.dedicaTc;
	}

	public void setDedicaTc(String dedicaTc) {
		this.dedicaTc = dedicaTc;
	}

	public String getEmpresaPropia() {
		return this.empresaPropia;
	}

	public void setEmpresaPropia(String empresaPropia) {
		this.empresaPropia = empresaPropia;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCon() {
		return this.fechaCon;
	}

	public void setFechaCon(Date fechaCon) {
		this.fechaCon = fechaCon;
	}

	public Date getFechaEnvio() {
		return this.fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Date getFechaIngepn() {
		return this.fechaIngepn;
	}

	public void setFechaIngepn(Date fechaIngepn) {
		this.fechaIngepn = fechaIngepn;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getHorassemanaOu() {
		return this.horassemanaOu;
	}

	public void setHorassemanaOu(Integer horassemanaOu) {
		this.horassemanaOu = horassemanaOu;
	}

	/*public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}*/

	public String getInstruAcademia() {
		return this.instruAcademia;
	}

	public void setInstruAcademia(String instruAcademia) {
		this.instruAcademia = instruAcademia;
	}

	public String getInstruSeminario() {
		return this.instruSeminario;
	}

	public void setInstruSeminario(String instruSeminario) {
		this.instruSeminario = instruSeminario;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombreDocente() {
		return this.nombreDocente;
	}

	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getNombreOu() {
		return this.nombreOu;
	}

	public void setNombreOu(String nombreOu) {
		this.nombreOu = nombreOu;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getTipoEmpresa() {
		return this.tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public String getTrabajaOu() {
		return this.trabajaOu;
	}

	public void setTrabajaOu(String trabajaOu) {
		this.trabajaOu = trabajaOu;
	}

	public List<Actividad_PlanHorario> getActividadPlanHorarios() {
		return this.actividadPlanHorarios;
	}

	public void setActividadPlanHorarios(List<Actividad_PlanHorario> actividadPlanHorarios) {
		this.actividadPlanHorarios = actividadPlanHorarios;
	}

	public Actividad_PlanHorario addActividadPlanHorario(Actividad_PlanHorario actividadPlanHorario) {
		getActividadPlanHorarios().add(actividadPlanHorario);
		actividadPlanHorario.setPlanTrabajo(this);

		return actividadPlanHorario;
	}

	public Actividad_PlanHorario removeActividadPlanHorario(Actividad_PlanHorario actividadPlanHorario) {
		getActividadPlanHorarios().remove(actividadPlanHorario);
		actividadPlanHorario.setPlanTrabajo(null);

		return actividadPlanHorario;
	}

	public List<ActPlan> getActPlans() {
		return this.actPlans;
	}

	public void setActPlans(List<ActPlan> actPlans) {
		this.actPlans = actPlans;
	}

	public ActPlan addActPlan(ActPlan actPlan) {
		getActPlans().add(actPlan);
		actPlan.setPlanTrabajo(this);

		return actPlan;
	}

	public ActPlan removeActPlan(ActPlan actPlan) {
		getActPlans().remove(actPlan);
		actPlan.setPlanTrabajo(null);

		return actPlan;
	}

}