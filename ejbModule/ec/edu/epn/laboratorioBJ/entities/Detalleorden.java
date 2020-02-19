package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the detalleorden database table.
 * 
 */
@Entity
@Table(name = "detalleorden", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Detalleorden.findAll", query="SELECT d FROM Detalleorden d")
public class Detalleorden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DETALLEOT_IDDETALLEOT_GENERATOR", sequenceName="secuencia_detalle_ordent",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DETALLEOT_IDDETALLEOT_GENERATOR")
	@Column(name="id_detalleorden")
	private int idDetalleorden;

	@Column(name="estado_dot")
	private String estadoDot;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_analisis")
	private Date fechaFinAnalisis;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_analisis")
	private Date fechaInicioAnalisis;

	@Column(name="horas_trabajo")
	private double horasTrabajo;

	@Column(name="id_metodo")
	private String idMetodo;

	@Column(name="id_servicio")
	private String idServicio;

	@Column(name="size_existencias")
	private Integer sizeExistencias;

	//bi-directional many-to-one association to Muestra
	@ManyToOne
	@JoinColumn(name="id_muestra")
	private Muestra muestra;

	//bi-directional many-to-one association to OrdenTrabajo
	@ManyToOne
	@JoinColumn(name="id_orden")
	private OrdenTrabajo ordenTrabajo;

	//bi-directional many-to-one association to Personal
	@ManyToOne
	@JoinColumn(name="id_personal")
	private PersonalLab personal;

	//bi-directional many-to-one association to Ordeninventario
	@OneToMany(mappedBy="detalleorden")
	private List<Ordeninventario> ordeninventarios;

	public Detalleorden() {
	}

	public int getIdDetalleorden() {
		return this.idDetalleorden;
	}

	public void setIdDetalleorden(int idDetalleorden) {
		this.idDetalleorden = idDetalleorden;
	}

	public String getEstadoDot() {
		return this.estadoDot;
	}

	public void setEstadoDot(String estadoDot) {
		this.estadoDot = estadoDot;
	}

	public Date getFechaFinAnalisis() {
		return this.fechaFinAnalisis;
	}

	public void setFechaFinAnalisis(Date fechaFinAnalisis) {
		this.fechaFinAnalisis = fechaFinAnalisis;
	}

	public Date getFechaInicioAnalisis() {
		return this.fechaInicioAnalisis;
	}

	public void setFechaInicioAnalisis(Date fechaInicioAnalisis) {
		this.fechaInicioAnalisis = fechaInicioAnalisis;
	}

	public double getHorasTrabajo() {
		return this.horasTrabajo;
	}

	public void setHorasTrabajo(double horasTrabajo) {
		this.horasTrabajo = horasTrabajo;
	}

	public String getIdMetodo() {
		return this.idMetodo;
	}

	public void setIdMetodo(String idMetodo) {
		this.idMetodo = idMetodo;
	}

	public String getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(String idServicio) {
		this.idServicio = idServicio;
	}

	public Integer getSizeExistencias() {
		return this.sizeExistencias;
	}

	public void setSizeExistencias(Integer sizeExistencias) {
		this.sizeExistencias = sizeExistencias;
	}

	public Muestra getMuestra() {
		return this.muestra;
	}

	public void setMuestra(Muestra muestra) {
		this.muestra = muestra;
	}

	public OrdenTrabajo getOrdenTrabajo() {
		return this.ordenTrabajo;
	}

	public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	public PersonalLab getPersonal() {
		return this.personal;
	}

	public void setPersonal(PersonalLab personal) {
		this.personal = personal;
	}

	public List<Ordeninventario> getOrdeninventarios() {
		return this.ordeninventarios;
	}

	public void setOrdeninventarios(List<Ordeninventario> ordeninventarios) {
		this.ordeninventarios = ordeninventarios;
	}

	public Ordeninventario addOrdeninventario(Ordeninventario ordeninventario) {
		getOrdeninventarios().add(ordeninventario);
		ordeninventario.setDetalleorden(this);

		return ordeninventario;
	}

	public Ordeninventario removeOrdeninventario(Ordeninventario ordeninventario) {
		getOrdeninventarios().remove(ordeninventario);
		ordeninventario.setDetalleorden(null);

		return ordeninventario;
	}

}