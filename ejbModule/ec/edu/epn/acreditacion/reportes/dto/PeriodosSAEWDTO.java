package ec.edu.epn.acreditacion.reportes.dto;

import java.io.Serializable;

public class PeriodosSAEWDTO implements Serializable {

	private static final long serialVersionUID = 3574385754496084840L;

	/** Variables **/
	private String periodo, anioMat, semMat, per;

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getAnioMat() {
		return anioMat;
	}

	public void setAnioMat(String anioMat) {
		this.anioMat = anioMat;
	}

	public String getSemMat() {
		return semMat;
	}

	public void setSemMat(String semMat) {
		this.semMat = semMat;
	}

	public String getPer() {
		return per;
	}

	public void setPer(String per) {
		this.per = per;
	}
}
