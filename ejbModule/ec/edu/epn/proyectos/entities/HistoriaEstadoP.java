package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the historia_estados database table.
 * 
 */
@Entity
@Table(name="historia_estados", catalog = "bddcorpepn", schema = "`Proyectos`")
public class HistoriaEstadoP implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_hp")
	private Integer idHp;

	//bi-directional many-to-one association to EstadoProyecto
    @ManyToOne
	@JoinColumn(name="id_estado")
	private EstadoProyecto estadoProyecto;

	//bi-directional many-to-one association to Proyecto
    @ManyToOne
	@JoinColumn(name="id_proy")
	private ProyectoP proyecto;

    public HistoriaEstadoP() {
    }

	public Integer getIdHp() {
		return this.idHp;
	}

	public void setIdHp(Integer idHp) {
		this.idHp = idHp;
	}

	public EstadoProyecto getEstadoProyecto() {
		return this.estadoProyecto;
	}

	public void setEstadoProyecto(EstadoProyecto estadoProyecto) {
		this.estadoProyecto = estadoProyecto;
	}
	
	public ProyectoP getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}
	
}