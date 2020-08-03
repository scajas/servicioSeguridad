package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the gsooindp database table.
 * 
 */
@Entity
@Table(name = "tipolabo_laboratorios", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "TipoLaboLaboratorios.findAll", query = "SELECT g FROM TipoLaboLaboratorios g")
public class TipoLaboLaboratorios implements Serializable {
	private static final long serialVersionUID = 1L;

	public TipoLaboLaboratorios() {
	}

	@EmbeddedId
	private TipoLaboLaboratoriosPK id;

	// bi-directional many-to-one association to Gestionsoo
	@ManyToOne
	@JoinColumn(name = "id_laboratorio", insertable = false, updatable = false)
	private Laboratorioscalibracionequipo labo;

	// bi-directional many-to-one association to Indicepotencial
	@ManyToOne
	@JoinColumn(name = "id_tipolaboratotio", insertable = false, updatable = false)
	private Tiposlaboratorio tipoLabo;

	public TipoLaboLaboratoriosPK getId() {
		return id;
	}

	public void setId(TipoLaboLaboratoriosPK id) {
		this.id = id;
	}

	public Laboratorioscalibracionequipo getLabo() {
		return labo;
	}

	public void setLabo(Laboratorioscalibracionequipo labo) {
		this.labo = labo;
	}

	public Tiposlaboratorio getTipoLabo() {
		return tipoLabo;
	}

	public void setTipoLabo(Tiposlaboratorio tipoLabo) {
		this.tipoLabo = tipoLabo;
	}

}