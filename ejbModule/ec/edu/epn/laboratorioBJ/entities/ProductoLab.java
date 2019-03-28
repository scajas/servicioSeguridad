package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name = "producto", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="ProductoLab.findAll", query="SELECT p FROM ProductoLab p")
public class ProductoLab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name="id_producto")
	private String idProducto;
	
	
	@Column(name="aux_idprod")
	private Integer auxIdprod;

	@Column(name="colorriesgo_pr")
	private String colorriesgoPr;

	@Column(name="descr_pr")
	private String descrPr;

	@Column(name="formula_pr")
	private String formulaPr;

	@Column(name="iupac_pr")
	private String iupacPr;

	@Column(name="nombre_pr")
	private String nombrePr;

	@Column(name="precio_pr")
	private double precioPr;

	@Column(name="riesgo_pr")
	private String riesgoPr;

	@Column(name="riesgoinflamabilidad_pr")
	private String riesgoinflamabilidadPr;

	@Column(name="riesgoreactividad_pr")
	private String riesgoreactividadPr;

	@Column(name="riesgosalud_pr")
	private String riesgosaludPr;

	@Column(name="stock_pr")
	private double stockPr;

	@Column(name="stockcrt_pr")
	private double stockcrtPr;

	@Column(name="stockmin_pr")
	private double stockminPr;

	//bi-directional many-to-one association to Existencia
	@OneToMany(mappedBy="producto")
	private List<Existencia> existencias;

	//bi-directional many-to-one association to Riesgoespecifico
	@ManyToOne
	@JoinColumn(name="id_riesgoespecifico")
	private Riesgoespecifico riesgoespecifico;

	//bi-directional many-to-one association to Tipoproducto
	@ManyToOne
	@JoinColumn(name="id_tipoprod")
	private Tipoproducto tipoproducto;

	public ProductoLab() {
	}

	public String getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getAuxIdprod() {
		return this.auxIdprod;
	}

	public void setAuxIdprod(Integer auxIdprod) {
		this.auxIdprod = auxIdprod;
	}

	public String getColorriesgoPr() {
		return this.colorriesgoPr;
	}

	public void setColorriesgoPr(String colorriesgoPr) {
		this.colorriesgoPr = colorriesgoPr;
	}

	public String getDescrPr() {
		return this.descrPr;
	}

	public void setDescrPr(String descrPr) {
		this.descrPr = descrPr;
	}

	public String getFormulaPr() {
		return this.formulaPr;
	}

	public void setFormulaPr(String formulaPr) {
		this.formulaPr = formulaPr;
	}

	public String getIupacPr() {
		return this.iupacPr;
	}

	public void setIupacPr(String iupacPr) {
		this.iupacPr = iupacPr;
	}

	public String getNombrePr() {
		return this.nombrePr;
	}

	public void setNombrePr(String nombrePr) {
		this.nombrePr = nombrePr;
	}

	public double getPrecioPr() {
		return this.precioPr;
	}

	public void setPrecioPr(double precioPr) {
		this.precioPr = precioPr;
	}

	public String getRiesgoPr() {
		return this.riesgoPr;
	}

	public void setRiesgoPr(String riesgoPr) {
		this.riesgoPr = riesgoPr;
	}

	public String getRiesgoinflamabilidadPr() {
		return this.riesgoinflamabilidadPr;
	}

	public void setRiesgoinflamabilidadPr(String riesgoinflamabilidadPr) {
		this.riesgoinflamabilidadPr = riesgoinflamabilidadPr;
	}

	public String getRiesgoreactividadPr() {
		return this.riesgoreactividadPr;
	}

	public void setRiesgoreactividadPr(String riesgoreactividadPr) {
		this.riesgoreactividadPr = riesgoreactividadPr;
	}

	public String getRiesgosaludPr() {
		return this.riesgosaludPr;
	}

	public void setRiesgosaludPr(String riesgosaludPr) {
		this.riesgosaludPr = riesgosaludPr;
	}

	public double getStockPr() {
		return this.stockPr;
	}

	public void setStockPr(double stockPr) {
		this.stockPr = stockPr;
	}

	public double getStockcrtPr() {
		return this.stockcrtPr;
	}

	public void setStockcrtPr(double stockcrtPr) {
		this.stockcrtPr = stockcrtPr;
	}

	public double getStockminPr() {
		return this.stockminPr;
	}

	public void setStockminPr(double stockminPr) {
		this.stockminPr = stockminPr;
	}

	public List<Existencia> getExistencias() {
		return this.existencias;
	}

	public void setExistencias(List<Existencia> existencias) {
		this.existencias = existencias;
	}

	public Existencia addExistencia(Existencia existencia) {
		getExistencias().add(existencia);
		existencia.setProducto(this);

		return existencia;
	}

	public Existencia removeExistencia(Existencia existencia) {
		getExistencias().remove(existencia);
		existencia.setProducto(null);

		return existencia;
	}

	public Riesgoespecifico getRiesgoespecifico() {
		return this.riesgoespecifico;
	}

	public void setRiesgoespecifico(Riesgoespecifico riesgoespecifico) {
		this.riesgoespecifico = riesgoespecifico;
	}

	public Tipoproducto getTipoproducto() {
		return this.tipoproducto;
	}

	public void setTipoproducto(Tipoproducto tipoproducto) {
		this.tipoproducto = tipoproducto;
	}

}