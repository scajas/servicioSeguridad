package ec.edu.epn.gestionDocente.DTO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



public class ActividadInvestigacionDTO implements Serializable{

	

	private String idActProy;
	private String idPeriodo;
	private String periodo;
	private String nCed;
	private String nomProy;
	private String rolProy;
	private Date fecIniP;
	private Date fecFinP;
	private int numHorasP;
	private String descripP;

	// otros
	private String auxFecIniP;
	private String auxFecFinP;

	// estado y validacion
	private String estado;
	private String imagen;
	private String validacion;
	private String sucesos = " ";
	
	

	public ActividadInvestigacionDTO() {
		super();
	}

	public ActividadInvestigacionDTO(String idActProy, String idPeriodo,
			String periodo, String nCed, String nomProy, String rolProy,
			Date fecIniP, Date fecFinP, int numHorasP, String descripP,
			String estado, String imagen, String validacion) {
		super();
		this.idActProy = idActProy;
		this.idPeriodo = idPeriodo;
		this.periodo = periodo;
		this.nCed = nCed;
		this.nomProy = nomProy;
		this.rolProy = rolProy;
		this.fecIniP = fecIniP;
		this.fecFinP = fecFinP;
		this.numHorasP = numHorasP;
		this.descripP = descripP;
		this.estado = estado;
		this.imagen = imagen;
		this.validacion = validacion;
	}
	
	/**GETTERS AND SETTERS*/

	public String getIdActProy() {
		return idActProy;
	}

	public void setIdActProy(String idActProy) {
		this.idActProy = idActProy;
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

	public String getNomProy() {
		return nomProy;
	}

	public void setNomProy(String nomProy) {
		this.nomProy = nomProy;
	}

	public String getRolProy() {
		return rolProy;
	}

	public void setRolProy(String rolProy) {
		this.rolProy = rolProy;
	}

	public Date getFecIniP() {
		return fecIniP;
	}

	public void setFecIniP(Date fecIniP) {
		this.fecIniP = fecIniP;
	}

	public Date getFecFinP() {
		return fecFinP;
	}

	public void setFecFinP(Date fecFinP) {
		this.fecFinP = fecFinP;
	}

	public int getNumHorasP() {
		return numHorasP;
	}

	public void setNumHorasP(int numHorasP) {
		this.numHorasP = numHorasP;
	}

	public String getDescripP() {
		return descripP;
	}

	public void setDescripP(String descripP) {
		this.descripP = descripP;
	}

	public String getAuxFecIniP() {
		return auxFecIniP;
	}

	public void setAuxFecIniP(String auxFecIniP) {
		this.auxFecIniP = auxFecIniP;
	}

	public String getAuxFecFinP() {
		return auxFecFinP;
	}

	public void setAuxFecFinP(String auxFecFinP) {
		this.auxFecFinP = auxFecFinP;
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

	public String getSucesos() {
		return sucesos;
	}

	public void setSucesos(String sucesos) {
		this.sucesos = sucesos;
	}

	
}
