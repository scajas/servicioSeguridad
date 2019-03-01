package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.catalogos.entities.Materia;

import java.util.Date;

/**
 * The persistent class for the carga_academica database table.
 * 
 */
@Entity
@Table(name = "carga_academica", catalog = "`bddcorpepn`", schema = "`Contratos`")
@NamedQuery(name = "CargaAcademica.findAll", query = "SELECT c FROM CargaAcademica c")
public class CargaAcademica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_carga")
	private Integer idCarga;

	@Column(name = "marca_varias_fechas")
	private String marcaVarFechas;

	@Column(name = "codmatsaew")
	private String codmatsaew;
	
	@Column(name = "nommatsaew")
	private String nommatsaew;

	@Column(name = "idcarrerasaew")
	private String idCarreraSaew;

	@Column(name = "nomcarrerasaew")
	private String nomcarrerasaew;

	/*
	 * @Column(name="cod_materia") private String codMateria;
	 */

	@ManyToOne
	@JoinColumn(name = "cod_materia")
	private Materia materia;

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	



	

	

	@Column(name = "num_horas_modulo")
	private Integer numHorasModulo;

	@Column(name = "num_horas_semana")
	private Integer numHorasSemana;

	private String paralelo;

	// bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	public CargaAcademica() {
	}

	public Integer getIdCarga() {
		return this.idCarga;
	}

	public void setIdCarga(Integer idCarga) {
		this.idCarga = idCarga;
	}

	/*
	 * public String getCodMateria() { return this.codMateria; }
	 * 
	 * public void setCodMateria(String codMateria) { this.codMateria =
	 * codMateria; }
	 */

	public String getCodmatsaew() {
		return this.codmatsaew;
	}

	public void setCodmatsaew(String codmatsaew) {
		this.codmatsaew = codmatsaew;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	

	

	public String getNomcarrerasaew() {
		return this.nomcarrerasaew;
	}

	public void setNomcarrerasaew(String nomcarrerasaew) {
		this.nomcarrerasaew = nomcarrerasaew;
	}

	public String getNommatsaew() {
		return this.nommatsaew;
	}

	public void setNommatsaew(String nommatsaew) {
		this.nommatsaew = nommatsaew;
	}

	public Integer getNumHorasModulo() {
		return this.numHorasModulo;
	}

	public void setNumHorasModulo(Integer numHorasModulo) {
		this.numHorasModulo = numHorasModulo;
	}

	public Integer getNumHorasSemana() {
		return this.numHorasSemana;
	}

	public void setNumHorasSemana(Integer numHorasSemana) {
		this.numHorasSemana = numHorasSemana;
	}

	public String getParalelo() {
		return this.paralelo;
	}

	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getMarcaVarFechas() {
		return marcaVarFechas;
	}

	public void setMarcaVarFechas(String marcaVarFechas) {
		this.marcaVarFechas = marcaVarFechas;
	}

	

	

	public String getIdCarreraSaew() {
		return idCarreraSaew;
	}

	public void setIdCarreraSaew(String idCarreraSaew) {
		this.idCarreraSaew = idCarreraSaew;
	}

	

}