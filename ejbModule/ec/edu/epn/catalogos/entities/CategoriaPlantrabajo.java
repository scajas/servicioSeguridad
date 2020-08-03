package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the categoria_plantrabajo database table.
 * 
 */
@Entity
@Table(name = "categoria_plantrabajo", catalog = "bddcorpepn", schema = "`Catalogos`")
public class CategoriaPlantrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_categoria_plantrabajo")
	private Integer idCategoriaPlantrabajo;

	@Column(name = "activo_categoria")
	private String activoCategoria;

	@Column(name = "nombre_categoria")
	private String nombreCategoria;
	
	
	@Column(name = "siglas_categoria")
	private String siglasCategoria;
	

	public String getSiglasCategoria() {
		return siglasCategoria;
	}

	public void setSiglasCategoria(String siglasCategoria) {
		this.siglasCategoria = siglasCategoria;
	}

	public CategoriaPlantrabajo() {
	}

	public Integer getIdCategoriaPlantrabajo() {
		return this.idCategoriaPlantrabajo;
	}

	public void setIdCategoriaPlantrabajo(Integer idCategoriaPlantrabajo) {
		this.idCategoriaPlantrabajo = idCategoriaPlantrabajo;
	}

	public String getActivoCategoria() {
		return this.activoCategoria;
	}

	public void setActivoCategoria(String activoCategoria) {
		this.activoCategoria = activoCategoria;
	}

	public String getNombreCategoria() {
		return this.nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

}