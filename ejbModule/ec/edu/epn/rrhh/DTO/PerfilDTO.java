package ec.edu.epn.rrhh.DTO;

import java.io.Serializable;

public class PerfilDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8847800830106030977L;

	private long idUsuario;
	private long idPerfil;
	private String perfil;
	private boolean seleccion;
	

	public PerfilDTO() {

	}


	/**
	 * @return the idUsuario
	 */
	public long getIdUsuario() {
		return idUsuario;
	}


	/**
	 * @return the idPerfil
	 */
	public long getIdPerfil() {
		return idPerfil;
	}


	/**
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}


	/**
	 * @return the seleccion
	 */
	public boolean isSeleccion() {
		return seleccion;
	}


	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}


	/**
	 * @param idPerfil the idPerfil to set
	 */
	public void setIdPerfil(long idPerfil) {
		this.idPerfil = idPerfil;
	}


	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}


	/**
	 * @param seleccion the seleccion to set
	 */
	public void setSeleccion(boolean seleccion) {
		this.seleccion = seleccion;
	}

	
}
