package ec.edu.epn.acreditacion.reportes.dto;

import java.util.Date;

public class DocenteDistributivoDTO {

	private String nced;
	private String nombres;
	private String departamento;
	private String periodo;
	private String tipo;
	private String dedicacion;
	private String cargo;
	private Date fechaIni;
	private Date fechaFin;
	private String pais;
	private String universidad;
	private String nombreNivel;
	private String nivelTitulo;
	private String titulo;
	private String areaCon;
	private String regSenes;
	private String fechaReg;

	public DocenteDistributivoDTO() {
		super();

	}

	public DocenteDistributivoDTO(String nced, String nombres, String departamento, String periodo, String tipo,
			String dedicacion, String cargo, Date fechaIni, Date fechaFin, String pais, String universidad,
			String nombreNivel, String nivelTitulo, String titulo, String areaCon, String regSenes, String fechaReg) {
		super();
		this.nced = nced;
		this.nombres = nombres;
		this.departamento = departamento;
		this.periodo = periodo;
		this.tipo = tipo;
		this.dedicacion = dedicacion;
		this.cargo = cargo;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.pais = pais;
		this.universidad = universidad;
		this.nombreNivel = nombreNivel;
		this.nivelTitulo = nivelTitulo;
		this.titulo = titulo;
		this.areaCon = areaCon;
		this.regSenes = regSenes;
		this.fechaReg = fechaReg;
	}

	/**
	 * @return the nced
	 */
	public String getNced() {
		return nced;
	}

	/**
	 * @param nced
	 *            the nced to set
	 */
	public void setNced(String nced) {
		this.nced = nced;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param noombres
	 *            the noombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the departamento
	 */
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento
	 *            the departamento to set
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	/**
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo
	 *            the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the dedicacion
	 */
	public String getDedicacion() {
		return dedicacion;
	}

	/**
	 * @param dedicacion
	 *            the dedicacion to set
	 */
	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 *            the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the fechaIni
	 */
	public Date getFechaIni() {
		return fechaIni;
	}

	/**
	 * @param fechaIni
	 *            the fechaIni to set
	 */
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin
	 *            the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais
	 *            the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return the universidad
	 */
	public String getUniversidad() {
		return universidad;
	}

	/**
	 * @param universidad
	 *            the universidad to set
	 */
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	/**
	 * @return the nombreNivel
	 */
	public String getNombreNivel() {
		return nombreNivel;
	}

	/**
	 * @param nombreNivel
	 *            the nombreNivel to set
	 */
	public void setNombreNivel(String nombreNivel) {
		this.nombreNivel = nombreNivel;
	}

	/**
	 * @return the nivelTitulo
	 */
	public String getNivelTitulo() {
		return nivelTitulo;
	}

	/**
	 * @param nivelTitulo
	 *            the nivelTitulo to set
	 */
	public void setNivelTitulo(String nivelTitulo) {
		this.nivelTitulo = nivelTitulo;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the areaCon
	 */
	public String getAreaCon() {
		return areaCon;
	}

	/**
	 * @param areaCon
	 *            the areaCon to set
	 */
	public void setAreaCon(String areaCon) {
		this.areaCon = areaCon;
	}

	/**
	 * @return the regSenes
	 */
	public String getRegSenes() {
		return regSenes;
	}

	/**
	 * @param regSenes
	 *            the regSenes to set
	 */
	public void setRegSenes(String regSenes) {
		this.regSenes = regSenes;
	}

	/**
	 * @return the fechaReg
	 */
	public String getFechaReg() {
		return fechaReg;
	}

	/**
	 * @param fechaReg
	 *            the fechaReg to set
	 */
	public void setFechaReg(String fechaReg) {
		this.fechaReg = fechaReg;
	}

}
