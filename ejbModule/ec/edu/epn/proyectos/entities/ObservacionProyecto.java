package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the observacion_proyecto database table.
 * 
 */
@Entity
@Table(name="observacion_proyecto", catalog = "bddcorpepn", schema = "`Proyectos`")
public class ObservacionProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_observacion")
	private Integer idObservacion;

	private String estado;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	private String observacion;

	//bi-directional many-to-one association to InvestigadorObservacione
    @ManyToOne
	@JoinColumn(name="id_revisorobsr")
	private InvestigadorObservacione investigadorObservacione;

    public ObservacionProyecto() {
    }

	public Integer getIdObservacion() {
		return this.idObservacion;
	}

	public void setIdObservacion(Integer idObservacion) {
		this.idObservacion = idObservacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public InvestigadorObservacione getInvestigadorObservacione() {
		return this.investigadorObservacione;
	}

	public void setInvestigadorObservacione(InvestigadorObservacione investigadorObservacione) {
		this.investigadorObservacione = investigadorObservacione;
	}
	
}