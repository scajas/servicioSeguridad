package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_accion database table.
 * 
 */
@Entity

@Table(name = "tipo_accion", catalog = "bddcorpepn", schema = "\"Rrhh\"")

@NamedQuery(name="TipoAccion.findAll", query="SELECT t FROM TipoAccion t")
public class TipoAccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tpa")
	private Integer idTpa;

	@Column(name="descripcion_accion")
	private String descripcionAccion;

	@Column(name="nombre_accion")
	private String nombreAccion;
	
	@Column(name="es_filtrable")
	private Boolean esFiltrable;
	
	// bi-directional many-to-one association to SubtipoAccion
	@OneToMany(mappedBy="tipoAccion", fetch=FetchType.EAGER)
	private List<SubtipoAccion> subtipoAccions;

	public TipoAccion() {
	}

	public Integer getIdTpa() {
		return this.idTpa;
	}

	public void setIdTpa(Integer idTpa) {
		this.idTpa = idTpa;
	}

	public String getDescripcionAccion() {
		return this.descripcionAccion;
	}

	public void setDescripcionAccion(String descripcionAccion) {
		this.descripcionAccion = descripcionAccion;
	}

	public String getNombreAccion() {
		return this.nombreAccion;
	}

	public void setNombreAccion(String nombreAccion) {
		this.nombreAccion = nombreAccion;
	}

	public List<SubtipoAccion> getSubtipoAccions() {
		return this.subtipoAccions;
	}

	public void setSubtipoAccions(List<SubtipoAccion> subtipoAccions) {
		this.subtipoAccions = subtipoAccions;
	}

	public SubtipoAccion addSubtipoAccion(SubtipoAccion subtipoAccion) {
		getSubtipoAccions().add(subtipoAccion);
		subtipoAccion.setTipoAccion(this);

		return subtipoAccion;
	}

	public SubtipoAccion removeSubtipoAccion(SubtipoAccion subtipoAccion) {
		getSubtipoAccions().remove(subtipoAccion);
		subtipoAccion.setTipoAccion(null);
		return subtipoAccion;
	}

	public Boolean isEsFiltrable() {
		return esFiltrable;
	}

	public void setEsFiltrable(Boolean esFiltrable) {
		this.esFiltrable = esFiltrable;
	}
	
	

}