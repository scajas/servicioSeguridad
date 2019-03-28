package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the metodo database table.
 * 
 */
@Entity
@NamedQuery(name="Metodo.findAll", query="SELECT m FROM Metodo m")
public class Metodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_metodo")
	private String idMetodo;

	@Column(name="aux_idmetodo")
	private Integer auxIdmetodo;

	@Column(name="certificado_mt")
	private String certificadoMt;

	@Column(name="descr_mt")
	private String descrMt;

	@Column(name="nombre_mt")
	private String nombreMt;

	//bi-directional many-to-one association to DetalleProforma
	@OneToMany(mappedBy="metodo")
	private List<DetalleProforma> detalleProformas;

	//bi-directional many-to-one association to Detallemetodo
	@OneToMany(mappedBy="metodo")
	private List<Detallemetodo> detallemetodos;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="id_servicio")
	private Servicio servicio;

	public Metodo() {
	}

	public String getIdMetodo() {
		return this.idMetodo;
	}

	public void setIdMetodo(String idMetodo) {
		this.idMetodo = idMetodo;
	}

	public Integer getAuxIdmetodo() {
		return this.auxIdmetodo;
	}

	public void setAuxIdmetodo(Integer auxIdmetodo) {
		this.auxIdmetodo = auxIdmetodo;
	}

	public String getCertificadoMt() {
		return this.certificadoMt;
	}

	public void setCertificadoMt(String certificadoMt) {
		this.certificadoMt = certificadoMt;
	}

	public String getDescrMt() {
		return this.descrMt;
	}

	public void setDescrMt(String descrMt) {
		this.descrMt = descrMt;
	}

	public String getNombreMt() {
		return this.nombreMt;
	}

	public void setNombreMt(String nombreMt) {
		this.nombreMt = nombreMt;
	}

	public List<DetalleProforma> getDetalleProformas() {
		return this.detalleProformas;
	}

	public void setDetalleProformas(List<DetalleProforma> detalleProformas) {
		this.detalleProformas = detalleProformas;
	}

	public DetalleProforma addDetalleProforma(DetalleProforma detalleProforma) {
		getDetalleProformas().add(detalleProforma);
		detalleProforma.setMetodo(this);

		return detalleProforma;
	}

	public DetalleProforma removeDetalleProforma(DetalleProforma detalleProforma) {
		getDetalleProformas().remove(detalleProforma);
		detalleProforma.setMetodo(null);

		return detalleProforma;
	}

	public List<Detallemetodo> getDetallemetodos() {
		return this.detallemetodos;
	}

	public void setDetallemetodos(List<Detallemetodo> detallemetodos) {
		this.detallemetodos = detallemetodos;
	}

	public Detallemetodo addDetallemetodo(Detallemetodo detallemetodo) {
		getDetallemetodos().add(detallemetodo);
		detallemetodo.setMetodo(this);

		return detallemetodo;
	}

	public Detallemetodo removeDetallemetodo(Detallemetodo detallemetodo) {
		getDetallemetodos().remove(detallemetodo);
		detallemetodo.setMetodo(null);

		return detallemetodo;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}