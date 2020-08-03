package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the laboratorioscalibracionequipo database table.
 * 
 */
@Entity
@Table(name = "laboratorioscalibracionequipo", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "Laboratorioscalibracionequipo.findAll", query = "SELECT l FROM Laboratorioscalibracionequipo l")
public class Laboratorioscalibracionequipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_laboratorio")
	private Integer idLaboratorio;

	@Column(name = "areafisica_lab")
	private double areafisicaLab;

	@Column(name = "areautil_lab")
	private double areautilLab;

	@Column(name = "codigo_lab")
	private String codigoLab;

	@Column(name = "descripcion_lab")
	private String descripcionLab;

	@Column(name = "id_departamento")
	private String idDepartamento;

	@Column(name = "id_facultad")
	private Integer idFacultad;

	@Column(name = "id_jefe_lab")
	private Integer idJefeLab;

	@Column(name = "idespacio_lab")
	private Integer idespacioLab;

	@Column(name = "ingresosanuales_lab")
	private double ingresosanualesLab;

	@Column(name = "logotipo_lab")
	private byte[] logotipoLab;

	@Column(name = "nombre_lab")
	private String nombreLab;

	@Column(name = "observaciones_lab")
	private String observacionesLab;

	@Column(name = "sitioweb_lab")
	private String sitiowebLab;

	// bi-directional many-to-one association to Auditoria
	@OneToMany(mappedBy = "laboratorioscalibracionequipo")
	private List<Auditoria> auditorias;

	// bi-directional many-to-one association to Equiposcalibracionequipo
	@OneToMany(mappedBy = "laboratorioscalibracionequipo")
	private List<Equiposcalibracionequipo> equiposcalibracionequipos;

	// bi-directional many-to-one association to Gestionepp
	@OneToMany(mappedBy = "laboratorioscalibracionequipo")
	private List<Gestionepp> gestionepps;

	// bi-directional many-to-one association to Incidentesaccidente
	@OneToMany(mappedBy = "laboratorioscalibracionequipo")
	private List<Incidentesaccidente> incidentesaccidentes;

	// bi-directional many-to-many association to Actividadescalibracionequipo
	@OneToMany
	@JoinColumn(name = "laboratorio")
	private List<Actividadescalibracionequipo> actividadescalibracionequipos;

	// bi-directional many-to-many association to Lineasinvestigacion
	@OneToMany(mappedBy = "labo")
	private List<LabLinInv> lablinv;

	public List<LabLinInv> getLablinv() {
		return lablinv;
	}

	public void setLablinv(List<LabLinInv> lablinv) {
		this.lablinv = lablinv;
	}

	// bi-directional many-to-many association to Matrizcondisionesfisica
	@ManyToMany(mappedBy = "laboratorioscalibracionequipos")
	private List<Matrizcondisionesfisica> matrizcondisionesfisicas;

	// bi-directional many-to-one association to Jefelaboratorio
	@ManyToOne
	@JoinColumn(name = "id_jefelab")
	private Jefelaboratorio jefelaboratorio;

	// bi-directional many-to-one association to Tiposlaboratorio
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "id_tipolab") private Tiposlaboratorio
	 * tiposlaboratorio;
	 */
	@OneToMany(mappedBy = "labo")
	private List<TipoLaboLaboratorios> tipoLaboLaboratorio;

	public List<TipoLaboLaboratorios> getTipoLaboLaboratorio() {
		return tipoLaboLaboratorio;
	}

	public void setTipoLaboLaboratorio(List<TipoLaboLaboratorios> tipoLaboLaboratorio) {
		this.tipoLaboLaboratorio = tipoLaboLaboratorio;
	}

	// bi-directional many-to-many association to Registrosemestralpractica
	@ManyToMany(mappedBy = "laboratorioscalibracionequipos")
	private List<Registrosemestralpractica> registrosemestralpracticas;

	// bi-directional many-to-many association to Sistemasgestioncalidad
	@OneToMany(mappedBy = "laboratorio")
	private List<Sistemasgestioncalidad> sistemasgestioncalidads;

	// bi-directional many-to-one association to Siso
	@OneToMany(mappedBy = "laboratorioscalibracionequipo")
	private List<Siso> sisos;

	public Laboratorioscalibracionequipo() {
	}

	public Integer getIdLaboratorio() {
		return this.idLaboratorio;
	}

	public void setIdLaboratorio(Integer idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public double getAreafisicaLab() {
		return this.areafisicaLab;
	}

	public void setAreafisicaLab(double areafisicaLab) {
		this.areafisicaLab = areafisicaLab;
	}

	public double getAreautilLab() {
		return this.areautilLab;
	}

	public void setAreautilLab(double areautilLab) {
		this.areautilLab = areautilLab;
	}

	public String getCodigoLab() {
		return this.codigoLab;
	}

	public void setCodigoLab(String codigoLab) {
		this.codigoLab = codigoLab;
	}

	public String getDescripcionLab() {
		return this.descripcionLab;
	}

	public void setDescripcionLab(String descripcionLab) {
		this.descripcionLab = descripcionLab;
	}

	public String getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Integer getIdFacultad() {
		return this.idFacultad;
	}

	public void setIdFacultad(Integer idFacultad) {
		this.idFacultad = idFacultad;
	}

	public Integer getIdJefeLab() {
		return this.idJefeLab;
	}

	public void setIdJefeLab(Integer idJefeLab) {
		this.idJefeLab = idJefeLab;
	}

	public Integer getIdespacioLab() {
		return this.idespacioLab;
	}

	public void setIdespacioLab(Integer idespacioLab) {
		this.idespacioLab = idespacioLab;
	}

	public double getIngresosanualesLab() {
		return this.ingresosanualesLab;
	}

	public void setIngresosanualesLab(double ingresosanualesLab) {
		this.ingresosanualesLab = ingresosanualesLab;
	}

	public byte[] getLogotipoLab() {
		return this.logotipoLab;
	}

	public void setLogotipoLab(byte[] logotipoLab) {
		this.logotipoLab = logotipoLab;
	}

	public String getNombreLab() {
		return this.nombreLab;
	}

	public void setNombreLab(String nombreLab) {
		this.nombreLab = nombreLab;
	}

	public String getObservacionesLab() {
		return this.observacionesLab;
	}

	public void setObservacionesLab(String observacionesLab) {
		this.observacionesLab = observacionesLab;
	}

	public String getSitiowebLab() {
		return this.sitiowebLab;
	}

	public void setSitiowebLab(String sitiowebLab) {
		this.sitiowebLab = sitiowebLab;
	}

	public List<Auditoria> getAuditorias() {
		return this.auditorias;
	}

	public void setAuditorias(List<Auditoria> auditorias) {
		this.auditorias = auditorias;
	}

	public Auditoria addAuditoria(Auditoria auditoria) {
		getAuditorias().add(auditoria);
		auditoria.setLaboratorioscalibracionequipo(this);

		return auditoria;
	}

	public Auditoria removeAuditoria(Auditoria auditoria) {
		getAuditorias().remove(auditoria);
		auditoria.setLaboratorioscalibracionequipo(null);

		return auditoria;
	}

	public List<Equiposcalibracionequipo> getEquiposcalibracionequipos() {
		return this.equiposcalibracionequipos;
	}

	public void setEquiposcalibracionequipos(List<Equiposcalibracionequipo> equiposcalibracionequipos) {
		this.equiposcalibracionequipos = equiposcalibracionequipos;
	}

	public Equiposcalibracionequipo addEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		getEquiposcalibracionequipos().add(equiposcalibracionequipo);
		equiposcalibracionequipo.setLaboratorioscalibracionequipo(this);

		return equiposcalibracionequipo;
	}

	public Equiposcalibracionequipo removeEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		getEquiposcalibracionequipos().remove(equiposcalibracionequipo);
		equiposcalibracionequipo.setLaboratorioscalibracionequipo(null);

		return equiposcalibracionequipo;
	}

	public List<Gestionepp> getGestionepps() {
		return this.gestionepps;
	}

	public void setGestionepps(List<Gestionepp> gestionepps) {
		this.gestionepps = gestionepps;
	}

	public Gestionepp addGestionepp(Gestionepp gestionepp) {
		getGestionepps().add(gestionepp);
		gestionepp.setLaboratorioscalibracionequipo(this);

		return gestionepp;
	}

	public Gestionepp removeGestionepp(Gestionepp gestionepp) {
		getGestionepps().remove(gestionepp);
		gestionepp.setLaboratorioscalibracionequipo(null);

		return gestionepp;
	}

	public List<Incidentesaccidente> getIncidentesaccidentes() {
		return this.incidentesaccidentes;
	}

	public void setIncidentesaccidentes(List<Incidentesaccidente> incidentesaccidentes) {
		this.incidentesaccidentes = incidentesaccidentes;
	}

	public Incidentesaccidente addIncidentesaccidente(Incidentesaccidente incidentesaccidente) {
		getIncidentesaccidentes().add(incidentesaccidente);
		incidentesaccidente.setLaboratorioscalibracionequipo(this);

		return incidentesaccidente;
	}

	public Incidentesaccidente removeIncidentesaccidente(Incidentesaccidente incidentesaccidente) {
		getIncidentesaccidentes().remove(incidentesaccidente);
		incidentesaccidente.setLaboratorioscalibracionequipo(null);

		return incidentesaccidente;
	}

	public List<Actividadescalibracionequipo> getActividadescalibracionequipos() {
		return this.actividadescalibracionequipos;
	}

	public void setActividadescalibracionequipos(List<Actividadescalibracionequipo> actividadescalibracionequipos) {
		this.actividadescalibracionequipos = actividadescalibracionequipos;
	}

	public List<Matrizcondisionesfisica> getMatrizcondisionesfisicas() {
		return this.matrizcondisionesfisicas;
	}

	public void setMatrizcondisionesfisicas(List<Matrizcondisionesfisica> matrizcondisionesfisicas) {
		this.matrizcondisionesfisicas = matrizcondisionesfisicas;
	}

	public Jefelaboratorio getJefelaboratorio() {
		return this.jefelaboratorio;
	}

	public void setJefelaboratorio(Jefelaboratorio jefelaboratorio) {
		this.jefelaboratorio = jefelaboratorio;
	}

	/*
	 * public Tiposlaboratorio getTiposlaboratorio() { return
	 * this.tiposlaboratorio; }
	 * 
	 * public void setTiposlaboratorio(Tiposlaboratorio tiposlaboratorio) {
	 * this.tiposlaboratorio = tiposlaboratorio; }
	 */
	public List<Registrosemestralpractica> getRegistrosemestralpracticas() {
		return this.registrosemestralpracticas;
	}

	public void setRegistrosemestralpracticas(List<Registrosemestralpractica> registrosemestralpracticas) {
		this.registrosemestralpracticas = registrosemestralpracticas;
	}

	public List<Sistemasgestioncalidad> getSistemasgestioncalidads() {
		return this.sistemasgestioncalidads;
	}

	public void setSistemasgestioncalidads(List<Sistemasgestioncalidad> sistemasgestioncalidads) {
		this.sistemasgestioncalidads = sistemasgestioncalidads;
	}

	public List<Siso> getSisos() {
		return this.sisos;
	}

	public void setSisos(List<Siso> sisos) {
		this.sisos = sisos;
	}

	public Siso addSiso(Siso siso) {
		getSisos().add(siso);
		siso.setLaboratorioscalibracionequipo(this);

		return siso;
	}

	public Siso removeSiso(Siso siso) {
		getSisos().remove(siso);
		siso.setLaboratorioscalibracionequipo(null);

		return siso;
	}

}