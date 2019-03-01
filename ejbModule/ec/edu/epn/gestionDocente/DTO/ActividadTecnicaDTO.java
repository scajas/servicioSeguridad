package ec.edu.epn.gestionDocente.DTO;

import java.util.Date;


public class ActividadTecnicaDTO {
	
	private String idActTec;
	private String nCed;
	private String idPeriodo;
	private String periodo;
	private String nomActTec;
	private Date fecIniAT;
	private Date fecFinAT;
	private int horasSemAT;
	private int horasTotalAT;
	private String descrip;

	// otros
	private String auxFecIniAT;
	private String auxFecFinAT;

	// estado y validacion
	private String estado;
	private String imagen;
	private String validacion;


	public ActividadTecnicaDTO() {
		super();
	}

	public ActividadTecnicaDTO(String idActTec, String nCed, String nomActTec,
			Date fecIniAT, Date fecFinAT, int horasSemAT, int horasTotalAT,
			String descrip, String auxFecIniAT, String auxFecFinAT,
			String idPeriodo, String periodo, String estado, String imagen,
			String validacion) {
		super();
		this.idActTec = idActTec;
		this.nCed = nCed;
		this.nomActTec = nomActTec;
		this.fecIniAT = fecIniAT;
		this.fecFinAT = fecFinAT;
		this.horasSemAT = horasSemAT;
		this.horasTotalAT = horasTotalAT;
		this.descrip = descrip;
		this.auxFecIniAT = auxFecIniAT;
		this.auxFecFinAT = auxFecFinAT;
		this.idPeriodo = idPeriodo;
		this.periodo = periodo;
		this.estado = estado;
		this.imagen = imagen;
		this.validacion = validacion;
	}
	
	/**GETTERS AND SETTERS*/

	public String getIdActTec() {
		return idActTec;
	}

	public void setIdActTec(String idActTec) {
		this.idActTec = idActTec;
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

	public String getNomActTec() {
		return nomActTec;
	}

	public void setNomActTec(String nomActTec) {
		this.nomActTec = nomActTec;
	}

	public Date getFecIniAT() {
		return fecIniAT;
	}

	public void setFecIniAT(Date fecIniAT) {
		this.fecIniAT = fecIniAT;
	}

	public Date getFecFinAT() {
		return fecFinAT;
	}

	public void setFecFinAT(Date fecFinAT) {
		this.fecFinAT = fecFinAT;
	}

	public int getHorasSemAT() {
		return horasSemAT;
	}

	public void setHorasSemAT(int horasSemAT) {
		this.horasSemAT = horasSemAT;
	}

	public int getHorasTotalAT() {
		return horasTotalAT;
	}

	public void setHorasTotalAT(int horasTotalAT) {
		this.horasTotalAT = horasTotalAT;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getAuxFecIniAT() {
		return auxFecIniAT;
	}

	public void setAuxFecIniAT(String auxFecIniAT) {
		this.auxFecIniAT = auxFecIniAT;
	}

	public String getAuxFecFinAT() {
		return auxFecFinAT;
	}

	public void setAuxFecFinAT(String auxFecFinAT) {
		this.auxFecFinAT = auxFecFinAT;
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
