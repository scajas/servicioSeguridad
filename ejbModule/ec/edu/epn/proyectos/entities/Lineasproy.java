package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.catalogos.entities.LineasInvestigacion;


/**
 * The persistent class for the lineasproy database table.
 * 
 */
@Entity
@Table(name="Lineasproy", catalog = "bddcorpepn", schema = "`Proyectos`")

public class Lineasproy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_lin_proy")
	private Integer idLinProy;

	

	//bi-directional many-to-one association to Proyecto
    @ManyToOne
	@JoinColumn(name="id_proy")
	private ProyectoP proyecto;
    
    
    
    @ManyToOne
	@JoinColumn(name="id_linin")
	private LineasInvestigacion lineas;
    
    

    public Lineasproy() {
    }

	public Integer getIdLinProy() {
		return this.idLinProy;
	}

	public void setIdLinProy(Integer idLinProy) {
		this.idLinProy = idLinProy;
	}

	

	public ProyectoP getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}

	/**
	 * @return the lineas
	 */
	public LineasInvestigacion getLineas() {
		return lineas;
	}

	/**
	 * @param lineas the lineas to set
	 */
	public void setLineas(LineasInvestigacion lineas) {
		this.lineas = lineas;
	}
	
}