package ec.edu.epn.gestionDocente.DTO;

import java.io.Serializable;
import java.util.Date;

public class HorasPeriodoAcademicoDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8835289164216940635L;
	private String nCed;
	private Date fechaInicioPeriodo;
	private Date fechaFinPeriodo;
	private String pensum;
	private Integer diasLaborables;
	private Integer diasDescanso;
	private Integer diasVacacion;
	private Integer diasPermiso;
	private Integer diasLabDesc;
	private Integer diasTotalLab;
	private Integer horasDedicacion;
	private Double promedioHorasDiaria;
	private Double horasPeriodoAcademico;
	private String dedicacion;
	private String tipo;
	private boolean dedicacionTP;
	private Double horasPermiso;
	private Double horasVacacion;
	/**
	 * @return the nCed
	 */
	public String getnCed() {
		return nCed;
	}
	/**
	 * @return the fechaInicioPeriodo
	 */
	public Date getFechaInicioPeriodo() {
		return fechaInicioPeriodo;
	}
	/**
	 * @return the fechaFinPeriodo
	 */
	public Date getFechaFinPeriodo() {
		return fechaFinPeriodo;
	}
	/**
	 * @return the pensum
	 */
	public String getPensum() {
		return pensum;
	}
	/**
	 * @return the diasLaborables
	 */
	public Integer getDiasLaborables() {
		return diasLaborables;
	}
	/**
	 * @return the diasVacacion
	 */
	public Integer getDiasVacacion() {
		return diasVacacion;
	}
	/**
	 * @return the diasPermiso
	 */
	public Integer getDiasPermiso() {
		return diasPermiso;
	}
	/**
	 * @return the horasDedicacion
	 */
	public Integer getHorasDedicacion() {
		return horasDedicacion;
	}
	/**
	 * @return the promedioHorasDiaria
	 */
	public Double getPromedioHorasDiaria() {
		return promedioHorasDiaria;
	}
	/**
	 * @return the horasPeriodoAcademico
	 */
	public Double getHorasPeriodoAcademico() {
		return horasPeriodoAcademico;
	}
	/**
	 * @param nCed the nCed to set
	 */
	public void setnCed(String nCed) {
		this.nCed = nCed;
	}
	/**
	 * @param fechaInicioPeriodo the fechaInicioPeriodo to set
	 */
	public void setFechaInicioPeriodo(Date fechaInicioPeriodo) {
		this.fechaInicioPeriodo = fechaInicioPeriodo;
	}
	/**
	 * @param fechaFinPeriodo the fechaFinPeriodo to set
	 */
	public void setFechaFinPeriodo(Date fechaFinPeriodo) {
		this.fechaFinPeriodo = fechaFinPeriodo;
	}
	/**
	 * @param pensum the pensum to set
	 */
	public void setPensum(String pensum) {
		this.pensum = pensum;
	}
	/**
	 * @param diasLaborables the diasLaborables to set
	 */
	public void setDiasLaborables(Integer diasLaborables) {
		this.diasLaborables = diasLaborables;
	}
	/**
	 * @param diasVacacion the diasVacacion to set
	 */
	public void setDiasVacacion(Integer diasVacacion) {
		this.diasVacacion = diasVacacion;
	}
	/**
	 * @param diasPermiso the diasPermiso to set
	 */
	public void setDiasPermiso(Integer diasPermiso) {
		this.diasPermiso = diasPermiso;
	}
	/**
	 * @param horasDedicacion the horasDedicacion to set
	 */
	public void setHorasDedicacion(Integer horasDedicacion) {
		this.horasDedicacion = horasDedicacion;
	}
	/**
	 * @param promedioHorasDiaria the promedioHorasDiaria to set
	 */
	public void setPromedioHorasDiaria(Double promedioHorasDiaria) {
		this.promedioHorasDiaria = promedioHorasDiaria;
	}
	/**
	 * @param horasPeriodoAcademico the horasPeriodoAcademico to set
	 */
	public void setHorasPeriodoAcademico(Double horasPeriodoAcademico) {
		this.horasPeriodoAcademico = horasPeriodoAcademico;
	}
	/**
	 * @return the dedicacion
	 */
	public String getDedicacion() {
		return dedicacion;
	}
	
	/**
	 * @param dedicacion the dedicacion to set
	 */
	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the diasDescanso
	 */
	public Integer getDiasDescanso() {
		return diasDescanso;
	}
	/**
	 * @param diasDescanso the diasDescanso to set
	 */
	public void setDiasDescanso(Integer diasDescanso) {
		this.diasDescanso = diasDescanso;
	}
	/**
	 * @return the dedicacionTP
	 */
	public boolean isDedicacionTP() {
		return dedicacionTP;
	}
	/**
	 * @param dedicacionTP the dedicacionTP to set
	 */
	public void setDedicacionTP(boolean dedicacionTP) {
		this.dedicacionTP = dedicacionTP;
	}
	/**
	 * @return the diasLabDesc
	 */
	public Integer getDiasLabDesc() {
		return diasLabDesc;
	}
	/**
	 * @return the diasTotalLab
	 */
	public Integer getDiasTotalLab() {
		return diasTotalLab;
	}
	/**
	 * @param diasLabDesc the diasLabDesc to set
	 */
	public void setDiasLabDesc(Integer diasLabDesc) {
		this.diasLabDesc = diasLabDesc;
	}
	/**
	 * @param diasTotalLab the diasTotalLab to set
	 */
	public void setDiasTotalLab(Integer diasTotalLab) {
		this.diasTotalLab = diasTotalLab;
	}
	/**
	 * @return the horasPermiso
	 */
	public Double getHorasPermiso() {
		return horasPermiso;
	}
	/**
	 * @return the horasVacacion
	 */
	public Double getHorasVacacion() {
		return horasVacacion;
	}
	/**
	 * @param horasPermiso the horasPermiso to set
	 */
	public void setHorasPermiso(Double horasPermiso) {
		this.horasPermiso = horasPermiso;
	}
	/**
	 * @param horasVacacion the horasVacacion to set
	 */
	public void setHorasVacacion(Double horasVacacion) {
		this.horasVacacion = horasVacacion;
	}
	
	
	
	
	
}