package ec.edu.epn.rrhh.DTO;

import ec.edu.epn.rrhh.entities.TipoEquipo;

public class EquipoDTO {
	private String numCedula;
	private String equipo;
	private String modelo;
	private String numSerie;
	private String codBienes;
	private TipoEquipo tipoEquipo;
	private String nombreCustodio;
	private String nombreTipo;
	private String nombreFacultad;
	private String nombreLaboratorio;
	private String fechaAsignacion;
	private String nroContrato;
	private String nombreEmp;
	private Integer anioAdquisicion;
	private Integer idEquipo;
	private String nombreDepartamento;
	private String tipoPersona;
	private String tipoContrato;
	private String dedicacionCustodio;

	public EquipoDTO() {

	}

	public EquipoDTO(String numCedula, String equipo, String modelo, String numSerie, String codBienes,
			TipoEquipo tipoEquipo, String nombreCustodio, String nombreTipo, String nombreFacultad,
			String nombreLaboratorio, String nroContrato, String nombreEmp, Integer anioAdquisicion, Integer idEquipo,
			String nombreDepartamento, String tipoPersona, String tipoContrato, String dedicacionCustodio) {
		super();
		this.numCedula = numCedula;
		this.equipo = equipo;
		this.modelo = modelo;
		this.numSerie = numSerie;
		this.codBienes = codBienes;
		this.tipoEquipo = tipoEquipo;
		this.nombreCustodio = nombreCustodio;
		this.nombreTipo = nombreTipo;
		this.nombreFacultad = nombreFacultad;
		this.nombreLaboratorio = nombreLaboratorio;
		this.nroContrato = nroContrato;
		this.nombreEmp = nombreEmp;
		this.anioAdquisicion = anioAdquisicion;
		this.idEquipo = idEquipo;
		this.nombreDepartamento = nombreDepartamento;
		this.tipoPersona = tipoPersona;
		this.tipoContrato = tipoContrato;
		this.dedicacionCustodio = dedicacionCustodio;

	}

	/**
	 * @return the numCedula
	 */
	public String getNumCedula() {
		return numCedula;
	}

	/**
	 * @param numCedula
	 *            the numCedula to set
	 */
	public void setNumCedula(String numCedula) {
		this.numCedula = numCedula;
	}

	/**
	 * @return the equipo
	 */
	public String getEquipo() {
		return equipo;
	}

	/**
	 * @param equipo
	 *            the equipo to set
	 */
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo
	 *            the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the numSerie
	 */
	public String getNumSerie() {
		return numSerie;
	}

	/**
	 * @param numSerie
	 *            the numSerie to set
	 */
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	/**
	 * @return the codBienes
	 */
	public String getCodBienes() {
		return codBienes;
	}

	/**
	 * @param codBienes
	 *            the codBienes to set
	 */
	public void setCodBienes(String codBienes) {
		this.codBienes = codBienes;
	}

	/**
	 * @return the nombreCustodio
	 */
	public String getNombreCustodio() {
		return nombreCustodio;
	}

	/**
	 * @param nombreCustodio
	 *            the nombreCustodio to set
	 */
	public void setNombreCustodio(String nombreCustodio) {
		this.nombreCustodio = nombreCustodio;
	}

	/**
	 * @return the tipoEquipo
	 */
	public TipoEquipo getTipoEquipo() {
		return tipoEquipo;
	}

	/**
	 * @param tipoEquipo
	 *            the tipoEquipo to set
	 */
	public void setTipoEquipo(TipoEquipo tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}

	/**
	 * @return the nombreTipo
	 */
	public String getNombreTipo() {
		return nombreTipo;
	}

	/**
	 * @param nombreTipo
	 *            the nombreTipo to set
	 */
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	/**
	 * @return the nombreLaboratorio
	 */
	public String getNombreLaboratorio() {
		return nombreLaboratorio;
	}

	/**
	 * @param nombreLaboratorio
	 *            the nombreLaboratorio to set
	 */
	public void setNombreLaboratorio(String nombreLaboratorio) {
		this.nombreLaboratorio = nombreLaboratorio;
	}

	/**
	 * @return the nombreFacultad
	 */
	public String getNombreFacultad() {
		return nombreFacultad;
	}

	/**
	 * @param nombreFacultad
	 *            the nombreFacultad to set
	 */
	public void setNombreFacultad(String nombreFacultad) {
		this.nombreFacultad = nombreFacultad;
	}

	/**
	 * @return the fechaAsignacion
	 */
	public String getFechaAsignacion() {
		return fechaAsignacion;
	}

	/**
	 * @param fechaAsignacion
	 *            the fechaAsignacion to set
	 */
	public void setFechaAsignacion(String fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public String getNroContrato() {
		return nroContrato;
	}

	public void setNroContrato(String nroContrato) {
		this.nroContrato = nroContrato;
	}

	public String getNombreEmp() {
		return nombreEmp;
	}

	public void setNombreEmp(String nombreEmp) {
		this.nombreEmp = nombreEmp;
	}

	/**
	 * @return the anioAdquisicion
	 */
	public Integer getAnioAdquisicion() {
		return anioAdquisicion;
	}

	/**
	 * @param anioAdquisicion
	 *            the anioAdquisicion to set
	 */
	public void setAnioAdquisicion(Integer anioAdquisicion) {
		this.anioAdquisicion = anioAdquisicion;
	}

	/**
	 * @return the idEquipo
	 */
	public Integer getIdEquipo() {
		return idEquipo;
	}

	/**
	 * @param idEquipo
	 *            the idEquipo to set
	 */
	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	/**
	 * @return the nombreDepartamento
	 */
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	/**
	 * @param nombreDepartamento
	 *            the nombreDepartamento to set
	 */
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	/**
	 * @return the tipoPersona
	 */
	public String getTipoPersona() {
		return tipoPersona;
	}

	/**
	 * @param tipoPersona
	 *            the tipoPersona to set
	 */
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	/**
	 * @return the tipoContrato
	 */
	public String getTipoContrato() {
		return tipoContrato;
	}

	/**
	 * @param tipoContrato
	 *            the tipoContrato to set
	 */
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	/**
	 * @return the dedicacionCustodio
	 */
	public String getDedicacionCustodio() {
		return dedicacionCustodio;
	}

	/**
	 * @param dedicacionCustodio
	 *            the dedicacionCustodio to set
	 */
	public void setDedicacionCustodio(String dedicacionCustodio) {
		this.dedicacionCustodio = dedicacionCustodio;
	}

}
