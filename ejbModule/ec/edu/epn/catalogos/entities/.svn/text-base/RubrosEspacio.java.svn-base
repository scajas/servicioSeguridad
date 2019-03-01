package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Array;

/**
 * The persistent class for the rubros_espacios database table.
 * 
 */
@Entity
@Table(name = "rubros_espacios", catalog = "bddcorpepn", schema = "`Catalogos`")
public class RubrosEspacio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_rubro")
	private Integer idRubro;

	@Column(name = "descripcion_rubro")
	private String descripcionRubro;

	@Column(name = "nombre_rubro")
	private String nombreRubro;

	
	@ManyToOne
	@JoinColumn(name = "id_tiporubros_espacios")
	private TipoRubrosEspacio tipoRubroEspacio;
	

	
	public TipoRubrosEspacio getTipoRubroEspacio() {
		return tipoRubroEspacio;
	}

	public void setTipoRubroEspacio(TipoRubrosEspacio tipoRubroEspacio) {
		this.tipoRubroEspacio = tipoRubroEspacio;
	}

	public RubrosEspacio() {
	}

	public Integer getIdRubro() {
		return this.idRubro;
	}

	public void setIdRubro(Integer idRubro) {
		this.idRubro = idRubro;
	}

	public String getDescripcionRubro() {
		return this.descripcionRubro;
	}

	public void setDescripcionRubro(String descripcionRubro) {
		this.descripcionRubro = descripcionRubro;
	}

	public String getNombreRubro() {
		return this.nombreRubro;
	}

	public void setNombreRubro(String nombreRubro) {
		this.nombreRubro = nombreRubro;
	}

}