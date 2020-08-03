package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the infoactividad database table.
 * 
 */
@Entity
@Table(name = "infoactividad", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name = "Infoactividad.findAll", query = "SELECT i FROM Infoactividad i")
public class Infoactividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id

	private Integer id;

	private String nced;

	private String url1;

	private String url2;

	private Double nota;
	private String observacion;
	private Date fecha;
	private Integer idrecategoriza;
	private String categoria;
	private String proceso;

	public Infoactividad() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getUrl1() {
		return this.url1;
	}

	public void setUrl1(String url1) {
		this.url1 = url1;
	}

	public String getUrl2() {
		return this.url2;
	}

	public void setUrl2(String url2) {
		this.url2 = url2;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIdrecategoriza() {
		return idrecategoriza;
	}

	public void setIdrecategoriza(Integer idrecategoriza) {
		this.idrecategoriza = idrecategoriza;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

}