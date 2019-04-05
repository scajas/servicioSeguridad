package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the existencias database table.
 * 
 */
@Entity
@Table(name = "`existencias`", catalog = "`bddcorpepn`", schema = "`Laboratorios`")
@NamedQuery(name="Existencia.findAll", query="SELECT e FROM Existencia e")
public class Existencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_existencia")
	private String idExistencia;

	private String aux1;

	private String aux2;

	@Column(name="cantidad_e")
	private BigDecimal cantidadE;

	@Column(name="cantidadneta_e")
	private double cantidadnetaE;

	private BigDecimal dism;

	@Temporal(TemporalType.DATE)
	@Column(name="fechabaja_e")
	private Date fechabajaE;

	@Temporal(TemporalType.DATE)
	@Column(name="fechacad_e")
	private Date fechacadE;

	@Column(name="id_hidratacion")
	private String idHidratacion;

	@Column(name="id_unidad")
	private Integer idUnidad;

	private BigDecimal increm;

	@Column(name="nenvase_e")
	private Integer nenvaseE;

	@Column(name="obsolescencia_e")
	private String obsolescenciaE;

	@Column(name="pureza_e")
	private String purezaE;

	@Column(name="tasauso_e")
	private double tasausoE;

	private String toi;

	@Column(name="ubica_e")
	private String ubicaE;

	//bi-directional many-to-one association to laboratory
	@ManyToOne
	@JoinColumn(name="id_bodega")
	private laboratory bodega;

	//bi-directional many-to-one association to Caracteristica
	@ManyToOne
	@JoinColumn(name="id_caracteristica")
	private Caracteristica caracteristica;

	//bi-directional many-to-one association to Concentracion
	@ManyToOne
	@JoinColumn(name="id_concentracion")
	private Concentracion concentracion;

	//bi-directional many-to-one association to Estadoproducto
	@ManyToOne
	@JoinColumn(name="id_estadoprod")
	private Estadoproducto estadoproducto;

	//bi-directional many-to-one association to Grado
	@ManyToOne
	@JoinColumn(name="id_grado")
	private Grado grado;

	//bi-directional many-to-one association to Posgiro
	@ManyToOne
	@JoinColumn(name="id_posgiro")
	private Posgiro posgiro;

	//bi-directional many-to-one association to Presentacion
	@ManyToOne
	@JoinColumn(name="id_presentacion")
	private Presentacion presentacion;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private ProductoLab producto;

	//bi-directional many-to-one association to Tipoproducto
	@ManyToOne
	@JoinColumn(name="id_tipoprod")
	private Tipoproducto tipoproducto;

	//bi-directional many-to-one association to Unidadmedida
	@ManyToOne
	@JoinColumn(name="id_umedida")
	private Unidadmedida unidadmedida;

	public Existencia() {
	}

	public String getIdExistencia() {
		return this.idExistencia;
	}

	public void setIdExistencia(String idExistencia) {
		this.idExistencia = idExistencia;
	}

	public String getAux1() {
		return this.aux1;
	}

	public void setAux1(String aux1) {
		this.aux1 = aux1;
	}

	public String getAux2() {
		return this.aux2;
	}

	public void setAux2(String aux2) {
		this.aux2 = aux2;
	}

	public BigDecimal getCantidadE() {
		return this.cantidadE;
	}

	public void setCantidadE(BigDecimal cantidadE) {
		this.cantidadE = cantidadE;
	}

	public double getCantidadnetaE() {
		return this.cantidadnetaE;
	}

	public void setCantidadnetaE(double cantidadnetaE) {
		this.cantidadnetaE = cantidadnetaE;
	}

	public BigDecimal getDism() {
		return this.dism;
	}

	public void setDism(BigDecimal dism) {
		this.dism = dism;
	}

	public Date getFechabajaE() {
		return this.fechabajaE;
	}

	public void setFechabajaE(Date fechabajaE) {
		this.fechabajaE = fechabajaE;
	}

	public Date getFechacadE() {
		return this.fechacadE;
	}

	public void setFechacadE(Date fechacadE) {
		this.fechacadE = fechacadE;
	}

	public String getIdHidratacion() {
		return this.idHidratacion;
	}

	public void setIdHidratacion(String idHidratacion) {
		this.idHidratacion = idHidratacion;
	}

	public Integer getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(Integer idUnidad) {
		this.idUnidad = idUnidad;
	}

	public BigDecimal getIncrem() {
		return this.increm;
	}

	public void setIncrem(BigDecimal increm) {
		this.increm = increm;
	}

	public Integer getNenvaseE() {
		return this.nenvaseE;
	}

	public void setNenvaseE(Integer nenvaseE) {
		this.nenvaseE = nenvaseE;
	}

	public String getObsolescenciaE() {
		return this.obsolescenciaE;
	}

	public void setObsolescenciaE(String obsolescenciaE) {
		this.obsolescenciaE = obsolescenciaE;
	}

	public String getPurezaE() {
		return this.purezaE;
	}

	public void setPurezaE(String purezaE) {
		this.purezaE = purezaE;
	}

	public double getTasausoE() {
		return this.tasausoE;
	}

	public void setTasausoE(double tasausoE) {
		this.tasausoE = tasausoE;
	}

	public String getToi() {
		return this.toi;
	}

	public void setToi(String toi) {
		this.toi = toi;
	}

	public String getUbicaE() {
		return this.ubicaE;
	}

	public void setUbicaE(String ubicaE) {
		this.ubicaE = ubicaE;
	}

	public laboratory getBodega() {
		return this.bodega;
	}

	public void setBodega(laboratory bodega) {
		this.bodega = bodega;
	}

	public Caracteristica getCaracteristica() {
		return this.caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Concentracion getConcentracion() {
		return this.concentracion;
	}

	public void setConcentracion(Concentracion concentracion) {
		this.concentracion = concentracion;
	}

	public Estadoproducto getEstadoproducto() {
		return this.estadoproducto;
	}

	public void setEstadoproducto(Estadoproducto estadoproducto) {
		this.estadoproducto = estadoproducto;
	}

	public Grado getGrado() {
		return this.grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Posgiro getPosgiro() {
		return this.posgiro;
	}

	public void setPosgiro(Posgiro posgiro) {
		this.posgiro = posgiro;
	}

	public Presentacion getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
	}

	public ProductoLab getProducto() {
		return this.producto;
	}

	public void setProducto(ProductoLab producto) {
		this.producto = producto;
	}

	public Tipoproducto getTipoproducto() {
		return this.tipoproducto;
	}

	public void setTipoproducto(Tipoproducto tipoproducto) {
		this.tipoproducto = tipoproducto;
	}

	public Unidadmedida getUnidadmedida() {
		return this.unidadmedida;
	}

	public void setUnidadmedida(Unidadmedida unidadmedida) {
		this.unidadmedida = unidadmedida;
	}

}