package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the equiposcalibracionequipo database table.
 * 
 */
@Entity
@Table(name = "equiposcalibracionequipo", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "Equiposcalibracionequipo.findAll", query = "SELECT e FROM Equiposcalibracionequipo e")
public class Equiposcalibracionequipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_equipo")
	private Integer idEquipo;

	@Column(name = "codbienes_equipo")
	private String codbienesEquipo;

	@Column(name = "costosiniva_equipo")
	private BigDecimal costosinivaEquipo;

	@Column(name = "custorio_equipo")
	private String custorioEquipo;

	@Column(name = "fabricante_equipo")
	private String fabricanteEquipo;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_adquisicion_equipo")
	private Date fechaAdquisicionEquipo;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_reposicion_equipo")
	private Date fechaReposicionEquipo;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechagarantei_equipo")
	private Date fechagaranteiEquipo;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechagarantiaf_equipo")
	private Date fechagarantiafEquipo;

	@Column(name = "frecuenciauso_equipo")
	private Integer frecuenciausoEquipo;

	@Column(name = "localizacionenlab_equipo")
	private String localizacionenlabEquipo;

	@Column(name = "marca_equipo")
	private String marcaEquipo;

	@Column(name = "modelo_equipo")
	private String modeloEquipo;

	@Column(name = "nombre_equipo")
	private String nombreEquipo;

	@Column(name = "nroserie_equipo")
	private String nroserieEquipo;

	@Column(name = "observaciones_equipo")
	private String observacionesEquipo;

	@Column(name = "tiempovidautil_equipo")
	private Integer tiempovidautilEquipo;

	@Column(name = "vidautil_equipo")
	private Integer vidautilEquipo;

	@Column(name = "foto_equipo")
	private byte[] fotoEquipo;

	// bi-directional many-to-one association to Caracteristicastecnica
	@OneToMany(mappedBy = "equiposcalibracionequipo")
	private List<Caracteristicastecnica> caracteristicastecnicas;

	// bi-directional many-to-one association to Condicionesespecialesuso
	@OneToMany(mappedBy = "equiposcalibracionequipo")
	private List<Condicionesespecialesuso> condicionesespecialesusos;

	// bi-directional many-to-one association to Documentacionasociada
	@OneToMany(mappedBy = "equiposcalibracionequipo")
	private List<Documentacionasociada> documentacionasociadas;

	// bi-directional many-to-many association to Accesorio
	/*@ManyToMany
	@JoinTable(name = "eqacces", joinColumns = { @JoinColumn(name = "id_equipo") }, inverseJoinColumns = {
			@JoinColumn(name = "id_accesorio") })
	private List<Accesorio> accesorios;*/
	@OneToMany(mappedBy = "equiposcalibracionequipo")
	private List<Accesorio> accesorios;

	// bi-directional many-to-many association to Personalcalificado
	//@ManyToMany(mappedBy = "equiposcalibracionequipos")
	//private List<Personalcalificado> personalcalificados;
	
	@OneToMany(mappedBy = "equipo")
	private List<EqPerCalf> eqpercalf;

	public List<EqPerCalf> getEqpercalf() {
		return eqpercalf;
	}

	public void setEqpercalf(List<EqPerCalf> eqpercalf) {
		this.eqpercalf = eqpercalf;
	}

	// bi-directional many-to-one association to Clasificacion
	@ManyToOne
	@JoinColumn(name = "id_clasificacion")
	private Clasificacion clasificacion;

	// bi-directional many-to-one association to Estadoequipo
	@ManyToOne
	@JoinColumn(name = "id_estadoequipo")
	private Estadoequipo estadoequipo;

	// bi-directional many-to-one association to Laboratorioscalibracionequipo
	@ManyToOne
	@JoinColumn(name = "id_laboratorio")
	private Laboratorioscalibracionequipo laboratorioscalibracionequipo;

	// bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;

	// bi-directional many-to-one association to Rangofuncionamiento
	@ManyToOne
	@JoinColumn(name = "id_rangofunc")
	private Rangofuncionamiento rangofuncionamiento;

	// bi-directional many-to-one association to Responsable
	@ManyToOne
	@JoinColumn(name = "id_responsable")
	private Responsable responsable;

	// bi-directional many-to-one association to Tipoadquisicion
	@ManyToOne
	@JoinColumn(name = "id_tipoadquisicion")
	private Tipoadquisicion tipoadquisicion;

	// bi-directional many-to-one association to Funcionesequipo
	@OneToMany(mappedBy = "equiposcalibracionequipo")
	private List<Funcionesequipo> funcionesequipos;

	// bi-directional many-to-one association to Gestioncompra
	@OneToMany(mappedBy = "equiposcalibracionequipo")
	private List<Gestioncompra> gestioncompras;

	// bi-directional many-to-one association to Incidentesasociado
	@OneToMany(mappedBy = "equiposcalibracionequipo")
	private List<Incidentesasociado> incidentesasociados;

	// bi-directional many-to-one association to Medidaspreventiva
	@OneToMany(mappedBy = "equiposcalibracionequipo")
	private List<Medidaspreventiva> medidaspreventivas;

	// bi-directional many-to-one association to Plan
	@OneToMany(mappedBy = "equiposcalibracionequipo")
	private List<Plan> plans;

	// bi-directional many-to-one association to Riesgosasociado
	@OneToMany(mappedBy = "equiposcalibracionequipo")
	private List<Riesgosasociado> riesgosasociados;

	public Equiposcalibracionequipo() {
	}

	public Integer getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getCodbienesEquipo() {
		return this.codbienesEquipo;
	}

	public void setCodbienesEquipo(String codbienesEquipo) {
		this.codbienesEquipo = codbienesEquipo;
	}

	public BigDecimal getCostosinivaEquipo() {
		return this.costosinivaEquipo;
	}

	public void setCostosinivaEquipo(BigDecimal costosinivaEquipo) {
		this.costosinivaEquipo = costosinivaEquipo;
	}

	public String getCustorioEquipo() {
		return this.custorioEquipo;
	}

	public void setCustorioEquipo(String custorioEquipo) {
		this.custorioEquipo = custorioEquipo;
	}

	public String getFabricanteEquipo() {
		return this.fabricanteEquipo;
	}

	public void setFabricanteEquipo(String fabricanteEquipo) {
		this.fabricanteEquipo = fabricanteEquipo;
	}

	public Date getFechaAdquisicionEquipo() {
		return this.fechaAdquisicionEquipo;
	}

	public void setFechaAdquisicionEquipo(Date fechaAdquisicionEquipo) {
		this.fechaAdquisicionEquipo = fechaAdquisicionEquipo;
	}

	public Date getFechaReposicionEquipo() {
		return this.fechaReposicionEquipo;
	}

	public void setFechaReposicionEquipo(Date fechaReposicionEquipo) {
		this.fechaReposicionEquipo = fechaReposicionEquipo;
	}

	public Date getFechagaranteiEquipo() {
		return this.fechagaranteiEquipo;
	}

	public void setFechagaranteiEquipo(Date fechagaranteiEquipo) {
		this.fechagaranteiEquipo = fechagaranteiEquipo;
	}

	public Date getFechagarantiafEquipo() {
		return this.fechagarantiafEquipo;
	}

	public void setFechagarantiafEquipo(Date fechagarantiafEquipo) {
		this.fechagarantiafEquipo = fechagarantiafEquipo;
	}

	public Integer getFrecuenciausoEquipo() {
		return this.frecuenciausoEquipo;
	}

	public void setFrecuenciausoEquipo(Integer frecuenciausoEquipo) {
		this.frecuenciausoEquipo = frecuenciausoEquipo;
	}

	public String getLocalizacionenlabEquipo() {
		return this.localizacionenlabEquipo;
	}

	public void setLocalizacionenlabEquipo(String localizacionenlabEquipo) {
		this.localizacionenlabEquipo = localizacionenlabEquipo;
	}

	public String getMarcaEquipo() {
		return this.marcaEquipo;
	}

	public void setMarcaEquipo(String marcaEquipo) {
		this.marcaEquipo = marcaEquipo;
	}

	public String getModeloEquipo() {
		return this.modeloEquipo;
	}

	public void setModeloEquipo(String modeloEquipo) {
		this.modeloEquipo = modeloEquipo;
	}

	public String getNombreEquipo() {
		return this.nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getNroserieEquipo() {
		return this.nroserieEquipo;
	}

	public void setNroserieEquipo(String nroserieEquipo) {
		this.nroserieEquipo = nroserieEquipo;
	}

	public String getObservacionesEquipo() {
		return this.observacionesEquipo;
	}

	public void setObservacionesEquipo(String observacionesEquipo) {
		this.observacionesEquipo = observacionesEquipo;
	}

	public Integer getTiempovidautilEquipo() {
		return this.tiempovidautilEquipo;
	}

	public void setTiempovidautilEquipo(Integer tiempovidautilEquipo) {
		this.tiempovidautilEquipo = tiempovidautilEquipo;
	}

	public Integer getVidautilEquipo() {
		return this.vidautilEquipo;
	}

	public void setVidautilEquipo(Integer vidautilEquipo) {
		this.vidautilEquipo = vidautilEquipo;
	}

	public List<Caracteristicastecnica> getCaracteristicastecnicas() {
		return this.caracteristicastecnicas;
	}

	public void setCaracteristicastecnicas(List<Caracteristicastecnica> caracteristicastecnicas) {
		this.caracteristicastecnicas = caracteristicastecnicas;
	}

	public Caracteristicastecnica addCaracteristicastecnica(Caracteristicastecnica caracteristicastecnica) {
		getCaracteristicastecnicas().add(caracteristicastecnica);
		caracteristicastecnica.setEquiposcalibracionequipo(this);

		return caracteristicastecnica;
	}

	public Caracteristicastecnica removeCaracteristicastecnica(Caracteristicastecnica caracteristicastecnica) {
		getCaracteristicastecnicas().remove(caracteristicastecnica);
		caracteristicastecnica.setEquiposcalibracionequipo(null);

		return caracteristicastecnica;
	}

	public List<Condicionesespecialesuso> getCondicionesespecialesusos() {
		return this.condicionesespecialesusos;
	}

	public void setCondicionesespecialesusos(List<Condicionesespecialesuso> condicionesespecialesusos) {
		this.condicionesespecialesusos = condicionesespecialesusos;
	}

	public Condicionesespecialesuso addCondicionesespecialesuso(Condicionesespecialesuso condicionesespecialesuso) {
		getCondicionesespecialesusos().add(condicionesespecialesuso);
		condicionesespecialesuso.setEquiposcalibracionequipo(this);

		return condicionesespecialesuso;
	}

	public Condicionesespecialesuso removeCondicionesespecialesuso(Condicionesespecialesuso condicionesespecialesuso) {
		getCondicionesespecialesusos().remove(condicionesespecialesuso);
		condicionesespecialesuso.setEquiposcalibracionequipo(null);

		return condicionesespecialesuso;
	}

	public List<Documentacionasociada> getDocumentacionasociadas() {
		return this.documentacionasociadas;
	}

	public void setDocumentacionasociadas(List<Documentacionasociada> documentacionasociadas) {
		this.documentacionasociadas = documentacionasociadas;
	}

	public Documentacionasociada addDocumentacionasociada(Documentacionasociada documentacionasociada) {
		getDocumentacionasociadas().add(documentacionasociada);
		documentacionasociada.setEquiposcalibracionequipo(this);

		return documentacionasociada;
	}

	public Documentacionasociada removeDocumentacionasociada(Documentacionasociada documentacionasociada) {
		getDocumentacionasociadas().remove(documentacionasociada);
		documentacionasociada.setEquiposcalibracionequipo(null);

		return documentacionasociada;
	}

	public List<Accesorio> getAccesorios() {
		return this.accesorios;
	}

	public void setAccesorios(List<Accesorio> accesorios) {
		this.accesorios = accesorios;
	}

	/*public List<Personalcalificado> getPersonalcalificados() {
		return this.personalcalificados;
	}

	public void setPersonalcalificados(List<Personalcalificado> personalcalificados) {
		this.personalcalificados = personalcalificados;
	}*/

	public Clasificacion getClasificacion() {
		return this.clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Estadoequipo getEstadoequipo() {
		return this.estadoequipo;
	}

	public void setEstadoequipo(Estadoequipo estadoequipo) {
		this.estadoequipo = estadoequipo;
	}

	public Laboratorioscalibracionequipo getLaboratorioscalibracionequipo() {
		return this.laboratorioscalibracionequipo;
	}

	public void setLaboratorioscalibracionequipo(Laboratorioscalibracionequipo laboratorioscalibracionequipo) {
		this.laboratorioscalibracionequipo = laboratorioscalibracionequipo;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Rangofuncionamiento getRangofuncionamiento() {
		return this.rangofuncionamiento;
	}

	public void setRangofuncionamiento(Rangofuncionamiento rangofuncionamiento) {
		this.rangofuncionamiento = rangofuncionamiento;
	}

	public Responsable getResponsable() {
		return this.responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public Tipoadquisicion getTipoadquisicion() {
		return this.tipoadquisicion;
	}

	public void setTipoadquisicion(Tipoadquisicion tipoadquisicion) {
		this.tipoadquisicion = tipoadquisicion;
	}

	public List<Funcionesequipo> getFuncionesequipos() {
		return this.funcionesequipos;
	}

	public void setFuncionesequipos(List<Funcionesequipo> funcionesequipos) {
		this.funcionesequipos = funcionesequipos;
	}

	public byte[] getFotoEquipo() {
		return fotoEquipo;
	}

	public void setFotoEquipo(byte[] fotoEquipo) {
		this.fotoEquipo = fotoEquipo;
	}

	public Funcionesequipo addFuncionesequipo(Funcionesequipo funcionesequipo) {
		getFuncionesequipos().add(funcionesequipo);
		funcionesequipo.setEquiposcalibracionequipo(this);

		return funcionesequipo;
	}

	public Funcionesequipo removeFuncionesequipo(Funcionesequipo funcionesequipo) {
		getFuncionesequipos().remove(funcionesequipo);
		funcionesequipo.setEquiposcalibracionequipo(null);

		return funcionesequipo;
	}

	public List<Gestioncompra> getGestioncompras() {
		return this.gestioncompras;
	}

	public void setGestioncompras(List<Gestioncompra> gestioncompras) {
		this.gestioncompras = gestioncompras;
	}

	public Gestioncompra addGestioncompra(Gestioncompra gestioncompra) {
		getGestioncompras().add(gestioncompra);
		gestioncompra.setEquiposcalibracionequipo(this);

		return gestioncompra;
	}

	public Gestioncompra removeGestioncompra(Gestioncompra gestioncompra) {
		getGestioncompras().remove(gestioncompra);
		gestioncompra.setEquiposcalibracionequipo(null);

		return gestioncompra;
	}

	public List<Incidentesasociado> getIncidentesasociados() {
		return this.incidentesasociados;
	}

	public void setIncidentesasociados(List<Incidentesasociado> incidentesasociados) {
		this.incidentesasociados = incidentesasociados;
	}

	public Incidentesasociado addIncidentesasociado(Incidentesasociado incidentesasociado) {
		getIncidentesasociados().add(incidentesasociado);
		incidentesasociado.setEquiposcalibracionequipo(this);

		return incidentesasociado;
	}

	public Incidentesasociado removeIncidentesasociado(Incidentesasociado incidentesasociado) {
		getIncidentesasociados().remove(incidentesasociado);
		incidentesasociado.setEquiposcalibracionequipo(null);

		return incidentesasociado;
	}

	public List<Medidaspreventiva> getMedidaspreventivas() {
		return this.medidaspreventivas;
	}

	public void setMedidaspreventivas(List<Medidaspreventiva> medidaspreventivas) {
		this.medidaspreventivas = medidaspreventivas;
	}

	public Medidaspreventiva addMedidaspreventiva(Medidaspreventiva medidaspreventiva) {
		getMedidaspreventivas().add(medidaspreventiva);
		medidaspreventiva.setEquiposcalibracionequipo(this);

		return medidaspreventiva;
	}

	public Medidaspreventiva removeMedidaspreventiva(Medidaspreventiva medidaspreventiva) {
		getMedidaspreventivas().remove(medidaspreventiva);
		medidaspreventiva.setEquiposcalibracionequipo(null);

		return medidaspreventiva;
	}

	public List<Plan> getPlans() {
		return this.plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	public Plan addPlan(Plan plan) {
		getPlans().add(plan);
		plan.setEquiposcalibracionequipo(this);

		return plan;
	}

	public Plan removePlan(Plan plan) {
		getPlans().remove(plan);
		plan.setEquiposcalibracionequipo(null);

		return plan;
	}

	public List<Riesgosasociado> getRiesgosasociados() {
		return this.riesgosasociados;
	}

	public void setRiesgosasociados(List<Riesgosasociado> riesgosasociados) {
		this.riesgosasociados = riesgosasociados;
	}

	public Riesgosasociado addRiesgosasociado(Riesgosasociado riesgosasociado) {
		getRiesgosasociados().add(riesgosasociado);
		riesgosasociado.setEquiposcalibracionequipo(this);

		return riesgosasociado;
	}

	public Riesgosasociado removeRiesgosasociado(Riesgosasociado riesgosasociado) {
		getRiesgosasociados().remove(riesgosasociado);
		riesgosasociado.setEquiposcalibracionequipo(null);

		return riesgosasociado;
	}

}