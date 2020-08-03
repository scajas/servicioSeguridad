package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_actividad database table.
 * 
 */
@Entity

@Table(name="tipo_actividad", catalog = "bddcorpepn", schema = "`Proyectos`")
public class TipoActividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_act")
	private Integer idTipoAct;

	@Column(name="descripcion_act")
	private String descripcionAct;

	@Column(name="nom_tipo_act")
	private String nomTipoAct;

	//bi-directional many-to-one association to ActividadProyecto
	@OneToMany(mappedBy="tipoActividad")
	private List<ActividadProyectoP> actividadProyectos;

    public TipoActividad() {
    }

	public Integer getIdTipoAct() {
		return this.idTipoAct;
	}

	public void setIdTipoAct(Integer idTipoAct) {
		this.idTipoAct = idTipoAct;
	}

	public String getDescripcionAct() {
		return this.descripcionAct;
	}

	public void setDescripcionAct(String descripcionAct) {
		this.descripcionAct = descripcionAct;
	}

	public String getNomTipoAct() {
		return this.nomTipoAct;
	}

	public void setNomTipoAct(String nomTipoAct) {
		this.nomTipoAct = nomTipoAct;
	}

	public List<ActividadProyectoP> getActividadProyectos() {
		return this.actividadProyectos;
	}

	public void setActividadProyectos(List<ActividadProyectoP> actividadProyectos) {
		this.actividadProyectos = actividadProyectos;
	}
	
}