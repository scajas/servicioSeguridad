package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name = "producto", catalog = "bddcorpepn", schema = "`Proyectos`")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String carrera;

	private String codtesis;

	private String estado;

	private String estuadiante;

	private Integer idpensum;



	private String meses;

	private String titulo,id_pub,tipopresentacion,expositor,evento,lugar
	,hv ,
	  autorexterno ,
	  volumen ,
	  numero ,
	  pagini ,
	  pagfin ,
	  catalogo ,
	  url;
	
	
	private Date  fechapresenta ;
	
	
	
	@ManyToOne
	@JoinColumn(name = "idproyecto")
	private ProyectoP proyecto;
	
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_producto")
	private TipoProducto tipo_producto;

	public Producto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getCodtesis() {
		return this.codtesis;
	}

	public void setCodtesis(String codtesis) {
		this.codtesis = codtesis;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstuadiante() {
		return this.estuadiante;
	}

	public void setEstuadiante(String estuadiante) {
		this.estuadiante = estuadiante;
	}

	public Integer getIdpensum() {
		return this.idpensum;
	}

	public void setIdpensum(Integer idpensum) {
		this.idpensum = idpensum;
	}

	

	public String getMeses() {
		return this.meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ProyectoP getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getId_pub() {
		return id_pub;
	}

	public void setId_pub(String id_pub) {
		this.id_pub = id_pub;
	}

	public String getTipopresentacion() {
		return tipopresentacion;
	}

	public void setTipopresentacion(String tipopresentacion) {
		this.tipopresentacion = tipopresentacion;
	}

	public String getExpositor() {
		return expositor;
	}

	public void setExpositor(String expositor) {
		this.expositor = expositor;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public Date getFechapresenta() {
		return fechapresenta;
	}

	public void setFechapresenta(Date fechapresenta) {
		this.fechapresenta = fechapresenta;
	}

	public TipoProducto getTipo_producto() {
		return tipo_producto;
	}

	public void setTipo_producto(TipoProducto tipo_producto) {
		this.tipo_producto = tipo_producto;
	}

	public String getHv() {
		return hv;
	}

	public void setHv(String hv) {
		this.hv = hv;
	}

	public String getAutorexterno() {
		return autorexterno;
	}

	public void setAutorexterno(String autorexterno) {
		this.autorexterno = autorexterno;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPagini() {
		return pagini;
	}

	public void setPagini(String pagini) {
		this.pagini = pagini;
	}

	public String getPagfin() {
		return pagfin;
	}

	public void setPagfin(String pagfin) {
		this.pagfin = pagfin;
	}

	public String getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(String catalogo) {
		this.catalogo = catalogo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}