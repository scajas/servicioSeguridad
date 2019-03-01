package ec.edu.epn.acreditacion.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the subcriterio_detalle database table.
 * 
 */
@Entity
@Table(name="subcriterio_detalle", catalog="`bddcorpepn`", schema="`Acreditacion`")
@NamedQuery(name="SubcriterioDetalle.findAll", query="SELECT s FROM SubcriterioDetalle s")
public class SubcriterioDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"Acreditacion\".sec_subcriterio_detalle")
	@SequenceGenerator(name = "\"Acreditacion\".sec_subcriterio_detalle", sequenceName = "\"Acreditacion\".sec_subcriterio_detalle", allocationSize = 1)
	@Column(name="id_subcr_detalle")
	private Integer idSubcrDetalle;

	@Column(name="calificacion_detalle")
	private double calificacionDetalle;

	@Column(name="id_subcr")
	private Integer idSubcr;

	//bi-directional many-to-one association to CriterioDetalle
	@ManyToOne
	@JoinColumn(name="id_criterio_detalle")
	private CriterioDetalle criterioDetalle;

	public SubcriterioDetalle() {
	}

	public Integer getIdSubcrDetalle() {
		return this.idSubcrDetalle;
	}

	public void setIdSubcrDetalle(Integer idSubcrDetalle) {
		this.idSubcrDetalle = idSubcrDetalle;
	}

	public double getCalificacionDetalle() {
		return this.calificacionDetalle;
	}

	public void setCalificacionDetalle(double calificacionDetalle) {
		this.calificacionDetalle = calificacionDetalle;
	}

	public Integer getIdSubcr() {
		return this.idSubcr;
	}

	public void setIdSubcr(Integer idSubcr) {
		this.idSubcr = idSubcr;
	}

	public CriterioDetalle getCriterioDetalle() {
		return this.criterioDetalle;
	}

	public void setCriterioDetalle(CriterioDetalle criterioDetalle) {
		this.criterioDetalle = criterioDetalle;
	}

}