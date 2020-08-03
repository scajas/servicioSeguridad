package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the registro_estados database table.
 * 
 */
@Entity
@Table(name="registro_estados", catalog = "`bddcorpepn`", schema = "`Convenios`")

public class RegistroEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_regest")
	private Integer idRegest;

    @Temporal( TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Convenio
    @ManyToOne
	@JoinColumn(name="id_conv")
	private Convenio convenio;

	//bi-directional many-to-one association to EstadoC
    @ManyToOne
	@JoinColumn(name="id_estadoc")
	private EstadoC estadoC;

    public RegistroEstado() {
    }

	public Integer getIdRegest() {
		return this.idRegest;
	}

	public void setIdRegest(Integer idRegest) {
		this.idRegest = idRegest;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Convenio getConvenio() {
		return this.convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	
	public EstadoC getEstadoC() {
		return this.estadoC;
	}

	public void setEstadoC(EstadoC estadoC) {
		this.estadoC = estadoC;
	}
	
}