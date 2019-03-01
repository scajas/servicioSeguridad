package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the gsooindp database table.
 * 
 */
@Entity
@Table(name = "percalact", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "PerCalAct.findAll", query = "SELECT g FROM PerCalAct g")
public class PerCalAct implements Serializable {
	private static final long serialVersionUID = 1L;

	public PerCalAct() {
	}

	@EmbeddedId
	private PerCalActPK id;

	// bi-directional many-to-one association to Gestionsoo
	@ManyToOne
	@JoinColumn(name = "id_personalcalificado", insertable = false, updatable = false)
	private Personalcalificado personal;

	// bi-directional many-to-one association to Indicepotencial
	@ManyToOne
	@JoinColumn(name = "id_actividadecalif", insertable = false, updatable = false)
	private Actividadespersonalcalificado actividades;

	public PerCalActPK getId() {
		return id;
	}

	public void setId(PerCalActPK id) {
		this.id = id;
	}

	public Personalcalificado getPersonal() {
		return personal;
	}

	public void setPersonal(Personalcalificado personal) {
		this.personal = personal;
	}

	public Actividadespersonalcalificado getActividades() {
		return actividades;
	}

	public void setActividades(Actividadespersonalcalificado actividades) {
		this.actividades = actividades;
	}

}