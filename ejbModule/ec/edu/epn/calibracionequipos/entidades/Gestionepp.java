package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the gestionepp database table.
 * 
 */
@Entity
@Table(name="gestionepp", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Gestionepp.findAll", query="SELECT g FROM Gestionepp g")
public class Gestionepp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_gestionepp")
	private Integer idGestionepp;

	@Temporal(TemporalType.DATE)
	@Column(name="fechadotacion_gestionepp")
	private Date fechadotacionGestionepp;

	@Temporal(TemporalType.DATE)
	@Column(name="fecharequerimiento_gestionepp")
	private Date fecharequerimientoGestionepp;

	@Column(name="observaciones_gestionepp")
	private String observacionesGestionepp;

	@Column(name="responsable_gestionepp")
	private String responsableGestionepp;

	private Integer totalepp;

	@Column(name="totalpersonalusaepp_gestionepp")
	private Integer totalpersonalusaeppGestionepp;

	//bi-directional many-to-many association to Equipoproteccionpersonal
	@ManyToMany
	@JoinTable(
		name="geppepp"
		, joinColumns={
			@JoinColumn(name="id_gestionepp")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_epp")
			}
		)
	private List<Equipoproteccionpersonal> equipoproteccionpersonals;

	//bi-directional many-to-one association to Laboratorioscalibracionequipo
	@ManyToOne
	@JoinColumn(name="id_laboratorio")
	private Laboratorioscalibracionequipo laboratorioscalibracionequipo;

	//bi-directional many-to-one association to Puestostrabajoepp
	@OneToMany(mappedBy="gestionepp")
	private List<Puestostrabajoepp> puestostrabajoepps;

	public Gestionepp() {
	}

	public Integer getIdGestionepp() {
		return this.idGestionepp;
	}

	public void setIdGestionepp(Integer idGestionepp) {
		this.idGestionepp = idGestionepp;
	}

	public Date getFechadotacionGestionepp() {
		return this.fechadotacionGestionepp;
	}

	public void setFechadotacionGestionepp(Date fechadotacionGestionepp) {
		this.fechadotacionGestionepp = fechadotacionGestionepp;
	}

	public Date getFecharequerimientoGestionepp() {
		return this.fecharequerimientoGestionepp;
	}

	public void setFecharequerimientoGestionepp(Date fecharequerimientoGestionepp) {
		this.fecharequerimientoGestionepp = fecharequerimientoGestionepp;
	}

	public String getObservacionesGestionepp() {
		return this.observacionesGestionepp;
	}

	public void setObservacionesGestionepp(String observacionesGestionepp) {
		this.observacionesGestionepp = observacionesGestionepp;
	}

	public String getResponsableGestionepp() {
		return this.responsableGestionepp;
	}

	public void setResponsableGestionepp(String responsableGestionepp) {
		this.responsableGestionepp = responsableGestionepp;
	}

	public Integer getTotalepp() {
		return this.totalepp;
	}

	public void setTotalepp(Integer totalepp) {
		this.totalepp = totalepp;
	}

	public Integer getTotalpersonalusaeppGestionepp() {
		return this.totalpersonalusaeppGestionepp;
	}

	public void setTotalpersonalusaeppGestionepp(Integer totalpersonalusaeppGestionepp) {
		this.totalpersonalusaeppGestionepp = totalpersonalusaeppGestionepp;
	}

	public List<Equipoproteccionpersonal> getEquipoproteccionpersonals() {
		return this.equipoproteccionpersonals;
	}

	public void setEquipoproteccionpersonals(List<Equipoproteccionpersonal> equipoproteccionpersonals) {
		this.equipoproteccionpersonals = equipoproteccionpersonals;
	}

	public Laboratorioscalibracionequipo getLaboratorioscalibracionequipo() {
		return this.laboratorioscalibracionequipo;
	}

	public void setLaboratorioscalibracionequipo(Laboratorioscalibracionequipo laboratorioscalibracionequipo) {
		this.laboratorioscalibracionequipo = laboratorioscalibracionequipo;
	}

	public List<Puestostrabajoepp> getPuestostrabajoepps() {
		return this.puestostrabajoepps;
	}

	public void setPuestostrabajoepps(List<Puestostrabajoepp> puestostrabajoepps) {
		this.puestostrabajoepps = puestostrabajoepps;
	}

	public Puestostrabajoepp addPuestostrabajoepp(Puestostrabajoepp puestostrabajoepp) {
		getPuestostrabajoepps().add(puestostrabajoepp);
		puestostrabajoepp.setGestionepp(this);

		return puestostrabajoepp;
	}

	public Puestostrabajoepp removePuestostrabajoepp(Puestostrabajoepp puestostrabajoepp) {
		getPuestostrabajoepps().remove(puestostrabajoepp);
		puestostrabajoepp.setGestionepp(null);

		return puestostrabajoepp;
	}

}