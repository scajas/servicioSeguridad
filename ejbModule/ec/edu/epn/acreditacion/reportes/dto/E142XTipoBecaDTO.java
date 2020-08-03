package ec.edu.epn.acreditacion.reportes.dto;

import java.io.Serializable;

public class E142XTipoBecaDTO implements Serializable {

	private static final long serialVersionUID = 3574385754496084840L;

	/** Variables **/
	private String beca, tipoBeca, porcentajeValor, solicitudes, noCumpleReglamento, coNCOntrato, masculino, femenino,
			renuncia, anulado, faltan, sinMatricula, valorSol, valorCont;

	/** Setter y Getters **/

	public String getBeca() {
		return beca;
	}

	public void setBeca(String beca) {
		this.beca = beca;
	}

	public String getTipoBeca() {
		return tipoBeca;
	}

	public void setTipoBeca(String tipoBeca) {
		this.tipoBeca = tipoBeca;
	}

	public String getPorcentajeValor() {
		return porcentajeValor;
	}

	public void setPorcentajeValor(String porcentajeValor) {
		this.porcentajeValor = porcentajeValor;
	}

	public String getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(String solicitudes) {
		this.solicitudes = solicitudes;
	}

	public String getNoCumpleReglamento() {
		return noCumpleReglamento;
	}

	public void setNoCumpleReglamento(String noCumpleReglamento) {
		this.noCumpleReglamento = noCumpleReglamento;
	}

	public String getCoNCOntrato() {
		return coNCOntrato;
	}

	public void setCoNCOntrato(String coNCOntrato) {
		this.coNCOntrato = coNCOntrato;
	}

	public String getMasculino() {
		return masculino;
	}

	public void setMasculino(String masculino) {
		this.masculino = masculino;
	}

	public String getFemenino() {
		return femenino;
	}

	public void setFemenino(String femenino) {
		this.femenino = femenino;
	}

	public String getRenuncia() {
		return renuncia;
	}

	public void setRenuncia(String renuncia) {
		this.renuncia = renuncia;
	}

	public String getAnulado() {
		return anulado;
	}

	public void setAnulado(String anulado) {
		this.anulado = anulado;
	}

	public String getFaltan() {
		return faltan;
	}

	public void setFaltan(String faltan) {
		this.faltan = faltan;
	}

	public String getSinMatricula() {
		return sinMatricula;
	}

	public void setSinMatricula(String sinMatricula) {
		this.sinMatricula = sinMatricula;
	}

	public String getValorSol() {
		return valorSol;
	}

	public void setValorSol(String valorSol) {
		this.valorSol = valorSol;
	}

	public String getValorCont() {
		return valorCont;
	}

	public void setValorCont(String valorCont) {
		this.valorCont = valorCont;
	}

}
