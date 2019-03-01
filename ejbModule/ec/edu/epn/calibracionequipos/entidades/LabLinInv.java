package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the gsooindp database table.
 * 
 */
@Entity
@Table(name = "lablininv", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "LabLinInv.findAll", query = "SELECT g FROM LabLinInv g")
public class LabLinInv implements Serializable {
	private static final long serialVersionUID = 1L;

	public LabLinInv() {
	}

	@EmbeddedId
	private LabLinInvPK id;

	// bi-directional many-to-one association to Gestionsoo
	@ManyToOne
	@JoinColumn(name = "id_laboratorio", insertable = false, updatable = false)
	private Laboratorioscalibracionequipo labo;

	// bi-directional many-to-one association to Indicepotencial
	@ManyToOne
	@JoinColumn(name = "id_lineainvestigacion", insertable = false, updatable = false)
	private Lineasinvestigacion linInvs;

	public LabLinInvPK getId() {
		return id;
	}

	public void setId(LabLinInvPK id) {
		this.id = id;
	}

	public Laboratorioscalibracionequipo getLabo() {
		return labo;
	}

	public void setLabo(Laboratorioscalibracionequipo labo) {
		this.labo = labo;
	}

	public Lineasinvestigacion getLinInvs() {
		return linInvs;
	}

	public void setLinInvs(Lineasinvestigacion linInvs) {
		this.linInvs = linInvs;
	}

}