package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the autorizacionretraso database table.
 * 
 */
@Entity

@Table(name="autorizacionretraso", catalog = "`bddcorpepn`", schema = "`Silabo`" )
@NamedQuery(name="Autorizacionretraso.findAll", query="SELECT a FROM Autorizacionretraso a")
public class Autorizacionretraso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_autoriza", unique=true, nullable=false)
	private Integer idAutoriza;

	@Column(length=15)
	private String anio;

	@Column(length=256)
	private String asignatura;

	@Column(length=256)
	private String carrera;

	@Column(nullable=false, length=10)
	private String cedula;

	@Column(length=10)
	private String codcarrera;

	@Column(length=256)
	private String codigo;

	@Column(length=1)
	private String estado;

	@Column(length=256)
	private String facultad;

	@Temporal(TemporalType.DATE)
	private Date fsistema;

	@Column(name="id_pensum", nullable=false)
	private Integer idPensum;

	@Column(length=256)
	private String paralelo;
	
	private String usuario; 

	public Autorizacionretraso() {
	}

	public Integer getIdAutoriza() {
		return this.idAutoriza;
	}

	public void setIdAutoriza(Integer idAutoriza) {
		this.idAutoriza = idAutoriza;
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodcarrera() {
		return this.codcarrera;
	}

	public void setCodcarrera(String codcarrera) {
		this.codcarrera = codcarrera;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFacultad() {
		return this.facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public Date getFsistema() {
		return this.fsistema;
	}

	public void setFsistema(Date fsistema) {
		this.fsistema = fsistema;
	}

	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	public String getParalelo() {
		return this.paralelo;
	}

	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}