package ec.edu.epn.gestionDocente.DTO;

import java.io.Serializable;
import java.util.Date;


public class CapacitacionDTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3574385754496084840L;
	private String idCapac;
	private String idPeriodo;
	private String periodo;
	private String nCed;
	private String nomCapac;
	private Date fechaIniCapac;
	private Date fechaFinCapac;
	private int horasCapac;
	private String conteCapac;
	private String lugarCapac;
	private String facilCapac;
	private String metodCapac;
	private String obsCapac;
	private String claseCapac;
	private String dirigidoA;
	private String paisCapac;
	private String docObtenido;
	private String mencion;

	// otros
	private String auxFecIniC;
	private String auxFecFinC;
	private String sucesos = " ";

	// estado y validacion
	private String estado;
	private String imagen;
	private String validacion;

	/** Estilo de los mensajes */
	// style del mensaje success
	private String style;
	private String styleSuccess = "COLOR: #0000FF;";
	private String styleError = "COLOR: #fc5868;";

	public CapacitacionDTO() {
	}

	public CapacitacionDTO(String nCed, String idCapac, String nomCapac,
			Date fechaIniCapac, Date fechaFinCapac, int horasCapac,
			String conteCapac, String lugarCapac, String facilCapac,
			String metodCapac, String obsCapac, String claseCapac,
			String idPeriodo, String periodo, String dirigidoA, String estado,
			String imagen, String validacion, String paisCapac,
			String docObtenido, String mencion) {

		this.nCed = nCed;
		this.idCapac = idCapac;
		this.nomCapac = nomCapac;
		this.fechaIniCapac = fechaIniCapac;
		this.fechaFinCapac = fechaFinCapac;
		this.horasCapac = horasCapac;
		this.conteCapac = conteCapac;
		this.lugarCapac = lugarCapac;
		this.facilCapac = facilCapac;
		this.metodCapac = metodCapac;
		this.obsCapac = obsCapac;
		this.claseCapac = claseCapac;
		this.idPeriodo = idPeriodo;
		this.periodo = periodo;
		this.dirigidoA = dirigidoA;
		this.estado = estado;
		this.imagen = imagen;
		this.validacion = validacion;
		this.paisCapac = paisCapac;
		this.docObtenido = docObtenido;
		this.mencion = mencion;
	}
	
	/**GETTERS AND SETTERS*/

	public String getIdCapac() {
		return idCapac;
	}

	public void setIdCapac(String idCapac) {
		this.idCapac = idCapac;
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

	public String getNomCapac() {
		return nomCapac;
	}

	public void setNomCapac(String nomCapac) {
		this.nomCapac = nomCapac;
	}

	public Date getFechaIniCapac() {
		return fechaIniCapac;
	}

	public void setFechaIniCapac(Date fechaIniCapac) {
		this.fechaIniCapac = fechaIniCapac;
	}

	public Date getFechaFinCapac() {
		return fechaFinCapac;
	}

	public void setFechaFinCapac(Date fechaFinCapac) {
		this.fechaFinCapac = fechaFinCapac;
	}

	public int getHorasCapac() {
		return horasCapac;
	}

	public void setHorasCapac(int horasCapac) {
		this.horasCapac = horasCapac;
	}

	public String getConteCapac() {
		return conteCapac;
	}

	public void setConteCapac(String conteCapac) {
		this.conteCapac = conteCapac;
	}

	public String getLugarCapac() {
		return lugarCapac;
	}

	public void setLugarCapac(String lugarCapac) {
		this.lugarCapac = lugarCapac;
	}

	public String getFacilCapac() {
		return facilCapac;
	}

	public void setFacilCapac(String facilCapac) {
		this.facilCapac = facilCapac;
	}

	public String getMetodCapac() {
		return metodCapac;
	}

	public void setMetodCapac(String metodCapac) {
		this.metodCapac = metodCapac;
	}

	public String getObsCapac() {
		return obsCapac;
	}

	public void setObsCapac(String obsCapac) {
		this.obsCapac = obsCapac;
	}

	public String getClaseCapac() {
		return claseCapac;
	}

	public void setClaseCapac(String claseCapac) {
		this.claseCapac = claseCapac;
	}

	public String getDirigidoA() {
		return dirigidoA;
	}

	public void setDirigidoA(String dirigidoA) {
		this.dirigidoA = dirigidoA;
	}

	public String getPaisCapac() {
		return paisCapac;
	}

	public void setPaisCapac(String paisCapac) {
		this.paisCapac = paisCapac;
	}

	public String getDocObtenido() {
		return docObtenido;
	}

	public void setDocObtenido(String docObtenido) {
		this.docObtenido = docObtenido;
	}

	public String getMencion() {
		return mencion;
	}

	public void setMencion(String mencion) {
		this.mencion = mencion;
	}

	public String getAuxFecIniC() {
		return auxFecIniC;
	}

	public void setAuxFecIniC(String auxFecIniC) {
		this.auxFecIniC = auxFecIniC;
	}

	public String getAuxFecFinC() {
		return auxFecFinC;
	}

	public void setAuxFecFinC(String auxFecFinC) {
		this.auxFecFinC = auxFecFinC;
	}

	public String getSucesos() {
		return sucesos;
	}

	public void setSucesos(String sucesos) {
		this.sucesos = sucesos;
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

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getStyleSuccess() {
		return styleSuccess;
	}

	public void setStyleSuccess(String styleSuccess) {
		this.styleSuccess = styleSuccess;
	}

	public String getStyleError() {
		return styleError;
	}

	public void setStyleError(String styleError) {
		this.styleError = styleError;
	}

	

}
