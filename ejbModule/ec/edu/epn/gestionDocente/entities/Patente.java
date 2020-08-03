package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the patentes database table.
 * 
 */
@Entity
@Table(name="patentes", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name="Patente.findAll", query="SELECT p FROM Patente p")
public class Patente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_patente")
	private Integer idPatente;

	@Column(name="codigo_iepi")
	private String codigoIepi;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_p")
	private Date fechaP;

	private String nced;

	@Column(name="nombre_p")
	private String nombreP;

	private String observaciones;

	private String valida;
	
	private String validarevalorazion ;
	private Date  fechavalidarevaloriacion;
	private String validarecategorza;
	private Date fechavalidarecategoriza;
	private String url;
	
	private String pathobrarel;
	private String   clase;
	
	@ManyToOne
	@JoinColumn(name = "id_periodo")
	private Periodo periodo;

	public Patente() {
	}

	public Integer getIdPatente() {
		return this.idPatente;
	}

	public void setIdPatente(Integer idPatente) {
		this.idPatente = idPatente;
	}

	public String getCodigoIepi() {
		return this.codigoIepi;
	}

	public void setCodigoIepi(String codigoIepi) {
		this.codigoIepi = codigoIepi;
	}

	public Date getFechaP() {
		return this.fechaP;
	}

	public void setFechaP(Date fechaP) {
		this.fechaP = fechaP;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombreP() {
		return this.nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getValida() {
		return this.valida;
	}

	public void setValida(String valida) {
		this.valida = valida;
	}

	public String getValidarevalorazion() {
		return validarevalorazion;
	}

	public void setValidarevalorazion(String validarevalorazion) {
		this.validarevalorazion = validarevalorazion;
	}

	public Date getFechavalidarevaloriacion() {
		return fechavalidarevaloriacion;
	}

	public void setFechavalidarevaloriacion(Date fechavalidarevaloriacion) {
		this.fechavalidarevaloriacion = fechavalidarevaloriacion;
	}

	public String getValidarecategorza() {
		return validarecategorza;
	}

	public void setValidarecategorza(String validarecategorza) {
		this.validarecategorza = validarecategorza;
	}

	public Date getFechavalidarecategoriza() {
		return fechavalidarecategoriza;
	}

	public void setFechavalidarecategoriza(Date fechavalidarecategoriza) {
		this.fechavalidarecategoriza = fechavalidarecategoriza;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPathobrarel() {
		return pathobrarel;
	}

	public void setPathobrarel(String pathobrarel) {
		this.pathobrarel = pathobrarel;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	/**
	 * @return the periodo
	 */
	public Periodo getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

}