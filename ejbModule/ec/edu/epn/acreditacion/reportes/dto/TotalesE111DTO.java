package ec.edu.epn.acreditacion.reportes.dto;

import java.io.Serializable;

public class TotalesE111DTO implements Serializable {

	private static final long serialVersionUID = 3574385754496084840L;

	/** Variables **/
	private int totalxProfesor, totalxDepartamento, totalxDedicacion, totalxCategoria;

	/** Setters y Getters **/

	public int getTotalxProfesor() {
		return totalxProfesor;
	}

	public void setTotalxProfesor(int totalxProfesor) {
		this.totalxProfesor = totalxProfesor;
	}

	public int getTotalxDepartamento() {
		return totalxDepartamento;
	}

	public void setTotalxDepartamento(int totalxDepartamento) {
		this.totalxDepartamento = totalxDepartamento;
	}

	public int getTotalxDedicacion() {
		return totalxDedicacion;
	}

	public void setTotalxDedicacion(int totalxDedicacion) {
		this.totalxDedicacion = totalxDedicacion;
	}

	public int getTotalxCategoria() {
		return totalxCategoria;
	}

	public void setTotalxCategoria(int totalxCategoria) {
		this.totalxCategoria = totalxCategoria;
	}

}
