package ec.edu.epn.gestionDocente.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.edu.epn.contratos.entities.Pedido;


/**
 * The persistent class for the preplanificacion_docencia database table.
 * 
 */
@Entity
@Table(name="preplanificacion_docencia",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="PreplanificacionDocencia.findAll", query="SELECT p FROM PreplanificacionDocencia p")
public class PreplanificacionDocencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_preplanif")
	private Integer idPreplanif;

	private String apellido;
	
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	@Column(name="horas_preplanif")
	private double horasPreplanif;

	@Column(name="id_pensum")
	private Integer idPensum;

	@Column(name="id_usuario_preplanif")
	private Integer idUsuarioPreplanif;

	private String nced;

	private String nombre;
	
	@Column(name="cod_dep")
	private String codDep;
	
	
	@Column(name="nombre_anterior")
	private String nombreAnterior;
	
	@Column(name="horas_exigibles")
	private double horasExigibles;
	

	@Column(name="semanas_doc_dentro")
	private double semanasDocDentro;
	
	
	@Column(name="id_tcont")
	private Integer idTcont;
	
	
	@Column(name="relacion_lab")
	private String relacionLab;
	
	@OneToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	private String dedicacion;
	
	
	public PreplanificacionDocencia() {
	}

	public Integer getIdPreplanif() {
		return this.idPreplanif;
	}

	public void setIdPreplanif(Integer idPreplanif) {
		this.idPreplanif = idPreplanif;
	}

	
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getHorasPreplanif() {
		return this.horasPreplanif;
	}

	public void setHorasPreplanif(double horasPreplanif) {
		this.horasPreplanif = horasPreplanif;
	}

	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	public Integer getIdUsuarioPreplanif() {
		return this.idUsuarioPreplanif;
	}

	public void setIdUsuarioPreplanif(Integer idUsuarioPreplanif) {
		this.idUsuarioPreplanif = idUsuarioPreplanif;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	

	public double getSemanasDocDentro() {
		return this.semanasDocDentro;
	}

	public void setSemanasDocDentro(double semanasDocDentro) {
		this.semanasDocDentro = semanasDocDentro;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodDep() {
		return codDep;
	}

	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public String getNombreAnterior() {
		return nombreAnterior;
	}

	public void setNombreAnterior(String nombreAnterior) {
		this.nombreAnterior = nombreAnterior;
	}

	/**
	 * @return the horasExigibles
	 */
	public double getHorasExigibles() {
		return horasExigibles;
	}

	/**
	 * @param horasExigibles the horasExigibles to set
	 */
	public void setHorasExigibles(double horasExigibles) {
		this.horasExigibles = horasExigibles;
	}

	
	/**
	 * @return the relacionLab
	 */
	public String getRelacionLab() {
		return relacionLab;
	}

	
	

	/**
	 * @param relacionLab the relacionLab to set
	 */
	public void setRelacionLab(String relacionLab) {
		this.relacionLab = relacionLab;
	}

	

	/**
	 * @return the dedicacion
	 */
	public String getDedicacion() {
		return dedicacion;
	}

	/**
	 * @param dedicacion the dedicacion to set
	 */
	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	/**
	 * @return the idTcont
	 */
	public Integer getIdTcont() {
		return idTcont;
	}

	/**
	 * @param idTcont the idTcont to set
	 */
	public void setIdTcont(Integer idTcont) {
		this.idTcont = idTcont;
	}

}