package ec.edu.epn.contratos.DTO;

import java.io.InputStream;

public class ArchivosCPA {

	private InputStream archivo;
	private int numeroArchivo;
	private String nombreArchivo;
	private String nombreCalificativoArchivo;

	public String getNombreCalificativoArchivo() {
		return nombreCalificativoArchivo;
	}

	public void setNombreCalificativoArchivo(String nombreCalificativoArchivo) {
		this.nombreCalificativoArchivo = nombreCalificativoArchivo;
	}

	public InputStream getArchivo() {
		return archivo;
	}

	public void setArchivo(InputStream archivo) {
		this.archivo = archivo;
	}

	public int getNumeroArchivo() {
		return numeroArchivo;
	}

	public void setNumeroArchivo(int numeroArchivo) {
		this.numeroArchivo = numeroArchivo;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

}
