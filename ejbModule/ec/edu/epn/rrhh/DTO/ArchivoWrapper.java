package ec.edu.epn.rrhh.DTO;

import java.io.Serializable;

public class ArchivoWrapper implements Serializable{

	private static final long serialVersionUID = 4002307000430592520L;
	
	private byte[] archivo;
	private String nombre;
	private String contentType;
	private String carpeta;
	
	
	
	public byte[] getArchivo() {
		return archivo;
	}
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getCarpeta() {
		return carpeta;
	}
	public void setCarpeta(String carpeta) {
		this.carpeta = carpeta;
	}
	
	
	
}