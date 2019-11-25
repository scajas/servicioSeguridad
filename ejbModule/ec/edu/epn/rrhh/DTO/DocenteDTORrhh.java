package ec.edu.epn.rrhh.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class DocenteDTORrhh implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8874718821598902077L;
	private String nCed;
	private String apel;
	private String nombre;
	private String cargo;
	private Date fechaIngresoEPN;
	private Date fechaIngresoSP;;
	private String relacionLab;

	private ArrayList<DocenteDTORrhh> docentesArray;
	private int idUsuario;

	// OTROS
	private String idFacultad;
	private String nomFacultad;
	private String idDepartamento;
	private String nomDepartamento;
	private String dedicacion;
	private String categoria;
	private String auxFechaIngresoEPN;

	private String fechaContrat;

	private String idPeriodo;
	
	private String nroDocumento;
	
	private Date fechaRige;
	
	private Date fechaFin;
	
	private Double remreal;

	public DocenteDTORrhh() {
		super();
	}

	public DocenteDTORrhh(String nCed, String apel, String nombre, String cargo, int idUsuario, String idFacultad,
			String nomFacultad, String idDepartamento, String nomDepartamento, String dedicacion, String categoria,
			Date fechaIngresoEPN, String auxFechaIngresoEPN, String relacionLab) {
		super();
		this.nCed = nCed;
		this.apel = apel;
		this.nombre = nombre;
		this.cargo = cargo;
		this.idUsuario = idUsuario;
		this.idFacultad = idFacultad;
		this.nomFacultad = nomFacultad;
		this.idDepartamento = idDepartamento;
		this.nomDepartamento = nomDepartamento;
		this.dedicacion = dedicacion;
		this.categoria = categoria;
		this.fechaIngresoEPN = fechaIngresoEPN;
		this.auxFechaIngresoEPN = auxFechaIngresoEPN;
		this.relacionLab = relacionLab;
	}

	public String getnCed() {
		return nCed;
	}

	public void setnCed(String nCed) {
		this.nCed = nCed;
	}

	public String getApel() {
		return apel;
	}

	public void setApel(String apel) {
		this.apel = apel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getFechaIngresoEPN() {
		return fechaIngresoEPN;
	}

	public void setFechaIngresoEPN(Date fechaIngresoEPN) {
		this.fechaIngresoEPN = fechaIngresoEPN;
	}

	public Date getFechaIngresoSP() {
		return fechaIngresoSP;
	}

	public void setFechaIngresoSP(Date fechaIngresoSP) {
		this.fechaIngresoSP = fechaIngresoSP;
	}

	public String getRelacionLab() {
		return relacionLab;
	}

	public void setRelacionLab(String relacionLab) {
		this.relacionLab = relacionLab;
	}

	public ArrayList<DocenteDTORrhh> getDocentesArray() {
		return docentesArray;
	}

	public void setDocentesArray(ArrayList<DocenteDTORrhh> docentesArray) {
		this.docentesArray = docentesArray;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getNomFacultad() {
		return nomFacultad;
	}

	public void setNomFacultad(String nomFacultad) {
		this.nomFacultad = nomFacultad;
	}

	public String getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNomDepartamento() {
		return nomDepartamento;
	}

	public void setNomDepartamento(String nomDepartamento) {
		this.nomDepartamento = nomDepartamento;
	}

	public String getDedicacion() {
		return dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getAuxFechaIngresoEPN() {
		return auxFechaIngresoEPN;
	}

	public void setAuxFechaIngresoEPN(String auxFechaIngresoEPN) {
		this.auxFechaIngresoEPN = auxFechaIngresoEPN;
	}

	public String getFechaContrat() {
		return fechaContrat;
	}

	public void setFechaContrat(String fechaContrat) {
		this.fechaContrat = fechaContrat;
	}

	public String getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(String idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public Date getFechaRige() {
		return fechaRige;
	}

	public void setFechaRige(Date fechaRige) {
		this.fechaRige = fechaRige;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Double getRemreal() {
		return remreal;
	}

	public void setRemreal(Double remreal) {
		this.remreal = remreal;
	}

	
}
