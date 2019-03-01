package ec.edu.epn.gestionDocente.DTO;

import java.util.Date;

public class TesisCalificadasDTO {

	

	/** Atributos del Objeto **/
	private String idTesisC;
	private String idPeriodo;
	private String periodo;
	private String nCed;
	private String temaTesisC;
	private Date fechaCalif;
	private String nivel;
	private String carrera;
	private int numHorasDedic;
	private String descripTC;

	/** OTROS */
	private String auxFechaCalif;

	/** ATRIBUTOS ADICIONALES **/	
	private int scrollerPage;

	/** ESTADO Y VALIDACION*/
	private String estado;
	private String imagen;
	private String validacion;	

	public TesisCalificadasDTO() {
		super();
	}

	public TesisCalificadasDTO(String idTesisC, String idPeriodo,
			String periodo, String nCed, String temaTesisC, Date fechaCalif,
			String nivel, String carrera, int numHorasDedic, String descripTC,
			String estado, String imagen, String validacion) {
		super();
		this.idTesisC = idTesisC;
		this.idPeriodo = idPeriodo;
		this.periodo = periodo;
		this.nCed = nCed;
		this.temaTesisC = temaTesisC;
		this.fechaCalif = fechaCalif;
		this.nivel = nivel;
		this.carrera = carrera;
		this.numHorasDedic = numHorasDedic;
		this.descripTC = descripTC;
		this.estado = estado;
		this.imagen = imagen;
		this.validacion = validacion;
	}
	
	/**GETTERS AND SETTERS*/

	public String getIdTesisC() {
		return idTesisC;
	}

	public void setIdTesisC(String idTesisC) {
		this.idTesisC = idTesisC;
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

	public String getnCed() {
		return nCed;
	}

	public void setnCed(String nCed) {
		this.nCed = nCed;
	}

	public String getTemaTesisC() {
		return temaTesisC;
	}

	public void setTemaTesisC(String temaTesisC) {
		this.temaTesisC = temaTesisC;
	}

	public Date getFechaCalif() {
		return fechaCalif;
	}

	public void setFechaCalif(Date fechaCalif) {
		this.fechaCalif = fechaCalif;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public int getNumHorasDedic() {
		return numHorasDedic;
	}

	public void setNumHorasDedic(int numHorasDedic) {
		this.numHorasDedic = numHorasDedic;
	}

	public String getDescripTC() {
		return descripTC;
	}

	public void setDescripTC(String descripTC) {
		this.descripTC = descripTC;
	}

	public String getAuxFechaCalif() {
		return auxFechaCalif;
	}

	public void setAuxFechaCalif(String auxFechaCalif) {
		this.auxFechaCalif = auxFechaCalif;
	}

	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
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
