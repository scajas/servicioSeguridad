package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.rrhh.movimientos.Cargosm;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the riesgos_laborales database table.
 * 
 */
@Entity
@Table(name="riesgos_laborales", catalog = "bddcorpepn", schema = "`Rrhh`")
@NamedQuery(name="RiesgosLaborale.findAll", query="SELECT r FROM RiesgosLaborale r")
public class RiesgosLaborale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_riesgo")
	private Integer idRiesgo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_desde")
	private Date fechaDesde;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_hasta")
	private Date fechaHasta;

	@Column(name="otros_biologico")
	private String otrosBiologico;

	@Column(name="otros_ergonomico")
	private String otrosErgonomico;

	@Column(name="otros_fisico")
	private String otrosFisico;

	@Column(name="otros_mecanico")
	private String otrosMecanico;

	@Column(name="otros_psicosocial")
	private String otrosPsicosocial;

	@Column(name="otros_quimico")
	private String otrosQuimico;

	private String puesto;

	//bi-directional many-to-one association to RiesgoActividad
	@OneToMany(mappedBy="riesgosLaborale")
	private List<RiesgoActividad> riesgoActividads;

	//bi-directional many-to-many association to CatalogoRiesgoLaboral
	@ManyToMany
	@JoinTable(
		name="riesgos_catalogo_puesto"
		, joinColumns={
			@JoinColumn(name="id_riesgo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id")
			}
		)
	private List<CatalogoRiesgoLaboral> catalogoRiesgoLaborals;

	//bi-directional many-to-one association to Cargosm
	@ManyToOne
	@JoinColumn(name="id_cargo")
	private Cargosm cargosm;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="nced")
	private Emp emp;

	public RiesgosLaborale() {
	}

	public Integer getIdRiesgo() {
		return this.idRiesgo;
	}

	public void setIdRiesgo(Integer idRiesgo) {
		this.idRiesgo = idRiesgo;
	}

	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public String getOtrosBiologico() {
		return this.otrosBiologico;
	}

	public void setOtrosBiologico(String otrosBiologico) {
		this.otrosBiologico = otrosBiologico;
	}

	public String getOtrosErgonomico() {
		return this.otrosErgonomico;
	}

	public void setOtrosErgonomico(String otrosErgonomico) {
		this.otrosErgonomico = otrosErgonomico;
	}

	public String getOtrosFisico() {
		return this.otrosFisico;
	}

	public void setOtrosFisico(String otrosFisico) {
		this.otrosFisico = otrosFisico;
	}

	public String getOtrosMecanico() {
		return this.otrosMecanico;
	}

	public void setOtrosMecanico(String otrosMecanico) {
		this.otrosMecanico = otrosMecanico;
	}

	public String getOtrosPsicosocial() {
		return this.otrosPsicosocial;
	}

	public void setOtrosPsicosocial(String otrosPsicosocial) {
		this.otrosPsicosocial = otrosPsicosocial;
	}

	public String getOtrosQuimico() {
		return this.otrosQuimico;
	}

	public void setOtrosQuimico(String otrosQuimico) {
		this.otrosQuimico = otrosQuimico;
	}

	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public List<RiesgoActividad> getRiesgoActividads() {
		return this.riesgoActividads;
	}

	public void setRiesgoActividads(List<RiesgoActividad> riesgoActividads) {
		this.riesgoActividads = riesgoActividads;
	}

	public RiesgoActividad addRiesgoActividad(RiesgoActividad riesgoActividad) {
		getRiesgoActividads().add(riesgoActividad);
		riesgoActividad.setRiesgosLaborale(this);

		return riesgoActividad;
	}

	public RiesgoActividad removeRiesgoActividad(RiesgoActividad riesgoActividad) {
		getRiesgoActividads().remove(riesgoActividad);
		riesgoActividad.setRiesgosLaborale(null);

		return riesgoActividad;
	}

	public List<CatalogoRiesgoLaboral> getCatalogoRiesgoLaborals() {
		return this.catalogoRiesgoLaborals;
	}

	public void setCatalogoRiesgoLaborals(List<CatalogoRiesgoLaboral> catalogoRiesgoLaborals) {
		this.catalogoRiesgoLaborals = catalogoRiesgoLaborals;
	}

	public Cargosm getCargosm() {
		return this.cargosm;
	}

	public void setCargosm(Cargosm cargosm) {
		this.cargosm = cargosm;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}