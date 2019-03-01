package ec.edu.epn.contratos.DTO;

import java.io.Serializable;
import java.util.Date;

public class CargaAcademicaWS implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idCarga;

	private Integer numHorasModulo;

	private Integer numHorasSemana;

	private String codMatSAE;

	private String nomMatSAE;

	private String idCarreraSaew;

	private String nomCarreraSaew;

	private Date fechaInicio;

	private Date fechaFin;

	public String getNomCarreraSaew() {
		return nomCarreraSaew;
	}

	public void setNomCarreraSaew(String nomCarreraSaew) {
		this.nomCarreraSaew = nomCarreraSaew;
	}

	public String getIdCarreraSaew() {
		return idCarreraSaew;
	}

	public void setIdCarreraSaew(String idCarreraSaew) {
		this.idCarreraSaew = idCarreraSaew;
	}

	public String getNomMatSAE() {
		return nomMatSAE;
	}

	public void setNomMatSAE(String nomMatSAE) {
		this.nomMatSAE = nomMatSAE;
	}

	public String getCodMatSAE() {
		return codMatSAE;
	}

	public void setCodMatSAE(String codMatSAE) {
		this.codMatSAE = codMatSAE;
	}


	private String paralelo;


	public CargaAcademicaWS() {
	}

	public Integer getIdCarga() {
		return this.idCarga;
	}

	public void setIdCarga(Integer idCarga) {
		this.idCarga = idCarga;
	}

	public Integer getNumHorasModulo() {
		return this.numHorasModulo;
	}

	public void setNumHorasModulo(Integer numHorasModulo) {
		this.numHorasModulo = numHorasModulo;
	}

	public Integer getNumHorasSemana() {
		return this.numHorasSemana;
	}

	public void setNumHorasSemana(Integer numHorasSemana) {
		this.numHorasSemana = numHorasSemana;
	}

	public String getParalelo() {
		return this.paralelo;
	}

	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}

	

}