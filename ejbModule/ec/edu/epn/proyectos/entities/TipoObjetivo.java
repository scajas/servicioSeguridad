package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_objetivo database table.
 * 
 */
@Entity
@Table(name="tipo_objetivo", catalog = "bddcorpepn", schema = "`Proyectos`")
public class TipoObjetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_obj")
	private Integer idTipoObj;

	@Column(name="descrip_obj")
	private String descripObj;

	@Column(name="tipo_obj")
	private String tipoObj;

	//bi-directional many-to-one association to ObjetivoProyecto
	@OneToMany(mappedBy="tipoObjetivo")
	private List<ObjetivoProyecto> objetivoProyectos;

    public TipoObjetivo() {
    }

	public Integer getIdTipoObj() {
		return this.idTipoObj;
	}

	public void setIdTipoObj(Integer idTipoObj) {
		this.idTipoObj = idTipoObj;
	}

	public String getDescripObj() {
		return this.descripObj;
	}

	public void setDescripObj(String descripObj) {
		this.descripObj = descripObj;
	}

	public String getTipoObj() {
		return this.tipoObj;
	}

	public void setTipoObj(String tipoObj) {
		this.tipoObj = tipoObj;
	}

	public List<ObjetivoProyecto> getObjetivoProyectos() {
		return this.objetivoProyectos;
	}

	public void setObjetivoProyectos(List<ObjetivoProyecto> objetivoProyectos) {
		this.objetivoProyectos = objetivoProyectos;
	}
	
}