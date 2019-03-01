package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the relacion_dedicacion database table.
 * 
 */
@Entity
@Table(name = "relacion_dedicacion", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class RelacionDedicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RelacionDedicacionPK id;

	private String activo;

	@ManyToOne
	@JoinColumn(name = "id_relacion", insertable = false, updatable = false)
	private RelacionActual relacionActual;

	// bi-directional many-to-one association to Indicepotencial
	@ManyToOne
	@JoinColumn(name = "id_dedicacion", insertable = false, updatable = false)
	private DedicacionContratos dedicacion;

	public RelacionActual getRelacionActual() {
		return relacionActual;
	}

	public void setRelacionActual(RelacionActual relacionActual) {
		this.relacionActual = relacionActual;
	}

	public DedicacionContratos getDedicacion() {
		return dedicacion;
	}

	public void setDedicacion(DedicacionContratos dedicacion) {
		this.dedicacion = dedicacion;
	}

	public RelacionDedicacion() {
	}

	public RelacionDedicacionPK getId() {
		return this.id;
	}

	public void setId(RelacionDedicacionPK id) {
		this.id = id;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

}