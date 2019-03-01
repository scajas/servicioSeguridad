package ec.edu.epn.gestionDocente.DTO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
public class ActividadAdministrativaDTO implements Serializable{

	

	private String idActAdm;
	private String nCed;
	private String idPeriodo;
	private String periodo;
	private String idCargoAdm;
	private Date fechaIniAdm;
	private Date fechaFinAdm;
	private int numHorasAdm;
	private int numHorasSemana;
	private String tipoAdm;
	private String nombAdm;
	private String descripAdm;

	private String sucesos = " ";

	// Atributos auxiliares
	private String auxFechaInicio;
	private String auxFechaFin;

	// estado y validacion
	private String estado;
	private String imagen;
	private String validacion;

	// subtabla
	private ArrayList<ActividadAdministrativaDTO> actAdminPorPeriodos;
	// aud
	private Date fecHoraSis;
	

	public ActividadAdministrativaDTO() {
		super();
	}

	public ActividadAdministrativaDTO(String idActAdm, String nCed,
			String idPeriodo, String periodo, String idCargoAdm,
			Date fechaIniAdm, Date fechaFinAdm, int numHorasAdm,
			int numHorasSemana, String tipoAdm, String nombAdm,
			String descripAdm, String estado, String imagen, String validacion,
			Date fecHoraSis) {
		super();
		this.idActAdm = idActAdm;
		this.nCed = nCed;
		this.idPeriodo = idPeriodo;
		this.periodo = periodo;
		this.idCargoAdm = idCargoAdm;
		this.fechaIniAdm = fechaIniAdm;
		this.fechaFinAdm = fechaFinAdm;
		this.numHorasAdm = numHorasAdm;
		this.numHorasSemana = numHorasSemana;
		this.tipoAdm = tipoAdm;
		this.nombAdm = nombAdm;
		this.descripAdm = descripAdm;
		this.estado = estado;
		this.imagen = imagen;
		this.validacion = validacion;
		this.fecHoraSis = fecHoraSis;
	}
	
	
	/**GETTERS AND SETTERS*/

	public String getIdActAdm() {
		return idActAdm;
	}

	public void setIdActAdm(String idActAdm) {
		this.idActAdm = idActAdm;
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

	public String getIdCargoAdm() {
		return idCargoAdm;
	}

	public void setIdCargoAdm(String idCargoAdm) {
		this.idCargoAdm = idCargoAdm;
	}

	public Date getFechaIniAdm() {
		return fechaIniAdm;
	}

	public void setFechaIniAdm(Date fechaIniAdm) {
		this.fechaIniAdm = fechaIniAdm;
	}

	public Date getFechaFinAdm() {
		return fechaFinAdm;
	}

	public void setFechaFinAdm(Date fechaFinAdm) {
		this.fechaFinAdm = fechaFinAdm;
	}

	public int getNumHorasAdm() {
		return numHorasAdm;
	}

	public void setNumHorasAdm(int numHorasAdm) {
		this.numHorasAdm = numHorasAdm;
	}

	public int getNumHorasSemana() {
		return numHorasSemana;
	}

	public void setNumHorasSemana(int numHorasSemana) {
		this.numHorasSemana = numHorasSemana;
	}

	public String getTipoAdm() {
		return tipoAdm;
	}

	public void setTipoAdm(String tipoAdm) {
		this.tipoAdm = tipoAdm;
	}

	public String getNombAdm() {
		return nombAdm;
	}

	public void setNombAdm(String nombAdm) {
		this.nombAdm = nombAdm;
	}

	public String getDescripAdm() {
		return descripAdm;
	}

	public void setDescripAdm(String descripAdm) {
		this.descripAdm = descripAdm;
	}

	public String getSucesos() {
		return sucesos;
	}

	public void setSucesos(String sucesos) {
		this.sucesos = sucesos;
	}

	public String getAuxFechaInicio() {
		return auxFechaInicio;
	}

	public void setAuxFechaInicio(String auxFechaInicio) {
		this.auxFechaInicio = auxFechaInicio;
	}

	public String getAuxFechaFin() {
		return auxFechaFin;
	}

	public void setAuxFechaFin(String auxFechaFin) {
		this.auxFechaFin = auxFechaFin;
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

	public ArrayList<ActividadAdministrativaDTO> getActAdminPorPeriodos() {
		return actAdminPorPeriodos;
	}

	public void setActAdminPorPeriodos(ArrayList<ActividadAdministrativaDTO> actAdminPorPeriodos) {
		this.actAdminPorPeriodos = actAdminPorPeriodos;
	}

	public Date getFecHoraSis() {
		return fecHoraSis;
	}

	public void setFecHoraSis(Date fecHoraSis) {
		this.fecHoraSis = fecHoraSis;
	}

	}
