package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the tipo_rubros_espacios database table.
 * 
 */
@Entity
@Table(name = "tipo_rubros_espacios", catalog = "bddcorpepn", schema = "`Catalogos`")
public class TipoRubrosEspacio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tiporubros_espacios")
	private Integer idTiporubrosEspacios;

	@Column(name = "nombretiportubros_espacios")
	private String nombretiportubrosEspacios;

	@OneToMany(mappedBy = "tipoRubroEspacio")
	private List<RubrosEspacio> rubroEspacio;

	public List<RubrosEspacio> getRubroEspacio() {
		return rubroEspacio;
	}

	public void setRubroEspacio(List<RubrosEspacio> rubroEspacio) {
		this.rubroEspacio = rubroEspacio;
	}

	public TipoRubrosEspacio() {
	}

	public Integer getIdTiporubrosEspacios() {
		return this.idTiporubrosEspacios;
	}

	public void setIdTiporubrosEspacios(Integer idTiporubrosEspacios) {
		this.idTiporubrosEspacios = idTiporubrosEspacios;
	}

	public String getNombretiportubrosEspacios() {
		return this.nombretiportubrosEspacios;
	}

	public void setNombretiportubrosEspacios(String nombretiportubrosEspacios) {
		this.nombretiportubrosEspacios = nombretiportubrosEspacios;
	}

}