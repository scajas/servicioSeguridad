package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the materiales_rubros_espacios database table.
 * 
 */
@Entity
@Table(name = "materiales_rubros_espacios")
public class MaterialesRubrosEspacio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_materiales")
	private Integer idMateriales;

	@Column(name = "nombre_material")
	private String nombreMaterial;

	public MaterialesRubrosEspacio() {
	}

	public Integer getIdMateriales() {
		return this.idMateriales;
	}

	public void setIdMateriales(Integer idMateriales) {
		this.idMateriales = idMateriales;
	}

	public String getNombreMaterial() {
		return this.nombreMaterial;
	}

	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}

}