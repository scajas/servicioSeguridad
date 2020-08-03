package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the investigador_observaciones database table.
 * 
 */
@Entity
@Table(name="investigador_observaciones", catalog = "bddcorpepn", schema = "`Proyectos`")
public class InvestigadorObservacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_revisorobsr")
	private Integer idRevisorobsr;

	@Column(name="fecha_asignacion")
	private String fechaAsignacion;

    @Temporal( TemporalType.DATE)
	private Date fechamaxrev;

	//bi-directional many-to-one association to Investigador
    @ManyToOne
	@JoinColumn(name="id_inv")
	private Investigador investigador;

	//bi-directional many-to-one association to Proyecto
    @ManyToOne
	@JoinColumn(name="id_proy")
	private ProyectoP proyecto;

	//bi-directional many-to-one association to ObservacionProyecto
	@OneToMany(mappedBy="investigadorObservacione")
	private List<ObservacionProyecto> observacionProyectos;

    public InvestigadorObservacione() {
    }

	public Integer getIdRevisorobsr() {
		return this.idRevisorobsr;
	}

	public void setIdRevisorobsr(Integer idRevisorobsr) {
		this.idRevisorobsr = idRevisorobsr;
	}

	public String getFechaAsignacion() {
		return this.fechaAsignacion;
	}

	public void setFechaAsignacion(String fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Date getFechamaxrev() {
		return this.fechamaxrev;
	}

	public void setFechamaxrev(Date fechamaxrev) {
		this.fechamaxrev = fechamaxrev;
	}

	public Investigador getInvestigador() {
		return this.investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}
	
	public ProyectoP getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}
	
	public List<ObservacionProyecto> getObservacionProyectos() {
		return this.observacionProyectos;
	}

	public void setObservacionProyectos(List<ObservacionProyecto> observacionProyectos) {
		this.observacionProyectos = observacionProyectos;
	}
	
}