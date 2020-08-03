package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gsooindp database table.
 * 
 */
@Entity
@Table(name="gsooindp", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Gsooindp.findAll", query="SELECT g FROM Gsooindp g")
public class Gsooindp implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GsooindpPK id;

	//bi-directional many-to-one association to Gestionsoo
	@ManyToOne
	@JoinColumn(name="id_proceso", insertable=false, updatable=false)
	private Gestionsoo gestionsoo;

	//bi-directional many-to-one association to Indicepotencial
	@ManyToOne
	@JoinColumn(name="id_indicepotencial", insertable=false, updatable=false)
	private Indicepotencial indicepotencial;

	public Gsooindp() {
	}

	public GsooindpPK getId() {
		return this.id;
	}

	public void setId(GsooindpPK id) {
		this.id = id;
	}

	public Gestionsoo getGestionsoo() {
		return this.gestionsoo;
	}

	public void setGestionsoo(Gestionsoo gestionsoo) {
		this.gestionsoo = gestionsoo;
	}

	public Indicepotencial getIndicepotencial() {
		return this.indicepotencial;
	}

	public void setIndicepotencial(Indicepotencial indicepotencial) {
		this.indicepotencial = indicepotencial;
	}

}