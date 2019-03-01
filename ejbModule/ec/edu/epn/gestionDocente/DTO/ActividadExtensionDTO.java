package ec.edu.epn.gestionDocente.DTO;

import java.io.Serializable;
import java.util.Date;


public class ActividadExtensionDTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 359265737041364788L;
	private String idActivExt;
	private String nCed;
	private String idPeriodo;
	private String periodo;
	private String idTipoExt;
	private int numHorasExt;
	private String nombreAE;
	private String ocupacion;
	private Date fechaAE;
	private String cliente;
	private String ordenTrab;
	private String descripAE;	

	private String auxFecAE;

	// estado y validacion
	private String estado;
	private String imagen;
	private String validacion;

	
	/** Constructores **/
	public ActividadExtensionDTO() {
		super();
	}

	public ActividadExtensionDTO(String idActivExt, String nCed,
			String idPeriodo, String idTipoExt, int numHorasExt,
			String nombreAE, String ocupacion, Date fechaAE, String cliente,
			String ordenTrab, String descripAE, String periodo, String estado,
			String imagen, String validacion) {
		super();
		this.idActivExt = idActivExt;
		this.nCed = nCed;
		this.idPeriodo = idPeriodo;
		this.idTipoExt = idTipoExt;
		this.numHorasExt = numHorasExt;
		this.nombreAE = nombreAE;
		this.ocupacion = ocupacion;
		this.fechaAE = fechaAE;
		this.cliente = cliente;
		this.ordenTrab = ordenTrab;
		this.descripAE = descripAE;
		this.periodo = periodo;
		this.estado = estado;
		this.imagen = imagen;
		this.validacion = validacion;
	}
	
	/**GETTERS AND SETTERS*/

	public String getIdActivExt() {
		return idActivExt;
	}

	public void setIdActivExt(String idActivExt) {
		this.idActivExt = idActivExt;
	}

	public String getnCed() {
		return nCed;
	}

	public void setnCed(String nCed) {
		this.nCed = nCed;
	}

	public String getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(String idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getIdTipoExt() {
		return idTipoExt;
	}

	public void setIdTipoExt(String idTipoExt) {
		this.idTipoExt = idTipoExt;
	}

	public int getNumHorasExt() {
		return numHorasExt;
	}

	public void setNumHorasExt(int numHorasExt) {
		this.numHorasExt = numHorasExt;
	}

	public String getNombreAE() {
		return nombreAE;
	}

	public void setNombreAE(String nombreAE) {
		this.nombreAE = nombreAE;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Date getFechaAE() {
		return fechaAE;
	}

	public void setFechaAE(Date fechaAE) {
		this.fechaAE = fechaAE;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getOrdenTrab() {
		return ordenTrab;
	}

	public void setOrdenTrab(String ordenTrab) {
		this.ordenTrab = ordenTrab;
	}

	public String getDescripAE() {
		return descripAE;
	}

	public void setDescripAE(String descripAE) {
		this.descripAE = descripAE;
	}

	public String getAuxFecAE() {
		return auxFecAE;
	}

	public void setAuxFecAE(String auxFecAE) {
		this.auxFecAE = auxFecAE;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getValidacion() {
		return validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

}
