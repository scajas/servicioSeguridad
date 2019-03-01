package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tipo_rubro database table.
 * 
 */
@Entity
@Table(name = "tipo_rubro", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class TipoRubro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tiporubro")
	private Integer idTiporubro;

	@Column(name="nombre_tiporubro")
	private String nombreTiporubro;

	//bi-directional many-to-one association to Rubro
	@OneToMany(mappedBy="tipoRubro")
	private List<Rubro> rubros;

    public TipoRubro() {
    }

	public Integer getIdTiporubro() {
		return this.idTiporubro;
	}

	public void setIdTiporubro(Integer idTiporubro) {
		this.idTiporubro = idTiporubro;
	}

	public String getNombreTiporubro() {
		return this.nombreTiporubro;
	}

	public void setNombreTiporubro(String nombreTiporubro) {
		this.nombreTiporubro = nombreTiporubro;
	}

	public List<Rubro> getRubros() {
		return this.rubros;
	}

	public void setRubros(List<Rubro> rubros) {
		this.rubros = rubros;
	}
	
}