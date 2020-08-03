package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the indicepotencial database table.
 * 
 */
@Entity
@Table(name="indicepotencial", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Indicepotencial.findAll", query="SELECT i FROM Indicepotencial i")
public class Indicepotencial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_indicepotencial")
	private Integer idIndicepotencial;

	@Column(name="nombre_indicepotencial")
	private String nombreIndicepotencial;

	//bi-directional many-to-one association to Gsooindp
	@OneToMany(mappedBy="indicepotencial")
	private List<Gsooindp> gsooindps;

	//bi-directional many-to-many association to Medidacontrol
	@ManyToMany(mappedBy="indicepotencials")
	private List<Medidacontrol> medidacontrols;

	public Indicepotencial() {
	}

	public Integer getIdIndicepotencial() {
		return this.idIndicepotencial;
	}

	public void setIdIndicepotencial(Integer idIndicepotencial) {
		this.idIndicepotencial = idIndicepotencial;
	}

	public String getNombreIndicepotencial() {
		return this.nombreIndicepotencial;
	}

	public void setNombreIndicepotencial(String nombreIndicepotencial) {
		this.nombreIndicepotencial = nombreIndicepotencial;
	}

	public List<Gsooindp> getGsooindps() {
		return this.gsooindps;
	}

	public void setGsooindps(List<Gsooindp> gsooindps) {
		this.gsooindps = gsooindps;
	}

	public Gsooindp addGsooindp(Gsooindp gsooindp) {
		getGsooindps().add(gsooindp);
		gsooindp.setIndicepotencial(this);

		return gsooindp;
	}

	public Gsooindp removeGsooindp(Gsooindp gsooindp) {
		getGsooindps().remove(gsooindp);
		gsooindp.setIndicepotencial(null);

		return gsooindp;
	}

	public List<Medidacontrol> getMedidacontrols() {
		return this.medidacontrols;
	}

	public void setMedidacontrols(List<Medidacontrol> medidacontrols) {
		this.medidacontrols = medidacontrols;
	}

}