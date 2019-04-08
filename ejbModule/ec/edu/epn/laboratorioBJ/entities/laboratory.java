package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bodega database table.
 * 
 */
@Entity
@Table(name = "`bodega`", catalog = "`bddcorpepn`", schema = "`Laboratorios`")
@NamedQuery(name="laboratory.findAll", query="SELECT l FROM laboratory l")
public class laboratory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_bodega")
	private String idBodega;

	@Column(name="descr_bg")
	private String descrBg;

	@Column(name="habilitar_bd")
	private String habilitarBd;

	@Column(name="id_unidad")
	private Integer idUnidad;

	@Column(name="id_usuario")
	private Integer idUsuario;

	@Column(name="nombre_bg")
	private String nombreBg;

	@Column(name="ubicacion_bg")
	private String ubicacionBg;

	//bi-directional many-to-one association to BodegaUsuario
	@OneToMany(mappedBy="bodega")
	private List<BodegaUsuario> bodegaUsuarios;

	//bi-directional many-to-one association to Existencia
	@OneToMany(mappedBy="bodega")
	private List<Existencia> existencias;

	public laboratory() {
	}

	public String getIdBodega() {
		return this.idBodega;
	}

	public void setIdBodega(String idBodega) {
		this.idBodega = idBodega;
	}

	public String getDescrBg() {
		return this.descrBg;
	}

	public void setDescrBg(String descrBg) {
		this.descrBg = descrBg;
	}

	public String getHabilitarBd() {
		return this.habilitarBd;
	}

	public void setHabilitarBd(String habilitarBd) {
		this.habilitarBd = habilitarBd;
	}

	public Integer getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(Integer idUnidad) {
		this.idUnidad = idUnidad;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreBg() {
		return this.nombreBg;
	}

	public void setNombreBg(String nombreBg) {
		this.nombreBg = nombreBg;
	}

	public String getUbicacionBg() {
		return this.ubicacionBg;
	}

	public void setUbicacionBg(String ubicacionBg) {
		this.ubicacionBg = ubicacionBg;
	}

	public List<BodegaUsuario> getBodegaUsuarios() {
		return this.bodegaUsuarios;
	}

	public void setBodegaUsuarios(List<BodegaUsuario> bodegaUsuarios) {
		this.bodegaUsuarios = bodegaUsuarios;
	}

	public BodegaUsuario addBodegaUsuario(BodegaUsuario bodegaUsuario) {
		getBodegaUsuarios().add(bodegaUsuario);
		bodegaUsuario.setBodega(this);

		return bodegaUsuario;
	}

	public BodegaUsuario removeBodegaUsuario(BodegaUsuario bodegaUsuario) {
		getBodegaUsuarios().remove(bodegaUsuario);
		bodegaUsuario.setBodega(null);

		return bodegaUsuario;
	}

	public List<Existencia> getExistencias() {
		return this.existencias;
	}

	public void setExistencias(List<Existencia> existencias) {
		this.existencias = existencias;
	}

	public Existencia addExistencia(Existencia existencia) {
		getExistencias().add(existencia);
		existencia.setBodega(this);

		return existencia;
	}

	public Existencia removeExistencia(Existencia existencia) {
		getExistencias().remove(existencia);
		existencia.setBodega(null);

		return existencia;
	}

}