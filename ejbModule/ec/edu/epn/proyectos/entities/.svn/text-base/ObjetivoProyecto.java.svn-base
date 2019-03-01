package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


/**
 * The persistent class for the objetivo_proyecto database table.
 * 
 */
@Entity
@Table(name="objetivo_proyecto", catalog = "bddcorpepn", schema = "`Proyectos`")
public class ObjetivoProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_objproy")
	private Integer idObjproy;

	private String detalle;
	
	private Double avance;
	
	//bi-directional many-to-one association to Proyecto
    @ManyToOne
	@JoinColumn(name="id_proy")
	private ProyectoP proyecto;

	//bi-directional many-to-one association to TipoObjetivo
    @ManyToOne
	@JoinColumn(name="id_tipo_obj")
	private TipoObjetivo tipoObjetivo;
    
    
    
    @OneToMany(cascade=CascadeType.ALL,mappedBy="objetivo",fetch = FetchType.EAGER)
	private Set<Objetivoavance> objetivos;

    public ObjetivoProyecto() {
    }

	public Integer getIdObjproy() {
		return this.idObjproy;
	}

	public void setIdObjproy(Integer idObjproy) {
		this.idObjproy = idObjproy;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public ProyectoP getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}
	
	public TipoObjetivo getTipoObjetivo() {
		return this.tipoObjetivo;
	}

	public void setTipoObjetivo(TipoObjetivo tipoObjetivo) {
		this.tipoObjetivo = tipoObjetivo;
	}

	public Double getAvance() {
		return avance;
	}

	public void setAvance(Double avance) {
		this.avance = avance;
	}

	public Set<Objetivoavance> getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(Set<Objetivoavance> objetivos) {
		this.objetivos = objetivos;
	}
	
	

	
	
}