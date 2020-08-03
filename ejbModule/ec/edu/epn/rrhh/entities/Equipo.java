package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the equipo database table.
 * 
 */
@Entity
@Table(name = "equipo", catalog = "bddcorpepn", schema = "`Rrhh`")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"Rrhh\".sec_equipo")
	@SequenceGenerator(name = "\"Rrhh\".sec_equipo", sequenceName = "\"Rrhh\".sec_equipo", allocationSize = 1)
	@Column(name = "id_equipo")
	private Integer idEquipo;

	@Column(name = "cod_bienes")
	private String codBienes;

	@Column(name = "cod_bienes_teclado")
	private String codBienesTeclado;

	private String descripcion;

	private String disco;

	private String marca;

	private String memoria;

	private String modelo;

	private String monitor;

	private String observaciones;

	private String procesador;

	private String sistema;

	private String equipo;

	@Column(name = "numero_serie")
	private String numeroSerie;

	@Column(name = "id_usuario_log")
	private Integer idUsuarioLog;

	@Column(name = "id_laboratorio")
	private String idLaboratorio;

	@Column(name = "id_facultad")
	private String idFacultad;

	@Column(name = "tipo_asignacion")
	private String tipoAsignacion;

	@Column(name = "fecha_asignacion")
	private Date fechaAsignacion;

	@Column(name = "nro_contrato")
	private String nroContrato;

	@Column(name = "anio_adquisicion")
	private Integer anioAdquisicion;

	@ManyToOne
	@JoinColumn(name = "nced")
	private Emp emp;

	@ManyToOne
	@JoinColumn(name = "id_tipo")
	private TipoEquipo tipoEquipo;

	public Equipo() {
	}

	public Integer getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getCodBienes() {
		return this.codBienes;
	}

	public void setCodBienes(String codBienes) {
		this.codBienes = codBienes;
	}

	public String getCodBienesTeclado() {
		return this.codBienesTeclado;
	}

	public void setCodBienesTeclado(String codBienesTeclado) {
		this.codBienesTeclado = codBienesTeclado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDisco() {
		return this.disco;
	}

	public void setDisco(String disco) {
		this.disco = disco;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMemoria() {
		return this.memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMonitor() {
		return this.monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getProcesador() {
		return this.procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public String getSistema() {
		return this.sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public TipoEquipo getTipoEquipo() {
		return this.tipoEquipo;
	}

	public void setTipoEquipo(TipoEquipo tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}

	/**
	 * @return the equipo
	 */
	public String getEquipo() {
		return equipo;
	}

	/**
	 * @param equipo
	 *            the equipo to set
	 */
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	/**
	 * @return the numeroSerie
	 */
	public String getNumeroSerie() {
		return numeroSerie;
	}

	/**
	 * @param numeroSerie
	 *            the numeroSerie to set
	 */
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	/**
	 * @return the idLaboratorio
	 */
	public String getIdLaboratorio() {
		return idLaboratorio;
	}

	/**
	 * @param idLaboratorio
	 *            the idLaboratorio to set
	 */
	public void setIdLaboratorio(String idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	/**
	 * @return the idFacultad
	 */
	public String getIdFacultad() {
		return idFacultad;
	}

	/**
	 * @param idFacultad
	 *            the idFacultad to set
	 */
	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	/**
	 * @return the tipoAsignacion
	 */
	public String getTipoAsignacion() {
		return tipoAsignacion;
	}

	/**
	 * @param tipoAsignacion
	 *            the tipoAsignacion to set
	 */
	public void setTipoAsignacion(String tipoAsignacion) {
		this.tipoAsignacion = tipoAsignacion;
	}

	/**
	 * @return the fechaAsignacion
	 */
	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	/**
	 * @param fechaAsignacion
	 *            the fechaAsignacion to set
	 */
	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	/**
	 * @return the idUsuarioLog
	 */
	public Integer getIdUsuarioLog() {
		return idUsuarioLog;
	}

	/**
	 * @param idUsuarioLog
	 *            the idUsuarioLog to set
	 */
	public void setIdUsuarioLog(Integer idUsuarioLog) {
		this.idUsuarioLog = idUsuarioLog;
	}

	/**
	 * @return the nroContrato
	 */
	public String getNroContrato() {
		return nroContrato;
	}

	/**
	 * @param nroContrato
	 *            the nroContrato to set
	 */
	public void setNroContrato(String nroContrato) {
		this.nroContrato = nroContrato;
	}

	/**
	 * @return the anioAdquisicion
	 */
	public Integer getAnioAdquisicion() {
		return anioAdquisicion;
	}

	/**
	 * @param anioAdquisicion
	 *            the anioAdquisicion to set
	 */
	public void setAnioAdquisicion(Integer anioAdquisicion) {
		this.anioAdquisicion = anioAdquisicion;
	}

}