package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;

public class SignosVitales  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4709399825365231280L;
	
	private String peso;
	private String talla;
	private String imc;
	private String temperatura;
	private String tensionSistolica;
	private String tensionDiastolica;
	private String respiracion;
	private String pulso;
	
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public String getImc() {
		return imc;
	}
	public void setImc(String imc) {
		this.imc = imc;
	}
	public String getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	public String getTensionSistolica() {
		return tensionSistolica;
	}
	public void setTensionSistolica(String tensionSistolica) {
		this.tensionSistolica = tensionSistolica;
	}
	public String getTensionDiastolica() {
		return tensionDiastolica;
	}
	public void setTensionDiastolica(String tensionDiastolica) {
		this.tensionDiastolica = tensionDiastolica;
	}
	public String getRespiracion() {
		return respiracion;
	}
	public void setRespiracion(String respiracion) {
		this.respiracion = respiracion;
	}
	public String getPulso() {
		return pulso;
	}
	public void setPulso(String pulso) {
		this.pulso = pulso;
	}

}
