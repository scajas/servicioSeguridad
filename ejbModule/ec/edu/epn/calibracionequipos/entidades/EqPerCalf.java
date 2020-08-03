package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the gsooindp database table.
 * 
 */
@Entity
@Table(name = "eqpercalf", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "EqPerCalf.findAll", query = "SELECT g FROM EqPerCalf g")
public class EqPerCalf implements Serializable {
	private static final long serialVersionUID = 1L;

	public EqPerCalf() {
	}

	@EmbeddedId
	private EqPerCalfPK id;

	@ManyToOne
	@JoinColumn(name = "id_equipo", insertable = false, updatable = false)
	private Equiposcalibracionequipo equipo;

	// bi-directional many-to-one association to Indicepotencial
	@ManyToOne
	@JoinColumn(name = "id_personalcalificado", insertable = false, updatable = false)
	private Personalcalificado personal;

	public Equiposcalibracionequipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equiposcalibracionequipo equipo) {
		this.equipo = equipo;
	}

	public Personalcalificado getPersonal() {
		return personal;
	}

	public void setPersonal(Personalcalificado personal) {
		this.personal = personal;
	}

	public EqPerCalfPK getId() {
		return id;
	}

	public void setId(EqPerCalfPK id) {
		this.id = id;
	}

}