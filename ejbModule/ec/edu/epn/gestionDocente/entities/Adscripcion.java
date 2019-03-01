package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the adscripcion database table.
 * 
 */
@Entity
@NamedQuery(name="Adscripcion.findAll", query="SELECT a FROM Adscripcion a")
public class Adscripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_adscrip")
	private String idAdscrip;

	@Column(name="descrip_adscrip")
	private String descripAdscrip;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_adscrip")
	private Date fechaFinAdscrip;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ini_adscrip")
	private Date fechaIniAdscrip;

	@Column(name="id_depart")
	private String idDepart;

	private String nced;

	@Column(name="num_docum")
	private Long numDocum;

	public Adscripcion() {
	}

	public String getIdAdscrip() {
		return this.idAdscrip;
	}

	public void setIdAdscrip(String idAdscrip) {
		this.idAdscrip = idAdscrip;
	}

	public String getDescripAdscrip() {
		return this.descripAdscrip;
	}

	public void setDescripAdscrip(String descripAdscrip) {
		this.descripAdscrip = descripAdscrip;
	}

	public Date getFechaFinAdscrip() {
		return this.fechaFinAdscrip;
	}

	public void setFechaFinAdscrip(Date fechaFinAdscrip) {
		this.fechaFinAdscrip = fechaFinAdscrip;
	}

	public Date getFechaIniAdscrip() {
		return this.fechaIniAdscrip;
	}

	public void setFechaIniAdscrip(Date fechaIniAdscrip) {
		this.fechaIniAdscrip = fechaIniAdscrip;
	}

	public String getIdDepart() {
		return this.idDepart;
	}

	public void setIdDepart(String idDepart) {
		this.idDepart = idDepart;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public Long getNumDocum() {
		return this.numDocum;
	}

	public void setNumDocum(Long numDocum) {
		this.numDocum = numDocum;
	}

}