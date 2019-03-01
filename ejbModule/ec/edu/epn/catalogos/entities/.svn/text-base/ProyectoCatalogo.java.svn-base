package ec.edu.epn.catalogos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the materias database table.
 * 
 */
@Entity
@Table(name = "proyecto", catalog = "`bddcorpepn`", schema = "`Catalogos`")
public class ProyectoCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_proyecto")
	private Integer id_proyecto;

	@Column(name = "cod_proyecto")
	private String codProyecto;

	@Column(name = "nombre_proyecto")
	private String nombreProyecto;

	/**
	 * @return the id_proyecto
	 */
	public Integer getId_proyecto() {
		return id_proyecto;
	}

	/**
	 * @return the codProyecto
	 */
	public String getCodProyecto() {
		return codProyecto;
	}

	/**
	 * @return the nombreProyecto
	 */
	public String getNombreProyecto() {
		return nombreProyecto;
	}

	/**
	 * @param id_proyecto the id_proyecto to set
	 */
	public void setId_proyecto(Integer id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	/**
	 * @param codProyecto the codProyecto to set
	 */
	public void setCodProyecto(String codProyecto) {
		this.codProyecto = codProyecto;
	}

	/**
	 * @param nombreProyecto the nombreProyecto to set
	 */
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	
}